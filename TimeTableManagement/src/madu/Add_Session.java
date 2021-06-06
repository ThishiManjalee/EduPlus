/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package madu;

import Thishi.View_Tables;
import actions.Session_Add;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SpinnerNumberModel;

/**
 *
 * @author Madu
 */
public final class Add_Session extends javax.swing.JFrame {

    Session_Add sa = new Session_Add();

    /**
     * Creates new form Add_Session
     */
    public Add_Session() {
        initComponents();
        //implement the hide size
        hidesize();
        //Call Lecturer1 methode
        lecturer1combox();
        //Call Lecturer2 methode
        lecturer2combox();
        tagcombox();
        //groupcombox();
        subjectcodecombox();
        subjectcombox();
spinnerMinusMaxStop();    }

    void hidesize() {

        setSize(1400, 820);
        setLocationRelativeTo(null);
        setResizable(false); // maximize button disable
       

    }
  //for spnner limit  
  void spinnerMinusMaxStop(){
          ((SpinnerNumberModel) StartHrs.getModel()).setMinimum(0);
          ((SpinnerNumberModel) StartMin.getModel()).setMinimum(0);
          ((SpinnerNumberModel) EndHrs.getModel()).setMinimum(0);
          ((SpinnerNumberModel) EndMin.getModel()).setMinimum(0);
          ((SpinnerNumberModel) jSpinnerHRS.getModel()).setMinimum(0);
          ((SpinnerNumberModel) jSpinnerMin.getModel()).setMinimum(0);
          ((SpinnerNumberModel) jSpinnernumofstudent.getModel()).setMinimum(0);

           ((SpinnerNumberModel) StartHrs.getModel()).setMaximum(23);
          ((SpinnerNumberModel) StartMin.getModel()).setMaximum(59);
          ((SpinnerNumberModel) EndHrs.getModel()).setMaximum(23);
          ((SpinnerNumberModel) EndMin.getModel()).setMaximum(59);
          ((SpinnerNumberModel) jSpinnerHRS.getModel()).setMaximum(23);
          ((SpinnerNumberModel) jSpinnerMin.getModel()).setMaximum(59);
 
  }
   
    //Retive All the Lecturer1 Data to Combobox

    void lecturer1combox() {
        // TODO add your handling code here:
        try {
            Connection cn = connection.DB_Connect.ConnecrDB();

            String sql = "select DISTINCT name from lecturer";
            Statement pst = cn.createStatement();
            ResultSet rs = pst.executeQuery(sql);
            while (rs.next()) {

                String name = rs.getString("name");
                jComboBoxLecturer1.addItem(name);

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

    //Retive All the Lecturer1 Data to Combobox
    void lecturer2combox() {
        // TODO add your handling code here:
        try {
            Connection cn = connection.DB_Connect.ConnecrDB();

            String sql = "select DISTINCT name from lecturer";
            Statement pst = cn.createStatement();
            ResultSet rs = pst.executeQuery(sql);
            while (rs.next()) {

                String name = rs.getString("name");
                jComboBoxLecturer2.addItem(name);

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
    //Retive All the Lecturer1 Data to Combobox

    void tagcombox() {
        // TODO add your handling code here:
        try {
            Connection cn = connection.DB_Connect.ConnecrDB();

            String sql = "select DISTINCT related_tag from tag";
            Statement pst = cn.createStatement();
            ResultSet rs = pst.executeQuery(sql);
            while (rs.next()) {

                String subject = rs.getString("related_tag");
                jComboBoxTag.addItem(subject);

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

    //Retive All the Lecturer1 Data to Combobox
    void subjectcombox() {
        // TODO add your handling code here:
        try {
            Connection cn = connection.DB_Connect.ConnecrDB();

            String sql = "select DISTINCT sub_name from subjects";
            Statement pst = cn.createStatement();
            ResultSet rs = pst.executeQuery(sql);
            while (rs.next()) {

                String subject = rs.getString("sub_name");
                jComboBoxSubject.addItem(subject);

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
    //Retive All the Lecturer1 Data to Combobox

    void subjectcodecombox() {
        // TODO add your handling code here:
        try {
            Connection cn = connection.DB_Connect.ConnecrDB();

            String sql = "select DISTINCT sub_code from subjects";
            Statement pst = cn.createStatement();
            ResultSet rs = pst.executeQuery(sql);
            while (rs.next()) {

                String code = rs.getString("sub_code");
                jComboBoxSubjectCode.addItem(code);

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

    void genertaeLecturers() {
        // TODO add your handling code here:

        String lec1 = jComboBoxLecturer1.getSelectedItem().toString();
        String lec2 = jComboBoxLecturer2.getSelectedItem().toString();

        String lecturers = String.join(",", lec1, lec2);

        jTextFieldSelectedLecturers.setText(lecturers);

    }

    void select() {

        String ch = jComboBoxTag.getSelectedItem().toString();

        if ("Lecture".equals(ch) || "Tutorial".equals(ch)) {
            // TODO add your handling code here:
            try {
                try (Connection cn = connection.DB_Connect.ConnecrDB()) {
                    String sql = "select DISTINCT group_id from student_group";
                    Statement pst = cn.createStatement();

                    ResultSet rs = pst.executeQuery(sql);
                    jComboBoxGroup.removeAllItems();
                    jComboBoxGroup.setSelectedItem(null);
                    while (rs.next()) {

                        String group = rs.getString("group_id");
                        jComboBoxGroup.addItem(group);

                    }
                    //Connection Close
                    pst.close();
                    rs.close();

                }

            } catch (SQLException ex) {
                Logger.getLogger(Add_Lecturer.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, ex);
            }

        } else if ("Lab".equals(ch)) {

            try {

                try (Connection cn = connection.DB_Connect.ConnecrDB()) {
                    String sql = "select DISTINCT sub_group_id from student_group";
                    Statement pst = cn.createStatement();

                    ResultSet rs = pst.executeQuery(sql);
                    rs = pst.executeQuery(sql);
                    jComboBoxGroup.removeAllItems();
                    jComboBoxGroup.setSelectedItem(null);

                    while (rs.next()) {
                        String group1 = rs.getString("sub_group_id");
                        jComboBoxGroup.addItem(group1);
                    }
                    //Connection Close

                    pst.close();

                    rs.close();
                }

            } catch (SQLException ex) {
                Logger.getLogger(Add_Lecturer.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, ex);
            }

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
        jPanelScode = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jComboBoxLecturer1 = new javax.swing.JComboBox<>();
        jComboBoxLecturer2 = new javax.swing.JComboBox<>();
        jComboBoxTag = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        jTextFieldSelectedLecturers = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jComboBoxGroup = new javax.swing.JComboBox<>();
        jComboBoxSubject = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jButtonSave = new javax.swing.JButton();
        JbuttonClear = new javax.swing.JButton();
        jSpinnerMin = new javax.swing.JSpinner();
        jSpinnerHRS = new javax.swing.JSpinner();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jComboBoxSubjectCode = new javax.swing.JComboBox<>();
        jSpinnernumofstudent = new javax.swing.JSpinner();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jComboBoxDay = new javax.swing.JComboBox<>();
        StartHrs = new javax.swing.JSpinner();
        EndHrs = new javax.swing.JSpinner();
        StartMin = new javax.swing.JSpinner();
        EndMin = new javax.swing.JSpinner();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextPaneGen = new javax.swing.JTextPane();
        Gen = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        dashboardclick = new javax.swing.JButton();
        addsessionclick = new javax.swing.JButton();
        managesessionclick = new javax.swing.JButton();
        backclick = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(1400, 820));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pasindu_img/logo.jpeg"))); // NOI18N

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Step -01");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Step-02");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Selected Lecturer 01");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Selected Lecturer 02");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("Select Tag");

        jComboBoxLecturer1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "" }));
        jComboBoxLecturer1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxLecturer1ItemStateChanged(evt);
            }
        });
        jComboBoxLecturer1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxLecturer1ActionPerformed(evt);
            }
        });

        jComboBoxLecturer2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "" }));
        jComboBoxLecturer2.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxLecturer2ItemStateChanged(evt);
            }
        });
        jComboBoxLecturer2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxLecturer2ActionPerformed(evt);
            }
        });

        jComboBoxTag.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));
        jComboBoxTag.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxTagItemStateChanged(evt);
            }
        });
        jComboBoxTag.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxTagActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("Selected Lecturers");

        jTextFieldSelectedLecturers.setEditable(false);

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel9.setText("Select Group");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel10.setText("Select Subject");

        jComboBoxGroup.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));
        jComboBoxGroup.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxGroupItemStateChanged(evt);
            }
        });

        jComboBoxSubject.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));
        jComboBoxSubject.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxSubjectItemStateChanged(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel11.setText("Number Of Student");

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel12.setText("Duration");

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel13.setText("Hrs");

        jButtonSave.setBackground(new java.awt.Color(0, 153, 153));
        jButtonSave.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButtonSave.setText("Submit");
        jButtonSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSaveActionPerformed(evt);
            }
        });

        JbuttonClear.setBackground(new java.awt.Color(0, 153, 153));
        JbuttonClear.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        JbuttonClear.setText("Clear");
        JbuttonClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JbuttonClearActionPerformed(evt);
            }
        });

        jSpinnerHRS.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSpinnerHRSStateChanged(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel14.setText("Min");

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel15.setText("Select Subject Code");

        jComboBoxSubjectCode.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));
        jComboBoxSubjectCode.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxSubjectCodeItemStateChanged(evt);
            }
        });

        jSpinnernumofstudent.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSpinnernumofstudentStateChanged(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel16.setText("Start Time");

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel17.setText("End Time");

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel18.setText("Day");

        jComboBoxDay.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday" }));

        jLabel19.setText("Hrs");

        jLabel20.setText("Min");

        jLabel21.setText("Hrs");

        jLabel22.setText("Min");

        jScrollPane1.setViewportView(jTextPaneGen);

        Gen.setBackground(new java.awt.Color(0, 153, 153));
        Gen.setText("Generate ");
        Gen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GenActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelScodeLayout = new javax.swing.GroupLayout(jPanelScode);
        jPanelScode.setLayout(jPanelScodeLayout);
        jPanelScodeLayout.setHorizontalGroup(
            jPanelScodeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelScodeLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelScodeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addGap(29, 29, 29))
            .addGroup(jPanelScodeLayout.createSequentialGroup()
                .addGap(119, 119, 119)
                .addGroup(jPanelScodeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9)
                    .addGroup(jPanelScodeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel10)
                    .addComponent(jLabel15)
                    .addComponent(jLabel16)
                    .addComponent(jLabel17))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelScodeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelScodeLayout.createSequentialGroup()
                        .addGroup(jPanelScodeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelScodeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jComboBoxSubject, javax.swing.GroupLayout.Alignment.LEADING, 0, 214, Short.MAX_VALUE)
                                .addComponent(jComboBoxGroup, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jComboBoxSubjectCode, 0, 278, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanelScodeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelScodeLayout.createSequentialGroup()
                                .addGroup(jPanelScodeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel11)
                                    .addGroup(jPanelScodeLayout.createSequentialGroup()
                                        .addComponent(jLabel12)
                                        .addGap(18, 18, 18)
                                        .addComponent(jSpinnerHRS)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanelScodeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanelScodeLayout.createSequentialGroup()
                                        .addComponent(jLabel13)
                                        .addGap(18, 18, 18)
                                        .addComponent(jSpinnerMin, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jSpinnernumofstudent))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel14)
                                .addGap(76, 76, 76))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelScodeLayout.createSequentialGroup()
                                .addGroup(jPanelScodeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(Gen)
                                    .addGroup(jPanelScodeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanelScodeLayout.createSequentialGroup()
                                            .addComponent(jLabel18)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jComboBoxDay, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(21, 21, 21))))
                    .addGroup(jPanelScodeLayout.createSequentialGroup()
                        .addGroup(jPanelScodeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldSelectedLecturers, javax.swing.GroupLayout.PREFERRED_SIZE, 549, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanelScodeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanelScodeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jComboBoxLecturer2, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jComboBoxLecturer1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jComboBoxTag, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanelScodeLayout.createSequentialGroup()
                                .addGroup(jPanelScodeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(EndHrs, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 63, Short.MAX_VALUE)
                                    .addComponent(StartHrs, javax.swing.GroupLayout.Alignment.LEADING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanelScodeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel19)
                                    .addComponent(jLabel21))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanelScodeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(StartMin, javax.swing.GroupLayout.DEFAULT_SIZE, 65, Short.MAX_VALUE)
                                    .addComponent(EndMin))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanelScodeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanelScodeLayout.createSequentialGroup()
                                        .addComponent(jLabel22)
                                        .addGap(143, 143, 143)
                                        .addComponent(jButtonSave, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(JbuttonClear, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel20))))
                        .addContainerGap(63, Short.MAX_VALUE))))
        );
        jPanelScodeLayout.setVerticalGroup(
            jPanelScodeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelScodeLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel3)
                .addGap(3, 3, 3)
                .addGroup(jPanelScodeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanelScodeLayout.createSequentialGroup()
                        .addGroup(jPanelScodeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelScodeLayout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(53, 53, 53)
                                .addComponent(jLabel6)
                                .addGap(37, 37, 37)
                                .addGroup(jPanelScodeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jComboBoxTag, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(30, 30, 30)
                                .addGroup(jPanelScodeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel8)
                                    .addComponent(jTextFieldSelectedLecturers, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(17, 17, 17)
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18)
                                .addGroup(jPanelScodeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel9)
                                    .addComponent(jComboBoxGroup, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel11)
                                    .addComponent(jSpinnernumofstudent, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanelScodeLayout.createSequentialGroup()
                                .addComponent(jComboBoxLecturer1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(35, 35, 35)
                                .addComponent(jComboBoxLecturer2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(41, 41, 41)
                        .addGroup(jPanelScodeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelScodeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jComboBoxSubject, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel12)
                                .addComponent(jLabel13)
                                .addComponent(jSpinnerMin, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jSpinnerHRS, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel14)))
                        .addGroup(jPanelScodeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelScodeLayout.createSequentialGroup()
                                .addGap(56, 56, 56)
                                .addComponent(jLabel15))
                            .addGroup(jPanelScodeLayout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addGroup(jPanelScodeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel18)
                                    .addComponent(jComboBoxDay, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addComponent(jComboBoxSubjectCode, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelScodeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(StartHrs, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(StartMin, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19)
                    .addComponent(jLabel20)
                    .addComponent(Gen))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addGroup(jPanelScodeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelScodeLayout.createSequentialGroup()
                        .addComponent(jLabel17)
                        .addGap(25, 25, 25))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelScodeLayout.createSequentialGroup()
                        .addGroup(jPanelScodeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(EndHrs, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(EndMin, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel21)
                            .addComponent(jLabel22)
                            .addComponent(jButtonSave, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JbuttonClear, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())))
        );

        jLabel2.setBackground(new java.awt.Color(0, 153, 153));
        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 153, 153));
        jLabel2.setText("Add Session");

        dashboardclick.setBackground(new java.awt.Color(0, 153, 153));
        dashboardclick.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        dashboardclick.setText("Dashboard");
        dashboardclick.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dashboardclickActionPerformed(evt);
            }
        });

        addsessionclick.setBackground(new java.awt.Color(0, 153, 153));
        addsessionclick.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        addsessionclick.setText("Add Session ");

        managesessionclick.setBackground(new java.awt.Color(0, 153, 153));
        managesessionclick.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        managesessionclick.setText("Manage Session");
        managesessionclick.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                managesessionclickActionPerformed(evt);
            }
        });

        backclick.setBackground(new java.awt.Color(0, 153, 153));
        backclick.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        backclick.setText("<<Back");
        backclick.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backclickActionPerformed(evt);
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
                        .addGap(125, 125, 125)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(managesessionclick, javax.swing.GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE)
                            .addComponent(addsessionclick, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(dashboardclick, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(176, 176, 176)
                        .addComponent(backclick)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jPanelScode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 73, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(dashboardclick, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(addsessionclick, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(managesessionclick, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addComponent(backclick, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 88, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelScode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
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

    private void dashboardclickActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dashboardclickActionPerformed
        // TODO add your handling code here:

        group_implmentation.loging.dashb.setVisible(true);
        this.dispose();

    }//GEN-LAST:event_dashboardclickActionPerformed
    Add_Session as;    Manage_Session ms;
    private void managesessionclickActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_managesessionclickActionPerformed
        // TODO add your handling code here:
        if (ms == null) {
            ms = new Manage_Session();
        }

        ms.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_managesessionclickActionPerformed

    private void backclickActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backclickActionPerformed
        // TODO add your handling code here:
        if (ms == null) {
            ms = new Manage_Session();
        }

        ms.setVisible(true);
        this.dispose();

    }//GEN-LAST:event_backclickActionPerformed

    private void jComboBoxLecturer1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxLecturer1ActionPerformed
        // TODO add your handling code here:
        genertaeLecturers();
    }//GEN-LAST:event_jComboBoxLecturer1ActionPerformed

    private void jComboBoxLecturer2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxLecturer2ActionPerformed
        // TODO add your handling code here:
        genertaeLecturers();
    }//GEN-LAST:event_jComboBoxLecturer2ActionPerformed

    private void JbuttonClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JbuttonClearActionPerformed
        // TODO add your handling code here:
        jComboBoxLecturer1.setSelectedIndex(0);
        jComboBoxLecturer2.setSelectedIndex(0);
        jComboBoxTag.setSelectedIndex(0);
        jTextFieldSelectedLecturers.setText("");
        jComboBoxGroup.setSelectedIndex(0);
        jComboBoxSubject.setSelectedIndex(0);
        jComboBoxSubjectCode.setSelectedIndex(0);
        jSpinnernumofstudent.setValue(0);
        jSpinnerHRS.setValue(0);
        jSpinnerMin.setValue(0);
        jComboBoxGroup.removeAllItems();
        jComboBoxDay.setSelectedIndex(0);
        StartHrs.setValue(0);
        StartMin.setValue(0);
        EndMin.setValue(0);
        EndHrs.setValue(0);
        jTextPaneGen.setText("");
    }//GEN-LAST:event_JbuttonClearActionPerformed

    private void jButtonSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSaveActionPerformed
        // TODO add your handling code here:

        String Lec1 = jComboBoxLecturer1.getSelectedItem().toString();
        String Lec2 = jComboBoxLecturer2.getSelectedItem().toString();
        String Tag = jComboBoxTag.getSelectedItem().toString();
        String Slec = jTextFieldSelectedLecturers.getText();
        String Sgroup = jComboBoxGroup.getSelectedItem().toString();
        String Ssubject = jComboBoxSubject.getSelectedItem().toString();
        String Scode = jComboBoxSubjectCode.getSelectedItem().toString();
        String Nostu = jSpinnernumofstudent.getValue().toString();
        String Hrs = jSpinnerHRS.getValue().toString();
        String Min = jSpinnerMin.getValue().toString();
        String Day = jComboBoxDay.getSelectedItem().toString();
        String sHrs = StartHrs.getValue().toString();
        String sMin = StartMin.getValue().toString();
        String EHrs = EndHrs.getValue().toString();
        String EMin = EndMin.getValue().toString();
        String SessionName = jTextPaneGen.getText();

        // Check Vaildation All  Index Empty       
        if (jComboBoxLecturer1.getSelectedIndex() == 0 || jComboBoxLecturer2.getSelectedIndex() == 0 || jComboBoxTag.getSelectedIndex() == 0 || jComboBoxSubject.getSelectedIndex() == 0 || jComboBoxSubjectCode.getSelectedIndex() == 0||jTextPaneGen.getText().trim().isEmpty()) {
            //Call Validation
            JOptionPane.showMessageDialog(null, "Empty Field Recheck");

        } else {
            sa.AddSession(Lec1, Lec2, Tag, Slec, Sgroup, Ssubject, Scode, Nostu, Hrs, Min, Day, sHrs, sMin, EHrs, EMin, SessionName);
        }


    }//GEN-LAST:event_jButtonSaveActionPerformed

    private void jComboBoxTagActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxTagActionPerformed
        // TODO add your handling code here:

        select();

    }//GEN-LAST:event_jComboBoxTagActionPerformed

    private void GenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GenActionPerformed

// TODO add your handling code here:

        String lec1 = jComboBoxLecturer1.getSelectedItem().toString();
        String lec2 = jComboBoxLecturer2.getSelectedItem().toString();
        String scode = jComboBoxSubjectCode.getSelectedItem().toString();
        String tag = jComboBoxTag.getSelectedItem().toString();
        String sgroup = jComboBoxGroup.getSelectedItem().toString();
        String nostu = jSpinnernumofstudent.getValue().toString();
        String duration = jSpinnerHRS.getValue().toString();

//        String session1
        if (lec1.trim().isEmpty() || lec1.length() == 0) {

            String session1 = String.join("-", lec2, scode, tag, sgroup, nostu, duration);

            jTextPaneGen.setText(session1);

        } else if (lec2.trim().isEmpty() || lec2.length() == 0) {

            String session2 = String.join("-", lec1, scode, tag, sgroup, nostu, duration);

            jTextPaneGen.setText(session2);

        } else {
             
            String session3 = String.join("-", lec1, lec2, scode, tag, sgroup, nostu, duration);

            jTextPaneGen.setText(session3);

        }


    }//GEN-LAST:event_GenActionPerformed

    private void jComboBoxLecturer1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxLecturer1ItemStateChanged
        // TODO add your handling code here:
        jTextPaneGen.setText("");
    }//GEN-LAST:event_jComboBoxLecturer1ItemStateChanged

    private void jComboBoxLecturer2ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxLecturer2ItemStateChanged
        // TODO add your handling code here:
        jTextPaneGen.setText("");
    }//GEN-LAST:event_jComboBoxLecturer2ItemStateChanged

    private void jComboBoxTagItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxTagItemStateChanged
        // TODO add your handling code here:
        jTextPaneGen.setText("");

    }//GEN-LAST:event_jComboBoxTagItemStateChanged

    private void jComboBoxGroupItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxGroupItemStateChanged
        // TODO add your handling code here:
        jTextPaneGen.setText("");

    }//GEN-LAST:event_jComboBoxGroupItemStateChanged

    private void jComboBoxSubjectItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxSubjectItemStateChanged
        // TODO add your handling code here:
        jTextPaneGen.setText("");

    }//GEN-LAST:event_jComboBoxSubjectItemStateChanged

    private void jComboBoxSubjectCodeItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxSubjectCodeItemStateChanged
        // TODO add your handling code here:
        jTextPaneGen.setText("");

    }//GEN-LAST:event_jComboBoxSubjectCodeItemStateChanged

    private void jSpinnernumofstudentStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSpinnernumofstudentStateChanged
        // TODO add your handling code here:
        jTextPaneGen.setText("");

    }//GEN-LAST:event_jSpinnernumofstudentStateChanged

    private void jSpinnerHRSStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSpinnerHRSStateChanged
        // TODO add your handling code here:
        jTextPaneGen.setText("");

    }//GEN-LAST:event_jSpinnerHRSStateChanged

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
            java.util.logging.Logger.getLogger(Add_Session.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Add_Session.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Add_Session.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Add_Session.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Add_Session().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JSpinner EndHrs;
    private javax.swing.JSpinner EndMin;
    private javax.swing.JButton Gen;
    private javax.swing.JButton JbuttonClear;
    private javax.swing.JSpinner StartHrs;
    private javax.swing.JSpinner StartMin;
    private javax.swing.JButton addsessionclick;
    private javax.swing.JButton backclick;
    private javax.swing.JButton dashboardclick;
    private javax.swing.JButton jButtonSave;
    private javax.swing.JComboBox<String> jComboBoxDay;
    private javax.swing.JComboBox<String> jComboBoxGroup;
    private javax.swing.JComboBox<String> jComboBoxLecturer1;
    private javax.swing.JComboBox<String> jComboBoxLecturer2;
    private javax.swing.JComboBox<String> jComboBoxSubject;
    private javax.swing.JComboBox<String> jComboBoxSubjectCode;
    private javax.swing.JComboBox<String> jComboBoxTag;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanelScode;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSpinner jSpinnerHRS;
    private javax.swing.JSpinner jSpinnerMin;
    private javax.swing.JSpinner jSpinnernumofstudent;
    private javax.swing.JTextField jTextFieldSelectedLecturers;
    private javax.swing.JTextPane jTextPaneGen;
    private javax.swing.JButton managesessionclick;
    // End of variables declaration//GEN-END:variables
}
