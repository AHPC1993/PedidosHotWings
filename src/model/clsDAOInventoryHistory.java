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
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author GSG
 */
public class clsDAOInventoryHistory extends clsInventoryHistory {
 controller.Connect connexion;

    public clsDAOInventoryHistory() {
        connexion = new Connect();
    }
    
     public boolean insert() {
        String sql = "INSERT INTO public.tbl_inventory_history(history_id, inventory_id, amount_in, amount_out, date_update) VALUES (nextval('SEQ_HISTORY_INVENTORY'),(SELECT Inventory_id FROM tbl_inventory WHERE name_product='" + super.getNameProduct()+ "'),'" + super.getAmountIn()+ "','"+super.getAmountOut()+"',current_date);";
         System.out.println(sql);
        return connexion.insert(sql);
    }

    public ResultSet search() {
        String sql = "Select * FROM public.tbl_inventory_history WHERE UPPER(history_id)=UPPER('" +  super.getSearch()+ "');";
        System.out.println(sql);
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

    public String delete() {
        String sql = "DELETE FROM public.tbl_inventory_history WHERE  UPPER(history_id)=UPPER('" +  super.getSearch()+ "');";
        return connexion.delete(sql);
    }

    public String edit() {

        String sql = "UPDATE public.tbl_inventory_history SET amount_in='" + super.getAmountIn()+ "', amount_out='" + super.getAmountOut()+ "', date_update=current_date WHERE UPPER(history_id)=UPPER('" +  super.getSearch()+ "');";
        return connexion.edit(sql);
    }

    public DefaultTableModel list() {
        String[] columnName = {"Fecha", "Id Inventario", "Producto", "Cantidad Entrante", "Cantidad que sale"};
        DefaultTableModel tblModel = new DefaultTableModel(columnName, 0);
        try {
            ResultSet result = null;
            String sql = "SELECT date_update, history_id, (SELECT product_name FROM tbl_inventory inv, tbl_inventory_history his WHERE inv.inventory_id = his.inventory_id),  amount_in, amount_out FROM tbl_inventory_history ORDER BY 2 DESC;";
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
 
    
    
     public ArrayList<String> loadCboProductsPerName() {
        ArrayList<String> listOfProductsName = new ArrayList<>();
        try {
            String sql = "SELECT DISTINCT name_product FROM tbl_inventory ORDER BY 1 ASC;";
            ResultSet results = null;
            results = connexion.search(sql);
            if (results.next()) {
                listOfProductsName.add(results.getString(1));
                while (results.next()) {
                    listOfProductsName.add(results.getString(1));
                }
                return listOfProductsName;
            } else {
                return null;
            }
        } catch (SQLException ex) {
            System.out.println(ex);
            return null;
        }
    }
    
}
