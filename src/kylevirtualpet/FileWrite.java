/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package kylevirtualpet;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author kylefrancis
 */
public class FileWrite {
    
    //create vaiables
    private Owner owner;
    private Animal myPet;
    
    //file write constructor
    public FileWrite(Owner owner, Animal myPet)
    {
        this.owner = owner;
        this.myPet = myPet;
    }
    
    //method to write names
    public void writeNames()
    {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("virtualPetNames.txt", true)); //write to virtualPetNames
            bw.write(owner.getName()+ " owns " +myPet.getName()+ " the " +myPet.getBreed()+"\n");//write owner name and pet name
            bw.close();
            System.out.println("Names saved"); //display name saved 
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    
    //method to write number of rounds played
    public void writeRounds(Actions action)
    {
        try{
            BufferedWriter bw = new BufferedWriter(new FileWriter("virtualPetRounds.txt", true));//write to virtualPetRounds
            bw.write(owner.getName()+ " played " +owner.getRounds()+ "\n"); //write owner name and round number
            bw.close();
            System.out.println("Rounds saved"); //display confirmation that rounds saved
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    
    //method to write death stats
    public void writeStats()
    {
        try{
            BufferedWriter bw = new BufferedWriter(new FileWriter("virtualPetStats.txt", true));//write to virtualPetStats
            bw.write(myPet.toString()+ "\n");//write pets last to string
            bw.close();
            System.out.println("Stats saved");//display confirmation that pet stats is saved
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    
    //write owners difficulty setting
    public void writeDiff()
    {
        try{
            BufferedWriter bw = new BufferedWriter(new FileWriter("virtualPetDiff.txt", true));//write to virtualPetDiff file
            bw.write(owner.getName()+ " picked " +myPet.getDiff()+ "\n");//write owners name and chosen difficulty
            bw.close();
            System.out.println("Difficulty saved");//display confrimation that difficulty has been saved
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
