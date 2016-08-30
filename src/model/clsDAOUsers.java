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
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author allan
 */
public class clsDAOUsers extends clsUsers {

    controller.Connect connexion;

    public clsDAOUsers() {
        connexion = new Connect();
    }

    /**
     * Método encargado de insertar usuarios para el ingreso de la aplicación en
     * la base de datos del sistema.
     *
     * @return
     */
    public boolean insert() {

        String sql = "INSERT INTO tbl_login(users, passwordu, description, date_register, date_in, isadmin) VALUES ('" + super.getUser() + "','" + super.getPasswordu() + "','" + super.getDescription() + "',(SELECT To_timestamp(To_char(current_timestamp, 'YYYY/MM/DD HH:MI:SS'),'YYYY/MM/DD HH:MI:SS')),(SELECT To_timestamp(To_char(current_timestamp, 'YYYY/MM/DD HH:MI:SS'),'YYYY/MM/DD HH:MI:SS')),'" + super.getIsAdmin() + "');";
        return connexion.insert(sql);
    }

    /**
     * Método encargado de encontrar usuarios duplicados en la base de datos.
     *
     * @param productname
     * @return
     */
    public String findDuplicateUsers(String username) {
        String sql = "Select * FROM public.tbl_login WHERE UPPER(users) = UPPER('" + username + "');";
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

    /**
     * Método encargado de traer información sobre un usuario específico.
     *
     * @return
     */
    public ResultSet search() {
        String sql = "Select * FROM tbl_login WHERE UPPER(users) = UPPER('" + super.getSearch() + "');";
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

    /**
     * Método encargado de verificar si un usuario que ha ingresado al sistema
     * tiene el rol de administrador o no.
     *
     * @param user
     * @return
     */
    public String isAdmin(String user) {
        String sql = "Select isadmin from tbl_login WHERE UPPER(users) = UPPER('" + user + "');";
        ResultSet results = null;
        results = connexion.search(sql);
        try {
            if (results.next()) {
                return results.getString(1);
            }
        } catch (SQLException e) {
            System.out.println(e);
            return "Error";
        }
        return null;
    }

    /**
     * Método encargado de eliminar un usuario.
     *
     * @return
     */
    public String delete() {
        String sql = "DELETE FROM tbl_login WHERE UPPER(users) = UPPER('" + super.getSearch() + "');";
        return connexion.delete(sql);
    }

    /**
     * Método encargado de editar un usuario.
     *
     * @return
     */
    public String edit() {
        String sql = "UPDATE tbl_login SET passwordu='" + super.getPasswordu() + "',description='" + super.getDescription() + "',isadmin='" + super.getIsAdmin() + "' WHERE UPPER(users) = UPPER('" + super.getUser() + "');";
        return connexion.edit(sql);
    }

    /**
     * Método encargado de actualizar la última vez que un usuario ingresó.
     *
     * @param user
     * @return
     */
    public String updateLastEntry(String user) {
        String sql = "UPDATE tbl_login SET date_in=(SELECT To_timestamp(To_char(current_timestamp, 'YYYY/MM/DD HH:MI:SS'),'YYYY/MM/DD HH:MI:SS')) WHERE UPPER(users) = UPPER('" + user + "');";
        return connexion.edit(sql);
    }

    /**
     * Método encargado de listar todos los usuarios que hay en el sistema y
     * devolverlos en una tabla.
     *
     * @return
     */
    public DefaultTableModel list() {
        String[] columnName = {"Usuario", "Contraseña", "Descripción", "Fecha de registro", "Fecha de último ingreso", "Es administrador"};
        DefaultTableModel tblModel = new DefaultTableModel(columnName, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        try {
            ResultSet result = null;
            String sql = "Select users, passwordu, description, date_register, date_in, isadmin FROM public.tbl_login order by 1;";
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
