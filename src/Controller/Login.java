/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;



/**
 *
 * @author silkroad
 */
public class Login extends person {
   
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
    
       
    @Override
    public String toString() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
