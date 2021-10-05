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
public class Shorthair extends Animal{
    
    public Shorthair(String name) //shorthair constructor
    {
        //set variables
        super(name);
        this.setAnimalType("Cat");
        this.setBreed("Shorthair");
        this.setHappyMeter(7);
        this.setHungerMeter(6);
        this.setCleanMeter(6);
        this.setDiff(Difficulty.MEDIUM);
    }
}
