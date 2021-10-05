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
public class Canary extends Animal{
    
    public Canary(String name) //canary constructor
    {
        //set variables
        super(name);
        this.setAnimalType("Bird");
        this.setBreed("Canary");
        this.setHappyMeter(10);
        this.setHungerMeter(8);
        this.setCleanMeter(9);
        this.setDiff(Difficulty.EASY);
    }
}
