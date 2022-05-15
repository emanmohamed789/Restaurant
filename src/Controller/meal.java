package Controller;

import java.util.*;
import java.io.*;
import java.util.*;
import java.util.InputMismatchException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.*;

public class meal {

    private int ID;
    private String Name;
    private double Price;

    public meal() {
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public void setPrice(double Price) {
        this.Price = Price;
    }

    public String getName() {
        return Name;
    }

    public double getPrice() {
        return Price;
    }

}
