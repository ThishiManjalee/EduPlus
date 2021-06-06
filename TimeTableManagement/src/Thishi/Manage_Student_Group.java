/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Thishi;

import actions.StudentGroup_Delete;
import actions.StudentGroup_Update;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import madu.Add_Lecturer;
import net.proteanit.sql.DbUtils;
import group_implmentation.dashboard;
import javax.swing.SpinnerNumberModel;
import madu.Manage_Lecturer;
/**
 *
 * @author Thishi
 */
public final class Manage_Student_Group extends javax.swing.JFrame {
                StudentGroup_Update sgu=new StudentGroup_Update();
                StudentGroup_Delete sgd=new StudentGroup_Delete();
    /**
     * Creates new form Manage_Student_Group
     */
    public Manage_Student_Group() {
        initComponents();
      
//call methode hidesize()
        hidesize();
                jTable1.setShowGrid(true);
     
        //call methode AcadamicYearSemester
        AcadamicYearSemcombox();
        //call methode Programmecombox
        Programmecombox();
        //call methode negativeSpinner
        jtableColumnWidth();

        negativeSpinnerStop();
          //Gride Add Jtable
        jTable1.setShowGrid(true);
    }
void hidesize(){
  
      setSize(1400, 820);
      setLocationRelativeTo(null);
      setResizable(false); // maximize button disable
      setVisible(true);
      
  
  }
 void LoadDataUpdate(){
  try{
      int row =jTable1.getSelectedRow(); 
      String value =(jTable1.getModel().getValueAt(row, 0).toString());
      sgu.value=Integer.parseInt(value);
  
  }catch(NumberFormatException ex){
  
      JOptionPane.showMessageDialog(null, "Load in Form"+ex.getMessage());
  
  }
 }   
  void LoadDataDelete(){
  try{
      int row =jTable1.getSelectedRow(); 
      String value =(jTable1.getModel().getValueAt(row, 0).toString());
      sgd.value=Integer.parseInt(value);
  
  }catch(NumberFormatException ex){
  
      JOptionPane.showMessageDialog(null, "Load in Form"+ex.getMessage());
  
  }}
void negativeSpinnerStop(){



          ((SpinnerNumberModel) jSpinnerGroupNum.getModel()).setMinimum(0);
          ((SpinnerNumberModel) jSpinnerSubGroupNum.getModel()).setMinimum(0);




}
public void displaytable(){
     
           try{
               try (Connection cn = connection.DB_Connect.ConnecrDB()) {
                   String select="select * from student_group";
                   try (PreparedStatement pst = cn.prepareStatement(select)) {
                       ResultSet rs =pst.executeQuery();
                       while(rs.next()){
                           //Data will be added until finish
                           String stu_id       = String.valueOf(rs.getInt("stu_id"));
                           String programme    = rs.getString("programme");
                           String group_id        = rs.getString("group_id");
                           String group_number=rs.getString("group_number");
                           String sub_group_id=rs.getString("sub_group_id");
                           String sub_group_number=rs.getString("sub_group_number");
                           String acadamic_year_semester=rs.getString("acadamic_year_semester");
                           //string array for store data into jtable
                           String tbData[]={stu_id,acadamic_year_semester,programme,group_number,sub_group_number,group_id,sub_group_id};
                           DefaultTableModel tblModel=(DefaultTableModel)jTable1.getModel();
                           
                           tblModel.addRow(tbData);
                       }
                       rs.close();
                   }
                   cn.close();
               }
                 }catch(SQLException e){
                
                
                    JOptionPane.showMessageDialog(this, e);
                
                }
         
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
                 pst.close();
                 rs.close();
                 cn.close();
  
        } catch (SQLException ex) {
            Logger.getLogger(Add_Lecturer.class.getName()).log(Level.SEVERE, null, ex);
              JOptionPane.showMessageDialog(null, ex);
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
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButtonUpdate = new javax.swing.JButton();
        DeleteButton = new javax.swing.JButton();
        jButtonClear = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jTextFieldSubGroupId = new javax.swing.JTextField();
        jTextFieldGroupId = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jComboBoxProgramme = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jSpinnerSubGroupNum = new javax.swing.JSpinner();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jSpinnerGroupNum = new javax.swing.JSpinner();
        jComboBoxAcadaicYearSem = new javax.swing.JComboBox<>();
        jLabelacayearsem = new javax.swing.JLabel();
        jLabelProgramme = new javax.swing.JLabel();
        jButtonGenerateId = new javax.swing.JButton();
        jLabelGenGroupId = new javax.swing.JLabel();
        jLabelGenSubGroupId = new javax.swing.JLabel();
        AddStudentGroupClick = new javax.swing.JButton();
        ManageStudentGroup = new javax.swing.JButton();
        BackClick = new javax.swing.JButton();
        DashboardClick = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(1400, 820));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pasindu_img/logo.jpeg"))); // NOI18N

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 153, 153));
        jLabel2.setText("Manage Student Group");

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        jTable1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jTable1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Academic year semester", "Programme", "Group Number", "Sub Group Number", "Group ID", "Sub Group ID"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
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
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(50);
            jTable1.getColumnModel().getColumn(1).setPreferredWidth(200);
            jTable1.getColumnModel().getColumn(2).setPreferredWidth(150);
            jTable1.getColumnModel().getColumn(3).setPreferredWidth(150);
            jTable1.getColumnModel().getColumn(4).setPreferredWidth(150);
            jTable1.getColumnModel().getColumn(5).setPreferredWidth(200);
            jTable1.getColumnModel().getColumn(6).setPreferredWidth(100);
        }

        jButtonUpdate.setBackground(new java.awt.Color(0, 153, 153));
        jButtonUpdate.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButtonUpdate.setText("Update");
        jButtonUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonUpdateActionPerformed(evt);
            }
        });

        DeleteButton.setBackground(new java.awt.Color(0, 153, 153));
        DeleteButton.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        DeleteButton.setText("Delete");
        DeleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteButtonActionPerformed(evt);
            }
        });

        jButtonClear.setBackground(new java.awt.Color(0, 153, 153));
        jButtonClear.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButtonClear.setText("Clear");
        jButtonClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonClearActionPerformed(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Selected Details"));

        jTextFieldSubGroupId.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTextFieldSubGroupId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldSubGroupIdActionPerformed(evt);
            }
        });

        jTextFieldGroupId.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Academic Year Semester");

        jComboBoxProgramme.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "" }));
        jComboBoxProgramme.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jComboBoxProgramme.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxProgrammeItemStateChanged(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel7.setText("Group ID");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setText("Group Number");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("Programme");

        jSpinnerSubGroupNum.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jSpinnerSubGroupNum.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSpinnerSubGroupNumStateChanged(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setText("Sub Group Number");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel8.setText("Sub Group ID");

        jSpinnerGroupNum.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jSpinnerGroupNum.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSpinnerGroupNumStateChanged(evt);
            }
        });

        jComboBoxAcadaicYearSem.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));
        jComboBoxAcadaicYearSem.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jComboBoxAcadaicYearSem.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxAcadaicYearSemItemStateChanged(evt);
            }
        });

        jLabelacayearsem.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabelacayearsem.setForeground(new java.awt.Color(255, 0, 0));

        jLabelProgramme.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabelProgramme.setForeground(new java.awt.Color(255, 0, 0));

        jButtonGenerateId.setBackground(new java.awt.Color(0, 153, 153));
        jButtonGenerateId.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButtonGenerateId.setText("Generate IDs");
        jButtonGenerateId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGenerateIdActionPerformed(evt);
            }
        });

        jLabelGenGroupId.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabelGenGroupId.setForeground(new java.awt.Color(51, 255, 51));

        jLabelGenSubGroupId.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabelGenSubGroupId.setForeground(new java.awt.Color(51, 255, 51));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addGap(71, 71, 71)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jSpinnerSubGroupNum, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jSpinnerGroupNum, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(183, 183, 183)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING))
                                .addGap(71, 71, 71)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jTextFieldGroupId)
                                    .addComponent(jTextFieldSubGroupId, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jComboBoxProgramme, 0, 268, Short.MAX_VALUE)
                                    .addComponent(jComboBoxAcadaicYearSem, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabelProgramme, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 48, Short.MAX_VALUE))
                                    .addComponent(jLabelacayearsem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButtonGenerateId, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelGenGroupId, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelGenSubGroupId, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(jComboBoxAcadaicYearSem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabelacayearsem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(24, 24, 24)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxProgramme, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jLabelProgramme, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(jTextFieldGroupId))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelGenGroupId)
                        .addGap(10, 10, 10)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(jTextFieldSubGroupId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)
                            .addComponent(jSpinnerSubGroupNum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jSpinnerGroupNum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelGenSubGroupId)
                .addGap(12, 12, 12)
                .addComponent(jButtonGenerateId, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(DeleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonClear)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonUpdate))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 869, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(DeleteButton)
                    .addComponent(jButtonClear)
                    .addComponent(jButtonUpdate))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(23, 23, 23))
        );

        AddStudentGroupClick.setBackground(new java.awt.Color(0, 153, 153));
        AddStudentGroupClick.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        AddStudentGroupClick.setText("Add Student Groups");
        AddStudentGroupClick.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddStudentGroupClickActionPerformed(evt);
            }
        });

        ManageStudentGroup.setBackground(new java.awt.Color(0, 153, 153));
        ManageStudentGroup.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        ManageStudentGroup.setText("Manage Student Groups");

        BackClick.setBackground(new java.awt.Color(0, 153, 153));
        BackClick.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        BackClick.setText("<<Back");
        BackClick.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackClickActionPerformed(evt);
            }
        });

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
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 439, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(86, 86, 86)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(AddStudentGroupClick, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(ManageStudentGroup, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(DashboardClick, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(159, 159, 159)
                        .addComponent(BackClick, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 441, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(246, 246, 246))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(DashboardClick, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(AddStudentGroupClick)
                .addGap(26, 26, 26)
                .addComponent(ManageStudentGroup)
                .addGap(43, 43, 43)
                .addComponent(BackClick)
                .addGap(0, 127, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldSubGroupIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldSubGroupIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldSubGroupIdActionPerformed

    private void jTable1AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jTable1AncestorAdded
        // TODO add your handling code here:
        displaytable();
    }//GEN-LAST:event_jTable1AncestorAdded

    private void jButtonClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonClearActionPerformed
        // TODO add your handling code here:
        jTextFieldGroupId.setText("");
        jTextFieldSubGroupId.setText("");
        jSpinnerSubGroupNum.setValue(0);
        jSpinnerGroupNum.setValue(0);
        jComboBoxAcadaicYearSem.setSelectedIndex(0);
        jComboBoxProgramme.setSelectedIndex(0);
        jLabelacayearsem.setText("");
        jLabelProgramme.setText("");
        jLabelGenGroupId.setText("");
        jLabelGenSubGroupId.setText("");
        
        
        
    }//GEN-LAST:event_jButtonClearActionPerformed

    private void jButtonUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonUpdateActionPerformed
        // TODO add your handling code here:

        LoadDataUpdate();
              String Programme=jComboBoxProgramme.getSelectedItem().toString();
           String GroupId=jTextFieldGroupId.getText();
           String GroupNumber=jSpinnerGroupNum.getValue().toString();
           String SubGroupId=jTextFieldSubGroupId.getText();
           String SubGroupNumber=jSpinnerSubGroupNum.getValue().toString();
           String AcadamicYearSemester=jComboBoxAcadaicYearSem.getSelectedItem().toString();  
            
     if(jComboBoxAcadaicYearSem.getSelectedIndex() == 0||jComboBoxProgramme.getSelectedIndex()==0||jTextFieldGroupId.getText().trim().isEmpty()||jTextFieldSubGroupId.getText().trim().isEmpty()){
           Validation();
               
     }else{
              sgu.UpdateStudentGroup(Programme, GroupId, GroupNumber, SubGroupId, SubGroupNumber, AcadamicYearSemester);
         
     }
                                    updateRe_table();
 
        
        
    }//GEN-LAST:event_jButtonUpdateActionPerformed

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
    
    
    
    
    
    
    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
           int i=jTable1.getSelectedRow();
           
            TableModel model=jTable1.getModel();
                       jComboBoxAcadaicYearSem.setSelectedItem(model.getValueAt(i, 1).toString());
                       jComboBoxProgramme.setSelectedItem(model.getValueAt(i, 2).toString());
                       jSpinnerGroupNum.setValue(Integer.parseInt((String)model.getValueAt(i, 3)));
                       jSpinnerSubGroupNum.setValue(Integer.parseInt((String)model.getValueAt(i, 4)));
                       jTextFieldGroupId.setText(model.getValueAt(i, 5).toString());
                       jTextFieldSubGroupId.setText(model.getValueAt(i, 6).toString());

         
        
        
        
        
    }//GEN-LAST:event_jTable1MouseClicked
Add_Student_group asg;
    private void AddStudentGroupClickActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddStudentGroupClickActionPerformed
        // TODO add your handling code here:
        
        if(asg == null) {
            asg = new Add_Student_group();
        }
        
        asg.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_AddStudentGroupClickActionPerformed

    private void BackClickActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackClickActionPerformed
        // TODO add your handling code here:
           
        group_implmentation.loging.dashb.setVisible(true);
        this.dispose();

    }//GEN-LAST:event_BackClickActionPerformed

    private void DashboardClickActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DashboardClickActionPerformed
        // TODO add your handling code here:
        
        group_implmentation.loging.dashb.setVisible(true);
        this.dispose();

        
    }//GEN-LAST:event_DashboardClickActionPerformed
Manage_Student_Group msg;
    private void jComboBoxAcadaicYearSemItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxAcadaicYearSemItemStateChanged
        // TODO add your handling code here:
        jTextFieldGroupId.setText("");
        jTextFieldSubGroupId.setText("");
        jLabelacayearsem.setText("");
    }//GEN-LAST:event_jComboBoxAcadaicYearSemItemStateChanged

    private void jComboBoxProgrammeItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxProgrammeItemStateChanged
        // TODO add your handling code here:
        jTextFieldGroupId.setText("");
        jTextFieldSubGroupId.setText("");
        jLabelProgramme.setText("");
    }//GEN-LAST:event_jComboBoxProgrammeItemStateChanged

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

//Delete Student Group    
    private void DeleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteButtonActionPerformed
        // TODO add your handling code here:
      LoadDataDelete();

        DefaultTableModel tableModel = (DefaultTableModel) jTable1.getModel();
        tableModel.setRowCount(0);
        sgd.DeleteStudentGroup();

        displaytable();
        
    }//GEN-LAST:event_DeleteButtonActionPerformed

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
      
private void updateRe_table(){
      

       Connection cn=connection.DB_Connect.ConnecrDB();
       String sql="select *from student_group";

try{
           


    PreparedStatement pst = cn.prepareStatement(sql);
           ResultSet rs = pst.executeQuery();
           jTable1.setModel(DbUtils.resultSetToTableModel(rs));
           jtableColumnWidth();

           rs.close();
           pst.close();
           cn.close();
}catch(SQLException e){
      JOptionPane.showMessageDialog(null, e);
}
    
    }    

//Cretae jtable Column Width Any Sizes
void jtableColumnWidth(){
 
        jTable1.setAutoResizeMode( JTable.AUTO_RESIZE_OFF );
        jTable1.getColumnModel().getColumn(0).setPreferredWidth(250);
        jTable1.getColumnModel().getColumn(1).setPreferredWidth(250);
        jTable1.getColumnModel().getColumn(2).setPreferredWidth(250);
        jTable1.getColumnModel().getColumn(3).setPreferredWidth(250);
        jTable1.getColumnModel().getColumn(4).setPreferredWidth(250);
        jTable1.getColumnModel().getColumn(5).setPreferredWidth(250);
        jTable1.getColumnModel().getColumn(6).setPreferredWidth(250);
        jTable1.getColumnModel().getColumn(7).setPreferredWidth(250);


 
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
            java.util.logging.Logger.getLogger(Manage_Student_Group.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Manage_Student_Group.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Manage_Student_Group.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Manage_Student_Group.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Manage_Student_Group().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddStudentGroupClick;
    private javax.swing.JButton BackClick;
    private javax.swing.JButton DashboardClick;
    private javax.swing.JButton DeleteButton;
    private javax.swing.JButton ManageStudentGroup;
    private javax.swing.JButton jButtonClear;
    private javax.swing.JButton jButtonGenerateId;
    private javax.swing.JButton jButtonUpdate;
    private javax.swing.JComboBox<String> jComboBoxAcadaicYearSem;
    private javax.swing.JComboBox<String> jComboBoxProgramme;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabelGenGroupId;
    private javax.swing.JLabel jLabelGenSubGroupId;
    private javax.swing.JLabel jLabelProgramme;
    private javax.swing.JLabel jLabelacayearsem;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSpinner jSpinnerGroupNum;
    private javax.swing.JSpinner jSpinnerSubGroupNum;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextFieldGroupId;
    private javax.swing.JTextField jTextFieldSubGroupId;
    // End of variables declaration//GEN-END:variables
}
