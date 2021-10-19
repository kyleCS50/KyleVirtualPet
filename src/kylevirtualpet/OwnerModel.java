/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package kylevirtualpet;


/**
 *
 * @author Kyle
 */
public class OwnerModel {
    
    //declare variable
    private String username;
    private String password;
    private Animal myPet;
    private int rounds;
    
    //getters and setters
    public String getUsername() {
        return username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Animal getMyPet() {
        return myPet;
    }

    public void setMyPet(Animal myPet) {
        this.myPet = myPet;
    }
    
    public int getRounds() {
        return rounds;
    }
    
    public void setRounds(int rounds) {
        this.rounds = rounds;
    }
    
    //owner constructor
    public OwnerModel(String username, String password)
    {
        this.username = username;
        this.password = password;
        this.rounds = 0;
    }
    
    //define addStat
    private int addStat()
    {
        int addStat = 0;
        if(myPet.getDiff().equals(Difficulty.EASY))
        {
            addStat = 3;
        }
        else if(myPet.getDiff().equals(Difficulty.MEDIUM))
        {
            addStat = 2;
        }
        else if(myPet.getDiff().equals(Difficulty.HARD))
        {
            addStat = 1;
        }
        return addStat;
    }
    
    //owner methods
    public void play()
    {
        myPet.setHappyMeter(myPet.getHappyMeter() + addStat());
        rounds++;
    }
    
    public void feed()
    {
        myPet.setFoodMeter(myPet.getFoodMeter() + addStat());
        rounds++;
    }
    
    public void clean()
    {
        myPet.setCleanMeter(myPet.getCleanMeter() + addStat());
        rounds++;
    }
    
}
