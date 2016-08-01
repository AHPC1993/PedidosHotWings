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
public class clsInventory {

    private String inventory_id;
    private String nameProduct;
    private double TotalAmount;
    private String notes;
    private String search;

    public clsInventory() {
    }

    public clsInventory(String inventory_id, String nameProduct, double TotalAmount, String notes, String search) {
        this.inventory_id = inventory_id;
        this.nameProduct = nameProduct;
        this.TotalAmount = TotalAmount;
        this.notes = notes;
        this.search = search;
    }

 
  

    public String getInventory_id() {
        return inventory_id;
    }

    public void setInventory_id(String inventory_id) {
        this.inventory_id = inventory_id;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public double getTotalAmount() {
        return TotalAmount;
    }

    public void setTotalAmount(double TotalAmount) {
        this.TotalAmount = TotalAmount;
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
