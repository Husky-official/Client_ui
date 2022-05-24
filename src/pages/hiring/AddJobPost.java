package src.pages.hiring;

import com.fasterxml.jackson.core.JsonProcessingException;
import src.client.ClientServerConnector;
import src.models.Hiring.JobPosting;
import src.models.*;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import src.components.shared.Button;
import src.pages.Home;
import src.utils.IconTextField;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class AddJobPost extends JPanel {
    private final Color textColor = Color.decode("#283A6D");
    private final Color bgColor = Color.decode("#F2F6FF");
    private IconTextField jobIdField, jobDescField, jobReqField, salaryField, salaryTypeField, locationField, startDateField, startTimeField, durationField, workersField;
    private JLabel jobId, errorLabel, jobDesc, jobReq, salary, salaryType, location, startDate, startTime, duration, workers;
    JButton submitData, viewJobPosts;

    JPanel contentPanel = new JPanel(new BorderLayout());
    JPanel headerPanel = new JPanel(new BorderLayout());
    JPanel bodyPanel = new JPanel(new GridBagLayout());
    JPanel formPanel = new JPanel();


    public AddJobPost() {
        this.setLayout(new BorderLayout());
        this.setBackground(this.bgColor);
        this.initUI();
    }

    public void initUI() {

        headerPanel.setPreferredSize(new Dimension(1000, 50));
        headerPanel.setBackground(this.bgColor);

//        bodyPanel.setLayout(new GridLayout(2, 1,2,2));
        bodyPanel.setPreferredSize(new Dimension(1000, 500));
        bodyPanel.setBackground(this.bgColor);

        JPanel headRightPanel = new JPanel(new GridLayout(1, 4, 30, 0));
        headRightPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 20));
        headRightPanel.setBackground(this.bgColor);
        JPanel headLeftPanel = new JPanel();
        headLeftPanel.setBorder(BorderFactory.createEmptyBorder(7, 20, 10, 5));
        headLeftPanel.setPreferredSize(new Dimension(500, 50));
        headLeftPanel.setBackground(this.bgColor);

//        viewJobPosts = new Button("View job posts", Color.WHITE, this.textColor,new Font("nunito", Font.BOLD, 18), 16, 80, 30,5 );
//        viewJobPosts.addMouseListener(new java.awt.event.MouseAdapter() {
//            public void mouseClicked(java.awt.event.MouseEvent evt) {
//                JobPostingPage jobPostingPage = new JobPostingPage();
//                jobPostingPage.setVisible(true);
//                Frame[] frames = Frame.getFrames();
//                for(Frame fr : frames){
//                    String specificFrameName = fr.getClass().getName();
//                    if(!specificFrameName.equals("src.pages.hiring.JobPostingPage")){
//                        if(fr.getSize().width > 600){
//                            jobPostingPage.setExtendedState(JFrame.MAXIMIZED_BOTH);
//                        }
//                        fr.dispose();
//                    }
//                }
//            }
//        });

        submitData = new Button("Submit", Color.WHITE, this.textColor,new Font("nunito", Font.BOLD, 18), 16, 80, 30,5 );
        submitData.addActionListener(evt -> {
                    System.out.println("Submit data button clicked");
                    String jobIdd = jobIdField.getText();
                    String jobDesc = jobDescField.getText();
                    String jobReq = jobReqField.getText();
                    String salarry = salaryField.getText();
                    String salaryType = salaryTypeField.getText();
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
                jobPosting.setSalaryType(salaryType);
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
                    salaryTypeField.setText("");
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
        JLabel breadCrumb = new JLabel("Hiric/Hiring/Job Posts");
        breadCrumb.setFont(new Font("nunito", Font.BOLD, 16));
        breadCrumb.setForeground(this.textColor);
        headLeftPanel.add(breadCrumb);
//        headRightPanel.add(viewJobPosts);
        headerPanel.add(headLeftPanel, BorderLayout.WEST);
        headerPanel.add(headRightPanel, BorderLayout.EAST);

        this.add(headerPanel, BorderLayout.NORTH);
        addUIComponents();

        contentPanel.add(headerPanel, BorderLayout.NORTH);
        contentPanel.add(bodyPanel, BorderLayout.CENTER);
        contentPanel.add(submitData, BorderLayout.SOUTH);
        this.add(contentPanel);

    }

    public void addUIComponents() {
        errorLabel = new JLabel("");
        errorLabel.setFont(new Font("nunito", Font.PLAIN, 15));
        errorLabel.setBackground(Color.WHITE);
        errorLabel.setForeground(Color.RED);
        errorLabel.setHorizontalAlignment(SwingConstants.CENTER);
        jobId = new JLabel("Job Id:");
        jobId.setFont(new Font("nunito", Font.PLAIN, 15));
        jobDesc = new JLabel("Job Description:");
        jobDesc.setFont(new Font("nunito", Font.PLAIN, 15));
        jobReq = new JLabel("Job Requirements:");
        jobReq.setFont(new Font("nunito", Font.PLAIN, 15));
        salary = new JLabel("Salary:");
        salary.setFont(new Font("nunito", Font.PLAIN, 15));
        salaryType = new JLabel("SalaryType:");
        salaryType.setFont(new Font("nunito", Font.PLAIN, 15));
        location = new JLabel("Location:");
        location.setFont(new Font("nunito", Font.PLAIN, 15));
        startDate = new JLabel("StartDate: ");
        startDate.setFont(new Font("nunito", Font.PLAIN, 15));
        startTime = new JLabel("StartTime: ");
        startTime.setFont(new Font("nunito", Font.PLAIN, 15));
        duration = new JLabel("Duration: ");
        duration.setFont(new Font("nunito", Font.PLAIN, 15));
        workers = new JLabel("Workers: ");
        workers.setFont(new Font("nunito", Font.PLAIN, 15));

        this.jobIdField = new IconTextField();
        jobIdField.setFont(new Font("nunito", Font.PLAIN, 15));
        this.jobIdField.setBackground(Color.WHITE);
        this.jobIdField.setPreferredSize(new Dimension(250, 30));
        this.jobIdField.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 5));

        this.jobDescField = new IconTextField();
        jobDescField.setFont(new Font("nunito", Font.PLAIN, 15));
        this.jobDescField.setBackground(Color.WHITE);
        this.jobDescField.setPreferredSize(new Dimension(250, 30));
        this.jobDescField.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 5));

        this.jobReqField = new IconTextField();
        jobReqField.setFont(new Font("nunito", Font.PLAIN, 15));
        this.jobReqField.setBackground(Color.WHITE);
        this.jobReqField.setPreferredSize(new Dimension(250, 30));
        this.jobReqField.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 5));

        this.salaryField = new IconTextField();
        salaryField.setFont(new Font("nunito", Font.PLAIN, 15));
        this.salaryField.setBackground(Color.WHITE);
        this.salaryField.setPreferredSize(new Dimension(250, 30));
        this.salaryField.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 5));

        this.salaryTypeField = new IconTextField();
        salaryTypeField.setFont(new Font("nunito", Font.PLAIN, 15));
        this.salaryTypeField.setBackground(Color.WHITE);
        this.salaryTypeField.setPreferredSize(new Dimension(250, 30));
        this.salaryTypeField.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 5));

        this.locationField = new IconTextField();
        locationField.setFont(new Font("nunito", Font.PLAIN, 15));
        this.locationField.setBackground(Color.WHITE);
        this.locationField.setPreferredSize(new Dimension(250, 30));
        this.locationField.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 5));

        this.startDateField = new IconTextField();
        startDateField.setFont(new Font("nunito", Font.PLAIN, 15));
        this.startDateField.setBackground(Color.WHITE);
        this.startDateField.setPreferredSize(new Dimension(250, 30));
        this.startDateField.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 5));

        this.startTimeField = new IconTextField();
        startTimeField.setFont(new Font("nunito", Font.PLAIN, 15));
        this.startTimeField.setBackground(Color.WHITE);
        this.startTimeField.setPreferredSize(new Dimension(250, 30));
        this.startTimeField.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 5));

        this.durationField = new IconTextField();
        durationField.setFont(new Font("nunito", Font.PLAIN, 15));
        this.durationField.setBackground(Color.WHITE);
        this.durationField.setPreferredSize(new Dimension(250, 30));
        this.durationField.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 5));

        this.workersField = new IconTextField();
        workersField.setFont(new Font("nunito", Font.PLAIN, 15));
        this.workersField.setBackground(Color.WHITE);
        this.workersField.setPreferredSize(new Dimension(250, 25));
        this.workersField.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 5));

        formPanel.setLayout(new GridLayout(15, 3,2,2));
        formPanel.setBackground(this.bgColor);

        formPanel.add(jobId);
        formPanel.add(jobIdField);

        formPanel.add(jobDesc);
        formPanel.add(jobDescField);

        formPanel.add(jobReq);
        formPanel.add(jobReqField);

        formPanel.add(salary);
        formPanel.add(salaryField);

        formPanel.add(salaryType);
        formPanel.add(salaryTypeField);

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

//        formPanel.add(submitData);

        bodyPanel.add(formPanel);
    }

    public void createJobPost() throws Exception {

    }

}