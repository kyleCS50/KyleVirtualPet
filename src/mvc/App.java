/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc;

/**
 *
 * @author kylefrancis
 */
public class App {
    public static void main(String[] args) {
        Model m = new Model("pdc", "pdc");
        View v = new View("Virtual Pet Game");
        Control c = new Control(m, v);
    }
}
