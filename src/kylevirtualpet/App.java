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
public class App {
    public static void main(String[] args) {
        Model m = new Model("pdc", "pdc");
        Control c = new Control(m);
        
        VirtualPetsDB.connectVirtualPetDB();
        //VirtualPetsDB.createOwners();
        //VirtualPetsDB.createSavedPets();
    }
}
