/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Thishi;

import group_implmentation.dashboard;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Thishi
 */
public final class Sessions_AvailableTime extends javax.swing.JFrame {

    /**
     * Creates new form Sessions_notAvailableTime
     */
    public Sessions_AvailableTime() {
        initComponents();
        //call methode
        //Gride Add Jtable
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
        jTable2.getColumnModel().getColumn(16).setPreferredWidth(500);

        
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
        jTable4.getColumnModel().getColumn(16).setPreferredWidth(500);

        
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
        jTable1.getColumnModel().getColumn(16).setPreferredWidth(500);

    }

    //Display All Data in Jtable
    public void displaytable() {

        try {
            try (Connection cn = connection.DB_Connect.ConnecrDB()) {
                String select = "select * from session";
                PreparedStatement pst = cn.prepareStatement(select);

                DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
                model.setRowCount(0);

                DefaultTableModel model1 = (DefaultTableModel) jTable4.getModel();
                model1.setRowCount(0);

                DefaultTableModel model2 = (DefaultTableModel) jTable1.getModel();
                model2.setRowCount(0);

                ResultSet rs = pst.executeQuery();
                while (rs.next()) {

                    //Data will be added until finish
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
                    String tbData[] = {null, se_id, lec1, lec2, scode, tag, ssubject, sgroup, nostu, hrs, min,day,shrs,smin,ehrs,emin,sesname};
                    DefaultTableModel tblModel = (DefaultTableModel) jTable2.getModel();

                    tblModel.addRow(tbData);

                    DefaultTableModel tblModel1 = (DefaultTableModel) jTable4.getModel();
                    tblModel1.addRow(tbData);

                    DefaultTableModel tblModel2 = (DefaultTableModel) jTable1.getModel();
                    tblModel2.addRow(tbData);

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
        jButtonConView = new javax.swing.JButton();
        jButtonAdd = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jButtonViewPar = new javax.swing.JButton();
        jButtonAddPar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButtonViewNon = new javax.swing.JButton();
        jButtonAddNon = new javax.swing.JButton();

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
        jLabel2.setText("Sessions  Time Allocations");

        jTable4.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jTable4.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Select", "ID", "Lecturer1", "Lecturer2", "Subject Code", "Tag", "Subject", "Group", "No Of Student", "Duration(Hrs)", "Duration(Min)", "Day", "Start Time(Hrs)", "Start Time(Min)", "End Time(Hrs)", "End Time(Min)", "Session Name"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Boolean.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable4.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
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
        jScrollPane4.setViewportView(jTable4);

        jButtonConView.setBackground(new java.awt.Color(0, 153, 153));
        jButtonConView.setText("View");
        jButtonConView.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonConViewActionPerformed(evt);
            }
        });

        jButtonAdd.setBackground(new java.awt.Color(0, 153, 153));
        jButtonAdd.setText("Add");
        jButtonAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(294, 294, 294)
                        .addComponent(jButtonConView, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(jButtonAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 876, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 386, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButtonConView, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
                    .addComponent(jButtonAdd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(154, Short.MAX_VALUE))
        );

        jTabbedPane5.addTab("Consecative", jPanel6);

        jTable2.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Select", "ID", "Lecturer 1", "Lecturer 2", "Subject Code", "Tag", "Subject", "Group", "No Of Student", "Duration(Hrs)_", "Duration(Miin)", "Day", "Start Time(HRS)", "Start Time(Min)", "End Time(HRS)", "End Time(Min)", "Session Name"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Boolean.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
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
        jScrollPane2.setViewportView(jTable2);

        jButtonViewPar.setBackground(new java.awt.Color(0, 153, 153));
        jButtonViewPar.setText("View");
        jButtonViewPar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonViewParActionPerformed(evt);
            }
        });

        jButtonAddPar.setBackground(new java.awt.Color(0, 153, 153));
        jButtonAddPar.setText("Add");
        jButtonAddPar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddParActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(286, 286, 286)
                .addComponent(jButtonViewPar, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(jButtonAddPar, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(377, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 871, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 391, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(61, 61, 61)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButtonViewPar, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
                    .addComponent(jButtonAddPar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(137, Short.MAX_VALUE))
        );

        jTabbedPane5.addTab("Parallel", jPanel2);

        jTable1.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Select", "ID", "Lecturer1", "Lecturer2", "Subject Code", "Tag", "Subject", "Group", "No Of Student", "Duration(Hrs)", "Duration(Min)", "Day", "Start Time(Hrs)", "Start Time(Min)", "End Time(Hrs)", "End Time(Min)", "Session Name"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Boolean.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                true, false, false, false, false, false, false, false, false, false, false, true, true, true, true, true, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setGridColor(new java.awt.Color(51, 153, 255));
        jTable1.setRowHeight(50);
        jScrollPane1.setViewportView(jTable1);

        jButtonViewNon.setBackground(new java.awt.Color(0, 153, 153));
        jButtonViewNon.setText("View");
        jButtonViewNon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonViewNonActionPerformed(evt);
            }
        });

        jButtonAddNon.setBackground(new java.awt.Color(0, 153, 153));
        jButtonAddNon.setText("Add");
        jButtonAddNon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddNonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 905, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(277, 277, 277)
                .addComponent(jButtonViewNon, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(jButtonAddNon, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(84, 84, 84)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButtonViewNon, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
                    .addComponent(jButtonAddNon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 99, Short.MAX_VALUE))
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
        dashboard dash = new dashboard();
        dash.show();
        dispose();
    }//GEN-LAST:event_BackClickActionPerformed

    private void jTable4AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jTable4AncestorAdded
        // TODO add your handling code here:
        displaytable();


    }//GEN-LAST:event_jTable4AncestorAdded

    private void jTable2AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jTable2AncestorAdded
        // TODO add your handling code here:
        displaytable();
    }//GEN-LAST:event_jTable2AncestorAdded

   


    private void jButtonAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddActionPerformed
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) jTable4.getModel();

        for (int i = 0; i < model.getRowCount(); i++) {

            try {
                if (model.getValueAt(i, 0).equals(true)) {
                    try {
                        Connection cn = connection.DB_Connect.ConnecrDB();

                        String value = model.getValueAt(i, 1).toString();

                        String update = "INSERT INTO consecutive(se_id, lec1, lec2, tag, slec, sgroup, ssubject, scode, nostu, hrs, min, day, shrs, smin, ehrs, emin,sesname) SELECT se_id, lec1, lec2, tag, slec, sgroup, ssubject, scode, nostu, hrs, min, day, shrs, smin, ehrs, emin, sesname FROM session  where se_id=" + value;

                        PreparedStatement pst = cn.prepareStatement(update);

                        
                        pst.execute();

                        pst.close();
                        cn.close();

                    } catch (SQLException e) {
//call NOTNULL validation 
                        JOptionPane.showMessageDialog(this, e);
                    }

                }
            } catch (Exception e) {
            }

        }
        JOptionPane.showMessageDialog(this, "Added Sucsessfully");


    }//GEN-LAST:event_jButtonAddActionPerformed
View_Tables mq;
    private void jButtonViewNonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonViewNonActionPerformed
        // TODO add your handling code here:
            if (mq == null) {
            mq = new View_Tables();
        }
        
        mq.setVisible(true);
        this.dispose();
        
        
    }//GEN-LAST:event_jButtonViewNonActionPerformed

    private void jButtonAddNonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddNonActionPerformed
        // TODO add your handling code here:

                DefaultTableModel model = (DefaultTableModel) jTable1.getModel();

        for (int i = 0; i < model.getRowCount(); i++) {

            try {
                if (model.getValueAt(i, 0).equals(true)) {
                    try {
                        Connection cn = connection.DB_Connect.ConnecrDB();

                        String value = model.getValueAt(i, 1).toString();

                        String update = "INSERT INTO non_overlapping(se_id, lec1, lec2, tag, slec, sgroup, ssubject, scode, nostu, hrs, min, day, shrs, smin, ehrs, emin,sesname) SELECT se_id, lec1, lec2, tag, slec, sgroup, ssubject, scode, nostu, hrs, min, day, shrs, smin, ehrs, emin, sesname FROM session  where se_id=" + value;

                        PreparedStatement pst = cn.prepareStatement(update);

                        
                        pst.execute();

                        pst.close();
                        cn.close();

                    } catch (SQLException e) {
//call NOTNULL validation 
                        JOptionPane.showMessageDialog(this, e);
                    }

                }
            } catch (Exception e) {
            }

        }
        JOptionPane.showMessageDialog(this, "Added Sucsessfully");
    }//GEN-LAST:event_jButtonAddNonActionPerformed
View_Tables ml;
    private void jButtonConViewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonConViewActionPerformed
        // TODO add your handling code here:
        
        if (ml == null) {
            ml = new View_Tables();
        }
        
        ml.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButtonConViewActionPerformed
View_Tables m2;
    private void jButtonViewParActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonViewParActionPerformed
        // TODO add your handling code here:
        
           
        if (m2 == null) {
            m2 = new View_Tables();
        }
        
        m2.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButtonViewParActionPerformed

    private void jButtonAddParActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddParActionPerformed
        // TODO add your handling code here:
        
        
                DefaultTableModel model = (DefaultTableModel) jTable2.getModel();

        for (int i = 0; i < model.getRowCount(); i++) {

            try {
                if (model.getValueAt(i, 0).equals(true)) {
                    try {
                        Connection cn = connection.DB_Connect.ConnecrDB();

                        String value = model.getValueAt(i, 1).toString();

                        String update = "INSERT INTO parallel(se_id, lec1, lec2, tag, slec, sgroup, ssubject, scode, nostu, hrs, min, day, shrs, smin, ehrs, emin,sesname) SELECT se_id, lec1, lec2, tag, slec, sgroup, ssubject, scode, nostu, hrs, min, day, shrs, smin, ehrs, emin, sesname FROM session  where se_id=" + value;

                        PreparedStatement pst = cn.prepareStatement(update);

                        
                        pst.execute();

                        pst.close();
                        cn.close();

                    } catch (SQLException e) {
//call NOTNULL validation 
                        JOptionPane.showMessageDialog(this, e);
                    }

                }
            } catch (Exception e) {
            }

        }
        JOptionPane.showMessageDialog(this, "Added Sucsessfully");
     

        
        
        
        
        
        
    }//GEN-LAST:event_jButtonAddParActionPerformed

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
            java.util.logging.Logger.getLogger(Sessions_AvailableTime.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Sessions_AvailableTime.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Sessions_AvailableTime.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Sessions_AvailableTime.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Sessions_AvailableTime().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BackClick;
    private javax.swing.JButton jButtonAdd;
    private javax.swing.JButton jButtonAddNon;
    private javax.swing.JButton jButtonAddPar;
    private javax.swing.JButton jButtonConView;
    private javax.swing.JButton jButtonViewNon;
    private javax.swing.JButton jButtonViewPar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
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
