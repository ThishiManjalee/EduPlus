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
public class NotAvailableTime_Add {
    
    public void AddNotAvailableTime(String Lecturer, String Room, String Group, String Subgroup, String Day, String Session_id, String Shrs, String Smin, String Ehrs, String Emin){
    
    
         try{
           Connection cn=connection.DB_Connect.ConnecrDB();
            
            String sql ="insert into not_available(lecturer,day,room, group1, subgroup,session_id,sthrs,stmin,enhrs,enmin) values(?,?,?,?,?,?,?,?,?,?)";
       
            PreparedStatement pst=cn.prepareStatement(sql);
         

            String value1=Lecturer;
            pst.setString(1,value1);
           
            
                      
            String value2=Day;
            pst.setString(2,value2);
            
            String value3=Room;
            pst.setString(3,value3);
                      
            String value4=Group;
            pst.setString(4,value4);
          
            String value5=Subgroup;
            pst.setString(5,value5);
         
          
            String value6=Session_id;
            pst.setString(6,value6);
          
      
            int stthrs=Integer.parseInt(Shrs);
            pst.setInt(7 , stthrs);
            
            int sttmin=Integer.parseInt(Smin);
            pst.setInt(8 , sttmin);
            
            
            int enhrs=Integer.parseInt(Ehrs);
            pst.setInt(9 , enhrs);
            
            int enmin=Integer.parseInt(Emin);
            pst.setInt(10 , enmin);
    
    
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
    

