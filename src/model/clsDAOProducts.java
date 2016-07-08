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
import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author GSG
 */
public class clsDAOProducts extends clsProducts{

    
    controller.Connect connexion;

    public clsDAOProducts() {
        connexion = new Connect();
    }

    public boolean insert() {
    
        String sql = "INSERT INTO public.tbl_products(id_products, namep, description, price, notes)VALUES (nextval('SEQ_PRODUCTS'),'" + super.getNamep()+ "','" + super.getDescription()+ "','" + super.getPrice()+ "','" + super.getNotes() + "');";
        return connexion.insert(sql);
    }

    public ResultSet search() {
        String sql = "Select * FROM public.tbl_products WHERE UPPER(namep) = UPPER('" + super.getNamep()+ "');";
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

    public String delete() {
        String sql = "DELETE FROM public.tbl_products WHERE UPPER(namep) = UPPER('" + super.getNamep()+ "');";
        return connexion.delete(sql);
    }

    public String edit() {

        String sql = "UPDATE public.tbl_products SET namep='" + super.getNamep()+ "',description='" + super.getDescription()+ "', price='" + super.getPrice()+ "', notes='" + super.getNotes()+ "' WHERE UPPER(namep) = UPPER('" + super.getNamep()+ "');";
        return connexion.edit(sql);
    }

    public DefaultTableModel list() {
        String[] columnName = {"Nombre",
            "Descripción", "Precio", "Notas"};
        DefaultTableModel tblModel = new DefaultTableModel(columnName, 0);
        try {
            ResultSet result = null;
            String sql = "Select * FROM public.tbl_products;";
            result = connexion.search(sql);
            ResultSetMetaData resultMetaData = result.getMetaData();
            int columns = resultMetaData.getColumnCount();

            tblModel.addColumn(columnName);

            while (result.next()) {
                Object[] row = new Object[columns];
                for (int i = 1; i < columns; i++) {
                    row[i] = result.getObject(i + 1);
                }
                tblModel.addRow(row);
            }
            return tblModel;
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    
}
