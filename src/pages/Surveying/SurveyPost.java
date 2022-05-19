package src.pages.Surveying;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class SurveyPost extends JFrame {
    private final Color textColor = Color.decode("#283A6D");
    private final Color bgColor = Color.decode("#F2F6FF");
    public SurveyPost(){
        this.setTitle("Hiric");
        this.setSize(1000, 600);
        this.setLayout(new GridLayout(6,6));
        this.setBackground(textColor);
        this.setVisible(true);
        this.setIconImage(new ImageIcon(Objects.requireNonNull(getClass().getResource("/src/img/logo-2.png"))).getImage());

    }
    public static void main(String[]argsv){
        new SurveyPost();
    }
}
