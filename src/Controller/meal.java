package Controller;
import Model.Database;
import java.io.IOException;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

public class Meal {

    private int ID;
    private String Name;
    private double Price;
    Database database = new Database();

    public Meal() {
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
    
    public void AddMeal(String Name, double Price) throws Exception{
        database.saveMeal(Name, Price);
    }
    
    public int MealExists(int ID) throws SQLException, Exception{
        return database.mealExists(ID);
    }
    
    public void DeleteMeal(int ID) throws IOException, ClassNotFoundException, SQLException{
        database.deleteMeal(ID);
    }
    
    public void DisplayMeals(DefaultTableModel model) throws ClassNotFoundException, SQLException{
        database.RetrieveListOfMeals(model);
    }
    
    public void UpdateMeal(String Name2, double Price2, int ID) throws Exception{
        database.updateMeal(Name2, Price2, ID);
    }

}
