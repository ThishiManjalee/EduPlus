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
public class StudentGroup_Add {
    public void Add_StudentGroup(String Programme,String GroupId,String GroupNumber,String SubGroupId,String SubGroupNumber,String AcadamicYearSemester){
    
       
         try{
           Connection cn=connection.DB_Connect.ConnecrDB();
            
            String sql ="insert into student_group(programme,group_id,group_number,sub_group_id,sub_group_number,acadamic_year_semester) values(?,?,?,?,?,?)";
       
            PreparedStatement pst=cn.prepareStatement(sql);
         

            String value1=Programme;
            pst.setString(1,value1);
            pst.setString(2,GroupId);
            int group_num=Integer.parseInt(GroupNumber);
            pst.setInt(3,group_num);
            pst.setString(4, SubGroupId);
            int sub_group_num=Integer.parseInt(SubGroupNumber);
            pst.setInt(5, sub_group_num);
            String value2=AcadamicYearSemester;
            pst.setString(6, value2);
           
    
            pst.execute();
            
            JOptionPane.showMessageDialog(null, "Added Sucsessfully");
         //Connection Close   
            pst.close();
            cn.close();
            
          }
            
            
        
         catch(HeadlessException | SQLException e){
                    JOptionPane.showMessageDialog(null, e);
           
        }
    
    
    }
}