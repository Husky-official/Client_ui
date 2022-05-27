package src.pages.billing.Payment;

import src.utils.IconTextField;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class PaypalPay extends JPanel {
    private final Color textColor = Color.decode("#283A6D");
    private final Color bgColor = Color.decode("#F2F6FF");
    private final Color mtnBgColor =  Color.decode("#ffcc00");
    private JButton confirmBtn;

    public PaypalPay() {
        this.setLayout(new BorderLayout());
        this.setBackground(this.bgColor);
        this.initUI();
    }

    public void initUI() {
        JPanel formPanel = new JPanel(new GridLayout(8, 1, 1,1));
        formPanel.setPreferredSize(new Dimension(600, 600));
        formPanel.setBackground(this.bgColor);

        JLabel text = new JLabel("Complete the form to pay with Paypal");
        text.setFont(new Font("nunito", Font.BOLD, 25));
        text.setForeground(this.textColor);

        this.confirmBtn = new JButton("Confirm");

        JLabel errorMsg = new JLabel("");
        errorMsg.setFont(new Font("nunito", Font.ITALIC, 17));
        errorMsg.setForeground(Color.red);

        JLabel phoneNbrOrEmailLabel = new JLabel("Email or phone number : ");
        JLabel passwordLabel = new JLabel("Password : ");
        IconTextField phoneNbrOrEmailField = new IconTextField();
        JTextField passwordField = new JTextField();

        phoneNbrOrEmailLabel.setFont(new Font("nunito", 0, 14));
        phoneNbrOrEmailLabel.setForeground(this.textColor);

        passwordLabel.setFont(new Font("nunito", 0, 14));
        passwordLabel.setForeground(this.textColor);

        phoneNbrOrEmailField.setFont(new Font("Verdana", 0, 14));
        phoneNbrOrEmailField.setPreferredSize(new Dimension(280, 30));
        phoneNbrOrEmailField.setBackground(this.bgColor);
        phoneNbrOrEmailField.setForeground(Color.BLACK);

        passwordField.setFont(new Font("Verdana", 0, 14));
        passwordField.setPreferredSize(new Dimension(280, 30));
        passwordField.setBackground(this.bgColor);
        passwordField.setForeground(Color.BLACK);

        this.confirmBtn.setBackground(this.textColor);
        this.confirmBtn.setForeground(Color.WHITE);
        this.confirmBtn.setFocusPainted(false);
        this.confirmBtn.setFont(new Font("nunito", Font.PLAIN, 20));
        this.confirmBtn.setPreferredSize(new Dimension(280, 30));

        this.confirmBtn.setFocusPainted(false);
        this.confirmBtn.setBorderPainted(false);

        formPanel.add(text);
        formPanel.add(errorMsg);
        formPanel.add(phoneNbrOrEmailLabel);
        formPanel.add(phoneNbrOrEmailField);
        formPanel.add(passwordLabel);
        formPanel.add(passwordField);
        formPanel.add(confirmBtn);
        this.add(formPanel);

        confirmBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (phoneNbrOrEmailField.getText().equals("") || passwordField.getText().equals("")) {
                    errorMsg.setText("Please fill out the all fields");
                } else {
                    new PaypalPayPage();
                }
            }
        });

    }
}
