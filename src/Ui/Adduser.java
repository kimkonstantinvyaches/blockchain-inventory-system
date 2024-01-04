/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ui;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

import java.util.Arrays;
import java.util.List;
import Controller.UserController;
import Helper.Validation;
import Models.User;
import Models.User.UserRoles;

/**
 *
 * @author slavi
 */
public class Adduser extends javax.swing.JFrame {

    /**
     * Creates new form AddUser
     */
    public Adduser() {
        initComponents();
        setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Txt_Password1 = new javax.swing.JPasswordField();
        Lbl_Quantity1 = new javax.swing.JLabel();
        lbl_Username = new javax.swing.JLabel();
        lbl_Password = new javax.swing.JLabel();
        Btn_Add = new javax.swing.JButton();
        Btn_Cancel = new javax.swing.JButton();
        txt_Username = new javax.swing.JTextField();
        lbl_Role = new javax.swing.JLabel();
        txt_Password = new javax.swing.JPasswordField();
        lbl_Emaill = new javax.swing.JLabel();
        txt_Email = new javax.swing.JTextField();
        cmb_UserRole = new javax.swing.JComboBox<>();
        Lbl_Message = new javax.swing.JLabel();

        Lbl_Quantity1.setText("Password");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lbl_Username.setText("Username");

        lbl_Password.setText("Password");

        Btn_Add.setText("Add");
        Btn_Add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_AddActionPerformed(evt);
            }
        });

        Btn_Cancel.setText("Cancel");
        Btn_Cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_CancelActionPerformed(evt);
            }
        });

        lbl_Role.setText("Role");

        lbl_Emaill.setText("Email");

        cmb_UserRole.setModel(new DefaultComboBoxModel(UserRoles.values()));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lbl_Role)
                            .addComponent(txt_Password, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_Emaill)
                            .addComponent(txt_Email, javax.swing.GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE)
                            .addComponent(cmb_UserRole, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Lbl_Message, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(Btn_Cancel, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(35, 35, 35)
                                        .addComponent(Btn_Add, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(lbl_Password)
                                    .addComponent(txt_Username, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbl_Username))
                                .addGap(0, 32, Short.MAX_VALUE)))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(lbl_Username)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_Username, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_Password)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_Password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_Emaill)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txt_Email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbl_Role)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmb_UserRole, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Lbl_Message, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Btn_Cancel)
                    .addComponent(Btn_Add))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Btn_CancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_CancelActionPerformed
        Mainmenu Mainmenu = new Mainmenu();
        Mainmenu.setVisible(true);
        dispose();
    }//GEN-LAST:event_Btn_CancelActionPerformed

    private void Btn_AddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_AddActionPerformed
       User newUser = getNewUserInfo();
       List<String> newUserList = Arrays.asList(newUser.getUserName(), newUser.getUserPass(), newUser.getUserEmail());
       
       if (Validation.emptyTextfield(newUserList)) {
    	   UserController userController = new UserController();
    	   
    	   if (userController.chkDuplicateUser(getName())) {
    		   userController.createNewUser(newUser.getUserName(), newUser.getUserPass(), newUser.getUserEmail(), newUser.getUserRole());
    		   
    		   Mainmenu mainmenu = new Mainmenu();
    		   mainmenu.setVisible(true);
    		   dispose();    		   
    	   } else {
    		   JOptionPane.showMessageDialog(null, "Each username must be unique", "Duplicated username found", 1);
    	   }
    	   
       } else {
    	   JOptionPane.showMessageDialog(null, "All text fields cannot be empty", "Empty Fields Detected", 1);
       }

    }//GEN-LAST:event_Btn_AddActionPerformed
    
    private User getNewUserInfo() {
    	String userName = txt_Username.getText();
    	String userPass = new String(txt_Password.getPassword());
    	String userEmail = txt_Email.getText();
    	String userRole = cmb_UserRole.getSelectedItem().toString();
    	User newUser = new User(userName, userPass, userEmail, userRole);
    	return newUser;
    }

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
            java.util.logging.Logger.getLogger(Adduser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Adduser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Adduser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Adduser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Adduser().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Btn_Add;
    private javax.swing.JButton Btn_Cancel;
    private javax.swing.JLabel Lbl_Message;
    private javax.swing.JLabel Lbl_Quantity1;
    private javax.swing.JPasswordField Txt_Password1;
    private javax.swing.JComboBox<String> cmb_UserRole;
    private javax.swing.JLabel lbl_Emaill;
    private javax.swing.JLabel lbl_Password;
    private javax.swing.JLabel lbl_Role;
    private javax.swing.JLabel lbl_Username;
    private javax.swing.JTextField txt_Email;
    private javax.swing.JPasswordField txt_Password;
    private javax.swing.JTextField txt_Username;
    // End of variables declaration//GEN-END:variables
}
