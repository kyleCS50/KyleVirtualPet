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
        OwnerModel owner = new OwnerModel("pdc", "pdc");
        Control c = new Control(owner);
        
        VirtualPetDB.connectVirtualPetDB();
        //VirtualPetDB.createOwners();
        //VirtualPetDB.createSavedPets();
    }
}
