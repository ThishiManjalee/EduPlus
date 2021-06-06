/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pasindu;
import group_implmentation.dashboard;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import madu.Add_Lecturer;

/**
 *
 * @author pasindu
 */
public final class View_SessionRoom extends javax.swing.JFrame {

    /**
     * Creates new form Manage_Sessions
     */
    public View_SessionRoom() {
        initComponents();
          //Gride Add Jtable
       jtableColumnWidth();

        jTable1.setShowGrid(true);

        //implement the hide size function
        hidesize();

    }
//window hidden size setting
    void hidesize(){
  
      setSize(1400, 820);
      setLocationRelativeTo(null);
      setResizable(false); // maximize button disable
     
  
  }
//jtable column width setting
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
        jTable1.getColumnModel().getColumn(8).setPreferredWidth(250);
        jTable1.getColumnModel().getColumn(9).setPreferredWidth(250);
        jTable1.getColumnModel().getColumn(10).setPreferredWidth(530);
        jTable1.getColumnModel().getColumn(11).setPreferredWidth(250);

        
       
      }     
    



 //Display All Data in Jtable
   public void displaytable1(){
     
           try{
               try (Connection cn = connection.DB_Connect.ConnecrDB()) {
                   String select="SELECT * FROM session";
                   PreparedStatement pst=cn.prepareStatement(select);
                   
                   DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
                    model.setRowCount(0);
                    
              
                
                   
                   ResultSet rs =pst.executeQuery();
                   while(rs.next()){

                            //Data will be added until finish
                         

                       String se_id = String.valueOf(rs.getInt("se_id"));
                       String lec1=rs.getString("lec1");
                       String lec2=rs.getString("lec2");
                       String tag=rs.getString("tag");
                       String sgroup=rs.getString("sgroup");
                       String scode=rs.getString("scode");
                       String ssubject=rs.getString("ssubject");
                       String nostu=rs.getString("nostu");
                       String hrs=rs.getString("hrs");
                       String min=rs.getString("min");
                       String sesname=rs.getString("sesname");
                       String room=rs.getString("roomname");

//string array for store data into jtable
                       String tbData[]={se_id,lec1,lec2,scode,tag,ssubject,sgroup,nostu,hrs,min,sesname,room};
                       DefaultTableModel tblModel=(DefaultTableModel)jTable1.getModel();

                       tblModel.addRow(tbData);

                   }
            
                                                             

               }
                 }catch(SQLException e){
                
                
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
        jPanel2 = new javax.swing.JPanel();
        JPanelMain = new javax.swing.JPanel();
        sesionpanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButtonRefresh = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        DashboardClick = new javax.swing.JButton();
        AddSessionRoomclick = new javax.swing.JButton();
        BackClick = new javax.swing.JButton();
        ManageSessionRoomClick = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(1400, 820));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pasindu_img/logo.jpeg"))); // NOI18N

        JPanelMain.setRequestFocusEnabled(false);
        JPanelMain.setLayout(new java.awt.CardLayout());

        sesionpanel.setPreferredSize(new java.awt.Dimension(100, 568));
        sesionpanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sesionpanelMouseClicked(evt);
            }
        });

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        jTable1.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Lecturer 1", "Lecturer 2", "Subject Code", "Subject Name", "Group_ID", "Tag", "Num Of Student", "Hrs", "Min", "Session", "Room"
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
        jTable1.setRowHeight(60);
        jTable1.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                jTable1AncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jButtonRefresh.setBackground(new java.awt.Color(0, 153, 153));
        jButtonRefresh.setText("Refresh");
        jButtonRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRefreshActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout sesionpanelLayout = new javax.swing.GroupLayout(sesionpanel);
        sesionpanel.setLayout(sesionpanelLayout);
        sesionpanelLayout.setHorizontalGroup(
            sesionpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, sesionpanelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 811, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, sesionpanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(131, 131, 131))
        );
        sesionpanelLayout.setVerticalGroup(
            sesionpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sesionpanelLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 426, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 116, Short.MAX_VALUE)
                .addComponent(jButtonRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(71, 71, 71))
        );

        JPanelMain.add(sesionpanel, "card2");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(JPanelMain, javax.swing.GroupLayout.DEFAULT_SIZE, 811, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(JPanelMain, javax.swing.GroupLayout.DEFAULT_SIZE, 661, Short.MAX_VALUE))
        );

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 153, 153));
        jLabel2.setText("View Session Rooms");

        DashboardClick.setBackground(new java.awt.Color(0, 153, 153));
        DashboardClick.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        DashboardClick.setText("DashBoard");
        DashboardClick.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DashboardClickActionPerformed(evt);
            }
        });

        AddSessionRoomclick.setBackground(new java.awt.Color(0, 153, 153));
        AddSessionRoomclick.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        AddSessionRoomclick.setText("Add Session Room");
        AddSessionRoomclick.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddSessionRoomclickActionPerformed(evt);
            }
        });

        BackClick.setBackground(new java.awt.Color(0, 153, 153));
        BackClick.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        BackClick.setText("<<Back");
        BackClick.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackClickActionPerformed(evt);
            }
        });

        ManageSessionRoomClick.setBackground(new java.awt.Color(0, 153, 153));
        ManageSessionRoomClick.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        ManageSessionRoomClick.setText("View Session Room");
        ManageSessionRoomClick.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ManageSessionRoomClickActionPerformed(evt);
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
                        .addGap(120, 120, 120)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(ManageSessionRoomClick, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(DashboardClick, javax.swing.GroupLayout.DEFAULT_SIZE, 251, Short.MAX_VALUE)
                            .addComponent(AddSessionRoomclick, javax.swing.GroupLayout.DEFAULT_SIZE, 251, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(189, 189, 189)
                        .addComponent(BackClick, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, 0)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(DashboardClick, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(AddSessionRoomclick, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(ManageSessionRoomClick, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(BackClick, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 84, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel2)
                .addGap(25, 25, 25)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
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

    private void DashboardClickActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DashboardClickActionPerformed
        // TODO add your handling code here:
          
        group_implmentation.loging.dashb.setVisible(true);
        this.dispose();
                      
        
        
    }//GEN-LAST:event_DashboardClickActionPerformed
Add_SessionRoom al2;
    private void AddSessionRoomclickActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddSessionRoomclickActionPerformed
        // TODO add your handling code here:
       if (al2 == null) {
            al2 = new Add_SessionRoom();
        }
        
        al2.setVisible(true);
        this.dispose();
                        
    }//GEN-LAST:event_AddSessionRoomclickActionPerformed

    private void BackClickActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackClickActionPerformed
        // TODO add your handling code here:
        group_implmentation.loging.dashb.setVisible(true);
        this.dispose();
                      
                         
    }//GEN-LAST:event_BackClickActionPerformed
    
    private void sesionpanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sesionpanelMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_sesionpanelMouseClicked

    View_SessionRoom al3;
    private void ManageSessionRoomClickActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ManageSessionRoomClickActionPerformed
        // TODO add your handling code here:
        if (al3 == null) {
            al3 = new View_SessionRoom();
        }
        
        al3.setVisible(true);
        this.dispose();
                         
    }//GEN-LAST:event_ManageSessionRoomClickActionPerformed

    private void jTable1AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jTable1AncestorAdded
        // TODO add your handling code here:
        displaytable1();
    }//GEN-LAST:event_jTable1AncestorAdded

    private void jButtonRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRefreshActionPerformed
        // TODO add your handling code here:
                displaytable1();

    }//GEN-LAST:event_jButtonRefreshActionPerformed
  
    
    
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
            java.util.logging.Logger.getLogger(View_SessionRoom.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(View_SessionRoom.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(View_SessionRoom.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(View_SessionRoom.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new View_SessionRoom().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddSessionRoomclick;
    private javax.swing.JButton BackClick;
    private javax.swing.JButton DashboardClick;
    private javax.swing.JPanel JPanelMain;
    private javax.swing.JButton ManageSessionRoomClick;
    private javax.swing.JButton jButtonRefresh;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JPanel sesionpanel;
    // End of variables declaration//GEN-END:variables
}
