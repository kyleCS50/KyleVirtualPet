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
public class VirtualPetApp {
    public static void main(String[] args) {
        //instansiate model and controller
        OwnerModel owner = new OwnerModel("pdc", "pdc");
        Control c = new Control(owner);
        
        //connect to database
        VirtualPetDB.connectVirtualPetDB();
        
        //if wanting to wipe database of owners and their progress
        VirtualPetDB.createOwners();
        VirtualPetDB.createSavedPets();
    }
}
