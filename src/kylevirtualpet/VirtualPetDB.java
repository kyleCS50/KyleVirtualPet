package kylevirtualpet;

import java.sql.Connection;
import java.sql.DatabaseMetaData;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

public class VirtualPetDB {
    
    private static final DBManager dbManager = new DBManager();;
    private static final Connection conn  = dbManager.getConnection();
    private static HashMap<String, String> ownersMap = new LinkedHashMap<>();
    private static HashMap<String, Integer> idSet = new LinkedHashMap<>();
    
    
    private VirtualPetDB() {}
    
    public static void connectVirtualPetDB() {
        try {
            String createBook = "CREATE TABLE PETS (PETID INT, NAME VARCHAR(50), ANIMAL VARCHAR(50), BREED VARCHAR(50), DIFF VARCHAR(20), HAPPY INT, FOOD INT, CLEAN INT)";
            String insertBook = "INSERT INTO PETS VALUES " +
                    "(1, 'Mordecai', 'Bird', 'Blue Jay', 'EASY', 10, 8, 9),\n" +
                    "(2, 'Eve', 'Cat', 'Shorthair', 'MEDIUM', 7, 6, 6),\n" +
                    "(3, 'Charlie', 'Dog', 'Labrador', 'HARD', 5, 4, 3)";
            
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
            Logger.getLogger(VirtualPetDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void createOwners()
    {
        try {
            String createOwners = "CREATE TABLE OWNERS (ownerID INT, username VARCHAR(50), password VARCHAR(50), petID INT)";
            Statement statement = conn.createStatement();
            //drop if exists
            DatabaseMetaData meta = conn.getMetaData();
            ResultSet rs = meta.getTables(null, null, "OWNERS", null);
            if(rs.next())
                statement.execute("DROP TABLE OWNERS");
            
            dbManager.updateDB(createOwners);
        } catch (SQLException ex) {
            Logger.getLogger(VirtualPetDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void createSavedPets()
    {
        try {
            String createSaved = "CREATE TABLE SAVEDPETS (ownerID INT, petID INT, rounds INT, savedHappy INT, savedFood INT, savedClean INT)";
            Statement statement = conn.createStatement();
            //drop if exists
            DatabaseMetaData meta = conn.getMetaData();
            ResultSet rs = meta.getTables(null, null, "SAVEDPETS", null);
            if(rs.next())
                statement.execute("DROP TABLE SAVEDPETS");
            
            dbManager.updateDB(createSaved);
            
        } catch (SQLException ex) {
            Logger.getLogger(VirtualPetDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void insertOwner(String username, String password, int petID)
    {
        if(petID > 0 && petID < 4)
        {
            try {
                int ownerID = 0;
                ResultSet rs = dbManager.queryDB("SELECT ownerID, username FROM owners");
                while(rs.next())
                {
                    int id = rs.getInt(1);
                    String name = rs.getString(2);
                    idSet.put(name, id);
                    ownerID++;
                }
                if(!idSet.containsKey(username))
                    ownerID++;
                else
                    ownerID = idSet.get(username);
                
                VirtualPetDB.getOwnersMap();
                String insertOwner = "INSERT INTO OWNERS VALUES "
                        + "(" +ownerID+ ", '" +username+ "', '" +password+ "', " +petID+ ")";
                
                if(!ownersMap.containsKey(username))
                {
                    dbManager.updateDB(insertOwner);
                    ownersMap.put(username, password);
                }
                else
                {
                    String updateOwner = "UPDATE OWNERS SET petID = "+petID+" WHERE username = '"+username+"'";
                    dbManager.updateDB(updateOwner);
                }
                
            } catch (SQLException ex) {
                Logger.getLogger(VirtualPetDB.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else
            System.err.println("petID "+petID+" is not in range");
    }
    
    public static void insertSavedPets(String name, int rounds, int savedHappy, int savedFood, int savedClean)
    {
        try {
            String selectPets = "SELECT o.ownerID, p.petID FROM owners o, pets p WHERE o.petID = p.petID ORDER BY o.ownerID";
            Statement statement = conn.createStatement();
            int ownerID = 0;
            int petID = 0;
            ResultSet rs = statement.executeQuery(selectPets);
            while(rs.next())
            {
                ownerID = rs.getInt(1);
                petID = rs.getInt(2);
                if(idSet.containsKey(name) && idSet.get(name).equals(ownerID))
                    break;
            }
            
            
            String insertSaved = "INSERT INTO savedPets VALUES "
                    + "(" +ownerID+ ", " +petID+ ", " +rounds+ ", " +savedHappy+ ", " +savedFood+ ", " +savedClean+ ")";
            dbManager.updateDB(insertSaved);
            
        } catch (SQLException ex) {
            Logger.getLogger(VirtualPetDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static HashMap<String, String> getOwnersMap()
    {
        try {
            String getUsers = "SELECT username, password FROM owners";
            ResultSet rs = dbManager.queryDB(getUsers);
            while(rs.next())
            {
                String username = rs.getString(1);
                String password = rs.getString(2);
                ownersMap.put(username, password);
            }
        } catch (SQLException ex) {
            Logger.getLogger(VirtualPetDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ownersMap;
    }
    
    public static String getDiff(String diff)
    {
        String output = "";
        try {
            Set<String> owners = new LinkedHashSet<>();
            String selectDiff = "SELECT o.username FROM owners o, savedPets s, pets p WHERE o.ownerID = s.ownerID AND p.petID = s.petID AND p.diff = '"+diff.toUpperCase()+"'";
            ResultSet rs = dbManager.queryDB(selectDiff);
            
            while(rs.next())
            {
                String owner = rs.getString(1);
                owners.add(owner);
            }
            
            for(String owner: owners)
            {
                output += owner+"<br/>";
            }
        } catch (SQLException ex) {
            Logger.getLogger(VirtualPetDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return output;
    }
    
    public static String getTopRounds()
    {
        String output = "";
        try {
            String selectRounds = "SELECT o.username, s.rounds FROM owners o INNER JOIN savedPets s ON o.ownerID = s.ownerID WHERE o.ownerID = s.ownerID "
                    + " AND s.savedHappy <= 0 OR s.savedFood <= 0 OR s.savedClean <= 0 ORDER BY s.rounds DESC";
            String[] topPlayers = new String[5];
            int position = 0;
            ResultSet rs = dbManager.queryDB(selectRounds);
            while(rs.next())
            {
                if(position < 5)
                {
                    String name = rs.getString(1);
                    int rounds = rs.getInt(2);
                    String playerStat = name+" | "+rounds;
                    topPlayers[position] = playerStat;
                    position++;
                }
            }
            
            for(int i = 0; i < topPlayers.length; i++)
            {
                if(topPlayers[i] != null)
                    output += (i+1)+". "+topPlayers[i]+"<br/>";
                else
                    output += (i+1)+". _____ | ___<br/>";
            }
        } catch (SQLException ex) {
            Logger.getLogger(VirtualPetDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return output;
    }
    
    public static ArrayList<String> getSavedPets(String username)
    {
        ArrayList<String> savedPets = new ArrayList<>();
        try {
            String selectSavedPets = "SELECT p.name, p.breed, s.rounds, s.savedHappy, s.savedFood, s.savedClean FROM pets p, savedPets s, owners o "
                    + "WHERE o.username = '"+username+"' AND o.ownerID = s.ownerID AND p.petID = s.petID";
            ResultSet rs = dbManager.queryDB(selectSavedPets);
            
            while(rs.next())
            {
                String petName = rs.getString(1);
                String petBreed = rs.getString(2);
                int rounds = rs.getInt(3);
                int savedHappy = rs.getInt(4);
                int savedFood = rs.getInt(5);
                int savedClean = rs.getInt(6);
                String petStats = petName+" the "+petBreed+" | Rounds: "+rounds+" | Happiness: "+savedHappy+" | Food: "+savedFood+" | Cleanliness: "+savedClean;
                if(savedHappy > 0 && savedFood > 0 && savedClean > 0)
                    savedPets.add(petStats);
            }
        } catch (SQLException ex) {
            Logger.getLogger(VirtualPetDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return savedPets;
    }
    
    public static void removeSavedPet(String username, int petID, int rounds, int happy, int food, int clean)
    {
        try {
            String getOwnerID = "SELECT s.ownerID FROM savedPets s, owners o WHERE o.username = '"+username+"' AND o.ownerID = s.ownerID";
            ResultSet ownerRS = dbManager.queryDB(getOwnerID);
            int ownerID = 0;
            while(ownerRS.next())
            {
                ownerID = ownerRS.getInt(1);
            }
            String delete = "DELETE FROM savedPets WHERE ownerID = "+ownerID+" AND petID = "+petID+" AND rounds = "+rounds+" "
                    + "AND savedHappy = "+happy+" AND savedFood = "+food+" AND savedClean = "+clean;
            dbManager.updateDB(delete);
        } catch (SQLException ex) {
            Logger.getLogger(VirtualPetDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
