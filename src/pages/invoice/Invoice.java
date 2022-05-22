package src.pages.invoice;

import src.components.invoice.Table;

import javax.swing.*;
import java.awt.*;

public class Invoice extends JPanel{
    private final Color textColor = Color.decode("#283A6D");
//    private final Color bgColor = Color.decode("#F2F6FF");

    public  Invoice(){
        this.setLayout(new BorderLayout());
//        this.setBounds(19, 29, 700, 500);
//        this.setBackground(this.bgColor);
        this.initUI();
    }
    public void initUI(){
        JPanel tableRow = new Table();
        add(tableRow);
    }
}
