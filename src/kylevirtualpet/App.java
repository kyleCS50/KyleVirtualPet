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
        LoginView logIn = new LoginView("LogIn");
        SignUpView signUp = new SignUpView("Sign Up");
        MenuView menu = new MenuView("Menu");
        SelectView select = new SelectView("Select Pet");
        //GameView game = new GameView("Virtual Pet Game");
        Control c = new Control(m, logIn, signUp, menu, select);
    }
}
