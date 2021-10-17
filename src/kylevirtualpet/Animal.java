/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package kylevirtualpet;

import java.util.Random;


/**
 *
 * @author Kyle
 */
public abstract class Animal {
    
    //declare variables
    private String name;
    private String animalType;
    private String breed;
    private Difficulty diff;
    
    private int foodMeter;
    private int happyMeter;
    private int cleanMeter;
    
 
    //getters and setters
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getAnimalType() {
        return animalType;
    }
    
    public void setAnimalType(String animalType) {
        this.animalType = animalType;
    }
    
    public String getBreed() {
        return breed;
    }
    
    public void setBreed(String breed) {
        this.breed = breed;
    }
    
    public Difficulty getDiff() {
        return diff;
    }
    
    public void setDiff(Difficulty diff) {
        this.diff = diff;
    }
    
    public int getFoodMeter() {
        return foodMeter;
    }
    
    public void setFoodMeter(int foodMeter) {
        this.foodMeter = foodMeter;
    }
    
    public int getHappyMeter() {
        return happyMeter;
    }
    
    public void setHappyMeter(int happyMeter) {
        this.happyMeter = happyMeter;
    }
    
    public int getCleanMeter() {
        return cleanMeter;
    }
    
    public void setCleanMeter(int cleanMeter) {
        this.cleanMeter = cleanMeter;
    }
    
    //Animal constructor
    public Animal(String name)
    {
        this.setName(name);
    }
    
    //methods
    public String isSad()
    {
        this.setHappyMeter(this.getHappyMeter() - 3);
        return "sad";
    }
    public String isHungry()
    {
        this.setFoodMeter(this.getFoodMeter() - 3);
        return "hungry";
    }
    public String isDirty()
    {
        this.setCleanMeter(this.getCleanMeter() - 3);
        return "dirty";
    }
    
    public String nextRandEvent()
    {
        Random random = new Random();
        int number = random.nextInt(3)+1;
        
        if (number == 1)
        {
            return isSad();
        }
        else if (number == 2)
        {
            return isHungry();
        }
        else
        {
            return isDirty();
        }
    }
    
    public abstract String happyAtZero();
    public abstract String foodAtZero();
    public abstract String cleanAtZero();
}
