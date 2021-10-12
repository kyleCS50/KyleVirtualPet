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

    @Override
    public String happyAtZero() {
        return this.getName()+ " has run away!";
    }
    
    @Override
    public String foodAtZero() {
        return this.getName()+ " went WACKO™ for a SCHMACKOS™!";
    }
    
    @Override
    public String cleanAtZero() {
        return this.getName()+ " has gone to roll in the mud!";
    }
}
