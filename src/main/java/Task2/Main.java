/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Task2;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Admin
 */
public class Main {

    public JTable table;

    public static void main(String[] args) {
        final Main task2= new Main();
        final JFrame parent = new JFrame();
        JButton button = new JButton();

        button.setText("Click để hiện danh sách có thay đổi giá");
        parent.add(button);
        parent.pack();
        parent.setVisible(true);

        button.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent evt) {
                javax.swing.SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                        task2.createAndShowGUI();
                    }
                });
            }
        });
        /*
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                task2.createAndShowGUI();
            }
        });
         */
    }

    private void createAndShowGUI() {
        JFrame frame = new JFrame("Danh sách sản phẩm có thay đổi giá");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        table = new JTable(new ExampleTableModel());
        JScrollPane scrollPane = new JScrollPane(table);
        table.setFillsViewportHeight(true);

        table.getColumnModel().getColumn(0).setPreferredWidth(100);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
        table.getColumn("in lại").setCellRenderer(new ButtonCellRenderer());
        table.getColumn("in lại").setCellEditor(new ButtonCellEditor());

        frame.getContentPane().add(scrollPane, BorderLayout.CENTER);
        frame.pack();
        frame.setVisible(true);
    }

}
