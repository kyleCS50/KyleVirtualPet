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
public class Beagle extends Animal{
    
    public Beagle(String name) {
        super(name);
        this.setAnimalType("Dog");
        this.setBreed("Beagle");
        this.setHappyMeter(7);
        this.setHungerMeter(6);
        this.setCleanMeter(6);
        this.setDiff(Difficulty.MEDIUM);
    }
    
    @Override
    public void soundsLike()
    {
        System.out.println(this.getName()+ " lets out a howls!");
    }
    
}
