/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yass;

import Thishi.Manage_tags;
import actions.NotAvailableTime_Delete;
import actions.NotAvailableTime_Update;
import javax.swing.JFrame;
import group_implmentation.dashboard;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SpinnerNumberModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author yass
 */
public final class manage_n_available_time extends javax.swing.JFrame {
         NotAvailableTime_Update nu=new NotAvailableTime_Update();
         NotAvailableTime_Delete nd =new NotAvailableTime_Delete();
    /**
     * Creates new form manage_n_available_time
     */
    public manage_n_available_time() {
        initComponents();
        maxsizehidden();
        jtableColumnWidth();
        jTable2.setShowGrid(true);
        spinnerMinusMaxStop();
        lecturercombox();
        Roomcombox();
        Groupcombox();
        SubGroupcombox();
        sessioncombox();
    }
    void LoadDataUpdate(){
  try{
      int row =jTable2.getSelectedRow(); 
      String value =(jTable2.getModel().getValueAt(row, 0).toString());
      nu.value=Integer.parseInt(value);
  
  }catch(NumberFormatException ex){
  
      JOptionPane.showMessageDialog(null, "Load in Form"+ex.getMessage());
  
  }
    }
  
      void LoadDataDelete(){
  try{
      int row =jTable2.getSelectedRow(); 
      String value =(jTable2.getModel().getValueAt(row, 0).toString());
      nd.value=Integer.parseInt(value);
  
  }catch(NumberFormatException ex){
  
      JOptionPane.showMessageDialog(null, "Load in Form"+ex.getMessage());
  
  }
 }  
     void maxsizehidden(){
        setSize(1400, 820);
        setLocationRelativeTo(null);
        setResizable(false); // maximize button disable
      
    }
   
     
     void jtableColumnWidth(){

//Cretae jtable Column Width Any Sizes
 
        jTable2.setAutoResizeMode( JTable.AUTO_RESIZE_OFF );
        jTable2.getColumnModel().getColumn(0).setPreferredWidth(250);
        jTable2.getColumnModel().getColumn(1).setPreferredWidth(250);
        jTable2.getColumnModel().getColumn(2).setPreferredWidth(250);
        jTable2.getColumnModel().getColumn(3).setPreferredWidth(250);
        jTable2.getColumnModel().getColumn(4).setPreferredWidth(250);
        jTable2.getColumnModel().getColumn(5).setPreferredWidth(250);
        jTable2.getColumnModel().getColumn(6).setPreferredWidth(250);
        jTable2.getColumnModel().getColumn(7).setPreferredWidth(250);
        jTable2.getColumnModel().getColumn(8).setPreferredWidth(250);
        jTable2.getColumnModel().getColumn(9).setPreferredWidth(250);
        jTable2.getColumnModel().getColumn(10).setPreferredWidth(250);


}            
     
  void spinnerMinusMaxStop(){
          ((SpinnerNumberModel) jSpinnerStartHour.getModel()).setMinimum(0);
          ((SpinnerNumberModel) jSpinnerStartMin.getModel()).setMinimum(0);
          ((SpinnerNumberModel) jSpinnerEndHour.getModel()).setMinimum(0);
          ((SpinnerNumberModel) jSpinnerEndMin.getModel()).setMinimum(0);
               
          ((SpinnerNumberModel) jSpinnerStartHour.getModel()).setMaximum(23);
          ((SpinnerNumberModel) jSpinnerStartMin.getModel()).setMaximum(59);
          ((SpinnerNumberModel) jSpinnerEndHour.getModel()).setMaximum(23);
          ((SpinnerNumberModel) jSpinnerEndMin.getModel()).setMaximum(59);
 
  }
  void sessioncombox(){
      // TODO add your handling code here:
          try {
                 Connection cn=connection.DB_Connect.ConnecrDB();
            
                 String sql ="select DISTINCT se_id from session";
                 Statement pst=cn.createStatement();
                 ResultSet rs=pst.executeQuery(sql);
                 while(rs.next()){
                 
                     String se_id=rs.getString("se_id");
                     jComboBoxSessionId.addItem(se_id);
                 
                 }
                 //Connection Close
                 pst.close();
                 rs.close();
                 cn.close();
       
        
        } catch (SQLException ex) {
            Logger.getLogger(manage_n_available_time.class.getName()).log(Level.SEVERE, null, ex);
              JOptionPane.showMessageDialog(null, ex);
        }
        
         
    }          
            
            
                  
            
   void lecturercombox(){
      // TODO add your handling code here:
          try {
                 Connection cn=connection.DB_Connect.ConnecrDB();
            
                 String sql ="select DISTINCT name from lecturer";
                 Statement pst=cn.createStatement();
                 ResultSet rs=pst.executeQuery(sql);
                 while(rs.next()){
                 
                     String name=rs.getString("name");
                     jComboBoxLecturer.addItem(name);
                 
                 }
                 //Connection Close
                 pst.close();
                 rs.close();
                 cn.close();
       
        
        } catch (SQLException ex) {
            Logger.getLogger(manage_n_available_time.class.getName()).log(Level.SEVERE, null, ex);
              JOptionPane.showMessageDialog(null, ex);
        }
        
         
    }
      void Roomcombox(){
      // TODO add your handling code here:
          try {
                 Connection cn=connection.DB_Connect.ConnecrDB();
            
                 String sql ="select DISTINCT room_name from location";
                 Statement pst=cn.createStatement();
                 ResultSet rs=pst.executeQuery(sql);
                 while(rs.next()){
                 
                     String room_name=rs.getString("room_name");
                     jComboBoxRoom.addItem(room_name);
                 
                 }
                 //Connection Close
                 pst.close();
                 rs.close();
                 cn.close();
       
        
        } catch (SQLException ex) {
            Logger.getLogger(manage_n_available_time.class.getName()).log(Level.SEVERE, null, ex);
              JOptionPane.showMessageDialog(null, ex);
        }
        
         
    }
     void Groupcombox(){
      // TODO add your handling code here:
          try {
                 Connection cn=connection.DB_Connect.ConnecrDB();
            
                 String sql ="select DISTINCT group_id from student_group";
                 Statement pst=cn.createStatement();
                 ResultSet rs=pst.executeQuery(sql);
                 while(rs.next()){
                 
                     String group_id=rs.getString("group_id");
                     jComboBoxGroup.addItem(group_id);
                 
                 }
                 //Connection Close
                 pst.close();
                 rs.close();
                 cn.close();
       
        
        } catch (SQLException ex) {
            Logger.getLogger(manage_n_available_time.class.getName()).log(Level.SEVERE, null, ex);
              JOptionPane.showMessageDialog(null, ex);
        }
        
         
    }
       void SubGroupcombox(){
      // TODO add your handling code here:
          try {
                 Connection cn=connection.DB_Connect.ConnecrDB();
            
                 String sql ="select DISTINCT sub_group_id from student_group";
                 Statement pst=cn.createStatement();
                 ResultSet rs=pst.executeQuery(sql);
                 while(rs.next()){
                 
                     String sub_group_id=rs.getString("sub_group_id");
                     jComboBoxSubGroup.addItem(sub_group_id);
                 
                 }
                 //Connection Close
                 pst.close();
                 rs.close();
                 cn.close();
       
        
        } catch (SQLException ex) {
            Logger.getLogger(manage_n_available_time.class.getName()).log(Level.SEVERE, null, ex);
              JOptionPane.showMessageDialog(null, ex);
        }
        
         
    }

     //Display All Data in Jtable
   public void displaytable(){
     
           try{
               try (Connection cn = connection.DB_Connect.ConnecrDB()) {
                   String select="select * from not_available";
                   PreparedStatement pst=cn.prepareStatement(select);
                   
                   
                   ResultSet rs =pst.executeQuery();
                   while(rs.next()){
                       //Data will be added until finish
                       String na_id       = String.valueOf(rs.getInt("na_id"));
                       String session_id   = rs.getString("session_id");
                       String lecturer    = rs.getString("lecturer");
                       String room=rs.getString("room");
                       String group1  = rs.getString("group1");
                       String subgroup=rs.getString("subgroup");
                       String day=rs.getString("day");
                       String sthrs         = rs.getString("sthrs");
                       String stmin=rs.getString("stmin");
                       String enhrs=rs.getString("enhrs");
                       String enmin=rs.getString("enmin");

                       //string array for store data into jtable
                       String tbData[]={na_id,session_id,lecturer,day, room, group1, subgroup ,sthrs,stmin,enhrs,enmin  };
                       DefaultTableModel tblModel=(DefaultTableModel)jTable2.getModel();
                       
                       tblModel.addRow(tbData);
                   }
               
                   
               }
                 }catch(SQLException e){
                
                
                    JOptionPane.showMessageDialog(this, e);
                
                }
         
    }  
       
   
       
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        AddNottomeClick = new javax.swing.JButton();
        ManageNottimeClick = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        BackClick = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jButtonClear = new javax.swing.JButton();
        jButtonDelete = new javax.swing.JButton();
        jButtonUpdate = new javax.swing.JButton();
        DashboardClick = new javax.swing.JButton();
        jComboBoxSessionId = new javax.swing.JComboBox<>();
        jComboBoxLecturer = new javax.swing.JComboBox<>();
        jComboBoxRoom = new javax.swing.JComboBox<>();
        jComboBoxGroup = new javax.swing.JComboBox<>();
        jComboBoxSubGroup = new javax.swing.JComboBox<>();
        jSpinnerStartMin = new javax.swing.JSpinner();
        jSpinnerStartHour = new javax.swing.JSpinner();
        jSpinnerEndHour = new javax.swing.JSpinner();
        jSpinnerEndMin = new javax.swing.JSpinner();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jComboBoxDay = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pasindu_img/logo.jpeg"))); // NOI18N

        AddNottomeClick.setBackground(new java.awt.Color(0, 153, 153));
        AddNottomeClick.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        AddNottomeClick.setText("Add Not Available Time");
        AddNottomeClick.setPreferredSize(new java.awt.Dimension(275, 30));
        AddNottomeClick.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddNottomeClickActionPerformed(evt);
            }
        });

        ManageNottimeClick.setBackground(new java.awt.Color(0, 153, 153));
        ManageNottimeClick.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        ManageNottimeClick.setText("Manage Not Available Time");
        ManageNottimeClick.setPreferredSize(new java.awt.Dimension(275, 30));

        jLabel2.setBackground(new java.awt.Color(0, 0, 0));
        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 153, 153));
        jLabel2.setText("Manage Not Available Time");

        jTable2.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Not_Available_Id", "Session_Id", "Lecturer", "Day", "Room", "Group", "Sub Group", "Start Time(Hr)", "Start Time(Min)", "End Time(Hr)", "End Time(Min)"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable2.setGridColor(new java.awt.Color(51, 153, 255));
        jTable2.setRowHeight(55);
        jTable2.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                jTable2AncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable2);

        BackClick.setBackground(new java.awt.Color(0, 153, 153));
        BackClick.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        BackClick.setText("<<BACK");
        BackClick.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackClickActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel3.setText("Session ID");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel4.setText("Lecturer");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel5.setText("Room");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel6.setText("Group");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel7.setText("Sub Group");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel8.setText("Start Time");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel9.setText("End Time");

        jButtonClear.setBackground(new java.awt.Color(0, 153, 153));
        jButtonClear.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jButtonClear.setText("Clear");
        jButtonClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonClearActionPerformed(evt);
            }
        });

        jButtonDelete.setBackground(new java.awt.Color(0, 153, 153));
        jButtonDelete.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jButtonDelete.setText("Delete");
        jButtonDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDeleteActionPerformed(evt);
            }
        });

        jButtonUpdate.setBackground(new java.awt.Color(0, 153, 153));
        jButtonUpdate.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jButtonUpdate.setText("Update");
        jButtonUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonUpdateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(125, 125, 125)
                .addComponent(jButtonUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 215, Short.MAX_VALUE)
                .addComponent(jButtonDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(184, 184, 184)
                .addComponent(jButtonClear, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(74, 74, 74))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(34, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonClear, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31))
        );

        DashboardClick.setBackground(new java.awt.Color(0, 153, 153));
        DashboardClick.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        DashboardClick.setText("Dashboard");
        DashboardClick.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DashboardClickActionPerformed(evt);
            }
        });

        jComboBoxSessionId.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));

        jComboBoxLecturer.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));

        jComboBoxRoom.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));
        jComboBoxRoom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxRoomActionPerformed(evt);
            }
        });

        jComboBoxGroup.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));

        jComboBoxSubGroup.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));

        jLabel10.setText("Hrs");

        jLabel11.setText("Min");

        jLabel12.setText("Hrs");

        jLabel13.setText("Min");

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel14.setText("Select Day");

        jComboBoxDay.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 376, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGap(71, 71, 71)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(ManageNottimeClick, javax.swing.GroupLayout.DEFAULT_SIZE, 287, Short.MAX_VALUE)
                                        .addComponent(AddNottomeClick, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(DashboardClick, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                            .addGap(32, 32, 32)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGap(199, 199, 199)
                                    .addComponent(jLabel2))
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 892, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jComboBoxGroup, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jComboBoxRoom, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jComboBoxLecturer, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jComboBoxSessionId, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGap(122, 122, 122)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jComboBoxSubGroup, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addComponent(jSpinnerEndHour, javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jSpinnerStartHour, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(jSpinnerEndMin, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(jSpinnerStartMin, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                        .addComponent(jComboBoxDay, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGap(0, 0, Short.MAX_VALUE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(143, 143, 143)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(140, 140, 140)
                        .addComponent(BackClick, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(100, 100, 100))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(27, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addGap(57, 57, 57)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(49, 49, 49)
                                .addComponent(jComboBoxSubGroup, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(32, 32, 32)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4)
                                    .addComponent(jComboBoxLecturer, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jComboBoxDay, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(52, 52, 52)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel7)
                                    .addComponent(jComboBoxSessionId, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(36, 36, 36)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jComboBoxRoom, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel8)
                                .addComponent(jSpinnerStartHour, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jSpinnerStartMin, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel6)
                                    .addComponent(jComboBoxGroup, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel9))
                                .addGap(63, 63, 63))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jSpinnerEndHour, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jSpinnerEndMin, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(69, 69, 69))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addComponent(DashboardClick, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(42, 42, 42)
                        .addComponent(AddNottomeClick, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41)
                        .addComponent(ManageNottimeClick, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(BackClick, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
add_n_avalable_time anot;
    private void AddNottomeClickActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddNottomeClickActionPerformed
        // TODO add your handling code here:
       
         
        if (anot == null) {
            anot = new add_n_avalable_time();
        }
        
        anot.setVisible(true);
        this.dispose(); 
      
    }//GEN-LAST:event_AddNottomeClickActionPerformed

    private void jButtonDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDeleteActionPerformed
        // TODO add your handling code here:
        
          // TODO add your handling code here:
        LoadDataDelete();

        DefaultTableModel tableModel = (DefaultTableModel) jTable2.getModel();
        tableModel.setRowCount(0);
        nd.DeleteNotAvailableTime();

          displaytable();
        
       
    }//GEN-LAST:event_jButtonDeleteActionPerformed
manage_n_available_time mnota;
    private void DashboardClickActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DashboardClickActionPerformed
        // TODO add your handling code here:
        group_implmentation.loging.dashb.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_DashboardClickActionPerformed

    private void BackClickActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackClickActionPerformed
        // TODO add your handling code here:
        dashboard dash1 =new dashboard();
        dash1.show();
        dispose();
    }//GEN-LAST:event_BackClickActionPerformed

    private void jButtonClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonClearActionPerformed
        // TODO add your handling code here:
         jComboBoxLecturer.setSelectedIndex(0);
        jComboBoxRoom.setSelectedIndex(0);
        jComboBoxGroup.setSelectedIndex(0);
        jComboBoxSubGroup.setSelectedIndex(0);
        jComboBoxSessionId.setSelectedIndex(0);
        jComboBoxDay.setSelectedIndex(0);
        jSpinnerStartHour.setValue(0);
        jSpinnerStartMin.setValue(0);
        jSpinnerEndHour.setValue(0);
        jSpinnerEndMin.setValue(0);
        
        
        
    }//GEN-LAST:event_jButtonClearActionPerformed

    private void jComboBoxRoomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxRoomActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxRoomActionPerformed

    private void jTable2AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jTable2AncestorAdded
        // TODO add your handling code here:
        displaytable();
    }//GEN-LAST:event_jTable2AncestorAdded

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
        // TODO add your handling code here:
         int i=jTable2.getSelectedRow();
           
            TableModel model=jTable2.getModel(); 
            jComboBoxSessionId.setSelectedItem(model.getValueAt(i, 1).toString());
            jComboBoxLecturer.setSelectedItem(model.getValueAt(i, 2).toString());
            jComboBoxDay.setSelectedItem(model.getValueAt(i, 3).toString());
            jComboBoxRoom.setSelectedItem(model.getValueAt(i, 4).toString());
            jComboBoxGroup.setSelectedItem(model.getValueAt(i, 5).toString());
            jComboBoxSubGroup.setSelectedItem(model.getValueAt(i, 6).toString());
            jSpinnerStartHour.setValue(Integer.parseInt((String)model.getValueAt(i,7)));
            jSpinnerStartMin.setValue(Integer.parseInt((String)model.getValueAt(i, 8)));
            jSpinnerEndHour.setValue(Integer.parseInt((String)model.getValueAt(i, 9)));
            jSpinnerEndMin.setValue(Integer.parseInt((String)model.getValueAt(i, 10)));
                    
    }//GEN-LAST:event_jTable2MouseClicked

//This methode use for Auto Refresh Data
private void updateRe_table(){
      

       Connection cn=connection.DB_Connect.ConnecrDB();
       String sql="select *from not_available";

try{
           


    PreparedStatement pst = cn.prepareStatement(sql);
           ResultSet rs = pst.executeQuery();
           jTable2.setModel(DbUtils.resultSetToTableModel(rs));
           jtableColumnWidth();

           
}catch(SQLException e){
      JOptionPane.showMessageDialog(null, e);
}
    
    }
    

    
    
    private void jButtonUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonUpdateActionPerformed
        // TODO add your handling code here:
        
        LoadDataUpdate();
        
        String Session_id=jComboBoxSessionId.getSelectedItem().toString();
        String Lecturer=jComboBoxLecturer.getSelectedItem().toString();
        String Room=jComboBoxRoom.getSelectedItem().toString();
        String Group = jComboBoxGroup.getSelectedItem().toString();
        String Subgroup=jComboBoxSubGroup.getSelectedItem().toString();
        String Day=jComboBoxDay.getSelectedItem().toString();
        String Shrs=jSpinnerStartHour.getValue().toString();
        String Smin=jSpinnerStartMin.getValue().toString();
        String Ehrs=jSpinnerEndHour.getValue().toString();
        String Emin=jSpinnerEndMin.getValue().toString();
      
    if(jComboBoxLecturer.getSelectedIndex() == 0||jComboBoxGroup.getSelectedIndex()==0||jComboBoxRoom.getSelectedIndex()==0||jComboBoxSubGroup.getSelectedIndex()==0||jComboBoxSessionId.getSelectedIndex()==0){
                 
                   //Call Validtion
                         JOptionPane.showMessageDialog(this, "Empty Feildes");

                  }else{ 
                
                nu.UpdateNotAvailableTime(Session_id,Lecturer, Room, Group, Subgroup, Day, Shrs, Smin, Ehrs, Emin);
            
            }
                
                                            updateRe_table();



        
    }//GEN-LAST:event_jButtonUpdateActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(manage_n_available_time.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(manage_n_available_time.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(manage_n_available_time.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(manage_n_available_time.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new manage_n_available_time().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddNottomeClick;
    private javax.swing.JButton BackClick;
    private javax.swing.JButton DashboardClick;
    private javax.swing.JButton ManageNottimeClick;
    private javax.swing.JButton jButtonClear;
    private javax.swing.JButton jButtonDelete;
    private javax.swing.JButton jButtonUpdate;
    private javax.swing.JComboBox<String> jComboBoxDay;
    private javax.swing.JComboBox<String> jComboBoxGroup;
    private javax.swing.JComboBox<String> jComboBoxLecturer;
    private javax.swing.JComboBox<String> jComboBoxRoom;
    private javax.swing.JComboBox<String> jComboBoxSessionId;
    private javax.swing.JComboBox<String> jComboBoxSubGroup;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSpinner jSpinnerEndHour;
    private javax.swing.JSpinner jSpinnerEndMin;
    private javax.swing.JSpinner jSpinnerStartHour;
    private javax.swing.JSpinner jSpinnerStartMin;
    private javax.swing.JTable jTable2;
    // End of variables declaration//GEN-END:variables
}
