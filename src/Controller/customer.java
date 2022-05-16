/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package Controller;
import Model.Database;
import java.io.IOException;
import java.sql.SQLException;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author hp
 */
public class Customer {

    private String Name;
    private int id;
    private int phone;
    private String address;
    private String email;
    Database database = new Database();
    
    public Customer() {
    }

    public String getName() {
        return Name;
    }

    public int getId() {
        return id;
    }

    public int getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }
    
    public String getEmail() {
        return email;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public void AddCustomer(int Id, String customerName, String Address, int Phone, String Email) throws Exception{
        database.saveCustomer(Id, customerName, Address, Phone, Email);
    }
    
    public void DisplayCustomers(DefaultTableModel model) throws ClassNotFoundException, SQLException{
        database.RetrieveListOfCustomers(model);
    }
    
    public void UpdateCustomer(String name, String address, int phone, String email, String id) throws IOException, ClassNotFoundException, SQLException{
        database.updateCustomer(name, address, phone, email, id);
    }
    
    public void DeleteCustomer(int id) throws SQLException, ClassNotFoundException{
        database.deleteCustomer(id);
    }
    
    public void GenerateCustomerID(int id, JLabel label) throws SQLException, ClassNotFoundException{
        database.GenerateCustomerID(id, label);
    }
    
    public int SearchCustomer(JTextField jTextID, JTextField jTextName,JTextField jTextAddress, JTextField jTextPhone, JTextField jTextEmail) throws SQLException, ClassNotFoundException{
        return database.SearchCustomer(jTextID, jTextName, jTextAddress, jTextPhone, jTextEmail);
    }
}