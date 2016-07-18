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
public class clsAdditionalProducts {
    private String id_additional_products;
    private String namep;
    private String description;
    private double price;
    private String notes;
    private String id_temp;

    public clsAdditionalProducts() {
    }

    public clsAdditionalProducts(String id_additional_products, String namep, String description, double price, String notes, String id_temp) {
        this.id_additional_products = id_additional_products;
        this.namep = namep;
        this.description = description;
        this.price = price;
        this.notes = notes;
        this.id_temp = id_temp;
    }

    public String getId_additional_products() {
        return id_additional_products;
    }

    public void setId_additional_products(String id_additional_products) {
        this.id_additional_products = id_additional_products;
    }

    public String getNamep() {
        return namep;
    }

    public void setNamep(String namep) {
        this.namep = namep;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getId_temp() {
        return id_temp;
    }

    public void setId_temp(String id_temp) {
        this.id_temp = id_temp;
    }
    
    
}
