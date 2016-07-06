/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import model.clsDAOEmployees;

/**
 *
 * @author GSG
 */
public class frmAdministration extends javax.swing.JFrame {

    model.clsDAOEmployees employees;

    /**
     * Creates new form frmAdministration
     */
    public frmAdministration() {
        //  this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        initComponents();
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dim = toolkit.getScreenSize();
        this.setSize(dim.width, dim.height);
        dlgAdminEmployees.setSize(dim.width, dim.height);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        dlgAdminEmployees.setSize(800, dim.height);
        lblBackgroundAdmin.setSize(800, dim.height);
        //   dlgAdminEmployees.setB(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        dlgAdminEmployees.setLocationRelativeTo(this);

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
        pnlEmployeesDates = new javax.swing.JPanel();
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
        lblLocal = new javax.swing.JLabel();
        lblPhone1 = new javax.swing.JLabel();
        txtPhone1 = new javax.swing.JTextField();
        cbLocal = new javax.swing.JComboBox<>();
        jToolBar1 = new javax.swing.JToolBar();
        jButton1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        btnEdit = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnInsert = new javax.swing.JButton();
        btnSearch = new javax.swing.JButton();
        btnNew = new javax.swing.JButton();
        lblBackgroundDialog = new javax.swing.JLabel();
        jDialog1 = new javax.swing.JDialog();
        btnAdminProducts = new javax.swing.JButton();
        btnCompanyDates = new javax.swing.JButton();
        btnAdminEmployees = new javax.swing.JButton();
        btnAdminPasswords = new javax.swing.JButton();
        btnAdminCustomers = new javax.swing.JButton();
        lblBackgroundAdmin = new javax.swing.JLabel();

        dlgAdminEmployees.getContentPane().setLayout(null);

        pnlEmployeesDates.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.MatteBorder(null), "Datos Empleados", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), java.awt.Color.red)); // NOI18N
        pnlEmployeesDates.setOpaque(false);

        lblDocument.setFont(new java.awt.Font("Noto Sans", 0, 18)); // NOI18N
        lblDocument.setText("Cédula");

        lblName.setFont(new java.awt.Font("Noto Sans", 0, 18)); // NOI18N
        lblName.setText("Nombre");

        lblLastName.setFont(new java.awt.Font("Noto Sans", 0, 18)); // NOI18N
        lblLastName.setText("Apellidos");

        lblAddress.setFont(new java.awt.Font("Noto Sans", 0, 18)); // NOI18N
        lblAddress.setText("Dirección");

        lblJob.setFont(new java.awt.Font("Noto Sans", 0, 18)); // NOI18N
        lblJob.setText("Puesto");

        lblNotes.setFont(new java.awt.Font("Noto Sans", 0, 18)); // NOI18N
        lblNotes.setText("Notas");

        txtNotes.setColumns(20);
        txtNotes.setRows(5);
        jScrollPane1.setViewportView(txtNotes);

        lblLocal.setFont(new java.awt.Font("Noto Sans", 0, 18)); // NOI18N
        lblLocal.setText("Local");

        lblPhone1.setFont(new java.awt.Font("Noto Sans", 0, 18)); // NOI18N
        lblPhone1.setText("Teléfono");

        cbLocal.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Hot Wings Linares", "Hot Wings La estrella" }));

        javax.swing.GroupLayout pnlEmployeesDatesLayout = new javax.swing.GroupLayout(pnlEmployeesDates);
        pnlEmployeesDates.setLayout(pnlEmployeesDatesLayout);
        pnlEmployeesDatesLayout.setHorizontalGroup(
            pnlEmployeesDatesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlEmployeesDatesLayout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(lblDocument)
                .addGap(67, 67, 67)
                .addComponent(txtDocument, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(pnlEmployeesDatesLayout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(lblName)
                .addGap(61, 61, 61)
                .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(pnlEmployeesDatesLayout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(lblLastName)
                .addGap(52, 52, 52)
                .addComponent(txtLastName, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(pnlEmployeesDatesLayout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(lblAddress)
                .addGap(50, 50, 50)
                .addComponent(txtAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(pnlEmployeesDatesLayout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(lblJob)
                .addGap(69, 69, 69)
                .addComponent(txtJob, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(pnlEmployeesDatesLayout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(lblPhone1)
                .addGap(54, 54, 54)
                .addComponent(txtPhone1, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(pnlEmployeesDatesLayout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(lblLocal)
                .addGap(77, 77, 77)
                .addComponent(cbLocal, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(pnlEmployeesDatesLayout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(lblNotes)
                .addGap(83, 83, 83)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        pnlEmployeesDatesLayout.setVerticalGroup(
            pnlEmployeesDatesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlEmployeesDatesLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(pnlEmployeesDatesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlEmployeesDatesLayout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(lblDocument))
                    .addComponent(txtDocument, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(pnlEmployeesDatesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlEmployeesDatesLayout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(lblName))
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(pnlEmployeesDatesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlEmployeesDatesLayout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(lblLastName))
                    .addComponent(txtLastName, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(pnlEmployeesDatesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlEmployeesDatesLayout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(lblAddress))
                    .addComponent(txtAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(pnlEmployeesDatesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlEmployeesDatesLayout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(lblJob))
                    .addComponent(txtJob, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlEmployeesDatesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlEmployeesDatesLayout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(lblPhone1))
                    .addComponent(txtPhone1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(pnlEmployeesDatesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlEmployeesDatesLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(lblLocal))
                    .addComponent(cbLocal, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(pnlEmployeesDatesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlEmployeesDatesLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(lblNotes))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        dlgAdminEmployees.getContentPane().add(pnlEmployeesDates);
        pnlEmployeesDates.setBounds(110, 130, 375, 521);

        jToolBar1.setRollover(true);

        jButton1.setText("Archivo");
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
        jToolBar1.setBounds(0, 0, 900, 25);

        jPanel2.setOpaque(false);

        btnEdit.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/iconBtnEdit.png"))); // NOI18N
        btnEdit.setText("Modificar");
        btnEdit.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnEdit.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnEdit.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        btnDelete.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/iconBtnDelete.png"))); // NOI18N
        btnDelete.setText("Eliminar");
        btnDelete.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnDelete.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnDelete.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnInsert.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnInsert.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/iconBtnSave.png"))); // NOI18N
        btnInsert.setText("Insertar");
        btnInsert.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnInsert.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnInsert.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnInsert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertActionPerformed(evt);
            }
        });

        btnSearch.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/iconBtnSearch.png"))); // NOI18N
        btnSearch.setText("Consultar");
        btnSearch.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnSearch.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnSearch.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        btnNew.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnNew.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/iconBtnNew.png"))); // NOI18N
        btnNew.setText("Nuevo");
        btnNew.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnNew.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnNew.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(btnNew)
                .addGap(3, 3, 3)
                .addComponent(btnInsert)
                .addGap(3, 3, 3)
                .addComponent(btnSearch)
                .addGap(3, 3, 3)
                .addComponent(btnEdit)
                .addGap(3, 3, 3)
                .addComponent(btnDelete))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnNew, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(btnInsert, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        dlgAdminEmployees.getContentPane().add(jPanel2);
        jPanel2.setBounds(40, 40, 520, 90);

        lblBackgroundDialog.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/555.jpg"))); // NOI18N
        dlgAdminEmployees.getContentPane().add(lblBackgroundDialog);
        lblBackgroundDialog.setBounds(-6, -6, 600, 710);

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
        getContentPane().setLayout(null);

        btnAdminProducts.setText("Administrar productos");
        getContentPane().add(btnAdminProducts);
        btnAdminProducts.setBounds(450, 30, 204, 149);

        btnCompanyDates.setText("Datos empresa");
        getContentPane().add(btnCompanyDates);
        btnCompanyDates.setBounds(780, 30, 204, 149);

        btnAdminEmployees.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnAdminEmployees.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/iconBtnAdminEmployees.jpg"))); // NOI18N
        btnAdminEmployees.setText("Administrar empleados");
        btnAdminEmployees.setBorderPainted(false);
        btnAdminEmployees.setContentAreaFilled(false);
        btnAdminEmployees.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnAdminEmployees.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnAdminEmployees.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnAdminEmployees.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdminEmployeesActionPerformed(evt);
            }
        });
        getContentPane().add(btnAdminEmployees);
        btnAdminEmployees.setBounds(30, 27, 290, 260);

        btnAdminPasswords.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnAdminPasswords.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/iconBtnAdminPasswords.png"))); // NOI18N
        btnAdminPasswords.setText("Administrador de contraseñas");
        btnAdminPasswords.setBorderPainted(false);
        btnAdminPasswords.setContentAreaFilled(false);
        btnAdminPasswords.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnAdminPasswords.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnAdminPasswords.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        getContentPane().add(btnAdminPasswords);
        btnAdminPasswords.setBounds(30, 370, 300, 290);

        btnAdminCustomers.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/la-gente-che-mangia-e-che-parla-ristorante-o-caff-64556176.jpg"))); // NOI18N
        btnAdminCustomers.setText("Administrar clientes");
        btnAdminCustomers.setBorderPainted(false);
        btnAdminCustomers.setContentAreaFilled(false);
        btnAdminCustomers.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnAdminCustomers.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnAdminCustomers.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        getContentPane().add(btnAdminCustomers);
        btnAdminCustomers.setBounds(430, 380, 300, 260);

        lblBackgroundAdmin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/555.jpg"))); // NOI18N
        getContentPane().add(lblBackgroundAdmin);
        lblBackgroundAdmin.setBounds(-6, 0, 1390, 740);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewActionPerformed
        cleanTextbox();
    }//GEN-LAST:event_btnNewActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        employees = new clsDAOEmployees();
        employees.setDocument_id(txtDocument.getText());
        String result = "";
        result = employees.delete();
        if (result.equals("correcto")) {
            JOptionPane.showMessageDialog(rootPane, "El empleado ha sido elminado correctamente.");

        } else {
            JOptionPane.showMessageDialog(rootPane, "No ha podido ser eliminado el empleado, intente nuevamente y verifique que el empleado exista.");

        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        try {
            employees = new clsDAOEmployees();
            ResultSet result;
            String document = JOptionPane.showInputDialog("Por favor ingrese el número de cédula del empleado a buscar");
            employees.setDocument_id(document);
            result = employees.search();
            txtDocument.setText(result.getString(2));
            txtName.setText(result.getString(3));
            txtLastName.setText(result.getString(4));
            txtJob.setText(result.getString(5));
            txtPhone1.setText(result.getString(6));
            txtNotes.setText(result.getString(7));
            txtAddress.setText(result.getString(9));

        } catch (SQLException ex) {
            Logger.getLogger(frmAdministration.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_btnSearchActionPerformed

    private void btnInsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertActionPerformed
        employees = new clsDAOEmployees();
        employees.setDocument_id(txtDocument.getText());
        employees.setNamee(txtName.getText());
        employees.setLastname(txtLastName.getText());
        employees.setJob(txtJob.getText());
        employees.setPhone(txtPhone1.getText());
        employees.setNotes(txtNotes.getText());
        employees.setAddress(txtAddress.getText());
        if ("Hot Wings Linares".equals(cbLocal.getSelectedItem().toString())) {
            employees.setLocal_id("1001");
        } else if ("Hot Wings la estrella".equals(cbLocal.getSelectedItem().toString())) {
            employees.setLocal_id("1002");
        }

        if (employees.insert()) {
            JOptionPane.showMessageDialog(rootPane, "Se insertó el empleado correctamente");
        } else {
            JOptionPane.showMessageDialog(rootPane, "No sé insertó el empleado");
        }
    }//GEN-LAST:event_btnInsertActionPerformed

    private void btnAdminEmployeesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdminEmployeesActionPerformed
        this.dispose();
        dlgAdminEmployees.setVisible(true);
    }//GEN-LAST:event_btnAdminEmployeesActionPerformed

    public void cleanTextbox() {
        txtDocument.setText("");
        txtName.setText("");
        txtLastName.setText("");
        txtJob.setText("");
        txtPhone1.setText("");
        txtNotes.setText("");
        txtAddress.setText("");
    }

    public void loadDates() {

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
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnInsert;
    private javax.swing.JButton btnNew;
    private javax.swing.JButton btnSearch;
    private javax.swing.JComboBox<String> cbLocal;
    private javax.swing.JDialog dlgAdminEmployees;
    private javax.swing.JButton jButton1;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JLabel lblAddress;
    private javax.swing.JLabel lblBackgroundAdmin;
    private javax.swing.JLabel lblBackgroundDialog;
    private javax.swing.JLabel lblDocument;
    private javax.swing.JLabel lblJob;
    private javax.swing.JLabel lblLastName;
    private javax.swing.JLabel lblLocal;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblNotes;
    private javax.swing.JLabel lblPhone1;
    private javax.swing.JPanel pnlEmployeesDates;
    private javax.swing.JTextField txtAddress;
    private javax.swing.JTextField txtDocument;
    private javax.swing.JTextField txtJob;
    private javax.swing.JTextField txtLastName;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextArea txtNotes;
    private javax.swing.JTextField txtPhone1;
    // End of variables declaration//GEN-END:variables
}
