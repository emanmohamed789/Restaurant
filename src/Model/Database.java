/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import Controller.customer;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import Controller.InvoiceOfficer;
import Controller.Discount;
import Controller.Employee;
import Controller.Login;
import Controller.meal;
import java.io.IOException;
import java.sql.ResultSet;
import java.util.Scanner;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author LapTop.10
 */
public class Database {

    static final String drive = "com.mysql.cj.jdbc.Driver";
    static final String url = "jdbc:mysql://localhost/restaurant";
    static final String name = "root";
    static final String password = "";

    public Database() {

    }

    public void RetrieveLoginInfo(Login user) {
        Connection con = null;
        Statement stmt = null;
        try {
            Class.forName(drive);
            con = DriverManager.getConnection(url, "root", "");
            if (con != null) {
                System.out.println("connected");
            }
            stmt = con.createStatement();
            String q = "SELECT username, password FROM login";
            java.sql.ResultSet result = stmt.executeQuery(q);
            result.next();
            user.setUserNameAdmin(result.getString("username"));
            user.setPassAdmin(result.getString("password"));
            result.next();
            user.setUserNameEmployee(result.getString("username"));
            user.setPassEmployee(result.getString("password"));

            con.close();

        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
        }

    }

//Discount
    public void saveDiscount(double discount, String offerday) {
        String forName = "com.mysql.cj.jdbc.Driver";
        try {
            Class.forName(forName);
            System.out.println("Driver Loaded Successfully");
        } catch (ClassNotFoundException ex) {
            System.out.println("Driver Failed To Load Successfully");
            System.out.println(ex.getMessage());
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
            String query = "INSERT INTO discount (discount,offerday) VALUES ('" + discount + "','" + offerday + "')";
            stmt.executeUpdate(query);
            con.close();

        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    //DOESNT WORK
    public void RetrieveDiscount(Discount discountObj) {
        Connection con = null;
        Statement stmt = null;

        try {

            Class.forName(drive);
            con = DriverManager.getConnection(url, name, password);
            if (con != null) {
                System.out.println("connected");
            }
            stmt = con.createStatement();
            String q = "SELECT discount,offerday FROM discount";
            java.sql.ResultSet result = stmt.executeQuery(q);
            while (result.next()) {
                discountObj.discount = Double.parseDouble(result.getString("discount"));
                discountObj.offerday = result.getString("offerday");
            }

            con.close();
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
        }
    }

//Employee
    public void saveEmployee(String name, String department, double salary, double bonus) throws Exception {

        Connection con = null;
        Statement stmt = null;
        try {
            Class.forName(drive);
            con = DriverManager.getConnection(url, name, password);
            if (con != null) {
                System.out.println("connected");
            }
            stmt = con.createStatement();
            String query = "INSERT INTO `Employee` (ID,firstName,department,salary,bonus) VALUES (null,'" + name + "','" + department + "','" + salary + "','" + bonus + "')";
            stmt.executeUpdate(query);
            stmt.close();
            con.close();

        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void deleteEmployee(int ID) throws IOException {
        Connection con = null;
        Statement stmt = null;
        try {
            Class.forName(drive);
            con = DriverManager.getConnection(url, name, password);
            if (con != null) {
                System.out.println("connected");
            }
            stmt = con.createStatement();
            String query = "DELETE FROM Employee WHERE ID='" + ID + "'";
            stmt.executeUpdate(query);
            stmt.close();
            con.close();

        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    public boolean SearchEmployee(JTextField jTextField1) throws IOException, ClassNotFoundException, SQLException, Exception {
        int ID = Integer.parseInt(jTextField1.getText());
        Employee employee = new Employee();
        int checkid = 0;
        java.sql.Connection con = null;
        java.sql.Statement stmt = null;
        Class.forName(drive);
        con = DriverManager.getConnection(url, name, password);
        stmt = con.createStatement();

        String q = "SELECT  * FROM Employee WHERE ID='" + ID + "'";
        ResultSet result = stmt.executeQuery(q);

        while (result.next()) {
            checkid = 1;
            jTextField1.setEditable(false);

            employee.searchEmployee(ID);

        }
        if (checkid == 0) {
            stmt.close();
            con.close();
            return false;
        } else {
            ID = Integer.parseInt(jTextField1.getText());
            stmt.close();
            con.close();
            return true;
        }

    }

    public void updateEmployee(int id, String name, String department, double salary, double bonus) throws Exception {
        Connection con = null;
        Statement stmt = null;
        try {
            Class.forName(drive);
            con = DriverManager.getConnection(url, name, password);
            if (con != null) {
                System.out.println("connected");
            }
            stmt = con.createStatement();
            String q = "UPDATE Employee SET firstName='" + name + "',department='" + department + "',salary='" + salary + "',bonus='" + bonus + "' WHERE ID='" + id + "'";
            stmt.executeUpdate(q);

            stmt.close();
            con.close();

        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
        }
    }

//Meal
    public void saveMeal(String Name, double Price) throws Exception {

        Connection con = null;
        Statement stmt = null;
        try {
            Class.forName(drive);
            con = DriverManager.getConnection(url, name, password);
            if (con != null) {
                System.out.println("connected");
            }
            stmt = con.createStatement();
            String query = "INSERT INTO `meals` (ID,Name,Price) VALUES (null,'" + Name + "','" + Price + "')";
            stmt.executeUpdate(query);
            stmt.close();
            con.close();

        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void searchMeal(JTextField jTextField1, JTextField jTextField2,
            JTextField jTextField3) {
        try {
            int ID = Integer.parseInt(jTextField3.getText());
            meal meal = new meal();
            int checkid = 0;
            java.sql.Connection con = null;
            java.sql.Statement stmt = null;
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, name, password);
            stmt = con.createStatement();

            String q = "SELECT  * FROM meals WHERE ID='" + ID + "'";
            ResultSet result = stmt.executeQuery(q);

            while (result.next()) {
                checkid = 1;
                jTextField3.setEditable(false);

                this.searchID(ID);

            }
            if (checkid == 0) {
                JOptionPane.showMessageDialog(null, "Meal does not Exist");
            } else {
                ID = Integer.parseInt(jTextField3.getText());
                String Name = jTextField1.getText();
                if (Name.equals("")) {
                    JOptionPane.showMessageDialog(null, "Error Input");
                    return;
                }
                double Price = Double.parseDouble(jTextField2.getText());

                this.updateMeal(Name, Price, ID);

                JOptionPane.showMessageDialog(null, "the Meal is Updated sucessfully");
            }
            stmt.close();
            con.close();

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error Input");
        }
    }

//needs simplifying
    public void deleteMeal(int ID, JTextField jTextField1, meal meal) {
        try {
            int checkid = 0;
            java.sql.Connection con = null;
            java.sql.Statement stmt = null;
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, name, password);
            stmt = con.createStatement();

            String q = "SELECT  * FROM meals WHERE ID='" + ID + "'";
            ResultSet result = stmt.executeQuery(q);

            while (result.next()) {
                checkid = 1;
                jTextField1.setEditable(false);

                this.searchID(ID);

            }
            if (checkid == 0) {
                JOptionPane.showMessageDialog(null, "Meal does not Exist");
            } else {
                ID = Integer.parseInt(jTextField1.getText());
                this.delete(ID);

                JOptionPane.showMessageDialog(null, "the Meal is deleted sucessfully");
            }
            stmt.close();
            con.close();

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error Input");
        }
    }

    public void delete(int ID) throws IOException {
        Connection con = null;
        Statement stmt = null;
        try {
            Class.forName(drive);
            con = DriverManager.getConnection(url, name, password);
            if (con != null) {
                System.out.println("connected");
            }
            stmt = con.createStatement();

            String q = "DELETE From meals WHERE ID='" + ID + "'";

            stmt.executeUpdate(q);
            stmt.close();
            con.close();

        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    public void searchID(int tempID) throws Exception {

        Connection con = null;
        Statement stmt = null;
        try {
            Class.forName(drive);
            con = DriverManager.getConnection(url, name, password);

            stmt = con.createStatement();

            String q = "SELECT  * FROM meals WHERE ID='" + tempID + "'";
            ResultSet result = stmt.executeQuery(q);

            stmt.close();
            con.close();

        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    public void DisplayMeal(DefaultTableModel model) {
        Connection con = null;
        Statement stmt = null;
        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, name, password);
            stmt = con.createStatement();
            String q = "SELECT * FROM meals";
            ResultSet result = stmt.executeQuery(q);
            while (result.next()) {

                model.addRow(new Object[]{result.getString(1), result.getString(2), result.getString(3)});

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public void updateMeal(String Name2, double Price2, int ID) throws Exception {
        Connection con = null;
        Statement stmt = null;
        try {
            Class.forName(drive);
            con = DriverManager.getConnection(url, name, password);
            if (con != null) {
                System.out.println("connected");
            }

            stmt = con.createStatement();
            String q = "UPDATE  meals   SET Name='" + Name2 + "',Price='" + Price2 + "' where ID='" + ID + "'";

            stmt.executeUpdate(q);
            stmt.close();
            con.close();

        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    //Customers  
    public void saveCustomer(int Id, String customerName, String Address, int Phone, String Email) throws Exception {
        try {
            Connection con = null;
            Statement stmt = null;
            Class.forName(drive);
            con = DriverManager.getConnection(url, name, password);
            PreparedStatement ps = con.prepareStatement("insert into customer values (?,?,?,?,?,?)");
            ps.setInt(1, Id);
            ps.setString(2, customerName);
            ps.setString(3, Address);
            ps.setInt(4, Phone);
            ps.setString(5, Email);
            ps.setInt(6, 0);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Successfully Saved");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error");
        }
    }

    public void RetrieveListOfCustomers(DefaultTableModel model) {
        try {
            Connection con = this.getDatabaseConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select *from customer");
            while (rs.next()) {
                model.addRow(new Object[]{rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5), rs.getDouble(6)});
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public void updateCustomer(String name, String address, int phone, String email, String id) throws IOException {
        try {
            Connection con = this.getDatabaseConnection();
            PreparedStatement ps = con.prepareStatement("update customer set name=?,address=?,phone=?,email=? where id=?");
            ps.setString(1, name);
            ps.setString(2, address);
            ps.setInt(3, phone);
            ps.setString(4, email);
            ps.setString(5, id);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Successfully Update");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public void deleteCustomer(int id) throws SQLException {
        Connection con = this.getDatabaseConnection();
        Statement st = con.createStatement();
        st.executeUpdate("delete from customer where id='" + id + "'");
        JOptionPane.showMessageDialog(null, "Successfully Deleted");

    }

    public void GenerateCustomerID(int id, JLabel label) throws SQLException {
        //COME BACK ASAP
        Connection con = this.getDatabaseConnection();
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("select max(id) from customer");
        while (rs.next()) {
            id = rs.getInt(1);
            id = id + 1;
            String str = String.valueOf(id);
            label.setText(str);
        }

    }

    public void SearchCustomer(JTextField jTextField1, JTextField jTextField2,
            JTextField jTextField3, JTextField jTextField4, JTextField jTextField5) {
        try {
            int checkid = 0;
            String id = jTextField1.getText();
            customer customer = new customer();
            if (jTextField1.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Error Input,please Enter ID");
                return;
            }
            Connection con = this.getDatabaseConnection();
            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery("select *from customer where id='" + id + "'");

            while (rs.next()) {
                checkid = 1;
                jTextField1.setEditable(false);
                jTextField2.setText(rs.getString(2));
                jTextField3.setText(rs.getString(3));
                jTextField4.setText(rs.getString(4));
                jTextField5.setText(rs.getString(5));
            }
            if (checkid == 0) {
                JOptionPane.showMessageDialog(null, "customer id does not Exist");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public Connection getDatabaseConnection() {
        Connection con = null;
        Statement stmt = null;
        try {
            Class.forName(drive);
            con = DriverManager.getConnection(url, name, password);
            return con;

        } catch (ClassNotFoundException | SQLException e) {
            return null;
        }
    }

}
