/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actions;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class NotAvailableTime_Update {
            public int value;

    public void UpdateNotAvailableTime(String SessionId,String Lecturer, String Room, String Group, String Subgroup, String Day, String Shrs, String Smin, String Ehrs, String Emin){
     try{
                Connection cn=connection.DB_Connect.ConnecrDB();

              
                String update="Update not_available set session_id=?,  lecturer=?, day=? ,room=?, group1=?, subgroup=?,sthrs=?,stmin=?,enhrs=?,enmin=?  where na_id="+value; 
        
                PreparedStatement pst=cn.prepareStatement(update);
            
            String value=SessionId;
            pst.setString(1, value);
       
            String value1=Lecturer;
            pst.setString(2,value1);
                  
            String value2=Day;
            pst.setString(3,value2);
            
            String value3=Room;
            pst.setString(4,value3);
                      
            String value4=Group;
            pst.setString(5,value4);
          
            String value5=Subgroup;
            pst.setString(6,value5);
         
          
      
            int stthrs=Integer.parseInt(Shrs);
            pst.setInt(7 , stthrs);
            
            int sttmin=Integer.parseInt(Smin);
            pst.setInt(8 , sttmin);
            
            
            int enhrs=Integer.parseInt(Ehrs);
            pst.setInt(9 , enhrs);
            
            int enmin=Integer.parseInt(Emin);
            pst.setInt(10 , enmin);
    
    
       
                
                
                JOptionPane.showMessageDialog(null, "Upadate Sucsessfully");
                pst.execute();
        
            
       
                pst.close();
                cn.close();
             
                
        }catch(SQLException e){
//SQL NOt Null Validation Called
                JOptionPane.showMessageDialog(null, e);
        }
    
    
    
    }
}
