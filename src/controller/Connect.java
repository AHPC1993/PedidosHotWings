/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author GSG
 */
public class Connect {
    static String user = "hotwings";
    static String password = "hotwings";
    static String data_base = "dbHotWings";
    static String stringConnection = "jdbc:postgresql://127.0.0.1/" + data_base + "?" + "user=" + user + "&password=" + password;
    Connection connection = null;
    Statement sentence = null;
    ResultSet result;

    public Connect() {
        try {
            try {
                Class.forName("org.postgresql.Driver");
                System.out.println("Se cargó correctamente el driver");
            } catch (ClassNotFoundException e) {
                System.out.println("Error cargando driver");
            }
            connection = DriverManager.getConnection(stringConnection);
            System.out.println("Se cargó correctamente la conexión");
        } catch (SQLException e) {
            System.out.println("Error cargando base de datos");
        }
    }
    
    public boolean validateSQL(String sql){
        ResultSet result = null;
        try{
            sentence = connection.createStatement();
            result = sentence.executeQuery(sql);
            if(result.next()){
                System.out.println("Encontré algo");
                return true;
            }else{
                System.out.println("No encontré nada");
                return false;
            }
        } catch (SQLException ex) {
            System.out.println("Error en la consulta " + sql);
        }
        return false;
    }

 
}
