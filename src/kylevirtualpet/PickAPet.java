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
public class PickAPet {
    
    //create variables
    private Scanner scan;
    private Animal myPet;
    private int animalChoice;
    private int petChoice;
    private ArrayList<Animal> pets;
    
    public PickAPet(ArrayList<Animal> pets) //pick a pet constructor
    {
        this.scan = new Scanner(System.in);
        this.pets = pets;
    }
    
    public Animal pickPet() //pick a pet method
    {
        boolean repeat = true; //create repeat variable
        while(repeat) //while repeat is true
        {
            try{
                //select what type of animal user wants
                System.out.println("To start pick one of the following animals:");
                System.out.println("1) Dog");
                System.out.println("2) Cat");
                System.out.println("3) Bird");
                
                animalChoice = scan.nextInt() - 1;
                System.out.println("Pick your pet! The higher the number, the harder the game.");
                
                switch (animalChoice) {
                    case 0:
                        for(int i = 0; i < pets.size(); i++)
                        {
                            //display all dogs in pet array
                            if(pets.get(i).getAnimalType().equals("Dog"))
                            {
                                System.out.println((i + 1)+ ")" +pets.get(i).getName()+ " the " +pets.get(i).getBreed());
                            }
                            repeat = false;
                        }   break;
                    case 1:
                        for(int i = 0; i < pets.size(); i++)
                        {
                            //display all cats in pet array
                            if(pets.get(i).getAnimalType().equals("Cat"))
                            {
                                System.out.println((i - 2)+ ")" +pets.get(i).getName()+ " the " +pets.get(i).getBreed());
                            }
                            repeat = false;
                        }   break;
                    case 2:
                        for(int i = 0; i < pets.size(); i++)
                        {
                            //display all birds in pet array
                            if(pets.get(i).getAnimalType().equals("Bird"))
                            {
                                System.out.println((i - 5)+ ")" +pets.get(i).getName()+ " the " +pets.get(i).getBreed());
                            }
                            repeat = false;
                        }   break;
                    default:
                        System.err.println("Enter valid number");
                        break;
                }
            }catch(InputMismatchException e)
            {
                System.err.println("Please input a number");
                scan.next();
            }
        }
        
        while(!repeat)
        {
            try{
                //ask user to choose a pet
                petChoice = scan.nextInt();
                
                switch (petChoice) {
                    case 1:
                        myPet = pets.get((petChoice*animalChoice) + (animalChoice * 2)); //formula to set myPet to the right pet
                        repeat = true;
                        break;
                    case 2:
                        myPet = pets.get((animalChoice*petChoice) + (animalChoice + 1)); //formula to set myPet to the right pet
                        repeat = true;
                        break;
                    case 3:
                        myPet = pets.get((animalChoice*petChoice) + 2); //formula to set myPet to the right pet
                        repeat = true;
                        break;
                    default:
                        System.err.println("Enter valid number");
                        break;
                }
            }catch(InputMismatchException e)
            {
                System.err.println("Please input a number");
                scan.next();
            }
            catch(IndexOutOfBoundsException e)
            {
                System.err.println("Number out of bounds");
                scan.next();
            }
        }
        return myPet;
    }
}