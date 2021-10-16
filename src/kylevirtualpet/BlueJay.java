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
public class BlueJay extends Animal{
    
    public BlueJay() //blue jay constructor
    {
        this(10, 8, 9);
    }
    
    public BlueJay(int happy, int food, int clean)
    {
        super("Mordecai");
        this.setAnimalType("Bird");
        this.setBreed("Blue Jay");
        this.setHappyMeter(happy);
        this.setFoodMeter(food);
        this.setCleanMeter(clean);
        this.setDiff(Difficulty.EASY);
    }
    
    @Override
    public String happyAtZero() {
        return this.getName()+ " has flown away!";
    }
    
    @Override
    public String foodAtZero() {
        return this.getName()+ " has gone to train for the Eggscellent Challenge!";
    }
    
    @Override
    public String cleanAtZero() {
        return this.getName()+ " has gone to the bird bath!";
    }
}
