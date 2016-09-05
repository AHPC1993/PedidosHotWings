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
public class clsOrdersGeneral {

    private String order_number;
    controller.Connect connexion;

    public clsOrdersGeneral() {
        connexion = new Connect();
    }

    public String deleteLocalOrder() {
        String sql = "DELETE FROM public.tbl_localorder WHERE order_number = '" + getOrder_number() + "';";
        return connexion.delete(sql);

    }

    public String deleteLocalOrderDetails() {
        String sql = "DELETE FROM public.tbl_localorder_details WHERE UPPER(order_number) = UPPER('" + getOrder_number() + "');";
        return connexion.delete(sql);
    }

    public String deleteOrderDelivery() {
        String sql = "DELETE FROM public.tbl_orderdelivery WHERE UPPER(order_number) = UPPER('" + getOrder_number() + "');";
        return connexion.delete(sql);
    }

    public String deleteOrderDeliveryDetails() {
        String sql = "DELETE FROM public.tbl_orderdelivery_details WHERE UPPER(order_number) = UPPER('" + getOrder_number() + "');";
        return connexion.delete(sql);
    }

    public DefaultTableModel list() {
        String[] columnName = {"Fecha", "Número de Orden", "Total Pedido"};
        DefaultTableModel tblModel = new DefaultTableModel(columnName, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        try {
            ResultSet result = null;
            String sql = "SELECT date_order, order_number, to_char(total_price,'FM999,999,999') FROM tbl_localorder UNION SELECT date_order, order_number, to_char(total_price,'FM999,999,999') FROM tbl_orderdelivery ORDER by date_order desc;";
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

    public clsOrdersGeneral(String order_number) {
        this.order_number = order_number;
    }

    public String getOrder_number() {
        return order_number;
    }

    public void setOrder_number(String order_number) {
        this.order_number = order_number;
    }

}
