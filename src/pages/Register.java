package src.pages;

import src.models.UserUtils;
import src.utils.IconTextField;

import javax.swing.*;
import java.awt.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
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
        loginButton.setFont(new Font("nunito", Font.PLAIN, 17));
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
        JLabel errorLabel = new JLabel("");
        JLabel accountTypeLabel = new JLabel("Account Type:");
        JLabel usernameLabel = new JLabel("Username:");
        JLabel passwordLabel = new JLabel("Password:");
        JLabel telephoneLabel = new JLabel("Telephone:");
        JLabel emailLabel = new JLabel("Email:");
        JLabel genderLabel = new JLabel("Gender: ");
        JLabel dob = new JLabel("Date of Birth: ");
        IconTextField accountTypeField = new IconTextField();
        IconTextField usernameField = new IconTextField();
        IconTextField passwordField = new IconTextField();
        IconTextField telephoneField = new IconTextField();
        JRadioButton maleRadioButton = new JRadioButton("Male");
        JRadioButton femaleRadioButton = new JRadioButton("Female");
        DateFormat dateFormat = new SimpleDateFormat("dd MMM yyyy");
        JFormattedTextField dobField = new JFormattedTextField(dateFormat);
        IconTextField emailField = new IconTextField();
        JButton submitButton = new JButton("Register");
        accountTypeLabel.setFont(new Font("nunito", Font.PLAIN, 15));
        usernameLabel.setFont(new Font("nunito", Font.PLAIN, 15));
        passwordLabel.setFont(new Font("nunito", Font.PLAIN, 15));
        telephoneLabel.setFont(new Font("nunito", Font.PLAIN, 15));
        emailLabel.setFont(new Font("nunito", Font.PLAIN, 15));
        errorLabel.setFont(new Font("nunito", Font.PLAIN, 15));
        errorLabel.setBackground(Color.WHITE);
        errorLabel.setForeground(Color.RED);
        errorLabel.setHorizontalAlignment(SwingConstants.CENTER);
        accountTypeField.setFont(new Font("nunito", Font.PLAIN, 15));
        usernameField.setFont(new Font("nunito", Font.PLAIN, 15));
        passwordField.setFont(new Font("nunito", Font.PLAIN, 15));
        telephoneField.setFont(new Font("nunito", Font.PLAIN, 15));
        emailField.setFont(new Font("nunito", Font.PLAIN, 15));
        submitButton.setFont(new Font("nunito", Font.PLAIN, 15));

        submitButton.setBackground(this.textColor);
        submitButton.setForeground(Color.WHITE);
        submitButton.setFocusPainted(false);
        submitButton.setFont(new Font("nunito", Font.PLAIN, 15));
        // adding padding to subimt button

        submitButton.setFocusPainted(false);
        submitButton.setBorderPainted(false);
        submitButton.addActionListener(evt -> {
                    System.out.println("Register button clicked");
                    String accountType = accountTypeField.getText();
                    String username = usernameField.getText();
                    String password = passwordField.getText();
                    String telephone = telephoneField.getText();
                    String email = emailField.getText();

                    if (accountType.equals("") || username.equals("") || password.equals("") || telephone.equals("") || email.equals("")) {
                        errorLabel.setText("Please fill all the fields");
                    }
                }
        );
        panel = new JPanel();
        panel.setLayout(new GridLayout(19, 1,2,2));
        panel.setBackground(this.bgColor);
        // adding radio buttons to panel in a group
        ButtonGroup group = new ButtonGroup();
        group.add(maleRadioButton);
        group.add(femaleRadioButton);
        maleRadioButton.setBackground(this.bgColor);
        femaleRadioButton.setBackground(this.bgColor);
        maleRadioButton.setForeground(Color.WHITE);
        femaleRadioButton.setForeground(Color.WHITE);
        maleRadioButton.setFont(new Font("nunito", Font.PLAIN, 15));
        femaleRadioButton.setFont(new Font("nunito", Font.PLAIN, 15));
        maleRadioButton.setFocusPainted(false);
        femaleRadioButton.setFocusPainted(false);
        maleRadioButton.setBorderPainted(false);
        femaleRadioButton.setBorderPainted(false);
        maleRadioButton.setSelected(true);

        panel.add(errorLabel);
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
        panel.add(dob);
        panel.add(dobField);
        panel.add(genderLabel);
        panel.add(maleRadioButton);
        panel.add(femaleRadioButton);
        panel.add(submitButton);
    }

}
