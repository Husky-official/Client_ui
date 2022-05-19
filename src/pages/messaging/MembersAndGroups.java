package src.pages.messaging;

import src.components.sidebar.MenuItem;
import src.pages.dashboard.DashboardPage;
import src.pages.profile.ProfilePage;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.Objects;

public class MembersAndGroups extends JPanel {
    public Color getBgColor() {
        return bgColor;
    }

    public void setBgColor(Color bgColor) {
        this.bgColor = bgColor;
    }

    private Color bgColor = Color.WHITE;
    Color sidebarColor = new Color(24, 28, 46);

    public MembersAndGroups() throws IOException, FontFormatException {
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


//
//        JPanel icon = new JPanel();
//        ImageIcon dashIconImage = new ImageIcon(Objects.requireNonNull(getClass().getResource("/src/img/recent.png")));
//        JLabel dashIcon = new JLabel(dashIconImage);
//        sidebar.add(dashIcon);

        JPanel dashboardP = new src.components.sidebar.MenuItem(0,100,380,65, "Dashboard");
        sidebar.add(dashboardP);
        JPanel settings = new src.components.sidebar.MenuItem(0,160,380,55, "Settings");
        sidebar.add(settings);
        JPanel module = new src.components.sidebar.MenuItem(0,220,380,55, "NewModule");
        sidebar.add(module);
        JPanel messaging = new src.components.sidebar.MenuItem(0,280,380,55,"Messaging");
        sidebar.add(messaging);

        JPanel  invoice = new src.components.sidebar.MenuItem(0,340,380,55,"Invoice");
        sidebar.add(invoice);

        JPanel posts = new src.components.sidebar.MenuItem(0,400,380,55,"Posts");
        sidebar.add(posts);

        JPanel interviewing = new MenuItem(0,460,380,55,"Interviewing");
        sidebar.add(interviewing);

        this.add(sidebar);


    }

    private void setLocationRelativeTo(Object o) {
    }

    private void setDefaultCloseOperation(int exitOnClose) {
    }

    private void setExtendedState(int maximizedBoth) {
    }

    public static void main(String[] args ) throws IOException, FontFormatException {
        new MembersAndGroups();
    }
}

