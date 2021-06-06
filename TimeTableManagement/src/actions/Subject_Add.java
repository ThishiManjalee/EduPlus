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
public class Subject_Add {
    public void Add_Subject(String SubjectCode,String SubjectName,String OfferedYear,String Semester,String EvalucationHours,String LabHours,String TutorialHours,String LecturerHours ){
      try{
           Connection cn=connection.DB_Connect.ConnecrDB();
            
            String sql ="insert into subjects(sub_code,sub_name,offered_year,offered_semester,no_of_evaluaction_hours,no_of_lab_hours,no_of_tutorial_hours,no_of_lecturer_hours) values(?,?,?,?,?,?,?,?)";
       
            PreparedStatement pst=cn.prepareStatement(sql);
            
            pst.setString(1,SubjectCode );
            pst.setString(2,SubjectName);
            String value=OfferedYear;
            pst.setString(3, value);
            pst.setString(4,Semester);
            int evalucation =Integer.parseInt(EvalucationHours);
            pst.setInt(5, evalucation);
            int labhours=Integer.parseInt(LabHours);
            pst.setInt(6,labhours);
            int tutehours=Integer.parseInt(TutorialHours);
            pst.setInt(7,tutehours);
            int lecturerhours=Integer.parseInt(LecturerHours);
            pst.setInt(8,lecturerhours);

       
               
            pst.execute();
         
        //Connection Close    
        pst.close();
        cn.close();

            JOptionPane.showMessageDialog(null, "Added Sucsessfully");
          
          }catch(HeadlessException | SQLException e){
                
//SQL not Null Validation function called   
           JOptionPane.showMessageDialog(null, e);
          }   
        
    
    }
}
    
            