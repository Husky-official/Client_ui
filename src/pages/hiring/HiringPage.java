package src.pages.hiring;

import src.components.shared.Button;
import src.pages.layout.SideBar;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class HiringPage extends JFrame {
    private final Color textColor = Color.decode("#283A6D");
    private final Color bgColor = Color.decode("#F2F6FF");
    private JPanel contentPanel;
    private JPanel bodyPanel;

    public HiringPage() {
        this.setTitle("HIRING | Hiric");
        this.setSize(1000, 600);
        this.initUI();
        this.setLocationRelativeTo((Component) null);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setIconImage(new ImageIcon(Objects.requireNonNull(getClass().getResource("/src/img/logo.png"))).getImage());
    }

    public void initUI() {
        contentPanel = new JPanel(new BorderLayout());
        bodyPanel = new JPanel(new GridBagLayout());


        bodyPanel.setBackground(Color.decode("#eaf5f9"));

        JButton jobPosting = new Button("Job Posts", Color.WHITE, this.textColor, new Font("nunito", Font.BOLD, 18), 16, 80, 30, 5);
        JButton jobApplication = new Button("Job Applications", Color.WHITE, this.textColor, new Font("nunito", Font.BOLD, 18), 16, 80, 30, 5);
        JButton shortListing = new Button("ShortListing", Color.WHITE, this.textColor, new Font("nunito", Font.BOLD, 18), 16, 80, 30, 5);
        JButton confirmAndCancel = new Button("Confirmation and Cancelling", Color.WHITE, this.textColor, new Font("nunito", Font.BOLD, 18), 16, 80, 30, 5);
        bodyPanel.add(jobPosting);
        bodyPanel.add(jobApplication);
        bodyPanel.add(shortListing);

        jobPosting.addMouseListener(new java.awt.event.MouseAdapter() {
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

        contentPanel.add(new SideBar(), BorderLayout.WEST);
        contentPanel.add(bodyPanel, BorderLayout.CENTER);

        this.add(contentPanel);
    }


    public static void main(String[] args) {
        new HiringPage();
    }
}