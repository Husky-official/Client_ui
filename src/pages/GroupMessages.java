package src.pages;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class GroupMessages extends JFrame {
    JFrame frame = new JFrame("Group Message");

    public Color getBgColor() {
        return bgColor;
    }

    public void setBgColor(Color bgColor) {
        this.bgColor = bgColor;
    }

    private Color bgColor = Color.WHITE;
    Color sidebarColor = new Color(24, 28, 46);



    public GroupMessages() throws IOException, FontFormatException {
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        this.setVisible(true);
        this.setLayout(null);

        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();
        JPanel panel3 = new JPanel();
        JPanel panel4 = new JPanel();



    }

}
