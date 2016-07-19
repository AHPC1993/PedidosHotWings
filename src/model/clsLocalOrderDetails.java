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
public class clsLocalOrderDetails {
    private String order_number;
    private String product_id;
    private String additional_products_id;
    private String product_name;
    private String product_description;
    private double product_price;
    private double product_amount;
    private double product_price_total;
    private String notes;
    private String search;
    private String localOrder_id;

    public clsLocalOrderDetails() {
    }

    public clsLocalOrderDetails(String order_number, String product_id, String additional_products_id, String product_name, String product_description, double product_price, double product_amount, double product_price_total, String notes, String search, String localOrder_id) {
        this.order_number = order_number;
        this.product_id = product_id;
        this.additional_products_id = additional_products_id;
        this.product_name = product_name;
        this.product_description = product_description;
        this.product_price = product_price;
        this.product_amount = product_amount;
        this.product_price_total = product_price_total;
        this.notes = notes;
        this.search = search;
        this.localOrder_id = localOrder_id;
    }


 

    public String getOrder_number() {
        return order_number;
    }

    public void setOrder_number(String order_number) {
        this.order_number = order_number;
    }


    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getProduct_description() {
        return product_description;
    }

    public void setProduct_description(String product_description) {
        this.product_description = product_description;
    }

  

    public String getProduct_id() {
        return product_id;
    }

    public void setProduct_id(String product_id) {
        this.product_id = product_id;
    }

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public double getProduct_price() {
        return product_price;
    }

    public void setProduct_price(double product_price) {
        this.product_price = product_price;
    }

    public double getProduct_amount() {
        return product_amount;
    }

    public void setProduct_amount(double product_amount) {
        this.product_amount = product_amount;
    }

    public double getProduct_price_total() {
        return product_price_total;
    }

    public void setProduct_price_total(double product_price_total) {
        this.product_price_total = product_price_total;
    }

    public String getLocalOrder_id() {
        return localOrder_id;
    }

    public void setLocalOrder_id(String localOrder_id) {
        this.localOrder_id = localOrder_id;
    }

    public String getAdditional_products_id() {
        return additional_products_id;
    }

    public void setAdditional_products_id(String additional_products_id) {
        this.additional_products_id = additional_products_id;
    }
    
    
}
