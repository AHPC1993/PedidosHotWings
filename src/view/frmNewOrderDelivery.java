/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import model.clsDAOCustomers;
import model.clsDAOOrderDeliveryDetails;

/**
 *
 * @author GSG
 */
public class frmNewOrderDelivery extends javax.swing.JFrame {

    Border borderDefault;
    Border borderEmptyField;
    // frmMainHotWings frmMain;
    model.clsDAOCustomers customers;
    String customers_id;
    int stateTypeProduct = 0;
    int deleteSelectionState = 0;
    model.clsDAOOrderDeliveryDetails orderDelivery;
    model.clsDAOProducts products;
    model.clsDAOAdditionalProducts additionalProducts;

    /**
     * Creates new form frmNewOrderDelivery
     */
    public frmNewOrderDelivery() {
        //  this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dim = toolkit.getScreenSize();
        this.setSize(dim.width, dim.height);
        this.setUndecorated(true); //pantalla completa
        initComponents();
        borderDefault = BorderFactory.createLineBorder(Color.black);
        borderEmptyField = BorderFactory.createLineBorder(Color.red);
        dlgOrderDelivery.setSize(400, 700);
        dlgOrderDelivery.setLocationRelativeTo(this);
        dlgAdditionsOrderDelivery.setLocationRelativeTo(this);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
    }

    public void loadAdditionalProductsValues() {
        orderDelivery = new model.clsDAOOrderDeliveryDetails();
        LinkedList<String[]> values = new LinkedList<String[]>();
        values = orderDelivery.listAdditionalProducts();
        for (int i = 0; i < values.size(); i++) {
            if (values.get(i)[0] != null) {
                switch (values.get(i)[0]) {
                    case "Alitas":
                        btnAdditionalProduct1.setText(values.get(i)[0]);
                        btnAdditionalProduct1.setToolTipText(values.get(i)[1] + " $ " + values.get(i)[2]);
                        break;
                    case "Papas":
                        btnAdditionalProduct2.setText(values.get(i)[0]);
                        btnAdditionalProduct2.setToolTipText(values.get(i)[1] + " $ " + values.get(i)[2]);
                        break;
                    case "Salsas":
                        btnAdditionalProduct3.setText(values.get(i)[0]);
                        btnAdditionalProduct3.setToolTipText(values.get(i)[1] + " $ " + values.get(i)[2]);
                        break;
                    case "Gaseosa Pequeña":
                        btnAdditionalProduct4.setText(values.get(i)[0]);
                        btnAdditionalProduct4.setToolTipText(values.get(i)[1] + " $ " + values.get(i)[2]);

                        break;
                    case "Gaseosa Grande":
                        btnAdditionalProduct5.setText(values.get(i)[0]);
                        btnAdditionalProduct5.setToolTipText(values.get(i)[1] + " $ " + values.get(i)[2]);
                        break;
                    default:
                        break;
                }

            }
        }
    }

    public void loadNameProductValues() {
        orderDelivery = new model.clsDAOOrderDeliveryDetails();
        LinkedList<String[]> values = new LinkedList<String[]>();
        values = orderDelivery.listProducts();
        for (int i = 0; i < values.size(); i++) {
            if (values.get(i)[0] != null) {
                switch (values.get(i)[0]) {
                    case "Combo 1":
                        btnProduct1.setText(values.get(i)[0]);
                        btnProduct1.setToolTipText(values.get(i)[1] + " $ " + values.get(i)[2]);
                        break;
                    case "Combo 2":
                        btnProduct2.setText(values.get(i)[0]);
                        btnProduct2.setToolTipText(values.get(i)[1] + " $ " + values.get(i)[2]);
                        break;
                    case "Combo 3":
                        btnProduct3.setText(values.get(i)[0]);
                        btnProduct3.setToolTipText(values.get(i)[1] + " $ " + values.get(i)[2]);
                        break;
                    case "Combo 4":
                        btnProduct4.setText(values.get(i)[0]);
                        btnProduct4.setToolTipText(values.get(i)[1] + " $ " + values.get(i)[2]);

                        break;
                    case "Combo 5":
                        btnProduct5.setText(values.get(i)[0]);
                        btnProduct5.setToolTipText(values.get(i)[1] + " $ " + values.get(i)[2]);
                        break;
                    default:
                        break;
                }
            }
        }

        btnProduct6.setText("Adicionales");
        btnProduct6.setToolTipText("Productos adicionales, como gaseosa, papas, etc.");
        btnProduct7.setEnabled(false);
        btnProduct8.setEnabled(false);
        btnProduct9.setEnabled(false);
//        btnProduct6.setText(values.get(5)[0]);
//        btnProduct7.setText(values.get(6)[0]);
//        btnProduct8.setText(values.get(7)[0]);
//        btnProduct9.setText(values.get(8)[0]);
//        btnProduct6.setToolTipText(values.get(5)[1] + " $ " + values.get(5)[2]);
//        btnProduct7.setToolTipText(values.get(6)[1] + " $ " + values.get(6)[2]);
//        btnProduct8.setToolTipText(values.get(7)[1] + " $ " + values.get(7)[2]);
//        btnProduct9.setToolTipText(values.get(8)[1] + " $ " + values.get(8)[2]);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dlgOrderDelivery = new javax.swing.JDialog();
        pnlCustomersDates = new javax.swing.JPanel();
        lbCustomersDocument = new javax.swing.JLabel();
        txtCustomersName = new javax.swing.JTextField();
        lblCustomersName = new javax.swing.JLabel();
        lblCustomersLastName = new javax.swing.JLabel();
        txtCustomersLastName = new javax.swing.JTextField();
        txtCustomerssAddress = new javax.swing.JTextField();
        txtCustomersDocument = new javax.swing.JTextField();
        lblCustomersAddress = new javax.swing.JLabel();
        lblCustomersNeighborhood = new javax.swing.JLabel();
        txtCustomersNeighborhood = new javax.swing.JTextField();
        lblCustomersNotes = new javax.swing.JLabel();
        scrollNotes1 = new javax.swing.JScrollPane();
        txtCustomersNotes = new javax.swing.JTextArea();
        lblCustomersCity = new javax.swing.JLabel();
        lblCustomersTown = new javax.swing.JLabel();
        cbCustomersTown = new javax.swing.JComboBox<String>();
        cbCustomersCity = new javax.swing.JComboBox<String>();
        lblPhone = new javax.swing.JLabel();
        txtCustomersPhone = new javax.swing.JTextField();
        btnAddCustomer = new javax.swing.JButton();
        btnSearchCustomerOrderDelivery = new javax.swing.JButton();
        btnCancelOrderDelivery = new javax.swing.JButton();
        btnContinueOrderDelivery = new javax.swing.JButton();
        dlgAdditionsOrderDelivery = new javax.swing.JDialog();
        pblAdditionsLocalOrder = new javax.swing.JPanel();
        btnAdditionalProduct2 = new javax.swing.JToggleButton();
        btnAdditionalProduct3 = new javax.swing.JToggleButton();
        btnAdditionalProduct1 = new javax.swing.JToggleButton();
        btnAdditionalProduct6 = new javax.swing.JToggleButton();
        btnAdditionalProduct4 = new javax.swing.JToggleButton();
        btnAdditionalProduct5 = new javax.swing.JToggleButton();
        btnDlgAdditionsCancel = new javax.swing.JButton();
        productsGroup = new javax.swing.ButtonGroup();
        numbersGroup = new javax.swing.ButtonGroup();
        actionsGroup = new javax.swing.ButtonGroup();
        additionsGroup = new javax.swing.ButtonGroup();
        pnlAmount = new javax.swing.JPanel();
        btnNumber6 = new javax.swing.JToggleButton();
        btnNumber2 = new javax.swing.JToggleButton();
        btnNumber1 = new javax.swing.JToggleButton();
        btnNumber3 = new javax.swing.JToggleButton();
        btnNumber4 = new javax.swing.JToggleButton();
        btnNumber5 = new javax.swing.JToggleButton();
        btnNumber7 = new javax.swing.JToggleButton();
        btnNumber8 = new javax.swing.JToggleButton();
        btnNumber9 = new javax.swing.JToggleButton();
        btnDoneOrder = new javax.swing.JButton();
        btnCorrection = new javax.swing.JButton();
        btnOtherAmount = new javax.swing.JButton();
        btnAddProduct = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtNotes = new javax.swing.JTextArea();
        pnlProducts = new javax.swing.JPanel();
        btnProduct1 = new javax.swing.JToggleButton();
        btnProduct2 = new javax.swing.JToggleButton();
        btnProduct3 = new javax.swing.JToggleButton();
        btnProduct4 = new javax.swing.JToggleButton();
        btnProduct5 = new javax.swing.JToggleButton();
        btnProduct6 = new javax.swing.JToggleButton();
        btnProduct8 = new javax.swing.JToggleButton();
        btnProduct9 = new javax.swing.JToggleButton();
        btnProduct7 = new javax.swing.JToggleButton();
        scrollPanelProductsTable = new javax.swing.JScrollPane();
        tblOrderDelivery = new javax.swing.JTable();
        txtOrderNumber = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        btnSelectedAmount = new javax.swing.JToggleButton();
        btnSelectedProducts = new javax.swing.JToggleButton();
        lblTotalOrder = new javax.swing.JLabel();
        txtTotalOrder = new javax.swing.JTextField();
        btnAdminBack = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        txtChangeOrder = new javax.swing.JTextField();
        btnSelectedAdditionalProduct = new javax.swing.JToggleButton();

        dlgOrderDelivery.setTitle("Buscar cliente");
        dlgOrderDelivery.setMinimumSize(new java.awt.Dimension(615, 775));
        dlgOrderDelivery.setSize(new java.awt.Dimension(615, 775));
        dlgOrderDelivery.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                dlgOrderDeliveryWindowClosing(evt);
            }
        });

        pnlCustomersDates.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.MatteBorder(null), "Datos ", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 12), java.awt.Color.red)); // NOI18N
        pnlCustomersDates.setOpaque(false);

        lbCustomersDocument.setFont(new java.awt.Font("Noto Sans", 0, 18)); // NOI18N
        lbCustomersDocument.setText("Cédula");

        txtCustomersName.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtCustomersName.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        lblCustomersName.setFont(new java.awt.Font("Noto Sans", 0, 18)); // NOI18N
        lblCustomersName.setText("Nombre");

        lblCustomersLastName.setFont(new java.awt.Font("Noto Sans", 0, 18)); // NOI18N
        lblCustomersLastName.setText("Apellidos");

        txtCustomersLastName.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtCustomersLastName.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        txtCustomerssAddress.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtCustomerssAddress.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        txtCustomersDocument.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtCustomersDocument.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtCustomersDocument.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCustomersDocumentKeyTyped(evt);
            }
        });

        lblCustomersAddress.setFont(new java.awt.Font("Noto Sans", 0, 18)); // NOI18N
        lblCustomersAddress.setText("Dirección");

        lblCustomersNeighborhood.setFont(new java.awt.Font("Noto Sans", 0, 18)); // NOI18N
        lblCustomersNeighborhood.setText("Barrio");

        txtCustomersNeighborhood.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtCustomersNeighborhood.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        lblCustomersNotes.setFont(new java.awt.Font("Noto Sans", 0, 18)); // NOI18N
        lblCustomersNotes.setText("Notas");

        txtCustomersNotes.setColumns(20);
        txtCustomersNotes.setRows(5);
        scrollNotes1.setViewportView(txtCustomersNotes);

        lblCustomersCity.setFont(new java.awt.Font("Noto Sans", 0, 18)); // NOI18N
        lblCustomersCity.setText("Departamento");

        lblCustomersTown.setFont(new java.awt.Font("Noto Sans", 0, 18)); // NOI18N
        lblCustomersTown.setText("Municipio");

        cbCustomersTown.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Manizales", "Villamaria" }));

        cbCustomersCity.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Caldas" }));

        lblPhone.setFont(new java.awt.Font("Noto Sans", 0, 18)); // NOI18N
        lblPhone.setText("Teléfono");

        txtCustomersPhone.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtCustomersPhone.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtCustomersPhone.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCustomersPhoneKeyTyped(evt);
            }
        });

        btnAddCustomer.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnAddCustomer.setText("Agregar");
        btnAddCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddCustomerActionPerformed(evt);
            }
        });

        btnSearchCustomerOrderDelivery.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnSearchCustomerOrderDelivery.setText("Buscar");
        btnSearchCustomerOrderDelivery.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchCustomerOrderDeliveryActionPerformed(evt);
            }
        });

        btnCancelOrderDelivery.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnCancelOrderDelivery.setText("Cancelar");
        btnCancelOrderDelivery.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelOrderDeliveryActionPerformed(evt);
            }
        });

        btnContinueOrderDelivery.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnContinueOrderDelivery.setText("Continuar");
        btnContinueOrderDelivery.setEnabled(false);
        btnContinueOrderDelivery.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnContinueOrderDeliveryActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlCustomersDatesLayout = new javax.swing.GroupLayout(pnlCustomersDates);
        pnlCustomersDates.setLayout(pnlCustomersDatesLayout);
        pnlCustomersDatesLayout.setHorizontalGroup(
            pnlCustomersDatesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCustomersDatesLayout.createSequentialGroup()
                .addGroup(pnlCustomersDatesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlCustomersDatesLayout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(pnlCustomersDatesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblCustomersNeighborhood)
                            .addComponent(lbCustomersDocument)
                            .addComponent(lblCustomersName)
                            .addComponent(lblCustomersLastName)
                            .addComponent(lblPhone)
                            .addComponent(lblCustomersAddress)
                            .addComponent(lblCustomersTown)
                            .addComponent(lblCustomersCity)
                            .addComponent(lblCustomersNotes)
                            .addComponent(btnCancelOrderDelivery, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(pnlCustomersDatesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlCustomersDatesLayout.createSequentialGroup()
                                .addGap(70, 70, 70)
                                .addComponent(btnAddCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlCustomersDatesLayout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addComponent(txtCustomersPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlCustomersDatesLayout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addComponent(scrollNotes1, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(pnlCustomersDatesLayout.createSequentialGroup()
                        .addGap(174, 174, 174)
                        .addGroup(pnlCustomersDatesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(pnlCustomersDatesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(cbCustomersTown, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(cbCustomersCity, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtCustomersName, javax.swing.GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)
                            .addComponent(txtCustomersLastName)
                            .addComponent(txtCustomerssAddress)
                            .addComponent(txtCustomersNeighborhood)
                            .addComponent(txtCustomersDocument))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlCustomersDatesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSearchCustomerOrderDelivery, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnContinueOrderDelivery, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(41, Short.MAX_VALUE))
        );
        pnlCustomersDatesLayout.setVerticalGroup(
            pnlCustomersDatesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlCustomersDatesLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlCustomersDatesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPhone)
                    .addComponent(txtCustomersPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearchCustomerOrderDelivery, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlCustomersDatesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbCustomersDocument)
                    .addComponent(txtCustomersDocument, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(pnlCustomersDatesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCustomersName)
                    .addComponent(txtCustomersName, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(pnlCustomersDatesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCustomersLastName)
                    .addComponent(txtCustomersLastName, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlCustomersDatesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCustomerssAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCustomersAddress))
                .addGap(24, 24, 24)
                .addGroup(pnlCustomersDatesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCustomersNeighborhood)
                    .addComponent(txtCustomersNeighborhood, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(pnlCustomersDatesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCustomersTown)
                    .addComponent(cbCustomersTown, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(pnlCustomersDatesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbCustomersCity, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCustomersCity))
                .addGroup(pnlCustomersDatesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlCustomersDatesLayout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(scrollNotes1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlCustomersDatesLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblCustomersNotes)
                        .addGap(56, 56, 56)))
                .addGroup(pnlCustomersDatesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlCustomersDatesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnCancelOrderDelivery, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnContinueOrderDelivery, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnAddCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(123, 123, 123))
        );

        javax.swing.GroupLayout dlgOrderDeliveryLayout = new javax.swing.GroupLayout(dlgOrderDelivery.getContentPane());
        dlgOrderDelivery.getContentPane().setLayout(dlgOrderDeliveryLayout);
        dlgOrderDeliveryLayout.setHorizontalGroup(
            dlgOrderDeliveryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dlgOrderDeliveryLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlCustomersDates, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(34, Short.MAX_VALUE))
        );
        dlgOrderDeliveryLayout.setVerticalGroup(
            dlgOrderDeliveryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dlgOrderDeliveryLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlCustomersDates, javax.swing.GroupLayout.PREFERRED_SIZE, 737, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        dlgOrderDelivery.getAccessibleContext().setAccessibleDescription("");

        dlgAdditionsOrderDelivery.setMinimumSize(new java.awt.Dimension(711, 423));
        dlgAdditionsOrderDelivery.setSize(new java.awt.Dimension(711, 523));
        dlgAdditionsOrderDelivery.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                dlgAdditionsOrderDeliveryWindowOpened(evt);
            }
        });

        pblAdditionsLocalOrder.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Adicionales", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), java.awt.Color.red)); // NOI18N

        additionsGroup.add(btnAdditionalProduct2);
        btnAdditionalProduct2.setText("Producto adicional 2");
        btnAdditionalProduct2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAdditionalProduct2MouseClicked(evt);
            }
        });

        additionsGroup.add(btnAdditionalProduct3);
        btnAdditionalProduct3.setText("Producto adicional 3");
        btnAdditionalProduct3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAdditionalProduct3MouseClicked(evt);
            }
        });

        additionsGroup.add(btnAdditionalProduct1);
        btnAdditionalProduct1.setText("Producto adicional 1");
        btnAdditionalProduct1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAdditionalProduct1MouseClicked(evt);
            }
        });
        btnAdditionalProduct1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdditionalProduct1ActionPerformed(evt);
            }
        });

        additionsGroup.add(btnAdditionalProduct6);
        btnAdditionalProduct6.setText("Producto adicional 6");
        btnAdditionalProduct6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAdditionalProduct6MouseClicked(evt);
            }
        });

        additionsGroup.add(btnAdditionalProduct4);
        btnAdditionalProduct4.setText("Producto adicional 4");
        btnAdditionalProduct4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAdditionalProduct4MouseClicked(evt);
            }
        });

        additionsGroup.add(btnAdditionalProduct5);
        btnAdditionalProduct5.setText("Producto adicional 5");
        btnAdditionalProduct5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAdditionalProduct5MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout pblAdditionsLocalOrderLayout = new javax.swing.GroupLayout(pblAdditionsLocalOrder);
        pblAdditionsLocalOrder.setLayout(pblAdditionsLocalOrderLayout);
        pblAdditionsLocalOrderLayout.setHorizontalGroup(
            pblAdditionsLocalOrderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pblAdditionsLocalOrderLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(pblAdditionsLocalOrderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pblAdditionsLocalOrderLayout.createSequentialGroup()
                        .addComponent(btnAdditionalProduct4, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnAdditionalProduct5, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnAdditionalProduct6, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pblAdditionsLocalOrderLayout.createSequentialGroup()
                        .addComponent(btnAdditionalProduct1, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnAdditionalProduct2, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnAdditionalProduct3, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        pblAdditionsLocalOrderLayout.setVerticalGroup(
            pblAdditionsLocalOrderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pblAdditionsLocalOrderLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pblAdditionsLocalOrderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdditionalProduct1, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAdditionalProduct2, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAdditionalProduct3, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pblAdditionsLocalOrderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdditionalProduct4, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAdditionalProduct5, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAdditionalProduct6, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        btnDlgAdditionsCancel.setText("Cancelar");
        btnDlgAdditionsCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDlgAdditionsCancelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout dlgAdditionsOrderDeliveryLayout = new javax.swing.GroupLayout(dlgAdditionsOrderDelivery.getContentPane());
        dlgAdditionsOrderDelivery.getContentPane().setLayout(dlgAdditionsOrderDeliveryLayout);
        dlgAdditionsOrderDeliveryLayout.setHorizontalGroup(
            dlgAdditionsOrderDeliveryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dlgAdditionsOrderDeliveryLayout.createSequentialGroup()
                .addGroup(dlgAdditionsOrderDeliveryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(dlgAdditionsOrderDeliveryLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(pblAdditionsLocalOrder, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(dlgAdditionsOrderDeliveryLayout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(btnDlgAdditionsCancel)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        dlgAdditionsOrderDeliveryLayout.setVerticalGroup(
            dlgAdditionsOrderDeliveryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dlgAdditionsOrderDeliveryLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pblAdditionsLocalOrder, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnDlgAdditionsCancel)
                .addContainerGap(49, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1382, 744));
        setSize(new java.awt.Dimension(1382, 744));
        addWindowStateListener(new java.awt.event.WindowStateListener() {
            public void windowStateChanged(java.awt.event.WindowEvent evt) {
                formWindowStateChanged(evt);
            }
        });
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        pnlAmount.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Cantidad", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 12), java.awt.Color.red)); // NOI18N
        pnlAmount.setLayout(null);

        numbersGroup.add(btnNumber6);
        btnNumber6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/numbers/iconNumber6.png"))); // NOI18N
        btnNumber6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnNumber6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNumber6ActionPerformed(evt);
            }
        });
        pnlAmount.add(btnNumber6);
        btnNumber6.setBounds(270, 110, 100, 80);

        numbersGroup.add(btnNumber2);
        btnNumber2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/numbers/iconNumber2.png"))); // NOI18N
        btnNumber2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnNumber2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNumber2ActionPerformed(evt);
            }
        });
        pnlAmount.add(btnNumber2);
        btnNumber2.setBounds(150, 20, 100, 80);

        numbersGroup.add(btnNumber1);
        btnNumber1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/numbers/iconNumber1.png"))); // NOI18N
        btnNumber1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnNumber1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNumber1ActionPerformed(evt);
            }
        });
        pnlAmount.add(btnNumber1);
        btnNumber1.setBounds(20, 20, 100, 80);

        numbersGroup.add(btnNumber3);
        btnNumber3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/numbers/iconNumber3.png"))); // NOI18N
        btnNumber3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnNumber3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNumber3ActionPerformed(evt);
            }
        });
        pnlAmount.add(btnNumber3);
        btnNumber3.setBounds(270, 20, 100, 80);

        numbersGroup.add(btnNumber4);
        btnNumber4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/numbers/iconNumber4.png"))); // NOI18N
        btnNumber4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnNumber4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNumber4ActionPerformed(evt);
            }
        });
        pnlAmount.add(btnNumber4);
        btnNumber4.setBounds(20, 110, 100, 80);

        numbersGroup.add(btnNumber5);
        btnNumber5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/numbers/iconNumber5.png"))); // NOI18N
        btnNumber5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnNumber5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNumber5ActionPerformed(evt);
            }
        });
        pnlAmount.add(btnNumber5);
        btnNumber5.setBounds(150, 110, 100, 80);

        numbersGroup.add(btnNumber7);
        btnNumber7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/numbers/iconNumber7.png"))); // NOI18N
        btnNumber7.setToolTipText("");
        btnNumber7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnNumber7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNumber7ActionPerformed(evt);
            }
        });
        pnlAmount.add(btnNumber7);
        btnNumber7.setBounds(20, 200, 100, 80);

        numbersGroup.add(btnNumber8);
        btnNumber8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/numbers/iconNumber8.png"))); // NOI18N
        btnNumber8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnNumber8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNumber8ActionPerformed(evt);
            }
        });
        pnlAmount.add(btnNumber8);
        btnNumber8.setBounds(150, 200, 100, 80);

        numbersGroup.add(btnNumber9);
        btnNumber9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/numbers/iconNumber9.png"))); // NOI18N
        btnNumber9.setToolTipText("");
        btnNumber9.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnNumber9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNumber9ActionPerformed(evt);
            }
        });
        pnlAmount.add(btnNumber9);
        btnNumber9.setBounds(270, 200, 100, 80);

        btnDoneOrder.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnDoneOrder.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/iconBtnDoneOrder.png"))); // NOI18N
        btnDoneOrder.setText("Finalizar");
        btnDoneOrder.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnDoneOrder.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnDoneOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDoneOrderActionPerformed(evt);
            }
        });
        pnlAmount.add(btnDoneOrder);
        btnDoneOrder.setBounds(260, 410, 100, 80);

        btnCorrection.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnCorrection.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/iconBtnCorrection.png"))); // NOI18N
        btnCorrection.setText("Corregir");
        btnCorrection.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCorrection.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnCorrection.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCorrectionActionPerformed(evt);
            }
        });
        pnlAmount.add(btnCorrection);
        btnCorrection.setBounds(20, 410, 100, 80);

        btnOtherAmount.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnOtherAmount.setText("Otra");
        numbersGroup.add(btnOtherAmount);
        btnOtherAmount.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnOtherAmount.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnOtherAmount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOtherAmountActionPerformed(evt);
            }
        });
        pnlAmount.add(btnOtherAmount);
        btnOtherAmount.setBounds(20, 300, 100, 80);

        btnAddProduct.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnAddProduct.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/iconBtnAdd.png"))); // NOI18N
        btnAddProduct.setText("Agregar");
        btnAddProduct.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnAddProduct.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnAddProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddProductActionPerformed(evt);
            }
        });
        pnlAmount.add(btnAddProduct);
        btnAddProduct.setBounds(140, 410, 100, 80);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Observaciones", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

        txtNotes.setColumns(20);
        txtNotes.setLineWrap(true);
        txtNotes.setRows(5);
        jScrollPane1.setViewportView(txtNotes);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 9, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 1, Short.MAX_VALUE))
        );

        pnlAmount.add(jPanel1);
        jPanel1.setBounds(140, 290, 220, 110);

        pnlProducts.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Productos", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 12), java.awt.Color.red)); // NOI18N

        productsGroup.add(btnProduct1);
        btnProduct1.setText("Combo 1");
        btnProduct1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProduct1ActionPerformed(evt);
            }
        });

        productsGroup.add(btnProduct2);
        btnProduct2.setText("Combo 2");
        btnProduct2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProduct2ActionPerformed(evt);
            }
        });

        productsGroup.add(btnProduct3);
        btnProduct3.setText("Combo 3");
        btnProduct3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProduct3ActionPerformed(evt);
            }
        });

        productsGroup.add(btnProduct4);
        btnProduct4.setText("Combo 4");
        btnProduct4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProduct4ActionPerformed(evt);
            }
        });

        productsGroup.add(btnProduct5);
        btnProduct5.setText("Combo 5");
        btnProduct5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProduct5ActionPerformed(evt);
            }
        });

        productsGroup.add(btnProduct6);
        btnProduct6.setText("Adicionales");
        btnProduct6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnProduct6MouseClicked(evt);
            }
        });
        btnProduct6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProduct6ActionPerformed(evt);
            }
        });

        productsGroup.add(btnProduct8);
        btnProduct8.setText("Producto2");
        btnProduct8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProduct8ActionPerformed(evt);
            }
        });

        productsGroup.add(btnProduct9);
        btnProduct9.setText("Producto3");
        btnProduct9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProduct9ActionPerformed(evt);
            }
        });

        productsGroup.add(btnProduct7);
        btnProduct7.setText("Producto1");
        btnProduct7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProduct7ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlProductsLayout = new javax.swing.GroupLayout(pnlProducts);
        pnlProducts.setLayout(pnlProductsLayout);
        pnlProductsLayout.setHorizontalGroup(
            pnlProductsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlProductsLayout.createSequentialGroup()
                .addGroup(pnlProductsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pnlProductsLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(btnProduct1, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnProduct2, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14)
                        .addComponent(btnProduct3, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlProductsLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(pnlProductsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnProduct4, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnProduct7, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnlProductsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlProductsLayout.createSequentialGroup()
                                .addComponent(btnProduct8, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnProduct9, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlProductsLayout.createSequentialGroup()
                                .addComponent(btnProduct5, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnProduct6, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        pnlProductsLayout.setVerticalGroup(
            pnlProductsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlProductsLayout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(pnlProductsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnProduct1, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnProduct2, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnProduct3, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlProductsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnProduct5, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnProduct6, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnProduct4, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlProductsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnProduct8, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnProduct9, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnProduct7, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tblOrderDelivery.setShowVerticalLines(false);
        tblOrderDelivery.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblOrderDeliveryMouseClicked(evt);
            }
        });
        scrollPanelProductsTable.setViewportView(tblOrderDelivery);

        txtOrderNumber.setEditable(false);
        txtOrderNumber.setBackground(new java.awt.Color(255, 255, 255));
        txtOrderNumber.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtOrderNumber.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Número de orden");

        numbersGroup.add(btnSelectedAmount);
        btnSelectedAmount.setText("Cantidad");

        productsGroup.add(btnSelectedProducts);
        btnSelectedProducts.setText("Productos");

        lblTotalOrder.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblTotalOrder.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTotalOrder.setText("Total Pedido");

        txtTotalOrder.setEditable(false);
        txtTotalOrder.setBackground(new java.awt.Color(255, 255, 255));
        txtTotalOrder.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        txtTotalOrder.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        btnAdminBack.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnAdminBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/back.png"))); // NOI18N
        btnAdminBack.setText("Volver");
        btnAdminBack.setBorderPainted(false);
        btnAdminBack.setContentAreaFilled(false);
        btnAdminBack.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAdminBack.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnAdminBack.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnAdminBack.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnAdminBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdminBackActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setText("Cuánto devolver");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        txtChangeOrder.setEditable(false);
        txtChangeOrder.setBackground(new java.awt.Color(255, 255, 255));
        txtChangeOrder.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        txtChangeOrder.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        additionsGroup.add(btnSelectedAdditionalProduct);
        btnSelectedAdditionalProduct.setText("Cantidad");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1409, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(1170, 1170, 1170)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(16, 16, 16)
                            .addComponent(pnlProducts, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(15, 15, 15)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(btnSelectedProducts, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnSelectedAdditionalProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnSelectedAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(90, 90, 90)
                            .addComponent(pnlAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(30, 30, 30)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(60, 60, 60)
                                    .addComponent(txtOrderNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtChangeOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblTotalOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtTotalOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addComponent(scrollPanelProductsTable, javax.swing.GroupLayout.PREFERRED_SIZE, 1240, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(1230, 1230, 1230)
                            .addComponent(btnAdminBack, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 760, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(pnlProducts, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(60, 60, 60)
                            .addComponent(btnSelectedProducts, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(20, 20, 20)
                            .addComponent(btnSelectedAdditionalProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(10, 10, 10)
                            .addComponent(btnSelectedAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(pnlAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 510, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(txtOrderNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(200, 200, 200)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(10, 10, 10)
                            .addComponent(txtChangeOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(40, 40, 40)
                            .addComponent(lblTotalOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(0, 0, 0)
                            .addComponent(txtTotalOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(scrollPanelProductsTable, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(90, 90, 90)
                            .addComponent(btnAdminBack, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtCustomersDocumentKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCustomersDocumentKeyTyped
        onlyNumbersInTextField(evt, txtCustomersDocument, 12);
    }//GEN-LAST:event_txtCustomersDocumentKeyTyped

    private void txtCustomersPhoneKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCustomersPhoneKeyTyped
        onlyNumbersInTextField(evt, txtCustomersPhone, 10);
    }//GEN-LAST:event_txtCustomersPhoneKeyTyped

    private void btnAddCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddCustomerActionPerformed
        loadSetValuesCustomers();
        if (validateFields()) {
            if (customers.insert()) {
                JOptionPane.showMessageDialog(dlgOrderDelivery, "Se insertó el cliente correctamente, ya puede hacer su pedido");
                //  frmMain.setVisible(false);
                dlgOrderDelivery.dispose();
                this.setVisible(true);

                cleanTextboxCustomers();

                // frmMain.processWindowEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
            } else {
                JOptionPane.showMessageDialog(dlgOrderDelivery, "No sé insertó el cliente, por favor verifique nuevamente");
            }
        } else {
            JOptionPane.showMessageDialog(dlgOrderDelivery, "Por favor rellene los campos que están subrayados en rojo.");

        }


    }//GEN-LAST:event_btnAddCustomerActionPerformed

    public boolean validateFields() {
        boolean state = true;

        if (txtCustomersPhone.getText().isEmpty()) {
            txtCustomersPhone.setBorder(borderEmptyField);
            state = false;
        } else if (txtCustomersPhone.getBorder().equals(borderEmptyField)) {
            txtCustomersPhone.setBorder(borderDefault);
        }

        if (txtCustomersName.getText().isEmpty()) {
            txtCustomersName.setBorder(borderEmptyField);
            state = false;
        } else if (txtCustomersName.getBorder().equals(borderEmptyField)) {
            txtCustomersName.setBorder(borderDefault);
        }

        if (txtCustomersNeighborhood.getText().isEmpty()) {
            txtCustomersNeighborhood.setBorder(borderEmptyField);
            state = false;
        } else if (txtCustomersNeighborhood.getBorder().equals(borderEmptyField)) {
            txtCustomersNeighborhood.setBorder(borderDefault);
        }

        if (txtCustomerssAddress.getText().isEmpty()) {
            txtCustomerssAddress.setBorder(borderEmptyField);
            state = false;
        } else if (txtCustomerssAddress.getBorder().equals(borderEmptyField)) {
            txtCustomerssAddress.setBorder(borderDefault);
        }

        return state;

    }


    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        loadNameProductValues();
        loadAdditionalProductsValues();
        orderDelivery = new clsDAOOrderDeliveryDetails();
        txtOrderNumber.setText(orderDelivery.selectOrderNumber());
        txtTotalOrder.setText("0");
        btnSelectedAmount.setSelected(true);
        btnSelectedProducts.setSelected(true);
        btnSelectedAdditionalProduct.setSelected(true);
        btnSelectedAmount.setVisible(false);
        btnSelectedProducts.setVisible(false);
        btnSelectedAdditionalProduct.setVisible(false);

    }//GEN-LAST:event_formWindowOpened

    private void btnSearchCustomerOrderDeliveryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchCustomerOrderDeliveryActionPerformed

        try {
            customers = new clsDAOCustomers();
            ResultSet result;
            String search = JOptionPane.showInputDialog("Por favor ingrese el número telefónico o el nombre de la persona a buscar");
            customers.setSearch(search);
            result = customers.search();
            if (result != null) {
                customers_id = result.getString(1);
                txtCustomersDocument.setText(result.getString(2));
                txtCustomersName.setText(result.getString(3));
                txtCustomersLastName.setText(result.getString(4));
                txtCustomerssAddress.setText(result.getString(5));
                txtCustomersNeighborhood.setText(result.getString(6));
                txtCustomersPhone.setText(result.getString(9));
                txtCustomersNotes.setText(result.getString(10));
                txtCustomersDocument.setEnabled(false);
                txtCustomersName.setEnabled(false);
                txtCustomersLastName.setEnabled(false);
                txtCustomerssAddress.setEnabled(false);
                txtCustomersNeighborhood.setEnabled(false);
                txtCustomersPhone.setEnabled(false);
                txtCustomersNotes.setEnabled(false);
                btnAddCustomer.setEnabled(false);
                btnContinueOrderDelivery.setEnabled(true);

            } else {
                JOptionPane.showMessageDialog(rootPane, "El cliente no existe, por favor créelo aquí y después de clic en el botón agregar..");
            }

        } catch (SQLException ex) {
            Logger.getLogger(frmAdministration.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btnSearchCustomerOrderDeliveryActionPerformed

    private void btnCancelOrderDeliveryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelOrderDeliveryActionPerformed
        dlgOrderDelivery.dispose();
        cleanTextboxCustomers();

    }//GEN-LAST:event_btnCancelOrderDeliveryActionPerformed

    private void btnContinueOrderDeliveryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnContinueOrderDeliveryActionPerformed
        this.setVisible(true);
        dlgOrderDelivery.dispose();
        cleanTextboxCustomers();
    }//GEN-LAST:event_btnContinueOrderDeliveryActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
    }//GEN-LAST:event_formWindowActivated

    private void btnNumber6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNumber6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnNumber6ActionPerformed

    private void btnNumber2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNumber2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnNumber2ActionPerformed

    private void btnNumber1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNumber1ActionPerformed

    }//GEN-LAST:event_btnNumber1ActionPerformed

    private void btnNumber3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNumber3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnNumber3ActionPerformed

    private void btnNumber4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNumber4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnNumber4ActionPerformed

    private void btnNumber5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNumber5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnNumber5ActionPerformed

    private void btnNumber7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNumber7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnNumber7ActionPerformed

    private void btnNumber8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNumber8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnNumber8ActionPerformed

    private void btnNumber9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNumber9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnNumber9ActionPerformed

    private void btnDoneOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDoneOrderActionPerformed
        if (tblOrderDelivery.getRowCount() > 0) {
            if (JOptionPane.showConfirmDialog(this,
                    "Desea confirmar el pedido con número de orden " + txtOrderNumber.getText(), "Confirmar pedido",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {
                ResultSet result = orderDelivery.searchEmployeesJobDelivery();
                JComboBox jcbListEmployees = new JComboBox();
                ArrayList<String> listEmployees_id = new ArrayList<>();
                String employee_id = "";
                try {
                    jcbListEmployees.addItem(result.getString(2));
                    listEmployees_id.add(result.getString(1));
                    while (result.next()) {
                        jcbListEmployees.addItem(result.getString(2));
                        listEmployees_id.add(result.getString(1));
                    }
                } catch (SQLException ex) {
                    System.out.println(ex);
                }
                if (listEmployees_id.size() > 0) {

                    JOptionPane.showMessageDialog(null, jcbListEmployees, "¿Quién llevará el domicilio?", JOptionPane.QUESTION_MESSAGE);
                    employee_id = listEmployees_id.get(jcbListEmployees.getSelectedIndex());
                }
                if (orderDelivery.insertOrderFull(txtOrderNumber.getText(), txtTotalOrder.getText(), employee_id)) {
                    txtOrderNumber.setText(orderDelivery.incrementOrderNumber());
                    txtTotalOrder.setText("0");

                    clearTable(tblOrderDelivery);
                    JOptionPane.showMessageDialog(this, "La orden ha sido procesada con éxito");
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "No hay todavía ningún producto para realizar la compra.");
        }
    }//GEN-LAST:event_btnDoneOrderActionPerformed

    public void clearTable(JTable table) {
        DefaultTableModel dm = (DefaultTableModel) table.getModel();
        int rowCount = dm.getRowCount();
        for (int i = rowCount - 1; i >= 0; i--) {
            dm.removeRow(i);
        }

        table.setModel(dm);
    }

    private void btnCorrectionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCorrectionActionPerformed
        if (tblOrderDelivery.getRowCount() > 0) {
            deleteSelectionState = 1;
            JOptionPane.showMessageDialog(this, "Por favor seleccione la fila del producto que desea eliminar.");
        }
    }//GEN-LAST:event_btnCorrectionActionPerformed

    private void btnOtherAmountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOtherAmountActionPerformed
        //PrintselectProductAndAmount();

        if (!btnSelectedProducts.isSelected()) {

            btnSelectedAmount.setSelected(true);
            String inputValue = JOptionPane.showInputDialog("Por favor ingrese la cantidad que necesita");
            if (inputValue == null || inputValue.isEmpty() || inputValue == "") {
                JOptionPane.showMessageDialog(this, "Por favor ingrese una cantidad");
            } else {
                double amount = Double.parseDouble(inputValue);
                if (amount > 9) {
                    if (!btnProduct6.isSelected()) {
                        if (btnProduct1.isSelected()) {
                            loadSetValuesOrderDetails(btnProduct1.getText(), amount);
                        } else if (btnProduct2.isSelected()) {
                            loadSetValuesOrderDetails(btnProduct2.getText(), amount);
                        } else if (btnProduct3.isSelected()) {
                            loadSetValuesOrderDetails(btnProduct3.getText(), amount);
                        } else if (btnProduct4.isSelected()) {
                            loadSetValuesOrderDetails(btnProduct4.getText(), amount);
                        } else if (btnProduct5.isSelected()) {
                            loadSetValuesOrderDetails(btnProduct5.getText(), amount);
                        } else if (btnProduct7.isSelected()) {
                            loadSetValuesOrderDetails(btnProduct7.getText(), amount);
                        } else if (btnProduct8.isSelected()) {
                            loadSetValuesOrderDetails(btnProduct8.getText(), amount);
                        } else if (btnProduct9.isSelected()) {
                            loadSetValuesOrderDetails(btnProduct9.getText(), amount);
                        }
                        if (orderDelivery.insertProduct()) {
                            txtTotalOrder.setText(orderDelivery.selectTotalOrder(txtOrderNumber.getText()));
                            tblOrderDelivery.setModel(orderDelivery.list(txtOrderNumber.getText()));
                            txtNotes.setText("");

                        } else {
                            JOptionPane.showMessageDialog(rootPane, "No sé insertó el producto");
                        }
                    } else if (btnProduct6.isSelected()) {
                        stateTypeProduct = 1;
                        loadSetValuesOrderDetails(selectAdditionalProductAndAmount(), amount);
                        if (orderDelivery.insertAdditionalProduct()) {
                            txtTotalOrder.setText(orderDelivery.selectTotalOrder(txtOrderNumber.getText()));
                            tblOrderDelivery.setModel(orderDelivery.list(txtOrderNumber.getText()));
                            txtNotes.setText("");
                        } else {
                            JOptionPane.showMessageDialog(rootPane, "No sé insertó el producto");
                        }

                    }
                } else {
                    JOptionPane.showMessageDialog(this, "La cantidad debe ser igual o mayor a 10");
                }
            }
        }

        btnSelectedAmount.setSelected(true);
        btnSelectedProducts.setSelected(true);
        btnSelectedAdditionalProduct.setSelected(true);

    }//GEN-LAST:event_btnOtherAmountActionPerformed

    private void btnAddProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddProductActionPerformed
        selectProductAndAmount();
        if (!btnProduct6.isSelected()) {
            if (!btnSelectedProducts.isSelected()) {
                if (!btnSelectedAmount.isSelected()) {

                    if (orderDelivery.insertProduct()) {
                        txtTotalOrder.setText(orderDelivery.selectTotalOrder(txtOrderNumber.getText()));
                        tblOrderDelivery.setModel(orderDelivery.list(txtOrderNumber.getText()));
                        txtNotes.setText("");

                    } else {
                        JOptionPane.showMessageDialog(rootPane, "No sé insertó el producto");
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Por favor seleccione una cantidad");
                }

            } else {
                JOptionPane.showMessageDialog(this, "Por favor seleccione un producto");

            }
        } else if (btnProduct6.isSelected()) {
            if (!btnSelectedAdditionalProduct.isSelected()) {
                if (!btnSelectedAmount.isSelected()) {
                    if (orderDelivery.insertAdditionalProduct()) {
                        txtTotalOrder.setText(orderDelivery.selectTotalOrder(txtOrderNumber.getText()));
                        tblOrderDelivery.setModel(orderDelivery.list(txtOrderNumber.getText()));
                        txtNotes.setText("");
                    } else {
                        JOptionPane.showMessageDialog(rootPane, "No sé insertó el producto");
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Por favor seleccione una cantidad");
                }
            }

        }

        btnSelectedAmount.setSelected(true);
        btnSelectedProducts.setSelected(true);
        btnSelectedAdditionalProduct.setSelected(true);
    }//GEN-LAST:event_btnAddProductActionPerformed

    private void btnProduct1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProduct1ActionPerformed

    }//GEN-LAST:event_btnProduct1ActionPerformed

    private void btnProduct2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProduct2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnProduct2ActionPerformed

    private void btnProduct3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProduct3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnProduct3ActionPerformed

    private void btnProduct4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProduct4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnProduct4ActionPerformed

    private void btnProduct5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProduct5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnProduct5ActionPerformed

    private void btnProduct6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnProduct6MouseClicked
        dlgAdditionsOrderDelivery.setVisible(true);
    }//GEN-LAST:event_btnProduct6MouseClicked

    private void btnProduct6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProduct6ActionPerformed

    }//GEN-LAST:event_btnProduct6ActionPerformed

    private void btnProduct8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProduct8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnProduct8ActionPerformed

    private void btnProduct9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProduct9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnProduct9ActionPerformed

    private void btnProduct7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProduct7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnProduct7ActionPerformed

    private void tblOrderDeliveryMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblOrderDeliveryMouseClicked
        try {
            if (deleteSelectionState == 1) {
                orderDelivery = new clsDAOOrderDeliveryDetails();
                String selection = String.valueOf(tblOrderDelivery.getValueAt(tblOrderDelivery.getSelectedRow(), 0));
                if (JOptionPane.showConfirmDialog(this,
                        "Está seguro que desea eliminar el producto:\n " + (tblOrderDelivery.getValueAt(tblOrderDelivery.getSelectedRow(), 1)) + "\nCon valor de: " + (tblOrderDelivery.getValueAt(tblOrderDelivery.getSelectedRow(), 5)), "Eliminar producto",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {
                    orderDelivery.setLocalOrder_id(selection);
                    orderDelivery.delete(orderDelivery.getLocalOrder_id());
                    tblOrderDelivery.setModel(orderDelivery.list(txtOrderNumber.getText()));
                    txtTotalOrder.setText(orderDelivery.selectTotalOrder(txtOrderNumber.getText()));
                    deleteSelectionState = 0;
                } else {
                    deleteSelectionState = 0;
                }

            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }//GEN-LAST:event_tblOrderDeliveryMouseClicked

    private void btnAdminBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdminBackActionPerformed
        if (tblOrderDelivery.getRowCount() > 0) {
            if (JOptionPane.showConfirmDialog(this,
                    "Está en la mitad de un pedido, si sale, el pedido será eliminado ¿Está seguro de que quiere salir? ", "Salir y cancelar pedido?",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {
                orderDelivery.cancelOrderButtonBack(txtOrderNumber.getText());
                this.setVisible(false);
                clearTable(tblOrderDelivery);

            } else {
                this.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
            }
        }

    }//GEN-LAST:event_btnAdminBackActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        double change = Double.parseDouble(JOptionPane.showInputDialog("Devuelta de cuánto?"));
        double total = Double.parseDouble(txtTotalOrder.getText());
        if (change < total) {
            JOptionPane.showMessageDialog(this, "El valor que ingresó es menor al total del pedido, por favor ingréselo nuevamente");
        } else {
            txtChangeOrder.setText((change - total) + "");

        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnAdditionalProduct2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAdditionalProduct2MouseClicked
        dlgAdditionsOrderDelivery.setVisible(false);
        this.setVisible(true);
        btnProduct6.isSelected();
    }//GEN-LAST:event_btnAdditionalProduct2MouseClicked

    private void btnAdditionalProduct3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAdditionalProduct3MouseClicked
        dlgAdditionsOrderDelivery.setVisible(false);
        this.setVisible(true);
        btnProduct6.isSelected();
    }//GEN-LAST:event_btnAdditionalProduct3MouseClicked

    private void btnAdditionalProduct1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAdditionalProduct1MouseClicked
        dlgAdditionsOrderDelivery.setVisible(false);
        this.setVisible(true);
        btnProduct6.isSelected();
    }//GEN-LAST:event_btnAdditionalProduct1MouseClicked

    private void btnAdditionalProduct1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdditionalProduct1ActionPerformed

    }//GEN-LAST:event_btnAdditionalProduct1ActionPerformed

    private void btnAdditionalProduct6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAdditionalProduct6MouseClicked
        dlgAdditionsOrderDelivery.setVisible(false);
        this.setVisible(true);
        btnProduct6.isSelected();
    }//GEN-LAST:event_btnAdditionalProduct6MouseClicked

    private void btnAdditionalProduct4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAdditionalProduct4MouseClicked
        dlgAdditionsOrderDelivery.setVisible(false);
        this.setVisible(true);
        btnProduct6.isSelected();
    }//GEN-LAST:event_btnAdditionalProduct4MouseClicked

    private void btnAdditionalProduct5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAdditionalProduct5MouseClicked
        dlgAdditionsOrderDelivery.setVisible(false);
        this.setVisible(true);
        btnProduct6.isSelected();
    }//GEN-LAST:event_btnAdditionalProduct5MouseClicked

    private void btnDlgAdditionsCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDlgAdditionsCancelActionPerformed
        btnSelectedAdditionalProduct.setSelected(true);
        btnSelectedAmount.setSelected(true);
        btnSelectedProducts.setSelected(true);
        dlgAdditionsOrderDelivery.setVisible(false);
        this.setVisible(true);
    }//GEN-LAST:event_btnDlgAdditionsCancelActionPerformed

    private void dlgAdditionsOrderDeliveryWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_dlgAdditionsOrderDeliveryWindowOpened

    }//GEN-LAST:event_dlgAdditionsOrderDeliveryWindowOpened

    private void dlgOrderDeliveryWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_dlgOrderDeliveryWindowClosing
        dlgOrderDelivery.dispose();
        cleanTextboxCustomers();
    }//GEN-LAST:event_dlgOrderDeliveryWindowClosing

    private void formWindowStateChanged(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowStateChanged

    }//GEN-LAST:event_formWindowStateChanged

    /**
     * Método que solo admite números y una longitud máxima de 8 caracteres.
     * Entra como parámetro un evento, que es cuando se presiona una tecla y una
     * caja de texto, la cual es la evaluada.
     *
     * @param evt
     * @param txtNumber
     * @param amountCharacters
     */
    public void onlyNumbersInTextField(java.awt.event.KeyEvent evt, JTextField txtNumber, int amountCharacters) {
        if (!Character.isDigit(evt.getKeyChar()) && !Character.isISOControl(evt.getKeyChar())) {
            Toolkit.getDefaultToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(null, "Por favor ingrese solamente números, sin puntuación o letras", "Validando datos", JOptionPane.ERROR_MESSAGE);
        }
        int k = (int) evt.getKeyChar();
        if (txtNumber.getText().length() >= amountCharacters) {
            evt.setKeyChar((char) KeyEvent.VK_CLEAR);//Limpiar el caracter ingresado
            JOptionPane.showMessageDialog(null, "Ha excedido el número máximo de caracteres! (" + amountCharacters + ")", "Validando Datos", JOptionPane.ERROR_MESSAGE);
        }

    }

    /**
     * Carga los valores de la clase employees con los valores que tienen las
     * cajas de texto del JDialog employees
     */
    public void loadSetValuesCustomers() {
        customers = new clsDAOCustomers();
        customers.setDocument_id(txtCustomersDocument.getText());
        customers.setNamec(txtCustomersName.getText());
        customers.setLastname(txtCustomersLastName.getText());
        customers.setAddress(txtCustomerssAddress.getText());
        customers.setNeighborhoos(txtCustomersNeighborhood.getText());
        customers.setTown(cbCustomersTown.getSelectedItem().toString());
        customers.setCity(cbCustomersCity.getSelectedItem().toString());
        customers.setPhone(txtCustomersPhone.getText());
        customers.setNotes(txtCustomersNotes.getText());
        customers.setCustomers_id(customers_id);
    }

    /**
     * Limpia todas las cajas de texto del JDialog de consumidores, cambia
     * cualquier valor que tengan por vacío
     */
    public void cleanTextboxCustomers() {
        txtCustomersDocument.setText("");
        txtCustomersName.setText("");
        txtCustomersLastName.setText("");
        txtCustomerssAddress.setText("");
        txtCustomersNeighborhood.setText("");
        txtCustomersPhone.setText("");
        txtCustomersNotes.setText("");
        txtCustomersDocument.setEnabled(true);
        txtCustomersName.setEnabled(true);
        txtCustomersLastName.setEnabled(true);
        txtCustomerssAddress.setEnabled(true);
        txtCustomersNeighborhood.setEnabled(true);
        txtCustomersPhone.setEnabled(true);
        txtCustomersNotes.setEnabled(true);
        btnAddCustomer.setEnabled(true);
        btnContinueOrderDelivery.setEnabled(false);
    }

    /**
     * Carga los valores de la clase products con los valores que tienen las
     * cajas de texto del JDialog products
     *
     * @param nameP
     * @param amount
     */
    public void loadSetValuesOrderDetails(String nameP, double amount) {
        try {
            orderDelivery = new clsDAOOrderDeliveryDetails();
            orderDelivery.setCustomers_id(customers_id);
            orderDelivery.setProduct_name(nameP);
            orderDelivery.setProduct_amount(amount);
            orderDelivery.setNotes(txtNotes.getText());
            ResultSet result;
            if (stateTypeProduct == 0) {
                result = orderDelivery.searchProductByName();
                if (result != null) {
                    orderDelivery.setProduct_id(result.getString(1));
                    orderDelivery.setProduct_description(result.getString(3));
                    orderDelivery.setProduct_price(Double.parseDouble(result.getString(4)));
                    orderDelivery.setProduct_price_total(orderDelivery.getProduct_amount() * orderDelivery.getProduct_price());
                }

            } else if (stateTypeProduct == 1) {
                result = orderDelivery.searchAdditionalProductByName();
                if (result != null) {
                    orderDelivery.setAdditional_products_id(result.getString(1));
                    orderDelivery.setProduct_description(result.getString(3));
                    orderDelivery.setProduct_price(Double.parseDouble(result.getString(4)));
                    orderDelivery.setProduct_price_total(orderDelivery.getProduct_amount() * orderDelivery.getProduct_price());
                }
                stateTypeProduct = 0;
            }

        } catch (SQLException ex) {
            System.out.println(ex);
        }

    }

    public void selectProductAndAmount() {
        if (btnProduct1.isSelected() && btnNumber1.isSelected()) {
            loadSetValuesOrderDetails(btnProduct1.getText(), 1);
        } else if (btnProduct1.isSelected() && btnNumber2.isSelected()) {
            loadSetValuesOrderDetails(btnProduct1.getText(), 2);
        } else if (btnProduct1.isSelected() && btnNumber3.isSelected()) {
            loadSetValuesOrderDetails(btnProduct1.getText(), 3);
        } else if (btnProduct1.isSelected() && btnNumber4.isSelected()) {
            loadSetValuesOrderDetails(btnProduct1.getText(), 4);
        } else if (btnProduct1.isSelected() && btnNumber5.isSelected()) {
            loadSetValuesOrderDetails(btnProduct1.getText(), 5);
        } else if (btnProduct1.isSelected() && btnNumber6.isSelected()) {
            loadSetValuesOrderDetails(btnProduct1.getText(), 6);
        } else if (btnProduct1.isSelected() && btnNumber7.isSelected()) {
            loadSetValuesOrderDetails(btnProduct1.getText(), 7);
        } else if (btnProduct1.isSelected() && btnNumber8.isSelected()) {
            loadSetValuesOrderDetails(btnProduct1.getText(), 8);
        } else if (btnProduct1.isSelected() && btnNumber9.isSelected()) {
            loadSetValuesOrderDetails(btnProduct1.getText(), 9);
        } else if (btnProduct2.isSelected() && btnNumber1.isSelected()) {
            loadSetValuesOrderDetails(btnProduct2.getText(), 1);
        } else if (btnProduct2.isSelected() && btnNumber2.isSelected()) {
            loadSetValuesOrderDetails(btnProduct2.getText(), 2);
        } else if (btnProduct2.isSelected() && btnNumber3.isSelected()) {
            loadSetValuesOrderDetails(btnProduct2.getText(), 3);
        } else if (btnProduct2.isSelected() && btnNumber4.isSelected()) {
            loadSetValuesOrderDetails(btnProduct2.getText(), 4);
        } else if (btnProduct2.isSelected() && btnNumber5.isSelected()) {
            loadSetValuesOrderDetails(btnProduct2.getText(), 5);
        } else if (btnProduct2.isSelected() && btnNumber6.isSelected()) {
            loadSetValuesOrderDetails(btnProduct2.getText(), 6);
        } else if (btnProduct2.isSelected() && btnNumber7.isSelected()) {
            loadSetValuesOrderDetails(btnProduct2.getText(), 7);
        } else if (btnProduct2.isSelected() && btnNumber8.isSelected()) {
            loadSetValuesOrderDetails(btnProduct2.getText(), 8);
        } else if (btnProduct2.isSelected() && btnNumber9.isSelected()) {
            loadSetValuesOrderDetails(btnProduct2.getText(), 9);
        } else if (btnProduct3.isSelected() && btnNumber1.isSelected()) {
            loadSetValuesOrderDetails(btnProduct3.getText(), 1);
        } else if (btnProduct3.isSelected() && btnNumber2.isSelected()) {
            loadSetValuesOrderDetails(btnProduct3.getText(), 2);
        } else if (btnProduct3.isSelected() && btnNumber3.isSelected()) {
            loadSetValuesOrderDetails(btnProduct3.getText(), 3);
        } else if (btnProduct3.isSelected() && btnNumber4.isSelected()) {
            loadSetValuesOrderDetails(btnProduct3.getText(), 4);
        } else if (btnProduct3.isSelected() && btnNumber5.isSelected()) {
            loadSetValuesOrderDetails(btnProduct3.getText(), 5);
        } else if (btnProduct3.isSelected() && btnNumber6.isSelected()) {
            loadSetValuesOrderDetails(btnProduct3.getText(), 6);
        } else if (btnProduct3.isSelected() && btnNumber7.isSelected()) {
            loadSetValuesOrderDetails(btnProduct3.getText(), 7);
        } else if (btnProduct3.isSelected() && btnNumber8.isSelected()) {
            loadSetValuesOrderDetails(btnProduct3.getText(), 8);
        } else if (btnProduct3.isSelected() && btnNumber9.isSelected()) {
            loadSetValuesOrderDetails(btnProduct3.getText(), 9);
        } else if (btnProduct4.isSelected() && btnNumber1.isSelected()) {
            loadSetValuesOrderDetails(btnProduct4.getText(), 1);
        } else if (btnProduct4.isSelected() && btnNumber2.isSelected()) {
            loadSetValuesOrderDetails(btnProduct4.getText(), 2);
        } else if (btnProduct4.isSelected() && btnNumber3.isSelected()) {
            loadSetValuesOrderDetails(btnProduct4.getText(), 3);
        } else if (btnProduct4.isSelected() && btnNumber4.isSelected()) {
            loadSetValuesOrderDetails(btnProduct4.getText(), 4);
        } else if (btnProduct4.isSelected() && btnNumber5.isSelected()) {
            loadSetValuesOrderDetails(btnProduct4.getText(), 5);
        } else if (btnProduct4.isSelected() && btnNumber6.isSelected()) {
            loadSetValuesOrderDetails(btnProduct4.getText(), 6);
        } else if (btnProduct4.isSelected() && btnNumber7.isSelected()) {
            loadSetValuesOrderDetails(btnProduct4.getText(), 7);
        } else if (btnProduct4.isSelected() && btnNumber8.isSelected()) {
            loadSetValuesOrderDetails(btnProduct4.getText(), 8);
        } else if (btnProduct4.isSelected() && btnNumber9.isSelected()) {
            loadSetValuesOrderDetails(btnProduct4.getText(), 9);
        } else if (btnProduct5.isSelected() && btnNumber1.isSelected()) {
            loadSetValuesOrderDetails(btnProduct5.getText(), 1);
        } else if (btnProduct5.isSelected() && btnNumber2.isSelected()) {
            loadSetValuesOrderDetails(btnProduct5.getText(), 2);
        } else if (btnProduct5.isSelected() && btnNumber3.isSelected()) {
            loadSetValuesOrderDetails(btnProduct5.getText(), 3);
        } else if (btnProduct5.isSelected() && btnNumber4.isSelected()) {
            loadSetValuesOrderDetails(btnProduct5.getText(), 4);
        } else if (btnProduct5.isSelected() && btnNumber5.isSelected()) {
            loadSetValuesOrderDetails(btnProduct5.getText(), 5);
        } else if (btnProduct5.isSelected() && btnNumber6.isSelected()) {
            loadSetValuesOrderDetails(btnProduct5.getText(), 6);
        } else if (btnProduct5.isSelected() && btnNumber7.isSelected()) {
            loadSetValuesOrderDetails(btnProduct5.getText(), 7);
        } else if (btnProduct5.isSelected() && btnNumber8.isSelected()) {
            loadSetValuesOrderDetails(btnProduct5.getText(), 8);
        } else if (btnProduct5.isSelected() && btnNumber9.isSelected()) {
            loadSetValuesOrderDetails(btnProduct5.getText(), 9);
        } else if (btnProduct6.isSelected() && btnNumber1.isSelected()) {
            stateTypeProduct = 1;
            loadSetValuesOrderDetails(selectAdditionalProductAndAmount(), 1);
        } else if (btnProduct6.isSelected() && btnNumber2.isSelected()) {
            stateTypeProduct = 1;
            loadSetValuesOrderDetails(selectAdditionalProductAndAmount(), 2);
        } else if (btnProduct6.isSelected() && btnNumber3.isSelected()) {
            stateTypeProduct = 1;
            loadSetValuesOrderDetails(selectAdditionalProductAndAmount(), 3);
        } else if (btnProduct6.isSelected() && btnNumber4.isSelected()) {
            stateTypeProduct = 1;
            loadSetValuesOrderDetails(selectAdditionalProductAndAmount(), 4);
        } else if (btnProduct6.isSelected() && btnNumber5.isSelected()) {
            stateTypeProduct = 1;
            loadSetValuesOrderDetails(selectAdditionalProductAndAmount(), 5);
        } else if (btnProduct6.isSelected() && btnNumber6.isSelected()) {
            stateTypeProduct = 1;
            loadSetValuesOrderDetails(selectAdditionalProductAndAmount(), 6);
        } else if (btnProduct6.isSelected() && btnNumber7.isSelected()) {
            stateTypeProduct = 1;
            loadSetValuesOrderDetails(selectAdditionalProductAndAmount(), 7);
        } else if (btnProduct6.isSelected() && btnNumber8.isSelected()) {
            stateTypeProduct = 1;
            loadSetValuesOrderDetails(selectAdditionalProductAndAmount(), 8);
        } else if (btnProduct6.isSelected() && btnNumber9.isSelected()) {
            stateTypeProduct = 1;
            loadSetValuesOrderDetails(selectAdditionalProductAndAmount(), 9);
        } else if (btnProduct7.isSelected() && btnNumber1.isSelected()) {
            loadSetValuesOrderDetails(btnProduct7.getText(), 1);
        } else if (btnProduct7.isSelected() && btnNumber2.isSelected()) {
            loadSetValuesOrderDetails(btnProduct7.getText(), 2);
        } else if (btnProduct7.isSelected() && btnNumber3.isSelected()) {
            loadSetValuesOrderDetails(btnProduct7.getText(), 3);
        } else if (btnProduct7.isSelected() && btnNumber4.isSelected()) {
            loadSetValuesOrderDetails(btnProduct7.getText(), 4);
        } else if (btnProduct7.isSelected() && btnNumber5.isSelected()) {
            loadSetValuesOrderDetails(btnProduct7.getText(), 5);
        } else if (btnProduct7.isSelected() && btnNumber6.isSelected()) {
            loadSetValuesOrderDetails(btnProduct7.getText(), 6);
        } else if (btnProduct7.isSelected() && btnNumber7.isSelected()) {
            loadSetValuesOrderDetails(btnProduct7.getText(), 7);
        } else if (btnProduct7.isSelected() && btnNumber8.isSelected()) {
            loadSetValuesOrderDetails(btnProduct7.getText(), 8);
        } else if (btnProduct7.isSelected() && btnNumber9.isSelected()) {
            loadSetValuesOrderDetails(btnProduct7.getText(), 9);
        } else if (btnProduct8.isSelected() && btnNumber1.isSelected()) {
            loadSetValuesOrderDetails(btnProduct8.getText(), 1);
        } else if (btnProduct8.isSelected() && btnNumber2.isSelected()) {
            loadSetValuesOrderDetails(btnProduct8.getText(), 2);
        } else if (btnProduct8.isSelected() && btnNumber3.isSelected()) {
            loadSetValuesOrderDetails(btnProduct8.getText(), 3);
        } else if (btnProduct8.isSelected() && btnNumber4.isSelected()) {
            loadSetValuesOrderDetails(btnProduct8.getText(), 4);
        } else if (btnProduct8.isSelected() && btnNumber5.isSelected()) {
            loadSetValuesOrderDetails(btnProduct8.getText(), 5);
        } else if (btnProduct8.isSelected() && btnNumber6.isSelected()) {
            loadSetValuesOrderDetails(btnProduct8.getText(), 6);
        } else if (btnProduct8.isSelected() && btnNumber7.isSelected()) {
            loadSetValuesOrderDetails(btnProduct8.getText(), 7);
        } else if (btnProduct8.isSelected() && btnNumber8.isSelected()) {
            loadSetValuesOrderDetails(btnProduct8.getText(), 8);
        } else if (btnProduct8.isSelected() && btnNumber9.isSelected()) {
            loadSetValuesOrderDetails(btnProduct8.getText(), 9);
        } else if (btnProduct9.isSelected() && btnNumber1.isSelected()) {
            loadSetValuesOrderDetails(btnProduct9.getText(), 1);
        } else if (btnProduct9.isSelected() && btnNumber2.isSelected()) {
            loadSetValuesOrderDetails(btnProduct9.getText(), 2);
        } else if (btnProduct9.isSelected() && btnNumber3.isSelected()) {
            loadSetValuesOrderDetails(btnProduct9.getText(), 3);
        } else if (btnProduct9.isSelected() && btnNumber4.isSelected()) {
            loadSetValuesOrderDetails(btnProduct9.getText(), 4);
        } else if (btnProduct9.isSelected() && btnNumber5.isSelected()) {
            loadSetValuesOrderDetails(btnProduct9.getText(), 5);
        } else if (btnProduct9.isSelected() && btnNumber6.isSelected()) {
            loadSetValuesOrderDetails(btnProduct9.getText(), 6);
        } else if (btnProduct9.isSelected() && btnNumber7.isSelected()) {
            loadSetValuesOrderDetails(btnProduct9.getText(), 7);
        } else if (btnProduct9.isSelected() && btnNumber8.isSelected()) {
            loadSetValuesOrderDetails(btnProduct9.getText(), 8);
        } else if (btnProduct9.isSelected() && btnNumber9.isSelected()) {
            loadSetValuesOrderDetails(btnProduct9.getText(), 9);
        }

    }

    public String selectAdditionalProductAndAmount() {

        if (btnAdditionalProduct1.isSelected()) {
            return btnAdditionalProduct1.getText();
        } else if (btnAdditionalProduct2.isSelected()) {
            return btnAdditionalProduct2.getText();
        } else if (btnAdditionalProduct3.isSelected()) {
            return btnAdditionalProduct3.getText();
        } else if (btnAdditionalProduct4.isSelected()) {
            return btnAdditionalProduct4.getText();
        } else if (btnAdditionalProduct5.isSelected()) {
            return btnAdditionalProduct5.getText();
        } else if (btnAdditionalProduct6.isSelected()) {
            return btnAdditionalProduct6.getText();
        } else {
            return "";
        }
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
            java.util.logging.Logger.getLogger(frmNewOrderDelivery.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmNewOrderDelivery.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmNewOrderDelivery.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmNewOrderDelivery.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmNewOrderDelivery().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup actionsGroup;
    private javax.swing.ButtonGroup additionsGroup;
    private javax.swing.JButton btnAddCustomer;
    private javax.swing.JButton btnAddProduct;
    private javax.swing.JToggleButton btnAdditionalProduct1;
    private javax.swing.JToggleButton btnAdditionalProduct2;
    private javax.swing.JToggleButton btnAdditionalProduct3;
    private javax.swing.JToggleButton btnAdditionalProduct4;
    private javax.swing.JToggleButton btnAdditionalProduct5;
    private javax.swing.JToggleButton btnAdditionalProduct6;
    private javax.swing.JButton btnAdminBack;
    private javax.swing.JButton btnCancelOrderDelivery;
    private javax.swing.JButton btnContinueOrderDelivery;
    private javax.swing.JButton btnCorrection;
    private javax.swing.JButton btnDlgAdditionsCancel;
    private javax.swing.JButton btnDoneOrder;
    private javax.swing.JToggleButton btnNumber1;
    private javax.swing.JToggleButton btnNumber2;
    private javax.swing.JToggleButton btnNumber3;
    private javax.swing.JToggleButton btnNumber4;
    private javax.swing.JToggleButton btnNumber5;
    private javax.swing.JToggleButton btnNumber6;
    private javax.swing.JToggleButton btnNumber7;
    private javax.swing.JToggleButton btnNumber8;
    private javax.swing.JToggleButton btnNumber9;
    private javax.swing.JButton btnOtherAmount;
    private javax.swing.JToggleButton btnProduct1;
    private javax.swing.JToggleButton btnProduct2;
    private javax.swing.JToggleButton btnProduct3;
    private javax.swing.JToggleButton btnProduct4;
    private javax.swing.JToggleButton btnProduct5;
    private javax.swing.JToggleButton btnProduct6;
    private javax.swing.JToggleButton btnProduct7;
    private javax.swing.JToggleButton btnProduct8;
    private javax.swing.JToggleButton btnProduct9;
    private javax.swing.JButton btnSearchCustomerOrderDelivery;
    private javax.swing.JToggleButton btnSelectedAdditionalProduct;
    private javax.swing.JToggleButton btnSelectedAmount;
    private javax.swing.JToggleButton btnSelectedProducts;
    private javax.swing.JComboBox<String> cbCustomersCity;
    private javax.swing.JComboBox<String> cbCustomersTown;
    private javax.swing.JDialog dlgAdditionsOrderDelivery;
    public javax.swing.JDialog dlgOrderDelivery;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbCustomersDocument;
    private javax.swing.JLabel lblCustomersAddress;
    private javax.swing.JLabel lblCustomersCity;
    private javax.swing.JLabel lblCustomersLastName;
    private javax.swing.JLabel lblCustomersName;
    private javax.swing.JLabel lblCustomersNeighborhood;
    private javax.swing.JLabel lblCustomersNotes;
    private javax.swing.JLabel lblCustomersTown;
    private javax.swing.JLabel lblPhone;
    private javax.swing.JLabel lblTotalOrder;
    private javax.swing.ButtonGroup numbersGroup;
    private javax.swing.JPanel pblAdditionsLocalOrder;
    private javax.swing.JPanel pnlAmount;
    private javax.swing.JPanel pnlCustomersDates;
    private javax.swing.JPanel pnlProducts;
    private javax.swing.ButtonGroup productsGroup;
    private javax.swing.JScrollPane scrollNotes1;
    private javax.swing.JScrollPane scrollPanelProductsTable;
    private javax.swing.JTable tblOrderDelivery;
    private javax.swing.JTextField txtChangeOrder;
    private javax.swing.JTextField txtCustomersDocument;
    private javax.swing.JTextField txtCustomersLastName;
    private javax.swing.JTextField txtCustomersName;
    private javax.swing.JTextField txtCustomersNeighborhood;
    private javax.swing.JTextArea txtCustomersNotes;
    private javax.swing.JTextField txtCustomersPhone;
    private javax.swing.JTextField txtCustomerssAddress;
    private javax.swing.JTextArea txtNotes;
    public javax.swing.JTextField txtOrderNumber;
    private javax.swing.JTextField txtTotalOrder;
    // End of variables declaration//GEN-END:variables
}
