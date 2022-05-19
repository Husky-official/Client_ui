package src.components.sidebar;

import src.constants.Colors;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.util.Objects;

public class MenuItem extends JPanel {



    public boolean isActive = false;
    Color onHover = new Colors().onHover;
    public Font setCustomFontSize(int size){
        Font font =  new Colors().SidebarFont;
        font = new Font("Nunito", Font.PLAIN,size);
        return font;

    }

    public MenuItem(int x, int y, int width, int height, String content) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.content = content;
//        this.icon = icon;
        setBounds(x,y,width,height);
        setBackground(null);
        setLayout(null);
        initItem();



        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                isActive = true;
                if(isActive){
                setBackground(onHover);
            }
                else{
                setBackground(null);}
            }
        });

        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseExited(MouseEvent e) {
                setBackground(null);
                isActive = false;


            }
        });
    }

    public void initItem(){

        JLabel label = new JLabel(content, JLabel.CENTER);
        label.setBounds(0,0 ,280,60);
        label.setForeground(Color.WHITE);
        label.setFont(setCustomFontSize(18));

        add(label);
    }



    public int gety() {
        return y;
    }

    public void sety(int y) {
        this.y = y;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
    private int width;
    private int height;
    private int x;
    private int y;
    private String content;
    private Icon icon;

    public Icon getIcon() {
        return icon;
    }

    public void setIcon(Icon icon) {
        this.icon = icon;
    }
}
