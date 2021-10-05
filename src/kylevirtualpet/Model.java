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
    
    private String user;
    private String pass;
    private Animal myPet;
    private Owner owner;
    
    public Model(String user, String pass) {
        this.user = user;
        this.pass = pass;
        owner = new Owner(user);
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
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
