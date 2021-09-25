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
public class Labrador extends Animal{
    
    public Labrador(String name) //labrador constructor
    {
        //setting variables
        super(name);
        this.setAnimalType("Dog");
        this.setBreed("Labrador");
        this.setHappyMeter(5);
        this.setHungerMeter(4);
        this.setCleanMeter(3);
        this.setDiff(Difficulty.HARD);
    }
    
    //override sounds like method
    @Override
    public void soundsLike()
    {
        System.out.println(this.getName()+ " does a quiet bark");
    }
    
}
