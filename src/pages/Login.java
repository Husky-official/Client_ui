package src.pages;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import src.client.ClientServerConnector;
import src.models.RequestBody;
import src.models.User;
import src.pages.dashboard.DashboardPage;
import src.utils.IconTextField;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Objects;
import java.util.Properties;

public class Login extends JFrame implements ActionListener {
    FileReader fileReader = new FileReader("./resources/application.properties");

    Properties properties = new Properties();

    private final Color textColor = Color.decode("#283A6D");
    private final Color bgColor = Color.decode("#F2F6FF");
    private JButton registerButton;
    private JButton loginButton;

    JLabel emailLabel = new JLabel("Email : ");
    JLabel passwordLabel = new JLabel("Password : ");
    IconTextField userEmailField = new IconTextField();
    JPasswordField passwordField = new JPasswordField();
    JButton login = new JButton("Login");
    JButton resetButton = new JButton("Reset");
    JCheckBox showPassword = new JCheckBox("Show Password");


    public Login() throws FileNotFoundException {
        this.setTitle("Login | Hiric");
        this.setSize(1000, 600);
        this.setLocationRelativeTo((Component) null);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.initUI();
        this.addActionEvent();
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
        appBrand.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Home home = new Home();
                home.setVisible(true);
                dispose();
            }
        });
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
            try {
              Login login = new Login();
                login.setVisible(true);
                dispose();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
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
        panel1.setBorder(BorderFactory.createEmptyBorder(50, 0, 30, 0));
        panel1.add(welcomeText);
        panel1.setBackground(this.bgColor);
        bodyContent.add(panel1);

        /**
         * Add login form
         * */

       //email label and email text field setup
//        emailLabel.setBounds(50, 150, 100, 30);
        Panel email=new Panel();
//        email.setLayout(new GridBagLayout());
        email.setBackground(this.bgColor);
        emailLabel.setFont(new Font("nunito", 0, 14));
        emailLabel.setForeground(this.textColor);
        userEmailField.setFont(new Font("Verdana", 0, 14));
        userEmailField.setPreferredSize(new Dimension(280, 30));
        userEmailField.setBackground(this.bgColor);
        userEmailField.setForeground(Color.BLACK);
//      passwordLabel.setBounds(50, 220, 100, 30);
        Panel password=new Panel();
//        password.setLayout(new GridBagLayout());
        password.setBackground(this.bgColor);
        passwordLabel.setFont(new Font("nunito", 0, 14));
        passwordLabel.setForeground(this.textColor);
        passwordField.setFont(new Font("Verdana", 0, 14));
        passwordField.setPreferredSize(new Dimension(280, 30));
        passwordField.setBackground(this.bgColor);
        passwordField.setForeground(Color.BLACK);
        //show password checkbox setup
        showPassword.setBackground(this.bgColor);
        showPassword.setForeground(this.textColor);
        showPassword.setFont(new Font("nunito", 0, 14));
        showPassword.setFocusPainted(false);
        showPassword.setBorderPainted(false);
        showPassword.setOpaque(false);
        showPassword.setSelected(false);
        showPassword.setBorder(null);
        showPassword.setFocusPainted(false);
        //login button setup
        login.setBackground(this.textColor);
        login.setForeground(Color.WHITE);
        login.setFocusPainted(false);
        login.setFont(new Font("nunito",Font.PLAIN,14));
        //reset button setup
        resetButton.setBackground(this.textColor);
        resetButton.setForeground(Color.RED);
        resetButton.setFont(new Font("nunito", Font.PLAIN, 14));
        resetButton.setFocusPainted(false);
        resetButton.setBorderPainted(false);
        //panel 2 setup
        JPanel panel2 = new JPanel();
        panel2.setLayout(new GridLayout(8,1,2,2));
//        panel2.setBorder(BorderFactory.createEmptyBorder(10, 0, 25, 0));
        panel2.setBackground(this.bgColor);
        panel2.add(emailLabel);
        panel2.add(userEmailField);
        panel2.add(passwordLabel);
        panel2.add(passwordField);
        panel2.add(showPassword);
        panel2.add(login);
        panel2.add(resetButton);
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
    public void addActionEvent() {
        login.addActionListener(this);
        resetButton.addActionListener(this);
        showPassword.addActionListener(this);
    }
    //listening to action
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == resetButton) {
            userEmailField.setText("");
            passwordField.setText("");
        }
        if(e.getSource()==showPassword){
            if(showPassword.isSelected()){
                passwordField.setEchoChar((char)0);
            }else{
                passwordField.setEchoChar('*');
            }
        }
        if (e.getSource()==login){
            String emailEntered= userEmailField.getText();
            String passwordEntered= passwordField.getText();
            if(emailEntered.equals("")||passwordEntered.equals("")){
                JOptionPane.showMessageDialog(null,"Please fill all the fields","Error",JOptionPane.ERROR_MESSAGE);
            }
            //sending request to the server
            try {
                User user =new User();
                user.setEmail(emailEntered);
                user.setPassword(passwordEntered);
                RequestBody requestBody=new RequestBody();
                requestBody.setUrl("/users");
                requestBody.setAction("login");
                requestBody.setObject(user);
                String requestString = new ObjectMapper().writeValueAsString(requestBody);
                ClientServerConnector clientServerConnector=new ClientServerConnector();
                //sending request to the server
                String response=clientServerConnector.connect(requestString);
                //getting response
                ObjectMapper objectMapper = new ObjectMapper();
                JsonNode jsonResponse = objectMapper.readTree(response);
                int status = jsonResponse.get("status").asInt();
                String message = jsonResponse.get("message").asText();
                System.out.println(message);
                String actionDone = jsonResponse.get("actionToDo").asText();
                if(Objects.equals(message, "You are already logged in.") || Objects.equals(message,"User logged in successfully")){
                    JOptionPane.showMessageDialog(null,"Login Successful");
                    properties.load(fileReader);
                    properties.setProperty("logged_in", true+"");
                    //fileWriter
                    FileWriter fileWriter = new FileWriter("./resources/application.properties");
                    try {
                        fileWriter.write("logged_in="+true+"\n");
                        fileWriter.flush();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                    System.out.println(properties.getProperty("logged_in"));
//                    properties.save();
                    new DashboardPage().setVisible(true);
                    this.dispose();
                    return;
                }
                else{
                    JOptionPane.showMessageDialog(null,"Invalid email or password");
                }
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            }
    }
}
