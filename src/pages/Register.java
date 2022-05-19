package src.pages;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class Register extends JFrame {
    private final Color textColor = Color.decode("#283A6D");
    private final Color bgColor = Color.decode("#F2F6FF");
    JButton registerButton;
    JButton loginButton;

    private JPanel panel;

    public Register() {
        super("SignUp | Hiric");
        createUIComponents();
        setSize(1000, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        initUI();
    }


    public void initUI() {
        setIconImage(new ImageIcon(Objects.requireNonNull(getClass().getResource("/src/img/logo.png"))).getImage());

        JPanel contentPanel = new JPanel(new BorderLayout());
        JPanel headPanel = new JPanel(new BorderLayout());
        JPanel bodyPanel = new JPanel(new GridBagLayout());

        registerButton = new JButton("Register");
        loginButton = new JButton("Login");

        headPanel.setPreferredSize(new Dimension(0, 80));
        headPanel.setBackground(this.bgColor);
        bodyPanel.setBackground(this.bgColor);
        JPanel headRightPanel = new JPanel(new GridLayout(1, 2, 15, 0));
        JPanel headLeftPanel = new JPanel(new GridLayout(1, 1, 10, 3));
        headRightPanel.setBackground(this.bgColor);
        headLeftPanel.setBackground(this.bgColor);
        headRightPanel.add(registerButton);
        headRightPanel.add(loginButton);
        headRightPanel.setBorder(BorderFactory.createEmptyBorder(20, 5, 20, 50));
        headLeftPanel.setBorder(BorderFactory.createEmptyBorder(20, 50, 20, 5));

        registerButton.setBackground(this.textColor);
        registerButton.setForeground(Color.WHITE);
        registerButton.setFocusPainted(false);
        registerButton.setFont(new Font("nunito", Font.PLAIN, 15));

        registerButton.setFocusPainted(false);
        registerButton.setBorderPainted(false);
        loginButton.setBackground(this.bgColor);
        loginButton.setFont(new Font("nunito", 0, 17));
        loginButton.setForeground(this.textColor);
        loginButton.setBorder(null);
        loginButton.setFocusPainted(false);

        //add action on login and register buttons
        loginButton.addActionListener(e -> {
            Login login = new Login();
            login.setVisible(true);
            this.dispose();
        });

        registerButton.addActionListener(e -> {
            Register register = new Register();
            register.setVisible(true);
            this.dispose();
        });

        JPanel bodyContent = new JPanel();
        BoxLayout boxLayout = new BoxLayout(bodyContent, BoxLayout.Y_AXIS);

        createUIComponents();
        bodyContent.add(panel);

        // end of login form

        JLabel copyright = new JLabel("Copyright 2022 @husky | All Right Reserved.");
        copyright.setFont(new Font("nunito", Font.ITALIC, 15));
        copyright.setForeground(Color.GRAY);

        JPanel footer = new JPanel(new GridBagLayout());
        if (this.getSize().height == 600) {
            footer.setBorder(BorderFactory.createEmptyBorder(235, 0, 0, 0));
        }
        footer.add(copyright);
        footer.setBackground(this.bgColor);
        bodyContent.add(footer);

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
    private void createUIComponents() {

        JLabel accountTypeLabel = new JLabel("Account Type:");
        JLabel usernameLabel = new JLabel("Username:");
        JLabel passwordLabel = new JLabel("Password:");
        JLabel telephoneLabel = new JLabel("Telephone:");
        JLabel emailLabel = new JLabel("Email:");
        JTextField accountTypeField = new JTextField();
        JTextField usernameField = new JTextField();
        JTextField passwordField = new JTextField();
        JTextField telephoneField = new JTextField();
        JTextField emailField = new JTextField();
        JButton submitButton = new JButton("Register");
        submitButton.setBackground(this.textColor);
        submitButton.setForeground(Color.WHITE);
        submitButton.setFocusPainted(false);
        submitButton.setFont(new Font("nunito", Font.PLAIN, 15));
        // adding padding to subimt button

        submitButton.setFocusPainted(false);
        submitButton.setBorderPainted(false);
        submitButton.addActionListener(evt -> {
                    System.out.println("Register button clicked");
                    System.out.println(evt);
                }
        );

        panel = new JPanel();
        panel.setLayout(new GridLayout(11, 1,2,2));
        panel.setBackground(this.bgColor);
        // design the form with grid layout and add the components
        panel.add(usernameLabel);
        panel.add(usernameField);
        panel.add(emailLabel);
        panel.add(emailField);
        panel.add(telephoneLabel);
        panel.add(telephoneField);
        panel.add(passwordLabel);
        panel.add(passwordField);
        panel.add(accountTypeLabel);
        panel.add(accountTypeField);
        panel.add(submitButton);
    }

}
