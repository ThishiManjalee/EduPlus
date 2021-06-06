/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yass;

import actions.NotAvailableTime_Add;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.SpinnerNumberModel;

/**
 *
 * @author yass
 */
public final class add_n_avalable_time extends javax.swing.JFrame {
        NotAvailableTime_Add na =new NotAvailableTime_Add();

    /**
     * Creates new form add_n_avalable_time
     */
    public add_n_avalable_time() {
        initComponents();
        //call mehode hide window size 
        maxsizehidden();
        lecturercombox();
        Roomcombox();
        Groupcombox();
        SubGroupcombox();
        sessioncombox();
        spinnerMinusMaxStop();
    }
//hide size methode
     void maxsizehidden(){
        setSize(1400, 820);
        setLocationRelativeTo(null);
        setResizable(false); // maximize button disable
       
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
            Logger.getLogger(add_n_avalable_time.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(add_n_avalable_time.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(add_n_avalable_time.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(add_n_avalable_time.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(add_n_avalable_time.class.getName()).log(Level.SEVERE, null, ex);
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
        AddNotAvailableTimeClick = new javax.swing.JButton();
        ManageNotAvailableTimeclick = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();
        jComboBoxLecturer = new javax.swing.JComboBox<>();
        jComboBoxRoom = new javax.swing.JComboBox<>();
        jTextField1 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jComboBoxGroup = new javax.swing.JComboBox<>();
        jTextField4 = new javax.swing.JTextField();
        jComboBoxSubGroup = new javax.swing.JComboBox<>();
        jTextField5 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        jComboBoxSessionId = new javax.swing.JComboBox<>();
        jTextField7 = new javax.swing.JTextField();
        jSpinnerStartHour = new javax.swing.JSpinner();
        jTextField8 = new javax.swing.JTextField();
        jSpinnerStartMin = new javax.swing.JSpinner();
        jTextField9 = new javax.swing.JTextField();
        jTextField10 = new javax.swing.JTextField();
        jSpinnerEndHour = new javax.swing.JSpinner();
        jTextField11 = new javax.swing.JTextField();
        jSpinnerEndMin = new javax.swing.JSpinner();
        jTextField12 = new javax.swing.JTextField();
        jButtonClear = new javax.swing.JButton();
        jButtonSumbit = new javax.swing.JButton();
        jComboBoxDay = new javax.swing.JComboBox<>();
        jTextField2 = new javax.swing.JTextField();
        BackClick = new javax.swing.JButton();
        DashBoardClick = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(java.awt.Color.white);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pasindu_img/logo.jpeg"))); // NOI18N
        jLabel1.setText("jLabel1");

        AddNotAvailableTimeClick.setBackground(new java.awt.Color(0, 153, 153));
        AddNotAvailableTimeClick.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        AddNotAvailableTimeClick.setText("Add Not Available Time");
        AddNotAvailableTimeClick.setPreferredSize(new java.awt.Dimension(2340, 30));

        ManageNotAvailableTimeclick.setBackground(new java.awt.Color(0, 153, 153));
        ManageNotAvailableTimeclick.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        ManageNotAvailableTimeclick.setText("Manage Not Available Time");
        ManageNotAvailableTimeclick.setPreferredSize(new java.awt.Dimension(275, 30));
        ManageNotAvailableTimeclick.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ManageNotAvailableTimeclickActionPerformed(evt);
            }
        });

        jTextPane1.setEditable(false);
        jTextPane1.setBorder(null);
        jTextPane1.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jTextPane1.setText("Select Lecturer");
        jScrollPane1.setViewportView(jTextPane1);

        jComboBoxLecturer.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));
        jComboBoxLecturer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxLecturerActionPerformed(evt);
            }
        });

        jComboBoxRoom.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));

        jTextField1.setEditable(false);
        jTextField1.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jTextField1.setText("Select Room");

        jTextField3.setEditable(false);
        jTextField3.setBackground(new java.awt.Color(255, 255, 255));
        jTextField3.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jTextField3.setText("Select Group");

        jComboBoxGroup.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));
        jComboBoxGroup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxGroupActionPerformed(evt);
            }
        });

        jTextField4.setEditable(false);
        jTextField4.setBackground(new java.awt.Color(255, 255, 255));
        jTextField4.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jTextField4.setText("Select Sub Group");

        jComboBoxSubGroup.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));
        jComboBoxSubGroup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxSubGroupActionPerformed(evt);
            }
        });

        jTextField5.setEditable(false);
        jTextField5.setBackground(new java.awt.Color(255, 255, 255));
        jTextField5.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jTextField5.setText("Select Day");

        jTextField6.setEditable(false);
        jTextField6.setBackground(new java.awt.Color(255, 255, 255));
        jTextField6.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jTextField6.setText("Select Session ID");
        jTextField6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField6ActionPerformed(evt);
            }
        });

        jComboBoxSessionId.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));

        jTextField7.setEditable(false);
        jTextField7.setBackground(new java.awt.Color(255, 255, 255));
        jTextField7.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jTextField7.setText("Start Time");

        jTextField8.setEditable(false);
        jTextField8.setBackground(new java.awt.Color(204, 204, 204));
        jTextField8.setText(" H");
        jTextField8.setBorder(null);

        jTextField9.setEditable(false);
        jTextField9.setBackground(new java.awt.Color(204, 204, 204));
        jTextField9.setText("M");

        jTextField10.setEditable(false);
        jTextField10.setBackground(new java.awt.Color(255, 255, 255));
        jTextField10.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jTextField10.setText("End Time");
        jTextField10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField10ActionPerformed(evt);
            }
        });

        jTextField11.setEditable(false);
        jTextField11.setBackground(new java.awt.Color(204, 204, 204));
        jTextField11.setText(" H");
        jTextField11.setBorder(null);

        jTextField12.setEditable(false);
        jTextField12.setBackground(new java.awt.Color(204, 204, 204));
        jTextField12.setText("M");

        jButtonClear.setBackground(new java.awt.Color(0, 153, 153));
        jButtonClear.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jButtonClear.setText("Clear");
        jButtonClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonClearActionPerformed(evt);
            }
        });

        jButtonSumbit.setBackground(new java.awt.Color(0, 153, 153));
        jButtonSumbit.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jButtonSumbit.setText("Submit");
        jButtonSumbit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSumbitActionPerformed(evt);
            }
        });

        jComboBoxDay.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday" }));
        jComboBoxDay.setSelectedItem(0
        );
        jComboBoxDay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxDayActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextField6, javax.swing.GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE)
                    .addComponent(jTextField5)
                    .addComponent(jTextField4)
                    .addComponent(jTextField3)
                    .addComponent(jScrollPane1)
                    .addComponent(jTextField1))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jComboBoxSubGroup, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jComboBoxRoom, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jComboBoxGroup, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jComboBoxLecturer, 0, 220, Short.MAX_VALUE)
                    .addComponent(jComboBoxDay, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jComboBoxSessionId, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextField7, javax.swing.GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE)
                            .addComponent(jTextField10))
                        .addGap(28, 28, 28)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jSpinnerStartHour, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE)
                            .addComponent(jSpinnerEndHour))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField11, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 4, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonSumbit, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jSpinnerEndMin, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextField12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jSpinnerStartMin, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextField9))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jButtonClear, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(35, 35, 35))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jComboBoxLecturer, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jSpinnerStartHour, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jSpinnerStartMin, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jComboBoxRoom, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(50, 50, 50)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBoxGroup, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBoxSubGroup, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(34, 34, 34)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBoxDay, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(9, 9, 9))
                    .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jSpinnerEndHour, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextField11, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jSpinnerEndMin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextField12, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBoxSessionId, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonSumbit)
                            .addComponent(jButtonClear))
                        .addGap(136, 136, 136))))
        );

        jTextField2.setEditable(false);
        jTextField2.setBackground(java.awt.Color.white);
        jTextField2.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jTextField2.setForeground(new java.awt.Color(0, 153, 153));
        jTextField2.setText("Add Not Available Time");
        jTextField2.setBorder(null);
        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        BackClick.setBackground(new java.awt.Color(0, 153, 153));
        BackClick.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        BackClick.setText("<<BACK");
        BackClick.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackClickActionPerformed(evt);
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
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 431, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(83, 83, 83)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(AddNotAvailableTimeClick, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(ManageNotAvailableTimeclick, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 282, Short.MAX_VALUE)
                            .addComponent(DashBoardClick, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(156, 156, 156)
                        .addComponent(BackClick, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 439, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(47, 47, 47))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(104, Short.MAX_VALUE)
                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 387, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(DashBoardClick, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(AddNotAvailableTimeClick, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(ManageNotAvailableTimeclick, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(BackClick, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBoxLecturerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxLecturerActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxLecturerActionPerformed

    private void jTextField10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField10ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField10ActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jButtonSumbitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSumbitActionPerformed
        // TODO add your handling code here:
        String Lecturer=jComboBoxLecturer.getSelectedItem().toString();
        String Room=jComboBoxRoom.getSelectedItem().toString();
        String Group = jComboBoxGroup.getSelectedItem().toString();
        String Subgroup=jComboBoxSubGroup.getSelectedItem().toString();
        String Day=jComboBoxDay.getSelectedItem().toString();
        String Session_id=jComboBoxSessionId.getSelectedItem().toString();
        String Shrs=jSpinnerStartHour.getValue().toString();
        String Smin=jSpinnerStartMin.getValue().toString();
        String Ehrs=jSpinnerEndHour.getValue().toString();
        String Emin=jSpinnerEndMin.getValue().toString();
      
        


          
     //Check Vaildation All jComboBox Index Empty       
    if(jComboBoxLecturer.getSelectedIndex() == 0||jComboBoxGroup.getSelectedIndex()==0||jComboBoxRoom.getSelectedIndex()==0||jComboBoxSubGroup.getSelectedIndex()==0||jComboBoxSessionId.getSelectedIndex()==0){
        //Call Validation
              JOptionPane.showMessageDialog(null, "Empty Fields");
     }else{
     na.AddNotAvailableTime(Lecturer, Room, Group, Subgroup, Day, Session_id, Shrs, Smin, Ehrs, Emin);

   }
   
        
        
        
        
        
        
    }//GEN-LAST:event_jButtonSumbitActionPerformed

    private void ManageNotAvailableTimeclickActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ManageNotAvailableTimeclickActionPerformed
        // TODO add your handling code here:
        manage_n_available_time a2=new manage_n_available_time();
        a2.show();
        dispose();
    }//GEN-LAST:event_ManageNotAvailableTimeclickActionPerformed

    private void BackClickActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackClickActionPerformed
        // TODO add your handling code here:
        manage_n_available_time a3=new manage_n_available_time();
        a3.show();
        dispose();

    }//GEN-LAST:event_BackClickActionPerformed

    private void jComboBoxSubGroupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxSubGroupActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxSubGroupActionPerformed

    private void DashBoardClickActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DashBoardClickActionPerformed
        // TODO add your handling code here:
       
        group_implmentation.loging.dashb.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_DashBoardClickActionPerformed

    private void jComboBoxGroupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxGroupActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxGroupActionPerformed

    private void jButtonClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonClearActionPerformed
        // TODO add your handling code here:
         jComboBoxLecturer.setSelectedIndex(0);
        jComboBoxRoom.setSelectedIndex(0);
        jComboBoxGroup.setSelectedIndex(0);
        jComboBoxSubGroup.setSelectedIndex(0);
        jComboBoxSessionId.setSelectedIndex(0);
        jSpinnerStartHour.setValue(0);
        jSpinnerStartMin.setValue(0);
        jSpinnerEndHour.setValue(0);
        jSpinnerEndMin.setValue(0);
        jComboBoxDay.setSelectedIndex(0);

        
    }//GEN-LAST:event_jButtonClearActionPerformed

    private void jTextField6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField6ActionPerformed

    private void jComboBoxDayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxDayActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxDayActionPerformed

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
            java.util.logging.Logger.getLogger(add_n_avalable_time.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(add_n_avalable_time.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(add_n_avalable_time.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(add_n_avalable_time.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new add_n_avalable_time().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddNotAvailableTimeClick;
    private javax.swing.JButton BackClick;
    private javax.swing.JButton DashBoardClick;
    private javax.swing.JButton ManageNotAvailableTimeclick;
    private javax.swing.JButton jButtonClear;
    private javax.swing.JButton jButtonSumbit;
    private javax.swing.JComboBox<String> jComboBoxDay;
    private javax.swing.JComboBox<String> jComboBoxGroup;
    private javax.swing.JComboBox<String> jComboBoxLecturer;
    private javax.swing.JComboBox<String> jComboBoxRoom;
    private javax.swing.JComboBox<String> jComboBoxSessionId;
    private javax.swing.JComboBox<String> jComboBoxSubGroup;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSpinner jSpinnerEndHour;
    private javax.swing.JSpinner jSpinnerEndMin;
    private javax.swing.JSpinner jSpinnerStartHour;
    private javax.swing.JSpinner jSpinnerStartMin;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField11;
    private javax.swing.JTextField jTextField12;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    private javax.swing.JTextPane jTextPane1;
    // End of variables declaration//GEN-END:variables
}
