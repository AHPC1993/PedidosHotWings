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
public class clsDAOInventory extends clsInventory {

    controller.Connect connexion;

    public clsDAOInventory() {
        connexion = new Connect();
    }

    public boolean insert() {
        String sql = "INSERT INTO public.tbl_inventory(inventory_id, name_product, total_amount, date_creation, notes) VALUES (nextval('SEQ_INVENTORY'),'" + super.getNameProduct()+ "','" + super.getTotalAmount() + "',current_date,'"+super.getNotes()+"');";
        return connexion.insert(sql);
    }

    public ResultSet search() {
        String sql = "Select * FROM public.tbl_inventory WHERE UPPER(name_product)=UPPER('" + super.getSearch()+ "');";
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
        String sql = "DELETE FROM public.tbl_inventory WHERE UPPER(name_product)=UPPER('" + super.getSearch()+ "');";
        return connexion.delete(sql);
    }

    public String edit() {

        String sql = "UPDATE public.tbl_inventory SET name_product='" + super.getNameProduct()+ "', notes='" + super.getNotes() + "' WHERE UPPER(inventory_id)=UPPER('" + super.getInventory_id()+ "');";
        return connexion.edit(sql);
    }

    public DefaultTableModel list() {
        String[] columnName = {"Producto", "Cantidad existente", "Notas", "Fecha de creación"};
        DefaultTableModel tblModel = new DefaultTableModel(columnName, 0);
        try {
            ResultSet result = null;
            String sql = "SELECT name_product, total_amount, notes, date_creation FROM public.tbl_inventory;";
            result = connexion.search(sql);
            ResultSetMetaData resultMetaData = result.getMetaData();
            int columns = resultMetaData.getColumnCount();
            while (result.next()) {
                Object[] row = new Object[columns];
                for (int i = 1; i <= columns; i++) {
                    row[i - 1] = result.getObject(i);
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
