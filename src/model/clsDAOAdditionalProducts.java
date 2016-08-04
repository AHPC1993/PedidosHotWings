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
public class clsDAOAdditionalProducts extends clsAdditionalProducts {

    controller.Connect connexion;

    public clsDAOAdditionalProducts() {
        connexion = new Connect();
    }

    /**
     * Método encargado de insertar los datos que el usuario selecciona. Estos
     * datos son insertados en la tabla encargada de llevar los productos
     * adicionales
     *
     * @return
     */
    public boolean insert() {

        String sql = "INSERT INTO public.tbl_additional_products(additional_products_id, namep, description, price, notes)VALUES (nextval('SEQ_ADDITIONAL_PRODUCTS'),'" + super.getNamep() + "','" + super.getDescription() + "','" + super.getPrice() + "','" + super.getNotes() + "');";
        return connexion.insert(sql);
    }

    /**
     * Método encargado de encontrar elementos duplicados en los productos
     * adicionales.
     *
     * @param productname
     * @return
     */
    public String findDuplicateAdditionalProducts(String productname) {
        String sql = "Select * FROM public.tbl_additional_products WHERE UPPER(namep) = UPPER('" + productname + "');";
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
     * Método encargado de traer información sobre un producto adicional
     * específico.
     *
     * @return
     */
    public ResultSet search() {
        String sql = "Select * FROM public.tbl_additional_products WHERE UPPER(namep) = UPPER('" + super.getNamep() + "');";
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
     * Método encargado de eliminar un producto adicional.
     *
     * @return
     */
    public String delete() {
        String sql = "DELETE FROM public.tbl_additional_products WHERE UPPER(namep) = UPPER('" + super.getNamep() + "');";
        return connexion.delete(sql);
    }

    /**
     * Método encargado de editar un producto adicional.
     *
     * @return
     */
    public String edit() {

        String sql = "UPDATE public.tbl_additional_products SET namep='" + super.getNamep() + "',description='" + super.getDescription() + "', price='" + super.getPrice() + "', notes='" + super.getNotes() + "' WHERE UPPER(additional_products_id) = UPPER('" + super.getId_additional_products() + "');";
        return connexion.edit(sql);
    }

    /**
     * Método encargado de listar todos los productos adicionales que existen en
     * el sistema.
     *
     * @return
     */
    public DefaultTableModel list() {
        String[] columnName = {"Nombre", "Descripción", "Precio", "Notas"};
        DefaultTableModel tblModel = new DefaultTableModel(columnName, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        try {
            ResultSet result = null;
            String sql = "Select namep, description, price, notes FROM public.tbl_additional_products;";
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
