/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.*;
import java.util.*;
import javax.swing.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author silkroad
 */
public class Bill {

    static final String drive = "com.mysql.cj.jdbc.Driver";
    static final String url = "jdbc:mysql://localhost/project";
    static final String name = "omnia";
    static final String password = "Omnia123";
    private ArrayList<String> order;
    private ArrayList<Integer> Quantity;
    String[] meals = {"rice", "coffee", "french fries", "salad"};
    double[] cost = {25.5, 10.2, 5.6, 15};
    double Price;

    public Bill() {
        order = new ArrayList<String>();
        Quantity = new ArrayList<Integer>();
        this.tax = 0.0675;
        this.tip = 0.2;
    }

    private double totalCost;
    private double totalBill;
    private final double tax;
    private final double tip;
    private double taxAmount;
    private double tipAmount;
    private int ID;

    public void setOrder(ArrayList<String> order) {
        this.order = order;
    }

    public void setQuantity(ArrayList<Integer> Quantity) {
        this.Quantity = Quantity;
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

    public void setFrame(JFrame frame) {
        this.frame = frame;
    }

    public double getTotalBill() {
        return totalBill;
    }

    public double getTipAmount() {
        return tipAmount;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public double getTaxAmount() {
        return taxAmount;
    }

    public int getID() {
        return ID;
    }

    public double[] getCost() {
        return cost;
    }

    /*public void MakeOrder(String meal, int quantity) {

        order.add(meal);
        Quantity.add(quantity);
        for (int i = 0; i < meals.length; i++) {
            if (meal.equals(meals[i])) {
                taxAmount = tax * cost[i];
                totalCost += (cost[i] * quantity) + taxAmount;
                tipAmount = tip * totalCost;
                totalBill = tipAmount + totalCost;

            }
        }
        Connection con = null;
        Statement stmt = null;
        try {
            Class.forName(drive);
            con = DriverManager.getConnection(url, name, password);
            if (con != null) {
                System.out.println("connected");
            }
            stmt = con.createStatement();
            String query = "INSERT INTO billing (FoodOrder,Quantity,TotalCost,TaxAmount,TipAmount,TotalBill) VALUES ('" + order + "','" + Quantity + "','" + totalCost + "','" + taxAmount + "','" + tipAmount + "','" + totalBill + "')";
            stmt.executeUpdate(query);
            con.close();

        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
        }
    }*/
    public void MakeOrder(int quantity,double price){
        this.taxAmount = tax * price;
        this.totalCost += (price * quantity) + taxAmount;
        this.tipAmount = tip * totalCost;
        this.totalBill = tipAmount + totalCost;
    }
    public ArrayList<String> getOrder() {
        int i;
        for (i = 0; i < order.size(); i++) {
            System.out.println(order.get(i));
        }
        return order;
    }

    public ArrayList<Integer> getQuantity() {
        int i;
        for (i = 0; i < Quantity.size(); i++) {
            System.out.println(Quantity.get(i));
        }

        return Quantity;
    }

    public void cancelOrder(int id) {
        this.ID = id;
        Connection con = null;
        Statement stmt = null;
        try {
            Class.forName(drive);
            con = DriverManager.getConnection(url, name, password);
            if (con != null) {
                System.out.println("connected");
            }
            stmt = con.createStatement();
            String query = "DELETE FROM billing WHERE ID ='" + ID + "'";
            stmt.executeUpdate(query);
            con.close();

        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    private JFrame frame;

    public void iExitSystem() {
        frame = new JFrame("Exit");
        if (JOptionPane.showConfirmDialog(frame, "Confirm if you want to exit", "Billing",
                JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION) {
            System.exit(0);
        }
    }

}
