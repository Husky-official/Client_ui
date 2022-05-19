package src.pages;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.util.Objects;
import javax.swing.*;
import javax.swing.border.Border;

public class NavBar extends JFrame{
    private final Color textColor = Color.decode("#283A6D");
    private final Color bgColor = Color.decode("#F2F6FF");
    private final Color background = Color.decode("#E3E3E3");
    private JLabel notifications;
    private JLabel settings;
    private JLabel logout;
    private JLabel recent;
    private JLabel avatar;
    private JTextField searchInput;

    public NavBar() {
        this.setTitle("Hiric");
        this.setSize(1000, 600);
        this.initUI();
        this.setLocationRelativeTo((Component)null);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public void initUI() {
        JPanel contentPanel = new JPanel(new BorderLayout());
        JPanel headPanel = new JPanel(new BorderLayout());
        JPanel bodyPanel = new JPanel(new GridBagLayout());
        ImageIcon recentIcon = new ImageIcon(Objects.requireNonNull(getClass().getResource("/src/img/recent.png")));
        this.recent = new JLabel(recentIcon);
        this.recent.setToolTipText("Recent Activities");
        ImageIcon notificationsIcon = new ImageIcon(Objects.requireNonNull(getClass().getResource("/src/img/notifications.png")));
        this.notifications = new JLabel(notificationsIcon);
        this.notifications.setToolTipText("Notifications");
        ImageIcon settingsIcon = new ImageIcon(Objects.requireNonNull(getClass().getResource("/src/img/settings.png")));
        this.settings = new JLabel(settingsIcon);
        this.settings.setToolTipText("Settings");
        ImageIcon logoutIcon = new ImageIcon(Objects.requireNonNull(getClass().getResource("/src/img/logout.png")));
        this.logout = new JLabel(logoutIcon);
        this.logout.setToolTipText("Logout");
        ImageIcon avatarIcon = new ImageIcon(Objects.requireNonNull(getClass().getResource("/src/img/avatar.png")));
        this.avatar = new JLabel(avatarIcon);
        this.avatar.setToolTipText("Profile");
        this.searchInput = new JTextField("Search...");
        this.searchInput.setBackground(this.bgColor);
        this.searchInput.setPreferredSize(new Dimension(250, 30));
        this.searchInput.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 5));
        headPanel.setPreferredSize(new Dimension(0, 50));
        headPanel.setBackground(this.background);
        bodyPanel.setBackground(this.bgColor);
        JPanel headRightPanel = new JPanel(new GridLayout(1, 4, 30, 0));
        JPanel headLeftPanel = new JPanel();
        headLeftPanel.setPreferredSize(new Dimension(500, 50));
        headRightPanel.setBackground(this.background);
        headLeftPanel.setBackground(this.background);
        headRightPanel.add(this.notifications);
        headRightPanel.add(this.settings);
        headRightPanel.add(this.avatar);
        headRightPanel.add(this.logout);
        headLeftPanel.add(this.recent);
        headLeftPanel.add(searchInput);
        headRightPanel.setBorder(BorderFactory.createEmptyBorder(7, 5, 10, 20));
        headLeftPanel.setBorder(BorderFactory.createEmptyBorder(7, 0, 10, 5));
        headPanel.add(headLeftPanel, "West");
        headPanel.add(headRightPanel, "East");
        contentPanel.add(headPanel, "North");
        this.add(contentPanel);
    }

    public static void main(String[] args) {
        new NavBar();
    }
}