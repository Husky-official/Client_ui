package src.pages.layout;

import src.pages.messaging.MessagingPage;
import src.pages.dashboard.DashboardPage;
import src.pages.profile.ProfilePage;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class SideBar extends JPanel {

    private final Color textColor = Color.decode("#283A6D");
    private final Color bgColor = Color.decode("#F2F6FF");

    public SideBar() {
        setLayout(new GridLayout(10, 1, 15, 0));
        setBackground(this.bgColor);
        initUI();
    }

    public void initUI() {

        JLabel appBrand = new JLabel("Hiric");
        appBrand.setFont(new Font("nunito", Font.BOLD, 25));
        appBrand.setForeground(this.textColor);
        ImageIcon image = new ImageIcon(Objects.requireNonNull(getClass().getResource("/src/img/logo-2.png")));
        Image img = image.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);

        //logo
        JPanel logo = new JPanel(new GridLayout(1, 0, 0, 0));
        logo.setBackground(this.bgColor);
        logo.add(new JLabel(new ImageIcon(img)));
        logo.add(appBrand);

        //dashboard
        ImageIcon dash_icon = new ImageIcon(Objects.requireNonNull(getClass().getResource("/src/img/dashboard1.png")));
        Image dash_img = dash_icon.getImage().getScaledInstance(12, 12, Image.SCALE_SMOOTH);
        JPanel dashboardPanel = new JPanel(new GridLayout(1, 2, 0, 0));
        dashboardPanel.setBackground(this.bgColor);
        dashboardPanel.add(new JLabel(new ImageIcon(dash_img)));
        JLabel dashboard = new JLabel("Dashboard    ");
        dashboard.setFont(new Font("nunito", Font.ITALIC, 15));
        dashboardPanel.add(dashboard);
        dashboardPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DashboardPage dashboardPage = new DashboardPage();
                dashboardPage.setVisible(true);
                Frame[] frames = Frame.getFrames();
                for(Frame fr : frames){
                    String specificFrameName = fr.getClass().getName();
                    if(!specificFrameName.equals("src.pages.dashboard.DashboardPage")){
                        if(fr.getSize().width > 600){
                            dashboardPage.setExtendedState(JFrame.MAXIMIZED_BOTH);
                        }
                        fr.dispose();
                    }
                }
            }
        });

        //profile
        ImageIcon profile_icon = new ImageIcon(Objects.requireNonNull(getClass().getResource("/src/img/userBlack.png")));
        Image profile_img = profile_icon.getImage().getScaledInstance(12, 12, Image.SCALE_SMOOTH);
        JPanel profilePanel = new JPanel(new GridLayout(1, 2, 0, 0));
        profilePanel.setBackground(this.bgColor);
        profilePanel.add(new JLabel(new ImageIcon(profile_img)));
        JLabel profile = new JLabel("Profile   ");
        profile.setFont(new Font("nunito", Font.ITALIC, 15));
        profilePanel.add(profile);
        profilePanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ProfilePage profilePage = new ProfilePage();
                profilePage.setVisible(true);
                Frame[] frames = Frame.getFrames();

                for(Frame fr : frames){
                    String specificFrameName = fr.getClass().getName();
                    if(!specificFrameName.equals("src.pages.profile.ProfilePage")){
                        if(fr.getSize().width > 600){
                            profilePage.setExtendedState(JFrame.MAXIMIZED_BOTH);
                        }
                        fr.dispose();
                    }
                }
            }
        });


        //New Module
        ImageIcon module_icon = new ImageIcon(Objects.requireNonNull(getClass().getResource("/src/img/edit.png")));
        Image module_img = module_icon.getImage().getScaledInstance(12, 12, Image.SCALE_SMOOTH);
        JPanel modulePanel = new JPanel(new GridLayout(1, 2, 0, 0));
        modulePanel.setBackground(this.bgColor);
        modulePanel.add(new JLabel(new ImageIcon(module_img)));
        JLabel module = new JLabel("New Module   ");
        module.setFont(new Font("nunito", Font.ITALIC, 15));
        modulePanel.add(module);
        modulePanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                System.out.println("New Module");
            }
        });


        // Messaging
        ImageIcon messaging_icon = new ImageIcon(Objects.requireNonNull(getClass().getResource("/src/img/message.png")));
        Image messaging_img = messaging_icon.getImage().getScaledInstance(12, 12, Image.SCALE_SMOOTH);
        JPanel messagingPanel = new JPanel(new GridLayout(1, 2, 0, 0));
        messagingPanel.setBackground(this.bgColor);
        messagingPanel.add(new JLabel(new ImageIcon(messaging_img)));
        JLabel messaging = new JLabel("Messaging   ");
        messaging.setFont(new Font("nunito", Font.ITALIC, 15));
        messagingPanel.add(messaging);
        messagingPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MessagingPage messagingPage = new MessagingPage();
                messagingPage.setVisible(true);
                Frame[] frames = Frame.getFrames();
                for(Frame fr : frames){
                    String specificFrameName = fr.getClass().getName();
                    if(!specificFrameName.equals("src.pages.messaging.MessagingPage")){
                        if(fr.getSize().width > 600){
                            messagingPage.setExtendedState(JFrame.MAXIMIZED_BOTH);
                        }
                        fr.dispose();
                    }
                }
            }
        });

        //Invoice
        ImageIcon invoice_icon = new ImageIcon(Objects.requireNonNull(getClass().getResource("/src/img/invoice.png")));
        Image invoice_img = invoice_icon.getImage().getScaledInstance(12, 12, Image.SCALE_SMOOTH);
        JPanel invoicePanel = new JPanel(new GridLayout(1, 2, 0, 0));
        invoicePanel.setBackground(this.bgColor);
        invoicePanel.add(new JLabel(new ImageIcon(invoice_img)));
        JLabel invoice = new JLabel("Invoice   ");
        invoice.setFont(new Font("nunito", Font.ITALIC, 15));
        invoicePanel.add(invoice);
        invoicePanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                System.out.println("Invoice");
            }
        });

        //Post
        ImageIcon post_icon = new ImageIcon(Objects.requireNonNull(getClass().getResource("/src/img/post.png")));
        Image post_img = post_icon.getImage().getScaledInstance(12, 12, Image.SCALE_SMOOTH);
        JPanel postPanel = new JPanel(new GridLayout(1, 2, 0, 0));
        postPanel.setBackground(this.bgColor);
        postPanel.add(new JLabel(new ImageIcon(post_img)));
        JLabel post = new JLabel("Post   ");
        post.setFont(new Font("nunito", Font.ITALIC, 15));
        postPanel.add(post);
        postPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                System.out.println("Post");
            }
        });

        //Interviewing
        ImageIcon interviewing_icon = new ImageIcon(Objects.requireNonNull(getClass().getResource("/src/img/interview.png")));
        Image interviewing_img = interviewing_icon.getImage().getScaledInstance(12, 12, Image.SCALE_SMOOTH);
        JPanel interviewingPanel = new JPanel(new GridLayout(1, 2, 0, 0));
        interviewingPanel.setBackground(this.bgColor);
        interviewingPanel.add(new JLabel(new ImageIcon(interviewing_img)));
        JLabel interviewing = new JLabel("Interviewing   ");
        interviewing.setFont(new Font("nunito", Font.ITALIC, 15));
        interviewingPanel.add(interviewing);
        interviewingPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                System.out.println("Interviewing");
            }
        });

        //settings
        ImageIcon settings_icon = new ImageIcon(Objects.requireNonNull(getClass().getResource("/src/img/settings-black.png")));
        Image settings_img = settings_icon.getImage().getScaledInstance(12, 12, Image.SCALE_SMOOTH);
        JPanel settingsPanel = new JPanel(new GridLayout(1, 2, 0, 0));
        settingsPanel.setBackground(this.bgColor);
        settingsPanel.add(new JLabel(new ImageIcon(settings_img)));
        JLabel settings = new JLabel("Settings   ");
        settings.setFont(new Font("nunito", Font.ITALIC, 15));
        settingsPanel.add(settings);
        settingsPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                System.out.println("Settings");
            }
        });

        //archives
        ImageIcon archives_icon = new ImageIcon(Objects.requireNonNull(getClass().getResource("/src/img/archives.png")));
        Image archives_img = archives_icon.getImage().getScaledInstance(12, 12, Image.SCALE_SMOOTH);
        JPanel archivesPanel = new JPanel(new GridLayout(1, 2, 0, 0));
        archivesPanel.setBackground(this.bgColor);
        archivesPanel.add(new JLabel(new ImageIcon(archives_img)));
        JLabel archives = new JLabel("Archives   ");
        archives.setFont(new Font("nunito", Font.ITALIC, 15));
        archivesPanel.add(archives);
        archivesPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                System.out.println("Archives");
            }
        });

        add(logo);
        add(dashboardPanel);
        add(modulePanel);
        add(messagingPanel);
        add(invoicePanel);
        add(postPanel);
        add(interviewingPanel);
        add(archivesPanel);
        add(profilePanel);
        add(settingsPanel);
    }

}
