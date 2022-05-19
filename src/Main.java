package src;

import com.fasterxml.jackson.databind.ObjectMapper;
import src.client.ClientServerConnector;
import src.models.RequestBody;
import src.pages.NavBar;
import src.pages.JobPostsView;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class Main extends JFrame {

    private JLabel label;

    public Main() throws Exception {
        Welcome();
    }

    public void Welcome() throws Exception{

        setTitle("HIRIC");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
        setIconImage(new ImageIcon("src/img/dv.png").getImage());
        setLayout(new BorderLayout());
        setBackground(Color.WHITE);

        label = new JLabel();
        add(label);

        RequestBody requestBody = new RequestBody();
        requestBody.setUrl("/welcome");
        requestBody.setAction("welcome");
        requestBody.setObject(null);

        String request = new ObjectMapper().writeValueAsString(requestBody);

        ClientServerConnector clientServerConnector = new ClientServerConnector();
        String response = clientServerConnector.connect(request);

        label.setText(response);


        NavBar navBar = new NavBar();
//        BufferedImage imageIcon = ImageIO.read(new File("A:\\Projects\\Client_ui\\src\\img\\search.svg"));
//        JPanel icon = new JPanel(){
//            @Override
//            protected void paintComponent(Graphics g){
//                super.paintComponent(g);
//                g.fillRoundRect(10, 10, 29 , 20, 2, 2);
//            }
//        };
//        icon.setOpaque(true);
//        icon.setBackground(Color.BLACK);
//        icon.setBounds(100, 200, 2000, 500);
//        this.add(icon);
        this.add(navBar);

        JobPostsView jobPostsView = new JobPostsView();
        this.add(jobPostsView);
    }

    public static void main(String[] args) throws Exception {
        new Main();
    }

}
