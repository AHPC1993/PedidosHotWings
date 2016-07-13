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
public class clsDAOLocalOrderDetails extends clsLocalOrderDetails{
    controller.Connect connexion;

    public clsDAOLocalOrderDetails() {
    connexion = new Connect();
    }
    
     public boolean insert() {

        String sql = "INSERT INTOpublic.tbl_localorder_details(order_number, unit_pruduct_id, product_name, product_description, product_price, product_amount) SELECT (SELECT LAST_VALUE FROM SEQ_ORDER_NUMBER), id_products, namep, description, price ,'" + super.getProduct_amount() +"' from tbl_products WHERE namep ='"+super.getProduct_id()+"';";
        return connexion.insert(sql);
    }

    public ResultSet search() {
        String sql = "Select * FROM public.tbl_customers WHERE UPPER(phone) = UPPER('" + super.getSearch() + "') OR UPPER(namec) = UPPER('" + super.getSearch() + "');";
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

    public String delete() {
        String sql = "DELETE FROM public.tbl_customers WHERE UPPER(phone) = UPPER('" + super.getSearch() + "') OR UPPER(namec) = UPPER('" + super.getSearch() + "');";
        return connexion.delete(sql);
    }

    public String edit() {
        String sql = "UPDATE public.tbl_customers SET document_id='" + super.getDocument_id() + "',namec='" + super.getNamec() + "', lastname='" + super.getLastname() + "', address='" + super.getAddress() + "',neighborhood='" + super.getNeighborhood() + "', town='" + super.getTown() + "', city='" + super.getCity() + "',phone='" + super.getPhone() + "', notes='" + super.getNotes() + "' WHERE UPPER(customers_id) = UPPER('" + super.getCustomers_id()+ "');";
        return connexion.edit(sql);
    }

    public DefaultTableModel list() {
        String[] columnName = {"Cédula", "Nombre", "Apellido", "Dirección", "Barrio", "Municipio", "Departamento", "Teléfono", "Notas"};
        DefaultTableModel tblModel = new DefaultTableModel(columnName, 0);
        try {
            ResultSet result = null;
            String sql = "Select document_id, namec, lastname, address, neighborhood, town, city, phone, notes FROM public.tbl_customers;";
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
    
    public LinkedList listProducts() {
        int numberButtons = 9;
        LinkedList<String[]> dates = new LinkedList<>();
        try {
            ResultSet result = null;
            String sql = "Select namep,description, price, notes FROM public.tbl_products;";
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
             numberButtons = numberButtons-dates.size();
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
