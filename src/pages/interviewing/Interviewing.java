package src.pages.interviewing;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import src.client.ClientServerConnector;
import src.models.EventScheduling;
import src.models.EventType;
import src.models.RequestBody;
import src.utils.IconTextField;
import src.components.shared.Button;
import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

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
    private JButton registerButton, addParticipantButton;
    private JPanel formPanel;
    private EventType eventTypes [] ={
            EventType.CALL, EventType.ONLINE_INTERVIEW, EventType.IN_PERSON_INTERVIEW
    };


    public Color getBgColor() {
        return bgColor;
    }

    public JLabel getTitle() {
        return title;
    }

    public void setTitle(JLabel title) {
        this.title = title;
    }

    public JLabel getJobPostIdLabel() {
        return jobPostIdLabel;
    }

    public void setJobPostIdLabel(JLabel jobPostIdLabel) {
        this.jobPostIdLabel = jobPostIdLabel;
    }

    public JLabel getEventNameLabel() {
        return eventNameLabel;
    }

    public void setEventNameLabel(JLabel eventNameLabel) {
        this.eventNameLabel = eventNameLabel;
    }

    public JLabel getEventDate() {
        return eventDate;
    }

    public void setEventDate(JLabel eventDate) {
        this.eventDate = eventDate;
    }

    public JLabel getEventTypeLabel() {
        return eventTypeLabel;
    }

    public void setEventTypeLabel(JLabel eventTypeLabel) {
        this.eventTypeLabel = eventTypeLabel;
    }

    public JLabel getStartTimeLabel() {
        return startTimeLabel;
    }

    public void setStartTimeLabel(JLabel startTimeLabel) {
        this.startTimeLabel = startTimeLabel;
    }

    public JLabel getEndTimeLabel() {
        return endTimeLabel;
    }

    public void setEndTimeLabel(JLabel endTimeLabel) {
        this.endTimeLabel = endTimeLabel;
    }

    public IconTextField getJobPostIdField() {
        return jobPostIdField;
    }

    public void setJobPostIdField(IconTextField jobPostIdField) {
        this.jobPostIdField = jobPostIdField;
    }

    public IconTextField getEventNameField() {
        return eventNameField;
    }

    public void setEventNameField(IconTextField eventNameField) {
        this.eventNameField = eventNameField;
    }

    public IconTextField getEventDateField() {
        return eventDateField;
    }

    public void setEventDateField(IconTextField eventDateField) {
        this.eventDateField = eventDateField;
    }

    public IconTextField getStartTimeField() {
        return startTimeField;
    }

    public void setStartTimeField(IconTextField startTimeField) {
        this.startTimeField = startTimeField;
    }

    public IconTextField getEndTimeField() {
        return endTimeField;
    }

    public void setEndTimeField(IconTextField endTimeField) {
        this.endTimeField = endTimeField;
    }

    public JComboBox getEventType() {
        return eventType;
    }

    public void setEventType(JComboBox eventType) {
        this.eventType = eventType;
    }

    public JButton getReset() {
        return reset;
    }

    public void setReset(JButton reset) {
        this.reset = reset;
    }

    public JButton getRegisterButton() {
        return registerButton;
    }

    public void setRegisterButton(JButton registerButton) {
        this.registerButton = registerButton;
    }

    public JPanel getFormPanel() {
        return formPanel;
    }

    public void setFormPanel(JPanel formPanel) {
        this.formPanel = formPanel;
    }

    public EventType[] getEventTypes() {
        return eventTypes;
    }

    public void setEventTypes(EventType[] eventTypes) {
        this.eventTypes = eventTypes;
    }

    public void initUI(){

        JPanel headPanel = new JPanel(new BorderLayout());

        headPanel.setPreferredSize(new Dimension(0, 80));
        headPanel.setBackground(this.bgColor);

//        bodyPanel.setBackground(this.bgColor);
        JPanel headRightPanel = new JPanel(new GridLayout(1, 2, 15, 0));
        JPanel headLeftPanel = new JPanel(new GridLayout(1, 1, 10, 3));
        headRightPanel.setBackground(this.bgColor);
        headLeftPanel.setBackground(this.bgColor);

        headRightPanel.setBorder(BorderFactory.createEmptyBorder(20, 5, 20, 50));
        headLeftPanel.setBorder(BorderFactory.createEmptyBorder(20, 50, 20, 5));


        //create a button to add participants
        this.addParticipantButton = new Button("+ Add Participants", Color.WHITE, textColor, new Font("nunito", Font.BOLD, 20), 2);
//        JPanel addParticipantPanel = new JPanel(new GridLayout(1, 1, 1, 0));

        formPanel = new JPanel(new GridLayout(15, 1, 7, 2));
        formPanel.setBackground(this.bgColor);
        formPanel.setPreferredSize(new Dimension(600, 600));

        title = new JLabel("Schedule a Meeting");
        title.setFont(new Font("nunito", Font.BOLD, 25));
        title.setForeground(this.textColor);

        jobPostIdLabel = new JLabel("Job Post ID");
        jobPostIdLabel.setFont(new Font("nunito", 0, 14));
        jobPostIdLabel.setForeground(this.textColor);

        jobPostIdField = new IconTextField();
        jobPostIdField.setFont(new Font("nunito", 0, 15));
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
        eventType.setBackground(this.bgColor);

        eventDate = new JLabel("Event date (dd.mm.yyyy)");
        eventDate.setFont(new Font("nunito", 0, 14));
        eventDate.setForeground(this.textColor);

        eventDateField = new IconTextField();
        eventDateField.setFont(new Font("nunito", 0, 15));
        eventDateField.setBackground(this.bgColor);
        eventDateField.setForeground(Color.BLACK);

        startTimeLabel = new JLabel("From (hh:mm:ss)");
        startTimeLabel.setFont(new Font("nunito", 0, 14));
        startTimeLabel.setForeground(this.textColor);

        startTimeField= new IconTextField();
        startTimeField.setFont(new Font("nunito", 0, 15));
        startTimeField.setBackground(this.bgColor);
        startTimeField.setForeground(Color.BLACK);

        endTimeLabel = new JLabel("To (hh:mm:ss)");
        endTimeLabel.setFont(new Font("nunito", 0, 14));
        endTimeLabel.setForeground(this.textColor);

        endTimeField= new IconTextField();
        endTimeField.setFont(new Font("nunito", 0, 15));
        endTimeField.setBackground(this.bgColor);
        endTimeField.setForeground(Color.BLACK);

        registerButton = new Button("Create Meeting", Color.WHITE, textColor, new Font("nunito", Font.PLAIN, 15) , 0);
        registerButton.setSize(200, 35);
        registerButton.setLocation(150, 420);
        registerButton.setActionCommand("scheduleMeeting");

        // adding components on main panel
        formPanel.add(title);
        this.add(headRightPanel);
        this.add(headLeftPanel);
        formPanel.add(jobPostIdLabel);
        formPanel.add(jobPostIdField);
        formPanel.add(eventNameLabel);
        formPanel.add(eventNameField);
        formPanel.add(eventTypeLabel);
        formPanel.add(eventType);
        formPanel.add(eventDate);
        formPanel.add(eventDateField);
        formPanel.add(startTimeLabel);
        formPanel.add(startTimeField);
        formPanel.add(endTimeLabel);
        formPanel.add(endTimeField);
        formPanel.add(registerButton);

        headRightPanel.add(addParticipantButton);
        headLeftPanel.add(title);
        headPanel.add(headLeftPanel, "West");
        headPanel.add(headRightPanel, "East");
        this.add(headPanel, "North");
        this.add(formPanel);

        //add participants button events

        this.addParticipantButton.addMouseListener(new java.awt.event.MouseAdapter(){
            public void mouseClicked(java.awt.event.MouseEvent evt){
                AddParticipantPage addParticipantPage= new AddParticipantPage();
                addParticipantPage.setVisible(true);
                Frame[] frames = Frame.getFrames();

                for (Frame fr : frames) {
                    String specificFrameName = fr.getClass().getName();
                    if (!specificFrameName.equals("src.pages.interviewing.AddParticipantPage")) {
                        if (fr.getSize().width > 600) {
                            addParticipantPage.setExtendedState(JFrame.MAXIMIZED_BOTH);
                        }
                        fr.dispose();
                    }
                }
            }
        });
        //add form button events
        this.registerButton.addActionListener(e -> {
//            System.out.println("Create Meeting button clicked");
            if (e.getSource() == registerButton){
                String jobId = jobPostIdField.getText();
                String eventName = eventNameField.getText();
                String date = eventDateField.getText();
                String time =startTimeField.getText();
                String time1 =endTimeField.getText();

                if(jobId.equals("")|| eventName.equals("")||date.equals("")||time.equals("")||time1.equals("")){
                    JOptionPane.showMessageDialog(null, "Please fill all the fields", "Error", JOptionPane.ERROR_MESSAGE);
                }

                Integer jobPostId = Integer.parseInt(jobId);
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
                LocalDate evenDate = LocalDate.parse(date, formatter);
                java.sql.Date eventDate = java.sql.Date.valueOf(evenDate);
                DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("HH:mm:ss");
                LocalTime starTime = LocalTime.parse(time, formatter1);
                java.sql.Time startTime = java.sql.Time.valueOf(starTime);
                DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("HH:mm:ss");
                LocalTime enTime = LocalTime.parse(time1, formatter2);
                java.sql.Time endTime = java.sql.Time.valueOf(enTime);

                // Sending request to the server
                try{
                    EventScheduling eventScheduling = new EventScheduling();
                    eventScheduling.setJobPostId(jobPostId);
                    eventScheduling.setEventName(eventName);
                    eventScheduling.setEventType(EventType.ONLINE_INTERVIEW);
                    eventScheduling.setEventDate(eventDate);
                    eventScheduling.setStartTime(startTime);
                    eventScheduling.setEndTime(endTime);
                    eventScheduling.setEventCreator(1);

                    RequestBody requestBody = new RequestBody();
                    requestBody.setUrl("/eventScheduling");
                    requestBody.setAction("scheduleEvent");
                    requestBody.setObject(eventScheduling);

                    String requestString = new ObjectMapper().writeValueAsString(requestBody);
                    // sending object to server
                    ClientServerConnector clientServerConnector = new ClientServerConnector();
                    String response = clientServerConnector.connect(requestString);

                    ObjectMapper objectMapper = new ObjectMapper();
                    JsonNode jsonResponse = objectMapper.readTree(response);

                    JOptionPane.showMessageDialog(null, "Scheduled a meeting Successfully");
                    jobPostIdField.setText(" ");
                    eventNameField.setText(" ");
                    eventDateField.setText(" ");
                    startTimeField.setText(" ");
                    endTimeField.setText(" ");
                }catch (Exception ex){
                    ex.getMessage();
                }
            }
        });

    }

}
