/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package mvc;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author kylefrancis
 */
public class Control implements ActionListener{
    private Model model;
    private View view;
    
    public Control(Model model, View view) {
        this.model = model;
        this.view = view;
        
        view.getLoginButton().addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        System.out.println("Log In button pressed");
        String user = view.getUsernameField().getText();
        String password = view.getPasswordField().getText();
        
        if(user.equals("kyle") && password.equals("abcd"))
        {
            view.getSuccess().setForeground(new Color(6, 156, 24));
            view.getSuccess().setText("Login Successful");
        }
        else
        {
            view.getSuccess().setForeground(Color.RED);
            view.getSuccess().setText("Wrong username or password");
        }
    }
    
    
    
}
