/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import controller.Connect;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author GSG
 */
public class clsDAOOrderDeliveryDetails extends clsOrderDeliveryDetails {

    controller.Connect connexion;

    public clsDAOOrderDeliveryDetails() {
        connexion = new Connect();
    }

    /**
     * Inserta en la tabla tbl_orderlocal_details, un producto con su cantidad,
     * valor y valor total.
     *
     * @return
     */
    public boolean insertProduct() {

        String sql = "INSERT INTO public.tbl_orderdelivery_details(order_number, product_id, customers_id, product_name, product_description, product_price, product_amount, product_price_total, notes, localorder_id) SELECT (SELECT LAST_VALUE FROM SEQ_ORDER_NUMBER), id_products,'" + super.getCustomers_id() + "',namep, description, price ,'" + super.getProduct_amount() + "','" + super.getProduct_price_total() + "','" + super.getNotes() + "',NEXTVAL('SEQ_ORDERDELIVERY_DETAILS') from tbl_products WHERE id_products ='" + super.getProduct_id() + "';";
        return connexion.insert(sql);
    }

    /**
     * Inserta en la tabla tbl_orderlocal_details, un producto adicional con su
     * cantidad, valor y valor total.
     *
     * @return
     */
    public boolean insertAdditionalProduct() {

        String sql = "INSERT INTO public.tbl_orderdelivery_details(order_number, additional_products_id,customers_id, product_name, product_description, product_price, product_amount, product_price_total, notes, localorder_id) SELECT (SELECT LAST_VALUE FROM SEQ_ORDER_NUMBER), additional_products_id,'" + super.getCustomers_id() + "',namep, description, price ,'" + super.getProduct_amount() + "','" + super.getProduct_price_total() + "','" + super.getNotes() + "',NEXTVAL('SEQ_ORDERDELIVERY_DETAILS') from tbl_additional_products WHERE additional_products_id ='" + super.getAdditional_products_id() + "';";
        return connexion.insert(sql);
    }

    /**
     * Inserta en la tabla tbl_orderlocal_details, un producto adicional con su
     * cantidad, valor y valor total.
     *
     * @param service
     * @return
     */
    public boolean insertServiceOrderDelivery(double service) {

        String sql = "INSERT INTO public.tbl_orderdelivery_details(order_number, customers_id, product_name, product_description, product_price, product_amount, product_price_total, notes, localorder_id) SELECT (SELECT LAST_VALUE FROM SEQ_ORDER_NUMBER),'" + super.getCustomers_id() + "','Domicilio', 'Cargo por el servicio a domicilio','" + service + "','1','" + service + "','" + super.getNotes() + "',(SELECT NEXTVAL('SEQ_ORDERDELIVERY_DETAILS')) ;";
        return connexion.insert(sql);
    }

    /**
     * Inserta en la tabla orderlocal, con el total del pedido y el número de
     * orden, con el fin de visualizar después todo lqo eu contiene el pedido.
     *
     * @param order_number
     * @param total_price
     * @param employee_id
     * @return
     */
    public boolean insertOrderFull(String order_number, String total_price, String employee_id) {

        String sql = "INSERT INTO public.tbl_orderdelivery(order_number, total_price, date_order,employee_id) VALUES('" + order_number + "','" + total_price + "', (SELECT To_timestamp(To_char(current_timestamp, 'YYYY/MM/DD HH:MI:SS'),'YYYY/MM/DD HH:MI:SS')),(SELECT employee_id FROM tbl_employees Where employee_id = '" + employee_id + "'));";
        return connexion.insert(sql);
    }

    /**
     * Método encargado de traer información sobre una orden para domicilio
     * específica.
     *
     * @return
     */
    public ResultSet search() {
        String sql = "Select * FROM public.tbl_orderdelivery_details WHERE UPPER(localorder_id) = UPPER('" + super.getLocalOrder_id() + "');";
        ResultSet results = null;
        results = connexion.search(sql);
        try {
            if (results.next()) {
                return results;
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    /**
     * Método que permite buscar un producto por su nombre.
     *
     * @return
     */
    public ResultSet searchProductByName() {
        String sql = "Select * FROM public.tbl_products WHERE UPPER(namep) = UPPER('" + super.getProduct_name() + "');";
        ResultSet results = null;
        results = connexion.search(sql);
        try {
            if (results.next()) {
                return results;
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    /**
     * Método que permite buscar un producto adicional por su nombre.
     *
     * @return
     */
    public ResultSet searchAdditionalProductByName() {
        String sql = "Select * FROM public.tbl_additional_products WHERE UPPER(namep) = UPPER('" + super.getProduct_name() + "');";
        ResultSet results = null;
        results = connexion.search(sql);
        try {
            if (results.next()) {
                return results;
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    /**
     * Método que permite buscar un empleado con su número de ID, su nombre y
     * apellido, solo para aquellos empleados que son domicilios
     *
     * @return
     */
    public ResultSet searchEmployeesJobDelivery() {
        try {
            String sql = "Select employee_id,  namee || ' ' || lastname FROM public.tbl_employees WHERE UPPER(job) = UPPER('Domicilio');";
            ResultSet results = null;
            results = connexion.search(sql);
            if (results.next()) {
                return results;
            } else {
                return null;
            }
        } catch (SQLException ex) {
            System.out.println(ex);
            return null;
        }

    }

    /**
     * Método que muestra el número de orden actual
     *
     * @return
     */
    public String selectOrderNumber() {
        String sql = "SELECT LAST_VALUE FROM SEQ_ORDER_NUMBER;";
        ResultSet results = null;
        results = connexion.search(sql);
        try {
            if (results.next()) {
                return results.getString(1);
            } else {
                return "0";
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    /**
     * Método que muestra el total de la orden de domicilio en un pedido.
     *
     * @param orderNumber
     * @return
     */
    public String selectTotalOrder(String orderNumber) {
        String sql = "SELECT to_char(SUM(product_price_total),'FM9,999,999') FROM tbl_orderdelivery_details WHERE order_number='" + orderNumber + "';";
        ResultSet results = null;
        results = connexion.search(sql);
        try {
            if (results.next()) {
                return results.getString(1);
            } else {
                return "0";
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    /**
     * Método que incrementa el número de orden(el general) cuando se finaliza
     * un pedido.
     *
     * @return
     */
    public String incrementOrderNumber() {
        String sql = "SELECT NEXTVAL('SEQ_ORDER_NUMBER') FROM SEQ_ORDERDELIVERY_DETAILS;";
        ResultSet results = null;
        results = connexion.search(sql);
        try {
            if (results.next()) {
                return results.getString(1);
                //return results.getString(2);//Segundo valor.
            } else {
                return "0";
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    /**
     * Método encargado de eliminar un item de una orden para domicilio.
     *
     * @return
     */
    public String delete(String localOrder_id) {
        String sql = "DELETE FROM public.tbl_orderdelivery_details WHERE UPPER(localorder_id) = UPPER('" + localOrder_id + "');";
        return connexion.delete(sql);
    }

    /**
     * Método encargado de cancelar(eliminar) una orden de domicilio cuando se
     * de clic en el botón volver.
     *
     * @param order_number
     * @return
     */
    public String cancelOrderButtonBack(String order_number) {
        String sql = "DELETE FROM public.tbl_orderdelivery_details WHERE UPPER(order_number) = UPPER('" + order_number + "');";
        return connexion.delete(sql);
    }

    /**
     * Método encargado de editar un item de una orden para domicilio.
     *
     * @return
     */
    public String edit() {
        //debo de pensar en hacer filtro por orden y por id del producto
        String sql = "UPDATE public.tbl_orderdelivery_details SET product_id='" + super.getProduct_id() + "',product_name='" + super.getProduct_name() + "', product_description='" + super.getProduct_description() + "', product_price='" + super.getProduct_price() + "',product_amount='" + super.getProduct_amount() + "' WHERE UPPER(order_number) = UPPER('" + super.getOrder_number() + "');";
        return connexion.edit(sql);
    }

    /**
     * Método encargado de listar todos los productos que están siendo pedidos
     * en una orden específica y devolverlos en una tabla que será visualizada
     * por el usuario.
     *
     * @param order_number
     * @return
     */
    public DefaultTableModel list(String order_number) {

        String[] columnName = {"Id Item", "Producto", "Descripción", "Precio", "Cant", "Total", "Observaciones"};
        DefaultTableModel tblModel = new DefaultTableModel(columnName, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        try {
            ResultSet result = null;
            String sql = "Select localOrder_id, product_name, product_description, to_char(product_price,'FM9,999,999'), product_amount, to_char(product_price_total,'FM9,999,999'), notes FROM public.tbl_orderdelivery_details WHERE order_number='" + order_number + "';";
            result = connexion.search(sql);
            ResultSetMetaData resultMetaData = result.getMetaData();
            int columns = resultMetaData.getColumnCount();

            while (result.next()) {
                Object[] row = new Object[columns];
                for (int i = 1; i <= columns; i++) {
                    if (result.getObject(i) != null) {
                        row[i - 1] = result.getObject(i);
                    }
                }
                tblModel.addRow(row);
            }
            return tblModel;
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    /**
     * Método encargado de listar todos los productos que existen en el sistema.
     *
     * @return
     */
    public LinkedList listProducts() {
        LinkedList<String[]> dates = new LinkedList<>();
        try {
            ResultSet result = null;
            String sql = "Select namep, description, price, notes FROM public.tbl_products order by 1;";
            result = connexion.search(sql);
            ResultSetMetaData resultMetaData = result.getMetaData();
            int columns = resultMetaData.getColumnCount();

            while (result.next()) {
                String[] row = new String[columns];
                for (int i = 1; i <= columns; i++) {
                    if (result.getObject(i) != null) {
                        row[i - 1] = result.getObject(i).toString();
                    }
                }
                dates.add(row);
            }
            return dates;
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    /**
     * Método encargado de listar todos los productos adicionales que existen en
     * el sistema.
     *
     * @return
     */
    public LinkedList listAdditionalProducts() {
        LinkedList<String[]> dates = new LinkedList<>();
        try {
            ResultSet result = null;
            String sql = "Select namep, description, price, notes FROM public.tbl_additional_products order by 1 asc;";
            result = connexion.search(sql);
            ResultSetMetaData resultMetaData = result.getMetaData();
            int columns = resultMetaData.getColumnCount();

            while (result.next()) {
                String[] row = new String[columns];
                for (int i = 1; i <= columns; i++) {
                    if (result.getObject(i) != null) {
                        row[i - 1] = result.getObject(i).toString();
                    }
                }
                dates.add(row);
            }
            return dates;
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

}
