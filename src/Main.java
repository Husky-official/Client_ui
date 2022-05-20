package src;


import src.pages.Home;
import src.pages.dashboard.Dashboard;
import src.pages.dashboard.DashboardPage;

import javax.swing.*;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;


public class Main extends JFrame {


    FileReader fileReader = new FileReader("./resources/application.properties");

    Properties properties = new Properties();

    public Main() throws IOException {

//        properties.load(fileReader);
//        boolean logged_in = Boolean.parseBoolean(properties.getProperty("logged_in"));
        boolean logged_in = true;
        System.out.println(logged_in);

        //change layout if user logged in
        if (logged_in){
            this.add(new DashboardPage());
        }else {
            this.add(new Home());
        }
    }

    public static void main(String[] args) throws Exception {
        new Main();
    }

}
