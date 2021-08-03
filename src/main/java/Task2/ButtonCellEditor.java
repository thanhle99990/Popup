/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Task2;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.EventObject;
import javax.swing.AbstractCellEditor;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableModel;

/**
 *
 * @author Admin
 */
public class ButtonCellEditor extends AbstractCellEditor implements TableCellEditor {

    private JButton editor;
    private Object value;
    private int row;
    private JTable table;

    public ButtonCellEditor() {
        editor = new JButton();
        editor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (table != null) {
                    fireEditingStopped();
                    TableModel model = table.getModel();
                    if (model instanceof DefaultTableModel) {
                        ((DefaultTableModel) model).removeRow(row);
                    }
                }
            }
        });
    }

    @Override
    public boolean isCellEditable(EventObject e) {
        return true;
    }

    @Override
    public Object getCellEditorValue() {
        return value;
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        this.table = table;
        this.row = row;
        this.value = value;
        if (value != null) {
            editor.setText("đã được in lại");
        } else {
            editor.setText("Delete Me");
        }
        if (isSelected) {
            editor.setForeground(table.getSelectionForeground());
            editor.setBackground(table.getSelectionBackground());
        } else {
            editor.setForeground(table.getForeground());
            editor.setBackground(UIManager.getColor("Button.background"));
        }
        return editor;
    }
}
