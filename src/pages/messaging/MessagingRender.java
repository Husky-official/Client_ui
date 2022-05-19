package src.pages.messaging;

import src.components.shared.Button;
import src.components.sidebar.MenuItem;
import src.pages.Login;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class MessagingRender extends JPanel {
    private final Color textColor = Color.decode("#283A6D");
    private final Color bgColor = Color.decode("#F2F6FF");

    public MessagingRender() {
        this.setLayout(new BorderLayout());
        this.setBackground(this.bgColor);
        this.initUI();
    }

    public void initUI() {
        JLabel text = new JLabel("Messaging");
        text.setFont(new Font("nunito", Font.BOLD, 25));
        text.setForeground(this.textColor);
        this.add(text, BorderLayout.NORTH);
    }
}
