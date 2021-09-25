/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package kylevirtualpet;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author kylefrancis
 */
public class VirtualPetApplication {
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        //array list of all pet choices
        ArrayList<Animal> pets = new ArrayList<>();
        pets.add(new Bulldog("Angus"));
        pets.add(new Beagle("Brandy"));
        pets.add(new Labrador("Charlie"));
        pets.add(new Persian("Diamond"));
        pets.add(new Shorthair("Eve"));
        pets.add(new Siamese("Felix"));
        pets.add(new Canary("Gandalf"));
        pets.add(new Parakeet("Harry"));
        pets.add(new Budgie("Icarus"));
        
        //show menu
        System.out.println("Welcome to Kyle's Virtual Pet Game!");
        System.out.println("Would you like to:");
        System.out.println("1) Play Game");
        System.out.println("2) See Game Stats");
        System.out.println("3) End Game");
        
        //create file reader class
        FileRead fr = new FileRead(pets);
        
        while(true)
        {
            try
            {
                int menuInput = scan.nextInt(); //ask user for input
                
                if(menuInput == 1) //start game
                {
                    //ask the user for their name
                    System.out.println("What is your name?"); //asks user for name
                    String name = fr.checkName(); //check if name is already being used
                    
                    
                    Owner owner = new Owner(name);
                    Animal myPet;
                    
                    System.out.println("Welcome to my Virtual Pet Game, " +owner.getName()+ "!");
                    PickAPet pick = new PickAPet(pets); //create pick a pet class
                    
                    myPet = pick.pickPet(); //assign chosen met to my pet variable
                    
                    System.out.println("You have chosen "+myPet.getName());
                    System.out.println("Keep playing, feeding and cleaning " +myPet.getName()+ " to make sure none of their level go down to 0!\n"
                            +"Try get through as many rounds as you can to score higher!"); //show basic instructions on how to play
                    
                    Actions actions = new Actions(myPet, owner);
                    actions.pickAction(); //run actions for game
                    
                    System.out.println("");
                    
                    FileWrite fw = new FileWrite(owner, myPet); //create file writer class
                    fw.writeNames(); //save owner and pet names to file
                    fw.writeRounds(actions); //save how many rounds played to file
                    fw.writeStats(); //save death stats to file
                    fw.writeDiff(); //save players difficulty choice to file
                    break;
                }
                else if(menuInput == 2) //show game stats menu
                {
                    while(true)
                    {
                        System.out.println("Pick a file to read");
                        System.out.println("1) Names");
                        System.out.println("2) Scores");
                        System.out.println("3) Death Stats");
                        System.out.println("4) Difficulty");
                        System.out.println("5) End Game");
                        
                        int input = scan.nextInt();
                        
                        if(input == 1)
                            fr.readNames(); //display how many times each pet has been picked
                        else if(input == 2)
                            fr.readRounds(); //display top 3 users and their scores
                        else if(input == 3)
                            fr.readStats(); //display how a certain pet died
                        else if(input == 4)
                            fr.readDiff(); //disply what users picked a certain difficulty level
                        else if(input == 5)
                            break;
                        else
                        {
                            System.err.println("Enter a valid number");
                        }
                        System.out.println();
                    }
                    break;
                }
                else if(menuInput == 3) //end game
                {
                    break;
                }
                else
                {
                    System.err.println("Enter valid number");
                }
            }catch(InputMismatchException e)
            {
                System.err.println("Please input a number");
                scan.next();
            }
        }
    }
}