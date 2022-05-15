
package Controller;


import View.AddMeal;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.*;
import javax.swing.*;
import java.util.*;
import View.Meals;
import View.MainMenu;
import View.billJFrame;




public class ResturantManagmentSystem  {
    static final String drive = "com.mysql.cj.jdbc.Driver";
    static final String url = "jdbc:mysql://localhost/restaurant";
    static final String name = "root";
    static final String password = "";

    public static void main(String[] args) throws Exception {

        new MainMenu().setVisible(true);
    //    new RestaurantSystem.getContentPane().setSize(400, 400);


       
//        
//        
//       
//        
//        meal e=new meal();
//        System.out.println("choose operation:\n1-Add a new meal"
//                + "\n2-Delete a meal"
//                + "\n3-update meal data"
//                + "\n4-search for a meal"
//                + "\n5-list all meals");
//        int choose = input.nextInt();
//        input.nextLine();
//       
//        do {
//            switch (choose) {
//
//                case 1:
//                    System.out.println("Enter the meal's  name: ");
//                    String Name = input.next();
//                    System.out.println("Enter the meal's Price: ");
//                    double Price = input.nextDouble();
//                    e.addMeal(Name, Price);
//                    System.out.println("the meal is added sucessfully");
//
//                    break;
//                case 2:
//                     System.out.println("Enter the meal's ID ");
//                    int ID = input.nextInt();
//                    e.delete(ID);
//                    break;
//                case 3:
//            System.out.println("Enter the meal's  New name: ");
//                    String Name2 = input.next();
//                    System.out.println("Enter the meal's New Price: ");
//                    double Price2 = input.nextDouble();
//                     System.out.println("Enter the meal's ID ");
//                     ID = input.nextInt();
//                         e.updateMeal(Name2,Price2,ID);
//                    break;
//                case 4:
//                     System.out.println("Enter the meal's  name: ");
//                     int tempID = input.nextInt();
//                    e.searchID(tempID);
//                    break;
//
//                case 5:
//                    e.displayMeal();
//                    break;
//                default:
//                    System.out.println("Thank You..!");
//                    System.exit(0);
//            }
//            System.out.println("Do another process?..choose '1' to continue and '0' to exit");
//            int x = input.nextInt();
//            if (x == 1) {
//                System.out.println("choose operation:\n"
//                        + "1-Add a new  meal\n"
//                        + "2-Delete a meal\n"
//                        + "3-update meal data\n"
//                        + "4-search for a meal\n"
//                        + "5-list all meals");
//                choose = input.nextInt();
//            } else {
//                System.out.println("Thank You..!");
//                System.exit(0);
//            }
//        } while (choose != 0);
    }

}
