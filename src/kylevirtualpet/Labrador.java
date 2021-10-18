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
    
    //labrador constructors
    public Labrador()
    {
        this(5, 4, 3);
    }
    
    public Labrador(int happy, int food, int clean)
    {
        super("Charlie");
        this.setAnimalType("Dog");
        this.setBreed("Labrador");
        this.setHappyMeter(happy);
        this.setFoodMeter(food);
        this.setCleanMeter(clean);
        this.setDiff(Difficulty.HARD);
    }
    
    //methods to dsiplay message if stat is at 0
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
