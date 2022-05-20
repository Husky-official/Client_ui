package src.pages.messaging;

import src.pages.dashboard.Dashboard;
import src.pages.layout.SideBar;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class MembersAndGroups extends JFrame {
    private final Color textColor = Color.decode("#283A6D");
    private final Color bgColor = Color.decode("#F2F6FF");
    private JPanel contentPanel;
    private JPanel bodyPanel;

    JButton loginButton;

    public MembersAndGroups() {
        this.setTitle("Groups | Hiric");
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
        bodyPanel.add(new JLabel("Group Messages"));
        loginButton = new JButton("Create Group");
        contentPanel.add(new SideBar(), BorderLayout.WEST);
        contentPanel.add(bodyPanel, BorderLayout.CENTER);
        contentPanel.add(new Groups(), BorderLayout.EAST);

        this.add(contentPanel);
    }

    public static void main(String[] args) {
        new MembersAndGroups();
    }
}
