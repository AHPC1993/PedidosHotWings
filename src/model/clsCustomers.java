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
public class clsCustomers {
    private String customers_id;
    private String document_id;
    private String namec;
    private String lastname;
    private String address;
    private String neighborhood;
    private String town;
    private String city;
    private String phone;
    private String notes;
    private String search;

    public clsCustomers() {
    }

    public clsCustomers(String customers_id, String document_id, String namec, String lastname, String address, String neighborhood, String town, String city, String phone, String notes, String search) {
        this.customers_id = customers_id;
        this.document_id = document_id;
        this.namec = namec;
        this.lastname = lastname;
        this.address = address;
        this.neighborhood = neighborhood;
        this.town = town;
        this.city = city;
        this.phone = phone;
        this.notes = notes;
        this.search = search;
    }

  

    public String getCustomers_id() {
        return customers_id;
    }

    public void setCustomers_id(String customers_id) {
        this.customers_id = customers_id;
    }

    public String getDocument_id() {
        return document_id;
    }

    public void setDocument_id(String document_id) {
        this.document_id = document_id;
    }

    public String getNamec() {
        return namec;
    }

    public void setNamec(String namec) {
        this.namec = namec;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhoos(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }
    
    
    
    
}
