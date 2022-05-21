package src.pages.billing.Payment;

import src.utils.IconTextField;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class MomoPay extends JPanel {
    private final Color textColor = Color.decode("#283A6D");
    private final Color bgColor = Color.decode("#F2F6FF");
    private final Color mtnBgColor =  Color.decode("#ffcc00");
    private JButton confirmBtn;

    public MomoPay() {
        this.setLayout(new BorderLayout());
        this.setBackground(this.bgColor);
        this.initUI();
    }

    public void initUI() {
        JPanel formPanel = new JPanel(new GridLayout(8, 1, 1,1));
        formPanel.setPreferredSize(new Dimension(600, 600));
        formPanel.setBackground(this.bgColor);

        JLabel text = new JLabel("Complete the form to pay with Momo");
        text.setFont(new Font("nunito", Font.BOLD, 25));
        text.setForeground(this.textColor);

        this.confirmBtn = new JButton("Confirm");

        JLabel errorMsg = new JLabel("");
        errorMsg.setFont(new Font("nunito", Font.ITALIC, 17));
        errorMsg.setForeground(Color.red);

        JLabel phoneNbrLabel = new JLabel("Your phone number : ");
        JLabel pinNbrLabel = new JLabel("Phone number pin : ");
        IconTextField phoneNbrField = new IconTextField();
        JTextField pinNbrField = new JTextField();

        phoneNbrLabel.setFont(new Font("nunito", 0, 14));
        phoneNbrLabel.setForeground(this.textColor);

        pinNbrLabel.setFont(new Font("nunito", 0, 14));
        pinNbrLabel.setForeground(this.textColor);

        phoneNbrField.setFont(new Font("Verdana", 0, 14));
        phoneNbrField.setPreferredSize(new Dimension(280, 30));
        phoneNbrField.setBackground(this.bgColor);
        phoneNbrField.setForeground(Color.BLACK);

        pinNbrField.setFont(new Font("Verdana", 0, 14));
        pinNbrField.setPreferredSize(new Dimension(280, 30));
        pinNbrField.setBackground(this.bgColor);
        pinNbrField.setForeground(Color.BLACK);

        this.confirmBtn.setBackground(this.mtnBgColor);
        this.confirmBtn.setForeground(Color.WHITE);
        this.confirmBtn.setFocusPainted(false);
        this.confirmBtn.setFont(new Font("nunito", Font.PLAIN, 20));
        this.confirmBtn.setPreferredSize(new Dimension(280, 30));

        this.confirmBtn.setFocusPainted(false);
        this.confirmBtn.setBorderPainted(false);

        formPanel.add(text);
        formPanel.add(errorMsg);
        formPanel.add(phoneNbrLabel);
        formPanel.add(phoneNbrField);
        formPanel.add(pinNbrLabel);
        formPanel.add(pinNbrField);
        formPanel.add(confirmBtn);
        this.add(formPanel);

        phoneNbrField.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if ( ((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE)) {
                    errorMsg.setText("Please input a vaild phone number!");
                    e.consume();  // if it's not a number, ignore the event
                }
            }
        });

        pinNbrField.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if ( ((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE) || pinNbrField.getDocument().getLength() > 4) {
                    errorMsg.setText("Please input a vaild pin!");
                    e.consume();  // if it's not a number, ignore the event
                }
            }
        });

        confirmBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (phoneNbrField.getText().equals("") || pinNbrField.getText().equals("") || phoneNbrField.getText().length() != 10 || pinNbrField.getText().length() != 5) {
                    errorMsg.setText("Invalid pin or phone number");
                } else {
                    new PaypalPayPage();
                }
            }
        });

    }
}
