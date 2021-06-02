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
public class Tag_Update {
                public int value;

    public void UpdateTag(String TagName,String TagCode,String RelatedTag){
        try{
                Connection cn=connection.DB_Connect.ConnecrDB();

                String update="Update tag set   tag_name=?, tag_code=?,related_tag=? where tag_id="+value; 
        
                PreparedStatement pst=cn.prepareStatement(update);
            
                pst.setString(1,TagName);
                pst.setString(2,TagCode);
                String value1=RelatedTag;
                pst.setString(3, value1);
                
                
               
                
       
             
                JOptionPane.showMessageDialog(null, "Upadate Sucsessfully");
                pst.execute();

                               
                pst.close();
                cn.close();
               
        }catch(SQLException e){
//call NOTNULL validation 
                    JOptionPane.showMessageDialog(null, e);
        }
    
    
    }
}
