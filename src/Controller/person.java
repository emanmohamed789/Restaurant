/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

/**
 *
 * @author silkroad
 */
public abstract class person {
    

    protected int id;
    protected String userNameAdmin;
    protected String passAdmin;
    protected String userNameEmployee;
    protected String passEmployee;
    protected String fname;
   
    protected double price;
    


   

    public person() {
    }

    public person(String user, String pass, int id, String fname, double price ){
             
        this.id = id;
        this.fname = fname;
        this.price = price;
       
        this.userNameAdmin = user;
        this.passAdmin = pass;
        
    }

    @Override
    public abstract String toString();

    //setter
    public void setID(int id) {
        this.id = id;
    }

    public void setFName(String fname) {
        this.fname = fname;
    }

    public person(double price) {
        this.price = price;
    }

    
    public void setUserName(String userName) {
        this.userNameAdmin = userName;
    }

    public void setPass(String pass) {
        this.passAdmin = pass;
    }

    public void setPrice(double price) {
        this.price = price;
    }

   
    public String getuserName() {
        return this.userNameAdmin;
    }

    public String getPass() {
        return this.passAdmin;
    }

    public int getID() {
        return this.id;
    }

    public String getFName() {
        return this.fname;
    }

   
    public boolean login(String userName, String Pass) {
        if (userName.equals("Admin@yahoo.com") && Pass.equals("12345678")) {
            return true;
        }
        return false;
    }
}
