package src.pages.Hiring;

import src.components.shared.Button;
import src.models.Hiring.JobApplication;
import src.utils.IconTextField;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class JobApplicationView extends JFrame {

    private final Color textColor = Color.decode("#283A6D");
    private final Color bgColor = Color.decode("#F2F6FF");

    JLabel jobPostLabel;
    JTextField jobPostField;
    JLabel userIdLabel, locationId,paymentMethod,referenceNameLabel,referencePhoneLabel,resumeLabel,certificateLabel;
    IconTextField userIdField, locationField,paymentMethodField,referenceNameField,referencePhoneField,resumeField,certificateField;

    JButton register;
    Container container;

    public JobApplicationView() {
        this.setTitle("Hiric");
        this.setSize(1000, 600);
        this.initUI();
        this.setLocationRelativeTo((Component)null);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public void initUI() {

        //application
            jobPostLabel = new JLabel("Job Post");
            jobPostField = new IconTextField();

            userIdLabel = new JLabel("User ID");
            userIdField = new IconTextField();

            locationId = new JLabel("Location");
            locationField = new IconTextField();

            paymentMethod=new JLabel("Payment method:");
            paymentMethodField=new IconTextField();

            referenceNameLabel=new JLabel("Reference Name");
            referenceNameField=new IconTextField();

            referencePhoneLabel=new JLabel("Reference Phone");
            referencePhoneField=new IconTextField();

            resumeLabel=new JLabel("Resume");
            resumeField=new IconTextField();

            certificateLabel=new JLabel("Certificate");
            certificateField=new IconTextField();

            register = new JButton();
            container = getContentPane();
            container.setLayout(null);
            setBounds();
            addComponents();
        }

        public void setBounds() {

            jobPostLabel.setBounds(50, 60, 100, 30);
            jobPostField.setBounds(210, 60, 250, 30);

            userIdLabel.setBounds(50, 110, 100, 30);
            userIdField.setBounds(210, 110, 250, 30);

            locationId.setBounds(50, 160, 600, 30);
            locationField.setBounds(210, 160, 250, 30);

            paymentMethod.setBounds(50, 210, 150, 30);
            paymentMethodField.setBounds(210, 210, 250, 30);

            referenceNameLabel.setBounds(50, 260, 100, 30);
            referenceNameField.setBounds(210, 260, 250, 30);

            referencePhoneLabel.setBounds(50, 310, 200, 30);
            referencePhoneField.setBounds(210, 310, 250, 30);

            resumeLabel.setBounds(50, 360, 200, 30);
            resumeField.setBounds(210, 360, 250, 30);

            certificateLabel.setBounds(50, 410, 100, 30);
            certificateField.setBounds(210, 410, 250, 30);

            register.setBounds(210, 460, 200, 30);
        }

        public void addComponents() {
          //  container.add(message);
            container.add(jobPostLabel);
            container.add(jobPostField);
            container.add(userIdLabel);
            container.add(userIdField);
            container.add(locationId);
            container.add(locationField);
            container.add(paymentMethod);
            container.add(paymentMethodField);
            container.add(referenceNameLabel);
            container.add(referenceNameField);
            container.add(referencePhoneLabel);
            container.add(referencePhoneField);
            container.add(resumeLabel);
            container.add(resumeField);
            container.add(certificateLabel);
            container.add(certificateField);
            container.add(register);
        }
    public static void main(String []args){
        new JobApplicationView();
    }
    public class ActionListen implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            userIdLabel.setText(userIdLabel.getText());
        }
    }
}
