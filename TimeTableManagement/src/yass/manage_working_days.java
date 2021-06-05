/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package yass;

import actions.WorkingDays_Delete;
import actions.WorkingDays_Update;
import java.awt.HeadlessException;
import java.awt.event.ItemEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import net.proteanit.sql.DbUtils;
import group_implmentation.dashboard;
import javax.swing.SpinnerNumberModel;
/**
 *
 * @author yass
 */
public final class manage_working_days extends javax.swing.JFrame {
                    WorkingDays_Update wu=new WorkingDays_Update();
                    WorkingDays_Delete wd =new WorkingDays_Delete();
    /** Creates new form manage_working_days */
    public manage_working_days() {
        initComponents();
        jtableColumnWidth();
        //Call window Hide Size Methode
        hidesize();
        //Call Minus Stop Spinner
        spinnerMinusStop();
        //Gride Add Jtable
        jTable1.setShowGrid(true);
    }
  //Hidden Window Size Methode  
  void hidesize(){
  
      setSize(1400, 820);
      setLocationRelativeTo(null);
      setResizable(false); // maximize button disable
      
  
  }    
    
 //Set Spinner Without Negative Numbers
  void spinnerMinusStop(){
  
          ((SpinnerNumberModel) jSpinnerHours.getModel()).setMinimum(0);
          ((SpinnerNumberModel) jSpinnerMini.getModel()).setMinimum(0);
 
  }
void LoadDataUpdate(){
  try{
      int row =jTable1.getSelectedRow(); 
      String value =(jTable1.getModel().getValueAt(row, 0).toString());
      wu.value=Integer.parseInt(value);
  
  }catch(NumberFormatException ex){
  
      JOptionPane.showMessageDialog(null, "Load in Form"+ex.getMessage());
  
  }
 }   
  void LoadDataDelete(){
  try{
      int row =jTable1.getSelectedRow(); 
      String value =(jTable1.getModel().getValueAt(row, 0).toString());
      wd.value=Integer.parseInt(value);
  
  }catch(NumberFormatException ex){
  
      JOptionPane.showMessageDialog(null, "Load in Form"+ex.getMessage());
  
  }
 }   
//Open ,Close selection Validation
   void openCloseValidation(){
    if(   jCheckBoxMon.isSelected()){
             
                day1="Open";

            }
            else {
             
                day1="Close";
            } 
    if(  jCheckBoxTue.isSelected()){
                
                day2="Open";
            
            }
            else{
            
                day2="Close";
            }
   
    if(  jCheckBoxWen.isSelected()){
           
                day3="Open";
           }
           else{
           
                day3="Close";
           }
    if(  jCheckBoxThu.isSelected()){
           
                day4="Open";
           }
           else{
           
                day4="Close";
           } 
    if(  jCheckBoxFri.isSelected()){
           
                day5="Open";
           }
           else{
           
                day5="Close";
           }
   if(  jCheckBoxSat.isSelected()){
           
                day6="Open";
           }
           else{
           
                day6="Close";
           }
   if(  jCheckBoxSun.isSelected()){
           
                day7="Open";
           }
           else{
           
                day7="Close";
           }
   
   } 
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        AddWorkingDaysButton = new javax.swing.JButton();
        ManageWorkingDaysButton = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jSpinnerWorkingdays = new javax.swing.JSpinner();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jSpinnerHours = new javax.swing.JSpinner();
        jSpinnerMini = new javax.swing.JSpinner();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jButtonUpdate = new javax.swing.JButton();
        jButtonDelete = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jCheckBoxMon = new javax.swing.JCheckBox();
        jCheckBoxTue = new javax.swing.JCheckBox();
        jCheckBoxWen = new javax.swing.JCheckBox();
        jCheckBoxThu = new javax.swing.JCheckBox();
        jCheckBoxFri = new javax.swing.JCheckBox();
        jCheckBoxSat = new javax.swing.JCheckBox();
        jCheckBoxSun = new javax.swing.JCheckBox();
        BackButton = new javax.swing.JButton();
        DashBoardClick = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setMinimumSize(new java.awt.Dimension(1400, 820));
        jPanel1.setRequestFocusEnabled(false);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pasindu_img/logo.jpeg"))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 153, 153));
        jLabel2.setText("Manage Working Days And Hours");

        AddWorkingDaysButton.setBackground(new java.awt.Color(0, 153, 153));
        AddWorkingDaysButton.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        AddWorkingDaysButton.setText("Add Working Days");
        AddWorkingDaysButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddWorkingDaysButtonActionPerformed(evt);
            }
        });

        ManageWorkingDaysButton.setBackground(new java.awt.Color(0, 153, 153));
        ManageWorkingDaysButton.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        ManageWorkingDaysButton.setText("Manage Working Days");

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setText("No.of Working Days");

        jSpinnerWorkingdays.setEnabled(false);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setText("Working Days");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setText("Working Time  Per Day");

        jTextField1.setEditable(false);
        jTextField1.setBackground(new java.awt.Color(102, 102, 102));
        jTextField1.setForeground(new java.awt.Color(255, 255, 255));
        jTextField1.setText("H");

        jTextField2.setEditable(false);
        jTextField2.setBackground(new java.awt.Color(102, 102, 102));
        jTextField2.setForeground(new java.awt.Color(255, 255, 255));
        jTextField2.setText("M");

        jButtonUpdate.setBackground(new java.awt.Color(0, 153, 153));
        jButtonUpdate.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jButtonUpdate.setText("Update");
        jButtonUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonUpdateActionPerformed(evt);
            }
        });

        jButtonDelete.setBackground(new java.awt.Color(0, 153, 153));
        jButtonDelete.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jButtonDelete.setText("Delete");
        jButtonDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDeleteActionPerformed(evt);
            }
        });

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "wd_id", "Added Date/Time", "Working Days", "Monday", "Tuesday", "Wensday", "Thursday", "Friday", "Saturday", "Sunday", "Working_Time_Perday_hr", "Working_Time_perday_min"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setGridColor(new java.awt.Color(51, 153, 255));
        jTable1.setRowHeight(55);
        jTable1.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                jTable1AncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jCheckBoxMon.setText("Monday");
        jCheckBoxMon.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                AllCount(evt);
            }
        });

        jCheckBoxTue.setText("Tuesday");
        jCheckBoxTue.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                AllCount(evt);
            }
        });

        jCheckBoxWen.setText("Wednesday");
        jCheckBoxWen.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                AllCount(evt);
            }
        });

        jCheckBoxThu.setText("Thursday");
        jCheckBoxThu.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                AllCount(evt);
            }
        });

        jCheckBoxFri.setText("Friday");
        jCheckBoxFri.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                AllCount(evt);
            }
        });

        jCheckBoxSat.setText("Saturday");
        jCheckBoxSat.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                AllCount(evt);
            }
        });

        jCheckBoxSun.setText("Sunday");
        jCheckBoxSun.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                AllCount(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(225, 225, 225)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(112, 112, 112)
                                .addComponent(jCheckBoxTue)
                                .addGap(18, 18, 18)
                                .addComponent(jCheckBoxWen)
                                .addGap(18, 18, 18)
                                .addComponent(jCheckBoxThu))
                            .addComponent(jCheckBoxMon))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                        .addComponent(jCheckBoxFri)
                        .addGap(18, 18, 18)
                        .addComponent(jCheckBoxSat)
                        .addGap(18, 18, 18)
                        .addComponent(jCheckBoxSun)
                        .addContainerGap(45, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(225, 225, 225)
                                        .addComponent(jSpinnerHours, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel5))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jSpinnerMini, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jSpinnerWorkingdays, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 822, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButtonUpdate)
                    .addComponent(jButtonDelete))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(114, 114, 114)
                        .addComponent(jButtonUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(jButtonDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 117, Short.MAX_VALUE)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSpinnerWorkingdays, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jCheckBoxMon)
                        .addComponent(jCheckBoxTue)
                        .addComponent(jCheckBoxWen)
                        .addComponent(jCheckBoxThu)
                        .addComponent(jCheckBoxFri)
                        .addComponent(jCheckBoxSat)
                        .addComponent(jCheckBoxSun)))
                .addGap(39, 39, 39)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jSpinnerHours, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSpinnerMini, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(143, 143, 143))
        );

        BackButton.setBackground(new java.awt.Color(0, 153, 153));
        BackButton.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        BackButton.setText("<<BACK");
        BackButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackButtonActionPerformed(evt);
            }
        });

        DashBoardClick.setBackground(new java.awt.Color(0, 153, 153));
        DashBoardClick.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        DashBoardClick.setText("Dashboard");
        DashBoardClick.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DashBoardClickActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 371, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(131, 131, 131)
                        .addComponent(BackButton))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(AddWorkingDaysButton, javax.swing.GroupLayout.DEFAULT_SIZE, 279, Short.MAX_VALUE)
                            .addComponent(ManageWorkingDaysButton, javax.swing.GroupLayout.DEFAULT_SIZE, 279, Short.MAX_VALUE)
                            .addComponent(DashBoardClick, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(40, 40, 40)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(202, 202, 202)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 617, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(37, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(DashBoardClick, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(AddWorkingDaysButton, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addComponent(ManageWorkingDaysButton, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52)
                .addComponent(BackButton, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(160, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
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
//Update Data
    private void jButtonUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonUpdateActionPerformed
        
                 LoadDataUpdate(); 
            
                //call Open Close identfy Validation
                 openCloseValidation();

                 String WorkingDays =jSpinnerWorkingdays.getValue().toString();
                 String Day1=day1;
                 String Day2=day2;
                 String Day3=day3;
                 String Day4=day4;
                 String Day5=day5;
                 String Day6=day6;
                 String Day7=day7;
                 String WorkingTimeHr=jSpinnerHours.getValue().toString();
                 String WorkingTimeMin=jSpinnerMini.getValue().toString();
                          
                
                 wu.UpdateWorkingDays( WorkingDays, Day1, Day2, Day3, Day4, Day5, Day6, Day7, WorkingTimeHr, WorkingTimeMin);

                 updateRe_table();
       
            
        
    }//GEN-LAST:event_jButtonUpdateActionPerformed
    
    private void jTable1AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jTable1AncestorAdded
   // TODO add your handling code here:
        //Call Methode
        displaytable();
    }//GEN-LAST:event_jTable1AncestorAdded

//Row Select And Display data
    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
         int i=jTable1.getSelectedRow();
         TableModel model=jTable1.getModel();
        
            jSpinnerWorkingdays.setValue(Integer.parseInt((String)model.getValueAt(i,2)));
            day1 = model.getValueAt(i, 3).toString();
            day2 = model.getValueAt(i, 4).toString();
            day3 = model.getValueAt(i, 5).toString();
            day4 = model.getValueAt(i, 6).toString();
            day5 = model.getValueAt(i, 7).toString();
            day6 = model.getValueAt(i, 8).toString();
            day7 = model.getValueAt(i, 9).toString();
            //Call the Methhode
            selectOpenCloseDisplay();


            jSpinnerHours.setValue(Integer.parseInt((String)model.getValueAt(i,10)));
            jSpinnerMini.setValue(Integer.parseInt((String)model.getValueAt(i, 11)));
       
         
    }//GEN-LAST:event_jTable1MouseClicked
//Delete Selected Row Data
    private void jButtonDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDeleteActionPerformed
        // TODO add your handling code here:
          LoadDataDelete();

          wd.WorkingDaysDelete();
        DefaultTableModel tableModel = (DefaultTableModel) jTable1.getModel();
        tableModel.setRowCount(0);
          displaytable();
        
        
        
    }//GEN-LAST:event_jButtonDeleteActionPerformed

//Check Box Select and Count Data    
    private void AllCount(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_AllCount
    

        if(evt.getSource().getClass() == JCheckBox.class)
    {
        if(evt.getStateChange() == ItemEvent.SELECTED){
            countChecked++;
                jSpinnerWorkingdays.setValue(countChecked);

        
        } else if(evt.getStateChange() == ItemEvent.DESELECTED)
            countChecked--;
                jSpinnerWorkingdays.setValue(countChecked);
    }
    }//GEN-LAST:event_AllCount
    private int countChecked =0;    
    

    private void DashBoardClickActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DashBoardClickActionPerformed
        // TODO add your handling code here
     
        group_implmentation.loging.dashb.setVisible(true);
        this.dispose();
        
    }//GEN-LAST:event_DashBoardClickActionPerformed
add_working_days awd;
    private void AddWorkingDaysButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddWorkingDaysButtonActionPerformed
        // TODO add your handling code here:
       if (awd == null) {
            awd = new add_working_days();
        }
        
        awd.setVisible(true);
        this.dispose(); 
    }//GEN-LAST:event_AddWorkingDaysButtonActionPerformed

    private void BackButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackButtonActionPerformed
        // TODO add your handling code here:
       group_implmentation.loging.dashb.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_BackButtonActionPerformed
      
    
//Jtable Mouse Click after identyfly Validation     
void selectOpenCloseDisplay(){
       
        switch (day1) {
            case "Open":
                jCheckBoxMon.setSelected(true);
                
                break;
            case "Close":
                jCheckBoxMon.setSelected(false);
                break;
            default:
                JOptionPane.showMessageDialog(this, "system erro");
                break;
        } 
    
        switch (day2) {
            case "Open":
                jCheckBoxTue.setSelected(true);
                break;
            case "Close":
                 jCheckBoxTue.setSelected(false);
                break;
            default:
                JOptionPane.showMessageDialog(this, "system erro");
                break;
        } 
        switch (day3) {
            case "Open":
                 jCheckBoxWen.setSelected(true);
                break;
            case "Close":
                 jCheckBoxWen.setSelected(false);
                break;
            default:
                JOptionPane.showMessageDialog(this, "system erro");
                break;
        }
        switch (day4) {
            case "Open":
                 jCheckBoxThu.setSelected(true);
                break;
            case "Close":
                 jCheckBoxThu.setSelected(false);
                break;
            default:
                JOptionPane.showMessageDialog(this, "system erro");
                break;
        } 
        switch (day5) {
            case "Open":
                 jCheckBoxFri.setSelected(true);
                break;
            case "Close":
                jCheckBoxFri.setSelected(false);
                break;
            default:
                JOptionPane.showMessageDialog(this, "system erro");
                break;
        } 
        switch (day6) {
            case "Open":
                 jCheckBoxSat.setSelected(true);
                break;
            case "Close":
                 jCheckBoxSat.setSelected(false);
                break;
            default:
                JOptionPane.showMessageDialog(this, "system erro");
                break;
        } 
        switch (day7) {
            case "Open":
               jCheckBoxSun.setSelected(true);
                break;
            case "Close":
                jCheckBoxSun.setSelected(false);
                break;
            default:
                JOptionPane.showMessageDialog(this, "system erro");
                break;
        } 
    
   } 
    
//Updata data    
void updateRe_table(){    
    Connection cn=connection.DB_Connect.ConnecrDB();
       String sql="select *from working_days_hours";

try{
           PreparedStatement pst = cn.prepareStatement(sql);
           ResultSet rs = pst.executeQuery();
            jTable1.setModel(DbUtils.resultSetToTableModel(rs));
            jtableColumnWidth();
      //Connection Close      
            rs.close();
            pst.close();
            cn.close();
}catch(SQLException e){
      JOptionPane.showMessageDialog(null, e);
}
    
    
} 

//Set jtable Column Width Methode
void jtableColumnWidth(){

//Cretae jtable Column Width Any Sizes
 
        jTable1.setAutoResizeMode( JTable.AUTO_RESIZE_OFF );
        jTable1.getColumnModel().getColumn(0).setPreferredWidth(250);
        jTable1.getColumnModel().getColumn(1).setPreferredWidth(250);
        jTable1.getColumnModel().getColumn(2).setPreferredWidth(250);
        jTable1.getColumnModel().getColumn(3).setPreferredWidth(250);
        jTable1.getColumnModel().getColumn(4).setPreferredWidth(250);
        jTable1.getColumnModel().getColumn(5).setPreferredWidth(250);
        jTable1.getColumnModel().getColumn(6).setPreferredWidth(250);
        jTable1.getColumnModel().getColumn(7).setPreferredWidth(250);
        jTable1.getColumnModel().getColumn(8).setPreferredWidth(250);
        jTable1.getColumnModel().getColumn(9).setPreferredWidth(250);
        jTable1.getColumnModel().getColumn(10).setPreferredWidth(250);
        jTable1.getColumnModel().getColumn(11).setPreferredWidth(250);


}   

//Display All Data in Jtable
   public void displaytable(){
     
           try{
               try (Connection cn = connection.DB_Connect.ConnecrDB()) {
                   String select="select * from working_days_hours";
                   PreparedStatement pst=cn.prepareStatement(select);
                   
                   
                   
                   ResultSet rs =pst.executeQuery();
                   while(rs.next()){
                       //Data will be added until finish
                       String wd_id       = String.valueOf(rs.getInt("wd_id"));
                       String datetime=rs.getString("datetime");
                       String working_days    = rs.getString("working_days");
                       String monday=rs.getString("monday");
                       String tuesday  = rs.getString("tuesday");
                       String wensday  = rs.getString("wensday");
                       String thursday=rs.getString("thursday");
                       String friday   = rs.getString("friday");
                       String saturday=rs.getString("saturday");
                       String sunday=rs.getString("sunday");
                       String working_time_perday_hr=rs.getString("working_time_perday_hr");
                       String working_time_perday_min=rs.getString("working_time_perday_min");

                       //string array for store data into jtable
                       String tbData[]={wd_id,datetime,working_days,monday,tuesday,wensday,thursday,friday,saturday,sunday,working_time_perday_hr,working_time_perday_min};
                       DefaultTableModel tblModel=(DefaultTableModel)jTable1.getModel();
                       
                       tblModel.addRow(tbData);
                       
             
                   }
               }
                 }catch(SQLException e){
                
                //Display null Meaasge
                    JOptionPane.showMessageDialog(this, e);
                
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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(manage_working_days.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new manage_working_days().setVisible(true);
            }
        });
    }
    String day1,day2,day3,day4,day5,day6,day7;

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddWorkingDaysButton;
    private javax.swing.JButton BackButton;
    private javax.swing.JButton DashBoardClick;
    private javax.swing.JButton ManageWorkingDaysButton;
    private javax.swing.JButton jButtonDelete;
    private javax.swing.JButton jButtonUpdate;
    private javax.swing.JCheckBox jCheckBoxFri;
    private javax.swing.JCheckBox jCheckBoxMon;
    private javax.swing.JCheckBox jCheckBoxSat;
    private javax.swing.JCheckBox jCheckBoxSun;
    private javax.swing.JCheckBox jCheckBoxThu;
    private javax.swing.JCheckBox jCheckBoxTue;
    private javax.swing.JCheckBox jCheckBoxWen;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSpinner jSpinnerHours;
    private javax.swing.JSpinner jSpinnerMini;
    private javax.swing.JSpinner jSpinnerWorkingdays;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables

}
