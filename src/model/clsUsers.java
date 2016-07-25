/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author allan
 */
public class clsUsers {
    private String user;
    private String passwordu;
    private String repeatPassword;
    private String description;
    private String date_register;
    private String date_in;
    private int isAdmin;
    private String search;

    public clsUsers() {
    }

    public clsUsers(String user, String passwordu, String repeatPassword, String description, String date_register, String date_in, int isAdmin, String search) {
        this.user = user;
        this.passwordu = passwordu;
        this.repeatPassword = repeatPassword;
        this.description = description;
        this.date_register = date_register;
        this.date_in = date_in;
        this.isAdmin = isAdmin;
        this.search = search;
    }


  

 
    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPasswordu() {
        return passwordu;
    }

    public void setPasswordu(String passwordu) {
        this.passwordu = passwordu;
    }

    public String getRepeatPassword() {
        return repeatPassword;
    }

    public void setRepeatPassword(String repeatPassword) {
        this.repeatPassword = repeatPassword;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDate_register() {
        return date_register;
    }

    public void setDate_register(String date_register) {
        this.date_register = date_register;
    }

    public String getDate_in() {
        return date_in;
    }

    public void setDate_in(String date_in) {
        this.date_in = date_in;
    }

    public int getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(int isAdmin) {
        this.isAdmin = isAdmin;
    }

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }
    
    
}
