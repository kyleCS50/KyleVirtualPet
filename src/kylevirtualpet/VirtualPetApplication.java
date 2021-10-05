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
        pets.add(new Labrador("Charlie"));
        pets.add(new Shorthair("Eve"));
        pets.add(new Canary("Gandalf"));
        
        //show menu
        System.out.println("Welcome to Kyle's Virtual Pet Game!");
        System.out.println("Would you like to:");
        System.out.println("1) Play Game");
        System.out.println("2) End Game");
                
        while(true)
        {
            try
            {
                int menuInput = scan.nextInt(); //ask user for input
                
                if(menuInput == 1) //start game
                {
                    //ask the user for their name
                    System.out.println("What is your name?"); //asks user for name
                    String name = scan.next();
                    
                    
                    Owner owner = new Owner(name);
                    Animal myPet;
                    
                    System.out.println("Welcome to my Virtual Pet Game, " +owner.getName()+ "!");
                    PickAPet pick = new PickAPet(pets); //create pick a pet class
                    
                    myPet = pick.pickPet(); //assign chosen met to my pet variable
                    
                    System.out.println("You have chosen "+myPet.getName());
                    System.out.println("Keep playing, feeding and cleaning " +myPet.getName()+ " to make sure none of their level go down to 0!\n"
                            +"Try get through as many rounds as you can to score higher!"); //show basic instructions on how to play
                    
                    Actions actions = new Actions(myPet, owner);
                    //actions.pickAction(); //run actions for game
                    
                    System.out.println("");
                    
                    break;
                }
                else if(menuInput == 2) //end game
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