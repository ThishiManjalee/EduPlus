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
public class Session_Add {
    
    public void AddSession(String Lec1,String Lec2,String Tag,String Slec,String Sgroup,String Ssubject,String Scode,String Nostu,String Hrs,String Min, String Day, String sHrs, String sMin, String EHrs, String EMin,String SessionName){
    
        
         try{
           Connection cn=connection.DB_Connect.ConnecrDB();
            
            String sql ="insert into session(lec1,lec2,tag,slec,sgroup,ssubject,scode,nostu,hrs,min,day,shrs,smin,ehrs,emin,sesname) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
       
            PreparedStatement pst=cn.prepareStatement(sql);
         

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
            
               
            int nostu=Integer.parseInt(Nostu);
            pst.setInt(8, nostu);
            
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
            
            
           pst.setString(16,SessionName);

            
            
            
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

