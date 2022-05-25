package src.pages.hiring;

import src.pages.dashboard.Dashboard;
import src.pages.dashboard.DashboardPage;
import src.pages.layout.SideBar;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class JobPostingPage extends JFrame {
    private JPanel contentPanel;
    private JPanel bodyPanel;

    public JobPostingPage() {
        this.setTitle("JOB POSTS | Hiric");
        this.setSize(1000, 600);
        this.initUI();
        this.setLocationRelativeTo((Component)null);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setIconImage(new ImageIcon(Objects.requireNonNull(getClass().getResource("/src/img/logo.png"))).getImage());
    }

    public void initUI(){
        contentPanel = new JPanel(new BorderLayout());
        bodyPanel = new JPanel(new GridBagLayout());


        bodyPanel.setBackground(Color.decode("#eaf5f9"));
        bodyPanel.add(new AddJobPostPage());

        contentPanel.add(new SideBar(), BorderLayout.WEST);
        contentPanel.add(bodyPanel);

        this.add(contentPanel);
    }


    public static void main(String[] args) {
        new JobPostingPage();
    }
}