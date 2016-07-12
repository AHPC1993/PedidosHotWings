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
public class clsCompany {
    private String local_id;
    private String nit;
    private String name;
    private String address;
    private String neighborhood;
    private String town;
    private String city;
    private String search;

    public clsCompany() {
    }

    public clsCompany(String local_id, String nit, String name, String address, String neighborhood, String town, String city, String search) {
        this.local_id = local_id;
        this.nit = nit;
        this.name = name;
        this.address = address;
        this.neighborhood = neighborhood;
        this.town = town;
        this.city = city;
        this.search = search;
    }

    public String getLocal_id() {
        return local_id;
    }

    public void setLocal_id(String local_id) {
        this.local_id = local_id;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public void setNeighborhood(String neighborhood) {
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

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }
    
    
    
    
}
