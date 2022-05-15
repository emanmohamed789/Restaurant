/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.util.*;
import java.io.*;
import java.util.*;
import java.util.InputMismatchException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.*;
import javax.swing.JOptionPane;


/**
 *
 * @author Pc
 */
public class Employee {

    private int id;
    private String fname;
    private String depart;
    private double salary;
    private double bonus;
    static final String drive = "com.mysql.cj.jdbc.Driver";
    static final String url = "jdbc:mysql://localhost/restaurant";
    static final String name = "root";
    static final String password = "";
    public Employee() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getDepart() {
        return depart;
    }

    public void setDepart(String depart) {
        this.depart = depart;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

   

    


    
//    public void updateEmployee(String idd, String namee, String departt, String salaryy, String bonuss) throws Exception {
//        Connection con = null;
//        Statement stmt = null;
//        try {
//            Class.forName(drive);
//            con = DriverManager.getConnection(url, name, password);
//            if (con != null) {
//                System.out.println("connected");
//            }
//            stmt = con.createStatement();
//            String q = "UPDATE Employee SET firstName='" + namee + "',department='" + departt + "',salary='" + salaryy + "',bonus='" + bonuss + "' WHERE ID='" + idd + "'";
//            stmt.executeUpdate(q);
//
//            stmt.close();
//            con.close();
//
//        } catch (ClassNotFoundException | SQLException e) {
//            System.out.println(e.getMessage());
//        }
//    }


    public void searchEmployee(int idd) throws Exception {
        Connection con = null;
        Statement stmt = null;
        try {
            Class.forName(drive);
            con = DriverManager.getConnection(url, name, password);
            if (con != null) {
                System.out.println("connected");
            }
            stmt = con.createStatement();
            String q = "SELECT  * FROM Employee WHERE ID='" + idd + "'";
            ResultSet result = stmt.executeQuery(q);
            while (result.next()) {
                System.out.println(result.getInt("ID") + " " + result.getString("firstName") + " " + result.getString("department") + " " + result.getDouble("salary") + " " + result.getDouble("bonus") + "\n");

            }
            stmt.close();
            con.close();

        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void displayEmployee() throws IOException {
        Connection con = null;
        Statement stmt = null;
        try {
            Class.forName(drive);
            con = DriverManager.getConnection(url, name, password);
            if (con != null) {
                System.out.println("connected");
            }
            stmt = con.createStatement();
            String q = "SELECT * FROM Employee";
            ResultSet result = stmt.executeQuery(q);
            while (result.next()) {
                System.out.println(result.getInt("ID") + " " + result.getString("firstName") + " " + result.getString("department") + " " + result.getDouble("salary") + " " + result.getDouble("bonus"));
            }
            stmt.close();
            con.close();

        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
