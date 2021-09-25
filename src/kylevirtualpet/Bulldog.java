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
public class Bulldog extends Animal{
    
    public Bulldog(String name) //bulldog constructor
    {
        //set variables
        super(name);
        this.setAnimalType("Dog");
        this.setBreed("Bulldog");
        this.setHappyMeter(10);
        this.setHungerMeter(8);
        this.setCleanMeter(9);
        this.setDiff(Difficulty.EASY);
    }

    @Override
    public void soundsLike() //override sounds like
    {
        System.out.println(this.getName()+ " does a friendly bark!");
    }
    
}
