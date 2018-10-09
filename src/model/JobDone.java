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
public class JobDone {

    private int id;
    private String noteNo;
    private String date;
    private int warranty;
    private String remarks;
    private double cost;
    private double sellingPrice;
    private int technicianID;

    public JobDone(int id, String noteNo, String date, int warranty, String remarks, double cost, double sellingPrice, int technicianID) {
        this.id = id;
        this.noteNo = noteNo;
        this.date = date;
        this.warranty = warranty;
        this.remarks = remarks;
        this.cost = cost;
        this.sellingPrice = sellingPrice;
        this.technicianID = technicianID;
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getWarranty() {
        return warranty;
    }

    public void setWarranty(int warranty) {
        this.warranty = warranty;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public double getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(double sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    public double getTechnicianID() {
        return technicianID;
    }

    public void setTechnicianID(int technicianID) {
        this.technicianID = technicianID;
    }
}
