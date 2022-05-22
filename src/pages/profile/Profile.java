package src.pages.profile;

import src.components.shared.Button;
import src.constants.Colors;
import src.pages.Login;
import src.pages.Register;
import src.pages.UserUpdateForm;

import javax.swing.*;
import java.awt.*;
import java.io.FileNotFoundException;

public class Profile extends JPanel {
    private final Color textColor = Color.decode("#283A6D");
    private final Color bgColor = Color.decode("#F2F6FF");

    public Profile() {
        this.setLayout(new BorderLayout());
        this.setBackground(this.bgColor);
        this.initUI();

    }

   public void initUI(){
       JLabel text = new JLabel("Profile");
       text.setFont(new Font("nunito", Font.BOLD, 25));
       text.setForeground(this.textColor);
       this.add(text, BorderLayout.NORTH);

       JPanel content = new JPanel();
       content.setBackground(this.bgColor);
       JButton manageProfile = new Button("Manage profile", Color.WHITE, textColor, new Colors().SidebarFont, 12);
       manageProfile.addActionListener(e -> {
           UserUpdateForm update = new UserUpdateForm();
           update.setVisible(true);

       });
        content.add(manageProfile);
        this.add(content);
   }

}
