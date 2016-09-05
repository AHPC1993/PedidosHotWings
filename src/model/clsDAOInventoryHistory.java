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

    /**
     * Método encargado de insertar datos sobe el historial de inventario en la
     * base de datos del sistema.
     *
     * @return
     */
    public boolean insert() {
        String sql = "INSERT INTO public.tbl_inventory_history(history_id, inventory_id, amount_in, amount_out, date_update) VALUES (nextval('SEQ_HISTORY_INVENTORY'),(SELECT Inventory_id FROM tbl_inventory WHERE name_product='" + super.getNameProduct() + "'),'" + super.getAmountIn() + "','" + super.getAmountOut() + "',(SELECT To_timestamp(To_char(current_timestamp, 'YYYY/MM/DD HH:MI:SS'),'YYYY/MM/DD HH:MI:SS')));";
        return connexion.insert(sql);
    }

    /**
     * Método encargado de traer información sobre el historial de inventario.
     *
     * @return
     */
    public ResultSet search() {
        String sql = "Select his.history_id, (SELECT DISTINCT inv.name_product FROM tbl_inventory inv WHERE inv.inventory_id = his.inventory_id),his.amount_in, his.amount_out FROM public.tbl_inventory_history his WHERE UPPER(his.history_id)=UPPER('" + super.getSearch() + "');";
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
     * Método encargado de eliminar un item del historial de inventarios.
     *
     * @return
     */
    public String delete() {
        String sql = "DELETE FROM public.tbl_inventory_history WHERE  UPPER(history_id)=UPPER('" + super.getSearch() + "');";
        return connexion.delete(sql);
    }

    /**
     * Método encargado de editar un item del historial de inventarios.
     *
     * @return
     */
    public String edit() {

        String sql = "UPDATE public.tbl_inventory_history SET amount_in='" + super.getAmountIn() + "', amount_out='" + super.getAmountOut() + "', date_update=(SELECT To_timestamp(To_char(current_timestamp, 'YYYY/MM/DD HH:MI:SS'),'YYYY/MM/DD HH:MI:SS')) WHERE UPPER(history_id)=UPPER('" + super.getHistory_id() + "');";
        return connexion.edit(sql);
    }

    /**
     * Método encargado de listar todo el historial de lo que entra y sale en el
     * inventario
     *
     * @return
     */
    public DefaultTableModel list() {
        String[] columnName = {"Fecha", "Id Inventario", "Producto", "Cantidad Entrante", "Cantidad que sale"};
        DefaultTableModel tblModel = new DefaultTableModel(columnName, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        try {
            ResultSet result = null;
            String sql = "SELECT TO_CHAR(date_update,'YYYY/MM/DD HH:MI'), history_id, (SELECT DISTINCT inv.name_product FROM tbl_inventory inv WHERE inv.inventory_id = his.inventory_id), amount_in, amount_out FROM tbl_inventory_history his, tbl_inventory inv   WHERE inv.inventory_id = his.inventory_id ORDER BY 2 DESC;";
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
     * Método que lista todos los productos existentens en un ComboBox
     *
     * @return
     */
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
