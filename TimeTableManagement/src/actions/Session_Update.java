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
public class Session_Update {
                     public int value;

    public void UpdateSession(String Lec1,String Lec2,String Tag,String Slec,String Sgroup,String Ssubject,String Scode,String Nostu,String Hrs,String Min ,String Day, String sHrs, String sMin, String EHrs, String EMin,String sesname){
     try{
                Connection cn=connection.DB_Connect.ConnecrDB();

              
                String update="Update session set  lec1=?, lec2=?, tag=?, slec=? ,sgroup=?,ssubject=?,scode=?,nostu=?,hrs=?,min=?,day=?,shrs=?,smin=?,ehrs=?,emin=?,sesname=?  where se_id="+value; 
        
                PreparedStatement pst=cn.prepareStatement(update);
            
                

            String value1=Lec1;
            pst.setString(1,value1);
           
            String value2=Lec2;
            pst.setString(2,value2);
            
            String value3=Tag;
            pst.setString(3, value3);
            
            pst.setString(4,Slec);
                   
            String value4=Sgroup;
            pst.setString(5, value4);
          
            String value5=Ssubject;
            pst.setString(6, value5);
          
            String value6=Scode;
            pst.setString(7, value6);
            
            pst.setString(8, Nostu);
            
            int hrs=Integer.parseInt(Hrs);
            pst.setInt(9, hrs);
            
            int min=Integer.parseInt(Min);
            pst.setInt(10, min);
    
            String value7=Day;
            pst.setString(11, value7);
            
            int shrs=Integer.parseInt(sHrs);
            pst.setInt(12, shrs);
            
            int smin=Integer.parseInt(sMin);
            pst.setInt(13, smin);
            
            int ehrs=Integer.parseInt(EHrs);
            pst.setInt(14, ehrs);
            
            
            int emin=Integer.parseInt(EMin);
            pst.setInt(15, emin);
            
            pst.setString(16, sesname);
                
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
