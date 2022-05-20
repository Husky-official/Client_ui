package src.pages.interviewing;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import src.client.ClientServerConnector;
import src.models.EventScheduling;
import src.models.EventType;
import src.models.RequestBody;
import src.pages.layout.SideBar;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class InterviewingPage extends JFrame implements ActionListener {
    private JPanel contentPanel;
    private JPanel bodyPanel;
    private Interviewing interviewing = new Interviewing();
    public InterviewingPage(){
        this.setTitle("Interviewing | Hiric");
        this.setSize(1000, 600);
        this.initUI();
        this.setLocationRelativeTo((Component) null);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setIconImage(new ImageIcon(Objects.requireNonNull(getClass().getResource("/src/img/logo.png"))).getImage());
    }
    public void initUI(){
        contentPanel = new JPanel(new BorderLayout());
        bodyPanel = new JPanel(new GridBagLayout());

        bodyPanel.setBackground(Color.decode("#eaf5f9"));
        bodyPanel.add(new Interviewing());

        contentPanel.add(new SideBar(), BorderLayout.WEST);
        contentPanel.add(bodyPanel, BorderLayout.CENTER);

        this.add(contentPanel);
    }
    public static void main(String[] args){
        new InterviewingPage();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("scheduleMeeting")){
            String jobId = interviewing.getJobPostIdField().getText();
            Integer jobPostId = Integer.parseInt(jobId);
            String eventName = interviewing.getEventNameField().getText();
            String date = interviewing.getEventDateField().getText();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
            LocalDate evenDate = LocalDate.parse(date, formatter);
            java.sql.Date eventDate = java.sql.Date.valueOf(evenDate);
            String time = interviewing.getStartTimeField().getText();
            DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("HH:mm:ss");
            LocalTime starTime = LocalTime.parse(time, formatter1);
            java.sql.Time startTime = java.sql.Time.valueOf(starTime);
            String time1 = interviewing.getEndTimeField().getText();
            DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("HH:mm:ss");
            LocalTime enTime = LocalTime.parse(time1, formatter2);
            java.sql.Time endTime = java.sql.Time.valueOf(enTime);
            if(jobId.equals(" ")|| eventName.equals(" ")||date.equals(" ")||time.equals(" ")||time1.equals(" ")){
                JOptionPane.showMessageDialog(null, "Please fill all the fields", "Error", JOptionPane.ERROR_MESSAGE);
            }

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

        }catch (Exception ex){
                ex.getMessage();
            }
            }
    }
}
