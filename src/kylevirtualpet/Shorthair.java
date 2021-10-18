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
    
    //shorthair constructor
    public Shorthair()
    {
        this(7, 6, 6);
    }
    
    public Shorthair(int happy, int food, int clean)
    {
        super("Eve");
        this.setAnimalType("Cat");
        this.setBreed("Shorthair");
        this.setHappyMeter(happy);
        this.setFoodMeter(food);
        this.setCleanMeter(clean);
        this.setDiff(Difficulty.MEDIUM);
    }
    
    //methods to dsiplay message if stat is at 0
    @Override
    public String happyAtZero() {
        return this.getName()+ " has started hissing!";
    }
    
    @Override
    public String foodAtZero() {
        return this.getName()+ " has gone to hunt for mice to eat!";
    }
    
    @Override
    public String cleanAtZero() {
        return this.getName()+ " goes to groom themselves!";
    }
}
