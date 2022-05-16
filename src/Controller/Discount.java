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

import java.sql.SQLException;
import Model.Database;



public class Discount {
    
    public double discount;
    private double minimumValue;
    private int amount;
    private boolean valid;
    public String offerday;
    
    Database database = new Database();
    
    public Discount(){
        
        this.discount=0.0;
        this.minimumValue=0.0;
        this.valid=false;
        
    }
    
    public void setdiscount(double discount) throws SQLException {
        this.discount = discount;
        this.valid = true;
       
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
    
    public void AddDiscount(double discount, String offerday) throws ClassNotFoundException, SQLException{
        database.saveDiscount(discount, offerday);
    }
    
    public void RetrieveDiscount(Discount discountObj) throws ClassNotFoundException, SQLException{
        database.RetrieveDiscount(discountObj);
    }
    
}
 
