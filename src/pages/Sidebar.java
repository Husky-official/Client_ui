package src.pages;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;



public class Sidebar extends JFrame {
    public Color getBgColor() {
        return bgColor;
    }

    public void setBgColor(Color bgColor) {
        this.bgColor = bgColor;
    }

    private Color bgColor = Color.WHITE;
    Color sidebarColor = new Color(24, 28, 46);
    Font f1 = new Font("Nunito", Font.PLAIN,18);
    public Font setCustomFontSize(int size){
        f1= new Font("Nunito", Font.PLAIN,size);
        return f1;
    }

    public Sidebar() throws IOException, FontFormatException {
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        this.setVisible(true);
        this.setLayout(null);
        this.setFont(f1);

        JPanel sidebar = new JPanel();
        sidebar.setBounds(0,0,280,1000);
        sidebar.setBackground(sidebarColor);


        JLabel logo = new JLabel("HIRIC",JLabel.CENTER);
        logo.setBounds(0,18,280,70);
        logo.setForeground(Color.white);
        logo.setFont(f1);
        sidebar.add(logo);


        JPanel dashboardP = new JPanel();
        dashboardP.setBounds(0,100,380,60);
        JLabel dashboard = new JLabel("Dashboard",JLabel.CENTER);
        dashboard.setBounds(0,0,280,60);
        dashboard.setForeground(Color.WHITE);
        dashboard.setFont(setCustomFontSize(16));
        dashboardP.setBackground(null);
        dashboardP.setLayout(null);
        dashboardP.add(dashboard);
        sidebar.add(dashboardP);


//        Event listener
        dashboard.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                dashboardP.setBackground(Color.BLUE);
            }
        });

        JLabel settings = new JLabel("Settings");
        settings.setBounds(0,160,200,60);
        settings.setForeground(Color.white);
        settings.setFont(setCustomFontSize(16));
        sidebar.add(settings);

        JLabel hiring= new JLabel("Hiring");
        hiring.setBounds(40,220,200,60);
        hiring.setForeground(Color.white);
        hiring.setFont(setCustomFontSize(16));

        JLabel module= new JLabel("NewModule");
        module.setBounds(40,280,200,60);
        module.setForeground(Color.white);
        module.setFont(setCustomFontSize(16));


        JLabel messaging= new JLabel("messaging");
        messaging.setBounds(40,340,200,60);
        messaging.setForeground(Color.white);
        messaging.setFont(setCustomFontSize(16));


        JLabel invoice= new JLabel("Invoice");
        invoice.setBounds(40,300,200,50);
        invoice.setForeground(Color.white);
        invoice.setFont(setCustomFontSize(16));


        JLabel posts= new JLabel("Posts");
        posts.setBounds(40,360,200,50);
        posts.setForeground(Color.white);
        posts.setFont(setCustomFontSize(16));






        sidebar.add(hiring);
        sidebar.add(module);
        sidebar.add(messaging);
        sidebar.add(invoice);
        sidebar.add(posts);
        this.add(sidebar);


    }

    public static  void main(String args[]) throws IOException, FontFormatException {
        new Sidebar();
    }
}
