package src.pages;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class Register extends JFrame {
    private JPanel panel;

        public Register(){
            super("Register");
            createUIComponents();
            setSize(1000, 600);
            setLocationRelativeTo(null);
            setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            setVisible(true);
            setContentPane(panel);
            setIconImage(new ImageIcon(Objects.requireNonNull(getClass().getResource("/src/img/logo.png"))).getImage());
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
        JButton registerButton = new JButton("Register");

        registerButton.addActionListener(evt -> {
                    System.out.println("Register button clicked");
                    System.out.println(evt);
                }
        );

        panel = new JPanel();
        panel.setLayout(new GridLayout(7, 2));
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
        panel.add(registerButton);
    }

}
