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
import java.util.LinkedList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author GSG
 */
public class clsDAOLocalOrderDetails extends clsLocalOrderDetails {

    controller.Connect connexion;

    public clsDAOLocalOrderDetails() {
        connexion = new Connect();
    }

    public boolean insert() {

        String sql = "INSERT INTO public.tbl_localorder_details(order_number, product_id, product_name, product_description, product_price, product_amount, product_price_total, notes) SELECT (SELECT LAST_VALUE FROM SEQ_ORDER_NUMBER), id_products, namep, description, price ,'" + super.getProduct_amount() + "','" + super.getProduct_price_total() + "','" + super.getNotes() + "' from tbl_products WHERE id_products ='" + super.getProduct_id() + "';";
        System.out.println(sql);
        return connexion.insert(sql);
    }

    public ResultSet search() {
        String sql = "Select * FROM public.tbl_localorder_details WHERE UPPER(order_number) = UPPER('" + super.getSearch() + "');";
        ResultSet results = null;
        results = connexion.search(sql);
        try {
            if (results.next()) {
                return results;
            } else {
                //  return "El empleado que usted está buscando no existe, por favor verifique nuevamente.";
                return null;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    public ResultSet searchProductByName() {
        String sql = "Select * FROM public.tbl_products WHERE UPPER(namep) = UPPER('" + super.getProduct_name() + "');";
        ResultSet results = null;
        results = connexion.search(sql);
        try {
            if (results.next()) {
                return results;
                //return results.getString(2);//Segundo valor.
            } else {
                //  return "El empleado que usted está buscando no existe, por favor verifique nuevamente.";
                return null;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    public String selectOrderNumber() {
        String sql = "SELECT LAST_VALUE FROM SEQ_ORDER_NUMBER;";
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

    public String delete() {
        String sql = "DELETE FROM public.tbl_localorder_details WHERE WHERE UPPER(order_number) = UPPER('" + super.getSearch() + "');";
        return connexion.delete(sql);
    }

    public String edit() {
        //debo de pensar en hacer filtro por orden y por id del producto
        String sql = "UPDATE public.tbl_localorder_details SET product_id='" + super.getProduct_id() + "',product_name='" + super.getProduct_name() + "', product_description='" + super.getProduct_description() + "', product_price='" + super.getProduct_price() + "',product_amount='" + super.getProduct_amount() + "' WHERE UPPER(order_number) = UPPER('" + super.getOrder_number() + "');";
        return connexion.edit(sql);
    }

    public DefaultTableModel list() {
        String[] columnName = {"Producto", "Descripción", "Precio", "Cant", "Total", "Observaciones"};
        DefaultTableModel tblModel = new DefaultTableModel(columnName, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        try {
            ResultSet result = null;
            String sql = "Select product_name, product_description, product_price, product_amount, product_price_total, notes FROM public.tbl_localorder_details;";
            result = connexion.search(sql);
            ResultSetMetaData resultMetaData = result.getMetaData();
            int columns = resultMetaData.getColumnCount();

            while (result.next()) {
                Object[] row = new Object[columns];
                for (int i = 1; i <= columns; i++) {
                    row[i - 1] = result.getObject(i);
                }

                System.out.println("");
                tblModel.addRow(row);
            }
            return tblModel;
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    public LinkedList listProducts() {
        int numberButtons = 9;
        LinkedList<String[]> dates = new LinkedList<>();
        try {
            ResultSet result = null;
            String sql = "Select namep, description, price, notes FROM public.tbl_products;";
            result = connexion.search(sql);
            ResultSetMetaData resultMetaData = result.getMetaData();
            int columns = resultMetaData.getColumnCount();

            while (result.next()) {
                String[] row = new String[columns];
                for (int i = 1; i <= columns; i++) {
                    row[i - 1] = result.getObject(i).toString();
                }
                dates.add(row);
            }
            numberButtons = numberButtons - dates.size();
            for (int i = 0; i < numberButtons; i++) {
                String[] row = new String[numberButtons];
                for (int j = 0; j < columns; j++) {
                    row[i] = "Producto X";
                }
                dates.add(row);
            }
            return dates;
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    public LinkedList listForOrderNumber() {
        int numberButtons = 9;
        LinkedList<String[]> dates = new LinkedList<>();
        try {
            ResultSet result = null;
            String sql = "Select product_name, product_description, product_price, product_amount, product_price_total, notes FROM public.tbl_localorder_details;";

            //String sql = "Select namep, description, price, notes FROM public.tbl_products;";
            result = connexion.search(sql);
            ResultSetMetaData resultMetaData = result.getMetaData();
            int columns = resultMetaData.getColumnCount();

            while (result.next()) {
                String[] row = new String[columns];
                for (int i = 1; i <= columns; i++) {
                    row[i - 1] = result.getObject(i).toString();
                }
                dates.add(row);
            }
            numberButtons = numberButtons - dates.size();
            for (int i = 0; i < numberButtons; i++) {
                String[] row = new String[numberButtons];
                for (int j = 0; j < columns; j++) {
                    row[i] = "Producto X";
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
