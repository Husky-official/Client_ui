package src.pages;

import src.components.sidebar.MenuItem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.Objects;


public class Sidebar extends JFrame {
    public Color getBgColor() {
        return bgColor;
    }

    public void setBgColor(Color bgColor) {
        this.bgColor = bgColor;
    }

    private Color bgColor = Color.WHITE;
    Color sidebarColor = new Color(24, 28, 46);



    public Sidebar() throws IOException, FontFormatException {
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        this.setVisible(true);
        this.setLayout(null);

        JPanel sidebar = new JPanel();
        sidebar.setBounds(0,0,280,1000);
        sidebar.setBackground(sidebarColor);


        JLabel logo = new JLabel("HIRIC",JLabel.CENTER);
        logo.setBounds(0,18,280,70);
        logo.setForeground(Color.white);
        sidebar.add(logo);



        JPanel dashboardP = new MenuItem(0,100,380,65, "Dashboard");
        sidebar.add(dashboardP);
        JPanel settings = new MenuItem(0,160,380,55, "Settings");
        sidebar.add(settings);
        JPanel module = new MenuItem(0,220,380,55, "NewModule");
        sidebar.add(module);
    JPanel messaging = new MenuItem(0,280,380,55,"Messaging");
    sidebar.add(messaging);

JPanel  invoice = new MenuItem(0,340,380,55,"Invoice");
sidebar.add(invoice);

JPanel posts = new MenuItem(0,400,380,55,"Posts");
sidebar.add(posts);
JPanel application = new MenuItem(0,400,380,55,"Application");
        sidebar.add(application);

        JPanel interviewing = new MenuItem(0,460,380,55,"Interviewing");
        sidebar.add(interviewing);

        this.add(sidebar);


    }

    public static  void main(String args[]) throws IOException, FontFormatException {
        new Sidebar();
    }
}
