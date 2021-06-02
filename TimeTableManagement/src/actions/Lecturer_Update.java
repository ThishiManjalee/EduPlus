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
public class Lecturer_Update {
                 public int value;

    public void UpdateLecturer(String LecturerName,String EmpId,String Faculty,String Department,String Center,String Building,String Level,String Rank){

          try{
                Connection cn=connection.DB_Connect.ConnecrDB();

                String update="Update lecturer set   name=?, employee_id=?, faculty=? ,leval=?,department=?,center=?,building=?,rank=?  where lid="+value; 
        
                PreparedStatement pst=cn.prepareStatement(update);
            
                pst.setString(1,LecturerName );
                pst.setString(2,EmpId);       
                String value1=Faculty;
                pst.setString(3, value1);
                String value2=Level;
                pst.setString(4, value2);
                String value3=Department;
                pst.setString(5, value3);
                String value4=Center;
                pst.setString(6, value4);
                String value5=Building;
                pst.setString(7, value5);
                pst.setString(8,Rank );


                pst.execute();
        //Display Message
         JOptionPane.showMessageDialog(null, "Upadate Sucsessfully");

            //Connection Close    
                pst.close();
                cn.close();
  
        }catch(SQLException e){
            //Display Message
            JOptionPane.showMessageDialog(null, e);
        }
    
    
    
    }
}
