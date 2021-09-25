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
public abstract class Animal {
    
    //declare variables
    private String name;
    private String animalType;
    private String breed;
    private Difficulty diff;
    
    private int hungerMeter;
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
    
    public int getHungerMeter() {
        return hungerMeter;
    }
    
    public void setHungerMeter(int hungerMeter) {
        this.hungerMeter = hungerMeter;
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
    public void isSad()
    {
        System.out.println(this.getName()+" is sad. What will you do?");
        this.setHappyMeter(this.getHappyMeter() - 3);
    }
    public void isHungry()
    {
        System.out.println(this.getName()+" is hungry. What will you do?");
        this.setHungerMeter(this.getHungerMeter() - 3);
        
    }
    public void isDirty()
    {
        System.out.println(this.getName()+" is dirty. What will you do?");
        this.setCleanMeter(this.getCleanMeter() - 3);
        
    }
    
    //abstract method
    public abstract void soundsLike();
    
    //override to string method
    @Override
    public String toString()
    {
        return "Name: " +this.getName().toUpperCase()+ " | Happiness: " +this.getHappyMeter()+
                " | Food: " +this.getHungerMeter()+ " | Cleanliness: " +this.getCleanMeter();
    }
    
}
