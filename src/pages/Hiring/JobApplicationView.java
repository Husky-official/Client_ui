package src.pages.Hiring;

import src.components.shared.Button;
import src.pages.Login;
import src.pages.Register;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class JobApplicationView extends JFrame {

    private final Color textColor = Color.decode("#283A6D");
    private final Color bgColor = Color.decode("#F2F6FF");
    private JButton registerButton;
    private JButton loginButton;

    JLabel jobPostLabel;
    JTextField jobPostField;
    JLabel userIdLabel, locationId,paymentMethod,referenceNameLabel,referencePhoneLabel,resumeLabel,certificateLabel;
    JTextField userIdField, locationField,paymentMethodField,referenceNameField,referencePhoneField,resumeField,certificateField;

    JButton register;
    Container container;

    public JobApplicationView() {
        this.setTitle("Hiric");
        this.setSize(1000, 600);
        this.initUI();
        this.setLocationRelativeTo((Component)null);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public void initUI() {

        this.setIconImage(new ImageIcon(Objects.requireNonNull(getClass().getResource("/src/img/logo.png"))).getImage());

        JPanel contentPanel = new JPanel(new BorderLayout());
        JPanel headPanel = new JPanel(new BorderLayout());
        JPanel bodyPanel = new JPanel(new GridBagLayout());

        this.registerButton = new Button("Register", Color.WHITE, textColor, new Font("nunito", Font.PLAIN, 15) , 0);
        this.loginButton = new JButton("Login");

        JLabel appBrand = new JLabel("Hiric");
        JLabel welcomeText = new JLabel("Job Application Form");
        JLabel instructionText = new JLabel("Fill in the following field to register for a job!!");

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
        instructionText.setForeground(Color.GRAY);
        instructionText.setFont(new Font("nunito", 0, 15));

        JPanel panel1 = new JPanel(new GridBagLayout());
        panel1.setBorder(BorderFactory.createEmptyBorder(60, 0, 3, 0));
        panel1.add(welcomeText);
        panel1.setBackground(this.bgColor);
        bodyContent.add(panel1);

        JPanel panel2 = new JPanel(new GridBagLayout());
        panel2.setBorder(BorderFactory.createEmptyBorder(0, 0, 25, 0));
        panel2.add(instructionText);
        panel2.setBackground(this.bgColor);

        JLabel copyright = new JLabel("Copyright 2022 @husky | All Right Reserved.");
        copyright.setFont(new Font("nunito", Font.ITALIC, 15));
        copyright.setForeground(Color.GRAY);

        JPanel footer = new JPanel(new GridBagLayout());
        if(this.getSize().height == 600){
            footer.setBorder(BorderFactory.createEmptyBorder(60, 0, 0, 0));
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
        //application
            jobPostLabel = new JLabel("Job Post");
            jobPostField = new JTextField();

            userIdLabel = new JLabel("User ID");
            userIdField = new JTextField();

            locationId = new JLabel("Location");
            locationField = new JTextField();

            paymentMethod=new JLabel("Payment method:");
            paymentMethodField=new JTextField();

            referenceNameLabel=new JLabel("Reference Name");
            referenceNameField=new JTextField();

            referencePhoneLabel=new JLabel("Reference Phone");
            referencePhoneField=new JTextField();

            resumeLabel=new JLabel("Resume");
            resumeField=new JTextField();

            certificateLabel=new JLabel("Certificate");
            certificateField=new JTextField();

            register = new JButton("Apply");
            container = getContentPane();
            container.setLayout(null);
            setBounds();
            addComponents();

        }

        public void setBounds() {

            jobPostLabel.setBounds(50, 60, 100, 30);
            jobPostField.setBounds(210, 60, 250, 30);

            userIdLabel.setBounds(50, 110, 100, 30);
            userIdField.setBounds(210, 110, 250, 30);

            locationId.setBounds(50, 160, 600, 30);
            locationField.setBounds(210, 160, 250, 30);

            paymentMethod.setBounds(50, 210, 150, 30);
            paymentMethodField.setBounds(210, 210, 250, 30);

            referenceNameLabel.setBounds(50, 260, 100, 30);
            referenceNameField.setBounds(210, 260, 250, 30);

            referencePhoneLabel.setBounds(50, 310, 200, 30);
            referencePhoneField.setBounds(210, 310, 250, 30);

            resumeLabel.setBounds(50, 360, 200, 30);
            resumeField.setBounds(210, 360, 250, 30);

            certificateLabel.setBounds(50, 410, 100, 30);
            certificateField.setBounds(210, 410, 250, 30);

            register.setBounds(130, 550, 200, 30);
        }

        public void addComponents() {
          //  container.add(message);
            container.add(jobPostLabel);
            container.add(jobPostField);
            container.add(userIdLabel);
            container.add(userIdField);
            container.add(locationId);
            container.add(locationField);
            container.add(paymentMethod);
            container.add(paymentMethodField);
            container.add(referenceNameLabel);
            container.add(referenceNameField);
            container.add(referencePhoneLabel);
            container.add(referencePhoneField);
            container.add(resumeLabel);
            container.add(resumeField);
            container.add(certificateLabel);
            container.add(certificateField);
            container.add(registerButton);
        }
    public static void main(String []args){
        new JobApplicationView();
    }
}
