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
public class Location_Update  {
    //Update Location
        public int value;

 public void Updatelocation(String BuildingName,String  RoomName,String Roomtype,String Capacity){
   // TODO add your handling code here:
           try{
                Connection cn=connection.DB_Connect.ConnecrDB();

                String update="Update location set  building=?, room_name=?, room_type=?, capacity=? where location_id="+value; 
        
                PreparedStatement pst=cn.prepareStatement(update);
            
                pst.setString(1,BuildingName );
                pst.setString(2,RoomName);
                pst.setString(3,Roomtype);
                pst.setString(4,Capacity);
            
           
                JOptionPane.showMessageDialog(null, "Upadate Sucsessfully");
                pst.execute();

                    
        pst.close();
        cn.close();
    
        }catch(SQLException e){
        
            JOptionPane.showMessageDialog(null, e);
        }
              
 
 
    
    
 }
}
