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
public class Persian extends Animal{
    
    public Persian(String name)  //persian constructor
    {
        //set variables
        super(name);
        this.setAnimalType("Cat");
        this.setBreed("Persian");
        this.setHappyMeter(10);
        this.setHungerMeter(8);
        this.setCleanMeter(9);
        this.setDiff(Difficulty.EASY);
    }
    
    @Override
    public void soundsLike() //override sounds like method
    {
        System.out.println(this.getName()+ " gves a gentle purr");
    }
    
}
