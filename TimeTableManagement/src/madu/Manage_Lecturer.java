/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package madu;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import net.proteanit.sql.DbUtils;
import actions.*;

/**
 *
 * @author Madu
 */
public final class Manage_Lecturer extends javax.swing.JFrame {

    Lecturer_Update lu = new Lecturer_Update();
    Lecturer_Delete ld = new Lecturer_Delete();

    /**
     * Creates new form Manage_Lecturer
     */
    public Manage_Lecturer() {
 
        initComponents();
        
//implement the hide size
        hidesize();
        //Gride Add Jtable
        jTable1.setShowGrid(true);
//database retrive function(Faculty)        
        facultycombox();
//database retrive function(Department)               
        departmentcombox();
//database retrive function(Center)                
        centercombox();
//database retrive function(Building)                
        buildingcombox();
//database retrive function(Level)                
        levelbox();
        //implement the jcolumn width setting function
        jtableColumnWidth();
    }

//hidewindow size and Maximize disable
    void hidesize() {

        setSize(1400, 820);
        setLocationRelativeTo(null);
        setResizable(false); // maximize button disable
        setVisible(true);

    }

    void LoadDataUpdate() {
        try {
            int row = jTable1.getSelectedRow();
            String value = (jTable1.getModel().getValueAt(row, 0).toString());
            lu.value = Integer.parseInt(value);

        } catch (NumberFormatException ex) {

            JOptionPane.showMessageDialog(null, "Load in Form" + ex.getMessage());

        }
    }

    void LoadDataDelete() {
        try {

            int row = jTable1.getSelectedRow();
            String value = (jTable1.getModel().getValueAt(row, 0).toString());
            ld.value = Integer.parseInt(value);

        } catch (NumberFormatException ex) {

            JOptionPane.showMessageDialog(null, "Load in Form" + ex.getMessage());

        }

    }
//Retive All the Faculty Data to Combobox

    void facultycombox() {
        // TODO add your handling code here:
        try {
            Connection cn = connection.DB_Connect.ConnecrDB();

            String sql = "select DISTINCT name from faculty_dep";
            Statement pst = cn.createStatement();
            ResultSet rs = pst.executeQuery(sql);
            while (rs.next()) {

                String name = rs.getString("name");
                jComboBoxFaculty.addItem(name);

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
    void departmentcombox() {
        try {
            try (Connection cn = connection.DB_Connect.ConnecrDB()) {
                String sql1 = "select DISTINCT department from faculty_dep ";
                Statement pst = cn.createStatement();
                ResultSet rs = pst.executeQuery(sql1);
                while (rs.next()) {

                    String department = rs.getString("department");
                    jComboBoxDepartment.addItem(department);

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
    void centercombox() {
        try {
            Connection cn = connection.DB_Connect.ConnecrDB();

            String sql1 = "select DISTINCT name from center";
            Statement pst = cn.createStatement();
            ResultSet rs = pst.executeQuery(sql1);
            while (rs.next()) {

                String name = rs.getString("name");
                jComboBoxCenter.addItem(name);

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

    void buildingcombox() {
        // TODO add your handling code here:
        try {
            Connection cn = connection.DB_Connect.ConnecrDB();

            String sql = "select DISTINCT building from location ";
            Statement pst = cn.createStatement();
            ResultSet rs = pst.executeQuery(sql);
            while (rs.next()) {

                String building = rs.getString("building");
                jComboBoxBuilding.addItem(building);

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

    void levelbox() {
        try {
            try (Connection cn = connection.DB_Connect.ConnecrDB()) {
                String sql1 = "select DISTINCT level_num from level";
                Statement pst = cn.createStatement();
                ResultSet rs = pst.executeQuery(sql1);
                while (rs.next()) {

                    String building = rs.getString("level_num");
                    jComboBoxLeval.addItem(building);

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
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        Update = new javax.swing.JButton();
        Delete = new javax.swing.JButton();
        Clear = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jTextLecturerName = new javax.swing.JTextField();
        jTextFieldEmployeeId = new javax.swing.JTextField();
        jComboBoxDepartment = new javax.swing.JComboBox<>();
        jComboBoxCenter = new javax.swing.JComboBox<>();
        jComboBoxBuilding = new javax.swing.JComboBox<>();
        jComboBoxLeval = new javax.swing.JComboBox<>();
        errolecturername = new javax.swing.JLabel();
        erroempid = new javax.swing.JLabel();
        errofaculty = new javax.swing.JLabel();
        errodepartment = new javax.swing.JLabel();
        errocenter = new javax.swing.JLabel();
        errobuilding = new javax.swing.JLabel();
        eroolevel = new javax.swing.JLabel();
        jLabelRank = new javax.swing.JLabel();
        jComboBoxFaculty = new javax.swing.JComboBox<>();
        errorank = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        dahboardclick = new javax.swing.JButton();
        addlecturerclick = new javax.swing.JButton();
        managelecturerclick = new javax.swing.JButton();
        backclick = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(1400, 820));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pasindu_img/logo.jpeg"))); // NOI18N

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        jScrollPane1.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                jScrollPane1AncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        jTable1.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name", "Emp. ID", "Faculty", "Level", "Department ", "Center", "Building", "Rank"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setGridColor(new java.awt.Color(51, 153, 255));
        jTable1.setInheritsPopupMenu(true);
        jTable1.setRowHeight(55);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        Update.setBackground(new java.awt.Color(0, 153, 153));
        Update.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Update.setText("Update");
        Update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateActionPerformed(evt);
            }
        });

        Delete.setBackground(new java.awt.Color(0, 153, 153));
        Delete.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Delete.setText("Delete");
        Delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteActionPerformed(evt);
            }
        });

        Clear.setBackground(new java.awt.Color(0, 153, 153));
        Clear.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Clear.setText("Clear");
        Clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClearActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Lecturer Name:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Employee Id");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Faculty");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Department");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("Center");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("Building");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setText("Leval");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setText("Rank");

        jTextLecturerName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextLecturerNameKeyReleased(evt);
            }
        });

        jTextFieldEmployeeId.setEditable(false);

        jComboBoxDepartment.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));
        jComboBoxDepartment.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxDepartmentItemStateChanged(evt);
            }
        });

        jComboBoxCenter.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));
        jComboBoxCenter.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxCenterItemStateChanged(evt);
            }
        });

        jComboBoxBuilding.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));
        jComboBoxBuilding.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxBuildingItemStateChanged(evt);
            }
        });

        jComboBoxLeval.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));
        jComboBoxLeval.setEnabled(false);
        jComboBoxLeval.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxLevalItemStateChanged(evt);
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

        jLabelRank.setForeground(java.awt.Color.red);

        jComboBoxFaculty.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "" }));
        jComboBoxFaculty.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxFacultyItemStateChanged(evt);
            }
        });

        errorank.setForeground(new java.awt.Color(255, 0, 0));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextLecturerName)
                                    .addComponent(jTextFieldEmployeeId)
                                    .addComponent(jComboBoxDepartment, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jComboBoxFaculty, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(161, 161, 161)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(errolecturername, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(erroempid, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(errofaculty, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(errodepartment, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(67, 67, 67)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel10))
                                .addGap(30, 30, 30)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jComboBoxCenter, 0, 265, Short.MAX_VALUE)
                                    .addComponent(jComboBoxBuilding, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jComboBoxLeval, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabelRank, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(errocenter, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(errobuilding, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(eroolevel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(errorank, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 669, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(Update, javax.swing.GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE)
                            .addComponent(Delete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Clear, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(94, 94, 94))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(83, 83, 83)
                        .addComponent(Update, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(Delete, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(Clear, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(51, 51, 51)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel7)
                    .addComponent(jTextLecturerName, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxCenter, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(errolecturername, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(errocenter, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(jTextFieldEmployeeId, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxBuilding, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(erroempid, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(errobuilding, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel9)
                        .addComponent(jComboBoxLeval, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jComboBoxFaculty))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(errofaculty, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(eroolevel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel10)
                        .addComponent(jComboBoxDepartment, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabelRank, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(5, 5, 5)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(errodepartment, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(errorank))
                .addContainerGap(33, Short.MAX_VALUE))
        );

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 153, 153));
        jLabel2.setText("Manage Lecturer");

        dahboardclick.setBackground(new java.awt.Color(0, 153, 153));
        dahboardclick.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        dahboardclick.setText("Dashboard");
        dahboardclick.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dahboardclickActionPerformed(evt);
            }
        });

        addlecturerclick.setBackground(new java.awt.Color(0, 153, 153));
        addlecturerclick.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        addlecturerclick.setText("Add Lecturer");
        addlecturerclick.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addlecturerclickActionPerformed(evt);
            }
        });

        managelecturerclick.setBackground(new java.awt.Color(0, 153, 153));
        managelecturerclick.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        managelecturerclick.setText("Manage Lecturer");

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
                        .addGap(99, 99, 99)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(managelecturerclick, javax.swing.GroupLayout.DEFAULT_SIZE, 221, Short.MAX_VALUE)
                            .addComponent(addlecturerclick, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(dahboardclick, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(152, 152, 152)
                        .addComponent(backclick)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 50, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(dahboardclick, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(addlecturerclick, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(managelecturerclick, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(backclick, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(56, 56, 56))
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
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
//Display All Data in Jtable

    public void displaytable() {

        try {
            try (Connection cn = connection.DB_Connect.ConnecrDB()) {
                String select = "select * from lecturer";
                PreparedStatement pst = cn.prepareStatement(select);

                ResultSet rs = pst.executeQuery();
                while (rs.next()) {
                    //Data will be added until finish
                    String lid = String.valueOf(rs.getInt("lid"));
                    String name = rs.getString("name");
                    String employee_id = rs.getString("employee_id");
                    String faculty = rs.getString("faculty");
                    String leval = rs.getString("leval");
                    String department = rs.getString("department");
                    String center = rs.getString("center");
                    String building = rs.getString("building");
                    String rank = rs.getString("rank");

                    //string array for store data into jtable
                    String tbData[] = {lid, name, employee_id, faculty, leval, department, center, building, rank};
                    DefaultTableModel tblModel = (DefaultTableModel) jTable1.getModel();

                    tblModel.addRow(tbData);
                }
                //Connection Close
                rs.close();
                pst.close();
                cn.close();
            }
        } catch (SQLException e) {

            //Display Erro Message
            JOptionPane.showMessageDialog(this, e);

        }

    }

//Update Lecturer Data
    private void UpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateActionPerformed
        // TODO add your handling code here:

        LoadDataUpdate();

        String LecturerName = jTextLecturerName.getText();
        String EmpId = jTextFieldEmployeeId.getText();
        String Faculty = jComboBoxFaculty.getSelectedItem().toString();
        String Department = jComboBoxDepartment.getSelectedItem().toString();
        String Center = jComboBoxCenter.getSelectedItem().toString();
        String Building = jComboBoxBuilding.getSelectedItem().toString();
        String Level = jComboBoxLeval.getSelectedItem().toString();
        String Rank = jLabelRank.getText();

//Check Empty Validations
        if (jTextLecturerName.getText().trim().isEmpty() || jTextFieldEmployeeId.getText().trim().isEmpty() || jComboBoxBuilding.getSelectedIndex() == 0 || jComboBoxCenter.getSelectedIndex() == 0 || jComboBoxDepartment.getSelectedIndex() == 0 || jComboBoxLeval.getSelectedIndex() == 0 || jComboBoxFaculty.getSelectedIndex() == 0 || jLabelRank.getText().trim().isEmpty()) {

            //call validation
            validation();

        } else {

            lu.UpdateLecturer(LecturerName, EmpId, Faculty, Department, Center, Building, Level, Rank);

        }
        updateRe_table();

    }//GEN-LAST:event_UpdateActionPerformed

//this method helps to Auto Refresh Jtable Data
    private void updateRe_table() {

        Connection cn = connection.DB_Connect.ConnecrDB();
        String sql = "select *from lecturer";

        try {

            ResultSet rs;
            try (PreparedStatement pst = cn.prepareStatement(sql)) {
                rs = pst.executeQuery();
                jTable1.setModel(DbUtils.resultSetToTableModel(rs));
                jtableColumnWidth();
            }
            //Connection Close          
            rs.close();
            cn.close();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }

//Cretae jtable Column Width Any Sizes
    void jtableColumnWidth() {

        jTable1.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
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

    }


    private void dahboardclickActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dahboardclickActionPerformed
        // TODO add your handling code here:
       
        group_implmentation.loging.dashb.setVisible(true);
        this.dispose();

    }//GEN-LAST:event_dahboardclickActionPerformed
Add_Lecturer ad;
    private void addlecturerclickActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addlecturerclickActionPerformed
        // TODO add your handling code here:
            if (ad == null) {
            ad = new Add_Lecturer();
        }
        
        ad.setVisible(true);
        this.dispose();
    
    }//GEN-LAST:event_addlecturerclickActionPerformed
Manage_Lecturer ml;
    private void backclickActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backclickActionPerformed
        // TODO add your handling code here:
         
        group_implmentation.loging.dashb.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_backclickActionPerformed

//Validation Lecturer Name Only Words    
    private void jTextLecturerNameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextLecturerNameKeyReleased
        // TODO add your handling code here:
        String PATTERN = "^[a-zA-Z]+(([',. -][a-zA-Z ])?[a-zA-Z]*)*$";
        Pattern patt = Pattern.compile(PATTERN);
        Matcher match = patt.matcher(jTextLecturerName.getText());

        if (!match.matches()) {
            errolecturername.setText("Please enter words only");

        } else {

            errolecturername.setText(null);
        }


    }//GEN-LAST:event_jTextLecturerNameKeyReleased

    private void jScrollPane1AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jScrollPane1AncestorAdded
        // TODO add your handling code here:
//Call display Table Method 
        displaytable();
    }//GEN-LAST:event_jScrollPane1AncestorAdded

//clicked any column display data any feilds
    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        int i = jTable1.getSelectedRow();

        TableModel model = jTable1.getModel();
        jTextLecturerName.setText(model.getValueAt(i, 1).toString());
        jTextFieldEmployeeId.setText(model.getValueAt(i, 2).toString());
        jComboBoxFaculty.setSelectedItem(model.getValueAt(i, 3).toString());
        jComboBoxLeval.setSelectedItem(model.getValueAt(i, 4).toString());
        jComboBoxDepartment.setSelectedItem(model.getValueAt(i, 5).toString());
        jComboBoxCenter.setSelectedItem(model.getValueAt(i, 6).toString());
        jComboBoxBuilding.setSelectedItem(model.getValueAt(i, 7).toString());
        jLabelRank.setText(model.getValueAt(i, 8).toString());


    }//GEN-LAST:event_jTable1MouseClicked

//Clicked Clear Button All Tha text feilds data clean
    private void ClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClearActionPerformed
        // TODO add your handling code here:
        jTextLecturerName.setText("");
        jComboBoxFaculty.setSelectedIndex(0);
        jComboBoxDepartment.setSelectedIndex(0);
        jComboBoxCenter.setSelectedIndex(0);
        jComboBoxBuilding.setSelectedIndex(0);
        errolecturername.setText("");
        erroempid.setText("");
        errobuilding.setText("");
        errocenter.setText("");
        errodepartment.setText("");
        errofaculty.setText("");
        eroolevel.setText("");
        errorank.setText("");
        jTextFieldEmployeeId.setText("");
        jLabelRank.setText("");
        jComboBoxLeval.setSelectedIndex(0);


    }//GEN-LAST:event_ClearActionPerformed

//Clicked Delete Button delete selected data
    private void DeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteActionPerformed
        // TODO add your handling code here:

        LoadDataDelete();

        ld.LecturerDelete();
        DefaultTableModel tableModel = (DefaultTableModel) jTable1.getModel();
        tableModel.setRowCount(0);

//call the display table methode
        displaytable();


    }//GEN-LAST:event_DeleteActionPerformed

    private void jComboBoxFacultyItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxFacultyItemStateChanged
        // TODO add your handling code here:
        errofaculty.setText("");
    }//GEN-LAST:event_jComboBoxFacultyItemStateChanged

    private void jComboBoxDepartmentItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxDepartmentItemStateChanged
        // TODO add your handling code here:
        errodepartment.setText("");
    }//GEN-LAST:event_jComboBoxDepartmentItemStateChanged

    private void jComboBoxCenterItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxCenterItemStateChanged
        // TODO add your handling code here:
        errocenter.setText("");
    }//GEN-LAST:event_jComboBoxCenterItemStateChanged

    private void jComboBoxBuildingItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxBuildingItemStateChanged
        // TODO add your handling code here:
        errobuilding.setText("");
    }//GEN-LAST:event_jComboBoxBuildingItemStateChanged

    private void jComboBoxLevalItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxLevalItemStateChanged
        // TODO add your handling code here:
        eroolevel.setText("");
    }//GEN-LAST:event_jComboBoxLevalItemStateChanged

    void validation() {

        if (jTextLecturerName.getText().trim().isEmpty() && jTextFieldEmployeeId.getText().trim().isEmpty() && jComboBoxBuilding.getSelectedIndex() == 0 && jComboBoxCenter.getSelectedIndex() == 0 && jComboBoxDepartment.getSelectedIndex() == 0 && jComboBoxLeval.getSelectedIndex() == 0 && jComboBoxFaculty.getSelectedIndex() == 0 && jLabelRank.getText().trim().isEmpty()) {
            //Display Mesage
            JOptionPane.showMessageDialog(this, "Fields are Emplty");
        } else if (jTextLecturerName.getText().trim().isEmpty()) {
            //Display Message  
            errolecturername.setText("Please Enter Lecturer Name");

        } else if (jTextFieldEmployeeId.getText().trim().isEmpty()) {
            //Display Message     
            erroempid.setText("Please Enter Employee Id");

        } else if (jComboBoxBuilding.getSelectedIndex() == 0) {
            //Display Message  
            errobuilding.setText("Please Select Building Name");

        } else if (jComboBoxCenter.getSelectedIndex() == 0) {
            //Display Message  
            errocenter.setText("Please Select Center Name");
        } else if (jComboBoxDepartment.getSelectedIndex() == 0) {
            //Display Message   
            errodepartment.setText("Please Select Department Name");

        } else if (jComboBoxFaculty.getSelectedIndex() == 0) {
            //Display Message        
            errofaculty.setText("Please Select Faculty Name");
        } else if (jComboBoxLeval.getSelectedIndex() == 0) {
            //Display Message         
            eroolevel.setText("Please Select Level Name");
        } else if (jLabelRank.getText().trim().isEmpty()) {
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
            java.util.logging.Logger.getLogger(Manage_Lecturer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Manage_Lecturer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Manage_Lecturer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Manage_Lecturer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Manage_Lecturer().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Clear;
    private javax.swing.JButton Delete;
    private javax.swing.JButton Update;
    private javax.swing.JButton addlecturerclick;
    private javax.swing.JButton backclick;
    private javax.swing.JButton dahboardclick;
    private javax.swing.JLabel eroolevel;
    private javax.swing.JLabel errobuilding;
    private javax.swing.JLabel errocenter;
    private javax.swing.JLabel errodepartment;
    private javax.swing.JLabel erroempid;
    private javax.swing.JLabel errofaculty;
    private javax.swing.JLabel errolecturername;
    private javax.swing.JLabel errorank;
    private javax.swing.JComboBox<String> jComboBoxBuilding;
    private javax.swing.JComboBox<String> jComboBoxCenter;
    private javax.swing.JComboBox<String> jComboBoxDepartment;
    private javax.swing.JComboBox<String> jComboBoxFaculty;
    private javax.swing.JComboBox<String> jComboBoxLeval;
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
    private javax.swing.JLabel jLabelRank;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextFieldEmployeeId;
    private javax.swing.JTextField jTextLecturerName;
    private javax.swing.JButton managelecturerclick;
    // End of variables declaration//GEN-END:variables
}
