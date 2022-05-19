package src.pages;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class Register extends JFrame {

        public Register(){
            this.setTitle("Register | Hiric");
            this.add(text);
            this.setSize(1000, 600);
            this.setLocationRelativeTo((Component)null);
            this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            this.setVisible(true);
            //make icon global

            this.setIconImage(new ImageIcon(Objects.requireNonNull(getClass().getResource("/src/img/logo.png"))).getImage());
        }
        JLabel text = new JLabel("Register");
}
