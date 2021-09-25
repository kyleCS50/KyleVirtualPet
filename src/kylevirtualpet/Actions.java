/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package kylevirtualpet;

import java.util.InputMismatchException;
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
        roundCount = 0;
    }
    
    //method to randomly pick the next event
    public void nextRandEvent()
    {
        Random random = new Random();
        int number = random.nextInt(3)+1;
        
        if (number == 1)
        {
            animal.isSad();
        }
        else if (number == 2)
        {
            animal.isHungry();
        }
        else if(number == 3)
        {
            animal.isDirty();
        }
    }
    
    //user picks what they do
    public boolean pickAction()
    {
        boolean askAgain = true; 
        
        while(askAgain) //while they want to be asked again
        {
            System.out.println(animal.toString());
            System.out.println("1) Play with " +animal.getName());
            System.out.println("2) Feed " +animal.getName());
            System.out.println("3) Clean " +animal.getName());
            System.out.println("4) End Game");
            
            
            try{
                int input = scan.nextInt();
                
                
                if (input == 1) //if user plays with pet
                {
                    owner.play(animal);
                    this.roundCount++;
                    this.nextRandEvent();
                }
                else if (input == 2) //if user feeds pet
                {
                    owner.feed(animal);
                    this.roundCount++;
                    this.nextRandEvent();
                }
                else if (input == 3) //if user cleans pet
                {
                    owner.clean(animal);
                    this.roundCount++;
                    this.nextRandEvent();
                }
                else if (input == 4) //if they want toleave the game
                {
                    System.out.println("You have left the Virtual Pet App.");
                    askAgain = false;
                }
                else
                {
                    System.err.println("Input valid number");
                }
                
                if(animal.getHappyMeter() <= 0) //if pets happiness is <= 0
                {
                    animal.setHappyMeter(0);
                    System.out.println(animal.toString()); //display final stats
                    System.out.println(animal.getName()+ " has "  +(animal.getAnimalType().equals("Bird")? "flown" : "run")+ " away!"); //give statement
                    askAgain = false; //end game
                }
                else if(animal.getHungerMeter() <= 0) //if hunger is <= 0
                {
                    animal.setHungerMeter(0);
                    System.out.println(animal.toString()); //give final stats
                    System.out.println(animal.getName()+ " has starved to death!"); //give statement
                    askAgain = false; //end game
                    
                }
                else if(animal.getCleanMeter() <= 0) //if cleanliness <= 0
                {
                    animal.setCleanMeter(0);
                    System.out.println(animal.toString()); //give final stats
                    System.out.println(animal.getName()+ " has contracted an infection!"); //give statement
                    askAgain = false; //end game
                    
                }
            }
            catch(InputMismatchException e)
            {
                System.err.println("Please enter a number");
                scan.next();
            }
        }
        this.owner.setRounds(roundCount); //set owners round number to round count
        return askAgain;
    }
}
