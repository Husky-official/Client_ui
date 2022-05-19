package src.pages;

import src.constants.Colors;

import javax.swing.*;
import java.awt.*;

public class Archives extends JFrame {

    Color titleColor = new Colors().ArchivesHeading;
    Color lightblue = new Colors().lightBlue;
    public Font setCustomFontSize(int size){
        Font font =  new Colors().SidebarFont;
        font = new Font("Nunito", Font.PLAIN,size);
        return font;

    }

public Archives(){
    this.setSize(1000, 600);
    this.setLocationRelativeTo((Component)null);
    this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    this.setLayout(null);
    this.setVisible(true);


    JPanel titlebar = new JPanel();
    titlebar.setBounds(270,60,500,70);
    JLabel heading = new JLabel("Husky's Archives",JLabel.CENTER);
    heading.setForeground(titleColor);
    heading.setFont(setCustomFontSize(19));
    titlebar.add(heading);
    this.add(titlebar);




    JPanel tableTitle = new JPanel();
    tableTitle.setBounds(250,120,950,50);
    tableTitle.setBackground(lightblue);
    this.add(tableTitle);



}


public static void main(String args[]){
    new Archives();
}


}
