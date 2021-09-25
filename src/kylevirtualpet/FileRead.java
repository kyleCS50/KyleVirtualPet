/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package kylevirtualpet;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author kylefrancis
 */
public class FileRead {
    //create variables
    private ArrayList<Animal> pets;
    private Scanner scan = new Scanner(System.in);
    
    //file read constructor
    public FileRead(ArrayList<Animal>pets)
    {
        this.pets = pets;
    }
    
    //method to read names
    public void readNames()
    {
        try {
            System.out.println("How many times each pet has been picked:"); //print statement describing method
            
            for(Animal p : pets) //for each animal in pets arraylist
            {
                BufferedReader br = new BufferedReader(new FileReader("virtualPetNames.txt")); //read from virtualPetNames file
                String line = null; //set line to null
                int count = 0; //set count to 0
                while((line = br.readLine())!=null) //while line equals file line
                {
                    if(line.contains(p.getName())) //if line contains pets name
                    {
                        count++; //add to count
                    }
                }
                if(count > 0) //if pets count is greater than 0
                    System.out.println(p.getName()+ ": " +count); //display pet name and their count
                br.close();
            }
            
            
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    
    public static HashMap<String, Integer> sortMap(HashMap<String, Integer> map) //method to sort hashmap
    {
        // make a list of elements in given hashmap
        List<HashMap.Entry<String, Integer> > list = new LinkedList<>(map.entrySet()); 
        
        // sort list in decending order of value
        Collections.sort(list, new Comparator<HashMap.Entry<String, Integer> >()
        {
            public int compare(HashMap.Entry<String, Integer> o1, HashMap.Entry<String, Integer> o2)
            {
                return (o2.getValue()).compareTo(o1.getValue()); //return in decending order
            }
        }
        );
        
        // put elements from list back into hashmap
        HashMap<String, Integer> sortedMap = new LinkedHashMap<>();
        
        for (HashMap.Entry<String, Integer> hashmap : list)
        {
            sortedMap.put(hashmap.getKey(), hashmap.getValue());
        }
        //return sorted hashmap
        return sortedMap;
    }
    
    public void readRounds() //read how many rounds each player got through
    {
        System.out.println("Top 3 Scores");
        HashMap<String, Integer> scoreMap = new HashMap<>(); //create hashmap
        
        try {
            
            BufferedReader br = new BufferedReader(new FileReader("virtualPetRounds.txt")); //read from virtualPetRounds
            String line = null;
            
            while((line = br.readLine())!=null)
            {
                String[] split = line.split(" played "); //split line from before and after "played"
                
                String name = split[0]; //set name variable to before "played"
                int rounds = Integer.parseInt(split[1]); //set round variable to after "played" and make int
                
                scoreMap.put(name, rounds);//put names as key and rounds as value in hashmap
            }
            
            scoreMap = sortMap(scoreMap); //sort hashmap in decending order
            
            Iterator it = scoreMap.entrySet().iterator(); //create hashmap iterator
            for(int i = 0; i < 3; i++) //print first three entries in hashmap
            {
                HashMap.Entry pair = (HashMap.Entry)it.next();
                System.out.println(pair.getKey()+ " scored " +pair.getValue()+ " points");
            }

            br.close();
            
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    
    public void readStats() //method to read stats at death of pet
    {
        System.out.println("Final Stats for Pets:");
        try {
            
            System.out.println("Type in pet name:");
            String petName = scan.next(); //ask user to enter pet name
            while(true)
            {
                BufferedReader br = new BufferedReader(new FileReader("virtualPetStats.txt"));//read from virtualPetStats
                String line = null;
                boolean found = false; //variable to see if name is found
                
                while((line = br.readLine())!=null)
                {
                    if(line.contains(petName.toUpperCase())) //if line contains pet name
                    {
                        System.out.println(line);//print out line
                        found = true;//set found to true
                    }
                }
                
                if(!found) //if unable to find name tell user name is not in file and ask again
                {
                    System.err.println("Name not found in file");
                    petName = scan.next();
                }
                else
                {
                    br.close();
                    break;
                }
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    
    public void readDiff() //method to read users difficulty
    {
        try {
            System.out.println("Type in difficulty:"); //ask the user to input a difficulty (easy, medium or hard)
            String difficulty = scan.next();
            while(true)
            {
                BufferedReader br = new BufferedReader(new FileReader("virtualPetDiff.txt"));//read from virtualPetDiff file
                String line = null;
                boolean found = false; //create found variable
                
                while((line = br.readLine())!=null)
                {
                    if(line.contains(difficulty.toUpperCase()))//if users input is found in file
                    {
                        System.out.println(line);//print line
                        found = true;//set found to true
                    }
                }
                
                if(!found)//is not found tell ask user to input again
                {
                    System.err.println("Pick easy, medium or hard");
                    difficulty = scan.next();
                }
                else
                {
                    br.close();
                    break;
                }
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    
    public String checkName()//method to check if an owners name is already taken
    {
        String name = ""; 
        try{
            name = scan.next();//ask user to input name
            while(true)
            {
                BufferedReader br = new BufferedReader(new FileReader("virtualPetNames.txt")); //read from virtualPetNames
                String line = null;
                boolean found = false;
                
                while((line = br.readLine())!=null)
                {
                    if(line.contains(name)) //if file contains name
                    {
                        found = true; //set found to true
                    }
                }
                
                if(found)
                {
                    System.err.println("Name already in file"); //if found ask user to input another name
                    name = scan.next();
                }
                else
                {
                    br.close();
                    break;
                }
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        
        return name; //return name
    }
}
