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
 * @author allan
 */
public class clsDAOUsers extends clsUsers{
    
    controller.Connect connexion;

    public clsDAOUsers() {
        connexion = new Connect();
    }

    public boolean insert() {

        String sql = "INSERT INTO tbl_login(users, passwordu, description, date_register, date_in, isadmin) VALUES ('" + super.getUser()+ "','" + super.getPasswordu()+ "','" + super.getDescription()+ "',current_date,current_date,'"+super.getIsAdmin()+"');";
        return connexion.insert(sql);
    }

    public ResultSet search() {
        String sql = "Select * FROM tbl_login WHERE UPPER(user) = UPPER('" + super.getSearch()+ "');";
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
        String sql = "DELETE FROM tbl_login WHERE UPPER(user) = UPPER('" + super.getUser()+  "');";
        return connexion.delete(sql);
    }

    public String edit() {
        String sql = "UPDATE tbl_login SET passwordu='" + super.getPasswordu()+ "',description='" + super.getDescription()+"',isadmin='" + super.getIsAdmin()+  "' WHERE UPPER(user) = UPPER('" + super.getUser() + "');";
        return connexion.edit(sql);
    }

    public DefaultTableModel list() {
        String[] columnName = {"Usurio", "Contraseña", "Descripción", "Fecha de registro", "Fecha de último ingreso", "Es administrador"};
        DefaultTableModel tblModel = new DefaultTableModel(columnName, 0){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        try {
            ResultSet result = null;
            String sql = "Select users, passwordu, description, date_register, date_in, isadmin FROM public.tbl_login;";
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
