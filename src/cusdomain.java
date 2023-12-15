/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

import java.awt.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import javax.swing.DropMode;

/**
 * Represents the customer domain window of the application.
 * Provides options for customers to perform various actions such as making a
 * booking,
 * registering, updating and canceling a booking, viewing a ticket, and
 * navigating to the main menu.
 * Constantly monitored by the main server.
 *
 * @author laiba atiq
 * @version 1.0
 * @since 2023-11-21
 */
public class cusdomain extends javax.swing.JFrame {

    /**
     * Creates new form cusdomain
     */
    public cusdomain() {
        initComponents();
        setExtendedState(JFrame.MAXIMIZED_BOTH);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel1 = new javax.swing.JPanel();
        panel2 = new javax.swing.JPanel();
        imgPK = new javax.swing.JLabel();
        panel4 = new javax.swing.JPanel();
        panel5 = new javax.swing.JPanel();
        panel6 = new javax.swing.JPanel();
        contactUsLabel = new javax.swing.JLabel();
        numberLabel = new javax.swing.JLabel();
        instaIcon = new javax.swing.JLabel();
        linkedInIncon = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        seperator = new javax.swing.JSeparator();
        makeBookingbtn = new javax.swing.JButton();
        registerBtn = new javax.swing.JButton();
        mainMenuBtn = new javax.swing.JButton();
        updateBookingBtn = new javax.swing.JButton();
        cancelBookingBtn = new javax.swing.JButton();
        passangerLabel = new javax.swing.JLabel();
        passangerLabel.setVerticalAlignment(SwingConstants.TOP);
        warningLabel = new javax.swing.JLabel();
        viewTicketBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panel2.setBackground(new java.awt.Color(0, 102, 102));

        imgPK.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pk.png"))); // NOI18N
        imgPK.setText("jLabel1");

        JLabel Company_name = new JLabel("JSKY ");
        Company_name.setForeground(new Color(255, 255, 255));
        Company_name.setFont(new Font("Tahoma", Font.BOLD, 40));

        JLabel logoslogan = new JLabel("Travel in Style");
        logoslogan.setFont(new Font("Tahoma", Font.PLAIN, 15));
        logoslogan.setForeground(new Color(255, 255, 255));

        javax.swing.GroupLayout groupLayoutPanel2 = new javax.swing.GroupLayout(panel2);
        groupLayoutPanel2.setHorizontalGroup(
                groupLayoutPanel2.createParallelGroup(Alignment.TRAILING)
                        .addGroup(groupLayoutPanel2.createSequentialGroup()
                                .addGap(29)
                                .addGroup(groupLayoutPanel2.createParallelGroup(Alignment.LEADING)
                                        .addComponent(logoslogan, GroupLayout.PREFERRED_SIZE, 139,
                                                GroupLayout.PREFERRED_SIZE)
                                        .addComponent(Company_name, GroupLayout.PREFERRED_SIZE, 128,
                                                GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(ComponentPlacement.RELATED, 1245, Short.MAX_VALUE)
                                .addComponent(imgPK, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
                                .addGap(41)));
        groupLayoutPanel2.setVerticalGroup(
                groupLayoutPanel2.createParallelGroup(Alignment.LEADING)
                        .addGroup(groupLayoutPanel2.createSequentialGroup()
                                .addGap(24)
                                .addComponent(Company_name, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(ComponentPlacement.RELATED)
                                .addComponent(logoslogan)
                                .addContainerGap(22, Short.MAX_VALUE))
                        .addGroup(Alignment.TRAILING, groupLayoutPanel2.createSequentialGroup()
                                .addContainerGap(34, Short.MAX_VALUE)
                                .addComponent(imgPK)
                                .addContainerGap()));
        panel2.setLayout(groupLayoutPanel2);

        panel4.setBackground(new java.awt.Color(151, 190, 190));

        panel5.setBackground(new java.awt.Color(0, 102, 102));

        javax.swing.GroupLayout groupLayoutPanel5 = new javax.swing.GroupLayout(panel5);
        groupLayoutPanel5.setHorizontalGroup(
                groupLayoutPanel5.createParallelGroup(Alignment.TRAILING)
                        .addGap(0, 1514, Short.MAX_VALUE));
        groupLayoutPanel5.setVerticalGroup(
                groupLayoutPanel5.createParallelGroup(Alignment.TRAILING)
                        .addGap(0, 86, Short.MAX_VALUE));
        panel5.setLayout(groupLayoutPanel5);

        panel6.setBackground(new java.awt.Color(0, 102, 102));

        contactUsLabel.setFont(new Font("Segoe UI", Font.BOLD, 20)); // NOI18N
        contactUsLabel.setForeground(new java.awt.Color(255, 255, 255));
        contactUsLabel.setText("CONTACT US");
        contactUsLabel.setToolTipText("");

        numberLabel.setFont(new java.awt.Font("Segoe UI Light", 1, 14)); // NOI18N
        numberLabel.setForeground(new java.awt.Color(255, 255, 255));
        numberLabel.setText("+51 789543");

        instaIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("insta.png"))); // NOI18N

        linkedInIncon.setIcon(new javax.swing.ImageIcon(getClass().getResource("twit.png"))); // NOI18N
        linkedInIncon.setToolTipText("");

        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Screenshot 2022-07-06 000042.png"))); // NOI18N

        javax.swing.GroupLayout groupLayoutPanel6 = new javax.swing.GroupLayout(panel6);
        groupLayoutPanel6.setHorizontalGroup(
                groupLayoutPanel6.createParallelGroup(Alignment.LEADING)
                        .addGroup(groupLayoutPanel6.createSequentialGroup()
                                .addGroup(groupLayoutPanel6.createParallelGroup(Alignment.LEADING)
                                        .addGroup(groupLayoutPanel6.createSequentialGroup()
                                                .addGap(19)
                                                .addComponent(numberLabel))
                                        .addGroup(groupLayoutPanel6.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(contactUsLabel, GroupLayout.DEFAULT_SIZE, 1123,
                                                        Short.MAX_VALUE)))
                                .addPreferredGap(ComponentPlacement.RELATED)
                                .addComponent(instaIcon)
                                .addGap(18)
                                .addComponent(linkedInIncon, GroupLayout.PREFERRED_SIZE, 102,
                                        GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(ComponentPlacement.RELATED)
                                .addComponent(jLabel16)
                                .addGap(62)));
        groupLayoutPanel6.setVerticalGroup(
                groupLayoutPanel6.createParallelGroup(Alignment.LEADING)
                        .addGroup(groupLayoutPanel6.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(groupLayoutPanel6.createParallelGroup(Alignment.TRAILING)
                                        .addComponent(jLabel16)
                                        .addComponent(instaIcon)
                                        .addComponent(linkedInIncon, GroupLayout.PREFERRED_SIZE, 48,
                                                GroupLayout.PREFERRED_SIZE)
                                        .addGroup(groupLayoutPanel6.createSequentialGroup()
                                                .addGap(14)
                                                .addComponent(contactUsLabel)
                                                .addPreferredGap(ComponentPlacement.RELATED)
                                                .addComponent(numberLabel)))
                                .addContainerGap(49, Short.MAX_VALUE)));
        panel6.setLayout(groupLayoutPanel6);

        seperator.setOrientation(javax.swing.SwingConstants.VERTICAL);
        seperator.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        makeBookingbtn.setBackground(new java.awt.Color(0, 51, 51));
        makeBookingbtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        makeBookingbtn.setForeground(new java.awt.Color(255, 255, 255));
        makeBookingbtn.setText("MAKE A BOOKING");
        makeBookingbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                makeBookingBtnAction(evt);
            }
        });

        registerBtn.setBackground(new java.awt.Color(0, 51, 51));
        registerBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        registerBtn.setForeground(new java.awt.Color(255, 255, 255));
        registerBtn.setText("REGISTER");
        registerBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerBtnAction(evt);
            }
        });

        mainMenuBtn.setBackground(new java.awt.Color(0, 51, 51));
        mainMenuBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        mainMenuBtn.setForeground(new java.awt.Color(255, 255, 255));
        mainMenuBtn.setText("MAIN MENU");
        mainMenuBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mainMenuBtnAction(evt);
            }
        });
        updateBookingBtn.setBackground(new java.awt.Color(0, 51, 51));
        updateBookingBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        updateBookingBtn.setForeground(new java.awt.Color(255, 255, 255));
        updateBookingBtn.setText("UPDATE A BOOKING");
        updateBookingBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateBookingBtnAction(evt);
            }
        });
        cancelBookingBtn.setBackground(new java.awt.Color(0, 51, 51));
        cancelBookingBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        cancelBookingBtn.setForeground(new java.awt.Color(255, 255, 255));
        cancelBookingBtn.setText("CANCEL A BOOKING");
        cancelBookingBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelBookingBtnAction(evt);
            }
        });
        viewTicketBtn.setBackground(new java.awt.Color(0, 51, 51));
        viewTicketBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        viewTicketBtn.setForeground(new java.awt.Color(255, 255, 255));
        viewTicketBtn.setText("VIEW TICKET");
        viewTicketBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewTicketBtnAction(evt);
            }
        });

        passangerLabel.setFont(new java.awt.Font("Rockwell", 1, 36)); // NOI18N
        passangerLabel.setText("PASSENGER");

        warningLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        warningLabel.setForeground(new java.awt.Color(204, 0, 51));
        warningLabel.setText("WARNING This Domain is constantly monitored by the main server.");

        portalLabel = new JLabel();
        portalLabel.setVerticalAlignment(SwingConstants.TOP);
        portalLabel.setText("PORTAL");
        portalLabel.setFont(new Font("Rockwell", Font.BOLD, 36));

        txtWelcomeAboardJsky = new JTextArea();
        txtWelcomeAboardJsky.setWrapStyleWord(true);
        txtWelcomeAboardJsky.setEditable(false);
        txtWelcomeAboardJsky.setFont(new Font("Monospaced", Font.BOLD, 18));
        txtWelcomeAboardJsky.setBackground(new Color(151, 190, 190));
        txtWelcomeAboardJsky.setText(
                "Welcome aboard JSKY! Take control of your journey with our easy-to-use interface. From booking to updates and cancellations, JSKY puts you in charge. Your smooth travel experience starts here");
        txtWelcomeAboardJsky.setLineWrap(true);

        javax.swing.GroupLayout gl_panel4 = new javax.swing.GroupLayout(panel4);
        gl_panel4.setHorizontalGroup(
                gl_panel4.createParallelGroup(Alignment.TRAILING)
                        .addComponent(panel6, GroupLayout.DEFAULT_SIZE, 1540, Short.MAX_VALUE)
                        .addComponent(panel5, GroupLayout.DEFAULT_SIZE, 1540, Short.MAX_VALUE)
                        .addGroup(gl_panel4.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(warningLabel, GroupLayout.PREFERRED_SIZE, 556, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(974, Short.MAX_VALUE))
                        .addGroup(gl_panel4.createSequentialGroup()
                                .addGap(208)
                                .addGroup(gl_panel4.createParallelGroup(Alignment.LEADING)
                                        .addGroup(gl_panel4.createSequentialGroup()
                                                .addComponent(passangerLabel)
                                                .addPreferredGap(ComponentPlacement.UNRELATED)
                                                .addComponent(portalLabel, GroupLayout.PREFERRED_SIZE, 221,
                                                        GroupLayout.PREFERRED_SIZE))
                                        .addComponent(txtWelcomeAboardJsky, GroupLayout.PREFERRED_SIZE, 565,
                                                GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(ComponentPlacement.RELATED, 198, Short.MAX_VALUE)
                                .addComponent(seperator, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                                        GroupLayout.PREFERRED_SIZE)
                                .addGap(74)
                                .addGroup(gl_panel4.createParallelGroup(Alignment.LEADING)
                                        .addComponent(updateBookingBtn, GroupLayout.PREFERRED_SIZE, 255,
                                                GroupLayout.PREFERRED_SIZE)
                                        .addComponent(makeBookingbtn, GroupLayout.PREFERRED_SIZE, 255,
                                                GroupLayout.PREFERRED_SIZE)
                                        .addComponent(cancelBookingBtn, GroupLayout.PREFERRED_SIZE, 255,
                                                GroupLayout.PREFERRED_SIZE)
                                        .addComponent(viewTicketBtn, GroupLayout.PREFERRED_SIZE, 255,
                                                GroupLayout.PREFERRED_SIZE)
                                        .addComponent(registerBtn, GroupLayout.PREFERRED_SIZE, 255,
                                                GroupLayout.PREFERRED_SIZE)
                                        .addComponent(mainMenuBtn, GroupLayout.PREFERRED_SIZE, 255,
                                                GroupLayout.PREFERRED_SIZE))
                                .addGap(238)));
        gl_panel4.setVerticalGroup(
                gl_panel4.createParallelGroup(Alignment.TRAILING)
                        .addGroup(gl_panel4.createSequentialGroup()
                                .addComponent(panel5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                                        GroupLayout.PREFERRED_SIZE)
                                .addGap(84)
                                .addGroup(gl_panel4.createParallelGroup(Alignment.TRAILING)
                                        .addGroup(gl_panel4.createSequentialGroup()
                                                .addGroup(gl_panel4.createParallelGroup(Alignment.TRAILING)
                                                        .addComponent(passangerLabel)
                                                        .addComponent(portalLabel, GroupLayout.PREFERRED_SIZE, 43,
                                                                GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(makeBookingbtn, GroupLayout.PREFERRED_SIZE, 51,
                                                                GroupLayout.PREFERRED_SIZE))
                                                .addGroup(gl_panel4.createParallelGroup(Alignment.LEADING)
                                                        .addGroup(gl_panel4.createSequentialGroup()
                                                                .addGap(20)
                                                                .addComponent(updateBookingBtn,
                                                                        GroupLayout.PREFERRED_SIZE, 54,
                                                                        GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(ComponentPlacement.UNRELATED)
                                                                .addComponent(cancelBookingBtn,
                                                                        GroupLayout.PREFERRED_SIZE, 54,
                                                                        GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(ComponentPlacement.UNRELATED)
                                                                .addComponent(viewTicketBtn, GroupLayout.PREFERRED_SIZE,
                                                                        54, GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18)
                                                                .addComponent(registerBtn, GroupLayout.PREFERRED_SIZE,
                                                                        48, GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18)
                                                                .addComponent(mainMenuBtn, GroupLayout.PREFERRED_SIZE,
                                                                        54, GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(gl_panel4.createSequentialGroup()
                                                                .addGap(38)
                                                                .addComponent(txtWelcomeAboardJsky,
                                                                        GroupLayout.PREFERRED_SIZE,
                                                                        GroupLayout.DEFAULT_SIZE,
                                                                        GroupLayout.PREFERRED_SIZE))))
                                        .addComponent(seperator, GroupLayout.PREFERRED_SIZE, 406,
                                                GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(ComponentPlacement.RELATED, 129, Short.MAX_VALUE)
                                .addComponent(panel6, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE))
                        .addGroup(gl_panel4.createSequentialGroup()
                                .addContainerGap(679, Short.MAX_VALUE)
                                .addComponent(warningLabel)
                                .addGap(125)));
        panel4.setLayout(gl_panel4);

        javax.swing.GroupLayout gl_panel1 = new javax.swing.GroupLayout(panel1);
        gl_panel1.setHorizontalGroup(
                gl_panel1.createParallelGroup(Alignment.LEADING)
                        .addComponent(panel2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(panel4, GroupLayout.DEFAULT_SIZE, 1514, Short.MAX_VALUE));
        gl_panel1.setVerticalGroup(
                gl_panel1.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_panel1.createSequentialGroup()
                                .addGroup(gl_panel1.createParallelGroup(Alignment.LEADING)
                                        .addComponent(panel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                                                GroupLayout.PREFERRED_SIZE)
                                        .addGroup(gl_panel1.createSequentialGroup()
                                                .addGap(10)
                                                .addComponent(panel4, GroupLayout.PREFERRED_SIZE, 824,
                                                        GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap()));
        panel1.setLayout(gl_panel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(panel1, javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(panel1, javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Event handler for the "Make a Booking" button.
     * Disposes of the current frame and opens a new instance of the ticket class.
     *
     * @param evt The ActionEvent generated by the button click.
     */
    private void makeBookingBtnAction(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_makeBookingBtnAction
        // TODO add your handling code here:
        super.dispose();
        ticketObj = new ticket();
        ticketObj.setVisible(true);
    }// GEN-LAST:event_makeBookingBtnAction

    /**
     * Event handler for the "Register" button.
     * Disposes of the current frame and opens a new instance of the addCustomer
     * class.
     *
     * @param evt The ActionEvent generated by the button click.
     */
    private void registerBtnAction(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_registerBtnAction
        // TODO add your handling code here:
        super.dispose();
        addCustomerObj = new addCustomer();
        addCustomerObj.setVisible(true);

    }// GEN-LAST:event_registerBtnAction

    /**
     * Event handler for the "Main Menu" button.
     * Disposes of the current frame and opens a new instance of the welcome class.
     *
     * @param evt The ActionEvent generated by the button click.
     */
    private void mainMenuBtnAction(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_mainMenuBtnAction
        super.dispose();
        welcomeObj = new welcome();
        welcomeObj.setVisible(true);
        // TODO add your handling code here:

    }// GEN-LAST:event_mainMenuBtnAction

    /**
     * Event handler for the "Update a Booking" button.
     * Disposes of the current frame and opens a new instance of the update class.
     *
     * @param evt The ActionEvent generated by the button click.
     */
    private void updateBookingBtnAction(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_updateBookingBtnAction
        super.dispose();
        updateObj = new update();
        updateObj.setSize(1150, 900);
        updateObj.setVisible(true);
        // TODO add your handling code here:

    }// GEN-LAST:event_updateBookingBtnAction

    /**
     * Event handler for the "Cancel a Booking" button.
     * Disposes of the current frame and opens a new instance of the cancels class.
     *
     * @param evt The ActionEvent generated by the button click.
     */
    private void cancelBookingBtnAction(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_cancelBookingBtnAction
        super.dispose();
        cancelsObj = new cancels();
        cancelsObj.setVisible(true);
        // TODO add your handling code here:

    }// GEN-LAST:event_cancelBookingBtnAction

    /**
     * Event handler for the "View Ticket" button.
     * Disposes of the current frame and opens a new instance of the viewTicket
     * class.
     *
     * @param evt The ActionEvent generated by the button click.
     */
    private void viewTicketBtnAction(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_viewTicketBtnAction
        super.dispose();
        VT = new viewTicket();
        VT.setVisible(true);
        // TODO add your handling code here:

    }// GEN-LAST:event_viewTicketBtnAction

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton makeBookingbtn;
    private javax.swing.JButton registerBtn;
    private javax.swing.JButton mainMenuBtn;
    private javax.swing.JButton updateBookingBtn;
    private javax.swing.JButton cancelBookingBtn;
    private javax.swing.JButton viewTicketBtn;
    private javax.swing.JLabel imgPK;
    private javax.swing.JLabel contactUsLabel;
    private javax.swing.JLabel numberLabel;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel instaIcon;
    private javax.swing.JLabel linkedInIncon;
    private javax.swing.JLabel passangerLabel;
    private javax.swing.JLabel warningLabel;
    private javax.swing.JPanel panel1;
    private javax.swing.JPanel panel2;
    private javax.swing.JPanel panel4;
    private javax.swing.JPanel panel5;
    private javax.swing.JPanel panel6;
    private javax.swing.JSeparator seperator;
    private welcome welcomeObj;
    private addCustomer addCustomerObj;
    private update updateObj;
    private cancels cancelsObj;
    private ticket ticketObj;
    private viewTicket VT;
    private JLabel portalLabel;
    private JTextArea txtWelcomeAboardJsky;
}
