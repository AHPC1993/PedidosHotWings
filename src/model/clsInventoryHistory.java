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
public class clsInventoryHistory {

    private String history_id;
    private String inventory_id;
    private String nameProduct;
    private double amountIn;
    private double amountOut;
    private String dateUpdate;
    private String search;

    public clsInventoryHistory() {
    }

    public clsInventoryHistory(String history_id, String inventory_id, String nameProduct, double amountIn, double amountOut, String dateUpdate, String search) {
        this.history_id = history_id;
        this.inventory_id = inventory_id;
        this.nameProduct = nameProduct;
        this.amountIn = amountIn;
        this.amountOut = amountOut;
        this.dateUpdate = dateUpdate;
        this.search = search;
    }

  

    public String getHistory_id() {
        return history_id;
    }

    public void setHistory_id(String history_id) {
        this.history_id = history_id;
    }

    public String getInventory_id() {
        return inventory_id;
    }

    public void setInventory_id(String inventory_id) {
        this.inventory_id = inventory_id;
    }

    public double getAmountIn() {
        return amountIn;
    }

    public void setAmountIn(double amountIn) {
        this.amountIn = amountIn;
    }

    public double getAmountOut() {
        return amountOut;
    }

    public void setAmountOut(double amountOut) {
        this.amountOut = amountOut;
    }

    public String getDateUpdate() {
        return dateUpdate;
    }

    public void setDateUpdate(String dateUpdate) {
        this.dateUpdate = dateUpdate;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }

}
