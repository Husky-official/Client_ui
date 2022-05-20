package src.pages.messaging;

import src.components.shared.Button;
import src.models.RequestBody;
import src.pages.dashboard.DashboardPage;
import src.pages.profile.ProfilePage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class Groups extends JPanel  {
    private final Color textColor = Color.decode("#283A6D");
    private final Color bgColor = Color.decode("#F2F6FF");
    private JButton crt;

    public Groups() {
        setLayout(new GridLayout(14, 1, 15, 0));
        setBackground(Color.WHITE);
        setSize(new Dimension(100, 600));
        initUI();
    }

    public void initUI() {

        JLabel appBrand = new JLabel("My Groups   ");
        appBrand.setFont(new Font("nunito", Font.PLAIN, 18));
        ImageIcon image = new ImageIcon(Objects.requireNonNull(getClass().getResource("/src/img/logo-2.png")));
        Image img = image.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);

        //logo
        JPanel logo = new JPanel(new GridLayout(1, 0, 0, 0));
        logo.setBackground(Color.WHITE);
        logo.add(new JLabel(new ImageIcon(img)));
        logo.add(appBrand);



        //Groups

        RequestBody requestBody = new RequestBody();
        requestBody.setAction("g");
        requestBody.setUrl("/group-messaging");

        ImageIcon group_icons = new ImageIcon(Objects.requireNonNull(getClass().getResource("/src/img/group.png")));
        Image dash_img = group_icons.getImage().getScaledInstance(12, 12, Image.SCALE_SMOOTH);

        JPanel groupPanel = new JPanel(new GridLayout(1, 2, 0, 0));
        groupPanel.setBackground(Color.WHITE);
        groupPanel.add(new JLabel(new ImageIcon(dash_img)));
        JLabel groupName = new JLabel("   Husky");
        groupName.setFont(new Font("nunito", Font.PLAIN, 12));
        groupPanel.add(groupName);

        JPanel create = new JPanel(new GridLayout(1, 1, 0,0));
        JButton  crt = new Button("New group", Color.WHITE, textColor, new Font("nunito", Font.PLAIN, 15) , 0);
        create.add(crt);


        crt.addActionListener(e -> {
            CreateGroup grp = new CreateGroup();
            grp.setVisible(true);
            Frame[] frames = Frame.getFrames();
            for(Frame fr : frames){
                String specificFrameName = fr.getClass().getName();
                if(specificFrameName.equals("src.pages.messaging.MembersAndGroups")){
                    fr.dispose();
                }
            }
        });

        add(logo);
        add(groupPanel);
        add(create);
    }

}
