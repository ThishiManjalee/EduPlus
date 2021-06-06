/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package madu;
import actions.Session_Delete;
import actions.Session_Update;
import group_implmentation.dashboard;
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
import javax.swing.SpinnerNumberModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author Madu
 */
public final class Manage_Session extends javax.swing.JFrame {

    Session_Update su =new Session_Update();
    Session_Delete sd=new Session_Delete();
    /**
     * Creates new form Manage_Session
     */
    public Manage_Session() {
        initComponents();
        //implement the hide size
        hidesize();
         lecturer1combox();
        lecturer2combox();
        tagcombox();
        subjectcodecombox();
        subjectcombox();
         jTable1.setShowGrid(true);
          spinnerMinusMaxStop();
        jtableColumnWidth();
       
    }
  void LoadDataUpdate(){
  try{
      int row =jTable1.getSelectedRow(); 
      String value =(jTable1.getModel().getValueAt(row, 0).toString());
      su.value=Integer.parseInt(value);
  
  }catch(NumberFormatException ex){
  
      JOptionPane.showMessageDialog(null, "Load in Form"+ex.getMessage());
  
  }
 }   
  
  void LoadDataDelete(){
  try{
      int row =jTable1.getSelectedRow(); 
      String value =(jTable1.getModel().getValueAt(row, 0).toString());
      sd.value=Integer.parseInt(value);
  
  }catch(NumberFormatException ex){
  
      JOptionPane.showMessageDialog(null, "Load in Form"+ex.getMessage());
  
  }
 }   
 void hidesize(){
  
      setSize(1400, 820);
      setLocationRelativeTo(null);
      setResizable(false); // maximize button disable
      setVisible(true);
  
  }
  //for spnner limit  
  void spinnerMinusMaxStop(){
          ((SpinnerNumberModel) shrs.getModel()).setMinimum(0);
          ((SpinnerNumberModel) smin.getModel()).setMinimum(0);
          ((SpinnerNumberModel) ehrs.getModel()).setMinimum(0);
          ((SpinnerNumberModel) emin.getModel()).setMinimum(0);
          ((SpinnerNumberModel) jSpinnerhrs.getModel()).setMinimum(0);
          ((SpinnerNumberModel) jSpinnermin.getModel()).setMinimum(0);
          ((SpinnerNumberModel) jSpinnerStudents.getModel()).setMinimum(0);

           ((SpinnerNumberModel) shrs.getModel()).setMaximum(23);
          ((SpinnerNumberModel) smin.getModel()).setMaximum(59);
          ((SpinnerNumberModel) ehrs.getModel()).setMaximum(23);
          ((SpinnerNumberModel) emin.getModel()).setMaximum(59);
          ((SpinnerNumberModel) jSpinnerhrs.getModel()).setMaximum(23);
          ((SpinnerNumberModel) jSpinnermin.getModel()).setMaximum(59);
 
  }
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
        jTable1.getColumnModel().getColumn(10).setPreferredWidth(250);
        jTable1.getColumnModel().getColumn(11).setPreferredWidth(250);
        jTable1.getColumnModel().getColumn(12).setPreferredWidth(250);
        jTable1.getColumnModel().getColumn(13).setPreferredWidth(250);
        jTable1.getColumnModel().getColumn(14).setPreferredWidth(250);
        jTable1.getColumnModel().getColumn(15).setPreferredWidth(250);
        jTable1.getColumnModel().getColumn(16).setPreferredWidth(250);
        jTable1.getColumnModel().getColumn(17).setPreferredWidth(450);

 
 }
   //Retive All the Lecturer1 Data to Combobox
     void lecturer1combox(){
      // TODO add your handling code here:
          try {
                 Connection cn=connection.DB_Connect.ConnecrDB();
            
                 String sql ="select DISTINCT name from lecturer";
                 Statement pst=cn.createStatement();
                 ResultSet rs=pst.executeQuery(sql);
                 while(rs.next()){
                 
                     String name=rs.getString("name");
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
     void lecturer2combox(){
      // TODO add your handling code here:
          try {
                 Connection cn=connection.DB_Connect.ConnecrDB();
            
                 String sql ="select DISTINCT name from lecturer";
                 Statement pst=cn.createStatement();
                 ResultSet rs=pst.executeQuery(sql);
                 while(rs.next()){
                 
                     String name=rs.getString("name");
                     jComboBoxlec2.addItem(name);
                 
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
     void tagcombox(){
      // TODO add your handling code here:
          try {
                 Connection cn=connection.DB_Connect.ConnecrDB();
            
                 String sql ="select DISTINCT related_tag from tag"; 
                 Statement pst=cn.createStatement();
                 ResultSet rs=pst.executeQuery(sql);
                 while(rs.next()){
                 
                     String subject=rs.getString("related_tag");
                     jComboBoxtag.addItem(subject);
                 
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
     void subjectcombox(){
      // TODO add your handling code here:
          try {
                 Connection cn=connection.DB_Connect.ConnecrDB();
            
                 String sql ="select DISTINCT sub_name from subjects"; 
                 Statement pst=cn.createStatement();
                 ResultSet rs=pst.executeQuery(sql);
                 while(rs.next()){
                 
                     String subject=rs.getString("sub_name");
                     jComboBoxsubject.addItem(subject);
                 
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
     void subjectcodecombox(){
      // TODO add your handling code here:
          try {
                 Connection cn=connection.DB_Connect.ConnecrDB();
            
                 String sql ="select DISTINCT sub_code from subjects"; 
                 Statement pst=cn.createStatement();
                 ResultSet rs=pst.executeQuery(sql);
                 while(rs.next()){
                 
                     String code=rs.getString("sub_code");
                     jComboBoxsubjectcode.addItem(code);
                 
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
   
   void select(){

     
   String ch=jComboBoxtag.getSelectedItem().toString();
 
   if("Lecture".equals(ch)||"Tutorial".equals(ch)){
   // TODO add your handling code here:
          try {
              try (Connection cn = connection.DB_Connect.ConnecrDB()) {
                  String sql ="select DISTINCT group_id from student_group";
                  Statement pst=cn.createStatement();
                  
                  
                  ResultSet rs=pst.executeQuery(sql);
                   jComboBoxGroup.removeAllItems();
                   jComboBoxGroup.setSelectedItem(null);
                  while(rs.next()){

                      String group=rs.getString("group_id");
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
        
   
   }else if("Lab".equals(ch)){

     try {
         

              try (Connection cn = connection.DB_Connect.ConnecrDB()) {
                  String sql ="select DISTINCT sub_group_id from student_group";
                   Statement pst=cn.createStatement();
                  
                  
                  ResultSet rs=pst.executeQuery(sql);
                      rs = pst.executeQuery(sql);
                    jComboBoxGroup.removeAllItems();
                    jComboBoxGroup.setSelectedItem(null);

                      while (rs.next()) {
                          String group1=rs.getString("sub_group_id");
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
       
     
  //Display All Data in Jtable
   public void displaytable(){
     
           try{
               try (Connection cn = connection.DB_Connect.ConnecrDB()) {
                   String select="select * from session";
                   PreparedStatement pst=cn.prepareStatement(select);
                   
                   
                   
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
                       String day=rs.getString("day");
                       String shrs=rs.getString("shrs");
                       String smin=rs.getString("smin");
                       String ehrs=rs.getString("ehrs");
                       String emin=rs.getString("emin");
                       String sesname=rs.getString("sesname");
                     //  String session =String.join("_",sgroup,scode,tag);

                               
                       //string array for store data into jtable
                       String tbData[]={se_id,lec1,lec2,scode,tag,ssubject,sgroup,nostu,hrs,min,day,shrs,smin,ehrs,emin,sesname};
                       DefaultTableModel tblModel=(DefaultTableModel)jTable1.getModel();
                       
                       tblModel.addRow(tbData);
                   }
               
                   
               }
                 }catch(SQLException e){
                
                
                    JOptionPane.showMessageDialog(this, e);
                
                }
         
    }
       void genertaeLecturers(){
     // TODO add your handling code here:
   
     
       String lec1=jComboBoxLecturer1.getSelectedItem().toString();
       String lec2=jComboBoxlec2.getSelectedItem().toString();

       String lecturers = String.join(",",lec1,lec2 );

        jTextFieldSelectedLecturers.setText(lecturers);
     
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel13 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButtonUpdate = new javax.swing.JButton();
        jButtonDelete = new javax.swing.JButton();
        jButtonClear = new javax.swing.JButton();
        jButtonRefresh = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jComboBoxLecturer1 = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jComboBoxsubject = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jComboBoxGroup = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jComboBoxtag = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jSpinnerhrs = new javax.swing.JSpinner();
        jLabel8 = new javax.swing.JLabel();
        jComboBoxlec2 = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        jComboBoxsubjectcode = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        jSpinnerStudents = new javax.swing.JSpinner();
        search = new javax.swing.JTextField();
        jcomboxsession = new javax.swing.JComboBox<>();
        jButtonSearch = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jSpinnermin = new javax.swing.JSpinner();
        jLabel14 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jTextFieldSelectedLecturers = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        day = new javax.swing.JComboBox<>();
        shrs = new javax.swing.JSpinner();
        jLabel18 = new javax.swing.JLabel();
        smin = new javax.swing.JSpinner();
        jLabel19 = new javax.swing.JLabel();
        ehrs = new javax.swing.JSpinner();
        jLabel20 = new javax.swing.JLabel();
        emin = new javax.swing.JSpinner();
        jLabel21 = new javax.swing.JLabel();
        jTextFieldg = new javax.swing.JTextField();
        jButtonGen = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        dashboardclick = new javax.swing.JButton();
        addsessionclick = new javax.swing.JButton();
        managesessionclick = new javax.swing.JButton();
        backclick = new javax.swing.JButton();

        jLabel13.setText("jLabel13");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(1400, 820));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pasindu_img/logo.jpeg"))); // NOI18N

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));

        jTable1.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Lecturer 1", "Lecturer 2", "Subject Code", "Tag", "Subject", "Group", "NO Of Student", "Duration(Hrs)", "Duration(Min)", "Day", "StartTime(Hrs)", "StartTime(Min)", "EndTime(Hrs)", "EndTime(Min)", "Session Name"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false
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

        jButtonUpdate.setBackground(new java.awt.Color(0, 153, 153));
        jButtonUpdate.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButtonUpdate.setText("Update");
        jButtonUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonUpdateActionPerformed(evt);
            }
        });

        jButtonDelete.setBackground(new java.awt.Color(0, 153, 153));
        jButtonDelete.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButtonDelete.setText("Delete");
        jButtonDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDeleteActionPerformed(evt);
            }
        });

        jButtonClear.setBackground(new java.awt.Color(0, 153, 153));
        jButtonClear.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButtonClear.setText("Clear");
        jButtonClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonClearActionPerformed(evt);
            }
        });

        jButtonRefresh.setBackground(new java.awt.Color(0, 153, 153));
        jButtonRefresh.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButtonRefresh.setText("Refresh");
        jButtonRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRefreshActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Select Lecturer 1");

        jComboBoxLecturer1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));
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

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Select Subject");

        jComboBoxsubject.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));
        jComboBoxsubject.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxsubjectItemStateChanged(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Select Student Group");

        jComboBoxGroup.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxGroupItemStateChanged(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Select Tag");

        jComboBoxtag.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));
        jComboBoxtag.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxtagItemStateChanged(evt);
            }
        });
        jComboBoxtag.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxtagActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("Duration");

        jSpinnerhrs.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSpinnerhrsStateChanged(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("Select Lecturer 2");

        jComboBoxlec2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));
        jComboBoxlec2.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxlec2ItemStateChanged(evt);
            }
        });
        jComboBoxlec2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxlec2ActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setText("Select Subject Code");

        jComboBoxsubjectcode.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));
        jComboBoxsubjectcode.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxsubjectcodeItemStateChanged(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setText("No Of Students");

        jSpinnerStudents.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSpinnerStudentsStateChanged(evt);
            }
        });

        search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchActionPerformed(evt);
            }
        });

        jcomboxsession.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Session", " " }));

        jButtonSearch.setBackground(new java.awt.Color(0, 153, 153));
        jButtonSearch.setText("Search");
        jButtonSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSearchActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel12.setText("Hrs");

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel14.setText("Min");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setText("Selected Lecturers");

        jTextFieldSelectedLecturers.setEditable(false);
        jTextFieldSelectedLecturers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldSelectedLecturersActionPerformed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel15.setText("Start Time");

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel16.setText("End Time");

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel17.setText("Day");

        day.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday" }));
        day.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dayActionPerformed(evt);
            }
        });

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel18.setText("Hrs");

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel19.setText("Min");

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel20.setText("Hrs");

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel21.setText("Min");

        jTextFieldg.setEditable(false);

        jButtonGen.setBackground(new java.awt.Color(0, 153, 153));
        jButtonGen.setText("Generate");
        jButtonGen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGenActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 736, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jButtonUpdate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonDelete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButtonClear, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(search, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jcomboxsession, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addGap(12, 12, 12)
                                        .addComponent(jComboBoxGroup, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(29, 29, 29))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addGap(44, 44, 44)
                                        .addComponent(jComboBoxLecturer1, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE)))
                                .addGap(171, 171, 171)
                                .addComponent(jComboBoxtag, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addGap(62, 62, 62)
                                        .addComponent(jComboBoxsubject, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel7)
                                            .addComponent(jLabel15))
                                        .addGap(33, 33, 33)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(ehrs)
                                            .addComponent(shrs)
                                            .addComponent(jSpinnerhrs, javax.swing.GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(jLabel12)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jSpinnermin)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel14))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                                        .addComponent(jLabel20)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(emin))
                                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                                        .addComponent(jLabel18)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(smin)))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel19)
                                                    .addComponent(jLabel21))))
                                        .addGap(24, 24, 24)))
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel8)
                                            .addComponent(jLabel9)
                                            .addComponent(jLabel6)
                                            .addComponent(jLabel11)
                                            .addComponent(jLabel17))
                                        .addGap(41, 41, 41)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jComboBoxlec2, 0, 226, Short.MAX_VALUE)
                                            .addComponent(jComboBoxsubjectcode, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jSpinnerStudents, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(day, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                    .addComponent(jTextFieldg)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel16)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel10)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jTextFieldSelectedLecturers, javax.swing.GroupLayout.PREFERRED_SIZE, 652, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonGen)
                        .addContainerGap())))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(search, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                        .addComponent(jcomboxsession))
                    .addComponent(jButtonSearch, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonClear, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(49, 49, 49)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jComboBoxsubject, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9)
                            .addComponent(jComboBoxsubjectcode, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 24, 24)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jComboBoxGroup, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBoxtag, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jComboBoxlec2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel8)
                        .addComponent(jComboBoxLecturer1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(jSpinnerhrs, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12)
                            .addComponent(jSpinnermin, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jSpinnerStudents, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11))))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel18, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(smin, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel19))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(shrs, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel17)
                            .addComponent(day, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(1, 1, 1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel16)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(ehrs, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel20))))
                    .addComponent(emin, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jTextFieldg)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButtonGen, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel21))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jTextFieldSelectedLecturers, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15))
        );

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 153, 153));
        jLabel2.setText("Manage Session");

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
        addsessionclick.setText("Add  Session");
        addsessionclick.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addsessionclickActionPerformed(evt);
            }
        });

        managesessionclick.setBackground(new java.awt.Color(0, 153, 153));
        managesessionclick.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        managesessionclick.setText("Manage Session");

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
                        .addGap(97, 97, 97)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(managesessionclick, javax.swing.GroupLayout.DEFAULT_SIZE, 234, Short.MAX_VALUE)
                            .addComponent(addsessionclick, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(dashboardclick, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(149, 149, 149)
                        .addComponent(backclick)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(jLabel2)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(131, 131, 131))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(36, 36, 36)
                        .addComponent(dashboardclick, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(addsessionclick, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(managesessionclick, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(backclick, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(42, 42, 42))
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
Add_Session as;
    private void addsessionclickActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addsessionclickActionPerformed
        // TODO add your handling code here:
                 if (as == null) {
            as = new Add_Session();
        }
        
        as.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_addsessionclickActionPerformed

    private void backclickActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backclickActionPerformed
        // TODO add your handling code here:
           
        group_implmentation.loging.dashb.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_backclickActionPerformed

    private void searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchActionPerformed

    private void jButtonUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonUpdateActionPerformed
        // TODO add your handling code here:
        
        LoadDataUpdate();
        
        
       String Lec1=jComboBoxLecturer1.getSelectedItem().toString();
       String Lec2=jComboBoxlec2.getSelectedItem().toString();
       String Tag=jComboBoxtag.getSelectedItem().toString();
       String Slec =jTextFieldSelectedLecturers.getText();
       String Sgroup=  jComboBoxGroup.getSelectedItem().toString(); 
       String Ssubject=jComboBoxsubject.getSelectedItem().toString();
       String Scode=jComboBoxsubjectcode.getSelectedItem().toString();
       String Nostu=jSpinnerStudents.getValue().toString();
       String Hrs=jSpinnerhrs.getValue().toString();
       String Min=jSpinnermin.getValue().toString();
       String Day=day.getSelectedItem().toString();
       String sHrs=shrs.getValue().toString();
       String sMin=smin.getValue().toString();
       String EHrs=ehrs.getValue().toString();
       String EMin=emin.getValue().toString() ;              
       String Session=jTextFieldg.getText();
                
      
                 
                   //Call Validtion
    if(jComboBoxLecturer1.getSelectedIndex() == 0||jComboBoxlec2.getSelectedIndex()==0||jComboBoxtag.getSelectedIndex()==0||jComboBoxsubject.getSelectedIndex()==0||jComboBoxsubjectcode.getSelectedIndex()==0||jTextFieldg.getText().trim().isEmpty()){
                   
        
                    JOptionPane.showMessageDialog(this, "Empty Feild Recheck");
                
        
        
        
                   }else{ 
                
                su.UpdateSession(Lec1, Lec2, Tag, Slec, Sgroup, Ssubject, Scode, Nostu, Hrs, Min,Day,sHrs,sMin,EHrs,EMin,Session);
                         
            
       
    
                
        
                        updateRe_table();
        
    }
        
        
    }//GEN-LAST:event_jButtonUpdateActionPerformed

    private void jTable1AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jTable1AncestorAdded
        // TODO add your handling code here:
        displaytable();
    }//GEN-LAST:event_jTable1AncestorAdded

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
                    int i=jTable1.getSelectedRow();
           
            TableModel model=jTable1.getModel();
              
            jComboBoxLecturer1.setSelectedItem(model.getValueAt(i, 1).toString());
            jComboBoxlec2.setSelectedItem(model.getValueAt(i, 2).toString());
            jComboBoxsubjectcode.setSelectedItem(model.getValueAt(i, 3).toString());
            jComboBoxtag.setSelectedItem(model.getValueAt(i, 4).toString()); 
            jComboBoxsubject.setSelectedItem(model.getValueAt(i, 5).toString());
            jComboBoxGroup.setSelectedItem(model.getValueAt(i, 8).toString());
            jSpinnerStudents.setValue(Integer.parseInt((String)model.getValueAt(i,7)));
            jSpinnerhrs.setValue(Integer.parseInt((String)model.getValueAt(i,8)));
            jSpinnermin.setValue(Integer.parseInt((String)model.getValueAt(i,9)));
            day.setSelectedItem(model.getValueAt(i, 10).toString());
            shrs.setValue(Integer.parseInt((String)model.getValueAt(i, 11)));
            smin.setValue(Integer.parseInt((String)model.getValueAt(i, 12)));
            ehrs.setValue(Integer.parseInt((String)model.getValueAt(i, 13)));
            emin.setValue(Integer.parseInt((String)model.getValueAt(i, 14)));
            jTextFieldg.setText(model.getValueAt(i, 15).toString());

            
            
                               //   String tbData[]={se_id,session,lec1,lec2,scode,tag,ssubject,sgroup,nostu,time};

            
        
    }//GEN-LAST:event_jTable1MouseClicked

    //This methode use for Auto Refresh Data
private void updateRe_table(){
      

       Connection cn=connection.DB_Connect.ConnecrDB();
       String sql="select *from session";

try{
           


    PreparedStatement pst = cn.prepareStatement(sql);
           ResultSet rs = pst.executeQuery();
           jTable1.setModel(DbUtils.resultSetToTableModel(rs));
           jtableColumnWidth();

           cn.close();
           rs.close();
}catch(SQLException e){
      JOptionPane.showMessageDialog(null, e);
}
    
    }
    
      
    
    
    
    private void jComboBoxtagActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxtagActionPerformed
        // TODO add your handling code here:
        select();
    }//GEN-LAST:event_jComboBoxtagActionPerformed

    private void jButtonClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonClearActionPerformed
        // TODO add your handling code here:
         // TODO add your handling code here:
                     jComboBoxLecturer1.setSelectedIndex(0);
                     jComboBoxlec2.setSelectedIndex(0);
                     jComboBoxtag.setSelectedIndex(0);
                     jComboBoxGroup.setSelectedIndex(0);
                     jComboBoxsubject.setSelectedIndex(0);
                     jComboBoxsubjectcode.setSelectedIndex(0);
                     jSpinnerStudents.setValue(0);
                     jSpinnerhrs.setValue(0);
                     jSpinnermin.setValue(0);
                     jComboBoxGroup.removeAllItems();
                     shrs.setValue(0);
                     smin.setValue(0);
                     ehrs.setValue(0);
                     emin.setValue(0);
                     day.setSelectedIndex(0);

    }//GEN-LAST:event_jButtonClearActionPerformed

    private void jComboBoxLecturer1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxLecturer1ActionPerformed
        // TODO add your handling code here:
        genertaeLecturers();
    }//GEN-LAST:event_jComboBoxLecturer1ActionPerformed

    private void jComboBoxlec2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxlec2ActionPerformed
        // TODO add your handling code here:
        genertaeLecturers();
    }//GEN-LAST:event_jComboBoxlec2ActionPerformed

    private void jButtonDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDeleteActionPerformed
        // TODO add your handling code here:
        LoadDataDelete();

        DefaultTableModel tableModel = (DefaultTableModel) jTable1.getModel();
        tableModel.setRowCount(0);
        sd.SessionDelete();

          displaytable();
        
    }//GEN-LAST:event_jButtonDeleteActionPerformed

    private void jButtonSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSearchActionPerformed
        // TODO add your handling code here:
               Connection cn=connection.DB_Connect.ConnecrDB();


        try{
            String sql= "select * from session where (lec1 = ? OR tag = ? OR lec2 = ? OR scode = ? OR sgroup = ? OR ssubject = ?) ";
            PreparedStatement pst = cn.prepareStatement(sql);
           
           pst.setString(1,search.getText());
           pst.setString(2,search.getText());           
           pst.setString(3,search.getText());
           pst.setString(4,search.getText());
           pst.setString(5,search.getText());
           pst.setString(6,search.getText());


  
             ResultSet rs = pst.executeQuery();
             jcomboxsession.removeAllItems();
             jcomboxsession.setSelectedItem(null); 
         
      while(rs.next()){
           String lec1=rs.getString("lec1");
           String lec2=rs.getString("lec2");
           String scode=rs.getString("scode");
           String tag=rs.getString("tag");
           String sgroup=rs.getString("sgroup");
           String nostu=rs.getString("nostu");
           String dura=rs.getString("hrs");
       
           
       String session = String.join("-",lec1,lec2,scode,tag,sgroup,nostu,dura );
                     
                       jcomboxsession.addItem(session);

       
          }         

        }catch(Exception e){
              JOptionPane.showMessageDialog(null, e);

        }
        
    }//GEN-LAST:event_jButtonSearchActionPerformed

    private void jButtonRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRefreshActionPerformed
        // TODO add your handling code here:
                             jcomboxsession.removeAllItems();
                             search.setText("");

    }//GEN-LAST:event_jButtonRefreshActionPerformed

    private void jTextFieldSelectedLecturersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldSelectedLecturersActionPerformed
        // TODO add your handling code here:
        jTextFieldg.setText("");
    }//GEN-LAST:event_jTextFieldSelectedLecturersActionPerformed

    private void dayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dayActionPerformed
        // TODO add your handling code here:
                jTextFieldg.setText("");

    }//GEN-LAST:event_dayActionPerformed

    private void jButtonGenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGenActionPerformed
        // TODO add your handling code here:
        
           
         String lec1=jComboBoxLecturer1.getSelectedItem().toString();
        String lec2=jComboBoxlec2.getSelectedItem().toString();
        String scode=jComboBoxsubjectcode.getSelectedItem().toString();
        String tag=jComboBoxtag.getSelectedItem().toString();
        String sgroup=jComboBoxGroup.getSelectedItem().toString();
        String nostu=jSpinnerStudents.getValue().toString();
        String duration=jSpinnerhrs.getValue().toString();
        
       
  if(lec1.isEmpty()||lec1.length()==0){
      
       String session1 = String.join("-",lec2,scode,tag,sgroup,nostu,duration );
                     
                       jTextFieldg.setText(session1);

      
      }else if(lec2.isEmpty()||lec2.length()==0){
      
       String session2 = String.join("-",lec1,scode,tag,sgroup,nostu,duration );
                     
                       jTextFieldg.setText(session2);

      
      }else{
      
               String session3 = String.join("-",lec1,lec2,scode,tag,sgroup,nostu,duration );
                     
                       jTextFieldg.setText(session3);
      
      
      }
        
        
        
        
    }//GEN-LAST:event_jButtonGenActionPerformed

    private void jComboBoxLecturer1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxLecturer1ItemStateChanged
        // TODO add your handling code here:
                jTextFieldg.setText("");

    }//GEN-LAST:event_jComboBoxLecturer1ItemStateChanged

    private void jComboBoxsubjectItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxsubjectItemStateChanged
        // TODO add your handling code here:
                jTextFieldg.setText("");

    }//GEN-LAST:event_jComboBoxsubjectItemStateChanged

    private void jComboBoxGroupItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxGroupItemStateChanged
        // TODO add your handling code here:
                jTextFieldg.setText("");

    }//GEN-LAST:event_jComboBoxGroupItemStateChanged

    private void jSpinnerhrsStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSpinnerhrsStateChanged
        // TODO add your handling code here:
                jTextFieldg.setText("");

    }//GEN-LAST:event_jSpinnerhrsStateChanged

    private void jComboBoxlec2ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxlec2ItemStateChanged
        // TODO add your handling code here:
                jTextFieldg.setText("");

    }//GEN-LAST:event_jComboBoxlec2ItemStateChanged

    private void jComboBoxsubjectcodeItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxsubjectcodeItemStateChanged
        // TODO add your handling code here:
                jTextFieldg.setText("");

    }//GEN-LAST:event_jComboBoxsubjectcodeItemStateChanged

    private void jComboBoxtagItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxtagItemStateChanged
        // TODO add your handling code here:
                jTextFieldg.setText("");

    }//GEN-LAST:event_jComboBoxtagItemStateChanged

    private void jSpinnerStudentsStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSpinnerStudentsStateChanged
        // TODO add your handling code here:
                jTextFieldg.setText("");

    }//GEN-LAST:event_jSpinnerStudentsStateChanged

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
            java.util.logging.Logger.getLogger(Manage_Session.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Manage_Session.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Manage_Session.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Manage_Session.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Manage_Session().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addsessionclick;
    private javax.swing.JButton backclick;
    private javax.swing.JButton dashboardclick;
    private javax.swing.JComboBox<String> day;
    private javax.swing.JSpinner ehrs;
    private javax.swing.JSpinner emin;
    private javax.swing.JButton jButtonClear;
    private javax.swing.JButton jButtonDelete;
    private javax.swing.JButton jButtonGen;
    private javax.swing.JButton jButtonRefresh;
    private javax.swing.JButton jButtonSearch;
    private javax.swing.JButton jButtonUpdate;
    private javax.swing.JComboBox<String> jComboBoxGroup;
    private javax.swing.JComboBox<String> jComboBoxLecturer1;
    private javax.swing.JComboBox<String> jComboBoxlec2;
    private javax.swing.JComboBox<String> jComboBoxsubject;
    private javax.swing.JComboBox<String> jComboBoxsubjectcode;
    private javax.swing.JComboBox<String> jComboBoxtag;
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
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSpinner jSpinnerStudents;
    private javax.swing.JSpinner jSpinnerhrs;
    private javax.swing.JSpinner jSpinnermin;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextFieldSelectedLecturers;
    private javax.swing.JTextField jTextFieldg;
    private javax.swing.JComboBox<String> jcomboxsession;
    private javax.swing.JButton managesessionclick;
    private javax.swing.JTextField search;
    private javax.swing.JSpinner shrs;
    private javax.swing.JSpinner smin;
    // End of variables declaration//GEN-END:variables
}
