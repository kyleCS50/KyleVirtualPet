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
public class Owner {
    
    //declare variable
    private String name;
    private int rounds;
    
//getters and setters
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public int getRounds() {
        return rounds;
    }
    
    public void setRounds(int rounds) {
        this.rounds = rounds;
    }
    
    //owner constructor
    public Owner(String name)
    {
        this.setName(name);
        this.rounds = 0;
    }
    
    //define addStat
    private int addStat(Animal a)
    {
        int addStat = 0;
        if(a.getDiff().equals(Difficulty.EASY))
        {
            addStat = 3;
        }
        else if(a.getDiff().equals(Difficulty.MEDIUM))
        {
            addStat = 2;
        }
        else if(a.getDiff().equals(Difficulty.HARD))
        {
            addStat = 1;
        }
        return addStat;
    }
    
    //owner methods
    public void play(Animal a)
    {
        a.setHappyMeter(a.getHappyMeter() + 3);
    }
    
    public void feed(Animal a)
    {
        a.setHungerMeter(a.getHungerMeter() + 3);
    }
    
    public void clean(Animal a)
    {
        a.setCleanMeter(a.getCleanMeter() + 3);
    }
    
}
