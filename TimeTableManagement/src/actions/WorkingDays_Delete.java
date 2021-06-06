/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actions;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class WorkingDays_Delete {
               public  int value;

    public void WorkingDaysDelete(){
// TODO add your handling code here:
          Connection cn=connection.DB_Connect.ConnecrDB();

        try{
        String query="DELETE FROM working_days_hours where wd_id="+value;
        PreparedStatement pst=cn.prepareStatement(query);
        pst.executeUpdate();
       
        
         JOptionPane.showMessageDialog(null, "Deleted Sucessfully");
       
//call modhode
        
//Connection Close
        pst.close();
        cn.close();
        
    }catch( HeadlessException | SQLException e){
        //Sql erro
        JOptionPane.showMessageDialog(null,e);
    }
       
    
    
    }
}
