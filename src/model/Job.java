/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author CM <2222cm@gmail.com>
 */
public class Job {

    private int id;
    private String noteNo;
    private int customerID;
    private String date;
    private int itemTypeID;
    private int brandID;
    private String model;
    private String serialNo;
    private int times;
    private String errorDesc;
    private String notes;

    public Job(int id, String noteNo, int customerID, String date, int itemTypeID, int brandID, String model, String serialNo, int times, String errorDesc, String notes) {
        this.id = id;
        this.noteNo = noteNo;
        this.customerID = customerID;
        this.date = date;
        this.itemTypeID = itemTypeID;
        this.brandID = brandID;
        this.model = model;
        this.serialNo = serialNo;
        this.times = times;
        this.errorDesc = errorDesc;
        this.notes = notes;
    }

    public int getID() {
        return id;
    }

    public void setID(int id) {
        this.id = id;
    }

    public String getNoteNo() {
        return noteNo;
    }

    public void setNoteNo(String noteNo) {
        this.noteNo = noteNo;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getItemTypeID() {
        return itemTypeID;
    }

    public void setItemTypeID(int itemTypeID) {
        this.itemTypeID = itemTypeID;
    }

    public int getBrandID() {
        return brandID;
    }

    public void setBrandID(int brandID) {
        this.brandID = brandID;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(String serialNo) {
        this.serialNo = serialNo;
    }

    public int getTimes() {
        return times;
    }

    public void setTimes(int times) {
        this.times = times;
    }

    public String getErrorDesc() {
        return errorDesc;
    }

    public void setErrorDesc(String errorDesc) {
        this.errorDesc = errorDesc;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
