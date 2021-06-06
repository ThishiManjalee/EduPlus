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
public class WorkingDays_Add {
    
    public void SaveWorkingDays(String WorkingDays,String Day1,String Day2,String Day3,String Day4,String Day5,String Day6,String Day7,String WorkingTimeHr,String WorkingTimeMin){
    
     // TODO add your handling code here:
        try{
            Connection cn=connection.DB_Connect.ConnecrDB();

            String sql ="Insert Into  working_days_hours(working_days,monday,tuesday,wensday,thursday,friday,saturday,sunday,working_time_perday_hr,working_time_perday_min,datetime) values(?,?,?,?,?,?,?,?,?,?,Now())";

            PreparedStatement pst=cn.prepareStatement(sql);
            int working_days =Integer.parseInt(WorkingDays);
            pst.setInt(1, working_days);
            pst.setString(2,Day1);
            pst.setString(3, Day2);
            pst.setString(4, Day3);
            pst.setString(5, Day4);
            pst.setString(6, Day5);
            pst.setString(7, Day6);
            pst.setString(8, Day7);
            int working_time_perday_hr =Integer.parseInt(WorkingTimeHr);
            pst.setInt(9, working_time_perday_hr);
            int working_time_perday_min =Integer.parseInt(WorkingTimeMin);
            pst.setInt(10, working_time_perday_min);
                       
            
            pst.execute();

            //Connection Close
            pst.close();
            cn.close();
            
            JOptionPane.showMessageDialog(null, "Added Sucsessfully");

        }catch(HeadlessException | SQLException e){

            JOptionPane.showMessageDialog(null, e);

        }
    }
    
}
