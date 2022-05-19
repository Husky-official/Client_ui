package src.pages;

import java.awt.*;
import java.awt.event.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class NavBar extends JLayeredPane {

    public NavBar() throws IOException {
        this.setOpaque(true);
        this.setBounds(100, 0, 900, 50);
        this.setBackground(new Color(247, 247, 254));
        Font textFont = new Font(Font.SANS_SERIF, Font.PLAIN, 17);
        this.setLayout(null);

        JPanel searchPane = new JPanel();
        searchPane.isCursorSet();
        searchPane.setBounds(130, 10, 200, 30);
        searchPane.setBackground(new Color(237,237,247));


        ImageIcon imageIcon = new ImageIcon("src/img/search.svg");
        JLabel searchIcon = new JLabel(imageIcon);
        searchIcon.setBounds(5,10,10,10);
        searchIcon.setOpaque(true);

        JLabel search = new JLabel("Search...");
        search.setFont(textFont);
        search.setForeground(Color.gray);
        search.setBounds(50, 10, 100, 15);
        
        searchPane.add(search);
        searchPane.add(searchIcon);
        this.add(searchPane);
//        this.add(searchIcon);
    }
    public static void main(String[] args) throws IOException {
        new NavBar();
    }



}
