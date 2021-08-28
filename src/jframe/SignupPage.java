/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jframe;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author Ashish
 */
public class SignupPage extends javax.swing.JFrame {

    /**
     * Creates new form SignupPage
     */
    public SignupPage() {
        initComponents();
    }

    //method to insert values into users table
    public void insertSingupDetails() {
        String name = txt_username.getText();
        String pwd = txt_password.getText();
        String email = txt_email.getText();
        String contact = txt_contact.getText();
        
        try {
            Connection con = DBConnection.getConnection();
            String sql = "insert into users(name,password,email,contact) values(?,?,?,?)";
            PreparedStatement pst = con.prepareStatement(sql);
            
            pst.setString(1, name);
            pst.setString(2, pwd);
            pst.setString(3, email);
            pst.setString(4, contact);
            
            int updateRowCount = pst.executeUpdate();
            
            if (updateRowCount > 0) {
                JOptionPane.showMessageDialog(this, "Recorded Inserted Successfull");
                LoginPage page = new LoginPage();
                page.setVisible(true);
                dispose();
                
            }else{
                JOptionPane.showMessageDialog(this, "Recorded Inserted Failure");
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    //Validation
    
    public boolean validateSignup(){
        String name = txt_username.getText();
        String pwd = txt_password.getText();
        String email = txt_email.getText();
        String contact = txt_contact.getText();
        
        if (name.equals("")) {
            JOptionPane.showMessageDialog(this, "Please Enter Username");
            return false;
        }
        
        if (pwd.equals("")) {
            JOptionPane.showMessageDialog(this, "Please Enter Password");
            return false;
        }
        
        if (email.equals("") || !email.matches("^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$")) {
            JOptionPane.showMessageDialog(this, "Please Enter Valid Email");
            return false;
        }
        
        if (contact.equals("")) {
            JOptionPane.showMessageDialog(this, "Please Enter Contact Number");
            return false;
        }
        return true;
        
    }
    
    //Check duplicate users
    public boolean checkDuplicateUser(){
        String name = txt_username.getText();
        boolean isExist = false;
        
        try {
            Connection con = DBConnection.getConnection();
            
            PreparedStatement pst = con.prepareStatement("select * from users where name = ?");
            pst.setString(1, name);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                isExist = true;
            }else{
                isExist = false;
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isExist;
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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txt_username = new app.bolivia.swing.JCTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txt_password = new app.bolivia.swing.JCTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txt_email = new app.bolivia.swing.JCTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        txt_contact = new app.bolivia.swing.JCTextField();
        rSMaterialButtonCircle1 = new necesario.RSMaterialButtonCircle();
        rSMaterialButtonCircle2 = new necesario.RSMaterialButtonCircle();
        jLabel16 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 255));
        jLabel1.setText("ASHISH");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 10, 110, -1));

        jLabel2.setFont(new java.awt.Font("Sitka Display", 0, 30)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 255));
        jLabel2.setText("UNIQUE LIBRARY");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 110, 270, -1));

        jLabel3.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 0, 15));
        jLabel3.setText("DEVELOPER");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 120, -1));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons/signup-library-icon.png"))); // NOI18N
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, 810, 580));

        jLabel6.setFont(new java.awt.Font("Sitka Display", 0, 30)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 0, 127));
        jLabel6.setText("Welcome To");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 70, 160, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 780, 730));

        jPanel2.setBackground(new java.awt.Color(51, 102, 255));
        jPanel2.setFont(new java.awt.Font("Times New Roman", 0, 11)); // NOI18N
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons/icons8_Account_50px.png"))); // NOI18N
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, -1, 50));

        jLabel7.setFont(new java.awt.Font("Microsoft JhengHei", 1, 30)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("X");
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel7MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 0, 40, -1));

        jLabel8.setFont(new java.awt.Font("Segoe UI Semibold", 1, 17)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Create New Account Here");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 80, 240, -1));

        txt_username.setBackground(new java.awt.Color(51, 102, 255));
        txt_username.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        txt_username.setFont(new java.awt.Font("Times New Roman", 1, 17)); // NOI18N
        txt_username.setPlaceholder("Enter Username....");
        txt_username.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_usernameFocusLost(evt);
            }
        });
        txt_username.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_usernameActionPerformed(evt);
            }
        });
        jPanel2.add(txt_username, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 150, -1, -1));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Username");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 120, 240, -1));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons/icons8_Secure_50px.png"))); // NOI18N
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 210, -1, 50));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Password");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 200, 240, -1));

        txt_password.setBackground(new java.awt.Color(51, 102, 255));
        txt_password.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        txt_password.setFont(new java.awt.Font("Times New Roman", 1, 17)); // NOI18N
        txt_password.setPlaceholder("Enter Password....");
        txt_password.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_passwordActionPerformed(evt);
            }
        });
        jPanel2.add(txt_password, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 230, -1, -1));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons/icons8_Secured_Letter_50px.png"))); // NOI18N
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 320, -1, 50));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText(" Email ID");
        jPanel2.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 300, 240, 30));

        txt_email.setBackground(new java.awt.Color(51, 102, 255));
        txt_email.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        txt_email.setFont(new java.awt.Font("Times New Roman", 1, 17)); // NOI18N
        txt_email.setPlaceholder("Enter Email Id....");
        txt_email.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_emailActionPerformed(evt);
            }
        });
        jPanel2.add(txt_email, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 340, -1, -1));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons/icons8_Google_Mobile_50px.png"))); // NOI18N
        jPanel2.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 410, -1, 50));

        jLabel15.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Contact");
        jPanel2.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 400, 240, -1));

        txt_contact.setBackground(new java.awt.Color(51, 102, 255));
        txt_contact.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        txt_contact.setFont(new java.awt.Font("Times New Roman", 1, 17)); // NOI18N
        txt_contact.setPlaceholder("Enter Contact Number...");
        txt_contact.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_contactActionPerformed(evt);
            }
        });
        jPanel2.add(txt_contact, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 430, -1, -1));

        rSMaterialButtonCircle1.setBackground(new java.awt.Color(0, 0, 204));
        rSMaterialButtonCircle1.setText("login");
        rSMaterialButtonCircle1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rSMaterialButtonCircle1MouseClicked(evt);
            }
        });
        jPanel2.add(rSMaterialButtonCircle1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 550, 310, 70));

        rSMaterialButtonCircle2.setBackground(new java.awt.Color(255, 0, 0));
        rSMaterialButtonCircle2.setText("SignUp");
        rSMaterialButtonCircle2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonCircle2ActionPerformed(evt);
            }
        });
        jPanel2.add(rSMaterialButtonCircle2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 480, 310, 70));

        jLabel16.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 25)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Signup Page");
        jPanel2.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 50, 160, -1));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 0, 500, 730));

        setSize(new java.awt.Dimension(1277, 828));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txt_usernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_usernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_usernameActionPerformed

    private void txt_passwordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_passwordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_passwordActionPerformed

    private void txt_emailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_emailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_emailActionPerformed

    private void txt_contactActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_contactActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_contactActionPerformed

    private void rSMaterialButtonCircle2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle2ActionPerformed
        if (validateSignup() == true) {
            if (checkDuplicateUser() == false) {
              insertSingupDetails();  
            }else{
                JOptionPane.showMessageDialog(this, "Username already exist");
            }
            
        }
        
    }//GEN-LAST:event_rSMaterialButtonCircle2ActionPerformed

    private void jLabel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseClicked
        System.exit(0);
    }//GEN-LAST:event_jLabel7MouseClicked

    private void txt_usernameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_usernameFocusLost
        if (checkDuplicateUser() == true) {
            JOptionPane.showMessageDialog(this, "Username already exist");
        }
    }//GEN-LAST:event_txt_usernameFocusLost

    private void rSMaterialButtonCircle1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle1MouseClicked
        LoginPage login = new LoginPage();
        login.setVisible(true);
        dispose();
    }//GEN-LAST:event_rSMaterialButtonCircle1MouseClicked

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
            java.util.logging.Logger.getLogger(SignupPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SignupPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SignupPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SignupPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SignupPage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
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
    private necesario.RSMaterialButtonCircle rSMaterialButtonCircle1;
    private necesario.RSMaterialButtonCircle rSMaterialButtonCircle2;
    private app.bolivia.swing.JCTextField txt_contact;
    private app.bolivia.swing.JCTextField txt_email;
    private app.bolivia.swing.JCTextField txt_password;
    private app.bolivia.swing.JCTextField txt_username;
    // End of variables declaration//GEN-END:variables
}