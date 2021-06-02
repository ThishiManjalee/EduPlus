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
public class Lecturer_Add {
   
    public void SaveLecturer(String LecturerName,String EmpId,String Faculty,String Department,String Center,String Building,String Level,String Rank){
     
        try{
           Connection cn=connection.DB_Connect.ConnecrDB();
            
            String sql ="insert into lecturer(name,employee_id,faculty,department,center,building,leval,rank) values(?,?,?,?,?,?,?,?)";
       
            PreparedStatement pst=cn.prepareStatement(sql);
            
            pst.setString(1,LecturerName );
            pst.setString(2,EmpId);
            String value1=Faculty;
            pst.setString(3, value1);
            String value2=Department;
            pst.setString(4, value2);
            String value3=Center;
            pst.setString(5, value3);
            String value4=Building;
            pst.setString(6, value4);
            String value5=Level;
            pst.setString(7, value5);
            pst.setString(8,Rank );
//Check Empty Validations
  
          //Connection close
           pst.execute();         
           pst.close();
           cn.close();
          //Display Message       
           JOptionPane.showMessageDialog(null, "Added Sucsessfully");

    
           
  }catch(HeadlessException | SQLException e){
                   
//validateion(SQL NULL) or Emplyoee id unique
           JOptionPane.showMessageDialog(null, e);

   }

    
    
    }
    
    
    
}
