package src.pages.profile;

import javax.swing.*;
import java.awt.*;

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
   }

}
