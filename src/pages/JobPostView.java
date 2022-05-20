package src.pages;

import src.client.*;
import src.models.*;
import src.models.Hiring.*;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import src.pages.layout.SideBar;


import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class JobPostView extends JFrame{
    private final Color textColor = Color.decode("#283A6D");
    private final Color bgColor = Color.decode("#F2F6FF");
    private JButton registerButton;
    private JButton loginButton;


    public JobPostView() throws Exception {
        this.setTitle("Job Posting | Hiric");
        this.setSize(1000, 600);
        this.setLocationRelativeTo((Component) null);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.initUI();
    }

    public static JobPosting[] getJobPosts() throws Exception {
        RequestBody requestBody = new RequestBody();
        requestBody.setUrl("/jobPost");
        requestBody.setAction("getJobPosts");

        String requestString = new ObjectMapper().writeValueAsString(requestBody);

        ClientServerConnector clientServerConnector = new ClientServerConnector();
        String response = clientServerConnector.connect(requestString);

        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode res = objectMapper.readTree(response);

        ObjectMapper objectMapper1 = new ObjectMapper();
        JsonNode jsonResponse = objectMapper1.readTree(response);
        JsonNode jsonNode = objectMapper1.readTree(String.valueOf(jsonResponse.get("object")));
        JobPosting[] jobPosts = objectMapper1.treeToValue(jsonNode, JobPosting[].class);

        return jobPosts;
    }

    public void initUI() throws Exception {
        this.setIconImage(new ImageIcon(Objects.requireNonNull(getClass().getResource("/src/img/logo.png"))).getImage());
        JPanel contentPanel = new JPanel(new BorderLayout());
        JPanel bodyPanel = new JPanel(new GridBagLayout());
        bodyPanel.setBackground(this.bgColor);
        JPanel bodyContent = new JPanel();
        BoxLayout boxLayout = new BoxLayout(bodyContent, BoxLayout.Y_AXIS);
        SideBar sideBar = new SideBar();
        JTable jobPosts;

        String[][] data = {
                { "Kundan Kumar Jha", "4031", "CSE" },
                { "Anand Jha", "6014", "IT" }
        };

        String[] columnNames = { "Name", "Roll Number", "Department" };

        jobPosts = new JTable(data, columnNames);

        JScrollPane sp = new JScrollPane(jobPosts);



        JLabel responseFromServer = new JLabel();
        JLabel random = new JLabel("some random text");
        random.setFont(new Font("nunito", Font.BOLD, 30));
        random.setForeground(this.textColor);
        responseFromServer.setFont(new Font("nunito", Font.BOLD, 30));
        responseFromServer.setForeground(this.textColor);
//        for (JobPosting jobPost : jobPosts) {
//            System.out.println(jobPost.jobDesc);
//            responseFromServer.setText(jobPost.jobDesc);
//        }

        JLabel copyright = new JLabel("Copyright 2022 @husky | All Right Reserved.");
        copyright.setFont(new Font("nunito", Font.ITALIC, 15));
        copyright.setForeground(Color.GRAY);

        JPanel footer = new JPanel(new GridBagLayout());
        if (this.getSize().height == 600) {
            footer.setBorder(BorderFactory.createEmptyBorder(235, 0, 0, 0));
        }

        JPanel panel1 = new JPanel(new GridBagLayout());
        panel1.setBorder(BorderFactory.createEmptyBorder(60, 0, 3, 0));
        panel1.add(responseFromServer);
        panel1.add(random);
        panel1.setBackground(this.bgColor);
        bodyContent.add(panel1);

        footer.add(copyright);
        footer.setBackground(this.bgColor);
        bodyContent.add(footer);

        bodyContent.setLayout(boxLayout);
        bodyContent.setBackground(this.bgColor);
        bodyPanel.setBackground(this.bgColor);
        bodyPanel.add(bodyContent);
        contentPanel.add(bodyPanel, "Center");
        this.add(sideBar);
        this.add(contentPanel);
    }

    public static void main(String[] args) throws Exception {
        new JobPostView();
    }

}
