package src.pages;

import src.components.shared.Button;
import src.constants.Colors;
import src.utils.IconTextField;

import javax.swing.*;
import java.awt.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Objects;

public class UserUpdateForm extends JFrame{
    private final Color textColor = Color.decode("#283A6D");
    private final Color bgColor = Color.decode("#F2F6FF");
    private JButton registerButton;
    private JButton loginButton;

    private JPanel panel;

    public UserUpdateForm(){
        super("Update user | Hiric");
        this.setSize(1000, 600);
        this.initUI();
        this.setLocationRelativeTo((Component)null);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
    public void initUI(){
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
//        loginButton.addActionListener(e -> {
//            Login login = new Login();
//            login.setVisible(true);
//            this.dispose();
//        });
//
//        registerButton.addActionListener(e -> {
//            Register register = new Register();
//            register.setVisible(true);
//            this.dispose();
//        });

        JPanel bodyContent = new JPanel();
        BoxLayout boxLayout = new BoxLayout(bodyContent, BoxLayout.Y_AXIS);

        updatedDetails();
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
//        headPanel.add(headLeftPanel, "West");
//        headPanel.add(headRightPanel, "East");
        JLabel welcomeText = new JLabel("Update user account");
        welcomeText.setFont(new Font("nunito", Font.BOLD, 25));
        welcomeText.setForeground(this.textColor);
        headPanel.add(welcomeText, "Center");
        contentPanel.add(headPanel, "North");
        contentPanel.add(bodyPanel, "Center");
        this.add(contentPanel);
    }
    private void updatedDetails() {
        JLabel errorLabel = new JLabel("");
        JLabel firstNameLabel = new JLabel("First name:");
        JLabel lastNameLabel = new JLabel("Last name:");
        JLabel telephoneLabel = new JLabel("Telephone:");
        JLabel emailLabel = new JLabel("Email:");
        JLabel genderLabel = new JLabel("Gender: ");
        JLabel roleLabel = new JLabel("Role:");
        JLabel dob = new JLabel("Date of Birth: ");
        IconTextField firstNameField = new IconTextField();
        IconTextField lastNameField = new IconTextField();
        IconTextField telephoneField = new IconTextField();
        IconTextField roleField = new IconTextField();
        JRadioButton maleRadioButton = new JRadioButton("Male");
        JRadioButton femaleRadioButton = new JRadioButton("Female");
        DateFormat dateFormat = new SimpleDateFormat("dd MMM yyyy");
        JFormattedTextField dobField = new JFormattedTextField(dateFormat);
        IconTextField emailField = new IconTextField();

        JButton submitButton = new Button("Update user", Color.WHITE, textColor, new Colors().SidebarFont, 12);
        roleLabel.setFont(new Font("nunito", Font.PLAIN, 15));
        firstNameLabel.setFont(new Font("nunito", Font.PLAIN, 15));
        lastNameLabel.setFont(new Font("nunito", Font.PLAIN, 15));
        telephoneLabel.setFont(new Font("nunito", Font.PLAIN, 15));
        emailLabel.setFont(new Font("nunito", Font.PLAIN, 15));
        errorLabel.setFont(new Font("nunito", Font.PLAIN, 15));
        errorLabel.setBackground(Color.WHITE);
        errorLabel.setForeground(Color.RED);
        errorLabel.setHorizontalAlignment(SwingConstants.CENTER);
        roleField.setFont(new Font("nunito", Font.PLAIN, 15));
        firstNameField.setFont(new Font("nunito", Font.PLAIN, 15));
        lastNameField.setFont(new Font("nunito", Font.PLAIN, 15));
        telephoneField.setFont(new Font("nunito", Font.PLAIN, 15));
        emailField.setFont(new Font("nunito", Font.PLAIN, 15));
        submitButton.setFont(new Font("nunito", Font.PLAIN, 15));

        submitButton.setBackground(this.textColor);
        submitButton.setForeground(Color.WHITE);
        submitButton.setFocusPainted(false);
        submitButton.setFont(new Font("nunito", Font.PLAIN, 15));
        // adding padding to submit button

        submitButton.setFocusPainted(false);
        submitButton.setBorderPainted(false);
        submitButton.addActionListener(evt -> {
                    System.out.println("Update button clicked");
                    String firstName = firstNameField.getText();
                    String lastName = lastNameField.getText();
                    String telephone = telephoneField.getText();
                    String email = emailField.getText();
                    String role = roleField.getText();

                    if (role.equals("") || firstName.equals("") || lastName.equals("") || telephone.equals("") || email.equals("")) {
                        errorLabel.setText("Please fill all the fields");
                    }
                }
        );
        panel = new JPanel();
        panel.setLayout(new GridLayout(15, 1,2,2));
        panel.setBackground(this.bgColor);
        // adding radio buttons to panel in a group

        JPanel radioButton = new JPanel();
        radioButton.setBackground(this.bgColor);
        radioButton.add(maleRadioButton);
        radioButton.add(femaleRadioButton);

        ButtonGroup group = new ButtonGroup();
        group.add(maleRadioButton);
        group.add(femaleRadioButton);
        maleRadioButton.setBackground(this.bgColor);
        femaleRadioButton.setBackground(this.bgColor);
        maleRadioButton.setFont(new Font("nunito", Font.PLAIN, 15));
        femaleRadioButton.setFont(new Font("nunito", Font.PLAIN, 15));
        maleRadioButton.setFocusPainted(false);
        femaleRadioButton.setFocusPainted(false);
        maleRadioButton.setBorderPainted(false);
        femaleRadioButton.setBorderPainted(false);
        maleRadioButton.setSelected(true);

//        panel.add(errorLabel);
        panel.add(firstNameLabel);
        panel.add(firstNameField);
        panel.add(lastNameLabel);
        panel.add(lastNameField);
        panel.add(emailLabel);
        panel.add(emailField);
        panel.add(telephoneLabel);
        panel.add(telephoneField);
        panel.add(roleLabel);
        panel.add(roleField);
        panel.add(dob);
        panel.add(dobField);
        panel.add(genderLabel);
        panel.add(radioButton);
        panel.add(submitButton);
    }

    public static void main(String[] args) {
        new UserUpdateForm();
    }
}
