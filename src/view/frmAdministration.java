/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;

/**
 *
 * @author GSG
 */
public class frmAdministration extends javax.swing.JFrame {

    /**
     * Creates new form frmAdministration
     */
    public frmAdministration() {
      //  this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        initComponents();
                Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dim = toolkit.getScreenSize();
        this.setSize(dim.width, dim.height);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dlgAdminEmployees = new javax.swing.JDialog();
        pnlCustomerDates = new javax.swing.JPanel();
        lblDocument = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        lblName = new javax.swing.JLabel();
        lblLastName = new javax.swing.JLabel();
        txtLastName = new javax.swing.JTextField();
        txtAddress = new javax.swing.JTextField();
        txtDocument = new javax.swing.JTextField();
        lblAddress = new javax.swing.JLabel();
        lblJob = new javax.swing.JLabel();
        txtJob = new javax.swing.JTextField();
        lblNotes = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtNotes = new javax.swing.JTextArea();
        btnNext = new javax.swing.JButton();
        lblLocal = new javax.swing.JLabel();
        lblPhone1 = new javax.swing.JLabel();
        txtPhone1 = new javax.swing.JTextField();
        cbLocal = new javax.swing.JComboBox<>();
        jToolBar1 = new javax.swing.JToolBar();
        jButton1 = new javax.swing.JButton();
        jDialog1 = new javax.swing.JDialog();
        btnAdminProducts = new javax.swing.JButton();
        btnCompanyDates = new javax.swing.JButton();
        btnAdminEmployees = new javax.swing.JButton();
        btnAdminPasswords = new javax.swing.JButton();
        btnAdminCustomers = new javax.swing.JButton();

        dlgAdminEmployees.getContentPane().setLayout(null);

        pnlCustomerDates.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos Empleados", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), java.awt.Color.red)); // NOI18N
        pnlCustomerDates.setLayout(null);

        lblDocument.setFont(new java.awt.Font("Noto Sans", 0, 18)); // NOI18N
        lblDocument.setText("Cédula");
        pnlCustomerDates.add(lblDocument);
        lblDocument.setBounds(50, 44, 57, 24);
        pnlCustomerDates.add(txtName);
        txtName.setBounds(174, 90, 196, 39);

        lblName.setFont(new java.awt.Font("Noto Sans", 0, 18)); // NOI18N
        lblName.setText("Nombre");
        pnlCustomerDates.add(lblName);
        lblName.setBounds(50, 94, 63, 24);

        lblLastName.setFont(new java.awt.Font("Noto Sans", 0, 18)); // NOI18N
        lblLastName.setText("Apellidos");
        pnlCustomerDates.add(lblLastName);
        lblLastName.setBounds(50, 139, 72, 24);
        pnlCustomerDates.add(txtLastName);
        txtLastName.setBounds(174, 135, 196, 39);
        pnlCustomerDates.add(txtAddress);
        txtAddress.setBounds(174, 185, 196, 39);
        pnlCustomerDates.add(txtDocument);
        txtDocument.setBounds(174, 40, 196, 39);

        lblAddress.setFont(new java.awt.Font("Noto Sans", 0, 18)); // NOI18N
        lblAddress.setText("Dirección");
        pnlCustomerDates.add(lblAddress);
        lblAddress.setBounds(49, 189, 75, 24);

        lblJob.setFont(new java.awt.Font("Noto Sans", 0, 18)); // NOI18N
        lblJob.setText("Puesto");
        pnlCustomerDates.add(lblJob);
        lblJob.setBounds(49, 239, 56, 24);
        pnlCustomerDates.add(txtJob);
        txtJob.setBounds(174, 235, 196, 39);

        lblNotes.setFont(new java.awt.Font("Noto Sans", 0, 18)); // NOI18N
        lblNotes.setText("Notas");
        pnlCustomerDates.add(lblNotes);
        lblNotes.setBounds(50, 430, 47, 24);

        txtNotes.setColumns(20);
        txtNotes.setRows(5);
        jScrollPane1.setViewportView(txtNotes);

        pnlCustomerDates.add(jScrollPane1);
        jScrollPane1.setBounds(180, 420, 184, 96);

        btnNext.setFont(new java.awt.Font("Noto Sans", 1, 18)); // NOI18N
        btnNext.setText("Siguiente");
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextActionPerformed(evt);
            }
        });
        pnlCustomerDates.add(btnNext);
        btnNext.setBounds(365, 510, 123, 45);

        lblLocal.setFont(new java.awt.Font("Noto Sans", 0, 18)); // NOI18N
        lblLocal.setText("Teléfono");
        pnlCustomerDates.add(lblLocal);
        lblLocal.setBounds(50, 360, 71, 24);

        lblPhone1.setFont(new java.awt.Font("Noto Sans", 0, 18)); // NOI18N
        lblPhone1.setText("Teléfono");
        pnlCustomerDates.add(lblPhone1);
        lblPhone1.setBounds(49, 296, 71, 24);
        pnlCustomerDates.add(txtPhone1);
        txtPhone1.setBounds(174, 292, 196, 39);

        cbLocal.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        pnlCustomerDates.add(cbLocal);
        cbLocal.setBounds(170, 350, 200, 40);

        dlgAdminEmployees.getContentPane().add(pnlCustomerDates);
        pnlCustomerDates.setBounds(10, 43, 494, 562);

        jToolBar1.setRollover(true);

        jButton1.setText("jButton1");
        jButton1.setFocusable(false);
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton1);

        dlgAdminEmployees.getContentPane().add(jToolBar1);
        jToolBar1.setBounds(0, 0, 532, 25);

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1382, 744));
        setSize(new java.awt.Dimension(1382, 744));

        btnAdminProducts.setText("Administrar productos");

        btnCompanyDates.setText("Datos empresa");

        btnAdminEmployees.setText("Administrar empleados");

        btnAdminPasswords.setText("Administrador de contraseñas");

        btnAdminCustomers.setText("Administrar clientes");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnAdminEmployees, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(109, 109, 109)
                        .addComponent(btnAdminProducts, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnAdminPasswords, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnAdminCustomers, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(151, 151, 151)
                .addComponent(btnCompanyDates, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(480, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdminProducts, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCompanyDates, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAdminEmployees, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(59, 59, 59)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdminPasswords, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAdminCustomers, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(360, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed
       
    }//GEN-LAST:event_btnNextActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(frmAdministration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmAdministration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmAdministration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmAdministration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmAdministration().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdminCustomers;
    private javax.swing.JButton btnAdminEmployees;
    private javax.swing.JButton btnAdminPasswords;
    private javax.swing.JButton btnAdminProducts;
    private javax.swing.JButton btnCompanyDates;
    private javax.swing.JButton btnNext;
    private javax.swing.JComboBox<String> cbLocal;
    private javax.swing.JDialog dlgAdminEmployees;
    private javax.swing.JButton jButton1;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JLabel lblAddress;
    private javax.swing.JLabel lblDocument;
    private javax.swing.JLabel lblJob;
    private javax.swing.JLabel lblLastName;
    private javax.swing.JLabel lblLocal;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblNotes;
    private javax.swing.JLabel lblPhone1;
    private javax.swing.JPanel pnlCustomerDates;
    private javax.swing.JTextField txtAddress;
    private javax.swing.JTextField txtDocument;
    private javax.swing.JTextField txtJob;
    private javax.swing.JTextField txtLastName;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextArea txtNotes;
    private javax.swing.JTextField txtPhone1;
    // End of variables declaration//GEN-END:variables
}
