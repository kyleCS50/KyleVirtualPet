/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package kylevirtualpet;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author kylefrancis
 */
public class Actions {
    //define variables
    private Animal animal;
    private Owner owner;
    private Scanner scan;
    private int roundCount;
    
    //actions constructor
    public Actions(Animal animal, Owner owner)
    {
        this.animal = animal;
        this.owner = owner;
        this.scan = new Scanner(System.in);
        roundCount = 1;
    }
    
    //method to randomly pick the next event
    public String nextRandEvent()
    {
        Random random = new Random();
        int number = random.nextInt(3)+1;
        
        if (number == 1)
        {
            return animal.isSad();
        }
        else if (number == 2)
        {
            return animal.isHungry();
        }
        else if(number == 3)
        {
            return animal.isDirty();
        }
        else
            return "test";
    }
    
//user picks to play with pet
    public void pickPlay()
    {
        owner.play(animal);
        owner.setRounds(roundCount++);
    }
    
    //user picks to feed pet
    public void pickFeed()
    {
        owner.feed(animal);
        owner.setRounds(roundCount++);
    }
    //user picks to clean pet
    public void pickClean()
    {
        owner.clean(animal);
        owner.setRounds(roundCount++);
    }
}
