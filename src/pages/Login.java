package src.pages;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class Login extends JFrame {

    private final Color textColor = Color.decode("#283A6D");
    private final Color bgColor = Color.decode("#F2F6FF");
    private JButton registerButton;
    private JButton loginButton;


    public Login() {
        this.setTitle("Login | Hiric");
        this.setSize(1000, 600);
        this.setLocationRelativeTo((Component) null);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.initUI();
    }

    public void initUI() {
        this.setIconImage(new ImageIcon(Objects.requireNonNull(getClass().getResource("/src/img/logo.png"))).getImage());

        JPanel contentPanel = new JPanel(new BorderLayout());
        JPanel headPanel = new JPanel(new BorderLayout());
        JPanel bodyPanel = new JPanel(new GridBagLayout());

        this.registerButton = new JButton("Register");
        this.loginButton = new JButton("Login");

        JLabel appBrand = new JLabel("Hiric");
        JLabel welcomeText = new JLabel("Login Into Your Account");

        appBrand.setFont(new Font("nunito", Font.BOLD, 25));
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
        this.registerButton.setFont(new Font("nunito", Font.PLAIN, 15));

        this.registerButton.setFocusPainted(false);
        this.registerButton.setBorderPainted(false);
        this.loginButton.setBackground(this.bgColor);
        this.loginButton.setFont(new Font("nunito", 0, 17));
        this.loginButton.setForeground(this.textColor);
        this.loginButton.setBorder(null);
        this.loginButton.setFocusPainted(false);

        //add action on login and register buttons
        this.loginButton.addActionListener(e -> {
            Login login = new Login();
            login.setVisible(true);
            this.dispose();
        });

        this.registerButton.addActionListener(e -> {
            Register register = new Register();
            register.setVisible(true);
            this.dispose();
        });

        JPanel bodyContent = new JPanel();
        BoxLayout boxLayout = new BoxLayout(bodyContent, BoxLayout.Y_AXIS);

        welcomeText.setFont(new Font("nunito", Font.BOLD, 30));
        welcomeText.setForeground(this.textColor);


        JPanel panel1 = new JPanel(new GridBagLayout());
        panel1.setBorder(BorderFactory.createEmptyBorder(80, 0, 3, 0));
        panel1.add(welcomeText);
        panel1.setBackground(this.bgColor);
        bodyContent.add(panel1);

        /**
         * Add login form
         * */



        JPanel panel2 = new JPanel(new GridBagLayout());
        panel2.setBorder(BorderFactory.createEmptyBorder(0, 0, 25, 0));
        panel2.setBackground(this.bgColor);
        bodyContent.add(panel2);

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

}
