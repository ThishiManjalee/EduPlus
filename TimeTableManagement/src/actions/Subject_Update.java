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
public class Subject_Update {
            public int value;

    public void UpdateSubject(String SubjectCode,String SubjectName,String OfferedYear,String Semester,String EvalucationHours,String LabHours,String TutorialHours,String LecturerHours){
        try{
                Connection cn=connection.DB_Connect.ConnecrDB();

              
                String update="Update subjects set  sub_code=?, sub_name=?, offered_semester=?, offered_year=? ,no_of_lecturer_hours=?,no_of_tutorial_hours=?,no_of_lab_hours=?,no_of_evaluaction_hours=?  where sub_id="+value; 
        
                PreparedStatement pst=cn.prepareStatement(update);
            
                pst.setString(1,SubjectCode );
                pst.setString(2,SubjectName);
                pst.setString(3,Semester);      
                String value1=OfferedYear;
                pst.setString(4, value1);
                int evalucation =Integer.parseInt(EvalucationHours);
                pst.setInt(5, evalucation);
                int labhours=Integer.parseInt(LabHours);
                pst.setInt(6,labhours);
                int tutehours=Integer.parseInt(TutorialHours);
                pst.setInt(7,tutehours);
                int lecturerhours=Integer.parseInt(LecturerHours);
                pst.setInt(8,lecturerhours);
            
       
                
                
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
