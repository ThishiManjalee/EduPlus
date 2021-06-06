/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Thishi;

import actions.StudentGroup_Add;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import madu.Add_Lecturer;
import group_implmentation.dashboard;
import javax.swing.SpinnerNumberModel;
import madu.Manage_Lecturer;

/**
 *
 * @author Thishi
 */
public final class Add_Student_group extends javax.swing.JFrame {
    StudentGroup_Add sga=new StudentGroup_Add();
    /**
     * Creates new form Add_Student_group
     */
public Add_Student_group() {
        initComponents();
//Retrive Acadamic Semester Combobox Data        
        AcadamicYearSemcombox();
//Retrive Programme Combox Data        
        Programmecombox();
//Call Methode the Hide Window Size Function        
        hidesize();
//Call Methode the Stop Negative Numbers Stop Spinner        
        negativeSpinnerStop();
    }


//Window HideSize and Stop Maximize
void hidesize(){
  
      setSize(1400, 820);
      setLocationRelativeTo(null);
      setResizable(false); // maximize button disable
      
  
  }
//Negative Numbers Spinner Stop
void negativeSpinnerStop(){

          ((SpinnerNumberModel) jSpinnerGroupNum.getModel()).setMinimum(0);
          ((SpinnerNumberModel) jSpinnerSubGroupNum.getModel()).setMinimum(0);

}

//Retive All the Acadamic year semester Data to Combobox
     void AcadamicYearSemcombox(){
      // TODO add your handling code here:
          try {
                 Connection cn=connection.DB_Connect.ConnecrDB();
            
                 String sql ="select DISTINCT semester from acadamic_sem_year";
                 Statement pst=cn.createStatement();
                 ResultSet rs=pst.executeQuery(sql);
                 while(rs.next()){
                 
                     String yearsem=rs.getString("semester");
                     jComboBoxAcadaicYearSem.addItem(yearsem);
                 
                 }
//Connection Close                 
                 pst.close();
                 rs.close();
                 cn.close();
  
        } catch (SQLException ex) {
            Logger.getLogger(Add_Lecturer.class.getName()).log(Level.SEVERE, null, ex);
              JOptionPane.showMessageDialog(null, ex);
        }
        
         
    }
    
//Retive All the Programme Data to Combobox
     void Programmecombox(){
      // TODO add your handling code here:
          try {
                 Connection cn=connection.DB_Connect.ConnecrDB();
            
                 String sql ="select DISTINCT name from programme";
                 Statement pst=cn.createStatement();
                 ResultSet rs=pst.executeQuery(sql);
                 while(rs.next()){
                 
                     String yearsem=rs.getString("name");
                     jComboBoxProgramme.addItem(yearsem);
                 
                 }
//Connection Close
                pst.close();
                rs.close();
                cn.close();
  
        } catch (SQLException ex) {
            Logger.getLogger(Add_Lecturer.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex);
        }
        
         
    } 
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        AddStudentGroupClick = new javax.swing.JButton();
        ManageStudentGroupsClicks = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jComboBoxProgramme = new javax.swing.JComboBox<>();
        jSpinnerGroupNum = new javax.swing.JSpinner();
        jSpinnerSubGroupNum = new javax.swing.JSpinner();
        jTextFieldGroupId = new javax.swing.JTextField();
        jTextFieldSubGroupId = new javax.swing.JTextField();
        jButtonClear = new javax.swing.JButton();
        jButtonSave = new javax.swing.JButton();
        jButtonGenerateId = new javax.swing.JButton();
        jComboBoxAcadaicYearSem = new javax.swing.JComboBox<>();
        jLabelGenGroupId = new javax.swing.JLabel();
        jLabelGenSubGroupId = new javax.swing.JLabel();
        jLabelProgramme = new javax.swing.JLabel();
        jLabelacayearsem = new javax.swing.JLabel();
        BackClick = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        DashboardClick = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setToolTipText("");
        jPanel1.setPreferredSize(new java.awt.Dimension(1400, 820));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 153, 153));
        jLabel2.setText("Add Student Group");

        AddStudentGroupClick.setBackground(new java.awt.Color(0, 153, 153));
        AddStudentGroupClick.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        AddStudentGroupClick.setText("Add Student Groups");
        AddStudentGroupClick.setActionCommand("");

        ManageStudentGroupsClicks.setBackground(new java.awt.Color(0, 153, 153));
        ManageStudentGroupsClicks.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        ManageStudentGroupsClicks.setText("Manage Student Groups");
        ManageStudentGroupsClicks.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ManageStudentGroupsClicksActionPerformed(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(102, 102, 102));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel2.setPreferredSize(new java.awt.Dimension(600, 620));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Academic Year Semester");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("Programme");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setText("Group Number");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel7.setText("Sub Group Number");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel8.setText("Group ID");

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel9.setText("Sub Group ID");

        jComboBoxProgramme.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));
        jComboBoxProgramme.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jComboBoxProgramme.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxProgrammeItemStateChanged(evt);
            }
        });
        jComboBoxProgramme.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxProgrammeActionPerformed(evt);
            }
        });

        jSpinnerGroupNum.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jSpinnerGroupNum.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSpinnerGroupNumStateChanged(evt);
            }
        });

        jSpinnerSubGroupNum.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jSpinnerSubGroupNum.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSpinnerSubGroupNumStateChanged(evt);
            }
        });

        jTextFieldGroupId.setEditable(false);
        jTextFieldGroupId.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jTextFieldSubGroupId.setEditable(false);
        jTextFieldSubGroupId.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jButtonClear.setBackground(new java.awt.Color(0, 153, 153));
        jButtonClear.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButtonClear.setText("Clear");
        jButtonClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonClearActionPerformed(evt);
            }
        });

        jButtonSave.setBackground(new java.awt.Color(0, 153, 153));
        jButtonSave.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButtonSave.setText("Save");
        jButtonSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSaveActionPerformed(evt);
            }
        });

        jButtonGenerateId.setBackground(new java.awt.Color(0, 153, 153));
        jButtonGenerateId.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButtonGenerateId.setText("Generate IDs");
        jButtonGenerateId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGenerateIdActionPerformed(evt);
            }
        });

        jComboBoxAcadaicYearSem.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));
        jComboBoxAcadaicYearSem.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxAcadaicYearSemItemStateChanged(evt);
            }
        });

        jLabelGenGroupId.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabelGenGroupId.setForeground(new java.awt.Color(153, 255, 0));

        jLabelGenSubGroupId.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabelGenSubGroupId.setForeground(new java.awt.Color(153, 255, 0));

        jLabelProgramme.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabelProgramme.setForeground(java.awt.Color.red);

        jLabelacayearsem.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabelacayearsem.setForeground(java.awt.Color.red);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabelGenGroupId, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addGap(89, 89, 89)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jComboBoxProgramme, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel5)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jButtonClear)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jButtonSave)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jButtonGenerateId))
                                    .addComponent(jLabel3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jSpinnerGroupNum)
                                    .addComponent(jSpinnerSubGroupNum)
                                    .addComponent(jTextFieldGroupId)
                                    .addComponent(jTextFieldSubGroupId)
                                    .addComponent(jComboBoxAcadaicYearSem, 0, 268, Short.MAX_VALUE)))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabelProgramme, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelacayearsem, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelGenSubGroupId, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(103, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxAcadaicYearSem, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addComponent(jLabelacayearsem)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jComboBoxProgramme, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelProgramme, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5)
                    .addComponent(jSpinnerGroupNum, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jSpinnerSubGroupNum, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(68, 68, 68)
                        .addComponent(jLabel8))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addComponent(jTextFieldGroupId, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelGenGroupId, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel9)
                    .addComponent(jTextFieldSubGroupId, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabelGenSubGroupId, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonClear)
                    .addComponent(jButtonSave)
                    .addComponent(jButtonGenerateId))
                .addGap(55, 55, 55))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 807, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 644, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        BackClick.setBackground(new java.awt.Color(0, 153, 153));
        BackClick.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        BackClick.setText("<<Back");
        BackClick.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackClickActionPerformed(evt);
            }
        });

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pasindu_img/logo.jpeg"))); // NOI18N

        DashboardClick.setBackground(new java.awt.Color(0, 153, 153));
        DashboardClick.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        DashboardClick.setText("Dashboard");
        DashboardClick.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DashboardClickActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(110, 110, 110)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(ManageStudentGroupsClicks, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(AddStudentGroupClick, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(DashboardClick, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGap(76, 76, 76)
                                .addComponent(BackClick, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(57, 57, 57)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(224, 224, 224)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(85, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(89, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addComponent(DashboardClick, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(AddStudentGroupClick)
                .addGap(39, 39, 39)
                .addComponent(ManageStudentGroupsClicks)
                .addGap(34, 34, 34)
                .addComponent(BackClick)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1412, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 12, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 846, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

//Clear All The Warning Messages /Messages And All Feildes
    private void jButtonClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonClearActionPerformed
        // TODO add your handling code here:
        jComboBoxAcadaicYearSem.setSelectedIndex(0);
        jComboBoxProgramme.setSelectedIndex(0);
        jSpinnerGroupNum.setValue(0);
        jSpinnerSubGroupNum.setValue(0);
        jTextFieldGroupId.setText("");
        jTextFieldSubGroupId.setText("");
        jLabelGenGroupId.setText(null);
        jLabelGenSubGroupId.setText(null);
        jLabelacayearsem.setText("");
        jLabelProgramme.setText("");
     

    }//GEN-LAST:event_jButtonClearActionPerformed

//Generate GroupId /GroupsubId Methode Action Performed    
    private void jButtonGenerateIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGenerateIdActionPerformed
        // TODO add your handling code here:
//Check Vaildation jCombox Acadamic semester and Programme Empty       
        if(jComboBoxProgramme.getSelectedIndex()!=0 && jComboBoxAcadaicYearSem.getSelectedIndex()!=0){
//Call Mehode genertaeGroupId        
        genertaeGroupId();
//Call Mehode generateSubGroupId        
        genertaeSubGroupId();
        
        }
//Ckeck Vaildation Programme Emplty         
        else if(jComboBoxProgramme.getSelectedIndex()==0 ){
                   //Display Message        
                   jLabelProgramme.setText("Please Select the Programme");
        }
//Check Validation Acadamic Semester Empty        
        else if(jComboBoxAcadaicYearSem.getSelectedIndex()==0){
                  //Display Message
                   jLabelacayearsem.setText("Please Select the Acadamic Semester Year");

        }
//Check Vaildation Programme Empty
        else if(jComboBoxProgramme.getSelectedIndex()==0 && jComboBoxAcadaicYearSem.getSelectedIndex()==0){
                  //Display Message
                  jLabelProgramme.setText("Please Select the Programme");
                  jLabelacayearsem.setText("Please Select the Acadamic Semester Year");

        
        }
        
    }//GEN-LAST:event_jButtonGenerateIdActionPerformed

//Insert data database
    private void jButtonSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSaveActionPerformed
        // TODO add your handling code here:
           
       
           String Programme=jComboBoxProgramme.getSelectedItem().toString();
           String GroupId=jTextFieldGroupId.getText();
           String GroupNumber=jSpinnerGroupNum.getValue().toString();
           String SubGroupId=jTextFieldSubGroupId.getText();
           String SubGroupNumber=jSpinnerSubGroupNum.getValue().toString();
           String AcadamicYearSemester=jComboBoxAcadaicYearSem.getSelectedItem().toString();       
           
           
            
          
     //Check Vaildation All jComboBox Index Empty       
     if(jComboBoxAcadaicYearSem.getSelectedIndex() == 0||jComboBoxProgramme.getSelectedIndex()==0||jTextFieldGroupId.getText().trim().isEmpty()||jTextFieldSubGroupId.getText().trim().isEmpty()){
        //Call Validation
         Validation();
     }else{
     
         sga.Add_StudentGroup(Programme, GroupId, GroupNumber, SubGroupId, SubGroupNumber, AcadamicYearSemester);
     }
   
            
            
           
     
    }//GEN-LAST:event_jButtonSaveActionPerformed

    private void DashboardClickActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DashboardClickActionPerformed
        // TODO add your handling code here:
         group_implmentation.loging.dashb.setVisible(true);
        this.dispose();
        
    }//GEN-LAST:event_DashboardClickActionPerformed
Manage_Student_Group msg;
    private void ManageStudentGroupsClicksActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ManageStudentGroupsClicksActionPerformed
        // TODO add your handling code here:
       
        if (msg == null) {
            msg = new Manage_Student_Group();
        }
        
        msg.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_ManageStudentGroupsClicksActionPerformed
Manage_Student_Group ms;
    private void BackClickActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackClickActionPerformed
        // TODO add your handling code here:
            
        if (ms == null) {
            ms = new Manage_Student_Group();
        }
        
        ms.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_BackClickActionPerformed

    private void jComboBoxAcadaicYearSemItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxAcadaicYearSemItemStateChanged
        // TODO add your handling code here:
        jLabelacayearsem.setText("");
        jTextFieldGroupId.setText("");
        jTextFieldSubGroupId.setText("");
    }//GEN-LAST:event_jComboBoxAcadaicYearSemItemStateChanged

    private void jComboBoxProgrammeItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxProgrammeItemStateChanged
        // TODO add your handling code here:
        jLabelProgramme.setText("");
        jTextFieldGroupId.setText("");
        jTextFieldSubGroupId.setText("");
    }//GEN-LAST:event_jComboBoxProgrammeItemStateChanged

    private void jComboBoxProgrammeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxProgrammeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxProgrammeActionPerformed

    private void jSpinnerGroupNumStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSpinnerGroupNumStateChanged
        // TODO add your handling code here:
         jTextFieldGroupId.setText("");
        jTextFieldSubGroupId.setText("");
    }//GEN-LAST:event_jSpinnerGroupNumStateChanged

    private void jSpinnerSubGroupNumStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSpinnerSubGroupNumStateChanged
        // TODO add your handling code here:
        jTextFieldGroupId.setText("");
        jTextFieldSubGroupId.setText("");
    }//GEN-LAST:event_jSpinnerSubGroupNumStateChanged

 
//Generate GroupID    
    void genertaeGroupId(){
     // TODO add your handling code here:
   
     
       String acadamicsem=jComboBoxAcadaicYearSem.getSelectedItem().toString();
       String programme=jComboBoxProgramme.getSelectedItem().toString();
       String groupnum=jSpinnerGroupNum.getValue().toString();
        
     // String groupid
       String groupid = String.join(".",acadamicsem,programme,groupnum );

        //Display Group ID
        jTextFieldGroupId.setText(groupid);
     
    }

//Generate SubGroup Id    
    void genertaeSubGroupId(){
    
       String acadamicsem=jComboBoxAcadaicYearSem.getSelectedItem().toString();
       String programme=jComboBoxProgramme.getSelectedItem().toString();
       String groupnum=jSpinnerGroupNum.getValue().toString();
       String subgroupnum=jSpinnerSubGroupNum.getValue().toString();
       
       //String Subgroupid
       String subgroupid =String.join(".",acadamicsem,programme ,groupnum,subgroupnum);

    
    
     if(subgroupid!=null){
        
           jLabelGenGroupId.setText("Generate Success");
           jLabelGenSubGroupId.setText("Generate Success");
          //Display Sub Group Id
           jTextFieldSubGroupId.setText(subgroupid);

           
        }
     else{
               JOptionPane.showMessageDialog(this, "system erro");


     }

    }
  
 //Validation   
    void Validation(){

 //Check Vaildation All jComboBox Index Empty       
     if(jComboBoxAcadaicYearSem.getSelectedIndex() == 0&&jComboBoxProgramme.getSelectedIndex()==0&&jTextFieldGroupId.getText().trim().isEmpty()&&jTextFieldSubGroupId.getText().trim().isEmpty()){
         //Display Messages
         jLabelacayearsem.setText("Please Selesct Semester Year");
         jLabelProgramme.setText("Please Select the Programme");
         jLabelGenGroupId.setText("Please Generate GroupId");
         jLabelGenSubGroupId.setText("Please Generate Sub GroupId ");
    
    }//Checck Validation
     else if(jTextFieldGroupId.getText().trim().isEmpty()&&jTextFieldSubGroupId.getText().trim().isEmpty()){
         //Dsplay Message
         jLabelGenGroupId.setText("Please Generate GroupId");
         jLabelGenSubGroupId.setText("Please Generate Sub GroupId ");
    }//Check Vaildation
     else if(jComboBoxAcadaicYearSem.getSelectedIndex() == 0){
         //Display Message
         jLabelacayearsem.setText("Please Selesct Semester Year");

    }//Check Vaildatiom
     else if(jComboBoxProgramme.getSelectedIndex()==0){
         //Display Message
         jLabelProgramme.setText("Please Select the Programme");

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
            java.util.logging.Logger.getLogger(Add_Student_group.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Add_Student_group.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Add_Student_group.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Add_Student_group.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Add_Student_group().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddStudentGroupClick;
    private javax.swing.JButton BackClick;
    private javax.swing.JButton DashboardClick;
    private javax.swing.JButton ManageStudentGroupsClicks;
    private javax.swing.JButton jButtonClear;
    private javax.swing.JButton jButtonGenerateId;
    private javax.swing.JButton jButtonSave;
    private javax.swing.JComboBox<String> jComboBoxAcadaicYearSem;
    private javax.swing.JComboBox<String> jComboBoxProgramme;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelGenGroupId;
    private javax.swing.JLabel jLabelGenSubGroupId;
    private javax.swing.JLabel jLabelProgramme;
    private javax.swing.JLabel jLabelacayearsem;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JSpinner jSpinnerGroupNum;
    private javax.swing.JSpinner jSpinnerSubGroupNum;
    private javax.swing.JTextField jTextFieldGroupId;
    private javax.swing.JTextField jTextFieldSubGroupId;
    // End of variables declaration//GEN-END:variables
}
