package src.pages.interviewing;

import src.models.EventType;
import src.utils.IconTextField;
import src.components.shared.Button;
import javax.swing.*;
import java.awt.*;

public class Interviewing extends JPanel {
    private final Color textColor = Color.decode("#283A6D");
    private final Color bgColor = Color.decode("#F2F6FF");

    public Interviewing() {
        this.setLayout(new BorderLayout());
        this.setBackground(this.bgColor);
        this.initUI();
    }

    private JLabel title, jobPostIdLabel, eventNameLabel, eventDate ,eventTypeLabel, startTimeLabel, endTimeLabel;
    private IconTextField jobPostIdField, eventNameField,eventDateField, startTimeField, endTimeField;
    private JComboBox eventType;
    private JButton reset;
    private JButton registerButton;
    private JPanel formPanel;
    private EventType eventTypes [] ={
            EventType.CALL, EventType.ONLINE_INTERVIEW, EventType.IN_PERSON_INTERVIEW
    };

    public void initUI(){
        formPanel = new JPanel(new GridLayout(12, 1,30 , 0));
        formPanel.setBackground(this.bgColor);
        formPanel.setPreferredSize(new Dimension(500, 300));


        title = new JLabel("Schedule a Meeting");
        title.setFont(new Font("nunito", Font.BOLD, 25));
        title.setSize(300, 40);
        title.setLocation(00, 30);
        title.setForeground(this.textColor);

        jobPostIdLabel = new JLabel("Job Post ID");
        jobPostIdLabel.setFont(new Font("nunito", 0, 14));
        jobPostIdLabel.setForeground(this.textColor);

        jobPostIdField = new IconTextField();
        jobPostIdField.setFont(new Font("nunito", 0, 15));
//        jobPostIdField.setPreferredSize(new Dimension(200, 30));
        jobPostIdField.setBackground(this.bgColor);
        jobPostIdField.setForeground(Color.BLACK);

        eventNameLabel = new JLabel("Event name");
        eventNameLabel.setFont(new Font("nunito", 0, 14));
        eventNameLabel.setForeground(this.textColor);

        eventNameField = new IconTextField();
        eventNameField.setFont(new Font("nunito", 0, 15));
        eventNameField.setBackground(this.bgColor);
        eventNameField.setForeground(Color.BLACK);

        eventTypeLabel = new JLabel("Event Type");
        eventTypeLabel.setFont(new Font("nunito", 0, 14));
        eventTypeLabel.setForeground(this.textColor);

        eventType = new JComboBox(eventTypes);
        eventType.setFont(new Font("nunito", Font.PLAIN, 15));

        eventDate = new JLabel("Event date");
        eventDate.setFont(new Font("nunito", 0, 14));
        eventDate.setForeground(this.textColor);

        eventDateField = new IconTextField();
        eventDateField.setText("dd.mm.yyyy");
        eventDateField.setFont(new Font("nunito", 0, 15));
        eventDateField.setBackground(this.bgColor);
        eventDateField.setForeground(Color.BLACK);

        startTimeLabel = new JLabel("From");
        startTimeLabel.setFont(new Font("nunito", 0, 14));
        startTimeLabel.setForeground(this.textColor);

        startTimeField= new IconTextField();
        startTimeField.setText("dd.mm.yyyy");
        startTimeField.setFont(new Font("nunito", 0, 15));
        startTimeField.setBackground(this.bgColor);
        startTimeField.setForeground(Color.BLACK);

        endTimeLabel = new JLabel("From");
        endTimeLabel.setFont(new Font("nunito", 0, 14));
        endTimeLabel.setForeground(this.textColor);

        endTimeField= new IconTextField();
        endTimeField.setText("dd.mm.yyyy");
        endTimeField.setFont(new Font("nunito", 0, 15));
        endTimeField.setBackground(this.bgColor);
        endTimeField.setForeground(Color.BLACK);

        registerButton = new Button("Create Meeting", Color.WHITE, textColor, new Font("nunito", Font.PLAIN, 15) , 0);
        registerButton.setSize(200, 35);
        registerButton.setLocation(150, 420);

        formPanel.add(title);
        formPanel.add(jobPostIdLabel);
        formPanel.add(jobPostIdField);
        formPanel.add(eventNameLabel);
        formPanel.add(eventNameField);
        formPanel.add(eventTypeLabel);
        formPanel.add(eventType);
        formPanel.add(eventDate);
        formPanel.add(eventDateField);
        formPanel.add(endTimeLabel);
        formPanel.add(endTimeField);
        formPanel.add(registerButton);
        this.add(formPanel);
    }
}
