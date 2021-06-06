/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package madu;
import Thishi.View_Tables;
import group_implmentation.dashboard;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import actions.Lecturer_Add;
/**
 *
 * @author Madu
 */
public final class Add_Lecturer extends javax.swing.JFrame {
     Lecturer_Add la=new Lecturer_Add();
    /**
     * Creates new form Add_Lecturer
     */
    public Add_Lecturer() {
        initComponents();
       //call the data retrive database  function(Building)
        buildingcombox();
//implement the hide size
        hidesize();
       
//call the data retrive database function(Faculty)
        facultycombox();
//call the data retrive deatabase function(Department)
       departmentcombox();
//call the data retrive database  function(Center)
        centercombox();

//call the data retrive database  function(Level)
        levelbox();
    }

//Set Size Window Application And Disable Maxzimize
    void hidesize(){
  
      setSize(1400, 820);
      setLocationRelativeTo(null);
      setResizable(false); // maximize button disable
     
  
  }
//Retive All the Faculty Data to Combobox
     void facultycombox(){
      // TODO add your handling code here:
          try {
                 Connection cn=connection.DB_Connect.ConnecrDB();
            
                 String sql ="select DISTINCT name from faculty_dep";
                 Statement pst=cn.createStatement();
                 ResultSet rs=pst.executeQuery(sql);
                 while(rs.next()){
                 
                     String name=rs.getString("name");
                     jComboFaculty.addItem(name);
                 
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
    
//Retrive All the Department Data to Combobox
     void departmentcombox(){
          try {
              try (Connection cn = connection.DB_Connect.ConnecrDB()) {
                  String sql1 ="select DISTINCT department from faculty_dep ";
                  Statement pst=cn.createStatement();
                  ResultSet rs=pst.executeQuery(sql1);
                  while(rs.next()){
                      
                      String department=rs.getString("department");
                      jComboDepartment.addItem(department);
                      
                  }
             //Connection Close
             pst.close();
             rs.close();
             cn.close();
              }

           
       
        
        } catch (SQLException ex) {
            Logger.getLogger(Add_Lecturer.class.getName()).log(Level.SEVERE, null, ex);
              JOptionPane.showMessageDialog(null, ex);
        }
        
         
     
     }
     
//Retrive All the Center Data to Combox
      void centercombox(){
          try {
                 Connection cn=connection.DB_Connect.ConnecrDB();
            
                 String sql1 ="select DISTINCT name from center";
                 Statement pst=cn.createStatement();
                 ResultSet rs=pst.executeQuery(sql1);
                 while(rs.next()){
                 
                     String name=rs.getString("name");
                     jComboCenter.addItem(name);
                 
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
//Retrive All the Building Data to Combobox

    void buildingcombox(){
      // TODO add your handling code here:
          try {
                 Connection cn=connection.DB_Connect.ConnecrDB();
            
                  String sql ="select DISTINCT building from location ";
                 Statement pst=cn.createStatement();
                 ResultSet rs=pst.executeQuery(sql);
                 while(rs.next()){
                 
                     String building=rs.getString("building");
                     jComboBuilding.addItem(building);
                 
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
//Retive All the levels to combox
     void levelbox(){
       try {
           try (Connection cn = connection.DB_Connect.ConnecrDB()) {
               String sql1 ="select DISTINCT level_num from level";
               Statement pst=cn.createStatement();
               ResultSet rs=pst.executeQuery(sql1);
               while(rs.next()){
                   
                   String building=rs.getString("level_num");
                   jComboLevel.addItem(building);
                   
               }
               //Connection Close
               pst.close();
               rs.close();
               cn.close();
           }

     
       
        
        } catch (SQLException ex) {
            Logger.getLogger(Add_Lecturer.class.getName()).log(Level.SEVERE, null, ex);
            //Display Message
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
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTextLecturerName = new javax.swing.JTextField();
        jTextEmpId = new javax.swing.JTextField();
        jComboFaculty = new javax.swing.JComboBox<>();
        jComboDepartment = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jComboCenter = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        jComboBuilding = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        jComboLevel = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        jTextRank = new javax.swing.JTextField();
        buttongenaraterank = new javax.swing.JButton();
        jButtonSaveLecturer = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        errolecturername = new javax.swing.JLabel();
        erroempid = new javax.swing.JLabel();
        errofaculty = new javax.swing.JLabel();
        errodepartment = new javax.swing.JLabel();
        errocenter = new javax.swing.JLabel();
        errobuilding = new javax.swing.JLabel();
        eroolevel = new javax.swing.JLabel();
        errorank = new javax.swing.JLabel();
        correctl = new javax.swing.JLabel();
        jllableGenSuccess = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        dasboardclick = new javax.swing.JButton();
        addlecturerclick = new javax.swing.JButton();
        managelecturerclick = new javax.swing.JButton();
        Backclick = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                FacultyValidation(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(1400, 820));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pasindu_img/logo.jpeg"))); // NOI18N

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Lecturer Name:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Employee Id:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Faculty:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Department:");

        jTextLecturerName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextLecturerNameKeyReleased(evt);
            }
        });

        jTextEmpId.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextEmpIdKeyReleased(evt);
            }
        });

        jComboFaculty.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));
        jComboFaculty.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboFacultyItemStateChanged(evt);
            }
        });

        jComboDepartment.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));
        jComboDepartment.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboDepartmentItemStateChanged(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("Center:");

        jComboCenter.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));
        jComboCenter.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboCenterItemStateChanged(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("Building:");

        jComboBuilding.setMaximumRowCount(50);
        jComboBuilding.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));
        jComboBuilding.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBuildingItemStateChanged(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setText("Level:");

        jComboLevel.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));
        jComboLevel.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboLevelItemStateChanged(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setText("Rank:");

        jTextRank.setEditable(false);

        buttongenaraterank.setBackground(new java.awt.Color(0, 153, 153));
        buttongenaraterank.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        buttongenaraterank.setText("Generate Rank");
        buttongenaraterank.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttongenaraterankActionPerformed(evt);
            }
        });

        jButtonSaveLecturer.setBackground(new java.awt.Color(0, 153, 153));
        jButtonSaveLecturer.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButtonSaveLecturer.setText("Save");
        jButtonSaveLecturer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSaveLecturerActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(0, 153, 153));
        jButton3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton3.setText("Clear");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        errolecturername.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        errolecturername.setForeground(java.awt.Color.red);

        erroempid.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        erroempid.setForeground(java.awt.Color.red);

        errofaculty.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        errofaculty.setForeground(java.awt.Color.red);

        errodepartment.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        errodepartment.setForeground(java.awt.Color.red);

        errocenter.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        errocenter.setForeground(java.awt.Color.red);

        errobuilding.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        errobuilding.setForeground(java.awt.Color.red);

        eroolevel.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        eroolevel.setForeground(java.awt.Color.red);

        errorank.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        errorank.setForeground(java.awt.Color.red);

        correctl.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        correctl.setForeground(new java.awt.Color(51, 255, 0));

        jllableGenSuccess.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jllableGenSuccess.setForeground(new java.awt.Color(51, 255, 51));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(559, 559, 559)
                        .addComponent(jButtonSaveLecturer, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGap(194, 194, 194)
                            .addComponent(errolecturername, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(errocenter, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGap(20, 20, 20)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(buttongenaraterank, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                            .addComponent(correctl, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(33, 33, 33)
                                            .addComponent(erroempid, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel3)
                                                .addComponent(jLabel4)
                                                .addComponent(jLabel5)
                                                .addComponent(jLabel6))
                                            .addGap(36, 36, 36)
                                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(jTextLecturerName)
                                                .addComponent(jTextEmpId)
                                                .addComponent(jComboFaculty, 0, 235, Short.MAX_VALUE)
                                                .addComponent(jComboDepartment, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                        .addComponent(errofaculty, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(errodepartment, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(91, 91, 91)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel7)
                                                .addComponent(jLabel8)
                                                .addComponent(jLabel9)
                                                .addComponent(jLabel10))
                                            .addGap(18, 18, 18)
                                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(jComboBuilding, 0, 236, Short.MAX_VALUE)
                                                .addComponent(jComboCenter, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jComboLevel, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jTextRank)))
                                        .addComponent(errobuilding, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(eroolevel, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                            .addComponent(errorank, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jllableGenSuccess, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))))))))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextLecturerName, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(jComboCenter, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(errolecturername, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(errocenter, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTextEmpId, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(jComboBuilding, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(erroempid, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(errobuilding, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel5)
                                .addComponent(jComboFaculty, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel9))
                            .addComponent(jComboLevel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(eroolevel, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                            .addComponent(errofaculty, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel6)
                                    .addComponent(jComboDepartment, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel10)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addComponent(jTextRank, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(errodepartment, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(errorank, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
                            .addComponent(jllableGenSuccess, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttongenaraterank, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(59, 59, 59)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonSaveLecturer, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(73, 73, 73))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(correctl)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 153, 153));
        jLabel2.setText("Add Lecturer");

        dasboardclick.setBackground(new java.awt.Color(0, 153, 153));
        dasboardclick.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        dasboardclick.setText("Dashboard");
        dasboardclick.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dasboardclickActionPerformed(evt);
            }
        });

        addlecturerclick.setBackground(new java.awt.Color(0, 153, 153));
        addlecturerclick.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        addlecturerclick.setText("Add Lecturer");

        managelecturerclick.setBackground(new java.awt.Color(0, 153, 153));
        managelecturerclick.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        managelecturerclick.setText("Manage Lecturer");
        managelecturerclick.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                managelecturerclickActionPerformed(evt);
            }
        });

        Backclick.setBackground(new java.awt.Color(0, 153, 153));
        Backclick.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        Backclick.setText("<<Back");
        Backclick.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackclickActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(104, 104, 104)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(managelecturerclick, javax.swing.GroupLayout.DEFAULT_SIZE, 243, Short.MAX_VALUE)
                            .addComponent(addlecturerclick, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(dasboardclick, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(164, 164, 164)
                        .addComponent(Backclick, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 46, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(dasboardclick, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(addlecturerclick, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(managelecturerclick, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(Backclick, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(80, Short.MAX_VALUE))
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
Manage_Lecturer ml;
    private void BackclickActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackclickActionPerformed
        // TODO add your handling code here:
         if (ml == null) {
            ml = new Manage_Lecturer();
        }
        
        ml.setVisible(true);
        this.dispose();
                   
    }//GEN-LAST:event_BackclickActionPerformed
Add_Lecturer al;
    private void managelecturerclickActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_managelecturerclickActionPerformed
        // TODO add your handling code here:
     if (ml == null) {
            ml = new Manage_Lecturer();
        }
        
        ml.setVisible(true);
        this.dispose();     
    }//GEN-LAST:event_managelecturerclickActionPerformed

    private void dasboardclickActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dasboardclickActionPerformed
        // TODO add your handling code here:
     
        group_implmentation.loging.dashb.setVisible(true);
        this.dispose();
                   
    }//GEN-LAST:event_dasboardclickActionPerformed

//This is Generote Rank Calculation
    private void buttongenaraterankActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttongenaraterankActionPerformed
        // TODO add your handling code here:
        
       //Emplyee id and level empty validation for generate rank
       if(jTextEmpId.getText().trim().isEmpty() &&jComboLevel.getSelectedIndex()== 0){
        
          erroempid.setText("Please Enter Employee Id");
          eroolevel.setText("Please Select Level Name");
       }
       else if(jTextEmpId.getText().trim().isEmpty() ){
       
          erroempid.setText("Please Enter Employee Id");

       
       }
       else if(jComboLevel.getSelectedIndex()== 0)
       
         eroolevel.setText("Please Select Level Name");

       else{
        String empid=jTextEmpId.getText();
        String level=jComboLevel.getSelectedItem().toString();
        
   
        
        //String rank
       String rank =String.join(".",level,empid);

        //Display rank
        jTextRank.setText(rank);
       
        //diplay Message
        jllableGenSuccess.setText("Generate Success");


        }
    }//GEN-LAST:event_buttongenaraterankActionPerformed

 //validation of EmpId Only 6 Digit Numbers
    private void jTextEmpIdKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextEmpIdKeyReleased
         // TODO add your handling code here:
        String PATTERN ="^[0-9]{6}$";
        Pattern patt=Pattern.compile(PATTERN);
        Matcher match=patt.matcher(jTextEmpId.getText());
       
        
        if(!match.matches()){
            //Display Message 
            erroempid.setText("Please 6 Digit Employee Id");
            correctl.setText("");
  
        }                                              
        else 
        {
            //Display Message
             erroempid.setText("");
             correctl.setText("Correct");
        }    
    }//GEN-LAST:event_jTextEmpIdKeyReleased

    
 //Save Lectuer to database
    private void jButtonSaveLecturerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSaveLecturerActionPerformed
        // TODO add your handling code here:
        String LecturerName=jTextLecturerName.getText();
        String EmpId=jTextEmpId.getText();
        String Faculty=jComboFaculty.getSelectedItem().toString();
        String Department=jComboDepartment.getSelectedItem().toString();
        String Center=jComboCenter.getSelectedItem().toString();
        String Building=jComboBuilding.getSelectedItem().toString();
        String Level=jComboLevel.getSelectedItem().toString();
        String Rank =jTextRank.getText();
        
      
//Check Empty Validations
  if(jTextLecturerName.getText().trim().isEmpty() || jTextEmpId.getText().trim().isEmpty() ||jComboBuilding.getSelectedIndex()== 0 || jComboCenter.getSelectedIndex()== 0 || jComboDepartment.getSelectedIndex()== 0 || jComboLevel.getSelectedIndex()== 0 || jComboFaculty.getSelectedIndex()==0 || jTextRank.getText().trim().isEmpty()){
      //Call validation      
      Validation();
  }
  else{
       la.SaveLecturer(LecturerName, EmpId, Faculty, Department, Center, Building, Level, Rank);

  }  
           
  


        
    }//GEN-LAST:event_jButtonSaveLecturerActionPerformed

 //Rest Correct Vaildation 
    private void FacultyValidation(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_FacultyValidation
  if (jComboFaculty.getSelectedIndex() == 0){
                  errofaculty.setText("Please Select Faculty Name");

    }else{
                    errofaculty.setText("");

  
  }
      
    }//GEN-LAST:event_FacultyValidation

 //Lecturer Name Only Words Vaildation
    private void jTextLecturerNameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextLecturerNameKeyReleased
        // TODO add your handling code here:
            String PATTERN ="^[a-zA-Z]+(([',. -][a-zA-Z ])?[a-zA-Z]*)*$";
        Pattern patt=Pattern.compile(PATTERN);
        Matcher match=patt.matcher(jTextLecturerName.getText());
       
        
        if(!match.matches()){
              errolecturername.setText("Please enter words only");
                    
    }                                              
        else {
            
             errolecturername.setText(null);
        }    
    }//GEN-LAST:event_jTextLecturerNameKeyReleased
//Rest Correct Vaildation
    private void jComboFacultyItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboFacultyItemStateChanged
        // TODO add your handling code here:
        errofaculty.setText(null);
    }//GEN-LAST:event_jComboFacultyItemStateChanged

    private void jComboDepartmentItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboDepartmentItemStateChanged
        // TODO add your handling code here:
        errodepartment.setText(null);
    }//GEN-LAST:event_jComboDepartmentItemStateChanged

    private void jComboCenterItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboCenterItemStateChanged
        // TODO add your handling code here:
        errocenter.setText(null);
    }//GEN-LAST:event_jComboCenterItemStateChanged

    private void jComboBuildingItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBuildingItemStateChanged
        // TODO add your handling code here:
        errobuilding.setText(null);
    }//GEN-LAST:event_jComboBuildingItemStateChanged

    private void jComboLevelItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboLevelItemStateChanged
        // TODO add your handling code here:
        eroolevel.setText(null);
    }//GEN-LAST:event_jComboLevelItemStateChanged

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        jTextLecturerName.setText("");
        jTextEmpId.setText("");
        jTextRank.setText("");
        jComboBuilding.setSelectedIndex(0);
        jComboCenter.setSelectedIndex(0);
        jComboDepartment.setSelectedIndex(0);
        jComboFaculty.setSelectedIndex(0);
        jComboLevel.setSelectedIndex(0);
        correctl.setText("");
        jllableGenSuccess.setText(" ");
        erroempid.setText("");
        eroolevel.setText("");

    }//GEN-LAST:event_jButton3ActionPerformed

 //Validatoion Methode   
  public void Validation(){
    
     if(jTextLecturerName.getText().trim().isEmpty() && jTextEmpId.getText().trim().isEmpty() &&jComboBuilding.getSelectedIndex()== 0 && jComboCenter.getSelectedIndex()== 0 && jComboDepartment.getSelectedIndex()== 0 && jComboLevel.getSelectedIndex()== 0 && jComboFaculty.getSelectedIndex()==0 && jTextRank.getText().trim().isEmpty()){
            //Display Mesage
           JOptionPane.showMessageDialog(this, "Fields are Emplty");
  }
  else if(jTextLecturerName.getText().trim().isEmpty()){
           //Display Message  
           errolecturername.setText("Please Enter Lecturer Name");
         
  } 
  else if(jTextEmpId.getText().trim().isEmpty()){
           //Display Message     
          erroempid.setText("Please Enter Employee Id");

  }
  else if(jComboBuilding.getSelectedIndex()== 0){
          //Display Message  
          errobuilding.setText("Please Select Building Name");

  }
  else if(jComboCenter.getSelectedIndex() == 0){
          //Display Message  
          errocenter.setText("Please Select Center Name");
  }
  else  if(jComboDepartment.getSelectedIndex() ==0){
          //Display Message   
          errodepartment.setText("Please Select Department Name");

  }
  else if (jComboFaculty.getSelectedIndex() == 0){
          //Display Message        
          errofaculty.setText("Please Select Faculty Name");
  }
  else if(jComboLevel.getSelectedIndex() == 0){
          //Display Message         
          eroolevel.setText("Please Select Level Name");
  }
  else if(jTextRank.getText().trim().isEmpty()){
           //Display Message        
          errorank.setText("Please Generate Rank");
    
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
            java.util.logging.Logger.getLogger(Add_Lecturer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Add_Lecturer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Add_Lecturer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Add_Lecturer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Add_Lecturer().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Backclick;
    private javax.swing.JButton addlecturerclick;
    private javax.swing.JButton buttongenaraterank;
    private javax.swing.JLabel correctl;
    private javax.swing.JButton dasboardclick;
    private javax.swing.JLabel eroolevel;
    private javax.swing.JLabel errobuilding;
    private javax.swing.JLabel errocenter;
    private javax.swing.JLabel errodepartment;
    private javax.swing.JLabel erroempid;
    private javax.swing.JLabel errofaculty;
    private javax.swing.JLabel errolecturername;
    private javax.swing.JLabel errorank;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButtonSaveLecturer;
    private javax.swing.JComboBox<String> jComboBuilding;
    private javax.swing.JComboBox<String> jComboCenter;
    private javax.swing.JComboBox<String> jComboDepartment;
    private javax.swing.JComboBox<String> jComboFaculty;
    private javax.swing.JComboBox<String> jComboLevel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
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
    private javax.swing.JTextField jTextEmpId;
    private javax.swing.JTextField jTextLecturerName;
    private javax.swing.JTextField jTextRank;
    private javax.swing.JLabel jllableGenSuccess;
    private javax.swing.JButton managelecturerclick;
    // End of variables declaration//GEN-END:variables
}
