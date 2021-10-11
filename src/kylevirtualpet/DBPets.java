package kylevirtualpet;

import java.sql.Connection;
import java.sql.DatabaseMetaData;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBPets {
    
    private final DBManager dbManager;
    private final Connection conn;
    
    public DBPets() {
        dbManager = new DBManager();
        conn = dbManager.getConnection();
    }
    
    public void connectVirtualPetDB() {
        //use the conn, initialize database by creating BOOK Table and insert records
        
        try {
            String createBook = "CREATE TABLE PETS (PETID INT, NAME VARCHAR(50), ANIMAL VARCHAR(50), BREED VARCHAR(50), DIFF VARCHAR(20), HAPPY INT, FOOD INT, CLEAN INT)";
            String insertBook = "INSERT INTO PETS VALUES " +
                    "(1, 'Mordecai', 'Bird', 'Blue Jay', 'Easy', 10, 8, 9),\n" +
                    "(2, 'Eve', 'Cat', 'Shorthair', 'Medium', 7, 6, 6),\n" +
                    "(3, 'Charlie', 'Dog', 'Labrador', 'Hard', 5, 4, 3)";
            
            dbManager.establishConnection();
            Statement statement = conn.createStatement();
            //drop if exists
            DatabaseMetaData meta = conn.getMetaData();
            ResultSet rs = meta.getTables(null, null, "PETS", null);
            if(rs.next())
                statement.execute("DROP TABLE PETS");
            
            //create and insert
            dbManager.updateDB(createBook);
            dbManager.updateDB(insertBook);
            
        } catch (SQLException ex) {
            Logger.getLogger(DBPets.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public ResultSet getPetsInfo() {
        /* You may need the following SQL statements for this method:
        
        * Query multiple tables:
        
        SELECT TITLE, PRICE, DISCOUNT FROM BOOK, PROMOTION WHERE BOOK.CATEGORY=PROMOTION.CATEGORY;
        
        */
        
        ResultSet rs = null;
        try {
            String selectWeek = "SELECT name, happy, food, clean, diff FROM pets";

            Statement statement = conn.createStatement();
            rs = statement.executeQuery(selectWeek);
            
            while(rs.next())
            {
                String name = rs.getString(1);
                int happy = rs.getInt(2);
                int food = rs.getInt(3);
                int clean = rs.getInt(4);
                String diff = rs.getString(5);
                
                System.out.println(name+ "\nHappy: " +happy+ "\tFood: " +food+ "\tClean: " +clean+ "\tDiff: " +diff);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBPets.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return (rs);
        
    }
    
    public static void main(String[] args) {
        DBPets dbp = new DBPets();
        dbp.connectVirtualPetDB();
        dbp.getPetsInfo();
    }
}
