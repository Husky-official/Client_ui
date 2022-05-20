package src.pages.interviewing;

import src.components.shared.Button;
import src.utils.IconTextField;

import javax.swing.*;
import java.awt.*;

public class AddParticipant extends JPanel {
    private final Color textColor = Color.decode("#283A6D");
    private final Color bgColor = Color.decode("#F2F6FF");

    public AddParticipant(){
        this.setLayout(new BorderLayout());
        this.setBackground(this.bgColor);
        this.initUI();
    }
    private JLabel title;
    private JPanel formPanel;
    private IconTextField textField;
    private JButton add;

    public void initUI(){
        formPanel = new JPanel(new GridLayout(5, 1, 10, 0));
        formPanel.setBackground(this.bgColor);
        formPanel.setPreferredSize(new Dimension(500, 700));

        title = new JLabel("Add Participant");
        title.setFont(new Font("nunito", Font.BOLD, 25));
        title.setForeground(this.textColor);

        textField = new IconTextField();
        textField.setText("Enter username | email address");
        textField.setFont(new Font("nunito", 0, 15));
        textField.setBackground(this.bgColor);
        textField.setForeground(Color.lightGray);

        this.add = new Button("Add", Color.WHITE, textColor, new Font("nunito", Font.BOLD, 20), 3);

        // append components on main label
        formPanel.add(title);
        formPanel.add(textField);
        this.add(formPanel);
    }
}
