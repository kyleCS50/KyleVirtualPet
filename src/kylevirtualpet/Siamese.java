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
public class Siamese extends Animal{
    
    public Siamese(String name) //siamese constructor
    {
        //set variables
        super(name);
        this.setAnimalType("Cat");
        this.setBreed("Siamese");
        this.setHappyMeter(5);
        this.setHungerMeter(4);
        this.setCleanMeter(3);
        this.setDiff(Difficulty.HARD);
    }
    
    @Override
    public void soundsLike()//override sounds like method
    {
        System.out.println(this.getName()+ " lets out a hiss");
    }
}
