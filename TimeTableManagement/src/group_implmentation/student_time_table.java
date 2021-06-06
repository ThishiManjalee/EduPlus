/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package group_implmentation;

import actions.MultipleLine;
import actions.MyTableModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.MessageFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.TableModel;

/**
 *
 * @author pasindu
 */
public final class student_time_table extends javax.swing.JFrame {

    /**
     * Creates new form student_time_table
     */
    public student_time_table() {
        initComponents();
                Student_Timetable.setShowGrid(true);

        //hidesize window function implement
         hidesize(); 
         studentcombox();

//student Timetable column row size  changer
         jtableColumnWidth();
        
    }

    void hidesize(){
  
      setSize(1400, 820);
      setLocationRelativeTo(null);
      setResizable(false); // maximize button disable
      
  }
     void jtableColumnWidth(){
 
        Student_Timetable.setAutoResizeMode( JTable.AUTO_RESIZE_OFF );
        Student_Timetable.getColumnModel().getColumn(0).setPreferredWidth(250);
        Student_Timetable.getColumnModel().getColumn(1).setPreferredWidth(250);
        Student_Timetable.getColumnModel().getColumn(2).setPreferredWidth(250);
        Student_Timetable.getColumnModel().getColumn(3).setPreferredWidth(250);
        Student_Timetable.getColumnModel().getColumn(4).setPreferredWidth(250);
        Student_Timetable.getColumnModel().getColumn(5).setPreferredWidth(250);
        Student_Timetable.getColumnModel().getColumn(6).setPreferredWidth(250);
        Student_Timetable.getColumnModel().getColumn(7).setPreferredWidth(250);
 
 } 
   
    void studentcombox(){
      
          try {
                 Connection cn=connection.DB_Connect.ConnecrDB();
            
                 String sql ="select DISTINCT sgroup from session";
                 Statement pst=cn.createStatement();
                 ResultSet rs=pst.executeQuery(sql);
                 while(rs.next()){
                 
                     String name=rs.getString("sgroup");
                     jComboBoxGroup.addItem(name);
                 
                 }
                 //Connection Close
                 pst.close();
                 rs.close();
                 cn.close();
       
        
        } catch (SQLException ex) {
            Logger.getLogger(student_time_table.class.getName()).log(Level.SEVERE, null, ex);
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
        Student_Timetable = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jComboBoxGroup = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jButtonPrint = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        DashboardClick = new javax.swing.JButton();
        LecturerTimetableClick = new javax.swing.JButton();
        StudentTimetableClick = new javax.swing.JButton();
        LocationTimetableClick = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(java.awt.Color.white);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pasindu_img/logo.jpeg"))); // NOI18N

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        Student_Timetable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Time Slot", "Monday", "Tuesday", "Wensday", "Thursday", "Friday", "Saturday", "Sunday"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Student_Timetable.setGridColor(new java.awt.Color(51, 153, 255));
        Student_Timetable.setRowHeight(60);
        jScrollPane1.setViewportView(Student_Timetable);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setText("Group");

        jButton1.setBackground(new java.awt.Color(0, 153, 153));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setText("Genarate");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButtonPrint.setBackground(new java.awt.Color(0, 153, 153));
        jButtonPrint.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButtonPrint.setText("Print");
        jButtonPrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPrintActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(74, 74, 74)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBoxGroup, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonPrint, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(100, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jComboBoxGroup)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                    .addComponent(jButtonPrint, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(34, 34, 34)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 562, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel2.setBackground(new java.awt.Color(204, 255, 0));
        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 255, 0));
        jLabel2.setText("Student Timetable");

        DashboardClick.setBackground(new java.awt.Color(0, 153, 153));
        DashboardClick.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        DashboardClick.setText("Dashboard");
        DashboardClick.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DashboardClickActionPerformed(evt);
            }
        });

        LecturerTimetableClick.setBackground(new java.awt.Color(0, 153, 153));
        LecturerTimetableClick.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        LecturerTimetableClick.setText("Lecturer Timetable");
        LecturerTimetableClick.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LecturerTimetableClickActionPerformed(evt);
            }
        });

        StudentTimetableClick.setBackground(new java.awt.Color(0, 153, 153));
        StudentTimetableClick.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        StudentTimetableClick.setText("Student Timetable");
        StudentTimetableClick.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StudentTimetableClickActionPerformed(evt);
            }
        });

        LocationTimetableClick.setBackground(new java.awt.Color(0, 153, 153));
        LocationTimetableClick.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        LocationTimetableClick.setText("Location Timetable");
        LocationTimetableClick.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LocationTimetableClickActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 484, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(105, 105, 105)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(LocationTimetableClick, javax.swing.GroupLayout.DEFAULT_SIZE, 233, Short.MAX_VALUE)
                            .addComponent(StudentTimetableClick, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(LecturerTimetableClick, javax.swing.GroupLayout.DEFAULT_SIZE, 233, Short.MAX_VALUE)
                            .addComponent(DashboardClick, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 433, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 47, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 439, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(DashboardClick, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(LecturerTimetableClick, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(StudentTimetableClick, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(LocationTimetableClick, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(46, Short.MAX_VALUE))
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

    private void DashboardClickActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DashboardClickActionPerformed
        // TODO add your handling code here:
            
        group_implmentation.loging.dashb.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_DashboardClickActionPerformed
lecturer_time_table st2;
    private void LecturerTimetableClickActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LecturerTimetableClickActionPerformed
        // TODO add your handling code here:
         try {
            if (st2 == null) {
                st2 = new lecturer_time_table();
            }

            st2.setVisible(true);
            this.dispose();
        } catch (Exception e) {
            e.printStackTrace();
        }

        
    }//GEN-LAST:event_LecturerTimetableClickActionPerformed
student_time_table st3;
    private void StudentTimetableClickActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_StudentTimetableClickActionPerformed
        // TODO add your handling code here:
          try {
            if (st3 == null) {
                st3 = new student_time_table();
            }

            st3.setVisible(true);
            this.dispose();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }//GEN-LAST:event_StudentTimetableClickActionPerformed
location_time_table st4;
    private void LocationTimetableClickActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LocationTimetableClickActionPerformed
        // TODO add your handling code here:
          try {
            if (st4 == null) {
                st4 = new location_time_table();
            }

            st4.setVisible(true);
            this.dispose();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }//GEN-LAST:event_LocationTimetableClickActionPerformed

    private void jButtonPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPrintActionPerformed
        
        MessageFormat header =new MessageFormat("Report Print");
        MessageFormat footer =new MessageFormat("Page{0,number,integer}");
        
        
       try{
       
        Student_Timetable.print(JTable.PrintMode.NORMAL,header,footer);
       
       }
       catch(java.awt.print.PrinterException e){
       
       System.err.format("cannot print %s%n", e.getMessage());
       
       
       }
        
        
        
    }//GEN-LAST:event_jButtonPrintActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
            
          TableModel df =  Student_Timetable.getModel();

        for (int i = 0; i < df.getRowCount(); i++) {

            for (int j = 1; j < df.getColumnCount(); j++) {

                df.setValueAt("", i, j);

            }

        }
        df.setValueAt("08:30-09:30", 0, 0);
        df.setValueAt("09:30-10:30", 1, 0);
        df.setValueAt("10:30-11:30", 2, 0);
        df.setValueAt("11:30-12:30", 3, 0);
        df.setValueAt("12:30-13:30", 4, 0);
        df.setValueAt("13:30-14:30", 5, 0);
        df.setValueAt("14:30-15:30", 6, 0);
        df.setValueAt("15:30-16:30", 7, 0);
        df.setValueAt("16:30-17:30", 8, 0);
        df.setValueAt("17:30-18:30", 9, 0);
        df.setValueAt("19:30-20:30", 10, 0);


        Connection cn = connection.DB_Connect.ConnecrDB();

        String td[][];
        Object col[] = {"Time Slots", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};

        td = new String[11][11];
        for (int i = 0; i < df.getRowCount(); i++) {
            td[i][0] = df.getValueAt(i, 0).toString();
        }

        try {
            String sql = "select * from session where  sgroup=?";
            PreparedStatement pst = cn.prepareStatement(sql);

            String ch = jComboBoxGroup.getSelectedItem().toString();

            pst.setString(1, ch);

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
                String day = rs.getString("day");
                String shrs = rs.getString("shrs");
                String smin = rs.getString("smin");
                String ehrs = rs.getString("ehrs");
                String emin = rs.getString("emin");
 String room = rs.getString("roomname");

                String session = String.join("-", lec1, lec2, scode, tag, sgroup, nostu, se_id,room);

                int Hrs = Integer.parseInt(shrs);
                int EHrs = Integer.parseInt(ehrs);  // ----------------------------- kaapiya maawa
                int db_start = (Hrs * 60) + Integer.parseInt(smin);
                int db_end = (EHrs * 60) + Integer.parseInt(emin);

                for (int i = 0; i < df.getRowCount(); i++) {

                    String Start_Time = df.getValueAt(i, 0).toString().split("-")[0];
                    String End_Time = df.getValueAt(i, 0).toString().split("-")[1];

                    int Start_Value = (Integer.parseInt(Start_Time.split(":")[0]) * 60) + Integer.parseInt(Start_Time.split(":")[1]);
                    int End_Value = (Integer.parseInt(End_Time.split(":")[0]) * 60) + Integer.parseInt(End_Time.split(":")[1]);

                    if ((Start_Value <= db_start && End_Value > db_start) || (End_Value <= db_end && End_Value > db_start)) {

                        for (int j = 1; j < df.getColumnCount(); j++) {

                            if (day.equals(df.getColumnName(j))) {

//                                df.setValueAt(session, i, j);
                                td[i][j] = session.replaceAll("-", " - ");
                                //
//                                break;
                            } else {

                                td[i][j] = " ";
                            }

                        }
                    }

                }

            }
            
            
           Student_Timetable.setModel(new MyTableModel(td, col));
           Student_Timetable.setDefaultRenderer(Object.class, new MultipleLine());
           Student_Timetable.setShowHorizontalLines(true);
           Student_Timetable.setShowVerticalLines(true);
           Student_Timetable.setAutoResizeMode(1);
           Student_Timetable.setRowHeight(90);
                      JOptionPane.showMessageDialog(null, "Generate Success"); 
//           lecturer_timetable.setc
        } catch (SQLException e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(this, e);

        }
        
        
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(student_time_table.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(student_time_table.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(student_time_table.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(student_time_table.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new student_time_table().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton DashboardClick;
    private javax.swing.JButton LecturerTimetableClick;
    private javax.swing.JButton LocationTimetableClick;
    private javax.swing.JButton StudentTimetableClick;
    private javax.swing.JTable Student_Timetable;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButtonPrint;
    private javax.swing.JComboBox<String> jComboBoxGroup;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
