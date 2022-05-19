package src.pages.hiring;

import src.components.shared.Button;

import javax.swing.*;
import java.awt.*;

public class JobPosting extends JPanel{
    private final Color textColor = Color.decode("#283A6D");
    private final Color bgColor = Color.decode("#F2F6FF");
    JPanel contentPanel = new JPanel(new BorderLayout());
    JPanel headerPanel = new JPanel(new BorderLayout());

    public JobPosting() {
        this.setLayout(new BorderLayout());
        this.setBackground(this.bgColor);
        this.initUI();
    }

    public void initUI() {

        headerPanel.setPreferredSize(new Dimension(1000, 50));
        headerPanel.setBackground(this.bgColor);

        JPanel headRightPanel = new JPanel(new GridLayout(1, 4, 30, 0));
        headRightPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 20));
        headRightPanel.setBackground(this.bgColor);
        JPanel headLeftPanel = new JPanel();
        headLeftPanel.setBorder(BorderFactory.createEmptyBorder(7, 20, 10, 5));
        headLeftPanel.setPreferredSize(new Dimension(500, 50));
        headLeftPanel.setBackground(this.bgColor);
        JPanel bodyPanel = new JPanel(new GridBagLayout());
//
        JButton addJobPost = new Button("+ Post a job", Color.WHITE, this.textColor,new Font("nunito", Font.BOLD, 18), 16, 80, 30,5 );
        addJobPost.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JobPostingPage jobPostingPage = new JobPostingPage();
                jobPostingPage.setVisible(true);
                Frame[] frames = Frame.getFrames();
                for(Frame fr : frames){
                    String specificFrameName = fr.getClass().getName();
                    if(!specificFrameName.equals("src.pages.hiring.JobPostingPage")){
                        if(fr.getSize().width > 600){
                            jobPostingPage.setExtendedState(JFrame.MAXIMIZED_BOTH);
                        }
                        fr.dispose();
                    }
                }
            }
        });
        JLabel breadCrumb = new JLabel("Hiric/Hiring/Job Posts");
        breadCrumb.setFont(new Font("nunito", Font.BOLD, 16));
        breadCrumb.setForeground(this.textColor);
        headLeftPanel.add(breadCrumb);
        headRightPanel.add(addJobPost);
        headerPanel.add(headLeftPanel, BorderLayout.WEST);
        headerPanel.add(headRightPanel, BorderLayout.EAST);
        contentPanel.add(headerPanel, BorderLayout.NORTH);
        this.add(headerPanel, BorderLayout.NORTH);

//        JLabel text = new JLabel("job posting");
//        text.setFont(new Font("nunito", Font.BOLD, 25));
//        text.setForeground(this.textColor);
//        this.add(text, BorderLayout.NORTH);
    }

}