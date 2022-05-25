package src.pages.hiring;

import src.utils.IconTextField;
import javax.swing.*;
import java.awt.*;

public class ViewJobPosts extends JPanel{
    private final Color textColor = Color.decode("#283A6D");
    private final Color bgColor = Color.decode("#F2F6FF");

    public ViewJobPosts() {
        this.setLayout(new BorderLayout());
        this.setBackground(this.bgColor);
        this.initUI();
    }

    private IconTextField searchField;
    private JLabel title, location, jobDesc, jobReq, startDate, startTime, salary, salaryType, duration, workers;
    private JButton createButton, applyButton;
    private JPanel bodyPanel, cardPanel;
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

        this.createButton = new src.components.shared.Button("+ Create a Job Post", Color.WHITE, textColor, new Font("nunito", Font.BOLD, 20), 2);
        this.applyButton = new src.components.shared.Button("Apply for this job", Color.WHITE, textColor, new Font("nunito", Font.BOLD, 20), 2);
        bodyPanel = new JPanel();
        bodyPanel.setLayout(new GridLayout());
        bodyPanel.setBackground(this.bgColor);
        bodyPanel.setPreferredSize(new Dimension(1150, 600));

        title = new JLabel("Job Posts");
        title.setFont(new Font("nunito", Font.BOLD, 25));
        title.setForeground(this.textColor);

        cardPanel = new JPanel( new GridLayout(15,1,0,0));
        cardPanel.setBackground(Color.red);
        cardPanel.setPreferredSize(new Dimension(10, 100));

        location = new JLabel("Location: ");
        location.setFont(new Font("nunito", Font.BOLD, 15));
        location.setForeground(Color.BLACK);

        startDate = new JLabel("Start Date: ");
        startDate.setFont(new Font("nunito", Font.BOLD, 15));
        startDate.setForeground(Color.BLACK);

        startTime = new JLabel("Start Time: ");
        startTime.setFont(new Font("nunito", Font.BOLD, 15));
        startTime.setForeground(Color.BLACK);

        jobReq = new JLabel("Job Requirements: ");
        jobReq.setFont(new Font("nunito", Font.BOLD, 15));
        jobReq.setForeground(Color.BLACK);

        jobDesc = new JLabel("Job Description: ");
        jobDesc.setFont(new Font("nunito", Font.BOLD, 15));
        jobDesc.setForeground(Color.BLACK);

        salary = new JLabel("Salary: ");
        salary.setFont(new Font("nunito", Font.BOLD, 15));
        salary.setForeground(Color.BLACK);

        salaryType = new JLabel("Payment: ");
        salaryType.setFont(new Font("nunito", Font.BOLD, 15));
        salaryType.setForeground(Color.BLACK);

        duration = new JLabel("Duration: ");
        duration.setFont(new Font("nunito", Font.BOLD, 15));
        duration.setForeground(Color.BLACK);

        workers = new JLabel("Workers: ");
        workers.setFont(new Font("nunito", Font.BOLD, 15));
        workers.setForeground(Color.BLACK);

        cardPanel.add(location);
        cardPanel.add(jobDesc);
        cardPanel.add(jobReq);
        cardPanel.add(startDate);
        cardPanel.add(startTime);
        cardPanel.add(salary);
        cardPanel.add(salaryType);
        cardPanel.add(duration);
        cardPanel.add(workers);



        bodyPanel.add(title);
        bodyPanel.add(cardPanel);
        this.add(headRightPanel);
        this.add(headLeftPanel);

        headRightPanel.add(createButton);
        headLeftPanel.add(title);
        headPanel.add(headLeftPanel, "West");
        headPanel.add(headRightPanel, "East");
        this.add(headPanel, "North");
        this.add(bodyPanel);

        this.createButton.addMouseListener(new java.awt.event.MouseAdapter(){
            public void mouseClicked(java.awt.event.MouseEvent evt){
                AddJobPostPage addJobPostPage= new AddJobPostPage();
                addJobPostPage.setVisible(true);
                Frame[] frames = Frame.getFrames();

                for (Frame fr : frames) {
                    String specificFrameName = fr.getClass().getName();
                    if (!specificFrameName.equals("src.pages.interviewing.AddJobPostPage")) {
                        if (fr.getSize().width > 600) {
                            addJobPostPage.setExtendedState(JFrame.MAXIMIZED_BOTH);
                        }
                        fr.dispose();
                    }
                }
            }
        });
        //add form button events
        this.applyButton.addActionListener(evt -> {
                    System.out.println("apply button clicked");
                }
        );

    }

    public static void main(String[] args) {
        new ViewJobPosts();
    }

}