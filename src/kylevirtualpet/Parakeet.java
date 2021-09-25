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
public class Parakeet extends Animal {
    
    public Parakeet(String name) //parakeet constructor
    {
        //set variables
        super(name);
        this.setAnimalType("Bird");
        this.setBreed("Parakeet");
        this.setHappyMeter(7);
        this.setHungerMeter(6);
        this.setCleanMeter(6);
        this.setDiff(Difficulty.MEDIUM);
    }
    
    //override sounds like method
    @Override
    public void soundsLike()
    {
        System.out.println(this.getName()+ " whistles");
    }
}
