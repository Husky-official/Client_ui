package src.pages.messaging;

import src.components.shared.Button;
import src.pages.Login;

import javax.swing.*;
import java.awt.*;
import java.io.FileNotFoundException;
import java.util.Objects;

public class Messages extends JFrame {
    private final Color textColor = Color.decode("#283A6D");
    private final Color bgColor = Color.decode("#F2F6FF");
    private final Color memberSideColor = Color.decode("#FFFFFF");
    private JButton goBack;

    public Messages() {
        this.setTitle("Messaging | Hiric");
        this.setSize(1300, 830);
        this.setLocationRelativeTo((Component) null);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.initUI();
    }

    public void initUI() {
        this.setIconImage(new ImageIcon(Objects.requireNonNull(getClass().getResource("/src/img/logo.png"))).getImage());

        /**
         * Messaging page panels
         */
        JPanel contentPanel = new JPanel(new BorderLayout());
        JPanel headPanel = new JPanel(new BorderLayout());
        JPanel membersAndGroupsPanel = new JPanel(new BorderLayout());
        JPanel activeChatPanel = new JPanel(new BorderLayout());

        JPanel headRightPanel = new JPanel(new GridLayout(1, 2, 15,0));
        JPanel headLeftPanel = new JPanel(new GridLayout(1, 1, 10, 3));

        this.goBack = new Button("<- Go Back", Color.WHITE, textColor, new Font("nunito", Font.PLAIN, 12) , 5);
        JLabel pageDescription = new JLabel("All messages");

        pageDescription.setFont(new Font("nunito", Font.BOLD, 20));
        pageDescription.setForeground(this.textColor);

        headPanel.setPreferredSize(new Dimension(0, 80));
        headPanel.setBackground(this.bgColor);

        contentPanel.setBackground(this.bgColor);

        headRightPanel.setBackground(this.bgColor);
        headLeftPanel.setBackground(this.bgColor);
        headRightPanel.add(this.goBack);
        headLeftPanel.add(pageDescription);
        headRightPanel.setBorder(BorderFactory.createEmptyBorder(20, 5, 20, 50));
        headLeftPanel.setBorder(BorderFactory.createEmptyBorder(20, 50, 20, 5));

        membersAndGroupsPanel.setBackground(this.memberSideColor);
//        membersAndGroupsPanel.setBorder(BorderFactory.createEmptyBorder(10, 5, 10, 400));
        activeChatPanel.setBackground(Color.green);
        activeChatPanel.setBorder(BorderFactory.createEmptyBorder(10, 700, 10, 5));

        /**
         * members and groups to chat with
         */
        JPanel member = new JPanel(new GridLayout(1, 2, 15,0));
        member.setBackground(Color.yellow);
        member.setBorder(BorderFactory.createEmptyBorder(20, 5, 20, 50));
        membersAndGroupsPanel.add(member);
        JPanel member1 = new JPanel(new GridLayout(1, 2, 15,0));
        member.setBackground(Color.yellow);
        member.setBorder(BorderFactory.createEmptyBorder(20, 5, 20, 50));
        membersAndGroupsPanel.add(member);

        /**
         * members and groups to chat with
         */
//        JPanel chat = new JPanel(new BorderLayout());
//        BoxLayout chatLayout = new BoxLayout(chat, BoxLayout.Y_AXIS);
//        chat.setLayout(memberLayout);
//        chat.setBackground(Color.yellow);
//        for(int i = 0; i < 5; i++) {
            JPanel message = new JPanel();
            message.setBackground(Color.blue);
            message.setBounds(0, 0, 400, 100);
            activeChatPanel.add(message);
//        }

        this.goBack.setBackground(this.textColor);
        this.goBack.setForeground(Color.WHITE);
        this.goBack.setFocusPainted(false);
        this.goBack.setBorderPainted(false);
        this.goBack.setFont(new Font("nunito", Font.PLAIN, 15));

        /**
         * action to the for back button
         */
        this.goBack.addActionListener(event -> {
            Login login = null;
            try {
                login = new Login();
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
            login.setVisible(true);
            this.dispose();
        });

        JPanel bodyContent = new JPanel(new BorderLayout());
        BoxLayout boxLayout = new BoxLayout(bodyContent, BoxLayout.X_AXIS);
//
        bodyContent.setLayout(boxLayout);
        bodyContent.setBackground(this.bgColor);

//        JPanel headingPanel = new JPanel(new GridBagLayout());
//        headingPanel.setBorder(BorderFactory.createEmptyBorder(80, 0, 3, 0));
//        headingPanel


        bodyContent.add(membersAndGroupsPanel, "West");
        bodyContent.add(activeChatPanel, "East");

        headPanel.add(headLeftPanel, "West");
        headPanel.add(headRightPanel, "East");
        contentPanel.add(headPanel, "North");
        contentPanel.add(bodyContent, "Center");
        this.add(contentPanel);
    }

}
