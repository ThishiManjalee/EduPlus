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
public class Tag_Add {
    public void SaveTag(String TagName,String TagCode,String RelatedTag){
    
      
         try{
           Connection cn=connection.DB_Connect.ConnecrDB();
            
            String sql ="insert into tag(tag_name,tag_code,related_tag) values(?,?,?)";
       
            PreparedStatement pst=cn.prepareStatement(sql);
           
            pst.setString(1,TagName);
            pst.setString(2,TagCode);
            String value=RelatedTag;
            pst.setString(3, value);
            
                  
               
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
    
            