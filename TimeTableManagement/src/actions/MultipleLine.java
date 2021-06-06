/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package actions;

import java.awt.Component;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author Owner
 */
public class MultipleLine extends JTextArea implements TableCellRenderer{

    
    private List<List<Integer>> rowColHeight=new ArrayList<>();
    
    public MultipleLine(){
    
        setLineWrap(true);
        setWrapStyleWord(true);
        setOpaque(true);
    
    }
    
    
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
     
        setText((value==null) ? "" : value.toString());
        setEditable(false);
        
        return this;
    }
    
}
