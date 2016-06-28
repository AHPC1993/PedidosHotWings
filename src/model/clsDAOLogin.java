/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author GSG
 */
public class clsDAOLogin extends clsLogin {
    controller.Connect connexion;

    public clsDAOLogin() {
        connexion = new controller.Connect();      
    }
    
    public boolean validate(){
    String SQL = "SELECT * FROM public.tbl_login WHERE USERS='" + super.getUser() +"' AND PASSWORD='"+ super.getPassword() + "';";
    if(connexion.validateSQL(SQL) == false){
        return false;
    }else{
        return true;
    }
    }
    
    
    
}
