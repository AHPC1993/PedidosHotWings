/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.*;
import org.pushingpixels.substance.api.SubstanceLookAndFeel;
import javax.swing.JOptionPane;
import model.clsDAOLocalOrderDetails;
import model.clsDAOOrderDeliveryDetails;
import model.clsDAOUsers;

/**
 *
 * @author allan
 */
public class frmMainHotWings extends javax.swing.JFrame {

    model.clsDAOOrderDeliveryDetails orderDelivery;
    model.clsDAOLocalOrderDetails localOrder;
    controller.Connect connexion;
    frmNewOrderDelivery frmOrderDelivery;
    frmAdministration frmAdmin;
    frmLocalOrder frmLocalO;
    frmReports frmReport;
    int count = 5;
    model.clsDAOUsers users;
    model.clsDAOLogin daoLogin;

    /**
     * Creates new form frmLoginHotWings
     */
    public frmMainHotWings() {
        frmReport = new frmReports();
        frmOrderDelivery = new frmNewOrderDelivery();
        frmAdmin = new frmAdministration();
        frmLocalO = new frmLocalOrder();
        JFrame.setDefaultLookAndFeelDecorated(true);
        this.setUndecorated(true); //pantalla completa
        SubstanceLookAndFeel.setSkin("org.pushingpixels.substance.api.skin.ChallengerDeepSkin");
        initComponents();
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dim = toolkit.getScreenSize();
        this.setSize(dim.width, dim.height);

        btnAdmin.setVisible(false);
        //  this.setExtendedState(JFrame.MAXIMIZED_BOTH);

        //Se crea el background contenido en un label y se le da tamaño y posición al jdialog
        ImageIcon icon = new ImageIcon(getClass().getClassLoader().getResource("resources/images/backgroundLogin.jpg"));
        lblBackground.setIcon(icon);
        lblBackgroundMainFrame.setSize(dim.width, dim.height);
        dlgLogin.setSize(692, 345);
        pnlLogin.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        dlgLogin.setLocationRelativeTo(this);
        dlgLogin.setVisible(true);

    }

    /*Método que permite validar el usuario y la contraseña para poder ver el frame.*/
    public void validateLogin() {
        users = new clsDAOUsers();
        daoLogin = new model.clsDAOLogin();
        daoLogin.setUser(txtUser.getText());
        daoLogin.setPassword(String.valueOf(txtPassword.getPassword()));
        if ("".equals(daoLogin.getUser()) || "".equals(daoLogin.getPassword())) {
            JOptionPane.showMessageDialog(this, "<html><p><font size=\"5\">El usuario o la contraseña no pueden estar en blanco.</font></p></html>");
        } else if (daoLogin.validate() == false) {
            if (count == 1) {
                JOptionPane.showMessageDialog(this, "<html><p><font size=\"5\">Usted ha ingresado la contraseña mal 5 veces, el programa se cerrará.</font></p></html>");
                System.exit(0);
            } else {
                count = count - 1;
                JOptionPane.showMessageDialog(this, "<html><p><font size=\"5\">Datos incorrectos. Inténtelo otra vez, le quedan " + count + " intentos</font></p></html>");
            }

        } else {
            JOptionPane.showMessageDialog(this, "<html><p><font size=\"5\">Bienvenido(a)</font></p></html> " + daoLogin.getUser());
            lblCurrentUser.setText(daoLogin.getUser());
            users.updateLastEntry(daoLogin.getUser());
            isAdmin(lblCurrentUser.getText());

            SubstanceLookAndFeel.setSkin("org.pushingpixels.substance.api.skin.ModerateSkin");
            // this.btnOrderDelivery.putClientProperty(SubstanceLookAndFeel.BUTTON_SHAPER_PROPERTY, new StandardButtonShaper());

            this.setVisible(true);
            dlgLogin.setVisible(false);
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

        dlgLogin = new javax.swing.JDialog();
        pnlLogin = new javax.swing.JPanel();
        btnAccept = new javax.swing.JButton();
        lblUser = new javax.swing.JLabel();
        txtUser = new javax.swing.JTextField();
        lblPassword = new javax.swing.JLabel();
        btnExit = new javax.swing.JButton();
        txtPassword = new javax.swing.JPasswordField();
        lblIconHotWings = new javax.swing.JLabel();
        lblBackground = new javax.swing.JLabel();
        jMenu1 = new javax.swing.JMenu();
        btnOrderDelivery = new javax.swing.JButton();
        btnLocalOrder = new javax.swing.JButton();
        btnReports = new javax.swing.JButton();
        btnAdmin = new javax.swing.JButton();
        btnMenuDetails = new javax.swing.JButton();
        btnCloseProgram = new javax.swing.JButton();
        lblCurrentUser = new javax.swing.JLabel();
        lblCurrentUser1 = new javax.swing.JLabel();
        lblBackgroundMainFrame = new javax.swing.JLabel();

        dlgLogin.setTitle("Inicio de Sesión");
        dlgLogin.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                dlgLoginWindowClosed(evt);
            }
            public void windowClosing(java.awt.event.WindowEvent evt) {
                dlgLoginWindowClosing(evt);
            }
        });
        dlgLogin.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                dlgLoginKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                dlgLoginKeyReleased(evt);
            }
        });

        pnlLogin.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Iniciar Sesión", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 14), java.awt.Color.red)); // NOI18N
        pnlLogin.setLayout(null);

        btnAccept.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnAccept.setText("Aceptar");
        btnAccept.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAcceptActionPerformed(evt);
            }
        });
        pnlLogin.add(btnAccept);
        btnAccept.setBounds(429, 223, 89, 34);

        lblUser.setFont(new java.awt.Font("Noto Sans", 1, 18)); // NOI18N
        lblUser.setForeground(new java.awt.Color(240, 240, 240));
        lblUser.setText("Usuario");
        pnlLogin.add(lblUser);
        lblUser.setBounds(290, 94, 120, 29);

        txtUser.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txtUser.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        pnlLogin.add(txtUser);
        txtUser.setBounds(429, 91, 200, 36);

        lblPassword.setFont(new java.awt.Font("Noto Sans", 1, 18)); // NOI18N
        lblPassword.setForeground(new java.awt.Color(240, 240, 240));
        lblPassword.setText("Contraseña");
        pnlLogin.add(lblPassword);
        lblPassword.setBounds(290, 146, 120, 29);

        btnExit.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnExit.setText("Salir");
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });
        pnlLogin.add(btnExit);
        btnExit.setBounds(540, 223, 89, 34);

        txtPassword.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        pnlLogin.add(txtPassword);
        txtPassword.setBounds(429, 145, 200, 36);

        lblIconHotWings.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/logoHotWings.jpeg"))); // NOI18N
        pnlLogin.add(lblIconHotWings);
        lblIconHotWings.setBounds(4, 7, 280, 280);
        pnlLogin.add(lblBackground);
        lblBackground.setBounds(0, 0, 670, 320);

        javax.swing.GroupLayout dlgLoginLayout = new javax.swing.GroupLayout(dlgLogin.getContentPane());
        dlgLogin.getContentPane().setLayout(dlgLoginLayout);
        dlgLoginLayout.setHorizontalGroup(
            dlgLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dlgLoginLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlLogin, javax.swing.GroupLayout.DEFAULT_SIZE, 657, Short.MAX_VALUE)
                .addContainerGap())
        );
        dlgLoginLayout.setVerticalGroup(
            dlgLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dlgLoginLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlLogin, javax.swing.GroupLayout.DEFAULT_SIZE, 322, Short.MAX_VALUE)
                .addContainerGap())
        );

        jMenu1.setText("jMenu1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Menú principal");
        setMinimumSize(new java.awt.Dimension(1382, 744));
        setResizable(false);
        setSize(new java.awt.Dimension(1382, 744));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        getContentPane().setLayout(null);

        btnOrderDelivery.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnOrderDelivery.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/frmMain/iconBtnOrder.png"))); // NOI18N
        btnOrderDelivery.setText("Nuevo domicilio");
        btnOrderDelivery.setToolTipText("Nuevo domicilio");
        btnOrderDelivery.setBorderPainted(false);
        btnOrderDelivery.setContentAreaFilled(false);
        btnOrderDelivery.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnOrderDelivery.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnOrderDelivery.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnOrderDelivery.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOrderDeliveryActionPerformed(evt);
            }
        });
        getContentPane().add(btnOrderDelivery);
        btnOrderDelivery.setBounds(100, 50, 330, 255);

        btnLocalOrder.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnLocalOrder.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/frmMain/iconBtnLocalOrder.png"))); // NOI18N
        btnLocalOrder.setText("Nuevo pedido local");
        btnLocalOrder.setToolTipText("Nuevo pedido local");
        btnLocalOrder.setBorderPainted(false);
        btnLocalOrder.setContentAreaFilled(false);
        btnLocalOrder.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLocalOrder.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnLocalOrder.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnLocalOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLocalOrderActionPerformed(evt);
            }
        });
        getContentPane().add(btnLocalOrder);
        btnLocalOrder.setBounds(550, 50, 330, 255);

        btnReports.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnReports.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/frmMain/iconBtnReports.png"))); // NOI18N
        btnReports.setText("Generar informes");
        btnReports.setToolTipText("Nuevo domicilio");
        btnReports.setBorderPainted(false);
        btnReports.setContentAreaFilled(false);
        btnReports.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnReports.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnReports.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnReports.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReportsActionPerformed(evt);
            }
        });
        getContentPane().add(btnReports);
        btnReports.setBounds(100, 380, 330, 255);

        btnAdmin.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnAdmin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/frmMain/iconBtnAdmin.png"))); // NOI18N
        btnAdmin.setText("Administrar");
        btnAdmin.setToolTipText("Administrar todo en el software");
        btnAdmin.setBorderPainted(false);
        btnAdmin.setContentAreaFilled(false);
        btnAdmin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAdmin.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnAdmin.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdminActionPerformed(evt);
            }
        });
        getContentPane().add(btnAdmin);
        btnAdmin.setBounds(1010, 70, 330, 255);

        btnMenuDetails.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnMenuDetails.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/frmMain/iconBtnMenuDetails.png"))); // NOI18N
        btnMenuDetails.setText("Menú");
        btnMenuDetails.setToolTipText("Nuevo domicilio");
        btnMenuDetails.setBorderPainted(false);
        btnMenuDetails.setContentAreaFilled(false);
        btnMenuDetails.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnMenuDetails.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnMenuDetails.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnMenuDetails.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMenuDetailsActionPerformed(evt);
            }
        });
        getContentPane().add(btnMenuDetails);
        btnMenuDetails.setBounds(550, 380, 330, 255);

        btnCloseProgram.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnCloseProgram.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/iconBtnExit.png"))); // NOI18N
        btnCloseProgram.setText("Salir");
        btnCloseProgram.setBorderPainted(false);
        btnCloseProgram.setContentAreaFilled(false);
        btnCloseProgram.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCloseProgram.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnCloseProgram.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnCloseProgram.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseProgramActionPerformed(evt);
            }
        });
        getContentPane().add(btnCloseProgram);
        btnCloseProgram.setBounds(1220, 605, 120, 115);

        lblCurrentUser.setFont(new java.awt.Font("Noto Sans", 1, 24)); // NOI18N
        lblCurrentUser.setForeground(new java.awt.Color(0, 0, 204));
        lblCurrentUser.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblCurrentUser.setText("Usuario: ");
        getContentPane().add(lblCurrentUser);
        lblCurrentUser.setBounds(1210, 10, 170, 50);

        lblCurrentUser1.setFont(new java.awt.Font("Noto Sans", 1, 24)); // NOI18N
        lblCurrentUser1.setForeground(new java.awt.Color(0, 0, 204));
        lblCurrentUser1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCurrentUser1.setText("Usuario: ");
        getContentPane().add(lblCurrentUser1);
        lblCurrentUser1.setBounds(1060, 10, 170, 50);

        lblBackgroundMainFrame.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/555.jpg"))); // NOI18N
        lblBackgroundMainFrame.setMaximumSize(new java.awt.Dimension(1382, 744));
        lblBackgroundMainFrame.setMinimumSize(new java.awt.Dimension(1382, 744));
        lblBackgroundMainFrame.setPreferredSize(new java.awt.Dimension(1382, 744));
        getContentPane().add(lblBackgroundMainFrame);
        lblBackgroundMainFrame.setBounds(0, 0, 1380, 740);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void isAdmin(String user) {
        users = new clsDAOUsers();
        String isAdmin = users.isAdmin(user);
        if (isAdmin.equals("1")) {
            btnAdmin.setVisible(true);
        } else {

        }

    }

    private void dlgLoginWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_dlgLoginWindowClosed


    }//GEN-LAST:event_dlgLoginWindowClosed

    private void dlgLoginWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_dlgLoginWindowClosing

        System.exit(0);
    }//GEN-LAST:event_dlgLoginWindowClosing

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        if (JOptionPane.showConfirmDialog(this,
                "<html><p><font size=\"5\">Está seguro de que quiere salir?</font></p></html>", "Salir?",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {
            System.exit(0);
        } else {
            this.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        }


    }//GEN-LAST:event_formWindowClosing

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnExitActionPerformed

    private void btnAcceptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAcceptActionPerformed

        validateLogin();
    }//GEN-LAST:event_btnAcceptActionPerformed

    private void btnLocalOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLocalOrderActionPerformed
        localOrder = new clsDAOLocalOrderDetails();
        frmLocalO.loadNameProductValues();
        frmLocalO.loadAdditionalProductsValues();
        frmLocalO.txtOrderNumber.setText(localOrder.selectOrderNumber());
        frmLocalO.btnSelectedAmount.setSelected(true);
        frmLocalO.btnSelectedProducts.setSelected(true);
        frmLocalO.btnSelectedAdditionalProduct.setSelected(true);
        frmLocalO.setVisible(true);
    }//GEN-LAST:event_btnLocalOrderActionPerformed

    private void btnOrderDeliveryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOrderDeliveryActionPerformed
        // frmOrderDelivery.setVisible(true);
        orderDelivery = new clsDAOOrderDeliveryDetails();       
        frmOrderDelivery.txtOrderNumber.setText(orderDelivery.selectOrderNumber());
        frmOrderDelivery.dlgOrderDelivery.setVisible(true);

    }//GEN-LAST:event_btnOrderDeliveryActionPerformed

    private void dlgLoginKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_dlgLoginKeyPressed

    }//GEN-LAST:event_dlgLoginKeyPressed

    private void dlgLoginKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_dlgLoginKeyReleased


    }//GEN-LAST:event_dlgLoginKeyReleased

    private void btnReportsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReportsActionPerformed
        frmReport.setVisible(true);
    }//GEN-LAST:event_btnReportsActionPerformed

    private void btnAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdminActionPerformed

        JPanel panelPass = new JPanel();
        JLabel labelPass = new JLabel("<html><p><font size=\"5\">Por favor ingrese su contraseña de usuario<br></font></p></html>");
        JPasswordField pass = new JPasswordField(20);
        panelPass.add(labelPass);
        panelPass.add(pass);
        String[] options = new String[]{"Aceptar", "Cancelar"};
        int password = JOptionPane.showOptionDialog(null, panelPass, "Contraseña",
                JOptionPane.YES_OPTION, JOptionPane.PLAIN_MESSAGE,
                null, options, options[0]);
        if (password == 0) {
            if (daoLogin.getPassword().equals(String.valueOf(pass.getPassword()))) {
                frmAdmin.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(this, "<html><p><font size=\"5\">Contraseña incorrecta, por favor verifíquela.</font></p></html>");
            }
        }


    }//GEN-LAST:event_btnAdminActionPerformed

    private void btnMenuDetailsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenuDetailsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnMenuDetailsActionPerformed

    private void btnCloseProgramActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseProgramActionPerformed
        if (JOptionPane.showConfirmDialog(this,
                "<html><p><font size=\"5\">Está seguro de que quiere salir?</font></p></html>", "¿Salir?",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {
            System.exit(0);
        } else {
            this.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        }
    }//GEN-LAST:event_btnCloseProgramActionPerformed

    public void showDialog(JDialog dialog) {
        dialog.setSize(470, 400);
        dialog.setLocationRelativeTo(this);
        dialog.setVisible(true);
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
            java.util.logging.Logger.getLogger(frmMainHotWings.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmMainHotWings.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmMainHotWings.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmMainHotWings.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmMainHotWings().setVisible(false);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAccept;
    private javax.swing.JButton btnAdmin;
    private javax.swing.JButton btnCloseProgram;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnLocalOrder;
    private javax.swing.JButton btnMenuDetails;
    private javax.swing.JButton btnOrderDelivery;
    private javax.swing.JButton btnReports;
    private javax.swing.JDialog dlgLogin;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JLabel lblBackground;
    private javax.swing.JLabel lblBackgroundMainFrame;
    private javax.swing.JLabel lblCurrentUser;
    private javax.swing.JLabel lblCurrentUser1;
    private javax.swing.JLabel lblIconHotWings;
    private javax.swing.JLabel lblPassword;
    private javax.swing.JLabel lblUser;
    private javax.swing.JPanel pnlLogin;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtUser;
    // End of variables declaration//GEN-END:variables
}
