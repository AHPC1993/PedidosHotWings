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
public class clsEmployees {
    private String document_id;
    private String namee;
    private String lastname;
    private String job;
    private String phone;
    private String notes;
    private String local_id;
    private String address;
    private String doc_temp;

    public clsEmployees() {
    }

    public clsEmployees(String document_id, String namee, String lastname, String job, String phone, String notes, String local_id, String address, String doc_temp) {
        this.document_id = document_id;
        this.namee = namee;
        this.lastname = lastname;
        this.job = job;
        this.phone = phone;
        this.notes = notes;
        this.local_id = local_id;
        this.address = address;
        this.doc_temp = doc_temp;
    }



    public String getDocument_id() {
        return document_id;
    }

    public void setDocument_id(String document_id) {
        this.document_id = document_id;
    }

    public String getNamee() {
        return namee;
    }

    public void setNamee(String namee) {
        this.namee = namee;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
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

    public String getLocal_id() {
        return local_id;
    }

    public void setLocal_id(String local_id) {
        this.local_id = local_id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDoc_temp() {
        return doc_temp;
    }

    public void setDoc_temp(String doc_temp) {
        this.doc_temp = doc_temp;
    }
    
    
}
