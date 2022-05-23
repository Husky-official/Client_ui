package src.pages.resetPassword;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.jdesktop.swingx.prompt.PromptSupport;
import src.client.ClientServerConnector;
import src.models.RequestBody;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SendEmail extends JPanel {
    public SendEmail(){
        setLayout(new GridBagLayout());
        JPanel resetForm=new JPanel();

        JLabel heading=new JLabel("Forgot password");

        JTextField email=new JTextField(20);
        email.setFont(new Font("Tahoma",Font.PLAIN,18));
        email.setBounds(70,35,250,40);
        PromptSupport.setPrompt("provide the email",email);
        PromptSupport.setFocusBehavior(PromptSupport.FocusBehavior.SHOW_PROMPT,email);
        JButton reset = new JButton("Reset");
        reset.setFont(new Font("Arial", Font.PLAIN, 15));
        reset.setSize(20, 70);
        reset.setLocation(270, 450);
        reset.setBackground(Color.decode("#283A6D"));
        reset.setForeground(Color.WHITE);
        reset.setFocusPainted(false);
        reset.setFocusPainted(false);
        reset.setBorderPainted(false);

        resetForm.add(heading);
        resetForm.add(email);
        resetForm.add(reset);
        add(resetForm);

        setLayout(new FlowLayout(FlowLayout.LEFT));
        setLayout(new GridLayout(3,15));
        setVisible(true);
        setBounds(300, 90, 400, 400);

        reset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String sendToEmail=email.getText();
                RequestBody requestBody = new RequestBody();
                requestBody.setUrl("/users");
                requestBody.setAction("sendEmail");
                requestBody.setObject(sendToEmail);
                String requestString = null;
                try {
                    requestString = new ObjectMapper().writeValueAsString(requestBody);
                } catch (JsonProcessingException ex) {
                    throw new RuntimeException(ex);
                }


                ClientServerConnector clientServerConnector = new ClientServerConnector();
                String response = clientServerConnector.connect(requestString);
                ObjectMapper objectMapper = new ObjectMapper();
                JsonNode jsonResponse = null;
                try {
                    jsonResponse = objectMapper.readTree(response);
                } catch (JsonProcessingException ex) {
                    throw new RuntimeException(ex);
                }

               int status = jsonResponse.get("status").asInt();
               String message = jsonResponse.get("message").asText();
               String actionDone = jsonResponse.get("actionToDo").asText();
               JOptionPane.showMessageDialog(reset,actionDone);
               if(status==200){
                   checkToken();
               }
            }
        });

    }
    public String checkToken(){
        JPanel resetForm=new JPanel();
//        resetForm.setLayout(new GridLayout(4,1,2,2));

        JLabel heading=new JLabel("Verify token");

        JTextField token=new JTextField(20);
        token.setFont(new Font("Tahoma",Font.PLAIN,18));
        token.setBounds(70,35,250,40);
        PromptSupport.setPrompt("paste the token sent to your email",token);
        PromptSupport.setFocusBehavior(PromptSupport.FocusBehavior.SHOW_PROMPT,token);
        JButton verify = new JButton("verify");
        verify.setFont(new Font("Arial", Font.PLAIN, 15));
        verify.setSize(20, 70);
        verify.setLocation(270, 450);
        verify.setBackground(Color.decode("#283A6D"));
        verify.setForeground(Color.WHITE);
        verify.setFocusPainted(false);
        verify.setFocusPainted(false);
        verify.setBorderPainted(false);

        resetForm.add(heading);
        resetForm.add(token);
        resetForm.add(verify);
        add(resetForm);

        setLayout(new FlowLayout(FlowLayout.LEFT));
        setLayout(new GridLayout(3,15));
        setVisible(true);
        setBounds(300, 90, 400, 400);

        verify.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String sendToEmail=token.getText();
                RequestBody requestBody = new RequestBody();
                requestBody.setUrl("/users");
                requestBody.setAction("verifyToken");
                requestBody.setObject(sendToEmail);
                String requestString = null;
                try {
                    requestString = new ObjectMapper().writeValueAsString(requestBody);
                } catch (JsonProcessingException ex) {
                    throw new RuntimeException(ex);
                }


                ClientServerConnector clientServerConnector = new ClientServerConnector();
                String response = clientServerConnector.connect(requestString);
                ObjectMapper objectMapper = new ObjectMapper();
                JsonNode jsonResponse = null;
                try {
                    jsonResponse = objectMapper.readTree(response);
                } catch (JsonProcessingException ex) {
                    throw new RuntimeException(ex);
                }

                int status = jsonResponse.get("status").asInt();
                String message = jsonResponse.get("message").asText();
                String actionDone = jsonResponse.get("actionToDo").asText();
                JOptionPane.showMessageDialog(verify,actionDone);
                if(status==200){
                    setNewPassword();
                }
            }
        });
        return "";
    }
    public String setNewPassword(){
        JPanel resetForm=new JPanel();

        JLabel heading=new JLabel("setPassword");

        JPasswordField password=new JPasswordField(20);

        password.setFont(new Font("Tahoma",Font.PLAIN,18));
        password.setBounds(70,35,250,40);
        PromptSupport.setPrompt("type your new password",password);
        PromptSupport.setFocusBehavior(PromptSupport.FocusBehavior.SHOW_PROMPT,password);
        JButton setPassword = new JButton("submit");
        setPassword.setFont(new Font("Arial", Font.PLAIN, 15));
        setPassword.setSize(20, 70);
        setPassword.setLocation(270, 450);
        setPassword.setBackground(Color.decode("#283A6D"));
        setPassword.setForeground(Color.WHITE);
        setPassword.setFocusPainted(false);
        setPassword.setFocusPainted(false);
        setPassword.setBorderPainted(false);

        resetForm.add(heading);
        resetForm.add(password);
        resetForm.add(setPassword);
        add(resetForm);

        setLayout(new FlowLayout(FlowLayout.LEFT));
        setLayout(new GridLayout(3,15));
        setVisible(true);
        setBounds(300, 90, 400, 400);

        setPassword.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String passwordText=password.getText();
                RequestBody requestBody = new RequestBody();
                requestBody.setUrl("/users");
                requestBody.setAction("setPassword");
                requestBody.setObject(passwordText);
                String requestString = null;
                try {
                    requestString = new ObjectMapper().writeValueAsString(requestBody);
                } catch (JsonProcessingException ex) {
                    throw new RuntimeException(ex);
                }


                ClientServerConnector clientServerConnector = new ClientServerConnector();
                String response = clientServerConnector.connect(requestString);
                ObjectMapper objectMapper = new ObjectMapper();
                JsonNode jsonResponse = null;
                try {
                    jsonResponse = objectMapper.readTree(response);
                } catch (JsonProcessingException ex) {
                    throw new RuntimeException(ex);
                }

                int status = jsonResponse.get("status").asInt();
                String message = jsonResponse.get("message").asText();
                String actionDone = jsonResponse.get("actionToDo").asText();
                JOptionPane.showMessageDialog(setPassword,actionDone);
            }
        });
        return "";
    }

    public static void main(String[] args){
        new SendEmail();
    }
}
