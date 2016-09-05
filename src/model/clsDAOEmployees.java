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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author GSG
 */
public class clsDAOEmployees extends clsEmployees {

    controller.Connect connexion;

    public clsDAOEmployees() {
        connexion = new Connect();
    }

    /**
     * Método encargado de insertar empleados en la base de datos del sistema.
     *
     * @return
     */
    public boolean insert() {
        String sql = "INSERT INTO public.tbl_employees(employee_id, document_id, namee, lastname, job, phone, notes,local_id, address)  VALUES (nextval('SEQ_EMPLOYEES'),'" + super.getDocument_id() + "','" + super.getNamee() + "','" + super.getLastname() + "','" + super.getJob() + "','" + super.getPhone() + "','" + super.getNotes() + "','" + super.getLocal_id() + "','" + super.getAddress() + "');";
        return connexion.insert(sql);
    }

    /**
     * Método encargado de encontrar elementos duplicados en los empleados
     * registrados.
     *
     * @param document
     * @return
     */
    public String findDuplicateEmployees(String document) {
        String sql = "Select * FROM public.tbl_employees WHERE UPPER(document_id) = UPPER('" + document + "');";
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
     * Método encargado de traer información sobre un empleado específico.
     *
     * @return
     */
    public ResultSet search() {
        String sql = "Select * FROM public.tbl_employees WHERE UPPER(document_id)=UPPER('" + super.getDocument_id() + "');";
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

    /**
     * Método encargado de eliminar un empleado.
     *
     * @return
     */
    public String delete() {
        String sql = "DELETE FROM public.tbl_employees WHERE document_id = '" + super.getDocument_id() + "';";
        return connexion.delete(sql);
    }

    /**
     * Método encargado de editar un empleado.
     *
     * @return
     */
    public String edit() {

        String sql = "UPDATE public.tbl_employees SET document_id='" + super.getDocument_id() + "',namee='" + super.getNamee() + "', lastname='" + super.getLastname() + "', job='" + super.getJob() + "', phone='" + super.getPhone() + "', notes='" + super.getNotes() + "', local_id='" + super.getLocal_id() + "', address='" + super.getAddress() + "' WHERE employee_id = '" + super.getDoc_temp() + "';";
        return connexion.edit(sql);
    }

    /**
     * Método encargado de listar todos los empleados que hay en la base de
     * datos.
     *
     * @return
     */
    public DefaultTableModel list() {
        String[] columnName = {"Cédula", "Nombre", "Apellidos", "Puesto", "Teléfono", "Notas", "Local Id", "Dirección"};
        DefaultTableModel tblModel = new DefaultTableModel(columnName, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        try {
            ResultSet result = null;
            String sql = "Select document_id, namee, lastname, job, phone, notes, local_id, address FROM public.tbl_employees order by 2 asc;";
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

}
