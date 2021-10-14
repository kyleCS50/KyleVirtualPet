/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package kylevirtualpet;

/**
 *
 * @author kylefrancis
 */
public class Model {
    
    private String username;
    private String password;
    private Animal myPet;
    private Owner owner;
    
    public Model(String adminUsername, String adminPassword) {
        this.username = adminUsername;
        this.password = adminPassword;
        owner = new Owner(adminUsername);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Animal getMyPet() {
        return myPet;
    }

    public void setMyPet(Animal myPet) {
        this.myPet = myPet;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }
    
    
}
