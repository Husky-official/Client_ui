package src.pages.interviewing;

import src.pages.layout.SideBar;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class AddParticipantPage extends JFrame implements ActionListener {
    private JPanel contentPanel;
    private JPanel bodyPanel;

    public AddParticipantPage(){
        this.setTitle("Add Participant | Hiric");
        this.setSize(1000, 600);
        this.initUI();
        this.setLocationRelativeTo((Component) null);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setIconImage(new ImageIcon(Objects.requireNonNull(getClass().getResource("/src/img/logo.png"))).getImage());
    }

    public void initUI(){
        contentPanel = new JPanel(new BorderLayout());
        bodyPanel = new JPanel(new GridBagLayout());

        bodyPanel.setBackground(Color.decode("#eaf5f9"));
        bodyPanel.add(new AddParticipant());

        contentPanel.add(new SideBar(), BorderLayout.WEST);
        contentPanel.add(bodyPanel, BorderLayout.CENTER);

        this.add(contentPanel);
    }
    public static void main(String[] args){
        new AddParticipantPage();
    }
    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
