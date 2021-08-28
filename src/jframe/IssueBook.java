/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jframe;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author Ashish
 */
public class IssueBook extends javax.swing.JFrame {

    /**
     * Creates new form IssueBook
     */
    public IssueBook() {
        initComponents();
    }
    
    //to fetch the book details from the database and display it to the book details panel
    public void getBookDetails(){
        int bookId = Integer.parseInt(txt_bookId.getText());
        
        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement pst = con.prepareStatement("select * from book_details where book_id = ?");
            pst.setInt(1, bookId);
            ResultSet rs = pst.executeQuery();
            
            if (rs.next()) {
                lbl_bookId.setText(rs.getString("book_id"));
                lbl_bookName.setText(rs.getString("book_name"));
                lbl_author.setText(rs.getString("author"));
                lbl_quantity.setText(rs.getString("quantity"));
            }else{
                lbl_bookError.setText("Invalid Book ID");
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    
        //to fetch the Student details from the database and display it to the Student details panel
    public void getStudentDetails(){
        int studentId = Integer.parseInt(txt_studentId.getText());
        
        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement pst = con.prepareStatement("select * from student_details where student_id = ?");
            pst.setInt(1, studentId);
            ResultSet rs = pst.executeQuery();
            
            if (rs.next()) {
                lbl_studentId.setText(rs.getString("student_id"));
                lbl_studentName.setText(rs.getString("name"));
                lbl_course.setText(rs.getString("course"));
                lbl_branch.setText(rs.getString("branch"));
            }else{
                lbl_studentError.setText("Invalid Student ID");
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    
    //insert issue book details to databse
    public boolean issueBook(){
        boolean isIssued = false;
        int bookId = Integer.parseInt(txt_bookId.getText());
        int studentId = Integer.parseInt(txt_studentId.getText());
        String bookName = lbl_bookName.getText();
        String studentName = lbl_studentName.getText();
        
        Date uIssueDate = date_issueDate.getDatoFecha();
        Date uDueDate = date_dueDate.getDatoFecha();
        
        Long l1 = uIssueDate.getTime();
        Long l2 = uDueDate.getTime();
        
        java.sql.Date sIssueDate = new java.sql.Date(l1);
        java.sql.Date sdueDate = new java.sql.Date(l2);
        
        try {
            Connection con = DBConnection.getConnection();
            String sql = "insert into issue_book_details(book_id,book_name,student_id,student_name,issue_date,due_date,status) values(?,?,?,?,?,?,?)";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, bookId);
            pst.setString(2, bookName);
            pst.setInt(3, studentId);
            pst.setString(4, studentName);
            pst.setDate(5, sIssueDate);
            pst.setDate(6, sdueDate);
            pst.setString(7, "pending");
            
            int rowCount = pst.executeUpdate();
            if (rowCount > 0) {
                isIssued = true;
            }else{
                isIssued = false;
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isIssued;
        
    }
    
    //Updating Book Count
    public void updateBookCount(){
        int bookId = Integer.parseInt(txt_bookId.getText());
        
        try {
            Connection con = DBConnection.getConnection();
            String sql = "update book_details set quantity = quantity - 1 where book_id = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, bookId);
            
            int rowCount = pst.executeUpdate();
            if (rowCount > 0) {
                JOptionPane.showMessageDialog(this, "Book Count Updated");
                int initialCount = Integer.parseInt(lbl_quantity.getText());
                lbl_quantity.setText(Integer.toString(initialCount - 1));
            }else{
                JOptionPane.showMessageDialog(this, " Can't Update Book Count");
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    //Checking whether book is already allocated or not
    public boolean isAlreadyIssued(){
        
        boolean isAlreadyIssued = false;
        int bookId = Integer.parseInt(txt_bookId.getText());
        int studentId = Integer.parseInt(txt_studentId.getText());
        
        try {
            Connection con = DBConnection.getConnection();
            String sql = "select * from issue_book_details where book_id = ? and student_id = ? and status = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, bookId);
            pst.setInt(2, studentId);
            pst.setString(3, "pending");
            
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                isAlreadyIssued = true;
            }else{
                isAlreadyIssued = false;
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isAlreadyIssued;
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel_main = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        lbl_studentError = new javax.swing.JLabel();
        lbl_branch = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        lbl_studentId = new javax.swing.JLabel();
        lbl_studentName = new javax.swing.JLabel();
        lbl_course = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        lbl_bookError = new javax.swing.JLabel();
        lbl_quantity = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        lbl_bookId = new javax.swing.JLabel();
        lbl_bookName = new javax.swing.JLabel();
        lbl_author = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txt_bookId = new app.bolivia.swing.JCTextField();
        jLabel11 = new javax.swing.JLabel();
        txt_studentId = new app.bolivia.swing.JCTextField();
        date_issueDate = new rojeru_san.componentes.RSDateChooser();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        date_dueDate = new rojeru_san.componentes.RSDateChooser();
        issueButton = new rojerusan.RSMaterialButtonCircle();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panel_main.setBackground(new java.awt.Color(255, 255, 255));
        panel_main.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(51, 102, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Yu Gothic Medium", 1, 30)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/AddNewBookIcons/icons8_Student_Registration_100px_2.png"))); // NOI18N
        jLabel3.setText(" Student Details");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 370, 100));

        lbl_studentError.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        lbl_studentError.setForeground(new java.awt.Color(255, 204, 0));
        jPanel1.add(lbl_studentError, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 530, 190, 40));

        lbl_branch.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        lbl_branch.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(lbl_branch, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 460, 220, 30));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Student Name :");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 340, 130, -1));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Course :");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 390, 70, 40));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Student ID :");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 280, 100, -1));

        lbl_studentId.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        lbl_studentId.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(lbl_studentId, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 280, 220, 30));

        lbl_studentName.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        lbl_studentName.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(lbl_studentName, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 340, 220, 30));

        lbl_course.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        lbl_course.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(lbl_course, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 400, 220, 30));

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 380, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 380, 5));

        jLabel17.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Branch :");
        jPanel1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 450, 70, 40));

        panel_main.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 0, 400, 660));

        jPanel3.setBackground(new java.awt.Color(255, 0, 51));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(51, 102, 255));

        jLabel2.setFont(new java.awt.Font("Yu Gothic Medium", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/AddNewBookIcons/icons8_Rewind_48px.png"))); // NOI18N
        jLabel2.setText("Back");
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 39, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel3.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 110, 40));

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 380, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel3.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 380, 5));

        lbl_bookError.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        lbl_bookError.setForeground(new java.awt.Color(255, 204, 0));
        jPanel3.add(lbl_bookError, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 540, 210, 40));

        lbl_quantity.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        lbl_quantity.setForeground(new java.awt.Color(255, 255, 255));
        jPanel3.add(lbl_quantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 460, 220, 30));

        jLabel20.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("Book Name :");
        jPanel3.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 334, 110, 40));

        jLabel21.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("Author :");
        jPanel3.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 394, 70, 40));

        jLabel22.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("Book ID :");
        jPanel3.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 270, 80, 40));

        lbl_bookId.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        lbl_bookId.setForeground(new java.awt.Color(255, 255, 255));
        jPanel3.add(lbl_bookId, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 280, 220, 30));

        lbl_bookName.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        lbl_bookName.setForeground(new java.awt.Color(255, 255, 255));
        jPanel3.add(lbl_bookName, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 340, 220, 30));

        lbl_author.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        lbl_author.setForeground(new java.awt.Color(255, 255, 255));
        jPanel3.add(lbl_author, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 400, 220, 30));

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("Yu Gothic Medium", 1, 30)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/AddNewBookIcons/icons8_Literature_100px_1.png"))); // NOI18N
        jLabel6.setText(" Book Details");
        jPanel3.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 70, 330, 100));

        jLabel19.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Quantity :");
        jPanel3.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 454, 90, 40));

        panel_main.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 660));

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Yu Gothic Medium", 1, 30)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/AddNewBookIcons/icons8_Student_Registration_100px_2.png"))); // NOI18N
        jLabel5.setText(" Student Details");
        panel_main.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 370, 100));

        jLabel4.setBackground(new java.awt.Color(255, 0, 51));
        jLabel4.setFont(new java.awt.Font("Yu Gothic Medium", 1, 20)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 0, 51));
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/AddNewBookIcons/icons8_Books_52px_1.png"))); // NOI18N
        jLabel4.setText(" Book Details");
        panel_main.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 110, 200, -1));

        jPanel5.setBackground(new java.awt.Color(255, 0, 51));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 320, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        panel_main.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 180, 320, 5));

        jPanel8.setBackground(new java.awt.Color(51, 102, 255));

        jLabel7.setFont(new java.awt.Font("Verdana", 1, 30)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText(" X");
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel7MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        panel_main.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 0, 60, 40));

        jLabel9.setFont(new java.awt.Font("Segoe UI Semibold", 0, 17)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 0, 51));
        jLabel9.setText("Enter Book ID :");
        panel_main.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 220, 120, -1));

        txt_bookId.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 0, 51)));
        txt_bookId.setFont(new java.awt.Font("Times New Roman", 1, 17)); // NOI18N
        txt_bookId.setPlaceholder("Enter Book ID.....");
        txt_bookId.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_bookIdFocusLost(evt);
            }
        });
        txt_bookId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_bookIdActionPerformed(evt);
            }
        });
        panel_main.add(txt_bookId, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 210, 170, 40));

        jLabel11.setFont(new java.awt.Font("Segoe UI Semibold", 0, 17)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 0, 51));
        jLabel11.setText("Issued Date :");
        panel_main.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 360, 100, -1));

        txt_studentId.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 0, 51)));
        txt_studentId.setFont(new java.awt.Font("Times New Roman", 1, 17)); // NOI18N
        txt_studentId.setPlaceholder("Enter Student ID.....");
        txt_studentId.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_studentIdFocusLost(evt);
            }
        });
        txt_studentId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_studentIdActionPerformed(evt);
            }
        });
        panel_main.add(txt_studentId, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 280, 170, 40));

        date_issueDate.setColorBackground(new java.awt.Color(255, 0, 51));
        date_issueDate.setColorForeground(new java.awt.Color(255, 0, 51));
        date_issueDate.setFuente(new java.awt.Font("Yu Gothic UI Semibold", 1, 17)); // NOI18N
        date_issueDate.setPlaceholder("Select Issued Date");
        panel_main.add(date_issueDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 400, 280, 40));

        jLabel15.setFont(new java.awt.Font("Segoe UI Semibold", 0, 17)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 0, 51));
        jLabel15.setText("Enter Student ID :");
        panel_main.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 290, 140, -1));

        jLabel16.setFont(new java.awt.Font("Segoe UI Semibold", 0, 17)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 0, 51));
        jLabel16.setText("Due Date :");
        panel_main.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 480, 100, -1));

        date_dueDate.setColorBackground(new java.awt.Color(255, 0, 51));
        date_dueDate.setColorForeground(new java.awt.Color(255, 0, 51));
        date_dueDate.setFuente(new java.awt.Font("Yu Gothic UI Semibold", 1, 17)); // NOI18N
        date_dueDate.setPlaceholder("Select Due Date");
        panel_main.add(date_dueDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 520, 280, 40));

        issueButton.setBackground(new java.awt.Color(255, 0, 51));
        issueButton.setText("Issue Book");
        issueButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                issueButtonActionPerformed(evt);
            }
        });
        panel_main.add(issueButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 580, 300, 70));

        getContentPane().add(panel_main, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1150, 660));

        setSize(new java.awt.Dimension(1150, 660));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        HomePage home = new HomePage();
        home.setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabel2MouseClicked

    private void jLabel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseClicked
        System.exit(0);
    }//GEN-LAST:event_jLabel7MouseClicked

    private void txt_bookIdFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_bookIdFocusLost
        if (!txt_bookId.getText().equals("")) {
            getBookDetails();
        }
        
    }//GEN-LAST:event_txt_bookIdFocusLost

    private void txt_bookIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_bookIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_bookIdActionPerformed

    private void txt_studentIdFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_studentIdFocusLost
        if (!txt_studentId.getText().equals("")) {
            getStudentDetails();
        }
    }//GEN-LAST:event_txt_studentIdFocusLost

    private void txt_studentIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_studentIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_studentIdActionPerformed

    private void issueButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_issueButtonActionPerformed
        
        if (lbl_quantity.getText().equals("0")) {
            JOptionPane.showMessageDialog(this, "Book is not available");
        }else{
            if (isAlreadyIssued() == false) {
            if (issueBook()== true) {
            JOptionPane.showMessageDialog(this, "Book Issued Successfully");
            updateBookCount();
        }else{
            JOptionPane.showMessageDialog(this, "Can't Issue the book");
        }
        }else{
            JOptionPane.showMessageDialog(this, "This Student Already Have This book");
        }
        }
        
    }//GEN-LAST:event_issueButtonActionPerformed

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
            java.util.logging.Logger.getLogger(IssueBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(IssueBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(IssueBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IssueBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new IssueBook().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rojeru_san.componentes.RSDateChooser date_dueDate;
    private rojeru_san.componentes.RSDateChooser date_issueDate;
    private rojerusan.RSMaterialButtonCircle issueButton;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
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
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JLabel lbl_author;
    private javax.swing.JLabel lbl_bookError;
    private javax.swing.JLabel lbl_bookId;
    private javax.swing.JLabel lbl_bookName;
    private javax.swing.JLabel lbl_branch;
    private javax.swing.JLabel lbl_course;
    private javax.swing.JLabel lbl_quantity;
    private javax.swing.JLabel lbl_studentError;
    private javax.swing.JLabel lbl_studentId;
    private javax.swing.JLabel lbl_studentName;
    private javax.swing.JPanel panel_main;
    private app.bolivia.swing.JCTextField txt_bookId;
    private app.bolivia.swing.JCTextField txt_studentId;
    // End of variables declaration//GEN-END:variables
}
