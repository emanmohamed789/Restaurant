/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import static View.CancelOrderJFrame.drive;
import static View.CancelOrderJFrame.password;
import static View.CancelOrderJFrame.url;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author silkroad
 */
public class AdministrativeModule extends javax.swing.JFrame {

    /**
     * Creates new form AdministrativeModule
     */
    public AdministrativeModule() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jButtonUser = new javax.swing.JButton();
        jButtonEmployee = new javax.swing.JButton();
        jButtonMeals = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButtonDiscount = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Administrative Module");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Administrative Module");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 20, 210, 20));

        jButtonUser.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        jButtonUser.setText("Change User/Pass");
        jButtonUser.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonUserActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 60, -1, -1));

        jButtonEmployee.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        jButtonEmployee.setText("Manage Employee");
        jButtonEmployee.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonEmployee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEmployeeActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonEmployee, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 110, -1, -1));

        jButtonMeals.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        jButtonMeals.setText("Manage Meals");
        jButtonMeals.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonMeals.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonMealsActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonMeals, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 160, 145, -1));

        jButton1.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jButton1.setText("Log out");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 260, -1, -1));

        jButtonDiscount.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        jButtonDiscount.setText("Add Discount");
        jButtonDiscount.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        jButtonDiscount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDiscountActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonDiscount, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 210, 140, 20));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/bg.jpg"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 480, 330));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonEmployeeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEmployeeActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        new EmployeeFrame().setVisible(true);
        
    }//GEN-LAST:event_jButtonEmployeeActionPerformed

    private void jButtonMealsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonMealsActionPerformed
        // TODO add your handling code here:
         this.setVisible(false);
        new Meals().setVisible(true);
    }//GEN-LAST:event_jButtonMealsActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        new LoginAdmin().setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButtonUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonUserActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        new ResetUser().setVisible(true);
    }//GEN-LAST:event_jButtonUserActionPerformed

    private void jButtonDiscountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDiscountActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        new AddDiscount().setVisible(true);
    }//GEN-LAST:event_jButtonDiscountActionPerformed

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
            java.util.logging.Logger.getLogger(AdministrativeModule.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdministrativeModule.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdministrativeModule.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdministrativeModule.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdministrativeModule().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButtonDiscount;
    private javax.swing.JButton jButtonEmployee;
    private javax.swing.JButton jButtonMeals;
    private javax.swing.JButton jButtonUser;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
