package src.pages.profile;


import src.pages.dashboard.Dashboard;
import src.pages.layout.SideBar;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class ProfilePage extends JFrame {
    private JPanel contentPanel;
    private JPanel bodyPanel;

    public ProfilePage() {

        this.setTitle("Profile | Hiric");
        this.setSize(1000, 600);
        this.initUI();
        this.setLocationRelativeTo((Component)null);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setIconImage(new ImageIcon(Objects.requireNonNull(getClass().getResource("/src/img/logo.png"))).getImage());
    }

    public void initUI(){
        contentPanel = new JPanel(new BorderLayout());
        bodyPanel = new JPanel(new GridBagLayout());

        bodyPanel.setBackground(Color.decode("#eaf5f9"));
        bodyPanel.add(new Profile());

        contentPanel.add(new SideBar(), BorderLayout.WEST);
        contentPanel.add(bodyPanel, BorderLayout.CENTER);

        this.add(contentPanel);
    }

    public static void main(String[] args) {
        new ProfilePage();
    }
}
