import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Represents the login window of the application.
 * Allows users to log in by entering a username and password.
 * On successful login, navigates to the admin domain window.
 * Handles potential errors and displays appropriate messages.
 *
 * @author Marriam Naeem
 * @version 1.0
 * @since 2023-11-21
 */

public class Login extends javax.swing.JFrame {
	

    /**
     * Creates new form Login
     */
    public Login() {
        initComponents();
        setExtendedState(JFrame.MAXIMIZED_BOTH);
    }

    // Instance variables
    Connection con;
    PreparedStatement pst;

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFrame1 = new javax.swing.JFrame();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        txtuser = new javax.swing.JTextField();
        txtpass = new javax.swing.JPasswordField();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();

        javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
                jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 400, Short.MAX_VALUE));
        jFrame1Layout.setVerticalGroup(
                jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 300, Short.MAX_VALUE));
        setTitle("Login");
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(151, 190, 190));
        // jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "",
        // javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
        // javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma",
        // 1, 18))); // NOI18N

        jLabel1.setFont(new Font("Segoe UI", Font.BOLD, 20)); // NOI18N
        jLabel1.setText("UserName");

        jLabel2.setFont(new Font("Segoe UI", Font.BOLD, 20)); // NOI18N
        jLabel2.setText("Password");

        jButton1.setBackground(new java.awt.Color(0, 51, 51));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Login");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(0, 51, 51));
        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Cancel");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(0, 102, 102));

        jLabel3.setFont(new Font("Segoe UI", Font.BOLD, 35)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("LOGIN");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2Layout.setHorizontalGroup(
        	jPanel2Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
        			.addContainerGap(660, Short.MAX_VALUE)
        			.addComponent(jLabel3, GroupLayout.PREFERRED_SIZE, 231, GroupLayout.PREFERRED_SIZE)
        			.addGap(654))
        );
        jPanel2Layout.setVerticalGroup(
        	jPanel2Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
        			.addContainerGap(22, Short.MAX_VALUE)
        			.addComponent(jLabel3)
        			.addGap(20))
        );
        jPanel2.setLayout(jPanel2Layout);

        jPanel7.setBackground(new java.awt.Color(0, 102, 102));

        jLabel11.setFont(new Font("Segoe UI", Font.BOLD, 22)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("CONTACT US");
        jLabel11.setToolTipText("");

        jLabel22.setFont(new java.awt.Font("Segoe UI Light", 1, 14)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("+51 789543");

        jLabel25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Screenshot 2022-07-06 000042.png"))); // NOI18N

        jLabel26.setIcon(new javax.swing.ImageIcon(getClass().getResource("/insta.png"))); // NOI18N

        jLabel27.setIcon(new javax.swing.ImageIcon(getClass().getResource("/twit.png"))); // NOI18N

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7Layout.setHorizontalGroup(
        	jPanel7Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jPanel7Layout.createSequentialGroup()
        			.addGroup(jPanel7Layout.createParallelGroup(Alignment.TRAILING)
        				.addGroup(jPanel7Layout.createSequentialGroup()
        					.addGap(19)
        					.addGroup(jPanel7Layout.createParallelGroup(Alignment.LEADING)
        						.addComponent(jLabel11, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        						.addComponent(jLabel22))
        					.addGap(534)
        					.addComponent(jLabel27)
        					.addPreferredGap(ComponentPlacement.UNRELATED))
        				.addGroup(jPanel7Layout.createSequentialGroup()
        					.addContainerGap(687, Short.MAX_VALUE)
        					.addComponent(jLabel21)
        					.addGap(585)))
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addComponent(jLabel26)
        			.addGap(10)
        			.addGroup(jPanel7Layout.createParallelGroup(Alignment.LEADING)
        				.addComponent(jLabel24)
        				.addComponent(jLabel25))
        			.addGap(32))
        );
        jPanel7Layout.setVerticalGroup(
        	jPanel7Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jPanel7Layout.createSequentialGroup()
        			.addGroup(jPanel7Layout.createParallelGroup(Alignment.TRAILING)
        				.addGroup(jPanel7Layout.createSequentialGroup()
        					.addContainerGap()
        					.addComponent(jLabel26))
        				.addGroup(Alignment.LEADING, jPanel7Layout.createParallelGroup(Alignment.LEADING)
        					.addGroup(jPanel7Layout.createSequentialGroup()
        						.addComponent(jLabel24)
        						.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        						.addComponent(jLabel27))
        					.addGroup(jPanel7Layout.createSequentialGroup()
        						.addContainerGap()
        						.addGroup(jPanel7Layout.createParallelGroup(Alignment.TRAILING)
        							.addComponent(jLabel25)
        							.addGroup(jPanel7Layout.createSequentialGroup()
        								.addComponent(jLabel21)
        								.addGap(14)
        								.addComponent(jLabel11)
        								.addPreferredGap(ComponentPlacement.UNRELATED)
        								.addComponent(jLabel22))))))
        			.addContainerGap(37, Short.MAX_VALUE))
        );
        jPanel7.setLayout(jPanel7Layout);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1Layout.setHorizontalGroup(
        	jPanel1Layout.createParallelGroup(Alignment.LEADING)
        		.addComponent(jPanel2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        		.addGroup(Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
        			.addComponent(jPanel7, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        			.addContainerGap())
        		.addGroup(Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
        			.addContainerGap(609, Short.MAX_VALUE)
        			.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
        					.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
        						.addComponent(jLabel2)
        						.addComponent(jLabel1))
        					.addGap(59))
        				.addGroup(Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
        					.addComponent(jButton1, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)
        					.addPreferredGap(ComponentPlacement.RELATED)))
        			.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
        				.addComponent(txtuser, GroupLayout.PREFERRED_SIZE, 177, GroupLayout.PREFERRED_SIZE)
        				.addGroup(jPanel1Layout.createSequentialGroup()
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addComponent(txtpass, GroupLayout.PREFERRED_SIZE, 177, GroupLayout.PREFERRED_SIZE))
        				.addGroup(jPanel1Layout.createSequentialGroup()
        					.addGap(46)
        					.addComponent(jButton2, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE)))
        			.addGap(602))
        );
        jPanel1Layout.setVerticalGroup(
        	jPanel1Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jPanel1Layout.createSequentialGroup()
        			.addComponent(jPanel2, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
        			.addGap(146)
        			.addGroup(jPanel1Layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(txtuser, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        				.addComponent(jLabel1))
        			.addGap(41)
        			.addGroup(jPanel1Layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(txtpass, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        				.addComponent(jLabel2))
        			.addGap(83)
        			.addGroup(jPanel1Layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(jButton1, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
        				.addComponent(jButton2, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE))
        			.addPreferredGap(ComponentPlacement.RELATED, 154, Short.MAX_VALUE)
        			.addComponent(jPanel7, GroupLayout.PREFERRED_SIZE, 121, GroupLayout.PREFERRED_SIZE))
        );
        jPanel1.setLayout(jPanel1Layout);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        layout.setHorizontalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, 1545, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, 741, Short.MAX_VALUE)
        );
        getContentPane().setLayout(layout);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Event handler for the "Login" button.
     * Retrieves the entered username and password, validates them against the
     * database.
     * If successful, opens the admin domain window; otherwise, displays an error
     * message.
     *
     * @param evt The ActionEvent generated by the button click.
     * @throws ClassNotFoundException If the JDBC driver class is not found.
     * @throws SQLException           If a SQL exception occurs while interacting
     *                                with the database.
     */

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:

        String username = txtuser.getText();
        String password = txtpass.getText();

        if (username.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(this, "UserName or Password Blank");
        } else {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost/airline", "root", "1234");
                pst = con.prepareStatement("select * from user where username = ? and password = ?");
                pst.setString(1, username);
                pst.setString(2, password);

                ResultSet rs;
                rs = pst.executeQuery();

                if (rs.next()) {
                    this.dispose();
                    A1 = new admindomain();
                    A1.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(this, "UserName or Password do not Match");
                    txtuser.setText("");
                    txtpass.setText("");
                    txtuser.requestFocus();

                }

            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }// GEN-LAST:event_jButton1ActionPerformed

    /**
     * Event handler for the "Cancel" button.
     * Disposes of the current frame and opens a new instance of the welcome class.
     *
     * @param evt The ActionEvent generated by the button click.
     */
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        super.dispose();
        W1 = new welcome();
        W1.setVisible(true);
    }// GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPasswordField txtpass;
    private javax.swing.JTextField txtuser;
    private welcome W1;
    private admindomain A1;
    // End of variables declaration//GEN-END:variables
}
