package Controller;

/*import GUI.AddADiscount;
import GUI.AddGift;
import java.awt.Component;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;*/

import View.AddDiscount;
import java.awt.Component;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import Model.Database;



public class Discount {
    
    public double discount;
    private double minimumValue;
    private int amount;
    private boolean valid;

    public String offerday;
    private final String day[]= {"friday","saturday"};
    private boolean OfferNotification;
    private Component AddADiscount;
    
    static final String drive = "com.mysql.cj.jdbc.Driver";
    static final String url = "jdbc:mysql://localhost/restaurant";
    static final String name = "root";
    static final String password = "";
    
    Database database = new Database();
    public Discount(){
        this.discount=0.0;
        this.minimumValue=0.0;
        this.valid=false;
        
    }
    
    public boolean setdiscount(double discount) {
        
        if (this.offerday.equalsIgnoreCase(day[0]) || this.offerday.equalsIgnoreCase(day[1])) {
            
            this.discount = discount;
            this.valid = true;
            database.saveDiscount(discount,offerday);
            
            return true;
        } else {
            
            return false;
        }
    }

    public void setOfferday(String Offerday) {
        this.offerday = Offerday;
    }

    public String getOfferday(){
        return this.offerday;
    }
    
    public double getdiscount (){
        return this.discount;
    }
    
    public boolean isDiscountValid(){
        return this.valid;
    }
    // When offer is added Notify customer
    public void setOfferNotification() {
        if (isDiscountValid()) {
            this.OfferNotification = true;
        }
    }

    public boolean getOfferNotification() {
        return this.OfferNotification;
    }

    
    public void setMinimumValue(double minimumValue){
        this.minimumValue = minimumValue;
    }
    
    public void setAmount(int amount){
        this.amount = amount;
    }
    

    
    public double getMinimumValue(){
        return this.minimumValue;
    }
    
    public int getAmount(){
        return this.amount;
    }
    }
 
