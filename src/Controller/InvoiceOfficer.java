/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import View.Billing;
import javax.swing.JTextField;
import Model.Database;

/**
 *
 * @author silkroad
 */
public class InvoiceOfficer {
    
    private int Quantity;
    private String order;
    double Price;
    private double totalCost;
    private double totalBill;
    private final double tax;
    private final double tip;
    private double taxAmount;
    private double tipAmount;
    private int ID;
    
   // Database database = new Database();

    public InvoiceOfficer() {
        this.tax = 0.0675;
        this.tip = 0.2;
    }

    public int getQuantity() {
        return Quantity;
    }

    public String getOrder() {
        return order;
    }

    public void setQuantity(int Quantity) {
        this.Quantity = Quantity;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public void setPrice(double Price) {
        this.Price = Price;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }

    public void setTotalBill(double totalBill) {
        this.totalBill = totalBill;
    }

    public void setTaxAmount(double taxAmount) {
        this.taxAmount = taxAmount;
    }

    public void setTipAmount(double tipAmount) {
        this.tipAmount = tipAmount;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public double getPrice() {
        return Price;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public double getTotalBill() {
        return totalBill;
    }

    public double getTaxAmount() {
        return taxAmount;
    }

    public double getTipAmount() {
        return tipAmount;
    }

    public int getID() {
        return ID;
    }
    
    
    public double CalculateBill(int Quantity,double Price){
        taxAmount = tax * Price;
        totalCost = (Price * Quantity) + taxAmount;
        tipAmount = tip * totalCost;
        totalBill = tipAmount + totalCost;
        return totalBill;
    }
}
