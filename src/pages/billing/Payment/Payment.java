package src.pages.billing.Payment;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Payment extends JPanel {
    private final Color textColor = Color.decode("#283A6D");
    private final Color bgColor = Color.decode("#F2F6FF");
    private final Color mtnBgColor =  Color.decode("#ffcc00");
    private JButton momoPay;
    private JButton paypalPay;

    public Payment() {
        this.setLayout(new BorderLayout());
        this.setBackground(this.bgColor);
        this.initUI();
    }

    public void initUI() {
        JLabel text = new JLabel("Choose Payment method");
        text.setFont(new Font("nunito", Font.BOLD, 25));
        text.setForeground(this.textColor);
        this.add(text, BorderLayout.NORTH);

        momoPay = new JButton("Momo Pay");
        this.momoPay.setBackground(this.mtnBgColor);
        this.momoPay.setForeground(Color.WHITE);
        this.momoPay.setFocusPainted(false);
        this.momoPay.setFont(new Font("nunito", Font.PLAIN, 15));

        this.momoPay.setFocusPainted(false);
        this.momoPay.setBorderPainted(false);
        this.add(this.momoPay, BorderLayout.WEST);

        paypalPay = new JButton("Pay with Paypal");
        this.paypalPay.setBackground(this.textColor);
        this.paypalPay.setForeground(Color.WHITE);
        this.paypalPay.setFocusPainted(false);
        this.paypalPay.setFont(new Font("nunito", Font.PLAIN, 15));

        this.paypalPay.setFocusPainted(false);
        this.paypalPay.setBorderPainted(false);
        this.add(paypalPay, BorderLayout.EAST);

        momoPay.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new MomoPayPage();
            }
        });

        paypalPay.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new PaypalPayPage();
            }
        });

    }
}
