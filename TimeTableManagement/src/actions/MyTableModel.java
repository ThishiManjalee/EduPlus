/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actions;

import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Owner
 */
public class MyTableModel extends AbstractTableModel {

    private final String[][] data;
    private final Object[] columnNames;

    public MyTableModel(String[][] d, Object[] cn) {
        data = d;
        columnNames = cn;
    }

    
    @Override
    public boolean isCellEditable(int row,int col){
    
        return false;
    }

    
    
    @Override
    public int getRowCount() {

        return data.length;

    }

    @Override
    public int getColumnCount() {

        return columnNames.length;

    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {

        return data[rowIndex][columnIndex];
        
    }
    
    
    @Override
    public String getColumnName(int col){
    
        return (String)columnNames[col];
    }

}
