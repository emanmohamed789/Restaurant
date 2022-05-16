/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import Controller.Discount;
import Controller.Login;
import java.io.IOException;
import java.sql.ResultSet;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author LapTop.10
 */
public class Database {

    static final String drive = "com.mysql.cj.jdbc.Driver";
    static final String url = "jdbc:mysql://localhost/restaurantsystem";
    static final String name = "root";
    static final String password = "";

    Connection con = null;
    Statement stmt = null;

    public Database() {

    }

    public Connection getDatabaseConnection() throws ClassNotFoundException {
        try {
            Class.forName(drive);
            con = DriverManager.getConnection(url, name, password);
            if (con != null) {
                System.out.println("connected");
                return con;
            }
            stmt = con.createStatement();
        } catch (SQLException e) {
            System.out.println(e.getMessage());

        }
        return null;
    }

    public void RetrieveAdminLogin(Login user) throws ClassNotFoundException, SQLException {
        Connection con = this.getDatabaseConnection();
        stmt = con.createStatement();
        String q = "SELECT username, password FROM login";
        java.sql.ResultSet result = stmt.executeQuery(q);
        result.next();
        user.setUserNameAdmin(result.getString("username"));
        user.setPassAdmin(result.getString("password"));
        con.close();
    }

    public void RetrieveEmployeeLogin(Login user) throws ClassNotFoundException, SQLException {
        Connection con = this.getDatabaseConnection();
        stmt = con.createStatement();
        String q = "SELECT username, password FROM login";
        java.sql.ResultSet result = stmt.executeQuery(q);
        result.next();
        result.next();
        user.setUserNameEmployee(result.getString("username"));
        user.setPassEmployee(result.getString("password"));
        con.close();
    }
    
    public void ResetLoginInfo(String userName, String password) throws SQLException, ClassNotFoundException {
        int id = 1;
        Connection con = this.getDatabaseConnection();
        stmt = con.createStatement();
        String q = "UPDATE login SET username='" + userName + "',password='" + password + "' WHERE ID='" + id + "'";
        stmt.executeUpdate(q);
        stmt.close();
        con.close();
    }

    public void saveOrder(String Order, int Quantity, double Price, double TotalBill) throws ClassNotFoundException, SQLException {
        Connection con = this.getDatabaseConnection();
        stmt = con.createStatement();
        String query = "INSERT INTO billing (FoodOrder,Quantity,price,TotalBill) VALUES ('" + Order + "','" + Quantity + "','" + Price + "','" + TotalBill + "')";
        stmt.executeUpdate(query);
        con.close();

    }

    public void deleteOrder(int id) throws ClassNotFoundException, SQLException {
        Connection con = this.getDatabaseConnection();
        stmt = con.createStatement();
        String query = "DELETE FROM billing WHERE ID ='" + id + "'";
        stmt.executeUpdate(query);
        con.close();
    }

    public int searchOrder(JTextField jTextOrder, JTextField jTextPrice) throws ClassNotFoundException, SQLException {
        int checkid = 0;
        String Order = jTextOrder.getText();
        Connection con = this.getDatabaseConnection();
        stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("select *from meals where Name='" + Order + "'");
        while (rs.next()) {
            checkid = 1;
            jTextOrder.setEditable(false);
            jTextPrice.setText(rs.getString(3));
        }
        return checkid;
    }

//Discount
    public void saveDiscount(double discount, String offerday) throws ClassNotFoundException, SQLException {

        Connection con = this.getDatabaseConnection();
        stmt = con.createStatement();
        String query = "INSERT INTO discount (discount,offerday) VALUES ('" + discount + "','" + offerday + "')";
        stmt.executeUpdate(query);
        con.close();

    }

    public void RetrieveDiscount(Discount discountObj) throws ClassNotFoundException, SQLException {

        Connection con = this.getDatabaseConnection();

        stmt = con.createStatement();
        String q = "SELECT discount,offerday FROM discount";
        java.sql.ResultSet result = stmt.executeQuery(q);
        while (result.next()) {
            discountObj.setdiscount(Double.parseDouble(result.getString("discount")));
            discountObj.setOfferday(result.getString("offerday"));
        }

        con.close();

    }

//Meal
    public void saveMeal(String Name, double Price) throws Exception {

        Connection con = this.getDatabaseConnection();
        stmt = con.createStatement();
        String query = "INSERT INTO `meals` (ID,Name,Price) VALUES (null,'" + Name + "','" + Price + "')";
        stmt.executeUpdate(query);
        stmt.close();
        con.close();

    }

    public int mealExists(int ID) throws ClassNotFoundException, SQLException, Exception {
        int check_id = 0;
        Connection con = this.getDatabaseConnection();
        stmt = con.createStatement();
        String q = "SELECT  * FROM meals WHERE ID='" + ID + "'";
        ResultSet result = stmt.executeQuery(q);

        while (result.next()) {
            check_id = 1;
        }

        stmt.close();
        con.close();
        return check_id;
    }

    public void deleteMeal(int ID) throws IOException, ClassNotFoundException, SQLException {

        Connection con = this.getDatabaseConnection();
        stmt = con.createStatement();

        String q = "DELETE From meals WHERE ID='" + ID + "'";

        stmt.executeUpdate(q);
        stmt.close();
        con.close();

    }

    public void RetrieveListOfMeals(DefaultTableModel model) throws ClassNotFoundException, SQLException {

        Connection con = this.getDatabaseConnection();
        stmt = con.createStatement();
        String q = "SELECT * FROM meals";
        ResultSet result = stmt.executeQuery(q);
        while (result.next()) {
            model.addRow(new Object[]{result.getString(1), result.getString(2), result.getString(3)});

        }
    }

    public void updateMeal(String Name2, double Price2, int ID) throws Exception {

        Connection con = this.getDatabaseConnection();
        stmt = con.createStatement();
        String q = "UPDATE  meals   SET Name='" + Name2 + "',Price='" + Price2 + "' where ID='" + ID + "'";
        stmt.executeUpdate(q);
        stmt.close();
        con.close();
    }

    //Customers  
    public void saveCustomer(int Id, String customerName, String Address, int Phone, String Email) throws Exception {

        Connection con = this.getDatabaseConnection();
        stmt = con.createStatement();
        String query = "INSERT INTO customer (name,address,phone,email) VALUES ('" + customerName + "','" + Address + "','" + Phone + "','" + Email + "')";
        stmt.executeUpdate(query);
        stmt.close();
        con.close();
    }

    public void RetrieveListOfCustomers(DefaultTableModel model) throws ClassNotFoundException, SQLException {

        Connection con = this.getDatabaseConnection();
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("select * from customer");
        while (rs.next()) {
            model.addRow(new Object[]{rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5)});
        }

    }

    public void updateCustomer(String name, String address, int phone, String email, String id) throws IOException, ClassNotFoundException, SQLException {
        Connection con = this.getDatabaseConnection();
        stmt = con.createStatement();
        String q = "UPDATE  customer  SET name='" + name + "',address='" + address + "',phone='" + phone + "',email='" + email + "' where id='" + id + "'";
        stmt.executeUpdate(q);
        stmt.close();
        con.close();

    }

    public void deleteCustomer(int id) throws SQLException, ClassNotFoundException {
        Connection con = this.getDatabaseConnection();
        Statement st = con.createStatement();
        st.executeUpdate("delete from customer where id='" + id + "'");
        JOptionPane.showMessageDialog(null, "Successfully Deleted");

    }

    public void GenerateCustomerID(int id, JLabel label) throws SQLException, ClassNotFoundException {
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


    public int SearchCustomer(JTextField jTextID, JTextField jTextName,
        JTextField jTextAddress, JTextField jTextPhone, JTextField jTextEmail) throws SQLException, ClassNotFoundException {
        int check_id = 0;
        Connection con = this.getDatabaseConnection();
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("select *from customer where id='" + jTextID.getText() + "'");
        while (rs.next()) {
            check_id = 1;
            jTextID.setEditable(false);
            jTextName.setText(rs.getString(2));
            jTextAddress.setText(rs.getString(3));
            jTextPhone.setText(rs.getString(4));
            jTextEmail.setText(rs.getString(5));
        }
        return check_id;
    }

//Employee
    public void saveEmployee(String employeeName, String department, double salary, double bonus) throws Exception {
        Connection con = this.getDatabaseConnection();
        stmt = con.createStatement();
        String query = "INSERT INTO `Employee` (ID,firstName,department,salary,bonus) VALUES (null,'" + employeeName + "','" + department + "','" + salary + "','" + bonus + "')";
        stmt.executeUpdate(query);
        stmt.close();
        con.close();
    }

    public void deleteEmployee(int ID) throws IOException, ClassNotFoundException, SQLException {
        Connection con = this.getDatabaseConnection();
        stmt = con.createStatement();
        String query = "DELETE FROM Employee WHERE ID='" + ID + "'";
        stmt.executeUpdate(query);
        stmt.close();
        con.close();
    }

    public void RetrieveLastEmployeeID(JLabel jLabelID) throws ClassNotFoundException, SQLException {
        Connection con = this.getDatabaseConnection();
        int id = 1;
        String str1 = String.valueOf(id);
        stmt = con.createStatement();
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("select max(id) from employee");
        while (rs.next()) {
            id = rs.getInt(1);
            id = id + 1;
            String str = String.valueOf(id);
            jLabelID.setText(str);
        }
    }

    public void RetrieveListofEmployees(DefaultTableModel model) throws ClassNotFoundException, SQLException {
        Connection con = this.getDatabaseConnection();
        stmt = con.createStatement();
        String q = "SELECT * FROM employee";
        ResultSet result = stmt.executeQuery(q);
        while (result.next()) {
            model.addRow(new Object[]{result.getString(1), result.getString(2), result.getString(3), result.getString(4), result.getString(5)});
        }
        stmt.close();
        con.close();
    }

    public int SearchEmployee(JTextField jTextEmployeeID) throws IOException, ClassNotFoundException, SQLException, Exception {
        int ID = Integer.parseInt(jTextEmployeeID.getText());
        int check_id = 0;
        Connection con = this.getDatabaseConnection();
        stmt = con.createStatement();
        String q = "SELECT  * FROM Employee WHERE ID='" + ID + "'";
        ResultSet result = stmt.executeQuery(q);
        while (result.next()) {
            check_id = 1;
            this.RetrieveEmployeeID(ID);
        }
        stmt.close();
        con.close();
        return check_id;

    }

    public void RetrieveEmployeeID(int ID) throws Exception {
        Connection con = this.getDatabaseConnection();
        stmt = con.createStatement();
        String q = "SELECT  * FROM Employee WHERE ID='" + ID + "'";
        ResultSet result = stmt.executeQuery(q);
        while (result.next()) {
            System.out.println(result.getInt("ID") + " " + result.getString("firstName") + " " + result.getString("department") + " " + result.getDouble("salary") + " " + result.getDouble("bonus") + "\n");
        }
        stmt.close();
        con.close();

    }

    public void updateEmployee(int id, String employeeName, String department, double salary, double bonus) throws Exception {
        Connection con = this.getDatabaseConnection();
        stmt = con.createStatement();
        String q = "UPDATE Employee SET firstName='" + employeeName + "',department='" + department + "',salary='" + salary + "',bonus='" + bonus + "' WHERE ID='" + id + "'";
        stmt.executeUpdate(q);
        stmt.close();
        con.close();

    }
}
