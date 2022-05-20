package src.pages.messaging;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import src.client.ClientServerConnector;
import src.components.shared.Button;
import src.models.Group;
import src.models.RequestBody;
import src.pages.layout.SideBar;
import src.utils.IconTextField;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class CreateGroup extends JFrame implements ActionListener {

    private JLabel groupName = new JLabel("Group Name: ");
    private JLabel groupDescription = new JLabel("Group Description");
    private IconTextField name = new IconTextField();
    private IconTextField description = new IconTextField();

    private JButton create  = new Button("Create", Color.WHITE, Color.blue, new Font("nunito", Font.PLAIN, 14), 0);;

    private final Color textColor = Color.decode("#283A6D");
    private final Color bgColor = Color.decode("#F2F6FF");

    public CreateGroup(){
        this.setIconImage(new ImageIcon(Objects.requireNonNull(getClass().getResource("/src/img/logo.png"))).getImage());
        this.setTitle("Create Group | Hiric");
        this.setSize(1000, 600);
        this.setLocationRelativeTo((Component) null);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.initUI();

        addActionEvent();
    }

    private void initUI() {
        JPanel content = new JPanel(new BorderLayout());
        JPanel body = new JPanel(new GridBagLayout());

        groupName.setFont(new Font("nunito", 0, 14));
        groupName.setForeground(this.textColor);
        name.setFont(new Font("Verdana", 0, 14));
        name.setPreferredSize(new Dimension(280, 30));
        name.setBackground(this.bgColor);
        name.setForeground(Color.BLACK);

        groupDescription.setFont(new Font("nunito", 0, 14));
        groupDescription.setForeground(this.textColor);
        description.setFont(new Font("Verdana", 0, 14));
        description.setPreferredSize(new Dimension(280, 40));
        description.setBackground(this.bgColor);
        description.setForeground(Color.BLACK);

        JPanel form = new JPanel(new GridLayout(8, 0, 12, 0));

        create.addActionListener(e -> {

        });

        form.add(groupName);
        form.add(name);
        form.add(groupDescription);
        form.add(description);
        form.add(create);

        body.add(form);

        content.setBackground(this.bgColor);
        content.setSize(new Dimension(200, 600));
        content.add(body, "Center");
        this.add(content);
    }

    public static void main(String[] args) {
        new CreateGroup();
    }

    public void addActionEvent() {
        create.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        //Groups

        RequestBody requestBody = new RequestBody();
        requestBody.setAction("createGroup");
        requestBody.setUrl("/group_messaging");

        Group group = new Group();
        group.setGroupCreatorID(1);
        group.setGroupName(name.getText());
        group.setGroupDescription(description.getText());
        requestBody.setObject(group);

        String requestString = null;
        try {
            requestString = new ObjectMapper().writeValueAsString(requestBody);
        } catch (JsonProcessingException ex) {
            throw new RuntimeException(ex);
        }
        ClientServerConnector clientServerConnector=new ClientServerConnector();
        //sending request to the server
        String response=clientServerConnector.connect(requestString);
        System.out.println(response);
        //getting response
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            JsonNode jsonResponse = objectMapper.readTree(response);

        } catch (JsonProcessingException ex) {
            throw new RuntimeException(ex);
        }
    }


}


