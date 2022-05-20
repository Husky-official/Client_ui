package src.pages.hiring;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import src.client.ClientServerConnector;
import src.models.Hiring.JobApplication;
import src.models.RequestBody;
import src.pages.layout.SideBar;
import src.utils.IconTextField;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JobApplicationView extends JFrame implements ActionListener {

    private final Color textColor = Color.decode("#283A6D");
    private final Color bgColor = Color.decode("#F2F6FF");

    JLabel jobPostLabel,text;
    JTextField jobPostField;
    JLabel userIdLabel, locationId,paymentMethod,referenceNameLabel,referencePhoneLabel,resumeLabel,certificateLabel;
    IconTextField userIdField, locationField,paymentMethodField,referenceNameField,referencePhoneField,resumeField,certificateField;

    JButton register;
    JPanel panel;

    public JobApplicationView() {
        this.setTitle("Hiric");
        createUIComponents();
        this.setSize(1000, 600);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.initUI();
        this.addActionEvent();
    }

    public void initUI() {
        JPanel contentPanel = new JPanel(new BorderLayout());
        JPanel headPanel = new JPanel(new BorderLayout());
        JPanel bodyPanel = new JPanel(new GridBagLayout());


        headPanel.setPreferredSize(new Dimension(0, 80));
        headPanel.setBackground(this.bgColor);
        bodyPanel.setBackground(this.bgColor);

        JPanel bodyContent = new JPanel();
        BoxLayout boxLayout = new BoxLayout(bodyContent, BoxLayout.Y_AXIS);
        JLabel text1 = new JLabel("Job Application Form");
        JLabel instructionText = new JLabel("Fill in the following fields!!");
        JPanel panel1 = new JPanel(new GridBagLayout());
        panel1.setBorder(BorderFactory.createEmptyBorder(5, 0, 0, 0));
        text1.setFont(new Font("nunito", Font.BOLD, 20));
        text1.setForeground(this.textColor);
        instructionText.setForeground(Color.GRAY);
        instructionText.setFont(new Font("nunito", 0, 15));
        panel1.add(text1);
        panel1.setBackground(this.bgColor);
        bodyContent.add(panel1);
        JPanel panel2 = new JPanel(new GridBagLayout());
        panel2.setBorder(BorderFactory.createEmptyBorder(0, 0, 25, 0));
        panel2.add(instructionText);
        panel2.setBackground(this.bgColor);
        bodyContent.add(panel2);
        createUIComponents();
        bodyContent.add(panel);


        bodyContent.setLayout(boxLayout);
        bodyContent.setBackground(this.bgColor);
        bodyPanel.setBackground(this.bgColor);
        bodyPanel.add(bodyContent);
        this.add(contentPanel);
        contentPanel.add(new SideBar(), BorderLayout.WEST);
        contentPanel.add(bodyPanel, BorderLayout.CENTER);

        this.add(contentPanel);
    }
        //application JP
        private void createUIComponents(){

            jobPostLabel = new JLabel("Job Post Id");
            jobPostField = new IconTextField();
            jobPostLabel.setFont(new Font("nunito", Font.PLAIN, 15));
            jobPostField.setPreferredSize(new Dimension(700,6));
            userIdLabel = new JLabel("User ID");
            userIdField = new IconTextField();
            userIdLabel.setFont(new Font("nunito", Font.PLAIN, 15));
            locationId = new JLabel("Location Id");
            locationField = new IconTextField();
            locationId.setFont(new Font("nunito", Font.PLAIN, 15));
            paymentMethod=new JLabel("Payment method:");
            paymentMethodField=new IconTextField();
            paymentMethod.setFont(new Font("nunito", Font.PLAIN, 15));
            referenceNameLabel=new JLabel("Reference Name");
            referenceNameField=new IconTextField();
            referenceNameLabel.setFont(new Font("nunito", Font.PLAIN, 15));
            referencePhoneLabel=new JLabel("Reference Phone");
            referencePhoneField=new IconTextField();
            referencePhoneLabel.setFont(new Font("nunito", Font.PLAIN, 15));
            resumeLabel=new JLabel("Resume");
            resumeField=new IconTextField();
            resumeLabel.setFont(new Font("nunito", Font.PLAIN, 15));
            certificateLabel=new JLabel("Certificate");
            certificateField=new IconTextField();
            certificateLabel.setFont(new Font("nunito", Font.PLAIN, 15));
            register = new JButton();
            this.register.setText("Apply Now");
            this.register.setBackground(this.textColor);
            this.register.setForeground(Color.WHITE);
            this.register.setFocusPainted(false);
            this.register.setFont(new Font("nunito", Font.PLAIN, 15));
            this.register.setFocusPainted(false);
            this.register.setBorderPainted(false);
            panel = new JPanel();
            panel.setLayout(new GridLayout(50, 1,3,3));
            panel.setBackground(this.bgColor);

            panel.add(jobPostLabel);
            panel.add(jobPostField);
            panel.add(userIdLabel);
            panel.add(userIdField);
            panel.add(locationId);
            panel.add(locationField);
            panel.add(paymentMethod);
            panel.add(paymentMethodField);
            panel.add(referenceNameLabel);
            panel.add(referenceNameField);
            panel.add(referencePhoneLabel);
            panel.add(referencePhoneField);
            panel.add(resumeLabel);
            panel.add(resumeField);
            panel.add(certificateLabel);
            panel.add(certificateField);
            panel.add(register);

        }
        public void addActionEvent(){
        register.addActionListener(this);
        }
    public static void main(String []args){
        new JobApplicationView();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==register){
            String jobPostId=jobPostField.getText();
            Integer jobId=Integer.parseInt(jobPostId);
            String userId=userIdField.getText();
            Integer userrId=Integer.parseInt(userId);
            String location=locationField.getText();
            Integer locId=Integer.parseInt(location);
            String payment=paymentMethodField.getText();
            String referencename=referenceNameField.getText();
            String referencePhone=referencePhoneField.getText();
            String resume=resumeField.getText();
            String certificate=certificateField.getText();
            try{
                JobApplication apply = new JobApplication();
                apply.setJobPostId(jobId);
                apply.setUserId(userrId);
                apply.setLocationId(locId);
                apply.setPaymentMethod(payment);
                apply.setReferenceName(referencename);
                apply.setReferencePhone(referencePhone);
                apply.setResume(resume);
                apply.setCertificate(certificate);


                RequestBody requestBody2= new RequestBody();
                requestBody2.setUrl("/createApplication");
                requestBody2.setAction("createApplication");
                requestBody2.setObject(apply);

                String requestString = new ObjectMapper().writeValueAsString(requestBody2);

                ClientServerConnector clientServerConnector = new ClientServerConnector();
                String response = clientServerConnector.connect(requestString);

                System.out.println("Response : " +response);

                ObjectMapper objectMapper = new ObjectMapper();
                JsonNode jsonResponse = objectMapper.readTree(response);

                int status = jsonResponse.get("status").asInt();
                String message = jsonResponse.get("message").asText();
                String actionDone = jsonResponse.get("actionToDo").asText();

            }catch (Exception ex){
                ex.printStackTrace();
            }
        }
    }
}
