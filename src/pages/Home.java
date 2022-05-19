package src.pages;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import javax.swing.*;
import javax.swing.border.Border;

public class Home extends JFrame {
    private final Color textColor = Color.decode("#283A6D");
    private final Color bgColor = Color.decode("#F2F6FF");
    private JButton registerButton;
    private JButton loginButton;
    private JTextField searchInput;

    public Home() {
        this.setTitle("Home");
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
        this.registerButton = new JButton("Register");
        this.loginButton = new JButton("Login");
        this.searchInput = new JTextField("Search whatever you want");
        JLabel appBrand = new JLabel("Hiric");
        JLabel welcomeText = new JLabel("Welcome to Hiric");
        JLabel instructionText = new JLabel("Search whatever you want");
        ImageIcon icon = new ImageIcon("search-icon.png");
        appBrand.setFont(new Font("nunito", 1, 25));
        appBrand.setForeground(this.textColor);
        headPanel.setPreferredSize(new Dimension(0, 80));
        headPanel.setBackground(this.bgColor);
        bodyPanel.setBackground(this.bgColor);
        JPanel headRightPanel = new JPanel(new GridLayout(1, 2, 15, 0));
        JPanel headLeftPanel = new JPanel(new GridLayout(1, 1, 10, 3));
        headRightPanel.setBackground(this.bgColor);
        headLeftPanel.setBackground(this.bgColor);
        headRightPanel.add(this.registerButton);
        headRightPanel.add(this.loginButton);
        headLeftPanel.add(appBrand);
        headRightPanel.setBorder(BorderFactory.createEmptyBorder(20, 5, 20, 50));
        headLeftPanel.setBorder(BorderFactory.createEmptyBorder(20, 50, 20, 5));
        this.registerButton.setBackground(this.textColor);
        this.registerButton.setForeground(Color.WHITE);
        this.registerButton.setFocusPainted(false);
        this.registerButton.setFont(new Font("nunito", 0, 15));
        this.registerButton.setFocusPainted(false);
        this.registerButton.setBorderPainted(false);
        this.loginButton.setBackground(this.bgColor);
        this.loginButton.setFont(new Font("nunito", 0, 17));
        this.loginButton.setForeground(this.textColor);
        this.loginButton.setBorder((Border)null);
        this.loginButton.setFocusPainted(false);
        JPanel bodyContent = new JPanel();
        BoxLayout boxLayout = new BoxLayout(bodyContent, 1);
        welcomeText.setFont(new Font("nunito", 1, 30));
        welcomeText.setForeground(this.textColor);
        instructionText.setForeground(Color.GRAY);
        instructionText.setFont(new Font("nunito", 0, 15));
        JPanel panel1 = new JPanel(new GridBagLayout());
        panel1.setBorder(BorderFactory.createEmptyBorder(0, 0, 3, 0));
        panel1.add(welcomeText);
        panel1.setBackground(this.bgColor);
        bodyContent.add(panel1);
        JPanel panel2 = new JPanel(new GridBagLayout());
        panel2.setBorder(BorderFactory.createEmptyBorder(0, 0, 25, 0));
        panel2.add(instructionText);
        panel2.setBackground(this.bgColor);
        bodyContent.add(panel2);
        bodyContent.setLayout(boxLayout);
        bodyContent.setBackground(this.bgColor);
        bodyPanel.setBackground(this.bgColor);
        bodyPanel.add(bodyContent);
        headPanel.add(headLeftPanel, "West");
        headPanel.add(headRightPanel, "East");
        contentPanel.add(headPanel, "North");
        contentPanel.add(bodyPanel, "Center");
        this.add(contentPanel);
    }

    public static void main(String[] args) {
        new Home();
    }
}
