/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Thishi;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;


/**
 *
 * @author User
 */
public final class View_Tables extends javax.swing.JFrame {

    /**
     * Creates new form View_Consecutive
     */
    public View_Tables() {
        initComponents();
                jtableColumnWidth();

        jTable2.setShowGrid(true);
        jTable4.setShowGrid(true);
        jTable1.setShowGrid(true);
        hidesize();
    }

    //Set Desktop Application size and hide Maximize Window
    void hidesize() {

        setSize(1400, 820);
        setLocationRelativeTo(null);
        setResizable(false); // maximize button disable
       
    }
    //set jtable Column width 

    void jtableColumnWidth() {

        jTable2.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        jTable2.getColumnModel().getColumn(0).setPreferredWidth(200);
        jTable2.getColumnModel().getColumn(1).setPreferredWidth(200);
        jTable2.getColumnModel().getColumn(2).setPreferredWidth(200);
        jTable2.getColumnModel().getColumn(3).setPreferredWidth(200);
        jTable2.getColumnModel().getColumn(4).setPreferredWidth(200);
        jTable2.getColumnModel().getColumn(5).setPreferredWidth(200);
        jTable2.getColumnModel().getColumn(6).setPreferredWidth(200);
        jTable2.getColumnModel().getColumn(7).setPreferredWidth(200);
        jTable2.getColumnModel().getColumn(8).setPreferredWidth(200);
        jTable2.getColumnModel().getColumn(9).setPreferredWidth(200);
        jTable2.getColumnModel().getColumn(10).setPreferredWidth(200);
        jTable2.getColumnModel().getColumn(11).setPreferredWidth(200);
        jTable2.getColumnModel().getColumn(12).setPreferredWidth(200);
        jTable2.getColumnModel().getColumn(13).setPreferredWidth(200);
        jTable2.getColumnModel().getColumn(14).setPreferredWidth(200);
        jTable2.getColumnModel().getColumn(15).setPreferredWidth(200);

        jTable2.getColumnModel().getColumn(16).setPreferredWidth(400);

        
        jTable4.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        jTable4.getColumnModel().getColumn(0).setPreferredWidth(200);
        jTable4.getColumnModel().getColumn(1).setPreferredWidth(200);
        jTable4.getColumnModel().getColumn(2).setPreferredWidth(200);
        jTable4.getColumnModel().getColumn(3).setPreferredWidth(200);
        jTable4.getColumnModel().getColumn(4).setPreferredWidth(200);
        jTable4.getColumnModel().getColumn(5).setPreferredWidth(200);
        jTable4.getColumnModel().getColumn(6).setPreferredWidth(200);
        jTable4.getColumnModel().getColumn(7).setPreferredWidth(200);
        jTable4.getColumnModel().getColumn(8).setPreferredWidth(200);
        jTable4.getColumnModel().getColumn(9).setPreferredWidth(200);
        jTable4.getColumnModel().getColumn(10).setPreferredWidth(200);
        jTable4.getColumnModel().getColumn(11).setPreferredWidth(200);
        jTable4.getColumnModel().getColumn(12).setPreferredWidth(200);
        jTable4.getColumnModel().getColumn(13).setPreferredWidth(200);
        jTable4.getColumnModel().getColumn(14).setPreferredWidth(200);
        jTable4.getColumnModel().getColumn(15).setPreferredWidth(200);

        jTable4.getColumnModel().getColumn(16).setPreferredWidth(400);

        
        jTable1.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        jTable1.getColumnModel().getColumn(0).setPreferredWidth(200);
        jTable1.getColumnModel().getColumn(1).setPreferredWidth(200);
        jTable1.getColumnModel().getColumn(2).setPreferredWidth(200);
        jTable1.getColumnModel().getColumn(3).setPreferredWidth(200);
        jTable1.getColumnModel().getColumn(4).setPreferredWidth(200);
        jTable1.getColumnModel().getColumn(5).setPreferredWidth(200);
        jTable1.getColumnModel().getColumn(6).setPreferredWidth(200);
        jTable1.getColumnModel().getColumn(7).setPreferredWidth(200);
        jTable1.getColumnModel().getColumn(8).setPreferredWidth(200);
        jTable1.getColumnModel().getColumn(9).setPreferredWidth(200);
        jTable1.getColumnModel().getColumn(10).setPreferredWidth(200);
                jTable1.getColumnModel().getColumn(11).setPreferredWidth(200);
        jTable1.getColumnModel().getColumn(12).setPreferredWidth(200);
        jTable1.getColumnModel().getColumn(13).setPreferredWidth(200);
        jTable1.getColumnModel().getColumn(14).setPreferredWidth(200);
        jTable1.getColumnModel().getColumn(15).setPreferredWidth(200);

        jTable1.getColumnModel().getColumn(16).setPreferredWidth(400);

    }

    //Display All Data in Jtable
    public void displaytableConsecative() {

        try {
            try (Connection cn = connection.DB_Connect.ConnecrDB()) {
                String select = "select * from consecutive";
              

                PreparedStatement pst = cn.prepareStatement(select);
                


                DefaultTableModel model1 = (DefaultTableModel) jTable4.getModel();
                model1.setRowCount(0);

             

                ResultSet rs = pst.executeQuery();
                while (rs.next()) {

                    //Data will be added until finish
                    String cn_id = String.valueOf(rs.getInt("cn_id"));
                    String se_id = String.valueOf(rs.getInt("se_id"));
                    String lec1 = rs.getString("lec1");
                    String lec2 = rs.getString("lec2");
                    String tag = rs.getString("tag");

                    String sgroup = rs.getString("sgroup");
                    String scode = rs.getString("scode");

                    String ssubject = rs.getString("ssubject");
                    String nostu = rs.getString("nostu");
                    String hrs = rs.getString("hrs");
                    String min = rs.getString("min");
                    String day=rs.getString("day");
                    String shrs=rs.getString("shrs");
                    String smin=rs.getString("smin");
                    String ehrs=rs.getString("ehrs");
                    String emin=rs.getString("emin");
                    String sesname=rs.getString("sesname");

                    //string array for store data into jtable
                    String tbData[] = {cn_id ,se_id, lec1, lec2, scode, tag, ssubject, sgroup, nostu, hrs, min,day,shrs,smin,ehrs,emin,sesname};
                    DefaultTableModel tblModel = (DefaultTableModel) jTable4.getModel();

                    tblModel.addRow(tbData);

                   
                }

            }
        } catch (SQLException e) {

            JOptionPane.showMessageDialog(this, e);

        }

    }
    public void displaytableParrel() {

        try {
            try (Connection cn = connection.DB_Connect.ConnecrDB()) {
                String select = "select * from parallel";
              

                PreparedStatement pst = cn.prepareStatement(select);
                


                DefaultTableModel model1 = (DefaultTableModel) jTable2.getModel();
                model1.setRowCount(0);

             

                ResultSet rs = pst.executeQuery();
                while (rs.next()) {

                    //Data will be added until finish
                    String pa_id = String.valueOf(rs.getInt("pa_id"));
                    String se_id = String.valueOf(rs.getInt("se_id"));
                    String lec1 = rs.getString("lec1");
                    String lec2 = rs.getString("lec2");
                    String tag = rs.getString("tag");

                    String sgroup = rs.getString("sgroup");
                    String scode = rs.getString("scode");

                    String ssubject = rs.getString("ssubject");
                    String nostu = rs.getString("nostu");
                    String hrs = rs.getString("hrs");
                    String min = rs.getString("min");
                    String day=rs.getString("day");
                    String shrs=rs.getString("shrs");
                    String smin=rs.getString("smin");
                    String ehrs=rs.getString("ehrs");
                    String emin=rs.getString("emin");
                    String sesname=rs.getString("sesname");
                    //  String session =String.join("_",sgroup,scode,tag);

                    //string array for store data into jtable
                    String tbData[] = {pa_id ,se_id, lec1, lec2, scode, tag, ssubject, sgroup, nostu, hrs, min,day,shrs,smin,ehrs,emin,sesname};
                    DefaultTableModel tblModel = (DefaultTableModel) jTable2.getModel();

                    tblModel.addRow(tbData);

                   
                }

            }
        } catch (SQLException e) {

            JOptionPane.showMessageDialog(this, e);

        }

    }
      public void displaytableNon() {

        try {
            try (Connection cn = connection.DB_Connect.ConnecrDB()) {
                String select = "select * from non_overlapping";
              

                PreparedStatement pst = cn.prepareStatement(select);
                


                DefaultTableModel model1 = (DefaultTableModel) jTable1.getModel();
                model1.setRowCount(0);

             

                ResultSet rs = pst.executeQuery();
                while (rs.next()) {

                    //Data will be added until finish
                    String no_id=String.valueOf(rs.getInt("no_id"));
                    String se_id = String.valueOf(rs.getInt("se_id"));
                    String lec1 = rs.getString("lec1");
                    String lec2 = rs.getString("lec2");
                    String tag = rs.getString("tag");

                    String sgroup = rs.getString("sgroup");
                    String scode = rs.getString("scode");

                    String ssubject = rs.getString("ssubject");
                    String nostu = rs.getString("nostu");
                    String hrs = rs.getString("hrs");
                    String min = rs.getString("min");
                    String day=rs.getString("day");
                    String shrs=rs.getString("shrs");
                    String smin=rs.getString("smin");
                    String ehrs=rs.getString("ehrs");
                    String emin=rs.getString("emin");
                    String sesname=rs.getString("sesname");
                    //  String session =String.join("_",sgroup,scode,tag);

                    //string array for store data into jtable
                    String tbData[] = { no_id,se_id, lec1, lec2, scode, tag, ssubject, sgroup, nostu, hrs, min,day,shrs,smin,ehrs,emin,sesname};
                    DefaultTableModel tblModel = (DefaultTableModel) jTable1.getModel();

                    tblModel.addRow(tbData);

                   
                }

            }
        } catch (SQLException e) {

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
        BackClick = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jTabbedPane5 = new javax.swing.JTabbedPane();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable4 = new javax.swing.JTable();
        jButtonDeleteCon = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabelCon = new javax.swing.JLabel();
        jButtonDAll1 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabelcname = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jButtonDeletePar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabelPar = new javax.swing.JLabel();
        jButtonDAll2 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabelpname = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButtonDeleteNon = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabelNon = new javax.swing.JLabel();
        jButtonDAll3 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabelnonname = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pasindu_img/logo.jpeg"))); // NOI18N

        BackClick.setBackground(new java.awt.Color(0, 153, 153));
        BackClick.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        BackClick.setText("<<Back");
        BackClick.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackClickActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 153, 153));
        jLabel2.setText("View Sessions  Time Allocations");

        jTable4.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Consecutive_ID", "Session_ID", "Lecturer1", "Lecturer2", "Subject Code", "Tag", "Subject", "Group", "No Of Student", "Duration(Hrs)", "Duration(Min)", "Day", "Start Time(Hrs)", "Start Time(Min)", "End Time(Hrs)", "End Time(Min)", "Session Name"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable4.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        jTable4.setGridColor(new java.awt.Color(51, 153, 255));
        jTable4.setRowHeight(50);
        jTable4.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                jTable4AncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        jTable4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable4MouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(jTable4);

        jButtonDeleteCon.setBackground(new java.awt.Color(0, 153, 153));
        jButtonDeleteCon.setText("Delete");
        jButtonDeleteCon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDeleteConActionPerformed(evt);
            }
        });

        jLabel3.setText("Select Row ID");

        jLabelCon.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabelCon.setText("1");

        jButtonDAll1.setBackground(new java.awt.Color(0, 153, 153));
        jButtonDAll1.setText("Delete All");
        jButtonDAll1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDAll1ActionPerformed(evt);
            }
        });

        jLabel9.setText("Section Name");

        jLabelcname.setText("jLabel10");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 876, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(106, 106, 106)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabelcname, javax.swing.GroupLayout.PREFERRED_SIZE, 478, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jButtonDAll1, javax.swing.GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE)
                                    .addComponent(jButtonDeleteCon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(86, 86, 86))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabelCon)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 386, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(76, 76, 76)
                        .addComponent(jButtonDeleteCon, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelCon))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(jLabelcname, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addComponent(jButtonDAll1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(70, Short.MAX_VALUE))
        );

        jTabbedPane5.addTab("Consecative", jPanel6);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Parallel_ID", "Session_ID", "Lecturer 1", "Lecturer 2", "Subject Code", "Tag", "Subject", "Group", "No Of Student", "Duration(Hrs)_", "Duration(Miin)", "Day", "Start Time(Hrs)", "Start Time(Min)", "End Time(Hrs)", "End Time(Min)", "Session Name"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable2.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        jTable2.setGridColor(new java.awt.Color(51, 153, 255));
        jTable2.setRowHeight(50);
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

        jButtonDeletePar.setBackground(new java.awt.Color(0, 153, 153));
        jButtonDeletePar.setText("Delete");
        jButtonDeletePar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDeleteParActionPerformed(evt);
            }
        });

        jLabel5.setText("Select Row Id");

        jLabelPar.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabelPar.setText("1");

        jButtonDAll2.setBackground(new java.awt.Color(0, 153, 153));
        jButtonDAll2.setText("Delete All");
        jButtonDAll2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDAll2ActionPerformed(evt);
            }
        });

        jLabel6.setText("Section Name");

        jLabelpname.setText("jLabel8");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 871, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 34, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelpname, javax.swing.GroupLayout.PREFERRED_SIZE, 465, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButtonDAll2, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonDeletePar, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(119, 119, 119))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jLabelPar)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 391, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonDeletePar, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabelPar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jLabelpname, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addComponent(jButtonDAll2, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(66, Short.MAX_VALUE))
        );

        jTabbedPane5.addTab("Parallel", jPanel2);

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Non-OverlappingID", "Session_ID", "Lecturer1", "Lecturer2", "Subject Code", "Tag", "Subject", "Group", "No Of Student", "Duration(Hrs)", "Duration(Min)", "Day", "Start Time(Hrs)", "Start Time(Min)", "End Time(Hrs)", "End Time(Min)", "Session Name"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        jTable1.setGridColor(new java.awt.Color(51, 153, 255));
        jTable1.setRowHeight(50);
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

        jButtonDeleteNon.setBackground(new java.awt.Color(0, 153, 153));
        jButtonDeleteNon.setText("Delete");
        jButtonDeleteNon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDeleteNonActionPerformed(evt);
            }
        });

        jLabel7.setText("Select Row Id");

        jLabelNon.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabelNon.setText("1");

        jButtonDAll3.setBackground(new java.awt.Color(0, 153, 153));
        jButtonDAll3.setText("Delete All");
        jButtonDAll3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDAll3ActionPerformed(evt);
            }
        });

        jLabel4.setText("Section Name:");

        jLabelnonname.setText("jLabel6");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 921, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(123, 123, 123)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jLabelNon)
                        .addGap(450, 450, 450))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelnonname, javax.swing.GroupLayout.PREFERRED_SIZE, 483, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButtonDAll3, javax.swing.GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE)
                    .addComponent(jButtonDeleteNon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(85, 85, 85))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(62, 62, 62)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonDeleteNon, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(jLabelNon))
                .addGap(15, 15, 15)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonDAll3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabelnonname, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(73, Short.MAX_VALUE))
        );

        jTabbedPane5.addTab("Non Overllaping", jPanel3);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(85, 85, 85)
                        .addComponent(BackClick, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, 0)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 814, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jTabbedPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 910, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(167, 167, 167)
                .addComponent(BackClick)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(jLabel2)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jTabbedPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 656, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37))
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

    private void BackClickActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackClickActionPerformed
        // TODO add your handling code here
        Sessions_AvailableTime dash = new Sessions_AvailableTime();
        dash.show();
        dispose();
    }//GEN-LAST:event_BackClickActionPerformed

    private void jTable4AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jTable4AncestorAdded
        // TODO add your handling code here:
        displaytableConsecative();

    }//GEN-LAST:event_jTable4AncestorAdded

    private void jTable2AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jTable2AncestorAdded
        // TODO add your handling code here:
        displaytableParrel();
    }//GEN-LAST:event_jTable2AncestorAdded

    private void jTable1AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jTable1AncestorAdded
        // TODO add your handling code here:
        displaytableNon();
    }//GEN-LAST:event_jTable1AncestorAdded

    private void jTable4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable4MouseClicked
        // TODO add your handling code here:
          int i=jTable4.getSelectedRow();
           
            TableModel model=jTable4.getModel();
           jLabelCon.setText(model.getValueAt(i, 0).toString());
           jLabelcname.setText(model.getValueAt(i, 11).toString());
 // jLabelcname
    }//GEN-LAST:event_jTable4MouseClicked

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
        // TODO add your handling code here:
       // jTable2
                   int i=jTable2.getSelectedRow();
           
            TableModel model=jTable2.getModel();
           jLabelPar.setText(model.getValueAt(i, 0).toString());
           jLabelpname.setText(model.getValueAt(i, 11).toString());
                
    }//GEN-LAST:event_jTable2MouseClicked

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
          int i=jTable1.getSelectedRow();
           
            TableModel model=jTable1.getModel();
           jLabelNon.setText(model.getValueAt(i, 0).toString());
           jLabelnonname.setText(model.getValueAt(i, 11).toString());
        
        
        
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButtonDeleteConActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDeleteConActionPerformed
        // TODO add your handling code here:
          
            Connection cn=connection.DB_Connect.ConnecrDB();

        try{
        int row =jTable4.getSelectedRow();
        String value=(jTable4.getModel().getValueAt(row, 0).toString());
        String query="DELETE FROM consecutive where cn_id="+value;
        PreparedStatement pst=cn.prepareStatement(query);
        pst.executeUpdate();
       
        
         JOptionPane.showMessageDialog(null, "Deleted Sucessfully");
         DefaultTableModel tableModel = (DefaultTableModel) jTable4.getModel();
         tableModel.setRowCount(0);
       
//call modhode
        displaytableConsecative();
        pst.close();
        cn.close();
        
    }catch( HeadlessException | SQLException e){
    
        JOptionPane.showMessageDialog(null,e);
    }
        
        
        
        
    }//GEN-LAST:event_jButtonDeleteConActionPerformed

    private void jButtonDeleteParActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDeleteParActionPerformed
        // TODO add your handling code here:
           Connection cn=connection.DB_Connect.ConnecrDB();

        try{
        int row =jTable2.getSelectedRow();
        String value=(jTable2.getModel().getValueAt(row, 0).toString());
        String query="DELETE FROM parallel where pa_id="+value;
        PreparedStatement pst=cn.prepareStatement(query);
        pst.executeUpdate();
       
        
         JOptionPane.showMessageDialog(null, "Deleted Sucessfully");
         DefaultTableModel tableModel = (DefaultTableModel) jTable2.getModel();
         tableModel.setRowCount(0);
       
//call modhode
        displaytableParrel();
        pst.close();
        cn.close();
        
    }catch( HeadlessException | SQLException e){
    
        JOptionPane.showMessageDialog(null,e);
    }
        
        
    }//GEN-LAST:event_jButtonDeleteParActionPerformed

    private void jButtonDeleteNonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDeleteNonActionPerformed
        // TODO add your handling code here:
        
           Connection cn=connection.DB_Connect.ConnecrDB();

        try{
        int row =jTable1.getSelectedRow();
        String value=(jTable1.getModel().getValueAt(row, 0).toString());
        String query="DELETE FROM non_overlapping where no_id="+value;
        PreparedStatement pst=cn.prepareStatement(query);
        pst.executeUpdate();
       
        
         JOptionPane.showMessageDialog(null, "Deleted Sucessfully");
         DefaultTableModel tableModel = (DefaultTableModel) jTable1.getModel();
         tableModel.setRowCount(0);
       
//call modhode
        displaytableNon();
        pst.close();
        cn.close();
        
    }catch( HeadlessException | SQLException e){
    
        JOptionPane.showMessageDialog(null,e);
    }
        
    }//GEN-LAST:event_jButtonDeleteNonActionPerformed

    private void jButtonDAll3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDAll3ActionPerformed
        // TODO add your handling code here:
            
          
           Connection cn=connection.DB_Connect.ConnecrDB();

        try{
        String query="DELETE FROM non_overlapping";
        PreparedStatement pst=cn.prepareStatement(query);
        pst.executeUpdate();
       
        
         JOptionPane.showMessageDialog(null, "Deleted Sucessfully");
         DefaultTableModel tableModel = (DefaultTableModel) jTable1.getModel();
         tableModel.setRowCount(0);
       
//call modhode
        displaytableNon();
        pst.close();
        cn.close();
        
    }catch( HeadlessException | SQLException e){
    
        JOptionPane.showMessageDialog(null,e);
    }
        
        
     
        
    }//GEN-LAST:event_jButtonDAll3ActionPerformed

    private void jButtonDAll2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDAll2ActionPerformed
        // TODO add your handling code here:
             Connection cn=connection.DB_Connect.ConnecrDB();

        try{
        String query="DELETE FROM parallel";
                 try (PreparedStatement pst = cn.prepareStatement(query)) {
                     pst.executeUpdate();
                     
                     
                     JOptionPane.showMessageDialog(null, "Deleted Sucessfully");
                     DefaultTableModel tableModel = (DefaultTableModel) jTable2.getModel();
                     tableModel.setRowCount(0);
                     
//call modhode
displaytableParrel();
                 }
        cn.close();
        
    }catch( HeadlessException | SQLException e){
    
        JOptionPane.showMessageDialog(null,e);
    }
    }//GEN-LAST:event_jButtonDAll2ActionPerformed

    private void jButtonDAll1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDAll1ActionPerformed
        // TODO add your handling code here:
           Connection cn=connection.DB_Connect.ConnecrDB();

        try{
        
        String query="DELETE FROM consecutive";
                try (PreparedStatement pst = cn.prepareStatement(query)) {
                    pst.executeUpdate();
                    
                    
                    JOptionPane.showMessageDialog(null, "Deleted Sucessfully");
                    DefaultTableModel tableModel = (DefaultTableModel) jTable4.getModel();
                    tableModel.setRowCount(0);
                    
//call modhode
displaytableConsecative();
                }
        cn.close();
        
    }catch( HeadlessException | SQLException e){
    
        JOptionPane.showMessageDialog(null,e);
    }
        
        
        
        
    }//GEN-LAST:event_jButtonDAll1ActionPerformed

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
            java.util.logging.Logger.getLogger(View_Tables.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(View_Tables.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(View_Tables.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(View_Tables.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new View_Tables().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BackClick;
    private javax.swing.JButton jButtonDAll1;
    private javax.swing.JButton jButtonDAll2;
    private javax.swing.JButton jButtonDAll3;
    private javax.swing.JButton jButtonDeleteCon;
    private javax.swing.JButton jButtonDeleteNon;
    private javax.swing.JButton jButtonDeletePar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelCon;
    private javax.swing.JLabel jLabelNon;
    private javax.swing.JLabel jLabelPar;
    private javax.swing.JLabel jLabelcname;
    private javax.swing.JLabel jLabelnonname;
    private javax.swing.JLabel jLabelpname;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane5;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable4;
    // End of variables declaration//GEN-END:variables
}
