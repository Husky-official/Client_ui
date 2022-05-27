package src;


import src.pages.Home;
import src.pages.dashboard.DashboardPage;

import javax.swing.*;
import java.io.IOException;


public class Main extends JFrame {


//FileReader fileReader = new FileReader("./resources/application.properties");
// Properties properties = new Properties();

    public Main() throws IOException {

//        properties.load(fileReader);
//        boolean logged_in = Boolean.parseBoolean(properties.getProperty("logged_in"));
//        System.out.println(logged_in);

        boolean logged_in = true;
        //change layout if user logged in
//        if (logged_in){
            this.add(new DashboardPage());
//        }else {
//            this.add(new Home());
//        }
    }

    public static void main(String[] args) throws Exception {
        new Main();
    }

}
