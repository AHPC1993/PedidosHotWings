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
public class clsDAOCompany extends clsCompany {

    controller.Connect connexion;

    public clsDAOCompany() {
        connexion = new Connect();
    }

    public boolean insert() {

        String sql = "INSERT INTO public.tbl_local(local_id, nit, namel, address, neighborhood, town, city) VALUES (nextval('SEQ_LOCALS'),'" + super.getNit() + "','" + super.getName() + "','" + super.getAddress() + "','" + super.getNeighborhood() + "','" + super.getTown() + "','" + super.getCity() + "');";
        return connexion.insert(sql);
    }

    public ResultSet search() {
        String sql = "Select * FROM public.tbl_local WHERE UPPER(namel) = UPPER('" + super.getSearch() + "') OR UPPER(neighborhood) = UPPER('" + super.getSearch() + "');";
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
        String sql = "DELETE FROM public.tbl_local WHERE UPPER(namel) = UPPER('" + super.getSearch() + "') OR UPPER(neighborhood) = UPPER('" + super.getSearch() + "');";
        return connexion.delete(sql);
    }

    public String edit() {
        String sql = "UPDATE public.tbl_local SET nit='" + super.getNit() + "',namel='" + super.getName() + "', address='" + super.getAddress() + "', neighborhood='" + super.getNeighborhood() + "',town='" + super.getTown() + "', city='" + super.getCity() + "' WHERE UPPER(local_id) = UPPER('" + super.getLocal_id() + "');";
        return connexion.edit(sql);
    }

    public DefaultTableModel list() {
        String[] columnName = {"Nit", "Nombre Local", "Dirección", "Barrio", "Municipio", "Departamento"};
        DefaultTableModel tblModel = new DefaultTableModel(columnName, 0){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        try {
            ResultSet result = null;
            String sql = "Select  nit, namel, address, neighborhood, town, city FROM public.tbl_local;";
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
