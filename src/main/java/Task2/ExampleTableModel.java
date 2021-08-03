/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Task2;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Admin
 */
public class ExampleTableModel extends DefaultTableModel {

        public ExampleTableModel() {
            super(new Object[]{"mã sản phẩm", "tên sản phẩm", "giá bán cũ", "giá bán mới","in lại"}, 0);
            //addRow(new Object[]{"2701122048100", "SẢ CÂY KG", "20,000", "22,000"});
            for (int index = 0; index < 30; index++) {
                addRow(new Object[]{"2701122048100", "SẢ CÂY KG", "20,000", "22,000", index});
            }
        }

        @Override
        public boolean isCellEditable(int rowIndex, int columnIndex) {
            return columnIndex == 4;
        }

    }
