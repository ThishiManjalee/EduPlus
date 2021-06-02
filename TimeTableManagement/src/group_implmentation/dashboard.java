/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package group_implmentation;

import java.awt.event.ActionEvent;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JFrame;
import pasindu.Manage_Location;
import pasindu.statistics;
import pasindu.View_SessionRoom;
import yass.manage_n_available_time;
import yass.manage_working_days;
import madu.Manage_Lecturer;
import system_update.menu_updates;
import madu.Manage_Subject;
import madu.Manage_Session;
import Thishi.Manage_Student_Group;
import Thishi.Manage_tags;
import Thishi.Sessions_AvailableTime;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author pasindu
 */
public final class dashboard extends javax.swing.JFrame {

    /**
     * Creates new form dashboard
     */
    public dashboard() {
        initComponents();
        hidesize();

//implement date and time functions
        showDate();
        showTime();
//implement hide size function 
//acess public methode countRegistered data        
//acsses public methode 
        // LatestUpdates();
        displayDaytime();
        countRegsteredData();

    }

    void showDate() {
        Date d = new Date();
        SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd");
        date.setText(s.format(d));

    }

    public void showTime() {
        new javax.swing.Timer(0, (ActionEvent ae) -> {
            Date d = new Date();
            SimpleDateFormat s = new SimpleDateFormat("hh:mm:ss a");
            time.setText(s.format(d));
        }).start();

    }

    void hidesize() {

        setSize(1400, 820);
        setLocationRelativeTo(null);
        setResizable(false); // maximize button disable
        
        
    }
 
    void displayDaytime() {
        Connection cn = connection.DB_Connect.ConnecrDB();

        PreparedStatement ps = null;
        ResultSet rs = null;
        try {

            String s5 = "SELECT * FROM working_days_hours ORDER BY wd_id DESC LIMIT 1";
            ps = cn.prepareStatement(s5);
            rs = ps.executeQuery();
            while (rs.next()) {
                String working_days = rs.getString("working_days");
                numofdays.setText(working_days);

                String monday = rs.getString("monday");
                String tuesday = rs.getString("tuesday");
                String wensday = rs.getString("wensday");
                String thursday = rs.getString("thursday");
                String friday = rs.getString("friday");
                String saturday = rs.getString("saturday");
                String sunday = rs.getString("sunday");

                if ("Open".equals(monday)) {

                    o1.setText(monday);
                } else if ("Close".equals(monday)) {

                    c1.setText(monday);
                }

                if ("Open".equals(tuesday)) {
                    o2.setText(tuesday);
                } else if ("Close".equals(tuesday)) {

                    c2.setText(tuesday);
                }

                if ("Open".equals(wensday)) {
                    o3.setText(wensday);
                } else if ("Close".equals(wensday)) {

                    c3.setText(wensday);
                }

                if ("Open".equals(thursday)) {
                    o4.setText(thursday);
                } else if ("Close".equals(thursday)) {

                    c4.setText(thursday);
                }

                if ("Open".equals(friday)) {
                    o5.setText(friday);
                } else if ("Close".equals(friday)) {

                    c5.setText(friday);
                }
                if ("Open".equals(saturday)) {
                    o6.setText(saturday);
                } else if ("Close".equals(saturday)) {

                    c6.setText(sunday);
                }
                if ("Open".equals(sunday)) {
                    o7.setText(sunday);
                } else if ("Close".equals(sunday)) {

                    c7.setText(sunday);
                }

                String working_time_perday_hr = rs.getString("working_time_perday_hr");
                hours.setText(working_time_perday_hr);
                String working_time_perday_min = rs.getString("working_time_perday_min");
                min.setText(working_time_perday_min);
            }
            ps.close();
            rs.close();
            cn.close();

        } catch (SQLException e) {
            System.out.print(e.toString());
        }

    }

    public void countRegsteredData() {
        Connection cn = connection.DB_Connect.ConnecrDB();
        PreparedStatement ps = null;
        ResultSet rs = null;
//Count Registered Lecturers        
        try {
            String s1 = "select count(lid) from lecturer";
            ps = cn.prepareStatement(s1);
            rs = ps.executeQuery();
            while (rs.next()) {
                String lec = rs.getString("count(lid)");

                leccount.setText(lec);

            }
        } catch (SQLException e) {
            System.out.print(e.toString());
        }
//Count Registered Student Groups
        try {
            String s2 = "select count(stu_id) from student_group";
            ps = cn.prepareStatement(s2);
            rs = ps.executeQuery();
            while (rs.next()) {

                String stu = rs.getString("count(stu_id)");
                countstudent.setText(stu);
            }

        } catch (SQLException e) {
            System.out.print(e.toString());
        }

//Count Registered Locations 
        try {
            String s4 = "select count(location_id) from location";
            ps = cn.prepareStatement(s4);
            rs = ps.executeQuery();
            while (rs.next()) {

                String room = rs.getString("count(location_id)");
                countrooms.setText(room);
            }

        } catch (SQLException e) {
            System.out.print(e.toString());
        }

//Count Registered Subject      
        try {
            String s3 = "select count(sub_id) from subjects";
            ps = cn.prepareStatement(s3);
            rs = ps.executeQuery();
            while (rs.next()) {

                String sub = rs.getString("count(sub_id)");
                countsubjects.setText(sub);
            }
            //coneection close
            ps.close();
            rs.close();
            cn.close();

        } catch (SQLException e) {
            System.out.print(e.toString());
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

        jTabbedPane2 = new javax.swing.JTabbedPane();
        lest_small = new javax.swing.JPanel();
        icon_logo = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        leccount = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        countstudent = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        countsubjects = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        jPanel15 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        countrooms = new javax.swing.JLabel();
        main_table_panel = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        NotAvailableTimeClik = new javax.swing.JButton();
        WorkingDetailsClick = new javax.swing.JButton();
        SubjectsClick = new javax.swing.JButton();
        SessionRoomsClick = new javax.swing.JButton();
        LocationClick = new javax.swing.JButton();
        SessionCategoriesClick = new javax.swing.JButton();
        TagClick = new javax.swing.JButton();
        ClickStudentGroup = new javax.swing.JButton();
        SessionClick = new javax.swing.JButton();
        AddLecturerClick = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        date = new javax.swing.JLabel();
        time = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        logout = new javax.swing.JButton();
        SystemUpdateClick = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        StatisticClicke = new javax.swing.JButton();
        jLabel25 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jComboBox_View = new javax.swing.JComboBox<>();
        ViewClick = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jPanel16 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        numofdays = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        hours = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        min = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        o1 = new javax.swing.JLabel();
        o2 = new javax.swing.JLabel();
        o3 = new javax.swing.JLabel();
        o4 = new javax.swing.JLabel();
        o5 = new javax.swing.JLabel();
        o6 = new javax.swing.JLabel();
        o7 = new javax.swing.JLabel();
        c1 = new javax.swing.JLabel();
        c2 = new javax.swing.JLabel();
        c3 = new javax.swing.JLabel();
        c4 = new javax.swing.JLabel();
        c5 = new javax.swing.JLabel();
        c6 = new javax.swing.JLabel();
        c7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setFocusable(false);
        setFocusableWindowState(false);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lest_small.setBackground(new java.awt.Color(255, 255, 255));
        lest_small.setPreferredSize(new java.awt.Dimension(250, 820));

        icon_logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pasindu_img/deklogo.png"))); // NOI18N

        jPanel8.setBackground(new java.awt.Color(204, 255, 0));
        jPanel8.setForeground(java.awt.Color.white);

        jPanel9.setBackground(new java.awt.Color(153, 255, 153));

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 15, Short.MAX_VALUE)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setText("Registered Lecturers");

        leccount.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        leccount.setText("      12");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addComponent(leccount, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 66, Short.MAX_VALUE)
                    .addComponent(leccount, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addGap(2, 2, 2))
        );

        jPanel10.setBackground(new java.awt.Color(204, 255, 0));
        jPanel10.setForeground(java.awt.Color.white);

        jPanel11.setBackground(new java.awt.Color(153, 255, 153));

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 15, Short.MAX_VALUE)
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setText("Registered Stu.Groups");

        countstudent.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        countstudent.setText("     67");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addComponent(countstudent, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(countstudent, javax.swing.GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addContainerGap())
        );

        jPanel12.setBackground(new java.awt.Color(204, 255, 0));
        jPanel12.setForeground(java.awt.Color.white);

        jPanel13.setBackground(new java.awt.Color(153, 255, 153));

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 15, Short.MAX_VALUE)
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setText("Registered Subjects");

        countsubjects.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        countsubjects.setText("     45");

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel6))
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addComponent(countsubjects, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(countsubjects, javax.swing.GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addContainerGap())
        );

        jPanel14.setBackground(new java.awt.Color(204, 255, 0));
        jPanel14.setForeground(java.awt.Color.white);

        jPanel15.setBackground(new java.awt.Color(153, 255, 153));

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 15, Short.MAX_VALUE)
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel7.setText("Registered Rooms");

        countrooms.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        countrooms.setText("    67");

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addComponent(countrooms, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel7)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(countrooms, javax.swing.GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addContainerGap())
        );

        javax.swing.GroupLayout lest_smallLayout = new javax.swing.GroupLayout(lest_small);
        lest_small.setLayout(lest_smallLayout);
        lest_smallLayout.setHorizontalGroup(
            lest_smallLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel12, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel14, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(icon_logo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        lest_smallLayout.setVerticalGroup(
            lest_smallLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lest_smallLayout.createSequentialGroup()
                .addComponent(icon_logo, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 67, Short.MAX_VALUE))
        );

        getContentPane().add(lest_small, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 250, 820));

        main_table_panel.setBackground(java.awt.Color.white);
        main_table_panel.setPreferredSize(new java.awt.Dimension(1400, 820));

        jPanel2.setBackground(new java.awt.Color(0, 153, 153));

        NotAvailableTimeClik.setBackground(new java.awt.Color(0, 153, 153));
        NotAvailableTimeClik.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dashboard_icon_img/not_avilablw_time_icon.png"))); // NOI18N
        NotAvailableTimeClik.setBorder(null);
        NotAvailableTimeClik.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NotAvailableTimeClikActionPerformed(evt);
            }
        });

        WorkingDetailsClick.setBackground(new java.awt.Color(0, 153, 153));
        WorkingDetailsClick.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dashboard_icon_img/working_details_icon.png"))); // NOI18N
        WorkingDetailsClick.setBorder(null);
        WorkingDetailsClick.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                WorkingDetailsClickActionPerformed(evt);
            }
        });

        SubjectsClick.setBackground(new java.awt.Color(0, 153, 153));
        SubjectsClick.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dashboard_icon_img/subject_icon.png"))); // NOI18N
        SubjectsClick.setBorder(null);
        SubjectsClick.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SubjectsClickActionPerformed(evt);
            }
        });

        SessionRoomsClick.setBackground(new java.awt.Color(0, 153, 153));
        SessionRoomsClick.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dashboard_icon_img/sessionRooms_icon.png"))); // NOI18N
        SessionRoomsClick.setBorder(null);
        SessionRoomsClick.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SessionRoomsClickActionPerformed(evt);
            }
        });

        LocationClick.setBackground(new java.awt.Color(0, 153, 153));
        LocationClick.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dashboard_icon_img/locaion_icon.png"))); // NOI18N
        LocationClick.setBorder(null);
        LocationClick.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LocationClickActionPerformed(evt);
            }
        });

        SessionCategoriesClick.setBackground(new java.awt.Color(0, 153, 153));
        SessionCategoriesClick.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dashboard_icon_img/sessionCato_icon.png"))); // NOI18N
        SessionCategoriesClick.setBorder(null);
        SessionCategoriesClick.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SessionCategoriesClickActionPerformed(evt);
            }
        });

        TagClick.setBackground(new java.awt.Color(0, 153, 153));
        TagClick.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dashboard_icon_img/Tag_icon.png"))); // NOI18N
        TagClick.setBorder(null);
        TagClick.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TagClickActionPerformed(evt);
            }
        });

        ClickStudentGroup.setBackground(new java.awt.Color(0, 153, 153));
        ClickStudentGroup.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dashboard_icon_img/student_group_icon.png"))); // NOI18N
        ClickStudentGroup.setBorder(null);
        ClickStudentGroup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClickStudentGroupActionPerformed(evt);
            }
        });

        SessionClick.setBackground(new java.awt.Color(0, 153, 153));
        SessionClick.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dashboard_icon_img/Session_icon.png"))); // NOI18N
        SessionClick.setBorder(null);
        SessionClick.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SessionClickActionPerformed(evt);
            }
        });

        AddLecturerClick.setBackground(new java.awt.Color(0, 153, 153));
        AddLecturerClick.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dashboard_icon_img/Lecturers_icon.png"))); // NOI18N
        AddLecturerClick.setBorder(null);
        AddLecturerClick.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddLecturerClickActionPerformed(evt);
            }
        });

        jPanel7.setBackground(new java.awt.Color(0, 153, 153));
        jPanel7.setPreferredSize(new java.awt.Dimension(156, 113));

        date.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        date.setText("Date:");

        time.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        time.setText("Time:");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Date:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setText("Time:");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel1))
                .addGap(30, 30, 30)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(date)
                    .addComponent(time))
                .addContainerGap(109, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(date)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(time)
                    .addComponent(jLabel3))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel2.setBackground(java.awt.Color.black);
        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel2.setText("DashBoard");

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pasindu_img/User_Avatar.png"))); // NOI18N
        jLabel9.setText("jLabel9");

        logout.setBackground(new java.awt.Color(204, 255, 0));
        logout.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        logout.setText("Logout");
        logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutActionPerformed(evt);
            }
        });

        SystemUpdateClick.setBackground(new java.awt.Color(0, 153, 153));
        SystemUpdateClick.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dashboard_icon_img/system_update.png"))); // NOI18N
        SystemUpdateClick.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SystemUpdateClickActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(91, 91, 91)
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE)
                        .addGap(98, 98, 98))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(81, 81, 81)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(logout, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(AddLecturerClick, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(SessionClick, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(SessionRoomsClick, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ClickStudentGroup, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TagClick, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(86, 86, 86)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(LocationClick, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(SubjectsClick, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(WorkingDetailsClick, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(NotAvailableTimeClik, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(SessionCategoriesClick, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(211, 211, 211)
                .addComponent(SystemUpdateClick, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(61, 61, 61))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel9)
                            .addComponent(logout, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(AddLecturerClick)
                        .addGap(40, 40, 40)
                        .addComponent(SessionClick, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(SessionRoomsClick, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(ClickStudentGroup, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(TagClick, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(LocationClick, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(85, 85, 85))
                            .addComponent(SubjectsClick, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(40, 40, 40)
                        .addComponent(WorkingDetailsClick, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(NotAvailableTimeClik, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(SessionCategoriesClick, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(45, 45, 45)
                .addComponent(SystemUpdateClick)
                .addGap(34, 34, 34))
        );

        jPanel3.setBackground(java.awt.Color.white);

        jPanel5.setBackground(new java.awt.Color(153, 255, 153));

        jPanel1.setBackground(new java.awt.Color(0, 153, 153));

        StatisticClicke.setBackground(new java.awt.Color(204, 255, 0));
        StatisticClicke.setForeground(new java.awt.Color(204, 255, 0));
        StatisticClicke.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dashboard_icon_img/statupdate.png"))); // NOI18N
        StatisticClicke.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StatisticClickeActionPerformed(evt);
            }
        });

        jLabel25.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel25.setForeground(java.awt.Color.white);
        jLabel25.setText("What is New ,Statistics");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(StatisticClicke, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(StatisticClicke, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(48, Short.MAX_VALUE))
        );

        jPanel6.setBackground(new java.awt.Color(0, 153, 153));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jLabel12.setForeground(java.awt.Color.white);
        jLabel12.setText("Please Select the Timetable type:-");

        jComboBox_View.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jComboBox_View.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Please Select the TimeTable type", "Student", "Lecturer", "Location", " " }));

        ViewClick.setBackground(new java.awt.Color(204, 255, 0));
        ViewClick.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        ViewClick.setText("View");
        ViewClick.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ViewClickActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(ViewClick, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addComponent(jComboBox_View, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBox_View, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addComponent(ViewClick, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel4.setBackground(new java.awt.Color(153, 255, 153));

        jPanel16.setBackground(new java.awt.Color(0, 153, 153));
        jPanel16.setForeground(new java.awt.Color(153, 255, 51));

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jLabel13.setForeground(java.awt.Color.white);
        jLabel13.setText("Working Days and Hourse");

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel14.setForeground(java.awt.Color.white);
        jLabel14.setText("No Of Days:");

        numofdays.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        numofdays.setForeground(java.awt.Color.white);
        numofdays.setText("5");

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel16.setForeground(java.awt.Color.white);
        jLabel16.setText("Working Days:-");

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel18.setForeground(java.awt.Color.white);
        jLabel18.setText("Working Time Per Day:-");

        hours.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        hours.setForeground(java.awt.Color.white);
        hours.setText("11");

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel20.setForeground(java.awt.Color.white);
        jLabel20.setText("Houres");

        min.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        min.setForeground(java.awt.Color.white);
        min.setText("30");

        jLabel23.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel23.setForeground(java.awt.Color.white);
        jLabel23.setText("Minutes");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel10.setText("Monday");

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel11.setText("Tuesday");

        jLabel24.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel24.setText("Wesnesday");

        jLabel26.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel26.setText("Thursday");

        jLabel27.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel27.setText("Friday");

        jLabel28.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel28.setText("Saturday");

        jLabel29.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel29.setText("Sunday");

        o1.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        o1.setForeground(new java.awt.Color(153, 255, 51));

        o2.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        o2.setForeground(new java.awt.Color(153, 255, 51));

        o3.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        o3.setForeground(new java.awt.Color(153, 255, 51));

        o4.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        o4.setForeground(new java.awt.Color(153, 255, 51));

        o5.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        o5.setForeground(new java.awt.Color(153, 255, 51));

        o6.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        o6.setForeground(new java.awt.Color(153, 255, 51));

        o7.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        o7.setForeground(new java.awt.Color(153, 255, 51));

        c1.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        c1.setForeground(new java.awt.Color(255, 0, 0));

        c2.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        c2.setForeground(new java.awt.Color(255, 0, 0));

        c3.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        c3.setForeground(java.awt.Color.red);

        c4.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        c4.setForeground(java.awt.Color.red);

        c5.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        c5.setForeground(java.awt.Color.red);

        c6.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        c6.setForeground(java.awt.Color.red);

        c7.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        c7.setForeground(java.awt.Color.red);

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel16)
                            .addComponent(jLabel28)
                            .addComponent(jLabel29))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addGroup(jPanel16Layout.createSequentialGroup()
                                .addComponent(hours, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(25, 25, 25)
                                .addComponent(min, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel23))
                            .addComponent(jLabel13)
                            .addGroup(jPanel16Layout.createSequentialGroup()
                                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel11)
                                    .addComponent(jLabel24)
                                    .addComponent(jLabel26)
                                    .addComponent(jLabel27))
                                .addGap(41, 41, 41)
                                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel16Layout.createSequentialGroup()
                                        .addComponent(o7)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(c7))
                                    .addGroup(jPanel16Layout.createSequentialGroup()
                                        .addComponent(o6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(c6))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel16Layout.createSequentialGroup()
                                        .addComponent(o5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(c5))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel16Layout.createSequentialGroup()
                                        .addComponent(o4, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(c4))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel16Layout.createSequentialGroup()
                                        .addComponent(o3, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(c3))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel16Layout.createSequentialGroup()
                                        .addComponent(o2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(c2))
                                    .addGroup(jPanel16Layout.createSequentialGroup()
                                        .addComponent(o1)
                                        .addGap(48, 48, 48)
                                        .addComponent(c1))))
                            .addGroup(jPanel16Layout.createSequentialGroup()
                                .addComponent(jLabel14)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(numofdays, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(67, Short.MAX_VALUE))))
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel13)
                .addGap(10, 10, 10)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(numofdays))
                .addGap(12, 12, 12)
                .addComponent(jLabel16)
                .addGap(26, 26, 26)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(o1)
                    .addComponent(c1))
                .addGap(15, 15, 15)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(o2)
                    .addComponent(c2))
                .addGap(15, 15, 15)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24)
                    .addComponent(o3)
                    .addComponent(c3))
                .addGap(15, 15, 15)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel26)
                    .addComponent(o4)
                    .addComponent(c4))
                .addGap(15, 15, 15)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel27)
                    .addComponent(o5)
                    .addComponent(c5))
                .addGap(15, 15, 15)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel28)
                    .addComponent(o6)
                    .addComponent(c6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel29)
                    .addComponent(o7)
                    .addComponent(c7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel18)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(hours, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(min, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout main_table_panelLayout = new javax.swing.GroupLayout(main_table_panel);
        main_table_panel.setLayout(main_table_panelLayout);
        main_table_panelLayout.setHorizontalGroup(
            main_table_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(main_table_panelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(236, Short.MAX_VALUE))
        );
        main_table_panelLayout.setVerticalGroup(
            main_table_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(main_table_panelLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(main_table_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(main_table_panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 0, 1400, 820));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jlecturer3mouseclicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlecturer3mouseclicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jlecturer3mouseclicked

    private void jlecturer3mousentered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlecturer3mousentered
        // TODO add your handling code here:
    }//GEN-LAST:event_jlecturer3mousentered

    private void jlecturer3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jlecturer3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jlecturer3ActionPerformed

    private void jstudent3mouseclicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jstudent3mouseclicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jstudent3mouseclicked

    private void jstudent3mousentered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jstudent3mousentered
        // TODO add your handling code here:
    }//GEN-LAST:event_jstudent3mousentered

    private void jstudent3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jstudent3ActionPerformed
    }//GEN-LAST:event_jstudent3ActionPerformed

    private void jlocation3mouseclicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlocation3mouseclicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jlocation3mouseclicked

    private void jlocation3mousentered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlocation3mousentered
        // TODO add your handling code here:
    }//GEN-LAST:event_jlocation3mousentered

    private void jlocation3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jlocation3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jlocation3ActionPerformed
       dashboard da;

    Manage_Lecturer mk;
    private void AddLecturerClickActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddLecturerClickActionPerformed
        // TODO add your handling code here:

       if (mk == null) {

          mk = new Manage_Lecturer();
           
      }
           mk.setVisible(true);
           this.dispose();

    }//GEN-LAST:event_AddLecturerClickActionPerformed
    Manage_Session nal3l;
    dashboard da6;
    private void SessionClickActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SessionClickActionPerformed
        // TODO add your handling code here:

        if (nal3l == null) {
            nal3l = new Manage_Session();
        }

        nal3l.setVisible(true);
        this.dispose();


    }//GEN-LAST:event_SessionClickActionPerformed
    View_SessionRoom vs;
    private void SessionRoomsClickActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SessionRoomsClickActionPerformed
        // TODO add your handling code here:

        if (vs == null) {
            vs = new View_SessionRoom();
        }

        vs.setVisible(true);
        this.dispose();


    }//GEN-LAST:event_SessionRoomsClickActionPerformed
    statistics al1;
    private void StatisticClickeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_StatisticClickeActionPerformed
        // TODO add your handling code here:

        if (al1 == null) {
            al1 = new statistics();
        }

        al1.setVisible(true);
        this.dispose();


    }//GEN-LAST:event_StatisticClickeActionPerformed
    Manage_Location ml1;
    private void LocationClickActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LocationClickActionPerformed
        // TODO add your handling code here:

        try {
            if (ml1 == null) {
                ml1 = new Manage_Location();
            }

            ml1.setVisible(true);
            this.dispose();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }//GEN-LAST:event_LocationClickActionPerformed

student_time_table tl1;
location_time_table tl2;
lecturer_time_table tl3;
    private void ViewClickActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ViewClickActionPerformed
        // TODO add your handling code here:
        
        
        if (jComboBox_View.getSelectedItem() == "Student") {

           
        try {
            if (tl1 == null) {
                tl1 = new student_time_table();
            }

            tl1.setVisible(true);
            this.dispose();
        } catch (Exception e) {
            e.printStackTrace();
        }

        }
        if (jComboBox_View.getSelectedItem() == "Location") {

            try {
            if (tl2 == null) {
                tl2 = new location_time_table();
            }

            tl2.setVisible(true);
            this.dispose();
        } catch (Exception e) {
            e.printStackTrace();
        }


        }
        if (jComboBox_View.getSelectedItem() == "Lecturer") {
             try {
            if (tl3 == null) {
                tl3 = new lecturer_time_table();
            }

            tl3.setVisible(true);
            this.dispose();
        } catch (Exception e) {
            e.printStackTrace();
        }


        }
    }//GEN-LAST:event_ViewClickActionPerformed

    private void logoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutActionPerformed

// TODO add your handling code herr
        loging log = new loging();
        log.show();
        dispose();

    }//GEN-LAST:event_logoutActionPerformed
    manage_working_days mwd;
    private void WorkingDetailsClickActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_WorkingDetailsClickActionPerformed
        // TODO add your handling code here:

        if (mwd == null) {
            mwd = new manage_working_days();
        }

        mwd.setVisible(true);
        this.dispose();


    }//GEN-LAST:event_WorkingDetailsClickActionPerformed
    manage_n_available_time mnt;
    private void NotAvailableTimeClikActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NotAvailableTimeClikActionPerformed
        // TODO add your handling code here:

        if (mnt == null) {
            mnt = new manage_n_available_time();
        }

        mnt.setVisible(true);
        this.dispose();

    }//GEN-LAST:event_NotAvailableTimeClikActionPerformed
    menu_updates mu;
    private void SystemUpdateClickActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SystemUpdateClickActionPerformed
        // TODO add your handling code here:

        if (mu == null) {
            mu = new menu_updates();
        }

        mu.setVisible(true);
        this.dispose();

    }//GEN-LAST:event_SystemUpdateClickActionPerformed
    Manage_Subject ms;
    private void SubjectsClickActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SubjectsClickActionPerformed
        // TODO add your handling code here:

        if (ms == null) {
            ms = new Manage_Subject();
        }

        ms.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_SubjectsClickActionPerformed
    Manage_Student_Group msg;
    private void ClickStudentGroupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClickStudentGroupActionPerformed
        // TODO add your handling code here:

        if (msg == null) {
            msg = new Manage_Student_Group();
        }

        msg.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_ClickStudentGroupActionPerformed
    Manage_tags mt;
    private void TagClickActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TagClickActionPerformed
        // TODO add your handling code here:
        if (mt == null) {
            mt = new Manage_tags();
        }

        mt.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_TagClickActionPerformed
    Sessions_AvailableTime sa;
    private void SessionCategoriesClickActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SessionCategoriesClickActionPerformed
        // TODO add your handling code here:

        if (sa == null) {
            sa = new Sessions_AvailableTime();
            
        }

        sa.setVisible(true);
        dispose();
    }//GEN-LAST:event_SessionCategoriesClickActionPerformed

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
            java.util.logging.Logger.getLogger(Manage_Location.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Manage_Location.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Manage_Location.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Manage_Location.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new dashboard().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddLecturerClick;
    private javax.swing.JButton ClickStudentGroup;
    private javax.swing.JButton LocationClick;
    private javax.swing.JButton NotAvailableTimeClik;
    private javax.swing.JButton SessionCategoriesClick;
    private javax.swing.JButton SessionClick;
    private javax.swing.JButton SessionRoomsClick;
    private javax.swing.JButton StatisticClicke;
    private javax.swing.JButton SubjectsClick;
    private javax.swing.JButton SystemUpdateClick;
    private javax.swing.JButton TagClick;
    private javax.swing.JButton ViewClick;
    private javax.swing.JButton WorkingDetailsClick;
    private javax.swing.JLabel c1;
    private javax.swing.JLabel c2;
    private javax.swing.JLabel c3;
    private javax.swing.JLabel c4;
    private javax.swing.JLabel c5;
    private javax.swing.JLabel c6;
    private javax.swing.JLabel c7;
    private javax.swing.JLabel countrooms;
    private javax.swing.JLabel countstudent;
    private javax.swing.JLabel countsubjects;
    private javax.swing.JLabel date;
    private javax.swing.JLabel hours;
    private javax.swing.JLabel icon_logo;
    private javax.swing.JComboBox<String> jComboBox_View;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JLabel leccount;
    private javax.swing.JPanel lest_small;
    private javax.swing.JButton logout;
    private javax.swing.JPanel main_table_panel;
    private javax.swing.JLabel min;
    private javax.swing.JLabel numofdays;
    private javax.swing.JLabel o1;
    private javax.swing.JLabel o2;
    private javax.swing.JLabel o3;
    private javax.swing.JLabel o4;
    private javax.swing.JLabel o5;
    private javax.swing.JLabel o6;
    private javax.swing.JLabel o7;
    private javax.swing.JLabel time;
    // End of variables declaration//GEN-END:variables

}
