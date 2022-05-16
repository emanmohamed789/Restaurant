/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Database;
import java.sql.SQLException;
import javax.swing.JTextField;

/**
 *
 * @author silkroad
 */
public class Invoice {

    Discount DiscountObject = new Discount();
    Database database = new Database();

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
    double Discount;
    double BillAfterDiscount;
    
    
    public Invoice() {
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
    
     public double getBillAfterDiscount() throws ClassNotFoundException, SQLException {   
        database.RetrieveDiscount(DiscountObject);
        Discount = totalBill * (DiscountObject.getdiscount() / 100);
        BillAfterDiscount = totalBill - Discount;
        return BillAfterDiscount;
    }
     
    public void AddOrder(String Order, int Quantity, double Price, double TotalBill) throws ClassNotFoundException, SQLException{
        database.saveOrder(Order, Quantity, Price, TotalBill);
    } 
    
    public void DeleteOrder(int id) throws ClassNotFoundException, SQLException{
        database.deleteOrder(id);
    }
    
    public int SearchOrder(JTextField jTextOrder, JTextField jTextPrice) throws ClassNotFoundException, SQLException{
        return database.searchOrder(jTextOrder, jTextPrice);
    }
    
}
