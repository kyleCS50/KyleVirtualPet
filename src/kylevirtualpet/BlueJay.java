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
}
