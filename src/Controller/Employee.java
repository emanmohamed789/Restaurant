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
 * @author Pc
 */
public class Employee {

    private int id;
    private String fname;
    private String depart;
    private double salary;
    private double bonus;

    Database database = new Database();
    
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

    public void setFirstName(String firstName) {
        this.fname = firstName;
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
    
    public void AddEmployee(String employeeName, String department, double salary, double bonus) throws Exception{
        database.saveEmployee(employeeName, department, salary, bonus);
    }
    
    public void DeleteEmployee(int ID) throws IOException, ClassNotFoundException, SQLException{
        database.deleteEmployee(ID);
    }
    
    public void UpdateEmployee(int id, String employeeName, String department, double salary, double bonus) throws Exception{
        database.updateEmployee(id, employeeName, department, salary, bonus);
    }
    
    public void RetrieveLastEmployeeID(JLabel jLabelID) throws ClassNotFoundException, SQLException{
        database.RetrieveLastEmployeeID(jLabelID);
    }
    
    public void RetrieveListofEmployees(DefaultTableModel model) throws ClassNotFoundException, SQLException{
        database.RetrieveListofEmployees(model);
    }
    
    public int SearchEmployee(JTextField jTextEmployeeID) throws IOException, ClassNotFoundException, SQLException, Exception{
       return database.SearchEmployee(jTextEmployeeID);
    }
    
    public void RetrieveEmployeeID(int ID) throws Exception{
        database.RetrieveEmployeeID(ID);
    }
    
}
