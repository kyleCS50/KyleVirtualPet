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
    
    public BlueJay(String name) //blue jay constructor
    {
        //set variables
        super(name);
        this.setAnimalType("Bird");
        this.setBreed("Blue Jay");
        this.setHappyMeter(10);
        this.setHungerMeter(8);
        this.setCleanMeter(9);
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
