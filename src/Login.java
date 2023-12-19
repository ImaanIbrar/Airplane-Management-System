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

                frame = new javax.swing.JFrame();
                panel1 = new javax.swing.JPanel();
                usernameLabel = new javax.swing.JLabel();
                passwordLabel = new javax.swing.JLabel();
                loginBtn = new javax.swing.JButton();
                cancelBtn = new javax.swing.JButton();
                usernameText = new javax.swing.JTextField();
                paswordText = new javax.swing.JPasswordField();
                panel2 = new javax.swing.JPanel();
                loginLabel = new javax.swing.JLabel();
                panel3 = new javax.swing.JPanel();
                contactUsLabel = new javax.swing.JLabel();
                numberLabel = new javax.swing.JLabel();
                backgroundAdjustLabel1 = new javax.swing.JLabel();
                backgroundAdjustLabel2 = new javax.swing.JLabel();
                jskyIcon = new javax.swing.JLabel();
                instaIcon = new javax.swing.JLabel();
                linkedInIcon = new javax.swing.JLabel();

                javax.swing.GroupLayout frameLayout = new javax.swing.GroupLayout(frame.getContentPane());
                frame.getContentPane().setLayout(frameLayout);
                frameLayout.setHorizontalGroup(
                                frameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGap(0, 400, Short.MAX_VALUE));
                frameLayout.setVerticalGroup(
                                frameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGap(0, 300, Short.MAX_VALUE));
                setTitle("Login");
                setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

                panel1.setBackground(new java.awt.Color(151, 190, 190));
                // jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "",
                // javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
                // javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma",
                // 1, 18))); // NOI18N

                usernameLabel.setFont(new Font("Segoe UI", Font.BOLD, 20)); // NOI18N
                usernameLabel.setText("UserName");

                passwordLabel.setFont(new Font("Segoe UI", Font.BOLD, 20)); // NOI18N
                passwordLabel.setText("Password");

                loginBtn.setBackground(new java.awt.Color(0, 51, 51));
                loginBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
                loginBtn.setForeground(new java.awt.Color(255, 255, 255));
                loginBtn.setText("Login");
                loginBtn.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                loginBtnAction(evt);
                        }
                });

                cancelBtn.setBackground(new java.awt.Color(0, 51, 51));
                cancelBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
                cancelBtn.setForeground(new java.awt.Color(255, 255, 255));
                cancelBtn.setText("Cancel");
                cancelBtn.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                cancelBtnAction(evt);
                        }
                });

                panel2.setBackground(new java.awt.Color(0, 102, 102));

                loginLabel.setFont(new Font("Segoe UI", Font.BOLD, 35)); // NOI18N
                loginLabel.setForeground(new java.awt.Color(255, 255, 255));
                loginLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                loginLabel.setText("LOGIN");

                javax.swing.GroupLayout groupLayoutPanel2 = new javax.swing.GroupLayout(panel2);
                groupLayoutPanel2.setHorizontalGroup(
                                groupLayoutPanel2.createParallelGroup(Alignment.LEADING)
                                                .addGroup(Alignment.TRAILING, groupLayoutPanel2.createSequentialGroup()
                                                                .addContainerGap(660, Short.MAX_VALUE)
                                                                .addComponent(loginLabel, GroupLayout.PREFERRED_SIZE,
                                                                                231, GroupLayout.PREFERRED_SIZE)
                                                                .addGap(654)));
                groupLayoutPanel2.setVerticalGroup(
                                groupLayoutPanel2.createParallelGroup(Alignment.LEADING)
                                                .addGroup(Alignment.TRAILING, groupLayoutPanel2.createSequentialGroup()
                                                                .addContainerGap(22, Short.MAX_VALUE)
                                                                .addComponent(loginLabel)
                                                                .addGap(20)));
                panel2.setLayout(groupLayoutPanel2);

                panel3.setBackground(new java.awt.Color(0, 102, 102));

                contactUsLabel.setFont(new Font("Segoe UI", Font.BOLD, 22)); // NOI18N
                contactUsLabel.setForeground(new java.awt.Color(255, 255, 255));
                contactUsLabel.setText("CONTACT US");
                contactUsLabel.setToolTipText("");

                numberLabel.setFont(new java.awt.Font("Segoe UI Light", 1, 14)); // NOI18N
                numberLabel.setForeground(new java.awt.Color(255, 255, 255));
                numberLabel.setText("+51 789543");

                jskyIcon.setIcon(
                                new javax.swing.ImageIcon(getClass().getResource("/Screenshot 2022-07-06 000042.png"))); // NOI18N

                instaIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/insta.png"))); // NOI18N

                linkedInIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/twit.png"))); // NOI18N

                javax.swing.GroupLayout groupLayoutPanel3 = new javax.swing.GroupLayout(panel3);
                groupLayoutPanel3.setHorizontalGroup(
                                groupLayoutPanel3.createParallelGroup(Alignment.LEADING)
                                                .addGroup(groupLayoutPanel3.createSequentialGroup()
                                                                .addGroup(groupLayoutPanel3
                                                                                .createParallelGroup(Alignment.TRAILING)
                                                                                .addGroup(groupLayoutPanel3
                                                                                                .createSequentialGroup()
                                                                                                .addGap(19)
                                                                                                .addGroup(groupLayoutPanel3
                                                                                                                .createParallelGroup(
                                                                                                                                Alignment.LEADING)
                                                                                                                .addComponent(contactUsLabel,
                                                                                                                                GroupLayout.DEFAULT_SIZE,
                                                                                                                                GroupLayout.DEFAULT_SIZE,
                                                                                                                                Short.MAX_VALUE)
                                                                                                                .addComponent(numberLabel))
                                                                                                .addGap(534)
                                                                                                .addComponent(linkedInIcon)
                                                                                                .addPreferredGap(
                                                                                                                ComponentPlacement.UNRELATED))
                                                                                .addGroup(groupLayoutPanel3
                                                                                                .createSequentialGroup()
                                                                                                .addContainerGap(687,
                                                                                                                Short.MAX_VALUE)
                                                                                                .addComponent(backgroundAdjustLabel1)
                                                                                                .addGap(585)))
                                                                .addPreferredGap(ComponentPlacement.UNRELATED)
                                                                .addComponent(instaIcon)
                                                                .addGap(10)
                                                                .addGroup(groupLayoutPanel3
                                                                                .createParallelGroup(Alignment.LEADING)
                                                                                .addComponent(backgroundAdjustLabel2)
                                                                                .addComponent(jskyIcon))
                                                                .addGap(32)));
                groupLayoutPanel3.setVerticalGroup(
                                groupLayoutPanel3.createParallelGroup(Alignment.LEADING)
                                                .addGroup(groupLayoutPanel3.createSequentialGroup()
                                                                .addGroup(groupLayoutPanel3
                                                                                .createParallelGroup(Alignment.TRAILING)
                                                                                .addGroup(groupLayoutPanel3
                                                                                                .createSequentialGroup()
                                                                                                .addContainerGap()
                                                                                                .addComponent(instaIcon))
                                                                                .addGroup(Alignment.LEADING,
                                                                                                groupLayoutPanel3
                                                                                                                .createParallelGroup(
                                                                                                                                Alignment.LEADING)
                                                                                                                .addGroup(groupLayoutPanel3
                                                                                                                                .createSequentialGroup()
                                                                                                                                .addComponent(backgroundAdjustLabel2)
                                                                                                                                .addPreferredGap(
                                                                                                                                                ComponentPlacement.RELATED,
                                                                                                                                                GroupLayout.DEFAULT_SIZE,
                                                                                                                                                Short.MAX_VALUE)
                                                                                                                                .addComponent(linkedInIcon))
                                                                                                                .addGroup(groupLayoutPanel3
                                                                                                                                .createSequentialGroup()
                                                                                                                                .addContainerGap()
                                                                                                                                .addGroup(groupLayoutPanel3
                                                                                                                                                .createParallelGroup(
                                                                                                                                                                Alignment.TRAILING)
                                                                                                                                                .addComponent(jskyIcon)
                                                                                                                                                .addGroup(groupLayoutPanel3
                                                                                                                                                                .createSequentialGroup()
                                                                                                                                                                .addComponent(backgroundAdjustLabel1)
                                                                                                                                                                .addGap(14)
                                                                                                                                                                .addComponent(contactUsLabel)
                                                                                                                                                                .addPreferredGap(
                                                                                                                                                                                ComponentPlacement.UNRELATED)
                                                                                                                                                                .addComponent(numberLabel))))))
                                                                .addContainerGap(37, Short.MAX_VALUE)));
                panel3.setLayout(groupLayoutPanel3);

                javax.swing.GroupLayout groupLayoutPanel1 = new javax.swing.GroupLayout(panel1);
                groupLayoutPanel1.setHorizontalGroup(
                                groupLayoutPanel1.createParallelGroup(Alignment.LEADING)
                                                .addComponent(panel2, GroupLayout.DEFAULT_SIZE,
                                                                GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGroup(Alignment.TRAILING, groupLayoutPanel1.createSequentialGroup()
                                                                .addComponent(panel3, GroupLayout.DEFAULT_SIZE,
                                                                                GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)
                                                                .addContainerGap())
                                                .addGroup(Alignment.TRAILING, groupLayoutPanel1.createSequentialGroup()
                                                                .addContainerGap(609, Short.MAX_VALUE)
                                                                .addGroup(groupLayoutPanel1
                                                                                .createParallelGroup(Alignment.LEADING)
                                                                                .addGroup(Alignment.TRAILING,
                                                                                                groupLayoutPanel1
                                                                                                                .createSequentialGroup()
                                                                                                                .addGroup(groupLayoutPanel1
                                                                                                                                .createParallelGroup(
                                                                                                                                                Alignment.LEADING)
                                                                                                                                .addComponent(passwordLabel)
                                                                                                                                .addComponent(usernameLabel))
                                                                                                                .addGap(59))
                                                                                .addGroup(Alignment.TRAILING,
                                                                                                groupLayoutPanel1
                                                                                                                .createSequentialGroup()
                                                                                                                .addComponent(loginBtn,
                                                                                                                                GroupLayout.PREFERRED_SIZE,
                                                                                                                                115,
                                                                                                                                GroupLayout.PREFERRED_SIZE)
                                                                                                                .addPreferredGap(
                                                                                                                                ComponentPlacement.RELATED)))
                                                                .addGroup(groupLayoutPanel1
                                                                                .createParallelGroup(Alignment.LEADING)
                                                                                .addComponent(usernameText,
                                                                                                GroupLayout.PREFERRED_SIZE,
                                                                                                177,
                                                                                                GroupLayout.PREFERRED_SIZE)
                                                                                .addGroup(groupLayoutPanel1
                                                                                                .createSequentialGroup()
                                                                                                .addPreferredGap(
                                                                                                                ComponentPlacement.RELATED)
                                                                                                .addComponent(paswordText,
                                                                                                                GroupLayout.PREFERRED_SIZE,
                                                                                                                177,
                                                                                                                GroupLayout.PREFERRED_SIZE))
                                                                                .addGroup(groupLayoutPanel1
                                                                                                .createSequentialGroup()
                                                                                                .addGap(46)
                                                                                                .addComponent(cancelBtn,
                                                                                                                GroupLayout.PREFERRED_SIZE,
                                                                                                                116,
                                                                                                                GroupLayout.PREFERRED_SIZE)))
                                                                .addGap(602)));
                groupLayoutPanel1.setVerticalGroup(
                                groupLayoutPanel1.createParallelGroup(Alignment.LEADING)
                                                .addGroup(groupLayoutPanel1.createSequentialGroup()
                                                                .addComponent(panel2, GroupLayout.PREFERRED_SIZE, 89,
                                                                                GroupLayout.PREFERRED_SIZE)
                                                                .addGap(146)
                                                                .addGroup(groupLayoutPanel1
                                                                                .createParallelGroup(Alignment.BASELINE)
                                                                                .addComponent(usernameText,
                                                                                                GroupLayout.PREFERRED_SIZE,
                                                                                                GroupLayout.DEFAULT_SIZE,
                                                                                                GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(usernameLabel))
                                                                .addGap(41)
                                                                .addGroup(groupLayoutPanel1
                                                                                .createParallelGroup(Alignment.BASELINE)
                                                                                .addComponent(paswordText,
                                                                                                GroupLayout.PREFERRED_SIZE,
                                                                                                GroupLayout.DEFAULT_SIZE,
                                                                                                GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(passwordLabel))
                                                                .addGap(83)
                                                                .addGroup(groupLayoutPanel1
                                                                                .createParallelGroup(Alignment.BASELINE)
                                                                                .addComponent(loginBtn,
                                                                                                GroupLayout.PREFERRED_SIZE,
                                                                                                49,
                                                                                                GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(cancelBtn,
                                                                                                GroupLayout.PREFERRED_SIZE,
                                                                                                51,
                                                                                                GroupLayout.PREFERRED_SIZE))
                                                                .addPreferredGap(ComponentPlacement.RELATED, 154,
                                                                                Short.MAX_VALUE)
                                                                .addComponent(panel3, GroupLayout.PREFERRED_SIZE, 121,
                                                                                GroupLayout.PREFERRED_SIZE)));
                panel1.setLayout(groupLayoutPanel1);

                javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
                layout.setHorizontalGroup(
                                layout.createParallelGroup(Alignment.LEADING)
                                                .addGroup(layout.createSequentialGroup()
                                                                .addComponent(panel1, GroupLayout.PREFERRED_SIZE, 1545,
                                                                                GroupLayout.PREFERRED_SIZE)
                                                                .addContainerGap(GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)));
                layout.setVerticalGroup(
                                layout.createParallelGroup(Alignment.LEADING)
                                                .addComponent(panel1, GroupLayout.DEFAULT_SIZE, 741, Short.MAX_VALUE));
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

        private void loginBtnAction(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_loginBtnAction
                // TODO add your handling code here:

                String username = usernameText.getText();
                String password = paswordText.getText();

                if (username.isEmpty() || password.isEmpty()) {
                        JOptionPane.showMessageDialog(this, "UserName or Password Blank");
                } else {
                        try {
                                con = connectionManager.getConnection();
                                pst = con.prepareStatement("select * from user where username = ? and password = ?");
                                pst.setString(1, username);
                                pst.setString(2, password);

                                ResultSet rs;
                                rs = pst.executeQuery();

                                if (rs.next()) {
                                        this.dispose();
                                        admindomainObj = new admindomain();
                                        admindomainObj.setVisible(true);
                                } else {
                                        JOptionPane.showMessageDialog(this, "UserName or Password do not Match");
                                        usernameText.setText("");
                                        paswordText.setText("");
                                        usernameText.requestFocus();

                                }
                        } catch (SQLException ex) {
                                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                        } finally {
                                // Close the connection and other resources if needed
                                try {
                                        if (con != null) {
                                                con.close();
                                        }
                                        if (pst != null) {
                                                pst.close();
                                        }
                                } catch (SQLException ex) {
                                        Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                                }
                        }

                }

        }// GEN-LAST:event_loginBtnAction

        /**
         * Event handler for the "Cancel" button.
         * Disposes of the current frame and opens a new instance of the welcome class.
         *
         * @param evt The ActionEvent generated by the button click.
         */
        private void cancelBtnAction(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_cancelBtnAction
                // TODO add your handling code here:
                super.dispose();
                welcomeObj = new welcome();
                welcomeObj.setVisible(true);
        }// GEN-LAST:event_cancelBtnAction

        /**
         * @param args the command line arguments
         */

        // Variables declaration - do not modify//GEN-BEGIN:variables
        private javax.swing.JButton loginBtn;
        private javax.swing.JButton cancelBtn;
        private javax.swing.JFrame frame;
        private javax.swing.JLabel usernameLabel;
        private javax.swing.JLabel contactUsLabel;
        private javax.swing.JLabel passwordLabel;
        private javax.swing.JLabel backgroundAdjustLabel1;
        private javax.swing.JLabel numberLabel;
        private javax.swing.JLabel backgroundAdjustLabel2;
        private javax.swing.JLabel jskyIcon;
        private javax.swing.JLabel instaIcon;
        private javax.swing.JLabel linkedInIcon;
        private javax.swing.JLabel loginLabel;
        private javax.swing.JPanel panel1;
        private javax.swing.JPanel panel2;
        private javax.swing.JPanel panel3;
        private javax.swing.JPasswordField paswordText;
        private javax.swing.JTextField usernameText;
        private welcome welcomeObj;
        private admindomain admindomainObj;
        // End of variables declaration//GEN-END:variables
}
