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
        String sql = "INSERT INTO public.tbl_inventory(inventory_id, name_product, total_amount, date_creation, notes) VALUES (nextval('SEQ_INVENTORY'),'" + super.getNameProduct() + "','" + super.getTotalAmount() + "',(SELECT To_timestamp(To_char(current_timestamp, 'YYYY/MM/DD HH:MI:SS'),'YYYY/MM/DD HH:MI:SS')),'" + super.getNotes() + "');";
        return connexion.insert(sql);
    }
    
    
     public String findDuplicateProductsInventory(String productName){
        String sql = "Select * FROM public.tbl_inventory WHERE UPPER(name_product) = UPPER('" + productName + "');";
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

    public ResultSet search() {
        String sql = "Select * FROM public.tbl_inventory WHERE UPPER(name_product)=UPPER('" + super.getSearch() + "');";
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
        String sql = "DELETE FROM public.tbl_inventory WHERE UPPER(name_product)=UPPER('" + super.getSearch() + "');";
        return connexion.delete(sql);
    }

    public String edit() {

        String sql = "UPDATE public.tbl_inventory SET name_product='" + super.getNameProduct() + "', notes='" + super.getNotes() + "' WHERE UPPER(inventory_id)=UPPER('" + super.getInventory_id() + "');";
        return connexion.edit(sql);
    }

    public String updateTotalAmount(String inventory_id) {
        String sql = "UPDATE public.tbl_inventory inv  SET total_amount=    (SELECT SUM(amount_in)-SUM(amount_out) FROM tbl_inventory_history his Where his.Inventory_id = '" + inventory_id + "')  WHERE inv.Inventory_id = '" + inventory_id + "';";
        return connexion.edit(sql);
    }

    public String searchInventoryIdFromProductName(String productName) {
        String sql = "Select DISTINCT inv.inventory_id FROM public.tbl_inventory inv WHERE UPPER(inv.name_product)=UPPER('" + productName + "');";
        ResultSet results = null;
        results = connexion.search(sql);
        try {
            if (results.next()) {
                return results.getString(1);
            } else {
                return "";
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return "";
    }

    public DefaultTableModel list() {
        String[] columnName = {"Producto", "Cantidad existente", "Notas", "Fecha de creación"};
        DefaultTableModel tblModel = new DefaultTableModel(columnName, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
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
