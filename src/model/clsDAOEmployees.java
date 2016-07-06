/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import controller.Connect;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author GSG
 */
public class clsDAOEmployees extends clsEmployees {

    controller.Connect connexion;

    public clsDAOEmployees() {
        connexion = new Connect();
    }

    public boolean insert() {
        String sql = "INSERT INTO public.tbl_employees(employee_id, document_id, namee, lastname, job, phone, notes,local_id, address)  VALUES (nextval('SEQ_EMPLOYEES'),'" + super.getDocument_id() + "','" + super.getNamee() + "','" + super.getLastname() + "','" + super.getJob() + "','" + super.getPhone() + "','" + super.getNotes() + "','" + super.getLocal_id() + "','"+super.getAddress()+"');";
        return connexion.insert(sql);
    }
    
    public ResultSet search(){
        String sql = "Select * FROM public.tbl_employees WHERE document_id='"+super.getDocument_id()+"';";
        ResultSet results = null;
        results = connexion.search(sql);
        try {
            if(results.next()){
                return results;
            //return results.getString(2);//Segundo valor.
            }else{
              //  return "El empleado que usted está buscando no existe, por favor verifique nuevamente.";
                return null;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }
    
    public String delete(){
        String sql = "DELETE FROM public.tbl_employees WHERE document_id = '"+super.getDocument_id()+"';";
        return connexion.delete(sql);
    }
    
      public String edit(){
        String sql = "UPDATE FROM public.tbl_employees WHERE document_id = '"+super.getDocument_id()+"';";
      //  return connexion.delete(sql);
      return null;
    }

}
