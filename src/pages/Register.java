package src.pages;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import src.client.ClientServerConnector;
import src.models.RegisterUser;
import src.models.RequestBody;
import src.models.User;
import src.models.UserUtils;
import src.pages.dashboard.DashboardPage;
import src.utils.IconTextField;
import src.utils.registration.Validations;

import javax.swing.*;
import java.awt.*;
import java.io.FileNotFoundException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

public class Register extends JFrame implements ActionListener {
    private final Color textColor = Color.decode("#283A6D");
    private final Color bgColor = Color.decode("#F2F6FF");
    JButton registerButton;
    JButton loginButton;
    IconTextField accountTypeField = new IconTextField();
    IconTextField usernameField = new IconTextField();
    IconTextField passwordField = new IconTextField();
    IconTextField telephoneField = new IconTextField();
    JRadioButton maleRadioButton = new JRadioButton("Male");
    JRadioButton femaleRadioButton = new JRadioButton("Female");
    DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    JFormattedTextField dobField = new JFormattedTextField(dateFormat);
    IconTextField emailField = new IconTextField();
    JLabel errorLabel = new JLabel("");
    JLabel successLabel = new JLabel("");


    private JPanel panel;
    JButton submitButton = new JButton("Register");

    public Register() {
        super("SignUp | Hiric");
        createUIComponents();
        setSize(1000, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        initUI();
        addActionEvent();
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
            Login login = null;
            try {
                login = new Login();
            } catch (FileNotFoundException ex) {
                throw new RuntimeException(ex);
            }
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
        JLabel genderLabel = new JLabel("Gender: ");
        JLabel dob = new JLabel("Date of Birth: ");
        accountTypeLabel.setFont(new Font("nunito", Font.PLAIN, 15));
        usernameLabel.setFont(new Font("nunito", Font.PLAIN, 15));
        passwordLabel.setFont(new Font("nunito", Font.PLAIN, 15));
        telephoneLabel.setFont(new Font("nunito", Font.PLAIN, 15));
        emailLabel.setFont(new Font("nunito", Font.PLAIN, 15));
        errorLabel.setFont(new Font("nunito", Font.PLAIN, 15));
        errorLabel.setBackground(Color.RED);
        errorLabel.setForeground(Color.WHITE);
        errorLabel.setHorizontalAlignment(SwingConstants.CENTER);
        successLabel.setFont(new Font("nunito", Font.PLAIN, 15));
        successLabel.setBackground(Color.GREEN);
        successLabel.setForeground(Color.WHITE);
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

    public void addActionEvent() {
        submitButton.addActionListener(this);
    }
    //listening to action
    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource()==submitButton){
            String accountType = accountTypeField.getText();
            String username = usernameField.getText();
            String password = passwordField.getText();
            String telephone = telephoneField.getText();
            String email = emailField.getText();
            String dob = dobField.getText();
            UserUtils.UserGender userGender = maleRadioButton.isSelected() ? UserUtils.UserGender.MALE : UserUtils.UserGender.FEMALE;
            if (accountType.equals("") || username.equals("") || password.equals("") || telephone.equals("") || email.equals("") || dob.equals("")) {
                errorLabel.setText("Please fill all the fields");
            }
            if(!Validations.isEmailValid(email).equals("OK")) errorLabel.setText(Validations.isEmailValid(email));
            if(!Validations.isPhoneNumberValid(telephone).equals("OK")) errorLabel.setText(Validations.isPhoneNumberValid(telephone));
            if(!Validations.isPasswordValid(password).equals("OK")) errorLabel.setText(Validations.isPasswordValid(password));
            if(!Validations.isNameValid(username).equals("OK")) errorLabel.setText(Validations.isNameValid(username));
            if(!Validations.isDateValid(dob).equals("OK")) errorLabel.setText(Validations.isDateValid(dob));

            //sending request to the server
            try {
                Date birthdate = new SimpleDateFormat("dd/MM/yyyy").parse(dob);
                String[] names = username.split(" ");
                String firstName = names[0];
                String lastName = names[1];
                UserUtils.UserRoles role = UserUtils.UserRoles.valueOf(accountType);
                RegisterUser registerUser = new RegisterUser(1, firstName, lastName, email,password, userGender, role, birthdate);
                RequestBody requestBody=new RequestBody();
                requestBody.setUrl("/users");
                requestBody.setAction("register");
                requestBody.setObject(registerUser);
                String requestString = new ObjectMapper().writeValueAsString(requestBody);
                ClientServerConnector clientServerConnector=new ClientServerConnector();
                //sending request to the server
                String response=clientServerConnector.connect(requestString);
                //getting response
                ObjectMapper objectMapper = new ObjectMapper();
                JsonNode jsonResponse = objectMapper.readTree(response);
                int status = jsonResponse.get("status").asInt();
                String message = jsonResponse.get("message").asText();
                String actionDone = jsonResponse.get("actionToDo").asText();
                if (status == 200) {
                        JOptionPane.showMessageDialog(null, message);
                        this.dispose();
                        new Login().setVisible(true);
                }else{
                    errorLabel.setText(message);
                }
                    System.out.println(message+" "+actionDone +" "+status);
            } catch (IOException e1) {
                e1.printStackTrace();
            } catch (ParseException ex) {
                throw new RuntimeException(ex);
            }
        }
    }
}
