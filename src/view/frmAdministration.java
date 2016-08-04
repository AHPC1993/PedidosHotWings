/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import ca.odell.glazedlists.GlazedLists;
import ca.odell.glazedlists.swing.AutoCompleteSupport;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableCellRenderer;
import model.clsDAOAdditionalProducts;
import model.clsDAOCompany;
import model.clsDAOCustomers;
import model.clsDAOEmployees;
import model.clsDAOInventory;
import model.clsDAOInventoryHistory;
import model.clsDAOProducts;
import model.clsDAOUsers;
import model.clsOrdersGeneral;

/**
 *
 * @author GSG
 */
public class frmAdministration extends javax.swing.JFrame {

    Border borderDefault;
    Border borderEmptyField;
    LinkedList<JTextField> listTxtValidate;
    LinkedList<JTextArea> listTxtAreaValidate;
    String additional_product_id;
    String employee_id;
    String product_id;
    String customers_id;
    String local_id;
    String usersname;
    String inventory_id;
    String history_id;
    String tempAadditionalProduct;
    String tempEmployeesDocument;
    String tempProductsName;
    String tempCustomersPhone;
    String tempUserName;
    String tempInventoryProduct;
    model.clsDAOEmployees employees;
    model.clsDAOProducts products;
    model.clsDAOCustomers customers;
    model.clsDAOCompany local;
    model.clsDAOAdditionalProducts additionalProducts;
    model.clsDAOUsers users;
    model.clsDAOInventory inventory;
    model.clsDAOInventoryHistory inventoryHistory;
    model.clsOrdersGeneral ordersGeneral;

    /**
     * Creates new form frmAdministration
     */
    public frmAdministration() {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dim = toolkit.getScreenSize();
        this.setSize(dim.width, dim.height);
        //  this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setUndecorated(true); //pantalla completa
        initComponents();
        //setExtendedState(java.awt.Frame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        borderDefault = BorderFactory.createLineBorder(Color.black);
        borderEmptyField = BorderFactory.createLineBorder(Color.red);
        lblBackgroundAdmin.setSize(dim.width, dim.height);
        lblCustomerssBackgroundDialog.setSize(dim.width, dim.height);
        lblProductsBackgroundDialog.setSize(dim.width, dim.height);
        lblEmployeesBackgroundDialog.setSize(dim.width, dim.height);
        lblLocalsBackgroundDialog.setSize(dim.width, dim.height);
        lblAdditionalProductsBackgroundDialog.setSize(dim.width, dim.height);
        lblUsersBackgroundDialog.setSize(dim.width, dim.height);
        lblInventoryBackgroundDialog.setSize(dim.width, dim.height);
        lblInventoryHistoryBackgroundDialog.setSize(dim.width, dim.height);

        dlgAdminEmployees.setSize(dim.width, dim.height);
        dlgAdminProducts.setSize(dim.width, dim.height);
        dlgAdminCustomers.setSize(dim.width, dim.height);
        dlgAdminLocal.setSize(dim.width, dim.height);
        dlgAdminAdditionalProducts.setSize(dim.width, dim.height);
        dlgAdminUsers.setSize(dim.width, dim.height);
        dlgAdminInventory.setSize(dim.width, dim.height);
        dlgAdminInventoryHistory.setSize(dim.width, dim.height);

        dlgAdminEmployees.setUndecorated(true);
        dlgAdminProducts.setUndecorated(true);
        dlgAdminCustomers.setUndecorated(true);
        dlgAdminLocal.setUndecorated(true);
        dlgAdminAdditionalProducts.setUndecorated(true);
        dlgAdminUsers.setUndecorated(true);
        dlgAdminInventory.setUndecorated(true);
        dlgAdminInventoryHistory.setUndecorated(true);

        this.setLocationRelativeTo(this);
        dlgAdminEmployees.setLocationRelativeTo(this);
        dlgAdminProducts.setLocationRelativeTo(this);
        dlgAdminCustomers.setLocationRelativeTo(this);
        dlgAdminLocal.setLocationRelativeTo(this);
        dlgSelectProducts.setLocationRelativeTo(this);
        dlgAdminAdditionalProducts.setLocationRelativeTo(this);
        dlgAdminUsers.setLocationRelativeTo(this);
        dlgAdminInventory.setLocationRelativeTo(this);
        dlgAdminInventoryHistory.setLocationRelativeTo(this);
        dlgSelectInventory.setLocationRelativeTo(this);

        scrollPanelEmployeesTable.setVisible(false);
        scrollPanelProductsTable.setVisible(false);
        scrollPanelCustomersTable.setVisible(false);
        scrollPanelLocalsTable.setVisible(false);
        scrollPanelAdditionalProductsTable.setVisible(false);
        scrollPanelUsersTable.setVisible(false);
        scrollPanelInventoryHistoryTable.setVisible(false);
        scrollPanelInventoryTable.setVisible(false);

        tblEmployees.setVisible(false);
        tblProducts.setVisible(false);
        tblCustomers.setVisible(false);
        tblLocals.setVisible(false);
        tblAdditionalProducts.setVisible(false);
        tblUsers.setVisible(false);
        tblInventory.setVisible(false);
        tblInventoryHistory.setVisible(false);

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
        lblEmployeesDocument = new javax.swing.JLabel();
        txtEmployeesName = new javax.swing.JTextField();
        lblEmployeesName = new javax.swing.JLabel();
        lblEmployeesLastName = new javax.swing.JLabel();
        txtEmployeesLastName = new javax.swing.JTextField();
        txtEmployeesAddress = new javax.swing.JTextField();
        txtEmployeesDocument = new javax.swing.JTextField();
        lblAddress = new javax.swing.JLabel();
        lblJob = new javax.swing.JLabel();
        lblNotes = new javax.swing.JLabel();
        scrollNotes = new javax.swing.JScrollPane();
        txtEmployeesNotes = new javax.swing.JTextArea();
        lblLocal = new javax.swing.JLabel();
        lblPhone1 = new javax.swing.JLabel();
        txtEmployeesPhone = new javax.swing.JTextField();
        cbLocal = new javax.swing.JComboBox<>();
        cbEmployeesJob = new javax.swing.JComboBox<>();
        pnlEmployeesButtons = new javax.swing.JPanel();
        btnEmployeesEdit = new javax.swing.JButton();
        btnEmployeesDelete = new javax.swing.JButton();
        btnEmployeesInsert = new javax.swing.JButton();
        btnEmployeesSearch = new javax.swing.JButton();
        btnEmployeesNew = new javax.swing.JButton();
        btnEmployeesList = new javax.swing.JButton();
        scrollPanelEmployeesTable = new javax.swing.JScrollPane();
        tblEmployees = new javax.swing.JTable();
        btnEmployeesBack = new javax.swing.JButton();
        lblEmployeesTitle = new javax.swing.JLabel();
        lblEmployeesBackgroundDialog = new javax.swing.JLabel();
        dlgAdminProducts = new javax.swing.JDialog();
        scrollPanelProductsTable = new javax.swing.JScrollPane();
        tblProducts = new javax.swing.JTable();
        pnlProductsButtons = new javax.swing.JPanel();
        btnProductsEdit = new javax.swing.JButton();
        btnProductsDelete = new javax.swing.JButton();
        btnProductsInsert = new javax.swing.JButton();
        btnProductsSearch = new javax.swing.JButton();
        btnProductsNew = new javax.swing.JButton();
        btnProductsList = new javax.swing.JButton();
        pnlProducts2 = new javax.swing.JPanel();
        txtProductsName = new javax.swing.JTextField();
        lblProductsName = new javax.swing.JLabel();
        lblProductsDescription = new javax.swing.JLabel();
        txtProductsPrice = new javax.swing.JTextField();
        lblPrice = new javax.swing.JLabel();
        lblProductsNotes = new javax.swing.JLabel();
        scrolProductslNotes2 = new javax.swing.JScrollPane();
        txtProductsNotes = new javax.swing.JTextArea();
        scrolProductDescription2 = new javax.swing.JScrollPane();
        txtProductsDescription = new javax.swing.JTextArea();
        btnProductsBack = new javax.swing.JButton();
        lblProductsTitle = new javax.swing.JLabel();
        lblProductsBackgroundDialog = new javax.swing.JLabel();
        dlgAdminCustomers = new javax.swing.JDialog();
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
        lblCustomersNotes = new javax.swing.JLabel();
        scrollNotes1 = new javax.swing.JScrollPane();
        txtCustomersNotes = new javax.swing.JTextArea();
        lblCustomersCity = new javax.swing.JLabel();
        lblCustomersTown = new javax.swing.JLabel();
        cbCustomersTown = new javax.swing.JComboBox<>();
        cbCustomersCity = new javax.swing.JComboBox<>();
        lblPhone = new javax.swing.JLabel();
        txtCustomersPhone = new javax.swing.JTextField();
        cboCustomersNeighborhood = new javax.swing.JComboBox<>();
        scrollPanelCustomersTable = new javax.swing.JScrollPane();
        tblCustomers = new javax.swing.JTable();
        pnlCustomersButtons = new javax.swing.JPanel();
        btnCustomersEdit = new javax.swing.JButton();
        btnCustomersDelete = new javax.swing.JButton();
        btnCustomersInsert = new javax.swing.JButton();
        btnCustomersSearch = new javax.swing.JButton();
        btnCustomersNew = new javax.swing.JButton();
        btnCustomersList = new javax.swing.JButton();
        btnCustomersBack = new javax.swing.JButton();
        lblCustomersTitle = new javax.swing.JLabel();
        lblCustomerssBackgroundDialog = new javax.swing.JLabel();
        dlgAdminAdditionalProducts = new javax.swing.JDialog();
        pnlAdditionalProductsButtons = new javax.swing.JPanel();
        btnAdditionalProductsEdit = new javax.swing.JButton();
        btnAdditionalProductsDelete = new javax.swing.JButton();
        btnAdditionalProductsInsert = new javax.swing.JButton();
        btnAdditionalProductsSearch = new javax.swing.JButton();
        btnAdditionalProductsNew = new javax.swing.JButton();
        btnAdditionalProductsList = new javax.swing.JButton();
        scrollPanelAdditionalProductsTable = new javax.swing.JScrollPane();
        tblAdditionalProducts = new javax.swing.JTable();
        pnlAdditionalProducts = new javax.swing.JPanel();
        txtAdditionalProductsName = new javax.swing.JTextField();
        lblAdditionalProductsName = new javax.swing.JLabel();
        lblAdditionalProductsDescription = new javax.swing.JLabel();
        txtAdditionalProductsPrice = new javax.swing.JTextField();
        lblAdditionalPrice = new javax.swing.JLabel();
        lblAdditionalProductsNotes = new javax.swing.JLabel();
        scrolAdditionalProductslNotes = new javax.swing.JScrollPane();
        txtAdditionalProductsNotes = new javax.swing.JTextArea();
        scrolAdditionalProductDescription = new javax.swing.JScrollPane();
        txtAdditionalProductsDescription = new javax.swing.JTextArea();
        btnAdditionalProductsBack = new javax.swing.JButton();
        lblAdditionalProductsTitle = new javax.swing.JLabel();
        lblAdditionalProductsBackgroundDialog = new javax.swing.JLabel();
        dlgAdminLocal = new javax.swing.JDialog();
        pnlLocals = new javax.swing.JPanel();
        txtLocalsNameL = new javax.swing.JTextField();
        lblLocalsyNit = new javax.swing.JLabel();
        lblLocalsName = new javax.swing.JLabel();
        txtLocalsAddress = new javax.swing.JTextField();
        lblLocalsAddress = new javax.swing.JLabel();
        lblLocalsNeighborhood = new javax.swing.JLabel();
        txtLocalsNit = new javax.swing.JTextField();
        txtLocalsNeighborhood = new javax.swing.JTextField();
        lblLocalsTown = new javax.swing.JLabel();
        lblLocalsCity = new javax.swing.JLabel();
        cbLocalsTown = new javax.swing.JComboBox<>();
        cbLocalsCity = new javax.swing.JComboBox<>();
        pnlLocalsButtons = new javax.swing.JPanel();
        btnLocalsEdit = new javax.swing.JButton();
        btnLocalsDelete = new javax.swing.JButton();
        btnLocalsInsert = new javax.swing.JButton();
        btnLocalsSearch = new javax.swing.JButton();
        btnLocalsNew = new javax.swing.JButton();
        btnLocalsList = new javax.swing.JButton();
        scrollPanelLocalsTable = new javax.swing.JScrollPane();
        tblLocals = new javax.swing.JTable();
        btnLocalsBack = new javax.swing.JButton();
        lblLocalsTitle = new javax.swing.JLabel();
        lblLocalsBackgroundDialog = new javax.swing.JLabel();
        dlgSelectProducts = new javax.swing.JDialog();
        pnlSelectAdminProducts = new javax.swing.JPanel();
        btnSelectAdminAdditions = new javax.swing.JButton();
        btnSelectAdminProducts = new javax.swing.JButton();
        dlgAdminUsers = new javax.swing.JDialog();
        scrollPanelUsersTable = new javax.swing.JScrollPane();
        tblUsers = new javax.swing.JTable();
        pnlUsersButtons = new javax.swing.JPanel();
        btnUsersEdit = new javax.swing.JButton();
        btnUsersDelete = new javax.swing.JButton();
        btnUsersInsert = new javax.swing.JButton();
        btnUsersSearch = new javax.swing.JButton();
        btnUersNew = new javax.swing.JButton();
        btnUsersList = new javax.swing.JButton();
        pnlUsers = new javax.swing.JPanel();
        txtUsersNameUser = new javax.swing.JTextField();
        lblUsersNameUser = new javax.swing.JLabel();
        lblUsersPassword = new javax.swing.JLabel();
        lblProductsNotes1 = new javax.swing.JLabel();
        scrolProductslNotes3 = new javax.swing.JScrollPane();
        txtUsersNotes = new javax.swing.JTextArea();
        lblUsersPassword1 = new javax.swing.JLabel();
        txtUsersPassword = new javax.swing.JPasswordField();
        txtUsersRepeatPassword = new javax.swing.JPasswordField();
        cboUsersIsAdmin = new javax.swing.JComboBox();
        lblUsersIsAdmin = new javax.swing.JLabel();
        btnUsersBack = new javax.swing.JButton();
        lblUsersTitle = new javax.swing.JLabel();
        lblUsersBackgroundDialog = new javax.swing.JLabel();
        dlgAdminInventoryHistory = new javax.swing.JDialog();
        scrollPanelInventoryHistoryTable = new javax.swing.JScrollPane();
        tblInventoryHistory = new javax.swing.JTable();
        pnlInventoryHistoryButtons = new javax.swing.JPanel();
        btnInventoryHistoryEdit = new javax.swing.JButton();
        btnInventoryHistoryDelete = new javax.swing.JButton();
        btnInventoryHistoryInsert = new javax.swing.JButton();
        btnInventoryHistoryList = new javax.swing.JButton();
        btnInventoryHistorySearch = new javax.swing.JButton();
        pnlInventoryHistory = new javax.swing.JPanel();
        lblInventoryHistoryProduct = new javax.swing.JLabel();
        lblInventoryHistoryActionInOut = new javax.swing.JLabel();
        lblInventoryHistoryAmount = new javax.swing.JLabel();
        cboInventoryHistoryInOut = new javax.swing.JComboBox();
        cboInventoryHistoryProduct = new javax.swing.JComboBox();
        txtInventoryHistoryAmount = new javax.swing.JTextField();
        btnInventoryHistoryBack = new javax.swing.JButton();
        lblInventoryHistoryTitle = new javax.swing.JLabel();
        lblInventoryHistoryBackgroundDialog = new javax.swing.JLabel();
        dlgSelectInventory = new javax.swing.JDialog();
        pnlSelectAdminInventory = new javax.swing.JPanel();
        btnSelectInventoryHistory = new javax.swing.JButton();
        btnSelectInventory1 = new javax.swing.JButton();
        dlgAdminInventory = new javax.swing.JDialog();
        scrollPanelInventoryTable = new javax.swing.JScrollPane();
        tblInventory = new javax.swing.JTable();
        pnlInventoryButtons = new javax.swing.JPanel();
        btnInventoryEdit = new javax.swing.JButton();
        btnInventoryDelete = new javax.swing.JButton();
        btnInventoryInsert = new javax.swing.JButton();
        btnInventorySearch = new javax.swing.JButton();
        btnInventoryNew = new javax.swing.JButton();
        btnInventoryList = new javax.swing.JButton();
        pnlInventory = new javax.swing.JPanel();
        lblInventoryProduct = new javax.swing.JLabel();
        scrollInventoryNotes = new javax.swing.JScrollPane();
        txtInventoryNotes = new javax.swing.JTextArea();
        lblInventoryNotes = new javax.swing.JLabel();
        txtInventoryProduct = new javax.swing.JTextField();
        btnInventoryBack = new javax.swing.JButton();
        lblInventoryTitle = new javax.swing.JLabel();
        lblInventoryBackgroundDialog = new javax.swing.JLabel();
        dlgAdminOrders = new javax.swing.JDialog();
        scrollPanelOrdersGTable = new javax.swing.JScrollPane();
        tblOrdersGeneral = new javax.swing.JTable();
        pnlInventoryHistoryButtons1 = new javax.swing.JPanel();
        btnOrdersGDelete = new javax.swing.JButton();
        btnInventoryHistoryList1 = new javax.swing.JButton();
        btnInventoryHistorySearch1 = new javax.swing.JButton();
        btnInventoryHistoryBack1 = new javax.swing.JButton();
        lblInventoryHistoryTitle1 = new javax.swing.JLabel();
        lblInventoryHistoryBackgroundDialog1 = new javax.swing.JLabel();
        btnAdminProducts = new javax.swing.JButton();
        btnCompanyDates = new javax.swing.JButton();
        btnAdminEmployees = new javax.swing.JButton();
        btnAdminPasswords = new javax.swing.JButton();
        btnAdminCustomers = new javax.swing.JButton();
        btnAdminBack = new javax.swing.JButton();
        btnAdminInventory = new javax.swing.JButton();
        btnAdminOrders = new javax.swing.JButton();
        lblBackgroundAdmin = new javax.swing.JLabel();

        dlgAdminEmployees.setTitle("Administrar Empleados");
        dlgAdminEmployees.setMinimumSize(new java.awt.Dimension(1382, 744));
        dlgAdminEmployees.setSize(new java.awt.Dimension(1382, 744));
        dlgAdminEmployees.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                dlgAdminEmployeesWindowClosing(evt);
            }
        });
        dlgAdminEmployees.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlEmployeesDates.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.MatteBorder(null), "Datos ", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), java.awt.Color.red)); // NOI18N
        pnlEmployeesDates.setOpaque(false);

        lblEmployeesDocument.setFont(new java.awt.Font("Noto Sans", 0, 18)); // NOI18N
        lblEmployeesDocument.setText("Cédula");

        txtEmployeesName.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtEmployeesName.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        lblEmployeesName.setFont(new java.awt.Font("Noto Sans", 0, 18)); // NOI18N
        lblEmployeesName.setText("Nombre");

        lblEmployeesLastName.setFont(new java.awt.Font("Noto Sans", 0, 18)); // NOI18N
        lblEmployeesLastName.setText("Apellidos");

        txtEmployeesLastName.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtEmployeesLastName.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        txtEmployeesAddress.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtEmployeesAddress.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        txtEmployeesDocument.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtEmployeesDocument.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtEmployeesDocument.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtEmployeesDocumentKeyTyped(evt);
            }
        });

        lblAddress.setFont(new java.awt.Font("Noto Sans", 0, 18)); // NOI18N
        lblAddress.setText("Dirección");

        lblJob.setFont(new java.awt.Font("Noto Sans", 0, 18)); // NOI18N
        lblJob.setText("Puesto");

        lblNotes.setFont(new java.awt.Font("Noto Sans", 0, 18)); // NOI18N
        lblNotes.setText("Notas");

        txtEmployeesNotes.setColumns(20);
        txtEmployeesNotes.setRows(5);
        scrollNotes.setViewportView(txtEmployeesNotes);

        lblLocal.setFont(new java.awt.Font("Noto Sans", 0, 18)); // NOI18N
        lblLocal.setText("Local");

        lblPhone1.setFont(new java.awt.Font("Noto Sans", 0, 18)); // NOI18N
        lblPhone1.setText("Teléfono");

        txtEmployeesPhone.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtEmployeesPhone.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtEmployeesPhone.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtEmployeesPhoneKeyTyped(evt);
            }
        });

        cbLocal.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Hot Wings Linares", "Hot Wings La estrella" }));

        cbEmployeesJob.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Domicilio", "Cocina", "Mesas", "Administrador" }));
        cbEmployeesJob.setToolTipText("Cargo que ocupa el empleado");

        javax.swing.GroupLayout pnlEmployeesDatesLayout = new javax.swing.GroupLayout(pnlEmployeesDates);
        pnlEmployeesDates.setLayout(pnlEmployeesDatesLayout);
        pnlEmployeesDatesLayout.setHorizontalGroup(
            pnlEmployeesDatesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlEmployeesDatesLayout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(pnlEmployeesDatesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblEmployeesName)
                    .addComponent(lblEmployeesDocument))
                .addGap(61, 61, 61)
                .addGroup(pnlEmployeesDatesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtEmployeesDocument)
                    .addComponent(txtEmployeesName))
                .addContainerGap())
            .addGroup(pnlEmployeesDatesLayout.createSequentialGroup()
                .addGroup(pnlEmployeesDatesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlEmployeesDatesLayout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(lblEmployeesLastName)
                        .addGap(52, 52, 52)
                        .addComponent(txtEmployeesLastName))
                    .addGroup(pnlEmployeesDatesLayout.createSequentialGroup()
                        .addGroup(pnlEmployeesDatesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlEmployeesDatesLayout.createSequentialGroup()
                                .addGap(44, 44, 44)
                                .addComponent(lblPhone1))
                            .addGroup(pnlEmployeesDatesLayout.createSequentialGroup()
                                .addGap(45, 45, 45)
                                .addComponent(lblLocal))
                            .addGroup(pnlEmployeesDatesLayout.createSequentialGroup()
                                .addGap(45, 45, 45)
                                .addComponent(lblNotes)))
                        .addGap(54, 54, 54)
                        .addGroup(pnlEmployeesDatesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtEmployeesPhone)
                            .addGroup(pnlEmployeesDatesLayout.createSequentialGroup()
                                .addComponent(cbLocal, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(scrollNotes, javax.swing.GroupLayout.DEFAULT_SIZE, 246, Short.MAX_VALUE)))
                    .addGroup(pnlEmployeesDatesLayout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addGroup(pnlEmployeesDatesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblAddress)
                            .addComponent(lblJob))
                        .addGap(50, 50, 50)
                        .addGroup(pnlEmployeesDatesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlEmployeesDatesLayout.createSequentialGroup()
                                .addComponent(cbEmployeesJob, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(txtEmployeesAddress))))
                .addGap(12, 12, 12))
        );
        pnlEmployeesDatesLayout.setVerticalGroup(
            pnlEmployeesDatesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlEmployeesDatesLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(pnlEmployeesDatesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEmployeesDocument)
                    .addComponent(txtEmployeesDocument, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(pnlEmployeesDatesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlEmployeesDatesLayout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(lblEmployeesName))
                    .addComponent(txtEmployeesName, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(pnlEmployeesDatesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlEmployeesDatesLayout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(lblEmployeesLastName))
                    .addComponent(txtEmployeesLastName, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(pnlEmployeesDatesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlEmployeesDatesLayout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(lblAddress))
                    .addComponent(txtEmployeesAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(pnlEmployeesDatesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblJob)
                    .addComponent(cbEmployeesJob, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlEmployeesDatesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlEmployeesDatesLayout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(lblPhone1))
                    .addComponent(txtEmployeesPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(pnlEmployeesDatesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlEmployeesDatesLayout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(lblLocal))
                    .addGroup(pnlEmployeesDatesLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(cbLocal, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(31, 31, 31)
                .addGroup(pnlEmployeesDatesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlEmployeesDatesLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(lblNotes))
                    .addComponent(scrollNotes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        dlgAdminEmployees.getContentPane().add(pnlEmployeesDates, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, -1, -1));

        pnlEmployeesButtons.setOpaque(false);

        btnEmployeesEdit.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnEmployeesEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/menuCrud/iconBtnEdit.png"))); // NOI18N
        btnEmployeesEdit.setText("Modificar");
        btnEmployeesEdit.setToolTipText("Modificar el empleado con los datos que aparecen en las cajas de texto");
        btnEmployeesEdit.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnEmployeesEdit.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnEmployeesEdit.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnEmployeesEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEmployeesEditActionPerformed(evt);
            }
        });

        btnEmployeesDelete.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnEmployeesDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/menuCrud/iconBtnDelete.png"))); // NOI18N
        btnEmployeesDelete.setText("Eliminar");
        btnEmployeesDelete.setToolTipText("Eliminar un empleado");
        btnEmployeesDelete.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnEmployeesDelete.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnEmployeesDelete.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnEmployeesDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEmployeesDeleteActionPerformed(evt);
            }
        });

        btnEmployeesInsert.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnEmployeesInsert.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/menuCrud/iconBtnSave.png"))); // NOI18N
        btnEmployeesInsert.setText("Insertar");
        btnEmployeesInsert.setToolTipText("Ingresar un nuevo empleado");
        btnEmployeesInsert.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnEmployeesInsert.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnEmployeesInsert.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnEmployeesInsert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEmployeesInsertActionPerformed(evt);
            }
        });

        btnEmployeesSearch.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnEmployeesSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/menuCrud/iconBtnSearch.png"))); // NOI18N
        btnEmployeesSearch.setText("Consultar");
        btnEmployeesSearch.setToolTipText("Buscar un empleado por número de cédula");
        btnEmployeesSearch.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnEmployeesSearch.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnEmployeesSearch.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnEmployeesSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEmployeesSearchActionPerformed(evt);
            }
        });

        btnEmployeesNew.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnEmployeesNew.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/menuCrud/iconBtnNew.png"))); // NOI18N
        btnEmployeesNew.setText("Nuevo");
        btnEmployeesNew.setToolTipText("Limpiar las cajas de texto para crear un nuevo empleado");
        btnEmployeesNew.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnEmployeesNew.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnEmployeesNew.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnEmployeesNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEmployeesNewActionPerformed(evt);
            }
        });

        btnEmployeesList.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnEmployeesList.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/menuCrud/iconBtnList.png"))); // NOI18N
        btnEmployeesList.setText("Listar Emp");
        btnEmployeesList.setToolTipText("Listar todos los empleados en la empresa");
        btnEmployeesList.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnEmployeesList.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnEmployeesList.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnEmployeesList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEmployeesListActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlEmployeesButtonsLayout = new javax.swing.GroupLayout(pnlEmployeesButtons);
        pnlEmployeesButtons.setLayout(pnlEmployeesButtonsLayout);
        pnlEmployeesButtonsLayout.setHorizontalGroup(
            pnlEmployeesButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlEmployeesButtonsLayout.createSequentialGroup()
                .addComponent(btnEmployeesNew)
                .addGap(3, 3, 3)
                .addComponent(btnEmployeesInsert)
                .addGap(3, 3, 3)
                .addComponent(btnEmployeesSearch)
                .addGap(3, 3, 3)
                .addComponent(btnEmployeesEdit)
                .addGap(3, 3, 3)
                .addComponent(btnEmployeesDelete)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEmployeesList)
                .addContainerGap(147, Short.MAX_VALUE))
        );
        pnlEmployeesButtonsLayout.setVerticalGroup(
            pnlEmployeesButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlEmployeesButtonsLayout.createSequentialGroup()
                .addGroup(pnlEmployeesButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnEmployeesNew, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEmployeesInsert, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEmployeesSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEmployeesEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEmployeesDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEmployeesList, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        dlgAdminEmployees.getContentPane().add(pnlEmployeesButtons, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, -1, -1));

        tblEmployees.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        tblEmployees.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Cédula", "Nombre", "Apellidos", "Dirección", "Puesto", "Teléfono", "Id local", "Notas"
            }
        ));
        scrollPanelEmployeesTable.setViewportView(tblEmployees);
        tblEmployees.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        dlgAdminEmployees.getContentPane().add(scrollPanelEmployeesTable, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 140, 870, 410));

        btnEmployeesBack.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnEmployeesBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/back.png"))); // NOI18N
        btnEmployeesBack.setText("Volver");
        btnEmployeesBack.setBorderPainted(false);
        btnEmployeesBack.setContentAreaFilled(false);
        btnEmployeesBack.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEmployeesBack.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnEmployeesBack.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnEmployeesBack.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnEmployeesBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEmployeesBackActionPerformed(evt);
            }
        });
        dlgAdminEmployees.getContentPane().add(btnEmployeesBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(1220, 605, 120, -1));

        lblEmployeesTitle.setFont(new java.awt.Font("Noto Sans", 1, 28)); // NOI18N
        lblEmployeesTitle.setText("Administrar Empleados");
        dlgAdminEmployees.getContentPane().add(lblEmployeesTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 60, 350, 50));

        lblEmployeesBackgroundDialog.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/555.jpg"))); // NOI18N
        dlgAdminEmployees.getContentPane().add(lblEmployeesBackgroundDialog, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1390, 770));

        dlgAdminProducts.setTitle("Administrar Productos");
        dlgAdminProducts.setMinimumSize(new java.awt.Dimension(1382, 744));
        dlgAdminProducts.setSize(new java.awt.Dimension(1382, 744));
        dlgAdminProducts.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                dlgAdminProductsWindowClosing(evt);
            }
        });
        dlgAdminProducts.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblProducts.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        tblProducts.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Nombre", "Descripción", "Precio", "Notas"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        scrollPanelProductsTable.setViewportView(tblProducts);
        tblProducts.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        dlgAdminProducts.getContentPane().add(scrollPanelProductsTable, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 122, 640, 410));

        pnlProductsButtons.setOpaque(false);

        btnProductsEdit.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnProductsEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/menuCrud/iconBtnEdit.png"))); // NOI18N
        btnProductsEdit.setText("Modificar");
        btnProductsEdit.setToolTipText("Modificar el empleado con los datos que aparecen en las cajas de texto");
        btnProductsEdit.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnProductsEdit.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnProductsEdit.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnProductsEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProductsEditActionPerformed(evt);
            }
        });

        btnProductsDelete.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnProductsDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/menuCrud/iconBtnDelete.png"))); // NOI18N
        btnProductsDelete.setText("Eliminar");
        btnProductsDelete.setToolTipText("Eliminar un empleado");
        btnProductsDelete.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnProductsDelete.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnProductsDelete.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnProductsDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProductsDeleteActionPerformed(evt);
            }
        });

        btnProductsInsert.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnProductsInsert.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/menuCrud/iconBtnSave.png"))); // NOI18N
        btnProductsInsert.setText("Insertar");
        btnProductsInsert.setToolTipText("Ingresar un nuevo empleado");
        btnProductsInsert.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnProductsInsert.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnProductsInsert.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnProductsInsert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProductsInsertActionPerformed(evt);
            }
        });

        btnProductsSearch.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnProductsSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/menuCrud/iconBtnSearch.png"))); // NOI18N
        btnProductsSearch.setText("Consultar");
        btnProductsSearch.setToolTipText("Buscar un empleado por número de cédula");
        btnProductsSearch.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnProductsSearch.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnProductsSearch.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnProductsSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProductsSearchActionPerformed(evt);
            }
        });

        btnProductsNew.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnProductsNew.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/menuCrud/iconBtnNew.png"))); // NOI18N
        btnProductsNew.setText("Nuevo");
        btnProductsNew.setToolTipText("Limpiar las cajas de texto para crear un nuevo empleado");
        btnProductsNew.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnProductsNew.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnProductsNew.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnProductsNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProductsNewActionPerformed(evt);
            }
        });

        btnProductsList.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnProductsList.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/menuCrud/iconBtnList.png"))); // NOI18N
        btnProductsList.setText("Listar Productos");
        btnProductsList.setToolTipText("Listar todos los empleados en la empresa");
        btnProductsList.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnProductsList.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnProductsList.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnProductsList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProductsListActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlProductsButtonsLayout = new javax.swing.GroupLayout(pnlProductsButtons);
        pnlProductsButtons.setLayout(pnlProductsButtonsLayout);
        pnlProductsButtonsLayout.setHorizontalGroup(
            pnlProductsButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlProductsButtonsLayout.createSequentialGroup()
                .addComponent(btnProductsNew)
                .addGap(3, 3, 3)
                .addComponent(btnProductsInsert)
                .addGap(3, 3, 3)
                .addComponent(btnProductsSearch)
                .addGap(3, 3, 3)
                .addComponent(btnProductsEdit)
                .addGap(3, 3, 3)
                .addComponent(btnProductsDelete)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnProductsList)
                .addContainerGap(104, Short.MAX_VALUE))
        );
        pnlProductsButtonsLayout.setVerticalGroup(
            pnlProductsButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlProductsButtonsLayout.createSequentialGroup()
                .addGroup(pnlProductsButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnProductsNew, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnProductsInsert, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnProductsSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnProductsEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnProductsDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnProductsList, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        dlgAdminProducts.getContentPane().add(pnlProductsButtons, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, -1, -1));

        pnlProducts2.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.MatteBorder(null), "Datos ", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), java.awt.Color.red)); // NOI18N
        pnlProducts2.setOpaque(false);

        txtProductsName.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtProductsName.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        lblProductsName.setFont(new java.awt.Font("Noto Sans", 0, 18)); // NOI18N
        lblProductsName.setText("Nombre");

        lblProductsDescription.setFont(new java.awt.Font("Noto Sans", 0, 18)); // NOI18N
        lblProductsDescription.setText("Descripción");

        txtProductsPrice.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtProductsPrice.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtProductsPrice.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtProductsPriceKeyTyped(evt);
            }
        });

        lblPrice.setFont(new java.awt.Font("Noto Sans", 0, 18)); // NOI18N
        lblPrice.setText("Precio");

        lblProductsNotes.setFont(new java.awt.Font("Noto Sans", 0, 18)); // NOI18N
        lblProductsNotes.setText("Notas");

        txtProductsNotes.setColumns(20);
        txtProductsNotes.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtProductsNotes.setLineWrap(true);
        txtProductsNotes.setRows(5);
        scrolProductslNotes2.setViewportView(txtProductsNotes);

        txtProductsDescription.setColumns(20);
        txtProductsDescription.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtProductsDescription.setLineWrap(true);
        txtProductsDescription.setRows(5);
        scrolProductDescription2.setViewportView(txtProductsDescription);

        javax.swing.GroupLayout pnlProducts2Layout = new javax.swing.GroupLayout(pnlProducts2);
        pnlProducts2.setLayout(pnlProducts2Layout);
        pnlProducts2Layout.setHorizontalGroup(
            pnlProducts2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlProducts2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lblProductsDescription)
                .addGap(150, 150, 150))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlProducts2Layout.createSequentialGroup()
                .addComponent(scrolProductslNotes2)
                .addContainerGap())
            .addGroup(pnlProducts2Layout.createSequentialGroup()
                .addGroup(pnlProducts2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlProducts2Layout.createSequentialGroup()
                        .addGap(167, 167, 167)
                        .addComponent(lblProductsName))
                    .addGroup(pnlProducts2Layout.createSequentialGroup()
                        .addGap(175, 175, 175)
                        .addComponent(lblPrice))
                    .addGroup(pnlProducts2Layout.createSequentialGroup()
                        .addGap(177, 177, 177)
                        .addComponent(lblProductsNotes))
                    .addGroup(pnlProducts2Layout.createSequentialGroup()
                        .addGap(99, 99, 99)
                        .addGroup(pnlProducts2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtProductsName, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtProductsPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(pnlProducts2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scrolProductDescription2)
                .addContainerGap())
        );
        pnlProducts2Layout.setVerticalGroup(
            pnlProducts2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlProducts2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblProductsName)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtProductsName, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblProductsDescription)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(scrolProductDescription2, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblPrice)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtProductsPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblProductsNotes)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrolProductslNotes2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(61, 61, 61))
        );

        dlgAdminProducts.getContentPane().add(pnlProducts2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 410, 470));

        btnProductsBack.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnProductsBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/back.png"))); // NOI18N
        btnProductsBack.setText("Volver");
        btnProductsBack.setBorderPainted(false);
        btnProductsBack.setContentAreaFilled(false);
        btnProductsBack.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnProductsBack.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnProductsBack.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnProductsBack.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnProductsBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProductsBackActionPerformed(evt);
            }
        });
        dlgAdminProducts.getContentPane().add(btnProductsBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(1220, 605, 120, -1));

        lblProductsTitle.setFont(new java.awt.Font("Noto Sans", 1, 28)); // NOI18N
        lblProductsTitle.setText("Administrar Productos");
        dlgAdminProducts.getContentPane().add(lblProductsTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 60, 350, 50));

        lblProductsBackgroundDialog.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/555.jpg"))); // NOI18N
        dlgAdminProducts.getContentPane().add(lblProductsBackgroundDialog, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 0, 1390, 770));

        dlgAdminCustomers.setTitle("Administrar Clientes");
        dlgAdminCustomers.setMinimumSize(new java.awt.Dimension(1382, 744));
        dlgAdminCustomers.setSize(new java.awt.Dimension(1382, 744));
        dlgAdminCustomers.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                dlgAdminCustomersWindowClosing(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                dlgAdminCustomersWindowOpened(evt);
            }
        });
        dlgAdminCustomers.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlCustomersDates.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.MatteBorder(null), "Datos ", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), java.awt.Color.red)); // NOI18N
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

        lblCustomersNotes.setFont(new java.awt.Font("Noto Sans", 0, 18)); // NOI18N
        lblCustomersNotes.setText("Notas");

        txtCustomersNotes.setColumns(20);
        txtCustomersNotes.setRows(5);
        scrollNotes1.setViewportView(txtCustomersNotes);

        lblCustomersCity.setFont(new java.awt.Font("Noto Sans", 0, 18)); // NOI18N
        lblCustomersCity.setText("Departamento");

        lblCustomersTown.setFont(new java.awt.Font("Noto Sans", 0, 18)); // NOI18N
        lblCustomersTown.setText("Municipio");

        cbCustomersTown.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Manizales", "Villamaria" }));

        cbCustomersCity.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Caldas" }));

        lblPhone.setFont(new java.awt.Font("Noto Sans", 0, 18)); // NOI18N
        lblPhone.setText("Teléfono");

        txtCustomersPhone.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtCustomersPhone.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtCustomersPhone.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCustomersPhoneKeyTyped(evt);
            }
        });

        cboCustomersNeighborhood.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout pnlCustomersDatesLayout = new javax.swing.GroupLayout(pnlCustomersDates);
        pnlCustomersDates.setLayout(pnlCustomersDatesLayout);
        pnlCustomersDatesLayout.setHorizontalGroup(
            pnlCustomersDatesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCustomersDatesLayout.createSequentialGroup()
                .addGroup(pnlCustomersDatesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pnlCustomersDatesLayout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addGroup(pnlCustomersDatesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlCustomersDatesLayout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addGroup(pnlCustomersDatesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblCustomersTown)
                                    .addComponent(lblCustomersCity)
                                    .addComponent(lblPhone)
                                    .addComponent(lblCustomersNotes))
                                .addGroup(pnlCustomersDatesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(pnlCustomersDatesLayout.createSequentialGroup()
                                        .addGap(11, 11, 11)
                                        .addComponent(cbCustomersTown, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(pnlCustomersDatesLayout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(cbCustomersCity, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(pnlCustomersDatesLayout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addGroup(pnlCustomersDatesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(scrollNotes1, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtCustomersPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addGroup(pnlCustomersDatesLayout.createSequentialGroup()
                                .addGroup(pnlCustomersDatesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblCustomersAddress)
                                    .addComponent(lblCustomersNeighborhood))
                                .addGap(50, 50, 50)
                                .addGroup(pnlCustomersDatesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtCustomerssAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cboCustomersNeighborhood, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(pnlCustomersDatesLayout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addGroup(pnlCustomersDatesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlCustomersDatesLayout.createSequentialGroup()
                                .addGroup(pnlCustomersDatesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblCustomersName)
                                    .addComponent(lbCustomersDocument))
                                .addGap(61, 61, 61))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlCustomersDatesLayout.createSequentialGroup()
                                .addComponent(lblCustomersLastName)
                                .addGap(49, 49, 49)))
                        .addGroup(pnlCustomersDatesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCustomersDocument)
                            .addComponent(txtCustomersName)
                            .addComponent(txtCustomersLastName))))
                .addGap(214, 214, 214))
        );
        pnlCustomersDatesLayout.setVerticalGroup(
            pnlCustomersDatesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCustomersDatesLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(pnlCustomersDatesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbCustomersDocument)
                    .addComponent(txtCustomersDocument, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(pnlCustomersDatesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlCustomersDatesLayout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(lblCustomersName))
                    .addComponent(txtCustomersName, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(pnlCustomersDatesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlCustomersDatesLayout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(lblCustomersLastName))
                    .addComponent(txtCustomersLastName, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(pnlCustomersDatesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlCustomersDatesLayout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(lblCustomersAddress))
                    .addComponent(txtCustomerssAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(pnlCustomersDatesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCustomersNeighborhood)
                    .addComponent(cboCustomersNeighborhood, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(pnlCustomersDatesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCustomersTown)
                    .addComponent(cbCustomersTown, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(pnlCustomersDatesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCustomersCity)
                    .addComponent(cbCustomersCity, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addGroup(pnlCustomersDatesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPhone)
                    .addComponent(txtCustomersPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(pnlCustomersDatesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblCustomersNotes)
                    .addComponent(scrollNotes1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        dlgAdminCustomers.getContentPane().add(pnlCustomersDates, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 460, -1));

        tblCustomers.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        tblCustomers.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Cédula", "Nombre", "Apellidos", "Dirección", "Puesto", "Teléfono", "Id local", "Notas"
            }
        ));
        scrollPanelCustomersTable.setViewportView(tblCustomers);
        tblCustomers.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        dlgAdminCustomers.getContentPane().add(scrollPanelCustomersTable, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 120, 870, 410));

        pnlCustomersButtons.setOpaque(false);

        btnCustomersEdit.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnCustomersEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/menuCrud/iconBtnEdit.png"))); // NOI18N
        btnCustomersEdit.setText("Modificar");
        btnCustomersEdit.setToolTipText("Modificar el empleado con los datos que aparecen en las cajas de texto");
        btnCustomersEdit.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCustomersEdit.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnCustomersEdit.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnCustomersEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCustomersEditActionPerformed(evt);
            }
        });

        btnCustomersDelete.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnCustomersDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/menuCrud/iconBtnDelete.png"))); // NOI18N
        btnCustomersDelete.setText("Eliminar");
        btnCustomersDelete.setToolTipText("Eliminar un empleado");
        btnCustomersDelete.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCustomersDelete.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnCustomersDelete.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnCustomersDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCustomersDeleteActionPerformed(evt);
            }
        });

        btnCustomersInsert.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnCustomersInsert.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/menuCrud/iconBtnSave.png"))); // NOI18N
        btnCustomersInsert.setText("Insertar");
        btnCustomersInsert.setToolTipText("Ingresar un nuevo empleado");
        btnCustomersInsert.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCustomersInsert.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnCustomersInsert.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnCustomersInsert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCustomersInsertActionPerformed(evt);
            }
        });

        btnCustomersSearch.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnCustomersSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/menuCrud/iconBtnSearch.png"))); // NOI18N
        btnCustomersSearch.setText("Consultar");
        btnCustomersSearch.setToolTipText("Buscar un empleado por número de cédula");
        btnCustomersSearch.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCustomersSearch.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnCustomersSearch.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnCustomersSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCustomersSearchActionPerformed(evt);
            }
        });

        btnCustomersNew.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnCustomersNew.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/menuCrud/iconBtnNew.png"))); // NOI18N
        btnCustomersNew.setText("Nuevo");
        btnCustomersNew.setToolTipText("Limpiar las cajas de texto para crear un nuevo empleado");
        btnCustomersNew.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCustomersNew.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnCustomersNew.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnCustomersNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCustomersNewActionPerformed(evt);
            }
        });

        btnCustomersList.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnCustomersList.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/menuCrud/iconBtnList.png"))); // NOI18N
        btnCustomersList.setText("Listar ");
        btnCustomersList.setToolTipText("Listar todos los empleados en la empresa");
        btnCustomersList.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCustomersList.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnCustomersList.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnCustomersList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCustomersListActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlCustomersButtonsLayout = new javax.swing.GroupLayout(pnlCustomersButtons);
        pnlCustomersButtons.setLayout(pnlCustomersButtonsLayout);
        pnlCustomersButtonsLayout.setHorizontalGroup(
            pnlCustomersButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCustomersButtonsLayout.createSequentialGroup()
                .addComponent(btnCustomersNew)
                .addGap(3, 3, 3)
                .addComponent(btnCustomersInsert)
                .addGap(3, 3, 3)
                .addComponent(btnCustomersSearch)
                .addGap(3, 3, 3)
                .addComponent(btnCustomersEdit)
                .addGap(3, 3, 3)
                .addComponent(btnCustomersDelete)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCustomersList)
                .addContainerGap(156, Short.MAX_VALUE))
        );
        pnlCustomersButtonsLayout.setVerticalGroup(
            pnlCustomersButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCustomersButtonsLayout.createSequentialGroup()
                .addGroup(pnlCustomersButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnCustomersNew, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCustomersInsert, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCustomersSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCustomersEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCustomersDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCustomersList, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        dlgAdminCustomers.getContentPane().add(pnlCustomersButtons, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, -1, -1));

        btnCustomersBack.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnCustomersBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/back.png"))); // NOI18N
        btnCustomersBack.setText("Volver");
        btnCustomersBack.setBorderPainted(false);
        btnCustomersBack.setContentAreaFilled(false);
        btnCustomersBack.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCustomersBack.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCustomersBack.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnCustomersBack.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnCustomersBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCustomersBackActionPerformed(evt);
            }
        });
        dlgAdminCustomers.getContentPane().add(btnCustomersBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(1220, 605, 120, -1));

        lblCustomersTitle.setFont(new java.awt.Font("Noto Sans", 1, 28)); // NOI18N
        lblCustomersTitle.setText("Administrar Clientes");
        dlgAdminCustomers.getContentPane().add(lblCustomersTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 60, 350, 50));

        lblCustomerssBackgroundDialog.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/555.jpg"))); // NOI18N
        dlgAdminCustomers.getContentPane().add(lblCustomerssBackgroundDialog, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 0, 1390, 770));

        dlgAdminAdditionalProducts.setTitle("Administrar Productos adicionales");
        dlgAdminAdditionalProducts.setMinimumSize(new java.awt.Dimension(1382, 744));
        dlgAdminAdditionalProducts.setSize(new java.awt.Dimension(1382, 744));
        dlgAdminAdditionalProducts.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                dlgAdminAdditionalProductsWindowClosing(evt);
            }
        });
        dlgAdminAdditionalProducts.getContentPane().setLayout(null);

        pnlAdditionalProductsButtons.setOpaque(false);

        btnAdditionalProductsEdit.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnAdditionalProductsEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/menuCrud/iconBtnEdit.png"))); // NOI18N
        btnAdditionalProductsEdit.setText("Modificar");
        btnAdditionalProductsEdit.setToolTipText("Modificar el empleado con los datos que aparecen en las cajas de texto");
        btnAdditionalProductsEdit.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnAdditionalProductsEdit.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnAdditionalProductsEdit.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnAdditionalProductsEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdditionalProductsEditActionPerformed(evt);
            }
        });

        btnAdditionalProductsDelete.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnAdditionalProductsDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/menuCrud/iconBtnDelete.png"))); // NOI18N
        btnAdditionalProductsDelete.setText("Eliminar");
        btnAdditionalProductsDelete.setToolTipText("Eliminar un empleado");
        btnAdditionalProductsDelete.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnAdditionalProductsDelete.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnAdditionalProductsDelete.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnAdditionalProductsDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdditionalProductsDeleteActionPerformed(evt);
            }
        });

        btnAdditionalProductsInsert.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnAdditionalProductsInsert.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/menuCrud/iconBtnSave.png"))); // NOI18N
        btnAdditionalProductsInsert.setText("Insertar");
        btnAdditionalProductsInsert.setToolTipText("Ingresar un nuevo empleado");
        btnAdditionalProductsInsert.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnAdditionalProductsInsert.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnAdditionalProductsInsert.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnAdditionalProductsInsert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdditionalProductsInsertActionPerformed(evt);
            }
        });

        btnAdditionalProductsSearch.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnAdditionalProductsSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/menuCrud/iconBtnSearch.png"))); // NOI18N
        btnAdditionalProductsSearch.setText("Consultar");
        btnAdditionalProductsSearch.setToolTipText("Buscar un empleado por número de cédula");
        btnAdditionalProductsSearch.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnAdditionalProductsSearch.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnAdditionalProductsSearch.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnAdditionalProductsSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdditionalProductsSearchActionPerformed(evt);
            }
        });

        btnAdditionalProductsNew.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnAdditionalProductsNew.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/menuCrud/iconBtnNew.png"))); // NOI18N
        btnAdditionalProductsNew.setText("Nuevo");
        btnAdditionalProductsNew.setToolTipText("Limpiar las cajas de texto para crear un nuevo empleado");
        btnAdditionalProductsNew.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnAdditionalProductsNew.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnAdditionalProductsNew.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnAdditionalProductsNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdditionalProductsNewActionPerformed(evt);
            }
        });

        btnAdditionalProductsList.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnAdditionalProductsList.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/menuCrud/iconBtnList.png"))); // NOI18N
        btnAdditionalProductsList.setText("Listar Productos");
        btnAdditionalProductsList.setToolTipText("Listar todos los empleados en la empresa");
        btnAdditionalProductsList.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnAdditionalProductsList.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnAdditionalProductsList.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnAdditionalProductsList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdditionalProductsListActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlAdditionalProductsButtonsLayout = new javax.swing.GroupLayout(pnlAdditionalProductsButtons);
        pnlAdditionalProductsButtons.setLayout(pnlAdditionalProductsButtonsLayout);
        pnlAdditionalProductsButtonsLayout.setHorizontalGroup(
            pnlAdditionalProductsButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlAdditionalProductsButtonsLayout.createSequentialGroup()
                .addComponent(btnAdditionalProductsNew)
                .addGap(3, 3, 3)
                .addComponent(btnAdditionalProductsInsert)
                .addGap(3, 3, 3)
                .addComponent(btnAdditionalProductsSearch)
                .addGap(3, 3, 3)
                .addComponent(btnAdditionalProductsEdit)
                .addGap(3, 3, 3)
                .addComponent(btnAdditionalProductsDelete)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAdditionalProductsList)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlAdditionalProductsButtonsLayout.setVerticalGroup(
            pnlAdditionalProductsButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlAdditionalProductsButtonsLayout.createSequentialGroup()
                .addGroup(pnlAdditionalProductsButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAdditionalProductsNew, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAdditionalProductsInsert, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAdditionalProductsSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAdditionalProductsEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAdditionalProductsDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAdditionalProductsList, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        dlgAdminAdditionalProducts.getContentPane().add(pnlAdditionalProductsButtons);
        pnlAdditionalProductsButtons.setBounds(0, 30, 640, 90);

        tblAdditionalProducts.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        tblAdditionalProducts.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Nombre", "Descripción", "Precio", "Notas"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        scrollPanelAdditionalProductsTable.setViewportView(tblAdditionalProducts);
        tblAdditionalProducts.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        dlgAdminAdditionalProducts.getContentPane().add(scrollPanelAdditionalProductsTable);
        scrollPanelAdditionalProductsTable.setBounds(640, 122, 640, 410);

        pnlAdditionalProducts.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.MatteBorder(null), "Datos ", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), java.awt.Color.red)); // NOI18N
        pnlAdditionalProducts.setOpaque(false);

        txtAdditionalProductsName.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtAdditionalProductsName.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        lblAdditionalProductsName.setFont(new java.awt.Font("Noto Sans", 0, 18)); // NOI18N
        lblAdditionalProductsName.setText("Nombre");

        lblAdditionalProductsDescription.setFont(new java.awt.Font("Noto Sans", 0, 18)); // NOI18N
        lblAdditionalProductsDescription.setText("Descripción");

        txtAdditionalProductsPrice.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtAdditionalProductsPrice.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtAdditionalProductsPrice.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtAdditionalProductsPriceKeyTyped(evt);
            }
        });

        lblAdditionalPrice.setFont(new java.awt.Font("Noto Sans", 0, 18)); // NOI18N
        lblAdditionalPrice.setText("Precio");

        lblAdditionalProductsNotes.setFont(new java.awt.Font("Noto Sans", 0, 18)); // NOI18N
        lblAdditionalProductsNotes.setText("Notas");

        txtAdditionalProductsNotes.setColumns(20);
        txtAdditionalProductsNotes.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtAdditionalProductsNotes.setLineWrap(true);
        txtAdditionalProductsNotes.setRows(5);
        scrolAdditionalProductslNotes.setViewportView(txtAdditionalProductsNotes);

        txtAdditionalProductsDescription.setColumns(20);
        txtAdditionalProductsDescription.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtAdditionalProductsDescription.setLineWrap(true);
        txtAdditionalProductsDescription.setRows(5);
        scrolAdditionalProductDescription.setViewportView(txtAdditionalProductsDescription);

        javax.swing.GroupLayout pnlAdditionalProductsLayout = new javax.swing.GroupLayout(pnlAdditionalProducts);
        pnlAdditionalProducts.setLayout(pnlAdditionalProductsLayout);
        pnlAdditionalProductsLayout.setHorizontalGroup(
            pnlAdditionalProductsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlAdditionalProductsLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lblAdditionalProductsDescription)
                .addGap(150, 150, 150))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlAdditionalProductsLayout.createSequentialGroup()
                .addComponent(scrolAdditionalProductslNotes)
                .addContainerGap())
            .addGroup(pnlAdditionalProductsLayout.createSequentialGroup()
                .addGroup(pnlAdditionalProductsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlAdditionalProductsLayout.createSequentialGroup()
                        .addGap(167, 167, 167)
                        .addComponent(lblAdditionalProductsName))
                    .addGroup(pnlAdditionalProductsLayout.createSequentialGroup()
                        .addGap(175, 175, 175)
                        .addComponent(lblAdditionalPrice))
                    .addGroup(pnlAdditionalProductsLayout.createSequentialGroup()
                        .addGap(177, 177, 177)
                        .addComponent(lblAdditionalProductsNotes))
                    .addGroup(pnlAdditionalProductsLayout.createSequentialGroup()
                        .addGap(99, 99, 99)
                        .addGroup(pnlAdditionalProductsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtAdditionalProductsName, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtAdditionalProductsPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(pnlAdditionalProductsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scrolAdditionalProductDescription)
                .addContainerGap())
        );
        pnlAdditionalProductsLayout.setVerticalGroup(
            pnlAdditionalProductsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlAdditionalProductsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblAdditionalProductsName)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtAdditionalProductsName, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblAdditionalProductsDescription)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(scrolAdditionalProductDescription, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblAdditionalPrice)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtAdditionalProductsPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblAdditionalProductsNotes)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrolAdditionalProductslNotes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(61, 61, 61))
        );

        dlgAdminAdditionalProducts.getContentPane().add(pnlAdditionalProducts);
        pnlAdditionalProducts.setBounds(0, 120, 410, 470);

        btnAdditionalProductsBack.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnAdditionalProductsBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/back.png"))); // NOI18N
        btnAdditionalProductsBack.setText("Volver");
        btnAdditionalProductsBack.setBorderPainted(false);
        btnAdditionalProductsBack.setContentAreaFilled(false);
        btnAdditionalProductsBack.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAdditionalProductsBack.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnAdditionalProductsBack.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnAdditionalProductsBack.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnAdditionalProductsBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdditionalProductsBackActionPerformed(evt);
            }
        });
        dlgAdminAdditionalProducts.getContentPane().add(btnAdditionalProductsBack);
        btnAdditionalProductsBack.setBounds(1220, 605, 120, 120);

        lblAdditionalProductsTitle.setFont(new java.awt.Font("Noto Sans", 1, 28)); // NOI18N
        lblAdditionalProductsTitle.setText("Administrar Productos adicionales");
        dlgAdminAdditionalProducts.getContentPane().add(lblAdditionalProductsTitle);
        lblAdditionalProductsTitle.setBounds(640, 60, 500, 50);

        lblAdditionalProductsBackgroundDialog.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/555.jpg"))); // NOI18N
        dlgAdminAdditionalProducts.getContentPane().add(lblAdditionalProductsBackgroundDialog);
        lblAdditionalProductsBackgroundDialog.setBounds(-10, 0, 1390, 770);

        dlgAdminLocal.setTitle("Administrar Locales");
        dlgAdminLocal.setMinimumSize(new java.awt.Dimension(1382, 744));
        dlgAdminLocal.setSize(new java.awt.Dimension(1382, 744));
        dlgAdminLocal.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                dlgAdminLocalWindowClosing(evt);
            }
        });
        dlgAdminLocal.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlLocals.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.MatteBorder(null), "Datos ", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), java.awt.Color.red)); // NOI18N
        pnlLocals.setOpaque(false);

        txtLocalsNameL.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtLocalsNameL.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        lblLocalsyNit.setFont(new java.awt.Font("Noto Sans", 0, 18)); // NOI18N
        lblLocalsyNit.setText("Nit");

        lblLocalsName.setFont(new java.awt.Font("Noto Sans", 0, 18)); // NOI18N
        lblLocalsName.setText("Nombre local");

        txtLocalsAddress.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtLocalsAddress.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtLocalsAddress.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtLocalsAddressKeyTyped(evt);
            }
        });

        lblLocalsAddress.setFont(new java.awt.Font("Noto Sans", 0, 18)); // NOI18N
        lblLocalsAddress.setText("Dirección");

        lblLocalsNeighborhood.setFont(new java.awt.Font("Noto Sans", 0, 18)); // NOI18N
        lblLocalsNeighborhood.setText("Barrio");

        txtLocalsNit.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtLocalsNit.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtLocalsNit.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtLocalsNitKeyTyped(evt);
            }
        });

        txtLocalsNeighborhood.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtLocalsNeighborhood.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtLocalsNeighborhood.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtLocalsNeighborhoodKeyTyped(evt);
            }
        });

        lblLocalsTown.setFont(new java.awt.Font("Noto Sans", 0, 18)); // NOI18N
        lblLocalsTown.setText("Municipio");

        lblLocalsCity.setFont(new java.awt.Font("Noto Sans", 0, 18)); // NOI18N
        lblLocalsCity.setText("Departamento");

        cbLocalsTown.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Manizales", "Villamaria" }));

        cbLocalsCity.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Caldas" }));

        javax.swing.GroupLayout pnlLocalsLayout = new javax.swing.GroupLayout(pnlLocals);
        pnlLocals.setLayout(pnlLocalsLayout);
        pnlLocalsLayout.setHorizontalGroup(
            pnlLocalsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlLocalsLayout.createSequentialGroup()
                .addGroup(pnlLocalsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlLocalsLayout.createSequentialGroup()
                        .addGap(183, 183, 183)
                        .addComponent(lblLocalsyNit))
                    .addGroup(pnlLocalsLayout.createSequentialGroup()
                        .addGap(134, 134, 134)
                        .addComponent(lblLocalsCity)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlLocalsLayout.createSequentialGroup()
                .addContainerGap(107, Short.MAX_VALUE)
                .addGroup(pnlLocalsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnlLocalsLayout.createSequentialGroup()
                        .addComponent(lblLocalsNeighborhood)
                        .addGap(80, 80, 80))
                    .addComponent(txtLocalsNit, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(97, 97, 97))
            .addGroup(pnlLocalsLayout.createSequentialGroup()
                .addGroup(pnlLocalsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlLocalsLayout.createSequentialGroup()
                        .addGap(141, 141, 141)
                        .addComponent(lblLocalsName))
                    .addGroup(pnlLocalsLayout.createSequentialGroup()
                        .addGap(160, 160, 160)
                        .addComponent(lblLocalsAddress))
                    .addGroup(pnlLocalsLayout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addGroup(pnlLocalsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtLocalsAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtLocalsNameL, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtLocalsNeighborhood, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pnlLocalsLayout.createSequentialGroup()
                        .addGap(155, 155, 155)
                        .addComponent(lblLocalsTown))
                    .addGroup(pnlLocalsLayout.createSequentialGroup()
                        .addGap(71, 71, 71)
                        .addGroup(pnlLocalsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbLocalsCity, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbLocalsTown, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        pnlLocalsLayout.setVerticalGroup(
            pnlLocalsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlLocalsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblLocalsyNit)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtLocalsNit, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(lblLocalsName)
                .addGap(18, 18, 18)
                .addComponent(txtLocalsNameL, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblLocalsAddress)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtLocalsAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblLocalsNeighborhood)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtLocalsNeighborhood, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17)
                .addComponent(lblLocalsTown)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbLocalsTown, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblLocalsCity)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbLocalsCity, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        dlgAdminLocal.getContentPane().add(pnlLocals, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, -1, -1));

        pnlLocalsButtons.setOpaque(false);

        btnLocalsEdit.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnLocalsEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/menuCrud/iconBtnEdit.png"))); // NOI18N
        btnLocalsEdit.setText("Modificar");
        btnLocalsEdit.setToolTipText("Modificar el empleado con los datos que aparecen en las cajas de texto");
        btnLocalsEdit.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnLocalsEdit.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnLocalsEdit.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnLocalsEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLocalsEditActionPerformed(evt);
            }
        });

        btnLocalsDelete.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnLocalsDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/menuCrud/iconBtnDelete.png"))); // NOI18N
        btnLocalsDelete.setText("Eliminar");
        btnLocalsDelete.setToolTipText("Eliminar un empleado");
        btnLocalsDelete.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnLocalsDelete.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnLocalsDelete.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnLocalsDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLocalsDeleteActionPerformed(evt);
            }
        });

        btnLocalsInsert.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnLocalsInsert.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/menuCrud/iconBtnSave.png"))); // NOI18N
        btnLocalsInsert.setText("Insertar");
        btnLocalsInsert.setToolTipText("Ingresar un nuevo empleado");
        btnLocalsInsert.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnLocalsInsert.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnLocalsInsert.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnLocalsInsert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLocalsInsertActionPerformed(evt);
            }
        });

        btnLocalsSearch.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnLocalsSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/menuCrud/iconBtnSearch.png"))); // NOI18N
        btnLocalsSearch.setText("Consultar");
        btnLocalsSearch.setToolTipText("Buscar un empleado por número de cédula");
        btnLocalsSearch.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnLocalsSearch.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnLocalsSearch.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnLocalsSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLocalsSearchActionPerformed(evt);
            }
        });

        btnLocalsNew.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnLocalsNew.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/menuCrud/iconBtnNew.png"))); // NOI18N
        btnLocalsNew.setText("Nuevo");
        btnLocalsNew.setToolTipText("Limpiar las cajas de texto para crear un nuevo empleado");
        btnLocalsNew.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnLocalsNew.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnLocalsNew.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnLocalsNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLocalsNewActionPerformed(evt);
            }
        });

        btnLocalsList.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnLocalsList.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/menuCrud/iconBtnList.png"))); // NOI18N
        btnLocalsList.setText("Listar Locales");
        btnLocalsList.setToolTipText("Listar todos los empleados en la empresa");
        btnLocalsList.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnLocalsList.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnLocalsList.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnLocalsList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLocalsListActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlLocalsButtonsLayout = new javax.swing.GroupLayout(pnlLocalsButtons);
        pnlLocalsButtons.setLayout(pnlLocalsButtonsLayout);
        pnlLocalsButtonsLayout.setHorizontalGroup(
            pnlLocalsButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlLocalsButtonsLayout.createSequentialGroup()
                .addComponent(btnLocalsNew)
                .addGap(3, 3, 3)
                .addComponent(btnLocalsInsert)
                .addGap(3, 3, 3)
                .addComponent(btnLocalsSearch)
                .addGap(3, 3, 3)
                .addComponent(btnLocalsEdit)
                .addGap(3, 3, 3)
                .addComponent(btnLocalsDelete)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnLocalsList)
                .addContainerGap(122, Short.MAX_VALUE))
        );
        pnlLocalsButtonsLayout.setVerticalGroup(
            pnlLocalsButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlLocalsButtonsLayout.createSequentialGroup()
                .addGroup(pnlLocalsButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnLocalsNew, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLocalsInsert, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLocalsSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLocalsEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLocalsDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLocalsList, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        dlgAdminLocal.getContentPane().add(pnlLocalsButtons, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, -1, -1));

        tblLocals.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        tblLocals.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Nombre", "Descripción", "Precio", "Notas"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        scrollPanelLocalsTable.setViewportView(tblLocals);
        tblLocals.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        dlgAdminLocal.getContentPane().add(scrollPanelLocalsTable, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 122, 640, 410));

        btnLocalsBack.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnLocalsBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/back.png"))); // NOI18N
        btnLocalsBack.setText("Volver");
        btnLocalsBack.setBorderPainted(false);
        btnLocalsBack.setContentAreaFilled(false);
        btnLocalsBack.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLocalsBack.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnLocalsBack.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnLocalsBack.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnLocalsBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLocalsBackActionPerformed(evt);
            }
        });
        dlgAdminLocal.getContentPane().add(btnLocalsBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(1220, 605, 120, -1));

        lblLocalsTitle.setFont(new java.awt.Font("Noto Sans", 1, 28)); // NOI18N
        lblLocalsTitle.setText("Administrar Locales");
        dlgAdminLocal.getContentPane().add(lblLocalsTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 60, 350, 50));

        lblLocalsBackgroundDialog.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/555.jpg"))); // NOI18N
        dlgAdminLocal.getContentPane().add(lblLocalsBackgroundDialog, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 0, 1390, 770));

        dlgSelectProducts.setTitle("Seleccionar tipo de producto a administrar");
        dlgSelectProducts.setMinimumSize(new java.awt.Dimension(702, 449));
        dlgSelectProducts.setResizable(false);
        dlgSelectProducts.setSize(new java.awt.Dimension(702, 449));

        pnlSelectAdminProducts.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Selección de tipo de productos", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), java.awt.Color.red)); // NOI18N

        btnSelectAdminAdditions.setText("Administrar adicionales");
        btnSelectAdminAdditions.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelectAdminAdditionsActionPerformed(evt);
            }
        });

        btnSelectAdminProducts.setText("Administrar Productos Principales");
        btnSelectAdminProducts.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelectAdminProductsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlSelectAdminProductsLayout = new javax.swing.GroupLayout(pnlSelectAdminProducts);
        pnlSelectAdminProducts.setLayout(pnlSelectAdminProductsLayout);
        pnlSelectAdminProductsLayout.setHorizontalGroup(
            pnlSelectAdminProductsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlSelectAdminProductsLayout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(btnSelectAdminProducts, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(btnSelectAdminAdditions, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(45, Short.MAX_VALUE))
        );
        pnlSelectAdminProductsLayout.setVerticalGroup(
            pnlSelectAdminProductsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSelectAdminProductsLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(pnlSelectAdminProductsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSelectAdminProducts, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSelectAdminAdditions, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(31, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout dlgSelectProductsLayout = new javax.swing.GroupLayout(dlgSelectProducts.getContentPane());
        dlgSelectProducts.getContentPane().setLayout(dlgSelectProductsLayout);
        dlgSelectProductsLayout.setHorizontalGroup(
            dlgSelectProductsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dlgSelectProductsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlSelectAdminProducts, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        dlgSelectProductsLayout.setVerticalGroup(
            dlgSelectProductsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dlgSelectProductsLayout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addComponent(pnlSelectAdminProducts, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(39, Short.MAX_VALUE))
        );

        dlgAdminUsers.setTitle("Administrar Productos");
        dlgAdminUsers.setMinimumSize(new java.awt.Dimension(1382, 744));
        dlgAdminUsers.setSize(new java.awt.Dimension(1382, 744));
        dlgAdminUsers.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                dlgAdminUsersWindowClosing(evt);
            }
        });
        dlgAdminUsers.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblUsers.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        tblUsers.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Usuario", "Contraseña", "Descripción", "Fecha de registo", "Fecha de último ingreso", "Es administrador ?"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        scrollPanelUsersTable.setViewportView(tblUsers);
        tblUsers.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        dlgAdminUsers.getContentPane().add(scrollPanelUsersTable, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 122, 640, 410));

        pnlUsersButtons.setOpaque(false);

        btnUsersEdit.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnUsersEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/menuCrud/iconBtnEdit.png"))); // NOI18N
        btnUsersEdit.setText("Modificar");
        btnUsersEdit.setToolTipText("Modificar el empleado con los datos que aparecen en las cajas de texto");
        btnUsersEdit.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnUsersEdit.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnUsersEdit.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnUsersEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUsersEditActionPerformed(evt);
            }
        });

        btnUsersDelete.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnUsersDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/menuCrud/iconBtnDelete.png"))); // NOI18N
        btnUsersDelete.setText("Eliminar");
        btnUsersDelete.setToolTipText("Eliminar un empleado");
        btnUsersDelete.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnUsersDelete.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnUsersDelete.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnUsersDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUsersDeleteActionPerformed(evt);
            }
        });

        btnUsersInsert.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnUsersInsert.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/menuCrud/iconBtnSave.png"))); // NOI18N
        btnUsersInsert.setText("Insertar");
        btnUsersInsert.setToolTipText("Ingresar un nuevo empleado");
        btnUsersInsert.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnUsersInsert.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnUsersInsert.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnUsersInsert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUsersInsertActionPerformed(evt);
            }
        });

        btnUsersSearch.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnUsersSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/menuCrud/iconBtnSearch.png"))); // NOI18N
        btnUsersSearch.setText("Consultar");
        btnUsersSearch.setToolTipText("Buscar un empleado por número de cédula");
        btnUsersSearch.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnUsersSearch.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnUsersSearch.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnUsersSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUsersSearchActionPerformed(evt);
            }
        });

        btnUersNew.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnUersNew.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/menuCrud/iconBtnNew.png"))); // NOI18N
        btnUersNew.setText("Nuevo");
        btnUersNew.setToolTipText("Limpiar las cajas de texto para crear un nuevo empleado");
        btnUersNew.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnUersNew.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnUersNew.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnUersNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUersNewActionPerformed(evt);
            }
        });

        btnUsersList.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnUsersList.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/menuCrud/iconBtnList.png"))); // NOI18N
        btnUsersList.setText("Listar Usuarios");
        btnUsersList.setToolTipText("Listar todos los empleados en la empresa");
        btnUsersList.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnUsersList.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnUsersList.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnUsersList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUsersListActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlUsersButtonsLayout = new javax.swing.GroupLayout(pnlUsersButtons);
        pnlUsersButtons.setLayout(pnlUsersButtonsLayout);
        pnlUsersButtonsLayout.setHorizontalGroup(
            pnlUsersButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlUsersButtonsLayout.createSequentialGroup()
                .addComponent(btnUersNew)
                .addGap(3, 3, 3)
                .addComponent(btnUsersInsert)
                .addGap(3, 3, 3)
                .addComponent(btnUsersSearch)
                .addGap(3, 3, 3)
                .addComponent(btnUsersEdit)
                .addGap(3, 3, 3)
                .addComponent(btnUsersDelete)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnUsersList)
                .addContainerGap(104, Short.MAX_VALUE))
        );
        pnlUsersButtonsLayout.setVerticalGroup(
            pnlUsersButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlUsersButtonsLayout.createSequentialGroup()
                .addGroup(pnlUsersButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnUersNew, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUsersInsert, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUsersSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUsersEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUsersDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUsersList, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        dlgAdminUsers.getContentPane().add(pnlUsersButtons, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, -1, -1));

        pnlUsers.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.MatteBorder(null), "Datos ", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), java.awt.Color.red)); // NOI18N
        pnlUsers.setOpaque(false);

        txtUsersNameUser.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtUsersNameUser.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        lblUsersNameUser.setFont(new java.awt.Font("Noto Sans", 0, 18)); // NOI18N
        lblUsersNameUser.setText("Nombre de Usuario");

        lblUsersPassword.setFont(new java.awt.Font("Noto Sans", 0, 18)); // NOI18N
        lblUsersPassword.setText("Contraseña");

        lblProductsNotes1.setFont(new java.awt.Font("Noto Sans", 0, 18)); // NOI18N
        lblProductsNotes1.setText("Notas");

        txtUsersNotes.setColumns(20);
        txtUsersNotes.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtUsersNotes.setLineWrap(true);
        txtUsersNotes.setRows(5);
        scrolProductslNotes3.setViewportView(txtUsersNotes);

        lblUsersPassword1.setFont(new java.awt.Font("Noto Sans", 0, 18)); // NOI18N
        lblUsersPassword1.setText("Repetir contraseña");

        txtUsersPassword.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        txtUsersRepeatPassword.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        cboUsersIsAdmin.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        cboUsersIsAdmin.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Si", "No" }));
        cboUsersIsAdmin.setSelectedIndex(1);
        cboUsersIsAdmin.setToolTipText("El usuario puede administrar ?");

        lblUsersIsAdmin.setFont(new java.awt.Font("Noto Sans", 0, 18)); // NOI18N
        lblUsersIsAdmin.setText("¿Es administrador?");

        javax.swing.GroupLayout pnlUsersLayout = new javax.swing.GroupLayout(pnlUsers);
        pnlUsers.setLayout(pnlUsersLayout);
        pnlUsersLayout.setHorizontalGroup(
            pnlUsersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlUsersLayout.createSequentialGroup()
                .addGroup(pnlUsersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scrolProductslNotes3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 390, Short.MAX_VALUE)
                    .addGroup(pnlUsersLayout.createSequentialGroup()
                        .addGroup(pnlUsersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlUsersLayout.createSequentialGroup()
                                .addGap(167, 167, 167)
                                .addComponent(lblProductsNotes1))
                            .addGroup(pnlUsersLayout.createSequentialGroup()
                                .addGap(99, 99, 99)
                                .addGroup(pnlUsersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtUsersPassword)
                                    .addComponent(txtUsersNameUser, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtUsersRepeatPassword, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                                    .addComponent(cboUsersIsAdmin, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(pnlUsersLayout.createSequentialGroup()
                .addGap(150, 150, 150)
                .addComponent(lblUsersPassword)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlUsersLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblUsersNameUser)
                .addGap(115, 115, 115))
            .addGroup(pnlUsersLayout.createSequentialGroup()
                .addGroup(pnlUsersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlUsersLayout.createSequentialGroup()
                        .addGap(118, 118, 118)
                        .addComponent(lblUsersPassword1))
                    .addGroup(pnlUsersLayout.createSequentialGroup()
                        .addGap(117, 117, 117)
                        .addComponent(lblUsersIsAdmin)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlUsersLayout.setVerticalGroup(
            pnlUsersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlUsersLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblUsersNameUser)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtUsersNameUser, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(lblUsersPassword)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtUsersPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblUsersPassword1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtUsersRepeatPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                .addComponent(lblUsersIsAdmin)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cboUsersIsAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblProductsNotes1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(scrolProductslNotes3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        dlgAdminUsers.getContentPane().add(pnlUsers, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 410, 580));

        btnUsersBack.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnUsersBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/back.png"))); // NOI18N
        btnUsersBack.setText("Volver");
        btnUsersBack.setBorderPainted(false);
        btnUsersBack.setContentAreaFilled(false);
        btnUsersBack.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnUsersBack.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnUsersBack.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnUsersBack.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnUsersBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUsersBackActionPerformed(evt);
            }
        });
        dlgAdminUsers.getContentPane().add(btnUsersBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(1220, 605, 120, -1));

        lblUsersTitle.setFont(new java.awt.Font("Noto Sans", 1, 28)); // NOI18N
        lblUsersTitle.setText("Administrar Usuarios");
        dlgAdminUsers.getContentPane().add(lblUsersTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 60, 350, 50));

        lblUsersBackgroundDialog.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/555.jpg"))); // NOI18N
        dlgAdminUsers.getContentPane().add(lblUsersBackgroundDialog, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 0, 1390, 770));

        dlgAdminInventoryHistory.setTitle("Administrar Productos");
        dlgAdminInventoryHistory.setMinimumSize(new java.awt.Dimension(1382, 744));
        dlgAdminInventoryHistory.setSize(new java.awt.Dimension(1382, 744));
        dlgAdminInventoryHistory.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                dlgAdminInventoryHistoryWindowClosing(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                dlgAdminInventoryHistoryWindowOpened(evt);
            }
        });
        dlgAdminInventoryHistory.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblInventoryHistory.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        tblInventoryHistory.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Fecha", "Producto", "Entra", "Sale"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        scrollPanelInventoryHistoryTable.setViewportView(tblInventoryHistory);
        tblInventoryHistory.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        dlgAdminInventoryHistory.getContentPane().add(scrollPanelInventoryHistoryTable, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 122, 680, 410));

        pnlInventoryHistoryButtons.setOpaque(false);

        btnInventoryHistoryEdit.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnInventoryHistoryEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/menuCrud/iconBtnEdit.png"))); // NOI18N
        btnInventoryHistoryEdit.setText("Modificar");
        btnInventoryHistoryEdit.setToolTipText("Modificar el empleado con los datos que aparecen en las cajas de texto");
        btnInventoryHistoryEdit.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnInventoryHistoryEdit.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnInventoryHistoryEdit.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnInventoryHistoryEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInventoryHistoryEditActionPerformed(evt);
            }
        });

        btnInventoryHistoryDelete.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnInventoryHistoryDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/menuCrud/iconBtnDelete.png"))); // NOI18N
        btnInventoryHistoryDelete.setText("Eliminar");
        btnInventoryHistoryDelete.setToolTipText("Eliminar un empleado");
        btnInventoryHistoryDelete.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnInventoryHistoryDelete.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnInventoryHistoryDelete.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnInventoryHistoryDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInventoryHistoryDeleteActionPerformed(evt);
            }
        });

        btnInventoryHistoryInsert.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnInventoryHistoryInsert.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/menuCrud/iconBtnSave.png"))); // NOI18N
        btnInventoryHistoryInsert.setText("Insertar");
        btnInventoryHistoryInsert.setToolTipText("Ingresar un nuevo empleado");
        btnInventoryHistoryInsert.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnInventoryHistoryInsert.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnInventoryHistoryInsert.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnInventoryHistoryInsert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInventoryHistoryInsertActionPerformed(evt);
            }
        });

        btnInventoryHistoryList.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnInventoryHistoryList.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/menuCrud/iconBtnList.png"))); // NOI18N
        btnInventoryHistoryList.setText("Listar Inventario");
        btnInventoryHistoryList.setToolTipText("Listar todos los empleados en la empresa");
        btnInventoryHistoryList.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnInventoryHistoryList.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnInventoryHistoryList.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnInventoryHistoryList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInventoryHistoryListActionPerformed(evt);
            }
        });

        btnInventoryHistorySearch.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnInventoryHistorySearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/menuCrud/iconBtnSearch.png"))); // NOI18N
        btnInventoryHistorySearch.setText("Consultar");
        btnInventoryHistorySearch.setToolTipText("Buscar un empleado por número de cédula");
        btnInventoryHistorySearch.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnInventoryHistorySearch.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnInventoryHistorySearch.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnInventoryHistorySearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInventoryHistorySearchActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlInventoryHistoryButtonsLayout = new javax.swing.GroupLayout(pnlInventoryHistoryButtons);
        pnlInventoryHistoryButtons.setLayout(pnlInventoryHistoryButtonsLayout);
        pnlInventoryHistoryButtonsLayout.setHorizontalGroup(
            pnlInventoryHistoryButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlInventoryHistoryButtonsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnInventoryHistoryInsert)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnInventoryHistorySearch)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnInventoryHistoryEdit)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnInventoryHistoryDelete)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnInventoryHistoryList)
                .addContainerGap())
        );
        pnlInventoryHistoryButtonsLayout.setVerticalGroup(
            pnlInventoryHistoryButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlInventoryHistoryButtonsLayout.createSequentialGroup()
                .addGroup(pnlInventoryHistoryButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnInventoryHistoryInsert, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnInventoryHistoryEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnInventoryHistoryDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnInventoryHistoryList, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnInventoryHistorySearch, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 22, Short.MAX_VALUE))
        );

        dlgAdminInventoryHistory.getContentPane().add(pnlInventoryHistoryButtons, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, -1, -1));

        pnlInventoryHistory.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.MatteBorder(null), "Datos ", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), java.awt.Color.red)); // NOI18N
        pnlInventoryHistory.setOpaque(false);

        lblInventoryHistoryProduct.setFont(new java.awt.Font("Noto Sans", 0, 24)); // NOI18N
        lblInventoryHistoryProduct.setText("Producto");

        lblInventoryHistoryActionInOut.setFont(new java.awt.Font("Noto Sans", 0, 24)); // NOI18N
        lblInventoryHistoryActionInOut.setText("¿Entra o sale?");

        lblInventoryHistoryAmount.setFont(new java.awt.Font("Noto Sans", 0, 24)); // NOI18N
        lblInventoryHistoryAmount.setText("Cantidad");

        cboInventoryHistoryInOut.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        cboInventoryHistoryInOut.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Entra", "Sale" }));
        cboInventoryHistoryInOut.setToolTipText("El producto entra o sale");

        cboInventoryHistoryProduct.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        cboInventoryHistoryProduct.setToolTipText("Productos que entran o salen");

        javax.swing.GroupLayout pnlInventoryHistoryLayout = new javax.swing.GroupLayout(pnlInventoryHistory);
        pnlInventoryHistory.setLayout(pnlInventoryHistoryLayout);
        pnlInventoryHistoryLayout.setHorizontalGroup(
            pnlInventoryHistoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlInventoryHistoryLayout.createSequentialGroup()
                .addGroup(pnlInventoryHistoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlInventoryHistoryLayout.createSequentialGroup()
                        .addGap(148, 148, 148)
                        .addComponent(lblInventoryHistoryAmount))
                    .addGroup(pnlInventoryHistoryLayout.createSequentialGroup()
                        .addGap(82, 82, 82)
                        .addGroup(pnlInventoryHistoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cboInventoryHistoryInOut, 0, 244, Short.MAX_VALUE)
                            .addComponent(cboInventoryHistoryProduct, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtInventoryHistoryAmount))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(pnlInventoryHistoryLayout.createSequentialGroup()
                .addGroup(pnlInventoryHistoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlInventoryHistoryLayout.createSequentialGroup()
                        .addGap(122, 122, 122)
                        .addComponent(lblInventoryHistoryActionInOut))
                    .addGroup(pnlInventoryHistoryLayout.createSequentialGroup()
                        .addGap(147, 147, 147)
                        .addComponent(lblInventoryHistoryProduct)))
                .addGap(0, 131, Short.MAX_VALUE))
        );
        pnlInventoryHistoryLayout.setVerticalGroup(
            pnlInventoryHistoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlInventoryHistoryLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblInventoryHistoryProduct)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cboInventoryHistoryProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblInventoryHistoryActionInOut)
                .addGap(8, 8, 8)
                .addComponent(cboInventoryHistoryInOut, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblInventoryHistoryAmount)
                .addGap(18, 18, 18)
                .addComponent(txtInventoryHistoryAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(72, Short.MAX_VALUE))
        );

        dlgAdminInventoryHistory.getContentPane().add(pnlInventoryHistory, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 420, 390));

        btnInventoryHistoryBack.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnInventoryHistoryBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/back.png"))); // NOI18N
        btnInventoryHistoryBack.setText("Volver");
        btnInventoryHistoryBack.setBorderPainted(false);
        btnInventoryHistoryBack.setContentAreaFilled(false);
        btnInventoryHistoryBack.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnInventoryHistoryBack.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnInventoryHistoryBack.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnInventoryHistoryBack.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnInventoryHistoryBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInventoryHistoryBackActionPerformed(evt);
            }
        });
        dlgAdminInventoryHistory.getContentPane().add(btnInventoryHistoryBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(1220, 605, 120, -1));

        lblInventoryHistoryTitle.setFont(new java.awt.Font("Noto Sans", 1, 28)); // NOI18N
        lblInventoryHistoryTitle.setText("Administrar Inventario");
        dlgAdminInventoryHistory.getContentPane().add(lblInventoryHistoryTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 60, 350, 50));

        lblInventoryHistoryBackgroundDialog.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/555.jpg"))); // NOI18N
        dlgAdminInventoryHistory.getContentPane().add(lblInventoryHistoryBackgroundDialog, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 0, 1390, 770));

        dlgSelectInventory.setTitle("Seleccionar tipo de producto a administrar");
        dlgSelectInventory.setMinimumSize(new java.awt.Dimension(702, 449));
        dlgSelectInventory.setModal(true);
        dlgSelectInventory.setResizable(false);
        dlgSelectInventory.setSize(new java.awt.Dimension(702, 449));

        pnlSelectAdminInventory.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Selección de tipo de productos", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), java.awt.Color.red)); // NOI18N

        btnSelectInventoryHistory.setText("Administrar productos en inventario");
        btnSelectInventoryHistory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelectInventoryHistoryActionPerformed(evt);
            }
        });

        btnSelectInventory1.setText("Agregar o eliminar productos de inventario");
        btnSelectInventory1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelectInventory1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlSelectAdminInventoryLayout = new javax.swing.GroupLayout(pnlSelectAdminInventory);
        pnlSelectAdminInventory.setLayout(pnlSelectAdminInventoryLayout);
        pnlSelectAdminInventoryLayout.setHorizontalGroup(
            pnlSelectAdminInventoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlSelectAdminInventoryLayout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(btnSelectInventory1, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(btnSelectInventoryHistory, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(45, Short.MAX_VALUE))
        );
        pnlSelectAdminInventoryLayout.setVerticalGroup(
            pnlSelectAdminInventoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSelectAdminInventoryLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(pnlSelectAdminInventoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSelectInventory1, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSelectInventoryHistory, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(31, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout dlgSelectInventoryLayout = new javax.swing.GroupLayout(dlgSelectInventory.getContentPane());
        dlgSelectInventory.getContentPane().setLayout(dlgSelectInventoryLayout);
        dlgSelectInventoryLayout.setHorizontalGroup(
            dlgSelectInventoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dlgSelectInventoryLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlSelectAdminInventory, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        dlgSelectInventoryLayout.setVerticalGroup(
            dlgSelectInventoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dlgSelectInventoryLayout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addComponent(pnlSelectAdminInventory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(39, Short.MAX_VALUE))
        );

        dlgAdminInventory.setTitle("Administrar Productos");
        dlgAdminInventory.setMinimumSize(new java.awt.Dimension(1382, 744));
        dlgAdminInventory.setSize(new java.awt.Dimension(1382, 744));
        dlgAdminInventory.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                dlgAdminInventoryWindowClosing(evt);
            }
        });
        dlgAdminInventory.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblInventory.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        tblInventory.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Usuario", "Contraseña", "Descripción", "Fecha de registo", "Fecha de último ingreso", "Es administrador ?"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        scrollPanelInventoryTable.setViewportView(tblInventory);
        tblInventory.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        dlgAdminInventory.getContentPane().add(scrollPanelInventoryTable, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 122, 640, 410));

        pnlInventoryButtons.setOpaque(false);

        btnInventoryEdit.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnInventoryEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/menuCrud/iconBtnEdit.png"))); // NOI18N
        btnInventoryEdit.setText("Modificar");
        btnInventoryEdit.setToolTipText("Modificar el empleado con los datos que aparecen en las cajas de texto");
        btnInventoryEdit.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnInventoryEdit.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnInventoryEdit.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnInventoryEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInventoryEditActionPerformed(evt);
            }
        });

        btnInventoryDelete.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnInventoryDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/menuCrud/iconBtnDelete.png"))); // NOI18N
        btnInventoryDelete.setText("Eliminar");
        btnInventoryDelete.setToolTipText("Eliminar un empleado");
        btnInventoryDelete.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnInventoryDelete.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnInventoryDelete.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnInventoryDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInventoryDeleteActionPerformed(evt);
            }
        });

        btnInventoryInsert.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnInventoryInsert.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/menuCrud/iconBtnSave.png"))); // NOI18N
        btnInventoryInsert.setText("Insertar");
        btnInventoryInsert.setToolTipText("Ingresar un nuevo empleado");
        btnInventoryInsert.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnInventoryInsert.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnInventoryInsert.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnInventoryInsert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInventoryInsertActionPerformed(evt);
            }
        });

        btnInventorySearch.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnInventorySearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/menuCrud/iconBtnSearch.png"))); // NOI18N
        btnInventorySearch.setText("Consultar");
        btnInventorySearch.setToolTipText("Buscar un empleado por número de cédula");
        btnInventorySearch.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnInventorySearch.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnInventorySearch.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnInventorySearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInventorySearchActionPerformed(evt);
            }
        });

        btnInventoryNew.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnInventoryNew.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/menuCrud/iconBtnNew.png"))); // NOI18N
        btnInventoryNew.setText("Nuevo");
        btnInventoryNew.setToolTipText("Limpiar las cajas de texto para crear un nuevo empleado");
        btnInventoryNew.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnInventoryNew.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnInventoryNew.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnInventoryNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInventoryNewActionPerformed(evt);
            }
        });

        btnInventoryList.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnInventoryList.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/menuCrud/iconBtnList.png"))); // NOI18N
        btnInventoryList.setText("Listar productos");
        btnInventoryList.setToolTipText("Listar todos los empleados en la empresa");
        btnInventoryList.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnInventoryList.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnInventoryList.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnInventoryList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInventoryListActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlInventoryButtonsLayout = new javax.swing.GroupLayout(pnlInventoryButtons);
        pnlInventoryButtons.setLayout(pnlInventoryButtonsLayout);
        pnlInventoryButtonsLayout.setHorizontalGroup(
            pnlInventoryButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlInventoryButtonsLayout.createSequentialGroup()
                .addComponent(btnInventoryNew)
                .addGap(3, 3, 3)
                .addComponent(btnInventoryInsert)
                .addGap(3, 3, 3)
                .addComponent(btnInventorySearch)
                .addGap(3, 3, 3)
                .addComponent(btnInventoryEdit)
                .addGap(3, 3, 3)
                .addComponent(btnInventoryDelete)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnInventoryList)
                .addContainerGap(104, Short.MAX_VALUE))
        );
        pnlInventoryButtonsLayout.setVerticalGroup(
            pnlInventoryButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlInventoryButtonsLayout.createSequentialGroup()
                .addGroup(pnlInventoryButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnInventoryNew, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnInventoryInsert, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnInventorySearch, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnInventoryEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnInventoryDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnInventoryList, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        dlgAdminInventory.getContentPane().add(pnlInventoryButtons, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, -1, -1));

        pnlInventory.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.MatteBorder(null), "Datos ", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), java.awt.Color.red)); // NOI18N
        pnlInventory.setOpaque(false);

        lblInventoryProduct.setFont(new java.awt.Font("Noto Sans", 0, 24)); // NOI18N
        lblInventoryProduct.setText("Producto");

        txtInventoryNotes.setColumns(20);
        txtInventoryNotes.setFont(new java.awt.Font("Monospaced", 0, 16)); // NOI18N
        txtInventoryNotes.setRows(5);
        scrollInventoryNotes.setViewportView(txtInventoryNotes);

        lblInventoryNotes.setFont(new java.awt.Font("Noto Sans", 0, 24)); // NOI18N
        lblInventoryNotes.setText("Notas");

        txtInventoryProduct.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        txtInventoryProduct.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        javax.swing.GroupLayout pnlInventoryLayout = new javax.swing.GroupLayout(pnlInventory);
        pnlInventory.setLayout(pnlInventoryLayout);
        pnlInventoryLayout.setHorizontalGroup(
            pnlInventoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlInventoryLayout.createSequentialGroup()
                .addGap(147, 147, 147)
                .addComponent(lblInventoryProduct)
                .addGap(0, 166, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlInventoryLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblInventoryNotes)
                .addGap(173, 173, 173))
            .addGroup(pnlInventoryLayout.createSequentialGroup()
                .addGap(82, 82, 82)
                .addGroup(pnlInventoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(scrollInventoryNotes, javax.swing.GroupLayout.DEFAULT_SIZE, 254, Short.MAX_VALUE)
                    .addComponent(txtInventoryProduct))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlInventoryLayout.setVerticalGroup(
            pnlInventoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlInventoryLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblInventoryProduct)
                .addGap(17, 17, 17)
                .addComponent(txtInventoryProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(lblInventoryNotes)
                .addGap(18, 18, 18)
                .addComponent(scrollInventoryNotes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        dlgAdminInventory.getContentPane().add(pnlInventory, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 420, 340));

        btnInventoryBack.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnInventoryBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/back.png"))); // NOI18N
        btnInventoryBack.setText("Volver");
        btnInventoryBack.setBorderPainted(false);
        btnInventoryBack.setContentAreaFilled(false);
        btnInventoryBack.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnInventoryBack.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnInventoryBack.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnInventoryBack.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnInventoryBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInventoryBackActionPerformed(evt);
            }
        });
        dlgAdminInventory.getContentPane().add(btnInventoryBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(1220, 605, 120, -1));

        lblInventoryTitle.setFont(new java.awt.Font("Noto Sans", 1, 28)); // NOI18N
        lblInventoryTitle.setText("Administrar Productos de inventario");
        dlgAdminInventory.getContentPane().add(lblInventoryTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 60, 530, 50));

        lblInventoryBackgroundDialog.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/555.jpg"))); // NOI18N
        dlgAdminInventory.getContentPane().add(lblInventoryBackgroundDialog, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 0, 1390, 770));

        dlgAdminOrders.setTitle("Administrar Productos");
        dlgAdminOrders.setMinimumSize(new java.awt.Dimension(1382, 744));
        dlgAdminOrders.setSize(new java.awt.Dimension(1382, 744));
        dlgAdminOrders.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                dlgAdminOrdersWindowClosing(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                dlgAdminOrdersWindowOpened(evt);
            }
        });
        dlgAdminOrders.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblOrdersGeneral.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        tblOrdersGeneral.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Fecha", "Producto", "Entra", "Sale"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        scrollPanelOrdersGTable.setViewportView(tblOrdersGeneral);
        tblOrdersGeneral.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        dlgAdminOrders.getContentPane().add(scrollPanelOrdersGTable, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 180, 740, 410));

        pnlInventoryHistoryButtons1.setOpaque(false);

        btnOrdersGDelete.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnOrdersGDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/menuCrud/iconBtnDelete.png"))); // NOI18N
        btnOrdersGDelete.setText("Eliminar");
        btnOrdersGDelete.setToolTipText("Eliminar un empleado");
        btnOrdersGDelete.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnOrdersGDelete.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnOrdersGDelete.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnOrdersGDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOrdersGDeleteActionPerformed(evt);
            }
        });

        btnInventoryHistoryList1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnInventoryHistoryList1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/menuCrud/iconBtnList.png"))); // NOI18N
        btnInventoryHistoryList1.setText("Listar Inventario");
        btnInventoryHistoryList1.setToolTipText("Listar todos los empleados en la empresa");
        btnInventoryHistoryList1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnInventoryHistoryList1.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnInventoryHistoryList1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnInventoryHistoryList1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInventoryHistoryList1ActionPerformed(evt);
            }
        });

        btnInventoryHistorySearch1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnInventoryHistorySearch1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/menuCrud/iconBtnSearch.png"))); // NOI18N
        btnInventoryHistorySearch1.setText("Consultar");
        btnInventoryHistorySearch1.setToolTipText("Buscar un empleado por número de cédula");
        btnInventoryHistorySearch1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnInventoryHistorySearch1.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnInventoryHistorySearch1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnInventoryHistorySearch1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInventoryHistorySearch1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlInventoryHistoryButtons1Layout = new javax.swing.GroupLayout(pnlInventoryHistoryButtons1);
        pnlInventoryHistoryButtons1.setLayout(pnlInventoryHistoryButtons1Layout);
        pnlInventoryHistoryButtons1Layout.setHorizontalGroup(
            pnlInventoryHistoryButtons1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlInventoryHistoryButtons1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnInventoryHistorySearch1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnOrdersGDelete)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnInventoryHistoryList1)
                .addContainerGap(208, Short.MAX_VALUE))
        );
        pnlInventoryHistoryButtons1Layout.setVerticalGroup(
            pnlInventoryHistoryButtons1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlInventoryHistoryButtons1Layout.createSequentialGroup()
                .addGroup(pnlInventoryHistoryButtons1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnOrdersGDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnInventoryHistoryList1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnInventoryHistorySearch1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 22, Short.MAX_VALUE))
        );

        dlgAdminOrders.getContentPane().add(pnlInventoryHistoryButtons1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, -1, -1));

        btnInventoryHistoryBack1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnInventoryHistoryBack1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/back.png"))); // NOI18N
        btnInventoryHistoryBack1.setText("Volver");
        btnInventoryHistoryBack1.setBorderPainted(false);
        btnInventoryHistoryBack1.setContentAreaFilled(false);
        btnInventoryHistoryBack1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnInventoryHistoryBack1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnInventoryHistoryBack1.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnInventoryHistoryBack1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnInventoryHistoryBack1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInventoryHistoryBack1ActionPerformed(evt);
            }
        });
        dlgAdminOrders.getContentPane().add(btnInventoryHistoryBack1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1220, 605, 120, -1));

        lblInventoryHistoryTitle1.setFont(new java.awt.Font("Noto Sans", 1, 28)); // NOI18N
        lblInventoryHistoryTitle1.setText("Administrar Ordenes locales");
        dlgAdminOrders.getContentPane().add(lblInventoryHistoryTitle1, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 60, 390, 50));

        lblInventoryHistoryBackgroundDialog1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/555.jpg"))); // NOI18N
        dlgAdminOrders.getContentPane().add(lblInventoryHistoryBackgroundDialog1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 0, 1390, 770));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Administrar");
        setMinimumSize(new java.awt.Dimension(1382, 744));
        setSize(new java.awt.Dimension(1382, 744));
        getContentPane().setLayout(null);

        btnAdminProducts.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnAdminProducts.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/frmAdministration/iconBtnAdminProducts.jpg"))); // NOI18N
        btnAdminProducts.setText("Administrar productos");
        btnAdminProducts.setBorderPainted(false);
        btnAdminProducts.setContentAreaFilled(false);
        btnAdminProducts.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAdminProducts.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnAdminProducts.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnAdminProducts.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnAdminProducts.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdminProductsActionPerformed(evt);
            }
        });
        getContentPane().add(btnAdminProducts);
        btnAdminProducts.setBounds(130, 370, 250, 210);

        btnCompanyDates.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnCompanyDates.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/frmAdministration/iconBtnAdminLocals.jpg"))); // NOI18N
        btnCompanyDates.setText("Administrar Locales");
        btnCompanyDates.setBorderPainted(false);
        btnCompanyDates.setContentAreaFilled(false);
        btnCompanyDates.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCompanyDates.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCompanyDates.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnCompanyDates.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnCompanyDates.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCompanyDatesActionPerformed(evt);
            }
        });
        getContentPane().add(btnCompanyDates);
        btnCompanyDates.setBounds(1060, 50, 250, 210);

        btnAdminEmployees.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnAdminEmployees.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/frmAdministration/iconBtnAdminEmployees.png"))); // NOI18N
        btnAdminEmployees.setText("Administrar empleados");
        btnAdminEmployees.setBorderPainted(false);
        btnAdminEmployees.setContentAreaFilled(false);
        btnAdminEmployees.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAdminEmployees.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnAdminEmployees.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnAdminEmployees.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnAdminEmployees.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdminEmployeesActionPerformed(evt);
            }
        });
        getContentPane().add(btnAdminEmployees);
        btnAdminEmployees.setBounds(720, 50, 250, 210);

        btnAdminPasswords.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnAdminPasswords.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/frmAdministration/iconBtnAdminPasswords.png"))); // NOI18N
        btnAdminPasswords.setText("Administrador de contraseñas");
        btnAdminPasswords.setBorderPainted(false);
        btnAdminPasswords.setContentAreaFilled(false);
        btnAdminPasswords.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAdminPasswords.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnAdminPasswords.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnAdminPasswords.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnAdminPasswords.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdminPasswordsActionPerformed(evt);
            }
        });
        getContentPane().add(btnAdminPasswords);
        btnAdminPasswords.setBounds(400, 50, 250, 210);

        btnAdminCustomers.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnAdminCustomers.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/frmAdministration/iconBtnAdminCustomers1.png"))); // NOI18N
        btnAdminCustomers.setText("Administrar Clientes");
        btnAdminCustomers.setBorderPainted(false);
        btnAdminCustomers.setContentAreaFilled(false);
        btnAdminCustomers.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAdminCustomers.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnAdminCustomers.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnAdminCustomers.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnAdminCustomers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdminCustomersActionPerformed(evt);
            }
        });
        getContentPane().add(btnAdminCustomers);
        btnAdminCustomers.setBounds(40, 50, 250, 210);

        btnAdminBack.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
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
        getContentPane().add(btnAdminBack);
        btnAdminBack.setBounds(1220, 605, 120, 110);

        btnAdminInventory.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnAdminInventory.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/frmAdministration/iconBtnAdminInventory.png"))); // NOI18N
        btnAdminInventory.setText("Inventario");
        btnAdminInventory.setBorderPainted(false);
        btnAdminInventory.setContentAreaFilled(false);
        btnAdminInventory.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAdminInventory.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnAdminInventory.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnAdminInventory.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnAdminInventory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdminInventoryActionPerformed(evt);
            }
        });
        getContentPane().add(btnAdminInventory);
        btnAdminInventory.setBounds(590, 370, 250, 210);

        btnAdminOrders.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnAdminOrders.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/frmAdministration/iconBtnAdminOrders.png"))); // NOI18N
        btnAdminOrders.setText("Administrar Ordenes");
        btnAdminOrders.setBorderPainted(false);
        btnAdminOrders.setContentAreaFilled(false);
        btnAdminOrders.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAdminOrders.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnAdminOrders.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnAdminOrders.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnAdminOrders.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdminOrdersActionPerformed(evt);
            }
        });
        getContentPane().add(btnAdminOrders);
        btnAdminOrders.setBounds(1030, 370, 250, 210);

        lblBackgroundAdmin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/555.jpg"))); // NOI18N
        getContentPane().add(lblBackgroundAdmin);
        lblBackgroundAdmin.setBounds(-6, 0, 1390, 740);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEmployeesNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEmployeesNewActionPerformed
        cleanTextboxEmployees();
    }//GEN-LAST:event_btnEmployeesNewActionPerformed

    private void btnEmployeesDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEmployeesDeleteActionPerformed
        employees = new clsDAOEmployees();
        String document = JOptionPane.showInputDialog("Por favor ingrese la cédula del empleado a eliminar");
        employees.setDocument_id(document);
        String result = "";
        result = employees.delete();
        if (result.equals("correcto")) {
            JOptionPane.showMessageDialog(dlgAdminEmployees, "El empleado ha sido elminado correctamente.");
            if (tblEmployees.isVisible()) {
                tblEmployees.setModel(employees.list());
            }
        } else {
            JOptionPane.showMessageDialog(dlgAdminEmployees, "No ha podido ser eliminado el empleado, intente nuevamente y verifique que el empleado exista.");
        }
    }//GEN-LAST:event_btnEmployeesDeleteActionPerformed

    private void btnEmployeesSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEmployeesSearchActionPerformed
        try {
            employees = new clsDAOEmployees();
            ResultSet result;
            String document = JOptionPane.showInputDialog("Por favor ingrese el número de cédula del empleado a buscar");
            employees.setDocument_id(document);
            result = employees.search();
            if (result != null) {
                employee_id = result.getString(1);
                txtEmployeesDocument.setText(result.getString(2));
                tempEmployeesDocument = result.getString(2);
                txtEmployeesName.setText(result.getString(3));
                txtEmployeesLastName.setText(result.getString(4));
                if (result.getString(5).equals("Domicilio")) {
                    cbEmployeesJob.setSelectedIndex(0);
                } else if (result.getString(5).equals("Cocina")) {
                    cbEmployeesJob.setSelectedIndex(1);
                } else if (result.getString(5).equals("Mesas")) {
                    cbEmployeesJob.setSelectedIndex(2);
                } else if (result.getString(5).equals("Administrador")) {
                    cbEmployeesJob.setSelectedIndex(3);
                }
                txtEmployeesPhone.setText(result.getString(6));
                txtEmployeesNotes.setText(result.getString(7));
                txtEmployeesAddress.setText(result.getString(9));
            } else {
                JOptionPane.showMessageDialog(dlgAdminEmployees, "El empleado no existe, por favor verifique que la cédula esté bien escrita.");
            }

        } catch (SQLException ex) {
            Logger.getLogger(frmAdministration.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_btnEmployeesSearchActionPerformed

    private void btnEmployeesInsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEmployeesInsertActionPerformed
        listTxtValidate = new LinkedList<>();
        listTxtAreaValidate = new LinkedList<>();
        listTxtValidate.add(txtEmployeesDocument);
        listTxtValidate.add(txtEmployeesName);
        listTxtValidate.add(txtEmployeesLastName);
        listTxtValidate.add(txtEmployeesAddress);
        listTxtValidate.add(txtEmployeesPhone);
        if (validateFields(listTxtValidate, listTxtAreaValidate)) {
            loadSetValuesEmployees();
            if (employees.findDuplicateEmployees(txtEmployeesDocument.getText()).equals("no_existe")) {

                if (employees.insert()) {
                    JOptionPane.showMessageDialog(dlgAdminEmployees, "Se insertó el empleado correctamente");
                    cleanTextboxEmployees();
                    if (tblEmployees.isVisible()) {
                        tblEmployees.setModel(employees.list());
                    }

                } else {
                    JOptionPane.showMessageDialog(dlgAdminEmployees, "No sé insertó el empleado");
                }
            } else {
                JOptionPane.showMessageDialog(dlgAdminEmployees, "Ya existe un empleado identificado con ese número de documento, por favor revise nuevamente.");
            }
        } else {
            JOptionPane.showMessageDialog(dlgAdminEmployees, "Por favor rellene los campos que están subrayados en rojo.");
        }
    }//GEN-LAST:event_btnEmployeesInsertActionPerformed

    private void btnAdminEmployeesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdminEmployeesActionPerformed
        dlgAdminEmployees.setVisible(true);
    }//GEN-LAST:event_btnAdminEmployeesActionPerformed


    private void btnEmployeesEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEmployeesEditActionPerformed

        String result = "";
        listTxtValidate = new LinkedList<>();
        listTxtAreaValidate = new LinkedList<>();
        listTxtValidate.add(txtEmployeesDocument);
        listTxtValidate.add(txtEmployeesName);
        listTxtValidate.add(txtEmployeesLastName);
        listTxtValidate.add(txtEmployeesAddress);
        listTxtValidate.add(txtEmployeesPhone);
        if (validateFields(listTxtValidate, listTxtAreaValidate)) {
            loadSetValuesEmployees();
            if (employees.findDuplicateEmployees(txtEmployeesDocument.getText()).equals("no_existe") || (employees.findDuplicateEmployees(txtEmployeesDocument.getText()).equals("existe") && tempEmployeesDocument.equals(employees.getDocument_id()))) {

                result = employees.edit();
                if (result.equals("correcto")) {
                    JOptionPane.showMessageDialog(dlgAdminEmployees, "El empleado ha sido modificado correctamente.");
                    if (tblEmployees.isVisible()) {
                        tblEmployees.setModel(employees.list());
                    }
                    cleanTextboxEmployees();
                } else {
                    JOptionPane.showMessageDialog(dlgAdminEmployees, "No ha podido ser modificado el empleado, intente nuevamente y verifique que el empleado exista.");
                }
            } else {
                JOptionPane.showMessageDialog(dlgAdminEmployees, "Ya existe un empleado identificado con ese número de documento, por favor revise nuevamente.");

            }
        } else {
            JOptionPane.showMessageDialog(dlgAdminEmployees, "Por favor rellene los campos que están subrayados en rojo.");
        }

    }//GEN-LAST:event_btnEmployeesEditActionPerformed

    private void btnEmployeesListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEmployeesListActionPerformed
        employees = new clsDAOEmployees();
        tblEmployees.setModel(employees.list());
        scrollPanelEmployeesTable.setVisible(true);
        tblEmployees.setVisible(true);
    }//GEN-LAST:event_btnEmployeesListActionPerformed

    private void btnProductsEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProductsEditActionPerformed

        String result = "";
        listTxtValidate = new LinkedList<>();
        listTxtAreaValidate = new LinkedList<>();
        listTxtValidate.add(txtProductsName);
        listTxtAreaValidate.add(txtProductsDescription);
        listTxtValidate.add(txtProductsPrice);
        if (validateFields(listTxtValidate, listTxtAreaValidate)) {
            loadSetValuesProducts();
            if (products.findDuplicateProducts(txtProductsName.getText()).equals("no_existe") || (products.findDuplicateProducts(txtProductsName.getText()).equals("existe") && tempProductsName.equals(products.getNamep()))) {

                result = products.edit();
                if (result.equals("correcto")) {
                    JOptionPane.showMessageDialog(dlgAdminProducts, "El producto ha sido modificado correctamente.");
                    if (tblProducts.isVisible()) {
                        tblProducts.setModel(products.list());
                    }
                    cleanTextboxProducts();
                } else {
                    JOptionPane.showMessageDialog(dlgAdminProducts, "No ha podido ser modificado el producto, intente nuevamente y verifique que el producto exista.");
                }
            } else {
                JOptionPane.showMessageDialog(dlgAdminProducts, "Ya existe un producto con ese nombre, por favor inténtolo con otro nombre");

            }
        } else {
            JOptionPane.showMessageDialog(dlgAdminEmployees, "Por favor rellene los campos que están subrayados en rojo.");
        }

    }//GEN-LAST:event_btnProductsEditActionPerformed

    private void btnProductsDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProductsDeleteActionPerformed
        products = new clsDAOProducts();
        String namep = JOptionPane.showInputDialog("Por favor ingrese el nombre del producto a eliminar");
        products.setNamep(namep);
        String result = products.delete();
        if (result.equals("correcto")) {
            JOptionPane.showMessageDialog(dlgAdminProducts, "El producto ha sido elminado correctamente.");
            if (tblProducts.isVisible()) {
                tblProducts.setModel(products.list());
            }
        } else if (result.equals("error")) {
            JOptionPane.showMessageDialog(dlgAdminProducts, "No ha podido ser eliminado el producto, intente nuevamente y verifique que el producto exista.");
        }


    }//GEN-LAST:event_btnProductsDeleteActionPerformed

    private void btnProductsInsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProductsInsertActionPerformed

        listTxtValidate = new LinkedList<>();
        listTxtAreaValidate = new LinkedList<>();
        listTxtValidate.add(txtProductsName);
        listTxtAreaValidate.add(txtProductsDescription);
        listTxtValidate.add(txtProductsPrice);
        if (validateFields(listTxtValidate, listTxtAreaValidate)) {
            loadSetValuesProducts();
            if (products.findDuplicateProducts(txtProductsName.getText()).equals("no_existe")) {

                if (products.insert()) {
                    JOptionPane.showMessageDialog(dlgAdminProducts, "Se insertó el producto correctamente");
                    if (tblProducts.isVisible()) {
                        tblProducts.setModel(products.list());
                    }
                    cleanTextboxProducts();
                } else {
                    JOptionPane.showMessageDialog(dlgAdminProducts, "No sé insertó el producto");
                }
            } else {
                JOptionPane.showMessageDialog(dlgAdminProducts, "Ya existe un producto con ese nombre, por favor inténtolo con otro nombre");
            }
        } else {
            JOptionPane.showMessageDialog(dlgAdminEmployees, "Por favor rellene los campos que están subrayados en rojo.");
        }
    }//GEN-LAST:event_btnProductsInsertActionPerformed

    private void btnProductsSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProductsSearchActionPerformed
        searchProductByName();

    }//GEN-LAST:event_btnProductsSearchActionPerformed

    public void searchProductByName() {
        try {
            products = new clsDAOProducts();
            ResultSet result;
            String namep = JOptionPane.showInputDialog("Por favor ingrese el nombre del producto a buscar");
            products.setNamep(namep);
            result = products.search();
            if (result != null) {
                product_id = result.getString(1);
                txtProductsName.setText(result.getString(2));
                tempProductsName = result.getString(2);
                txtProductsDescription.setText(result.getString(3));
                txtProductsPrice.setText(result.getString(4));
                txtProductsNotes.setText(result.getString(5));

            } else {
                JOptionPane.showMessageDialog(dlgAdminProducts, "El producto no existe, por favor verifique que el nombre del producto esté bien escrito.");
            }

        } catch (SQLException ex) {
            Logger.getLogger(frmAdministration.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    private void btnProductsNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProductsNewActionPerformed
        cleanTextboxProducts();
    }//GEN-LAST:event_btnProductsNewActionPerformed

    private void btnProductsListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProductsListActionPerformed
        products = new clsDAOProducts();
        tblProducts.setModel(products.list());
        scrollPanelProductsTable.setVisible(true);
        tblProducts.setVisible(true);


    }//GEN-LAST:event_btnProductsListActionPerformed

    private void btnAdminProductsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdminProductsActionPerformed

        dlgSelectProducts.setVisible(true);

    }//GEN-LAST:event_btnAdminProductsActionPerformed

    private void txtEmployeesDocumentKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEmployeesDocumentKeyTyped
        onlyNumbersInTextField(evt, txtEmployeesDocument, 12);
    }//GEN-LAST:event_txtEmployeesDocumentKeyTyped

    private void txtCustomersDocumentKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCustomersDocumentKeyTyped
        onlyNumbersInTextField(evt, txtCustomersDocument, 12);
    }//GEN-LAST:event_txtCustomersDocumentKeyTyped

    private void btnCustomersEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCustomersEditActionPerformed
        listTxtValidate = new LinkedList<>();
        listTxtAreaValidate = new LinkedList<>();
        listTxtValidate.add(txtCustomersName);
        listTxtValidate.add(txtCustomersLastName);
        listTxtValidate.add(txtCustomerssAddress);
        // listTxtValidate.add(cbo);
        listTxtValidate.add(txtCustomersPhone);
        if (validateFields(listTxtValidate, listTxtAreaValidate) && !cboCustomersNeighborhood.getEditor().toString().isEmpty()) {
            cboCustomersNeighborhood.setBorder(borderDefault);
            loadSetValuesCustomers();
            if (customers.findDuplicateCustomers(txtCustomersPhone.getText()).equals("no_existe") || (customers.findDuplicateCustomers(txtCustomersPhone.getText()).equals("existe") && tempCustomersPhone.equals(customers.getPhone()))) {
                String result = "";
                result = customers.edit();
                if (result.equals("correcto")) {
                    JOptionPane.showMessageDialog(dlgAdminCustomers, "El cliente ha sido modificado correctamente.");
                    if (tblCustomers.isVisible()) {
                        tblCustomers.setModel(customers.list());
                    }
                    cleanTextboxCustomers();
                } else {
                    JOptionPane.showMessageDialog(dlgAdminCustomers, "No ha podido ser modificado el producto, intente nuevamente y verifique que el producto exista.");
                }
            } else {
                JOptionPane.showMessageDialog(dlgAdminEmployees, "El número de teléfono ya existe en esa base de datos, por favor regístrelo con otro número.");
            }
        } else {
            if (cboCustomersNeighborhood.getEditor().getItem() == null) {
                cboCustomersNeighborhood.setBorder(borderEmptyField);
            } else if (cboCustomersNeighborhood.getBorder().equals(borderEmptyField)) {
                cboCustomersNeighborhood.setBorder(borderDefault);
            }
            JOptionPane.showMessageDialog(dlgAdminEmployees, "Por favor rellene los campos que están subrayados en rojo.");

        }
    }//GEN-LAST:event_btnCustomersEditActionPerformed

    private void btnCustomersDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCustomersDeleteActionPerformed
        customers = new clsDAOCustomers();
        String search = JOptionPane.showInputDialog("Por favor ingrese el número telefónico  de la persona a buscar");
        customers.setSearch(search);
        String result = customers.delete();
        if (result.equals("correcto")) {
            JOptionPane.showMessageDialog(dlgAdminCustomers, "El cliente ha sido elminado correctamente.");
            if (tblCustomers.isVisible()) {
                tblCustomers.setModel(customers.list());
            }
        } else if (result.equals("error")) {
            JOptionPane.showMessageDialog(dlgAdminCustomers, "No ha podido ser eliminado el cliente, intente nuevamente y verifique que el cliente exista.");
        }

    }//GEN-LAST:event_btnCustomersDeleteActionPerformed

    private void btnCustomersInsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCustomersInsertActionPerformed
        listTxtValidate = new LinkedList<>();
        listTxtAreaValidate = new LinkedList<>();
        listTxtValidate.add(txtCustomersName);
        listTxtValidate.add(txtCustomersLastName);
        listTxtValidate.add(txtCustomerssAddress);
        listTxtValidate.add(txtCustomersPhone);
        if (validateFields(listTxtValidate, listTxtAreaValidate) && cboCustomersNeighborhood.getEditor().getItem() != null) {
            cboCustomersNeighborhood.setBorder(borderDefault);
            if (customers.findDuplicateCustomers(txtCustomersPhone.getText()).equals("no_existe")) {
                loadSetValuesCustomers();
                if (customers.insert()) {
                    JOptionPane.showMessageDialog(dlgAdminCustomers, "Se insertó el cliente correctamente");
                    if (tblCustomers.isVisible()) {
                        tblCustomers.setModel(customers.list());
                    }
                    cleanTextboxCustomers();
                } else {
                    JOptionPane.showMessageDialog(dlgAdminCustomers, "No sé insertó el cliente");
                }
            } else {
                JOptionPane.showMessageDialog(dlgAdminEmployees, "El número de teléfono ya existe en esa base de datos, por favor regístrelo con otro número.");
            }
        } else {
            if (cboCustomersNeighborhood.getEditor().getItem() == null) {
                cboCustomersNeighborhood.setBorder(borderEmptyField);
            } else if (cboCustomersNeighborhood.getBorder().equals(borderEmptyField)) {
                cboCustomersNeighborhood.setBorder(borderDefault);
            }
            JOptionPane.showMessageDialog(dlgAdminEmployees, "Por favor rellene los campos que están subrayados en rojo.");

        }

    }//GEN-LAST:event_btnCustomersInsertActionPerformed

    private void btnCustomersSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCustomersSearchActionPerformed
        searchCustomersByPhoneOrName();
    }//GEN-LAST:event_btnCustomersSearchActionPerformed

    public void searchCustomersByPhoneOrName() {
        try {
            customers = new clsDAOCustomers();
            ResultSet result;
            String search = JOptionPane.showInputDialog("Por favor ingrese el número telefónico de la persona a buscar");
            customers.setSearch(search);
            result = customers.search();
            if (result != null) {
                customers_id = result.getString(1);
                txtCustomersDocument.setText(result.getString(2));
                txtCustomersName.setText(result.getString(3));
                txtCustomersLastName.setText(result.getString(4));
                txtCustomerssAddress.setText(result.getString(5));
                cboCustomersNeighborhood.setSelectedItem(result.getString(6));
                txtCustomersPhone.setText(result.getString(9));
                tempCustomersPhone = result.getString(9);
                txtCustomersNotes.setText(result.getString(10));

            } else {
                JOptionPane.showMessageDialog(dlgAdminCustomers, "El cliente no existe, por favor verifique que el nombre del cliente o el número esté bien escrito.");
            }

        } catch (SQLException ex) {
            Logger.getLogger(frmAdministration.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void btnCustomersNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCustomersNewActionPerformed
        cleanTextboxCustomers();

    }//GEN-LAST:event_btnCustomersNewActionPerformed

    private void btnCustomersListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCustomersListActionPerformed
        customers = new clsDAOCustomers();
        tblCustomers.setModel(customers.list());
        scrollPanelCustomersTable.setVisible(true);
        tblCustomers.setVisible(true);

    }//GEN-LAST:event_btnCustomersListActionPerformed

    private void btnAdminCustomersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdminCustomersActionPerformed

        dlgAdminCustomers.setVisible(true);
    }//GEN-LAST:event_btnAdminCustomersActionPerformed

    private void dlgAdminEmployeesWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_dlgAdminEmployeesWindowClosing
        this.setVisible(true);

    }//GEN-LAST:event_dlgAdminEmployeesWindowClosing

    private void dlgAdminProductsWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_dlgAdminProductsWindowClosing
        this.setVisible(true);
    }//GEN-LAST:event_dlgAdminProductsWindowClosing

    private void dlgAdminCustomersWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_dlgAdminCustomersWindowClosing
        this.setVisible(true);
    }//GEN-LAST:event_dlgAdminCustomersWindowClosing

    private void txtLocalsAddressKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtLocalsAddressKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtLocalsAddressKeyTyped

    private void btnLocalsEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLocalsEditActionPerformed
        listTxtValidate = new LinkedList<>();
        listTxtAreaValidate = new LinkedList<>();
        listTxtValidate.add(txtLocalsNit);
        listTxtValidate.add(txtLocalsNameL);
        listTxtValidate.add(txtLocalsAddress);
        listTxtValidate.add(txtLocalsNeighborhood);
        if (validateFields(listTxtValidate, listTxtAreaValidate)) {
            loadSetValuesLocals();
            String result = "";
            result = local.edit();
            if (result.equals("correcto")) {
                JOptionPane.showMessageDialog(dlgAdminLocal, "El local ha sido modificado correctamente.");
                if (tblLocals.isVisible()) {
                    tblLocals.setModel(local.list());
                }
                cleanTextboxLocals();
            } else {
                JOptionPane.showMessageDialog(dlgAdminLocal, "No ha podido ser modificado el local, intente nuevamente y verifique que el local exista.");
            }
        } else {
            JOptionPane.showMessageDialog(dlgAdminEmployees, "Por favor rellene los campos que están subrayados en rojo.");
        }
    }//GEN-LAST:event_btnLocalsEditActionPerformed

    private void btnLocalsDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLocalsDeleteActionPerformed
        local = new clsDAOCompany();
        String search = JOptionPane.showInputDialog("Por favor ingrese el nombre o el barrio del local a buscar");
        local.setSearch(search);
        String result = local.delete();
        if (result.equals("correcto")) {
            JOptionPane.showMessageDialog(dlgAdminLocal, "El local ha sido elminado correctamente.");
            if (tblLocals.isVisible()) {
                tblLocals.setModel(local.list());
            }
        } else if (result.equals("error")) {
            JOptionPane.showMessageDialog(dlgAdminLocal, "No ha podido ser eliminado el local, intente nuevamente y verifique que el local exista.");
        }


    }//GEN-LAST:event_btnLocalsDeleteActionPerformed

    private void btnLocalsInsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLocalsInsertActionPerformed
        listTxtValidate = new LinkedList<>();
        listTxtAreaValidate = new LinkedList<>();
        listTxtValidate.add(txtLocalsNit);
        listTxtValidate.add(txtLocalsNameL);
        listTxtValidate.add(txtLocalsAddress);
        listTxtValidate.add(txtLocalsNeighborhood);
        if (validateFields(listTxtValidate, listTxtAreaValidate)) {
            loadSetValuesLocals();
            if (local.insert()) {
                JOptionPane.showMessageDialog(dlgAdminLocal, "Se insertó el Local correctamente");
                if (tblLocals.isVisible()) {
                    tblLocals.setModel(local.list());
                }
                cleanTextboxLocals();
            } else {
                JOptionPane.showMessageDialog(dlgAdminLocal, "No sé insertó el local");
            }
        } else {
            JOptionPane.showMessageDialog(dlgAdminEmployees, "Por favor rellene los campos que están subrayados en rojo.");
        }
    }//GEN-LAST:event_btnLocalsInsertActionPerformed

    private void btnLocalsSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLocalsSearchActionPerformed
        try {
            local = new clsDAOCompany();
            ResultSet result;
            String search = JOptionPane.showInputDialog("Por favor ingrese el nombre o el barrio del local a buscar");
            local.setSearch(search);
            result = local.search();
            if (result != null) {
                local_id = result.getString(1);
                txtLocalsNit.setText(result.getString(2));
                txtLocalsNameL.setText(result.getString(3));
                txtLocalsAddress.setText(result.getString(4));
                txtLocalsNeighborhood.setText(result.getString(5));
            } else {
                JOptionPane.showMessageDialog(dlgAdminLocal, "El local no existe, por favor verifique que el nombre o barrio del local esté bien escrito.");
            }

        } catch (SQLException ex) {
            Logger.getLogger(frmAdministration.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_btnLocalsSearchActionPerformed

    private void btnLocalsNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLocalsNewActionPerformed
        cleanTextboxLocals();

    }//GEN-LAST:event_btnLocalsNewActionPerformed

    private void btnLocalsListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLocalsListActionPerformed
        local = new clsDAOCompany();
        tblLocals.setModel(local.list());
        scrollPanelLocalsTable.setVisible(true);
        tblLocals.setVisible(true);
    }//GEN-LAST:event_btnLocalsListActionPerformed

    private void dlgAdminLocalWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_dlgAdminLocalWindowClosing
        this.setVisible(true);

    }//GEN-LAST:event_dlgAdminLocalWindowClosing

    private void txtProductsPriceKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtProductsPriceKeyTyped
        onlyNumbersInTextField(evt, txtProductsPrice, 7);
    }//GEN-LAST:event_txtProductsPriceKeyTyped

    private void txtLocalsNeighborhoodKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtLocalsNeighborhoodKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtLocalsNeighborhoodKeyTyped

    private void btnCompanyDatesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCompanyDatesActionPerformed
        dlgAdminLocal.setVisible(true);
    }//GEN-LAST:event_btnCompanyDatesActionPerformed

    private void txtLocalsNitKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtLocalsNitKeyTyped
        onlyNumbersInTextField(evt, txtLocalsNit, 12);
    }//GEN-LAST:event_txtLocalsNitKeyTyped

    private void txtEmployeesPhoneKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEmployeesPhoneKeyTyped
        onlyNumbersInTextField(evt, txtEmployeesPhone, 10);
    }//GEN-LAST:event_txtEmployeesPhoneKeyTyped

    private void txtCustomersPhoneKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCustomersPhoneKeyTyped
        onlyNumbersInTextField(evt, txtCustomersPhone, 10);
    }//GEN-LAST:event_txtCustomersPhoneKeyTyped

    private void btnCustomersBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCustomersBackActionPerformed
        this.setVisible(true);
        scrollPanelCustomersTable.setVisible(false);
        tblCustomers.setVisible(false);
        dlgAdminCustomers.setVisible(false);
        cleanTextboxCustomers();
    }//GEN-LAST:event_btnCustomersBackActionPerformed

    private void btnProductsBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProductsBackActionPerformed
        this.setVisible(true);
        scrollPanelProductsTable.setVisible(false);
        tblProducts.setVisible(false);
        dlgAdminProducts.setVisible(false);
        cleanTextboxProducts();
    }//GEN-LAST:event_btnProductsBackActionPerformed

    private void btnEmployeesBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEmployeesBackActionPerformed
        this.setVisible(true);
        scrollPanelEmployeesTable.setVisible(false);
        tblEmployees.setVisible(false);
        dlgAdminEmployees.setVisible(false);
        cleanTextboxEmployees();
    }//GEN-LAST:event_btnEmployeesBackActionPerformed

    private void btnLocalsBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLocalsBackActionPerformed
        this.setVisible(true);
        scrollPanelLocalsTable.setVisible(false);
        tblLocals.setVisible(false);
        dlgAdminLocal.setVisible(false);
        cleanTextboxLocals();
    }//GEN-LAST:event_btnLocalsBackActionPerformed

    private void btnAdminBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdminBackActionPerformed
        this.setVisible(false);

    }//GEN-LAST:event_btnAdminBackActionPerformed

    private void btnAdditionalProductsEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdditionalProductsEditActionPerformed
        listTxtValidate = new LinkedList<>();
        listTxtAreaValidate = new LinkedList<>();
        listTxtValidate.add(txtAdditionalProductsName);
        listTxtValidate.add(txtAdditionalProductsPrice);
        listTxtAreaValidate.add(txtAdditionalProductsDescription);
        if (validateFields(listTxtValidate, listTxtAreaValidate)) {
            loadSetValuesAdditionalProducts();
            String result = "";
            if (additionalProducts.findDuplicateAdditionalProducts(txtAdditionalProductsName.getText()).equals("no_existe") || (additionalProducts.findDuplicateAdditionalProducts(txtAdditionalProductsName.getText()).equals("existe") && tempAadditionalProduct.equals(additionalProducts.getNamep()))) {

                result = additionalProducts.edit();
                if (result.equals("correcto")) {
                    JOptionPane.showMessageDialog(dlgAdminAdditionalProducts, "El producto ha sido modificado correctamente.");
                    if (tblAdditionalProducts.isVisible()) {
                        tblAdditionalProducts.setModel(additionalProducts.list());
                    }
                    cleanTextboxAdditionalProducts();
                } else {
                    JOptionPane.showMessageDialog(dlgAdminAdditionalProducts, "No ha podido ser modificado el producto, intente nuevamente y verifique que el producto exista.");
                }
            } else {
                JOptionPane.showMessageDialog(dlgAdminAdditionalProducts, "Ya existe un producto con ese nombre, por favor intente con otro nombre.");
            }
        } else {
            JOptionPane.showMessageDialog(dlgAdminEmployees, "Por favor rellene los campos que están subrayados en rojo.");
        }
    }//GEN-LAST:event_btnAdditionalProductsEditActionPerformed

    private void btnAdditionalProductsDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdditionalProductsDeleteActionPerformed
        additionalProducts = new clsDAOAdditionalProducts();
        String namep = JOptionPane.showInputDialog("Por favor ingrese el nombre del producto adicional a eliminar");
        additionalProducts.setNamep(namep);
        String result = additionalProducts.delete();
        if (result.equals("correcto")) {
            JOptionPane.showMessageDialog(dlgAdminAdditionalProducts, "El producto adicional ha sido elminado correctamente.");
            if (tblAdditionalProducts.isVisible()) {
                tblAdditionalProducts.setModel(additionalProducts.list());
            }
        } else if (result.equals("error")) {
            JOptionPane.showMessageDialog(dlgAdminAdditionalProducts, "No ha podido ser eliminado el producto, intente nuevamente y verifique que el producto exista.");
        }

    }//GEN-LAST:event_btnAdditionalProductsDeleteActionPerformed

    private void btnAdditionalProductsInsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdditionalProductsInsertActionPerformed
        listTxtValidate = new LinkedList<>();
        listTxtAreaValidate = new LinkedList<>();
        listTxtValidate.add(txtAdditionalProductsName);
        listTxtValidate.add(txtAdditionalProductsPrice);
        listTxtAreaValidate.add(txtAdditionalProductsDescription);
        if (validateFields(listTxtValidate, listTxtAreaValidate)) {
            loadSetValuesAdditionalProducts();
            if (additionalProducts.findDuplicateAdditionalProducts(txtAdditionalProductsName.getText()).equals("no_existe")) {

                if (additionalProducts.insert()) {
                    JOptionPane.showMessageDialog(dlgAdminAdditionalProducts, "Se insertó el producto adicional correctamente");
                    if (tblAdditionalProducts.isVisible()) {
                        tblAdditionalProducts.setModel(additionalProducts.list());
                    }
                    cleanTextboxAdditionalProducts();
                } else {
                    JOptionPane.showMessageDialog(dlgAdminAdditionalProducts, "No sé insertó el producto adicional");
                }
            } else {
                JOptionPane.showMessageDialog(dlgAdminAdditionalProducts, "Ya existe un producto con ese nombre, por favor intente con otro nombre.");
            }
        } else {
            JOptionPane.showMessageDialog(dlgAdminEmployees, "Por favor rellene los campos que están subrayados en rojo.");

        }
    }//GEN-LAST:event_btnAdditionalProductsInsertActionPerformed

    private void btnAdditionalProductsSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdditionalProductsSearchActionPerformed
        try {
            additionalProducts = new clsDAOAdditionalProducts();
            ResultSet result;
            String namep = JOptionPane.showInputDialog("Por favor ingrese el nombre del producto adicional a buscar");
            additionalProducts.setNamep(namep);
            result = additionalProducts.search();
            if (result != null) {
                additional_product_id = result.getString(1);
                txtAdditionalProductsName.setText(result.getString(2));
                tempAadditionalProduct = result.getString(2);
                txtAdditionalProductsDescription.setText(result.getString(3));
                txtAdditionalProductsPrice.setText(result.getString(4));
                txtAdditionalProductsNotes.setText(result.getString(5));

            } else {
                JOptionPane.showMessageDialog(dlgAdminAdditionalProducts, "El producto no existe, por favor verifique que el nombre del producto esté bien escrito.");
            }

        } catch (SQLException ex) {
            Logger.getLogger(frmAdministration.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnAdditionalProductsSearchActionPerformed

    private void btnAdditionalProductsNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdditionalProductsNewActionPerformed
        cleanTextboxAdditionalProducts();
    }//GEN-LAST:event_btnAdditionalProductsNewActionPerformed

    private void btnAdditionalProductsListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdditionalProductsListActionPerformed
        additionalProducts = new clsDAOAdditionalProducts();
        tblAdditionalProducts.setModel(additionalProducts.list());
        scrollPanelAdditionalProductsTable.setVisible(true);
        tblAdditionalProducts.setVisible(true);
    }//GEN-LAST:event_btnAdditionalProductsListActionPerformed

    private void txtAdditionalProductsPriceKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAdditionalProductsPriceKeyTyped
        onlyNumbersInTextField(evt, txtAdditionalProductsPrice, 7);
    }//GEN-LAST:event_txtAdditionalProductsPriceKeyTyped

    private void btnAdditionalProductsBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdditionalProductsBackActionPerformed
        this.setVisible(true);
        scrollPanelAdditionalProductsTable.setVisible(false);
        tblAdditionalProducts.setVisible(false);
        dlgAdminAdditionalProducts.setVisible(false);
        cleanTextboxAdditionalProducts();
    }//GEN-LAST:event_btnAdditionalProductsBackActionPerformed

    private void dlgAdminAdditionalProductsWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_dlgAdminAdditionalProductsWindowClosing
        // TODO add your handling code here:
    }//GEN-LAST:event_dlgAdminAdditionalProductsWindowClosing

    private void btnSelectAdminProductsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelectAdminProductsActionPerformed
        dlgSelectProducts.setVisible(false);
        dlgAdminProducts.setVisible(true);


    }//GEN-LAST:event_btnSelectAdminProductsActionPerformed

    private void btnSelectAdminAdditionsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelectAdminAdditionsActionPerformed
        dlgSelectProducts.setVisible(false);
        dlgAdminAdditionalProducts.setVisible(true);
    }//GEN-LAST:event_btnSelectAdminAdditionsActionPerformed

    private void btnAdminPasswordsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdminPasswordsActionPerformed
        dlgAdminUsers.setVisible(true);
    }//GEN-LAST:event_btnAdminPasswordsActionPerformed

    private void btnUsersEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUsersEditActionPerformed
        listTxtValidate = new LinkedList<>();
        listTxtAreaValidate = new LinkedList<>();
        listTxtValidate.add(txtUsersNameUser);
        listTxtValidate.add(txtUsersPassword);
        listTxtValidate.add(txtUsersRepeatPassword);
        if (validateFields(listTxtValidate, listTxtAreaValidate)) {
            loadSetValuesUsers();
            String result = "";
            if (users.getPasswordu().equals(users.getRepeatPassword())) {
                if (users.findDuplicateUsers(txtUsersNameUser.getText()).equals("no_existe") || (users.findDuplicateUsers(txtUsersNameUser.getText()).equals("existe") && tempUserName.equals(users.getUser()))) {

                    result = users.edit();
                    if (result.equals("correcto")) {
                        JOptionPane.showMessageDialog(dlgAdminUsers, "El producto ha sido modificado correctamente.");
                        if (tblUsers.isVisible()) {
                            tblUsers.setModel(users.list());
                        }
                        cleanTextboxUsers();
                    } else {
                        JOptionPane.showMessageDialog(dlgAdminUsers, "No ha podido ser modificado el producto, intente nuevamente y verifique que el producto exista.");
                    }
                } else {
                    JOptionPane.showMessageDialog(dlgAdminUsers, "Ya existe un usuario con ese nombre, por favor cambie el nombre de usuario.");

                }
            } else {
                JOptionPane.showMessageDialog(dlgAdminUsers, "Las contraseñas no coinciden, por favor verifíquelas.");
            }
        } else {
            JOptionPane.showMessageDialog(dlgAdminEmployees, "Por favor rellene los campos que están subrayados en rojo.");
        }

    }//GEN-LAST:event_btnUsersEditActionPerformed

    private void btnUsersDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUsersDeleteActionPerformed
        users = new clsDAOUsers();
        String namep = JOptionPane.showInputDialog("Por favor ingrese el nombre del usuario a eliminar");
        users.setSearch(namep);
        String result = users.delete();
        if (result.equals("correcto")) {
            JOptionPane.showMessageDialog(dlgAdminUsers, "El Usuario ha sido elminado correctamente.");
            if (tblUsers.isVisible()) {
                tblUsers.setModel(users.list());
            }
        } else if (result.equals("error")) {
            JOptionPane.showMessageDialog(dlgAdminUsers, "No ha podido ser eliminado el usuario, intente nuevamente y verifique que el usuario exista.");
        }
    }//GEN-LAST:event_btnUsersDeleteActionPerformed

    private void btnUsersInsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUsersInsertActionPerformed
        listTxtValidate = new LinkedList<>();
        listTxtAreaValidate = new LinkedList<>();
        listTxtValidate.add(txtUsersNameUser);
        listTxtValidate.add(txtUsersPassword);
        listTxtValidate.add(txtUsersRepeatPassword);
        if (validateFields(listTxtValidate, listTxtAreaValidate)) {
            loadSetValuesUsers();
            if (users.getPasswordu().equals(users.getRepeatPassword())) {
                if (users.findDuplicateUsers(txtUsersNameUser.getText()).equals("no_existe")) {
                    if (users.insert()) {
                        JOptionPane.showMessageDialog(dlgAdminUsers, "Se insertó el usuario correctamente");
                        if (tblUsers.isVisible()) {
                            tblUsers.setModel(users.list());
                        }
                        cleanTextboxUsers();
                    } else {
                        JOptionPane.showMessageDialog(dlgAdminUsers, "No sé insertó el usuario");
                    }
                } else {
                    JOptionPane.showMessageDialog(dlgAdminUsers, "Ya existe un usuario con ese nombre, por favor cambie el nombre de usuario.");
                }
            } else {
                JOptionPane.showMessageDialog(dlgAdminUsers, "Las contraseñas no coinciden, por favor verifíquelas.");
            }
        } else {
            JOptionPane.showMessageDialog(dlgAdminEmployees, "Por favor rellene los campos que están subrayados en rojo.");

        }
    }//GEN-LAST:event_btnUsersInsertActionPerformed

    private void btnUsersSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUsersSearchActionPerformed
        try {
            users = new clsDAOUsers();
            ResultSet result;
            String search = JOptionPane.showInputDialog("Por favor ingrese el nombre de usuario a buscar");
            users.setSearch(search);
            result = users.search();
            if (result != null) {
                usersname = result.getString(1);
                tempUserName = result.getString(1);
                txtUsersNameUser.setText(usersname);
                txtUsersNameUser.setEnabled(false);
                txtUsersPassword.setText(result.getString(2));
                txtUsersRepeatPassword.setText(result.getString(2));
                txtUsersNotes.setText(result.getString(3));
                if (result.getString(6).equals("0")) {
                    cboUsersIsAdmin.setSelectedIndex(1);
                } else {
                    cboUsersIsAdmin.setSelectedIndex(0);
                }

            } else {
                JOptionPane.showMessageDialog(dlgAdminUsers, "El usuario no existe, por favor verifique que el nombre de usuario esté bien escrito.");
            }

        } catch (SQLException ex) {
            Logger.getLogger(frmAdministration.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnUsersSearchActionPerformed

    private void btnUersNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUersNewActionPerformed
        cleanTextboxUsers();
    }//GEN-LAST:event_btnUersNewActionPerformed

    private void btnUsersListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUsersListActionPerformed
        users = new clsDAOUsers();
        tblUsers.setModel(users.list());
        scrollPanelUsersTable.setVisible(true);
        tblUsers.setVisible(true);

    }//GEN-LAST:event_btnUsersListActionPerformed

    private void btnUsersBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUsersBackActionPerformed
        this.setVisible(true);
        scrollPanelUsersTable.setVisible(false);
        tblUsers.setVisible(false);
        dlgAdminUsers.setVisible(false);
        cleanTextboxUsers();
    }//GEN-LAST:event_btnUsersBackActionPerformed

    private void dlgAdminUsersWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_dlgAdminUsersWindowClosing
        // TODO add your handling code here:
    }//GEN-LAST:event_dlgAdminUsersWindowClosing

    private void dlgAdminCustomersWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_dlgAdminCustomersWindowOpened
        customers = new clsDAOCustomers();
        customers.loadCboNeighborhood(cboCustomersNeighborhood);
    }//GEN-LAST:event_dlgAdminCustomersWindowOpened

    private void btnAdminInventoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdminInventoryActionPerformed
        dlgSelectInventory.setVisible(true);

    }//GEN-LAST:event_btnAdminInventoryActionPerformed

    private void btnAdminOrdersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdminOrdersActionPerformed
        dlgAdminOrders.setVisible(true);
    }//GEN-LAST:event_btnAdminOrdersActionPerformed

    private void btnInventoryHistoryEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInventoryHistoryEditActionPerformed
        listTxtValidate = new LinkedList<>();
        listTxtAreaValidate = new LinkedList<>();
        listTxtValidate.add(txtInventoryHistoryAmount);
        if (validateFields(listTxtValidate, listTxtAreaValidate)) {
            loadSetValuesInventoryHistory();
            String result = "";
            result = inventoryHistory.edit();
            if (result.equals("correcto")) {
                inventory = new clsDAOInventory();
                String inventory_id2 = inventory.searchInventoryIdFromProductName(inventoryHistory.getNameProduct());
                inventory.updateTotalAmount(inventory_id2);
                JOptionPane.showMessageDialog(dlgAdminInventoryHistory, "El producto ha sido modificado correctamente.");
                if (tblInventoryHistory.isVisible()) {
                    tblInventoryHistory.setModel(inventoryHistory.list());
                }
                txtInventoryHistoryAmount.setText("");
            } else {
                JOptionPane.showMessageDialog(dlgAdminInventoryHistory, "No ha podido ser modificado el producto, intente nuevamente y verifique que el producto exista.");
            }
        } else {
            JOptionPane.showMessageDialog(dlgAdminInventoryHistory, "Por favor rellene los campos que están subrayados en rojo.");
        }


    }//GEN-LAST:event_btnInventoryHistoryEditActionPerformed

    private void btnInventoryHistoryDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInventoryHistoryDeleteActionPerformed
        inventoryHistory = new clsDAOInventoryHistory();
        String namep = JOptionPane.showInputDialog("Por favor ingrese el ID de inventario del producto a eliminar");
        inventoryHistory.setSearch(namep);
        String result = inventoryHistory.delete();
        if (result.equals("correcto")) {
            JOptionPane.showMessageDialog(dlgAdminInventoryHistory, "El producto ha sido elminado correctamente.");
            if (tblInventoryHistory.isVisible()) {
                tblInventoryHistory.setModel(inventoryHistory.list());
            }
        } else if (result.equals("error")) {
            JOptionPane.showMessageDialog(dlgAdminInventoryHistory, "No ha podido ser eliminado el producto, intente nuevamente y verifique que el producto exista.");
        }

    }//GEN-LAST:event_btnInventoryHistoryDeleteActionPerformed

    private void btnInventoryHistoryInsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInventoryHistoryInsertActionPerformed
        listTxtValidate = new LinkedList<>();
        listTxtAreaValidate = new LinkedList<>();
        listTxtValidate.add(txtInventoryHistoryAmount);
        if (validateFields(listTxtValidate, listTxtAreaValidate)) {
            loadSetValuesInventoryHistory();

            if (inventoryHistory.insert()) {
                inventory = new clsDAOInventory();
                String inventory_id2 = inventory.searchInventoryIdFromProductName(inventoryHistory.getNameProduct());
                inventory.updateTotalAmount(inventory_id2);
                JOptionPane.showMessageDialog(dlgAdminInventoryHistory, "Se hicieron los cambios en el inventario respectivos");

                if (tblInventoryHistory.isVisible()) {
                    tblInventoryHistory.setModel(inventoryHistory.list());
                }
                txtInventoryHistoryAmount.setText("");
            } else {
                JOptionPane.showMessageDialog(dlgAdminInventoryHistory, "No sé hicieron cambios en el inventario");
            }

        } else {
            JOptionPane.showMessageDialog(dlgAdminInventoryHistory, "Por favor rellene los campos que están subrayados en rojo.");

        }


    }//GEN-LAST:event_btnInventoryHistoryInsertActionPerformed

    private void btnInventoryHistoryListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInventoryHistoryListActionPerformed
        inventoryHistory = new clsDAOInventoryHistory();
        tblInventoryHistory.setModel(inventoryHistory.list());
        scrollPanelInventoryHistoryTable.setVisible(true);
        tblInventoryHistory.setVisible(true);


    }//GEN-LAST:event_btnInventoryHistoryListActionPerformed

    private void btnInventoryHistoryBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInventoryHistoryBackActionPerformed
        this.setVisible(true);
        scrollPanelInventoryHistoryTable.setVisible(false);
        tblInventoryHistory.setVisible(false);
        dlgAdminInventoryHistory.setVisible(false);
        txtInventoryHistoryAmount.setText("");
    }//GEN-LAST:event_btnInventoryHistoryBackActionPerformed

    private void dlgAdminInventoryHistoryWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_dlgAdminInventoryHistoryWindowClosing
        // TODO add your handling code here:
    }//GEN-LAST:event_dlgAdminInventoryHistoryWindowClosing

    private void btnSelectInventoryHistoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelectInventoryHistoryActionPerformed
        inventoryHistory = new clsDAOInventoryHistory();
        ArrayList<String> productsInv = inventoryHistory.loadCboProductsPerName();
        cboInventoryHistoryProduct.removeAllItems();
        for (int i = 0; i < productsInv.size(); i++) {
            cboInventoryHistoryProduct.addItem(productsInv.get(i));
        }
        dlgSelectInventory.setVisible(false);
        dlgAdminInventoryHistory.setVisible(true);
    }//GEN-LAST:event_btnSelectInventoryHistoryActionPerformed

    private void btnSelectInventory1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelectInventory1ActionPerformed
        dlgSelectInventory.setVisible(false);
        dlgAdminInventory.setVisible(true);
    }//GEN-LAST:event_btnSelectInventory1ActionPerformed

    private void btnInventoryEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInventoryEditActionPerformed
        listTxtValidate = new LinkedList<>();
        listTxtAreaValidate = new LinkedList<>();
        listTxtValidate.add(txtInventoryProduct);
        if (validateFields(listTxtValidate, listTxtAreaValidate)) {
            loadSetValuesInventory();
            String result = "";
            if (inventory.findDuplicateProductsInventory(txtInventoryProduct.getText()).equals("no_existe") || (inventory.findDuplicateProductsInventory(txtInventoryProduct.getText()).equals("existe") && tempInventoryProduct.equals(inventory.getNameProduct()))) {

                result = inventory.edit();
                if (result.equals("correcto")) {
                    JOptionPane.showMessageDialog(dlgAdminInventory, "El producto ha sido modificado correctamente.");
                    if (tblInventory.isVisible()) {
                        tblInventory.setModel(inventory.list());
                    }
                    cleanTextboxInventory();
                } else {
                    JOptionPane.showMessageDialog(dlgAdminInventory, "No ha podido ser modificado el producto, intente nuevamente y verifique que el producto exista.");
                }
            } else {
                JOptionPane.showMessageDialog(dlgAdminInventory, "Ya existe un producto con ese nombre por favor intente con otro nombre para ese producto.");

            }
        } else {
            JOptionPane.showMessageDialog(dlgAdminInventory, "Por favor rellene los campos que están subrayados en rojo.");
        }


    }//GEN-LAST:event_btnInventoryEditActionPerformed

    private void btnInventoryDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInventoryDeleteActionPerformed

        inventory = new clsDAOInventory();
        String namep = JOptionPane.showInputDialog("Por favor ingrese el nombre del producto a eliminar");
        inventory.setSearch(namep);
        String result = inventory.delete();
        if (result.equals("correcto")) {
            JOptionPane.showMessageDialog(dlgAdminInventory, "El producto ha sido elminado correctamente.");
            if (tblInventory.isVisible()) {
                tblInventory.setModel(inventory.list());
            }
        } else if (result.equals("error")) {
            JOptionPane.showMessageDialog(dlgAdminInventory, "No ha podido ser eliminado el producto, intente nuevamente y verifique que el producto exista.");
        }


    }//GEN-LAST:event_btnInventoryDeleteActionPerformed

    private void btnInventoryInsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInventoryInsertActionPerformed
        listTxtValidate = new LinkedList<>();
        listTxtAreaValidate = new LinkedList<>();
        listTxtValidate.add(txtInventoryProduct);
        if (validateFields(listTxtValidate, listTxtAreaValidate)) {
            if (inventory.findDuplicateProductsInventory(txtInventoryProduct.getText()).equals("no_existe")) {

                loadSetValuesInventory();
                if (inventory.insert()) {
                    JOptionPane.showMessageDialog(dlgAdminInventory, "Se insertó el producto correctamente");
                    if (tblInventory.isVisible()) {
                        tblInventory.setModel(inventory.list());
                    }
                    cleanTextboxInventory();
                } else {
                    JOptionPane.showMessageDialog(dlgAdminInventory, "No sé insertó el producto");
                }
            } else {
                JOptionPane.showMessageDialog(dlgAdminInventory, "El producto ya existe, por favor inserte el producto para inventario con otro nombre.");

            }
        } else {
            JOptionPane.showMessageDialog(dlgAdminInventory, "Por favor rellene los campos que están subrayados en rojo.");

        }


    }//GEN-LAST:event_btnInventoryInsertActionPerformed

    private void btnInventorySearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInventorySearchActionPerformed
        try {
            inventory = new clsDAOInventory();
            ResultSet result;
            String search = JOptionPane.showInputDialog("Por favor ingrese el nombre del producto a buscar");
            inventory.setSearch(search);
            result = inventory.search();
            if (result != null) {
                inventory_id = result.getString(1);
                txtInventoryProduct.setText(result.getString(2));
                tempInventoryProduct = result.getString(2);
                txtInventoryNotes.setText(result.getString(5));

            } else {
                JOptionPane.showMessageDialog(dlgAdminInventory, "El producto no existe, por favor verifique que el nombre del producto esté bien escrito.");
            }

        } catch (SQLException ex) {
            Logger.getLogger(frmAdministration.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_btnInventorySearchActionPerformed

    private void btnInventoryNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInventoryNewActionPerformed
        cleanTextboxInventory();
    }//GEN-LAST:event_btnInventoryNewActionPerformed

    private void btnInventoryListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInventoryListActionPerformed
        inventory = new clsDAOInventory();
        tblInventory.setModel(inventory.list());
        scrollPanelInventoryTable.setVisible(true);
        tblInventory.setVisible(true);


    }//GEN-LAST:event_btnInventoryListActionPerformed

    private void btnInventoryBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInventoryBackActionPerformed

        this.setVisible(true);
        scrollPanelInventoryTable.setVisible(false);
        tblInventory.setVisible(false);
        dlgAdminInventory.setVisible(false);
        cleanTextboxInventory();
    }//GEN-LAST:event_btnInventoryBackActionPerformed

    private void dlgAdminInventoryWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_dlgAdminInventoryWindowClosing
        // TODO add your handling code here:
    }//GEN-LAST:event_dlgAdminInventoryWindowClosing

    private void btnInventoryHistorySearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInventoryHistorySearchActionPerformed
        try {
            inventoryHistory = new clsDAOInventoryHistory();
            ResultSet result;
            String search = JOptionPane.showInputDialog("Por favor ingrese el ID de inventario del producto a buscar");
            inventoryHistory.setSearch(search);
            result = inventoryHistory.search();
            if (result != null) {
                history_id = result.getString(1);
                cboInventoryHistoryProduct.setSelectedItem(result.getString(2));
                if (result.getString(3).equals("0")) {
                    cboInventoryHistoryInOut.setSelectedIndex(1);
                    txtInventoryHistoryAmount.setText(result.getString(4));
                } else {
                    cboInventoryHistoryInOut.setSelectedIndex(0);
                    txtInventoryHistoryAmount.setText(result.getString(3));

                }

                //txtInventoryNotes.setText(result.getString(5));
            } else {
                JOptionPane.showMessageDialog(dlgAdminInventory, "El producto no existe, por favor verifique que el nombre del producto esté bien escrito.");
            }

        } catch (SQLException ex) {
            Logger.getLogger(frmAdministration.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnInventoryHistorySearchActionPerformed

    private void dlgAdminInventoryHistoryWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_dlgAdminInventoryHistoryWindowOpened

    }//GEN-LAST:event_dlgAdminInventoryHistoryWindowOpened

    private void btnOrdersGDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOrdersGDeleteActionPerformed
        ordersGeneral = new clsOrdersGeneral();
        String namep = JOptionPane.showInputDialog("Por favor ingrese el nombre del producto a eliminar");
        ordersGeneral.setOrder_number(namep);
        String result = ordersGeneral.deleteLocalOrder();
        String result2 = ordersGeneral.deleteLocalOrderDetails();
        String result3 = ordersGeneral.deleteOrderDelivery();
        String result4 = ordersGeneral.deleteOrderDeliveryDetails();
        if (result.equals("correcto") || result3.equals("correcto")) {
            JOptionPane.showMessageDialog(dlgAdminOrders, "La orden ha sido elminada correctamente.");
            if (tblOrdersGeneral.isVisible()) {
                tblOrdersGeneral.setModel(ordersGeneral.list());
            }
        } else if (result.equals("error")) {
            JOptionPane.showMessageDialog(dlgAdminOrders, "No ha podido ser eliminada la orden, intente nuevamente y verifique que el número de orden.");
        }
    }//GEN-LAST:event_btnOrdersGDeleteActionPerformed

    private void btnInventoryHistoryList1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInventoryHistoryList1ActionPerformed
        ordersGeneral = new clsOrdersGeneral();
        tblOrdersGeneral.setModel(ordersGeneral.list());
        scrollPanelOrdersGTable.setVisible(true);
        tblOrdersGeneral.setVisible(true);


    }//GEN-LAST:event_btnInventoryHistoryList1ActionPerformed

    private void btnInventoryHistorySearch1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInventoryHistorySearch1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnInventoryHistorySearch1ActionPerformed

    private void btnInventoryHistoryBack1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInventoryHistoryBack1ActionPerformed
        this.setVisible(true);
        scrollPanelOrdersGTable.setVisible(false);
        tblOrdersGeneral.setVisible(false);
        dlgAdminOrders.setVisible(false);
    }//GEN-LAST:event_btnInventoryHistoryBack1ActionPerformed

    private void dlgAdminOrdersWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_dlgAdminOrdersWindowClosing
        // TODO add your handling code here:
    }//GEN-LAST:event_dlgAdminOrdersWindowClosing

    private void dlgAdminOrdersWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_dlgAdminOrdersWindowOpened
        // TODO add your handling code here:
    }//GEN-LAST:event_dlgAdminOrdersWindowOpened

    public void centerElementsTable(JTable table) {
        DefaultTableCellRenderer rendererCenter = new DefaultTableCellRenderer();
        rendererCenter.setHorizontalAlignment(SwingConstants.CENTER);
        for (int i = 0; i < table.getColumnCount(); i++) {
            table.getColumnModel().getColumn(0).setCellRenderer(rendererCenter);

        }
    }

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
     * Limpia todas las cajas de texto del JDialog de employees, cambia
     * cualquier valor que tengan por vacío
     */
    public void cleanTextboxEmployees() {
        txtEmployeesDocument.setText("");
        txtEmployeesName.setText("");
        txtEmployeesLastName.setText("");
        txtEmployeesPhone.setText("");
        txtEmployeesNotes.setText("");
        txtEmployeesAddress.setText("");
    }

    /**
     * Limpia todas las cajas de texto del JDialog de productos, cambia
     * cualquier valor que tengan por vacío
     */
    public void cleanTextboxProducts() {
        txtProductsName.setText("");
        txtProductsDescription.setText("");
        txtProductsPrice.setText("");
        txtProductsNotes.setText("");
    }

    /**
     * Limpia todas las cajas de texto del JDialog de productos, cambia
     * cualquier valor que tengan por vacío
     */
    public void cleanTextboxAdditionalProducts() {
        txtAdditionalProductsName.setText("");
        txtAdditionalProductsDescription.setText("");
        txtAdditionalProductsPrice.setText("");
        txtAdditionalProductsNotes.setText("");
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
        txtCustomersPhone.setText("");
        txtCustomersNotes.setText("");
        cboCustomersNeighborhood.setSelectedItem("");

    }

    /**
     * Limpia todas las cajas de texto del JDialog de consumidores, cambia
     * cualquier valor que tengan por vacío
     */
    public void cleanTextboxLocals() {
        txtLocalsNit.setText("");
        txtLocalsNameL.setText("");
        txtLocalsAddress.setText("");
        txtLocalsNeighborhood.setText("");
    }

    /**
     * Limpia todas las cajas de texto del JDialog de usuarios, cambia cualquier
     * valor que tengan por vacío
     */
    public void cleanTextboxUsers() {
        txtUsersNameUser.setText("");
        txtUsersNameUser.setEnabled(true);
        txtUsersPassword.setText("");
        txtUsersRepeatPassword.setText("");
    }

    /**
     * Limpia todas las cajas de texto del JDialog de inventario, cambia
     * cualquier valor que tengan por vacío
     */
    public void cleanTextboxInventory() {
        txtInventoryProduct.setText("");
        txtInventoryNotes.setText("");
    }

    /**
     * Carga los valores de la clase employees con los valores que tienen las
     * cajas de texto del JDialog employees
     */
    public void loadSetValuesEmployees() {
        employees = new clsDAOEmployees();
        employees.setDocument_id(txtEmployeesDocument.getText());
        employees.setNamee(txtEmployeesName.getText());
        employees.setLastname(txtEmployeesLastName.getText());
        employees.setJob(cbEmployeesJob.getSelectedItem().toString());
        employees.setPhone(txtEmployeesPhone.getText());
        employees.setNotes(txtEmployeesNotes.getText());
        employees.setAddress(txtEmployeesAddress.getText());
        if ("Hot Wings Linares".equals(cbLocal.getSelectedItem().toString())) {
            employees.setLocal_id("1001");
        } else if ("Hot Wings la estrella".equals(cbLocal.getSelectedItem().toString())) {
            employees.setLocal_id("1002");
        }
        employees.setDoc_temp(employee_id);
    }

    /**
     * Carga los valores de la clase products con los valores que tienen las
     * cajas de texto del JDialog products
     */
    public void loadSetValuesProducts() {
        products = new clsDAOProducts();
        products.setNamep(txtProductsName.getText());
        products.setDescription(txtProductsDescription.getText());
        products.setPrice(Integer.parseInt(txtProductsPrice.getText()));
        products.setNotes(txtProductsNotes.getText());
        products.setId_products(product_id);

    }

    /**
     * Carga los valores de la clase Additionalproducts con los valores que
     * tienen las cajas de texto del JDialog Additionalproducts
     */
    public void loadSetValuesAdditionalProducts() {
        additionalProducts = new clsDAOAdditionalProducts();
        additionalProducts.setNamep(txtAdditionalProductsName.getText());
        additionalProducts.setDescription(txtAdditionalProductsDescription.getText());
        additionalProducts.setPrice(Integer.parseInt(txtAdditionalProductsPrice.getText()));
        additionalProducts.setNotes(txtAdditionalProductsNotes.getText());
        additionalProducts.setId_additional_products(additional_product_id);

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
        customers.setNeighborhoos(cboCustomersNeighborhood.getEditor().getItem().toString());
        customers.setTown(cbCustomersTown.getSelectedItem().toString());
        customers.setCity(cbCustomersCity.getSelectedItem().toString());
        customers.setPhone(txtCustomersPhone.getText());
        customers.setNotes(txtCustomersNotes.getText());
        customers.setCustomers_id(customers_id);
    }

    /**
     * Carga los valores de la clase company con los valores que tienen las
     * cajas de texto del JDialog local
     */
    public void loadSetValuesLocals() {
        local = new clsDAOCompany();
        local.setNit(txtLocalsNit.getText());
        local.setName(txtLocalsNameL.getText());
        local.setAddress(txtLocalsAddress.getText());
        local.setNeighborhood(txtLocalsNeighborhood.getText());
        local.setTown(cbLocalsTown.getSelectedItem().toString());
        local.setCity(cbLocalsCity.getSelectedItem().toString());
        local.setLocal_id(local_id);
    }

    /**
     * Carga los valores de la clase company con los valores que tienen las
     * cajas de texto del JDialog local
     */
    public void loadSetValuesUsers() {

        users = new clsDAOUsers();
        users.setUser(txtUsersNameUser.getText());
        users.setPasswordu(String.valueOf(txtUsersPassword.getPassword()));
        users.setRepeatPassword(String.valueOf(txtUsersRepeatPassword.getPassword()));
        users.setDescription(txtUsersNotes.getText());
        if (cboUsersIsAdmin.getSelectedItem().equals("Si")) {
            users.setIsAdmin(1);
        }
        if (cboUsersIsAdmin.getSelectedItem().equals("No")) {
            users.setIsAdmin(0);
        }
    }

    /**
     * Carga los valores de la clase company con los valores que tienen las
     * cajas de texto del JDialog local
     */
    public void loadSetValuesInventory() {
        inventory = new clsDAOInventory();
        inventory.setNameProduct(txtInventoryProduct.getText());
        inventory.setNotes(txtInventoryNotes.getText());
        inventory.setInventory_id(inventory_id);
    }

    /**
     * Carga los valores de la clase company con los valores que tienen las
     * cajas de texto del JDialog local
     */
    public void loadSetValuesInventoryHistory() {
        inventoryHistory = new clsDAOInventoryHistory();
        if (cboInventoryHistoryInOut.getSelectedItem().toString().equals("Entra")) {
            inventoryHistory.setAmountIn(Double.parseDouble(txtInventoryHistoryAmount.getText()));
        } else if (cboInventoryHistoryInOut.getSelectedItem().toString().equals("Sale")) {
            inventoryHistory.setAmountOut(Double.parseDouble(txtInventoryHistoryAmount.getText()));
        }
        inventoryHistory.setHistory_id(history_id);
        inventoryHistory.setNameProduct(cboInventoryHistoryProduct.getSelectedItem().toString());

    }

    public boolean validateFields(LinkedList<JTextField> listTxt, LinkedList<JTextArea> listTxtArea) {
        boolean state = true;
        if (listTxt.size() > 0) {
            for (int i = 0; i < listTxt.size(); i++) {
                if (listTxt.get(i).getText().isEmpty()) {
                    listTxt.get(i).setBorder(borderEmptyField);
                    state = false;
                } else if (listTxt.get(i).getBorder().equals(borderEmptyField)) {
                    listTxt.get(i).setBorder(borderDefault);
                }
            }
        }
        if (listTxtArea.size() > 0) {
            for (int i = 0; i < listTxtArea.size(); i++) {
                if (listTxtArea.get(i).getText().isEmpty()) {
                    listTxtArea.get(i).setBorder(borderEmptyField);
                    state = false;
                } else if (listTxtArea.get(i).getBorder().equals(borderEmptyField)) {
                    listTxtArea.get(i).setBorder(borderDefault);
                }
            }
        }

        return state;
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
    private javax.swing.JButton btnAdditionalProductsBack;
    private javax.swing.JButton btnAdditionalProductsDelete;
    private javax.swing.JButton btnAdditionalProductsEdit;
    private javax.swing.JButton btnAdditionalProductsInsert;
    private javax.swing.JButton btnAdditionalProductsList;
    private javax.swing.JButton btnAdditionalProductsNew;
    private javax.swing.JButton btnAdditionalProductsSearch;
    private javax.swing.JButton btnAdminBack;
    private javax.swing.JButton btnAdminCustomers;
    private javax.swing.JButton btnAdminEmployees;
    private javax.swing.JButton btnAdminInventory;
    private javax.swing.JButton btnAdminOrders;
    private javax.swing.JButton btnAdminPasswords;
    private javax.swing.JButton btnAdminProducts;
    private javax.swing.JButton btnCompanyDates;
    private javax.swing.JButton btnCustomersBack;
    private javax.swing.JButton btnCustomersDelete;
    private javax.swing.JButton btnCustomersEdit;
    private javax.swing.JButton btnCustomersInsert;
    private javax.swing.JButton btnCustomersList;
    private javax.swing.JButton btnCustomersNew;
    private javax.swing.JButton btnCustomersSearch;
    private javax.swing.JButton btnEmployeesBack;
    private javax.swing.JButton btnEmployeesDelete;
    private javax.swing.JButton btnEmployeesEdit;
    private javax.swing.JButton btnEmployeesInsert;
    private javax.swing.JButton btnEmployeesList;
    private javax.swing.JButton btnEmployeesNew;
    private javax.swing.JButton btnEmployeesSearch;
    private javax.swing.JButton btnInventoryBack;
    private javax.swing.JButton btnInventoryDelete;
    private javax.swing.JButton btnInventoryEdit;
    private javax.swing.JButton btnInventoryHistoryBack;
    private javax.swing.JButton btnInventoryHistoryBack1;
    private javax.swing.JButton btnInventoryHistoryDelete;
    private javax.swing.JButton btnInventoryHistoryEdit;
    private javax.swing.JButton btnInventoryHistoryInsert;
    private javax.swing.JButton btnInventoryHistoryList;
    private javax.swing.JButton btnInventoryHistoryList1;
    private javax.swing.JButton btnInventoryHistorySearch;
    private javax.swing.JButton btnInventoryHistorySearch1;
    private javax.swing.JButton btnInventoryInsert;
    private javax.swing.JButton btnInventoryList;
    private javax.swing.JButton btnInventoryNew;
    private javax.swing.JButton btnInventorySearch;
    private javax.swing.JButton btnLocalsBack;
    private javax.swing.JButton btnLocalsDelete;
    private javax.swing.JButton btnLocalsEdit;
    private javax.swing.JButton btnLocalsInsert;
    private javax.swing.JButton btnLocalsList;
    private javax.swing.JButton btnLocalsNew;
    private javax.swing.JButton btnLocalsSearch;
    private javax.swing.JButton btnOrdersGDelete;
    private javax.swing.JButton btnProductsBack;
    private javax.swing.JButton btnProductsDelete;
    private javax.swing.JButton btnProductsEdit;
    private javax.swing.JButton btnProductsInsert;
    private javax.swing.JButton btnProductsList;
    private javax.swing.JButton btnProductsNew;
    private javax.swing.JButton btnProductsSearch;
    private javax.swing.JButton btnSelectAdminAdditions;
    private javax.swing.JButton btnSelectAdminProducts;
    private javax.swing.JButton btnSelectInventory1;
    private javax.swing.JButton btnSelectInventoryHistory;
    private javax.swing.JButton btnUersNew;
    private javax.swing.JButton btnUsersBack;
    private javax.swing.JButton btnUsersDelete;
    private javax.swing.JButton btnUsersEdit;
    private javax.swing.JButton btnUsersInsert;
    private javax.swing.JButton btnUsersList;
    private javax.swing.JButton btnUsersSearch;
    private javax.swing.JComboBox<String> cbCustomersCity;
    private javax.swing.JComboBox<String> cbCustomersTown;
    private javax.swing.JComboBox<String> cbEmployeesJob;
    private javax.swing.JComboBox<String> cbLocal;
    private javax.swing.JComboBox<String> cbLocalsCity;
    private javax.swing.JComboBox<String> cbLocalsTown;
    private javax.swing.JComboBox<String> cboCustomersNeighborhood;
    private javax.swing.JComboBox cboInventoryHistoryInOut;
    private javax.swing.JComboBox cboInventoryHistoryProduct;
    private javax.swing.JComboBox cboUsersIsAdmin;
    private javax.swing.JDialog dlgAdminAdditionalProducts;
    private javax.swing.JDialog dlgAdminCustomers;
    private javax.swing.JDialog dlgAdminEmployees;
    private javax.swing.JDialog dlgAdminInventory;
    private javax.swing.JDialog dlgAdminInventoryHistory;
    private javax.swing.JDialog dlgAdminLocal;
    private javax.swing.JDialog dlgAdminOrders;
    private javax.swing.JDialog dlgAdminProducts;
    private javax.swing.JDialog dlgAdminUsers;
    private javax.swing.JDialog dlgSelectInventory;
    private javax.swing.JDialog dlgSelectProducts;
    private javax.swing.JLabel lbCustomersDocument;
    private javax.swing.JLabel lblAdditionalPrice;
    private javax.swing.JLabel lblAdditionalProductsBackgroundDialog;
    private javax.swing.JLabel lblAdditionalProductsDescription;
    private javax.swing.JLabel lblAdditionalProductsName;
    private javax.swing.JLabel lblAdditionalProductsNotes;
    private javax.swing.JLabel lblAdditionalProductsTitle;
    private javax.swing.JLabel lblAddress;
    private javax.swing.JLabel lblBackgroundAdmin;
    private javax.swing.JLabel lblCustomersAddress;
    private javax.swing.JLabel lblCustomersCity;
    private javax.swing.JLabel lblCustomersLastName;
    private javax.swing.JLabel lblCustomersName;
    private javax.swing.JLabel lblCustomersNeighborhood;
    private javax.swing.JLabel lblCustomersNotes;
    private javax.swing.JLabel lblCustomersTitle;
    private javax.swing.JLabel lblCustomersTown;
    private javax.swing.JLabel lblCustomerssBackgroundDialog;
    private javax.swing.JLabel lblEmployeesBackgroundDialog;
    private javax.swing.JLabel lblEmployeesDocument;
    private javax.swing.JLabel lblEmployeesLastName;
    private javax.swing.JLabel lblEmployeesName;
    private javax.swing.JLabel lblEmployeesTitle;
    private javax.swing.JLabel lblInventoryBackgroundDialog;
    private javax.swing.JLabel lblInventoryHistoryActionInOut;
    private javax.swing.JLabel lblInventoryHistoryAmount;
    private javax.swing.JLabel lblInventoryHistoryBackgroundDialog;
    private javax.swing.JLabel lblInventoryHistoryBackgroundDialog1;
    private javax.swing.JLabel lblInventoryHistoryProduct;
    private javax.swing.JLabel lblInventoryHistoryTitle;
    private javax.swing.JLabel lblInventoryHistoryTitle1;
    private javax.swing.JLabel lblInventoryNotes;
    private javax.swing.JLabel lblInventoryProduct;
    private javax.swing.JLabel lblInventoryTitle;
    private javax.swing.JLabel lblJob;
    private javax.swing.JLabel lblLocal;
    private javax.swing.JLabel lblLocalsAddress;
    private javax.swing.JLabel lblLocalsBackgroundDialog;
    private javax.swing.JLabel lblLocalsCity;
    private javax.swing.JLabel lblLocalsName;
    private javax.swing.JLabel lblLocalsNeighborhood;
    private javax.swing.JLabel lblLocalsTitle;
    private javax.swing.JLabel lblLocalsTown;
    private javax.swing.JLabel lblLocalsyNit;
    private javax.swing.JLabel lblNotes;
    private javax.swing.JLabel lblPhone;
    private javax.swing.JLabel lblPhone1;
    private javax.swing.JLabel lblPrice;
    private javax.swing.JLabel lblProductsBackgroundDialog;
    private javax.swing.JLabel lblProductsDescription;
    private javax.swing.JLabel lblProductsName;
    private javax.swing.JLabel lblProductsNotes;
    private javax.swing.JLabel lblProductsNotes1;
    private javax.swing.JLabel lblProductsTitle;
    private javax.swing.JLabel lblUsersBackgroundDialog;
    private javax.swing.JLabel lblUsersIsAdmin;
    private javax.swing.JLabel lblUsersNameUser;
    private javax.swing.JLabel lblUsersPassword;
    private javax.swing.JLabel lblUsersPassword1;
    private javax.swing.JLabel lblUsersTitle;
    private javax.swing.JPanel pnlAdditionalProducts;
    private javax.swing.JPanel pnlAdditionalProductsButtons;
    private javax.swing.JPanel pnlCustomersButtons;
    private javax.swing.JPanel pnlCustomersDates;
    private javax.swing.JPanel pnlEmployeesButtons;
    private javax.swing.JPanel pnlEmployeesDates;
    private javax.swing.JPanel pnlInventory;
    private javax.swing.JPanel pnlInventoryButtons;
    private javax.swing.JPanel pnlInventoryHistory;
    private javax.swing.JPanel pnlInventoryHistoryButtons;
    private javax.swing.JPanel pnlInventoryHistoryButtons1;
    private javax.swing.JPanel pnlLocals;
    private javax.swing.JPanel pnlLocalsButtons;
    private javax.swing.JPanel pnlProducts2;
    private javax.swing.JPanel pnlProductsButtons;
    private javax.swing.JPanel pnlSelectAdminInventory;
    private javax.swing.JPanel pnlSelectAdminProducts;
    private javax.swing.JPanel pnlUsers;
    private javax.swing.JPanel pnlUsersButtons;
    private javax.swing.JScrollPane scrolAdditionalProductDescription;
    private javax.swing.JScrollPane scrolAdditionalProductslNotes;
    private javax.swing.JScrollPane scrolProductDescription2;
    private javax.swing.JScrollPane scrolProductslNotes2;
    private javax.swing.JScrollPane scrolProductslNotes3;
    private javax.swing.JScrollPane scrollInventoryNotes;
    private javax.swing.JScrollPane scrollNotes;
    private javax.swing.JScrollPane scrollNotes1;
    private javax.swing.JScrollPane scrollPanelAdditionalProductsTable;
    private javax.swing.JScrollPane scrollPanelCustomersTable;
    private javax.swing.JScrollPane scrollPanelEmployeesTable;
    private javax.swing.JScrollPane scrollPanelInventoryHistoryTable;
    private javax.swing.JScrollPane scrollPanelInventoryTable;
    private javax.swing.JScrollPane scrollPanelLocalsTable;
    private javax.swing.JScrollPane scrollPanelOrdersGTable;
    private javax.swing.JScrollPane scrollPanelProductsTable;
    private javax.swing.JScrollPane scrollPanelUsersTable;
    private javax.swing.JTable tblAdditionalProducts;
    private javax.swing.JTable tblCustomers;
    private javax.swing.JTable tblEmployees;
    private javax.swing.JTable tblInventory;
    private javax.swing.JTable tblInventoryHistory;
    private javax.swing.JTable tblLocals;
    private javax.swing.JTable tblOrdersGeneral;
    private javax.swing.JTable tblProducts;
    private javax.swing.JTable tblUsers;
    private javax.swing.JTextArea txtAdditionalProductsDescription;
    private javax.swing.JTextField txtAdditionalProductsName;
    private javax.swing.JTextArea txtAdditionalProductsNotes;
    private javax.swing.JTextField txtAdditionalProductsPrice;
    private javax.swing.JTextField txtCustomersDocument;
    private javax.swing.JTextField txtCustomersLastName;
    private javax.swing.JTextField txtCustomersName;
    private javax.swing.JTextArea txtCustomersNotes;
    private javax.swing.JTextField txtCustomersPhone;
    private javax.swing.JTextField txtCustomerssAddress;
    private javax.swing.JTextField txtEmployeesAddress;
    private javax.swing.JTextField txtEmployeesDocument;
    private javax.swing.JTextField txtEmployeesLastName;
    private javax.swing.JTextField txtEmployeesName;
    private javax.swing.JTextArea txtEmployeesNotes;
    private javax.swing.JTextField txtEmployeesPhone;
    private javax.swing.JTextField txtInventoryHistoryAmount;
    private javax.swing.JTextArea txtInventoryNotes;
    private javax.swing.JTextField txtInventoryProduct;
    private javax.swing.JTextField txtLocalsAddress;
    private javax.swing.JTextField txtLocalsNameL;
    private javax.swing.JTextField txtLocalsNeighborhood;
    private javax.swing.JTextField txtLocalsNit;
    private javax.swing.JTextArea txtProductsDescription;
    private javax.swing.JTextField txtProductsName;
    private javax.swing.JTextArea txtProductsNotes;
    private javax.swing.JTextField txtProductsPrice;
    private javax.swing.JTextField txtUsersNameUser;
    private javax.swing.JTextArea txtUsersNotes;
    private javax.swing.JPasswordField txtUsersPassword;
    private javax.swing.JPasswordField txtUsersRepeatPassword;
    // End of variables declaration//GEN-END:variables
}
