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
public class Location_Add {
    
    /**
     *
     * @param BuildingName
     * @param RoomName
     * @param Roomtype
     * @param Capacity
     */
    
    public void SaveLocation(String BuildingName, String RoomName, String Roomtype, String Capacity) {
       // TODO add your handling code here:
     
         try{
           Connection cn=connection.DB_Connect.ConnecrDB();
            
            String sql ="insert into location(building,room_name,room_type,capacity) values(?,?,?,?)";
       
            PreparedStatement pst=cn.prepareStatement(sql);
            
            pst.setString(1,BuildingName );
            pst.setString(2,RoomName);
            pst.setString(3,Roomtype);
            pst.setString(4,Capacity);

              
        pst.execute();
        JOptionPane.showMessageDialog(null, "Added Sucsessfully");
  
        pst.close();
        cn.close();
         
        }catch(HeadlessException | SQLException e){
//validateion methode for not null sql called
           JOptionPane.showMessageDialog(null, e);
        }

        
    }
    
    
    
}
