/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pasindu;

import Thishi.Add_Tags;
import group_implmentation.dashboard;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;
import javafx.scene.control.RadioButton;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import actions.*;
/**
 *
 * @author pasindu
 */
public final class Add_Location extends javax.swing.JFrame {
         Location_Add al=new Location_Add();

    /**
     * Creates new form Add_Location
     */
    public Add_Location() {
        initComponents();
//hidesize window function implement
        hidesize();
           
    }
//Set Desktop Application size and hide Maximize Window
    void hidesize(){
  
      setSize(1400, 820);
      setLocationRelativeTo(null);
      setResizable(false); // maximize button disable
      
  
  }
 

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jButtonClear = new javax.swing.JButton();
        javax.swing.JButton jButtonSaveLocation = new javax.swing.JButton();
        jTextFieldLecturerHall = new javax.swing.JRadioButton();
        jTextFieldLaboratory = new javax.swing.JRadioButton();
        jTextFieldBuildingName = new javax.swing.JTextPane();
        jTextFieldCapacity = new javax.swing.JTextPane();
        jTextFieldRoomName = new javax.swing.JTextPane();
        erroCapacity = new javax.swing.JLabel();
        erroBuildingName = new javax.swing.JLabel();
        erroRoomName = new javax.swing.JLabel();
        erroRoonType = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        ManageLocationClick = new javax.swing.JButton();
        BackClick = new javax.swing.JButton();
        DashboardClick = new javax.swing.JButton();
        AddLocationClick = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(1400, 820));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pasindu_img/logo.jpeg"))); // NOI18N

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Add Rooms Building Wise:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Building Name");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Room Name");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Room Type");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("Capacity");

        jButtonClear.setBackground(new java.awt.Color(0, 153, 153));
        jButtonClear.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButtonClear.setText("Clear");
        jButtonClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonClearActionPerformed(evt);
            }
        });

        jButtonSaveLocation.setBackground(new java.awt.Color(0, 153, 153));
        jButtonSaveLocation.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButtonSaveLocation.setText("Save");
        jButtonSaveLocation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSaveLocationActionPerformed(evt);
            }
        });

        buttonGroup1.add(jTextFieldLecturerHall);
        jTextFieldLecturerHall.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTextFieldLecturerHall.setText("Lectuer Hall");
        jTextFieldLecturerHall.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jTextFieldLecturerHallItemStateChanged(evt);
            }
        });
        jTextFieldLecturerHall.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LecturerAction(evt);
            }
        });

        buttonGroup1.add(jTextFieldLaboratory);
        jTextFieldLaboratory.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTextFieldLaboratory.setText("Laboratory");
        jTextFieldLaboratory.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jTextFieldLaboratoryItemStateChanged(evt);
            }
        });
        jTextFieldLaboratory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldLaboratoryActionPerformed(evt);
            }
        });

        jTextFieldBuildingName.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTextFieldBuildingName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldBuildingNameKeyReleased(evt);
            }
        });

        jTextFieldCapacity.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTextFieldCapacity.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldCapacityKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldCapacityKeyTyped(evt);
            }
        });

        jTextFieldRoomName.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTextFieldRoomName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldRoomNameKeyReleased(evt);
            }
        });

        erroCapacity.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        erroCapacity.setForeground(java.awt.Color.red);

        erroBuildingName.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        erroBuildingName.setForeground(java.awt.Color.red);

        erroRoomName.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        erroRoomName.setForeground(java.awt.Color.red);

        erroRoonType.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        erroRoonType.setForeground(java.awt.Color.red);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonClear, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(jButtonSaveLocation, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(erroRoonType, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 367, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addGap(94, 94, 94)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jTextFieldRoomName, javax.swing.GroupLayout.PREFERRED_SIZE, 396, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                            .addGap(0, 0, Short.MAX_VALUE)
                                            .addComponent(erroCapacity, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel2Layout.createSequentialGroup()
                                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                    .addComponent(jTextFieldLecturerHall)
                                                    .addGap(39, 39, 39)
                                                    .addComponent(jTextFieldLaboratory))
                                                .addGroup(jPanel2Layout.createSequentialGroup()
                                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                    .addComponent(jTextFieldCapacity, javax.swing.GroupLayout.PREFERRED_SIZE, 395, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addGap(0, 0, Short.MAX_VALUE))))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(erroBuildingName, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jTextFieldBuildingName, javax.swing.GroupLayout.PREFERRED_SIZE, 398, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGap(2, 2, 2)))
                            .addComponent(erroRoomName, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(60, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldBuildingName, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(erroBuildingName, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldRoomName, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(erroRoomName, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldLecturerHall)
                    .addComponent(jTextFieldLaboratory))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(erroRoonType, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldCapacity, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(erroCapacity, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(87, 87, 87)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonClear, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonSaveLocation, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50))
        );

        jLabel2.setBackground(new java.awt.Color(204, 255, 0));
        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 153, 153));
        jLabel2.setText("Add Locations");

        ManageLocationClick.setBackground(new java.awt.Color(0, 153, 153));
        ManageLocationClick.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        ManageLocationClick.setText("Manage Location");
        ManageLocationClick.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ManageLocationClickActionPerformed(evt);
            }
        });

        BackClick.setBackground(new java.awt.Color(0, 153, 153));
        BackClick.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        BackClick.setText("<<Back");
        BackClick.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackClickActionPerformed(evt);
            }
        });

        DashboardClick.setBackground(new java.awt.Color(0, 153, 153));
        DashboardClick.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        DashboardClick.setText("Dashboard");
        DashboardClick.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DashboardClickActionPerformed(evt);
            }
        });

        AddLocationClick.setBackground(new java.awt.Color(0, 153, 153));
        AddLocationClick.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        AddLocationClick.setText("Add Location");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 484, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(96, 96, 96)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(DashboardClick, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(ManageLocationClick, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(AddLocationClick, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(150, 150, 150)
                        .addComponent(BackClick, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 451, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 39, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 439, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(DashboardClick, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(AddLocationClick, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(ManageLocationClick, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(BackClick, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(69, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    
//Button Clicked After All the feilds are clean   
    private void jButtonClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonClearActionPerformed
       
        
          
        jTextFieldRoomName.setText("");
        jTextFieldBuildingName.setText("");
        buttonGroup1.clearSelection();
        jTextFieldCapacity.setText("");
        erroBuildingName.setText("");
        erroCapacity.setText("");
        erroRoomName.setText("");
        erroRoonType.setText("");
        
        
    }//GEN-LAST:event_jButtonClearActionPerformed
Manage_Location al1;
    private void ManageLocationClickActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ManageLocationClickActionPerformed
        
        if (al1 == null) {
            al1 = new Manage_Location();
        }
        
        al1.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_ManageLocationClickActionPerformed

    private void BackClickActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackClickActionPerformed
        
         if (al1 == null) {
            al1 = new Manage_Location();
        }
        
        al1.setVisible(true);
        this.dispose();
    
        
    }//GEN-LAST:event_BackClickActionPerformed

    private void DashboardClickActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DashboardClickActionPerformed
       
      
        group_implmentation.loging.dashb.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_DashboardClickActionPerformed

    
//Validation Capacity 0 - 120 user can entered and can't entered negetive values
    private void jTextFieldCapacityKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldCapacityKeyReleased
                  // TODO add your handling code here:
        String PATTERN ="([1-9]|[1-9][0-9]|1[01][0-9]|120)";
        Pattern patt=Pattern.compile(PATTERN);
        Matcher match=patt.matcher(jTextFieldCapacity.getText());

        
        if(!match.matches()){
              erroCapacity.setText("Please Input Number 0-120");
        } else {
            
             erroCapacity.setText(null);
        }    
             
    }//GEN-LAST:event_jTextFieldCapacityKeyReleased

    private void LecturerAction(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LecturerAction
        //equle room type
       room_type= "Lecturer_Hall";
    }//GEN-LAST:event_LecturerAction

//feilds rest functions
    private void jTextFieldBuildingNameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldBuildingNameKeyReleased
       
          erroBuildingName.setText(null);

    }//GEN-LAST:event_jTextFieldBuildingNameKeyReleased

    private void jTextFieldRoomNameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldRoomNameKeyReleased
       
          erroRoomName.setText(null);

    }//GEN-LAST:event_jTextFieldRoomNameKeyReleased

//Save Location
    private void jButtonSaveLocationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSaveLocationActionPerformed
         String BuildingName =jTextFieldBuildingName.getText();
         String    RoomName=jTextFieldRoomName.getText();
         if(jTextFieldLecturerHall.isSelected()){
                    room_type="Lecturer_Hall";
            
         }
          if(jTextFieldLaboratory.isSelected()){
                    room_type="Laboratory";
         } 
         String   Roomtype=room_type;
         String Capacity=jTextFieldCapacity.getText();

            
//This validation is applicable when room type is true.
       if(!("Laboratory".equals(Roomtype) || "Lecturer_Hall".equals(Roomtype))|| jTextFieldBuildingName.getText().trim().isEmpty() || jTextFieldRoomName.getText().trim().isEmpty() || jTextFieldCapacity.getText().trim().isEmpty()){
                  
                Validation();
       }
      else{       
          
         al.SaveLocation(BuildingName, RoomName, Roomtype, Capacity);
      
       } 
          
    }//GEN-LAST:event_jButtonSaveLocationActionPerformed

    private void jTextFieldLecturerHallItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jTextFieldLecturerHallItemStateChanged
        // TODO add your handling code here:
        erroRoonType.setText("");
    }//GEN-LAST:event_jTextFieldLecturerHallItemStateChanged

    private void jTextFieldLaboratoryItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jTextFieldLaboratoryItemStateChanged
        // TODO add your handling code here:
        erroRoonType.setText("");
    }//GEN-LAST:event_jTextFieldLaboratoryItemStateChanged

    private void jTextFieldLaboratoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldLaboratoryActionPerformed
        // TODO add your handling code here:
         room_type="Laboratory";

    }//GEN-LAST:event_jTextFieldLaboratoryActionPerformed

    private void jTextFieldCapacityKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldCapacityKeyTyped
        // TODO add your handling code here:
        char c=evt.getKeyChar();
        if(!Character.isDigit(c)){
             evt.consume();
        }
    }//GEN-LAST:event_jTextFieldCapacityKeyTyped


  //form Validation      
 public void Validation(){
    if(jTextFieldBuildingName.getText().trim().isEmpty() && jTextFieldRoomName.getText().trim().isEmpty() && jTextFieldCapacity.getText().trim().isEmpty() && buttonGroup1.getSelection()==null){
            JOptionPane.showMessageDialog(null, "Fields are Emplty");
   
    } else if(( "Laboratory".equals(room_type)|| "Lecturer_Hall".equals(room_type))&& jTextFieldBuildingName.getText().trim().isEmpty() && jTextFieldRoomName.getText().trim().isEmpty()){
       
                          erroRoomName.setText("Please Enter Room Name");
                          erroBuildingName.setText("Please Select the Building Name");
 
       }
       else if(( "Laboratory".equals(room_type)|| "Lecturer_Hall".equals(room_type)) && jTextFieldBuildingName.getText().trim().isEmpty() && jTextFieldCapacity.getText().trim().isEmpty() ){
                          erroCapacity.setText("please Enter Capacity");
                          erroBuildingName.setText("Please Enter the Building Name");

       }
       else if(( "Laboratory".equals(room_type)|| "Lecturer_Hall".equals(room_type)) && jTextFieldRoomName.getText().trim().isEmpty() && jTextFieldCapacity.getText().trim().isEmpty() ){
                          erroCapacity.setText("please Enter Capacity");
                          erroRoomName.setText("Please Enter Room Name");

       }
       else if(("Laboratory".equals(room_type)|| "Lecturer_Hall".equals(room_type))&& jTextFieldBuildingName.getText().trim().isEmpty()){
                          erroBuildingName.setText("Please Select the Building Name");
    
       }
       else if(("Laboratory".equals(room_type)|| "Lecturer_Hall".equals(room_type))&& jTextFieldCapacity.getText().trim().isEmpty()){
                          erroCapacity.setText("please Enter Capacity");

       }
       else if(( "Laboratory".equals(room_type)|| "Lecturer_Hall".equals(room_type)) && jTextFieldRoomName.getText().trim().isEmpty()){
                          erroCapacity.setText("please Enter Capacity");
       
       }
       else if(buttonGroup1.getSelection()==null){
            
            erroRoonType.setText("Please Select Room Type");
    
       }
       else if(jTextFieldRoomName.getText().trim().isEmpty()){
            erroRoomName.setText("Please Enter Room Name");

    
       }
       else if(jTextFieldCapacity.getText().trim().isEmpty()){
    
            erroCapacity.setText("please Enter Capacity");
            
       
       }
       else if(jTextFieldBuildingName.getText().trim().isEmpty()){
    
            erroBuildingName.setText("Please Enter the Building Name");

       }
        

    }         
    
           
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
            java.util.logging.Logger.getLogger(Add_Location.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Add_Location.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Add_Location.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Add_Location.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
               
                new Add_Location().setVisible(true);
                
            }
        });
        
    }
    public String room_type;

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddLocationClick;
    private javax.swing.JButton BackClick;
    private javax.swing.JButton DashboardClick;
    private javax.swing.JButton ManageLocationClick;
    public javax.swing.ButtonGroup buttonGroup1;
    public javax.swing.JLabel erroBuildingName;
    public javax.swing.JLabel erroCapacity;
    public javax.swing.JLabel erroRoomName;
    public javax.swing.JLabel erroRoonType;
    private javax.swing.JButton jButtonClear;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    public javax.swing.JTextPane jTextFieldBuildingName;
    public javax.swing.JTextPane jTextFieldCapacity;
    public javax.swing.JRadioButton jTextFieldLaboratory;
    public javax.swing.JRadioButton jTextFieldLecturerHall;
    public javax.swing.JTextPane jTextFieldRoomName;
    // End of variables declaration//GEN-END:variables




}