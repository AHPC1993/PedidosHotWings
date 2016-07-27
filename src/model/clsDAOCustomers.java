/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import ca.odell.glazedlists.GlazedLists;
import ca.odell.glazedlists.swing.AutoCompleteSupport;
import controller.Connect;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JComboBox;
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

    public String findDuplicateCustomers(String numberphone){
        String sql = "Select * FROM public.tbl_customers WHERE UPPER(phone) = UPPER('" + numberphone + "');";
        ResultSet results = null;
        results = connexion.search(sql);
        try {
            if (results.next()) {
                return "existe";
            } else {
                //  return "El empleado que usted está buscando no existe, por favor verifique nuevamente.";
                return "no_existe";
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null; 
    }
    
    public boolean insert() {
        String sql = "INSERT INTO public.tbl_customers(customers_id, document_id, namec, lastname, address, neighborhood, town, city, phone, notes)VALUES (nextval('SEQ_CUSTOMERS'),'" + super.getDocument_id() + "','" + super.getNamec() + "','" + super.getLastname() + "','" + super.getAddress() + "','" + super.getNeighborhood() + "','" + super.getTown() + "','" + super.getCity() + "','" + super.getPhone() + "','" + super.getNotes() + "');";
        return connexion.insert(sql);
    }

    public ResultSet search() {
        String sql = "Select * FROM public.tbl_customers WHERE UPPER(phone) = UPPER('" + super.getSearch() + "');";
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
        String sql = "DELETE FROM public.tbl_customers WHERE UPPER(phone) = UPPER('" + super.getSearch() + "');";
        return connexion.delete(sql);
    }

    public String edit() {
        String sql = "UPDATE public.tbl_customers SET document_id='" + super.getDocument_id() + "',namec='" + super.getNamec() + "', lastname='" + super.getLastname() + "', address='" + super.getAddress() + "',neighborhood='" + super.getNeighborhood() + "', town='" + super.getTown() + "', city='" + super.getCity() + "',phone='" + super.getPhone() + "', notes='" + super.getNotes() + "' WHERE UPPER(customers_id) = UPPER('" + super.getCustomers_id() + "');";
        return connexion.edit(sql);
    }

    public DefaultTableModel list() {
        String[] columnName = {"Cédula", "Nombre", "Apellido", "Dirección", "Barrio", "Municipio", "Departamento", "Teléfono", "Notas"};
        DefaultTableModel tblModel = new DefaultTableModel(columnName, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
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

    public JComboBox loadCboNeighborhood(JComboBox combo) {
        ArrayList<String> listOfNeighborhood = searchNeighBorhoodCustomers();
        Object[] elements = new Object[listOfNeighborhood.size()];
        for (int i = 0; i < listOfNeighborhood.size(); i++) {
            elements[i] = listOfNeighborhood.get(i);
        }
        AutoCompleteSupport.install(combo, GlazedLists.eventListOf(elements));
        return combo;
    }

    public ArrayList<String> searchNeighBorhoodCustomers() {
        ArrayList<String> listOfNeighborhood = new ArrayList<>();
        try {
            String sql = "Select Distinct neighborhood FROM public.tbl_customers order by 1 asc ;";
            ResultSet results = null;
            results = connexion.search(sql);
            if (results.next()) {
                listOfNeighborhood.add(results.getString(1));
                while (results.next()) {
                    listOfNeighborhood.add(results.getString(1));
                }
                return listOfNeighborhood;
            } else {
                System.out.println("No encontré ni un solo registro");
                return null;
            }
        } catch (SQLException ex) {
            System.out.println(ex);
            return null;
        }
    }

}
