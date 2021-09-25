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
public class Budgie extends Animal{
    
    public Budgie(String name) //budgie constrctor
    {
        //set variables
        super(name);
        this.setAnimalType("Bird");
        this.setBreed("Budgie");
        this.setHappyMeter(5);
        this.setHungerMeter(4);
        this.setCleanMeter(3);
        this.setDiff(Difficulty.HARD);
    }
    
    //override sound like method
    @Override
    public void soundsLike()
    {
        System.out.println(this.getName()+ " lets out a high-pitched chrip");
    }
}