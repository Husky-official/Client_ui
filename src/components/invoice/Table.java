package src.components.invoice;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class Table extends JPanel {
   DefaultTableModel tableModel = new DefaultTableModel();
   JTable table = new JTable(tableModel){
       public boolean editCellAt(int row, int column, java.util.EventObject e){
           return false;
       }
   };
   public Table(){
       table.setRowSelectionAllowed(false);
       tableModel.addColumn("Date");
       tableModel.addColumn("Invoice #");
       tableModel.addColumn("Order Number");
       tableModel.addColumn("Employee name");
       tableModel.addColumn("Employee email");
       tableModel.addColumn("Status");
       tableModel.addColumn("Due Date");
       tableModel.addColumn("Amount");
       tableModel.addColumn("Balance Due");
       table.setRowHeight(60);table.setRowMargin(10);table.setShowGrid(false);
       table.setPreferredScrollableViewportSize(new Dimension(1150, 500));

       tableModel.addRow(new Object[]{"16/02","INV0000011","2302","Ineza Jost Chance","jinezachance@gmail.com", "Over Due","14/02", "2000", "1500"});
       table.setBackground(Color.WHITE);
       setBackground(Color.BLUE);
       JScrollPane scrollPane = new JScrollPane(table);
       scrollPane.setBorder(BorderFactory.createEmptyBorder());
       scrollPane.setBackground(Color.WHITE);
       scrollPane.getViewport().setBackground(Color.WHITE);
       add(scrollPane);
       int viewRow = table.getSelectedColumn();
       System.out.println(viewRow);
   }


}
