/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;
import Model.Database;
import java.sql.SQLException;


/**
 *
 * @author silkroad
 */
public class Login extends Person {
    
    Database database = new Database();
     public Login() {

    }

    public void setUserNameAdmin(String user) {
        this.userNameAdmin = user;
    }

    public void setPassAdmin(String pass) {
        this.passAdmin = pass;
    }

    public void setUserNameEmployee(String user) {
        this.userNameEmployee = user;
    }

    public void setPassEmployee(String pass) {
        this.passEmployee = pass;
    }
  
    public String getUserNameAdmin() {
        return this.userNameAdmin;
    }

    public String getPassAdmin() {
        return this.passAdmin;
    }

    public String getUserNameEmployee() {
        return this.userNameEmployee;
    }

    public String getPassEmployee() {
        return this.passEmployee;
    }
    
    public void ResetLoginInfo(String Name, String Password) throws SQLException, ClassNotFoundException{
        database.ResetLoginInfo(Name, Password);
    }
    
    public void RetrieveAdminLogin(Login user) throws ClassNotFoundException, SQLException{
        database.RetrieveAdminLogin(user);
    }
    
    public void RetrieveEmployeeLogin(Login user) throws ClassNotFoundException, SQLException{
        database.RetrieveEmployeeLogin(user);
    }
    
       
    @Override
    public String toString() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
