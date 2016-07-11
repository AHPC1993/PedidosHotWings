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
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author GSG
 */
public class clsDAOCustomers extends clsCustomers {

    controller.Connect connexion;

    public clsDAOCustomers() {
        connexion = new Connect();
    }

    public boolean insert() {

        String sql = "INSERT INTO public.tbl_customers(customers_id, document_id, namec, lastname, address, neighborhood, town, city, phone, notes)VALUES (nextval('SEQ_CUSTOMERS'),'" + super.getDocument_id() + "','" + super.getNamec() + "','" + super.getLastname() + "','" + super.getAddress() + "','" + super.getNeighborhood() + "','" + super.getTown() + "','" + super.getCity() + "','" + super.getPhone() + "','" + super.getNotes() + "');";
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

}
