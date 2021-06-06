/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package madu;
import group_implmentation.dashboard;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SpinnerNumberModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import net.proteanit.sql.DbUtils;
import actions.*;

/**
 *
 * @author Madu
 */
public final class Manage_Subject extends javax.swing.JFrame {

         Subject_Update su=new Subject_Update();
         Subject_Delete sd=new Subject_Delete();
    /**
     * Creates new form Manage_Subject
     */
    public Manage_Subject() {
        initComponents();
   //implement the hidesoze
        hidesize();       
//Gride Add Jtable
        jTable1.setShowGrid(true);

//call create column width
        jtableColumnWidth();
        
        negativeSpinnerStop();



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


 
    
//Set Size of Application and hize maximize    
 void hidesize(){
  
      setSize(1400, 820);
      setLocationRelativeTo(null);
      setResizable(false); // maximize button disable
      setVisible(true);
  }

//set jtable Column width 
 void jtableColumnWidth(){
 
        jTable1.setAutoResizeMode( JTable.AUTO_RESIZE_OFF );
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

}
 
//system Validation for NOT Null Sql
 void validation(){
    if(jTextFieldSubjectName.getText().trim().isEmpty()){
             
        erroSubjectName.setText("Please Enter Subject Name");
         
    }
     
    else if(jTextFieldSubjectCode.getText().trim().isEmpty()){
              
        erroSubjectCode.setText("Please Enter Subject Code");

    } 
    } 
 
 
 
//Display All Data in Jtable
   public void displaytable(){
     
           try{
               try (Connection cn = connection.DB_Connect.ConnecrDB()) {
                   String select="select * from subjects";
                   PreparedStatement pst=cn.prepareStatement(select);
                   
                   
                   
                   ResultSet rs =pst.executeQuery();
                   while(rs.next()){
                       //Data will be added until finish
                       String sub_id       = String.valueOf(rs.getInt("sub_id"));
                       String sub_code    = rs.getString("sub_code");
                       String sub_name=rs.getString("sub_name");
                       String offered_semester  = rs.getString("offered_semester");
                       String offered_year=rs.getString("offered_year");
                       String no_of_lecturer_hours=rs.getString("no_of_lecturer_hours");
                       String no_of_evaluaction_hours   = rs.getString("no_of_evaluaction_hours");
                       String no_of_lab_hours         = rs.getString("no_of_lab_hours");
                       String no_of_tutorial_hours=rs.getString("no_of_tutorial_hours");
                       
                       //string array for store data into jtable
                       String tbData[]={sub_id,sub_code,sub_name,offered_year,offered_semester,no_of_lecturer_hours,no_of_tutorial_hours,no_of_lab_hours,no_of_evaluaction_hours};
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        UpdateButton = new javax.swing.JButton();
        DeleteButton = new javax.swing.JButton();
        ClearButton = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jRadioButton_1Semester = new javax.swing.JRadioButton();
        jRadioButton_2Semester = new javax.swing.JRadioButton();
        jTextFieldSubjectName = new javax.swing.JTextField();
        jTextFieldSubjectCode = new javax.swing.JTextField();
        jSpinnerLecturer = new javax.swing.JSpinner();
        jSpinnerTutorial = new javax.swing.JSpinner();
        jSpinnerLab = new javax.swing.JSpinner();
        jSpinnerEvalucation = new javax.swing.JSpinner();
        erroSubjectName = new javax.swing.JLabel();
        erroSubjectCode = new javax.swing.JLabel();
        ComboBoxOfferedYear = new javax.swing.JComboBox<>();
        erroOfferedYear = new javax.swing.JLabel();
        errosem = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        dashboardclick = new javax.swing.JButton();
        addsubjectclick = new javax.swing.JButton();
        managesubjectclick = new javax.swing.JButton();
        backclick = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(1400, 820));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pasindu_img/logo.jpeg"))); // NOI18N

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        jTable1.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Subject Code", "Subject Name", "Offered year", "Offered Sem", "Number of lecturer hours", "Number of tutorial hours", "Number of lab hours", "number of evalucation hours"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setRowHeight(55);
        jTable1.getTableHeader().setReorderingAllowed(false);
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
            jTable1.getColumnModel().getColumn(0).setResizable(false);
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(250);
            jTable1.getColumnModel().getColumn(1).setResizable(false);
            jTable1.getColumnModel().getColumn(1).setPreferredWidth(250);
            jTable1.getColumnModel().getColumn(2).setResizable(false);
            jTable1.getColumnModel().getColumn(2).setPreferredWidth(250);
            jTable1.getColumnModel().getColumn(3).setResizable(false);
            jTable1.getColumnModel().getColumn(3).setPreferredWidth(250);
            jTable1.getColumnModel().getColumn(4).setResizable(false);
            jTable1.getColumnModel().getColumn(4).setPreferredWidth(250);
            jTable1.getColumnModel().getColumn(5).setResizable(false);
            jTable1.getColumnModel().getColumn(5).setPreferredWidth(250);
            jTable1.getColumnModel().getColumn(6).setResizable(false);
            jTable1.getColumnModel().getColumn(6).setPreferredWidth(250);
            jTable1.getColumnModel().getColumn(7).setResizable(false);
            jTable1.getColumnModel().getColumn(7).setPreferredWidth(250);
            jTable1.getColumnModel().getColumn(8).setResizable(false);
            jTable1.getColumnModel().getColumn(8).setPreferredWidth(250);
        }

        UpdateButton.setBackground(new java.awt.Color(0, 153, 153));
        UpdateButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        UpdateButton.setText("Update");
        UpdateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateButtonActionPerformed(evt);
            }
        });

        DeleteButton.setBackground(new java.awt.Color(0, 153, 153));
        DeleteButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        DeleteButton.setText("Delete");
        DeleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteButtonActionPerformed(evt);
            }
        });

        ClearButton.setBackground(new java.awt.Color(0, 153, 153));
        ClearButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        ClearButton.setText("Clear");
        ClearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClearButtonActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Offered year");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Offered Semester");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Subject Name");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Subject Code");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("Number of lecturer Hours");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("Number of tutorial Hours");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setText("Number of lab Hours");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setText("Number of Evalucation Hours");

        buttonGroup1.add(jRadioButton_1Semester);
        jRadioButton_1Semester.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jRadioButton_1Semester.setText("1 st Semester");

        buttonGroup1.add(jRadioButton_2Semester);
        jRadioButton_2Semester.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jRadioButton_2Semester.setText("2 nd Semester");

        jTextFieldSubjectName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldSubjectNameKeyReleased(evt);
            }
        });

        jTextFieldSubjectCode.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldSubjectCodeKeyReleased(evt);
            }
        });

        erroSubjectName.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        erroSubjectName.setForeground(java.awt.Color.red);

        erroSubjectCode.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        erroSubjectCode.setForeground(java.awt.Color.red);

        ComboBoxOfferedYear.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Y1", "Y2", "Y3", "Y4" }));
        ComboBoxOfferedYear.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                ComboBoxOfferedYearItemStateChanged(evt);
            }
        });
        ComboBoxOfferedYear.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                ComboBoxOfferedYearAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        erroOfferedYear.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        erroOfferedYear.setForeground(new java.awt.Color(255, 0, 0));

        errosem.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        errosem.setForeground(java.awt.Color.red);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 695, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(UpdateButton, javax.swing.GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE)
                    .addComponent(DeleteButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ClearButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addGap(22, 22, 22)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(erroSubjectCode, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(311, 311, 311))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jTextFieldSubjectName)
                                            .addComponent(jTextFieldSubjectCode))
                                        .addGap(40, 40, 40))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(ComboBoxOfferedYear, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGap(10, 10, 10)
                                                .addComponent(erroOfferedYear, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(errosem, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGroup(jPanel2Layout.createSequentialGroup()
                                                    .addComponent(jRadioButton_1Semester)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                    .addComponent(jRadioButton_2Semester))))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)))
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel10)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jSpinnerEvalucation, javax.swing.GroupLayout.DEFAULT_SIZE, 56, Short.MAX_VALUE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel7)
                                            .addComponent(jLabel8)
                                            .addComponent(jLabel9))
                                        .addGap(38, 38, 38)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jSpinnerLecturer, javax.swing.GroupLayout.DEFAULT_SIZE, 56, Short.MAX_VALUE)
                                            .addComponent(jSpinnerTutorial)
                                            .addComponent(jSpinnerLab))))))
                        .addGap(147, 147, 147))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(erroSubjectName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(458, 458, 458))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel3)
                                .addComponent(jLabel7)
                                .addComponent(jSpinnerLecturer, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(ComboBoxOfferedYear, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addComponent(UpdateButton, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(DeleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(ClearButton, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(8, 8, 8)
                .addComponent(erroOfferedYear)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel8)
                    .addComponent(jRadioButton_1Semester)
                    .addComponent(jRadioButton_2Semester)
                    .addComponent(jSpinnerTutorial, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(errosem)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel9)
                    .addComponent(jTextFieldSubjectName, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSpinnerLab, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addComponent(erroSubjectName, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel10)
                    .addComponent(jTextFieldSubjectCode, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSpinnerEvalucation, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(erroSubjectCode, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52))
        );

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 153, 153));
        jLabel2.setText("Manage Subject");

        dashboardclick.setBackground(new java.awt.Color(0, 153, 153));
        dashboardclick.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        dashboardclick.setText("Dashboard");
        dashboardclick.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dashboardclickActionPerformed(evt);
            }
        });

        addsubjectclick.setBackground(new java.awt.Color(0, 153, 153));
        addsubjectclick.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        addsubjectclick.setText("Add Subject");
        addsubjectclick.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addsubjectclickActionPerformed(evt);
            }
        });

        managesubjectclick.setBackground(new java.awt.Color(0, 153, 153));
        managesubjectclick.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        managesubjectclick.setText("Manage Subject");

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
                        .addGap(103, 103, 103)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(managesubjectclick, javax.swing.GroupLayout.DEFAULT_SIZE, 228, Short.MAX_VALUE)
                            .addComponent(addsubjectclick, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(dashboardclick, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(139, 139, 139)
                        .addComponent(backclick, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(110, 110, 110))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jLabel2)
                        .addGap(3, 3, 3)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dashboardclick, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addComponent(addsubjectclick, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addComponent(managesubjectclick, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addComponent(backclick, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(76, 76, 76))
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
Add_Subject as;
    private void addsubjectclickActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addsubjectclickActionPerformed
        // TODO add your handling code here:
              if (as == null) {
            as = new Add_Subject();
        }
        
        as.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_addsubjectclickActionPerformed
Manage_Subject ms;
    private void backclickActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backclickActionPerformed
        // TODO add your handling code here:
       group_implmentation.loging.dashb.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_backclickActionPerformed

    private void jTable1AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jTable1AncestorAdded
        // TODO add your handling code here:
//call the methode        
        displaytable();
    }//GEN-LAST:event_jTable1AncestorAdded

//Select Row And Display Data
    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
            int i=jTable1.getSelectedRow();
           
            TableModel model=jTable1.getModel();
                      jTextFieldSubjectCode.setText(model.getValueAt(i, 1).toString());
 
            jTextFieldSubjectName.setText(model.getValueAt(i, 2).toString());
            ComboBoxOfferedYear.setSelectedItem(model.getValueAt(i, 3).toString());

            String semester;
            semester = model.getValueAt(i, 4).toString();
            if(semester.equals("1-Semester")){
                jRadioButton_1Semester.setSelected(true);
            }
            else if(semester.equals("2-Semester")) {
                jRadioButton_2Semester.setSelected(true);
            
            }

            jSpinnerLecturer.setValue(Integer.parseInt((String)model.getValueAt(i,5)));
            jSpinnerTutorial.setValue(Integer.parseInt((String)model.getValueAt(i, 6)));
            jSpinnerLab.setValue(Integer.parseInt((String)model.getValueAt(i, 7)));
            jSpinnerEvalucation.setValue(Integer.parseInt((String)model.getValueAt(i, 8)));
            
    }//GEN-LAST:event_jTable1MouseClicked


//This methode use for Auto Refresh Data
private void updateRe_table(){
      

       Connection cn=connection.DB_Connect.ConnecrDB();
       String sql="select *from subjects";

try{
           


    PreparedStatement pst = cn.prepareStatement(sql);
           ResultSet rs = pst.executeQuery();
           jTable1.setModel(DbUtils.resultSetToTableModel(rs));
           jtableColumnWidth();

           cn.close();
           pst.close();
           rs.close();
}catch(SQLException e){
      JOptionPane.showMessageDialog(null, e);
}
    
    }
    

//Update All Data
    private void UpdateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateButtonActionPerformed
        // TODO add your handling code here:

              LoadDataUpdate();
            String SubjectName=jTextFieldSubjectName.getText();
            String SubjectCode=jTextFieldSubjectCode.getText();
            String OfferedYear=ComboBoxOfferedYear.getSelectedItem().toString();
               if(jRadioButton_1Semester.isSelected()){
                    semester="1-Semester";
            
                }
                if(jRadioButton_2Semester.isSelected()){
                    semester="2-Semester";
                } 
            String Semester=semester;
            String EvalucationHours=jSpinnerLecturer.getValue().toString();
            String LabHours=jSpinnerLab.getValue().toString();
            String TutorialHours=jSpinnerTutorial.getValue().toString();
            String LecturerHours=jSpinnerEvalucation.getValue().toString();
                
        if(!("1-Semester".equals(semester)|| "2-Semester".equals(semester))|| jTextFieldSubjectName.getText().trim().isEmpty() || jTextFieldSubjectCode.getText().trim().isEmpty()){
                 
                                         JOptionPane.showMessageDialog(null, "Some Feilds Are Empty");

                   
                   }else{ 
                
                su.UpdateSubject(SubjectCode, SubjectName, OfferedYear, Semester, EvalucationHours, LabHours, TutorialHours, LecturerHours);
                         
            
       
             }
                
        
                        updateRe_table();

    }//GEN-LAST:event_UpdateButtonActionPerformed
void negativeSpinnerStop(){



          ((SpinnerNumberModel) jSpinnerLecturer.getModel()).setMinimum(0);
          ((SpinnerNumberModel) jSpinnerTutorial.getModel()).setMinimum(0);
          ((SpinnerNumberModel) jSpinnerEvalucation.getModel()).setMinimum(0);
          ((SpinnerNumberModel) jSpinnerLab.getModel()).setMinimum(0);





}
    
//Delete selected Data
    private void DeleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteButtonActionPerformed
        // TODO add your handling code here:
        LoadDataDelete();

        DefaultTableModel tableModel = (DefaultTableModel) jTable1.getModel();
        tableModel.setRowCount(0);
        sd.SubjectDelete();

          displaytable();
    }//GEN-LAST:event_DeleteButtonActionPerformed

//Clear All Data Database
    private void ClearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClearButtonActionPerformed
        // TODO add your handling code here:
        jTextFieldSubjectName.setText("");
        jTextFieldSubjectCode.setText("");
        buttonGroup1.clearSelection();
        jSpinnerTutorial.setValue(0);
        jSpinnerLab.setValue(0);
        jSpinnerLecturer.setValue(0);
        jSpinnerEvalucation.setValue(0);
        ComboBoxOfferedYear.setSelectedIndex(0);
        erroOfferedYear.setText("");
        erroSubjectName.setText("");
        erroSubjectCode.setText("");
        
        
    }//GEN-LAST:event_ClearButtonActionPerformed

    private void ComboBoxOfferedYearItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_ComboBoxOfferedYearItemStateChanged
        // TODO add your handling code here:
            erroOfferedYear.setText("");

    }//GEN-LAST:event_ComboBoxOfferedYearItemStateChanged

    private void ComboBoxOfferedYearAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_ComboBoxOfferedYearAncestorAdded
        // TODO add your handling code here:
   
    }//GEN-LAST:event_ComboBoxOfferedYearAncestorAdded

    private void jTextFieldSubjectNameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldSubjectNameKeyReleased
        // TODO add your handling code here:
      erroSubjectName.setText("");

    }//GEN-LAST:event_jTextFieldSubjectNameKeyReleased

    private void jTextFieldSubjectCodeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldSubjectCodeKeyReleased
        // TODO add your handling code here:
    erroSubjectCode.setText("");

    }//GEN-LAST:event_jTextFieldSubjectCodeKeyReleased
String semester;


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
            java.util.logging.Logger.getLogger(Manage_Subject.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Manage_Subject.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Manage_Subject.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Manage_Subject.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Manage_Subject().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ClearButton;
    private javax.swing.JComboBox<String> ComboBoxOfferedYear;
    private javax.swing.JButton DeleteButton;
    private javax.swing.JButton UpdateButton;
    private javax.swing.JButton addsubjectclick;
    private javax.swing.JButton backclick;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton dashboardclick;
    private javax.swing.JLabel erroOfferedYear;
    private javax.swing.JLabel erroSubjectCode;
    private javax.swing.JLabel erroSubjectName;
    private javax.swing.JLabel errosem;
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
    private javax.swing.JRadioButton jRadioButton_1Semester;
    private javax.swing.JRadioButton jRadioButton_2Semester;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSpinner jSpinnerEvalucation;
    private javax.swing.JSpinner jSpinnerLab;
    private javax.swing.JSpinner jSpinnerLecturer;
    private javax.swing.JSpinner jSpinnerTutorial;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextFieldSubjectCode;
    private javax.swing.JTextField jTextFieldSubjectName;
    private javax.swing.JButton managesubjectclick;
    // End of variables declaration//GEN-END:variables
}
