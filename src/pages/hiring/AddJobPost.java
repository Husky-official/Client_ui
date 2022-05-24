package src.pages.hiring;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import src.client.ClientServerConnector;
import src.models.Hiring.JobPosting;
import src.models.RequestBody;
import src.utils.IconTextField;
import src.components.shared.Button;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Objects;

public class AddJobPost extends JPanel {
    private final Color textColor = Color.decode("#283A6D");
    private final Color bgColor = Color.decode("#F2F6FF");

    public AddJobPost() {
        this.setLayout(new BorderLayout());
        this.setBackground(this.bgColor);
        this.initUI();
    }

    private IconTextField jobIdField, jobDescField, jobReqField, salaryField, locationField, startDateField, startTimeField, durationField, workersField;
    private JLabel title, jobId, errorLabel, jobDesc, jobReq, salary, salaryType, location, startDate, startTime, duration, workers;
    private JComboBox selectSalaryType;
    private JButton reset;
    private JButton registerButton, viewJobPostsButton;
    private JPanel formPanel;
    Object[] salaryTypes = {
            "DYNAMIC", "STATIC"
    };
    public void initUI(){

        JPanel headPanel = new JPanel(new BorderLayout());

        headPanel.setPreferredSize(new Dimension(0, 80));
        headPanel.setBackground(this.bgColor);

        JPanel headRightPanel = new JPanel(new GridLayout(1, 2, 15, 0));
        JPanel headLeftPanel = new JPanel(new GridLayout(1, 1, 10, 3));
        headRightPanel.setBackground(this.bgColor);
        headLeftPanel.setBackground(this.bgColor);

        headRightPanel.setBorder(BorderFactory.createEmptyBorder(20, 5, 20, 50));
        headLeftPanel.setBorder(BorderFactory.createEmptyBorder(20, 50, 20, 5));


        //create a button to add participants
        this.viewJobPostsButton = new Button("View Job Posts", Color.WHITE, textColor, new Font("nunito", Font.BOLD, 20), 2);

        formPanel = new JPanel(new GridLayout(22, 1, 7, 2));
        formPanel.setBackground(this.bgColor);
        formPanel.setPreferredSize(new Dimension(600, 600));

        title = new JLabel("Post a Job");
        title.setFont(new Font("nunito", Font.BOLD, 25));
        title.setForeground(this.textColor);

        jobId = new JLabel("Job");
        jobId.setFont(new Font("nunito", 0, 14));
        jobId.setForeground(this.textColor);

        jobIdField = new IconTextField();
        jobIdField.setFont(new Font("nunito", 0, 15));
        jobIdField.setBackground(Color.WHITE);
        jobIdField.setForeground(Color.BLACK);

        jobDesc = new JLabel("Job Description");
        jobDesc.setFont(new Font("nunito", 0, 14));
        jobDesc.setForeground(this.textColor);

        jobDescField = new IconTextField();
        jobDescField.setFont(new Font("nunito", 0, 15));
        jobDescField.setBackground(Color.WHITE);
        jobDescField.setForeground(Color.BLACK);

        jobReq = new JLabel("Job Requirements");
        jobReq.setFont(new Font("nunito", 0, 14));
        jobReq.setForeground(this.textColor);

        jobReqField = new IconTextField();
        jobReqField.setFont(new Font("nunito", 0, 15));
        jobReqField.setBackground(Color.WHITE);
        jobReqField.setForeground(Color.BLACK);

        salary = new JLabel("Salary");
        salary.setFont(new Font("nunito", 0, 14));
        salary.setForeground(this.textColor);

        salaryField = new IconTextField();
        salaryField.setFont(new Font("nunito", 0, 15));
        salaryField.setBackground(Color.WHITE);
        salaryField.setForeground(Color.BLACK);

        salaryType = new JLabel("Salary Type");
        salaryType.setFont(new Font("nunito", 0, 14));
        salaryType.setForeground(this.textColor);

        selectSalaryType = new JComboBox(salaryTypes);
        selectSalaryType.setFont(new Font("nunito", Font.PLAIN, 15));
        selectSalaryType.setBackground(Color.WHITE);

        location = new JLabel("Location");
        location.setFont(new Font("nunito", 0, 14));
        location.setForeground(this.textColor);

        locationField = new IconTextField();
        locationField.setFont(new Font("nunito", 0, 15));
        locationField.setBackground(Color.WHITE);
        locationField.setForeground(Color.BLACK);

        startDate = new JLabel("Start Date (dd.mm.yyyy)");
        startDate.setFont(new Font("nunito", 0, 14));
        startDate.setForeground(this.textColor);

        startDateField = new IconTextField();
        startDateField.setFont(new Font("nunito", 0, 15));
        startDateField.setBackground(Color.WHITE);
        startDateField.setForeground(Color.BLACK);

        startTime = new JLabel("Start Time (hh:mm:ss)");
        startTime.setFont(new Font("nunito", 0, 14));
        startTime.setForeground(this.textColor);

        startTimeField= new IconTextField();
        startTimeField.setFont(new Font("nunito", 0, 15));
        startTimeField.setBackground(Color.WHITE);
        startTimeField.setForeground(Color.BLACK);

        duration = new JLabel("Duration");
        duration.setFont(new Font("nunito", 0, 14));
        duration.setForeground(this.textColor);

        durationField= new IconTextField();
        durationField.setFont(new Font("nunito", 0, 15));
        durationField.setBackground(Color.WHITE);
        durationField.setForeground(Color.BLACK);

        workers = new JLabel("Workers");
        workers.setFont(new Font("nunito", 0, 14));
        workers.setForeground(this.textColor);

        workersField= new IconTextField();
        workersField.setFont(new Font("nunito", 0, 15));
        workersField.setBackground(Color.WHITE);
        workersField.setForeground(Color.BLACK);

        registerButton = new Button("Create Post", Color.WHITE, textColor, new Font("nunito", Font.PLAIN, 15) , 0);
        registerButton.setSize(200, 35);
        registerButton.setLocation(150, 420);
        registerButton.setActionCommand("scheduleMeeting");

        // adding components on main panel
        formPanel.add(title);
        this.add(headRightPanel);
        this.add(headLeftPanel);
        formPanel.add(jobId);
        formPanel.add(jobIdField);
        formPanel.add(jobDesc);
        formPanel.add(jobDescField);
        formPanel.add(jobReq);
        formPanel.add(jobReqField);
        formPanel.add(salary);
        formPanel.add(salaryField);
        formPanel.add(salaryType);
        formPanel.add(selectSalaryType);
        formPanel.add(location);
        formPanel.add(locationField);
        formPanel.add(startDate);
        formPanel.add(startDateField);
        formPanel.add(startTime);
        formPanel.add(startTimeField);
        formPanel.add(duration);
        formPanel.add(durationField);
        formPanel.add(workers);
        formPanel.add(workersField);
        formPanel.add(registerButton);

        headRightPanel.add(viewJobPostsButton);
        headLeftPanel.add(title);
        headPanel.add(headLeftPanel, "West");
        headPanel.add(headRightPanel, "East");
        this.add(headPanel, "North");
        this.add(formPanel);

        //add participants button events

        this.viewJobPostsButton.addMouseListener(new java.awt.event.MouseAdapter(){
            public void mouseClicked(java.awt.event.MouseEvent evt){
                ViewJobPostsPage viewJobPostsPage= new ViewJobPostsPage();
                viewJobPostsPage.setVisible(true);
                Frame[] frames = Frame.getFrames();

                for (Frame fr : frames) {
                    String specificFrameName = fr.getClass().getName();
                    if (!specificFrameName.equals("src.pages.interviewing.ViewJobPosts")) {
                        if (fr.getSize().width > 600) {
                            viewJobPostsPage.setExtendedState(JFrame.MAXIMIZED_BOTH);
                        }
                        fr.dispose();
                    }
                }
            }
        });
        //add form button events
        this.registerButton.addActionListener(evt -> {
                    System.out.println("Submit data button clicked");
                    String jobIdd = jobIdField.getText();
                    String jobDesc = jobDescField.getText();
                    String jobReq = jobReqField.getText();
                    String salarry = salaryField.getText();
                    String loc = locationField.getText();
                    String date = startDateField.getText();
                    String stime = startTimeField.getText();
                    String duration = durationField.getText();
                    String work = workersField.getText();


                    if (jobIdd.equals("") || jobDesc.equals("") || jobReq.equals("") || salarry.equals("") || salaryType.equals("") || loc.equals("") || date.equals("") || stime.equals("") || duration.equals("") || work.equals("")) {
                        JOptionPane.showMessageDialog(null,"Please fill all the fields","Error",JOptionPane.ERROR_MESSAGE);
                    }
                    Integer jobId = Integer.parseInt(jobIdd);
                    Integer salary = Integer.parseInt(salarry);
                    Integer location = Integer.parseInt(loc);
                    Integer workers = Integer.parseInt(work);

                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MM yyyy");
                    LocalDate starDate = LocalDate.parse(date, formatter);
                    java.sql.Date startDate = java.sql.Date.valueOf(starDate);

                    DateTimeFormatter formattter = DateTimeFormatter.ofPattern("HH mm ss");
                    LocalTime starTime = LocalTime.parse(stime, formattter);
                    java.sql.Time startTime = java.sql.Time.valueOf(starTime);
                    try {
                        JobPosting jobPosting = new JobPosting();
                        jobPosting.setUserId(1);
                        jobPosting.setJobId(jobId);
                        jobPosting.setJobDesc(jobDesc);
                        jobPosting.setJobRequirements(jobReq);
                        jobPosting.setLocation(location);
                        jobPosting.setStartDate(startDate);
                        jobPosting.setStartTime(startTime);
                        jobPosting.setDuration(duration);
                        jobPosting.setSalary(salary);
                        jobPosting.setSalaryType("DYNAMIC");
                        jobPosting.setWorkers(workers);
                        RequestBody requestBody = new RequestBody();
                        requestBody.setUrl("/jobPost");
                        requestBody.setAction("createJobPost");
                        requestBody.setObject(jobPosting);
                        String requestString = new ObjectMapper().writeValueAsString(requestBody);
                        System.out.println(requestString);
                        ClientServerConnector clientServerConnector = new ClientServerConnector();
                        String response = clientServerConnector.connect(requestString);

                        ObjectMapper objectMapper = new ObjectMapper();
                        JsonNode jsonResponse = objectMapper.readTree(response);
                        String message = jsonResponse.get("message").asText();
                        System.out.println(message);
                        if(Objects.equals(message, "Posted Job Successfully")){
                            JOptionPane.showMessageDialog(null,"Posted successfully!");
                            jobIdField.setText("");
                            jobDescField.setText("");
                            jobReqField.setText("");
                            salaryField.setText("");
                            locationField.setText("");
                            startDateField.setText("");
                            startTimeField.setText("");
                            durationField.setText("");
                            workersField.setText("");
                        }
                        else{
                            JOptionPane.showMessageDialog(null,"Unable to post the job!");
                        }
                    }catch (IOException e1) {
                        e1.printStackTrace();
                    }
                }
        );

    }

}