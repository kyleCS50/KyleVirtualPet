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
        view.getSignUpButton().addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();
        if(source == view.getLoginButton())
        {
            System.out.println("Log In button pressed");
            String user = view.getLiUserField().getText();
            String password = view.getPasswordField().getText();
            
            if(user.equals(model.getUser()) && password.equals(model.getPass()))
            {
                view.getLiSuccess().setForeground(new Color(6, 156, 24));
                view.getLiSuccess().setText("Login Successful");
            }
            else
            {
                view.getLiSuccess().setForeground(Color.RED);
                view.getLiSuccess().setText("Wrong username or password");
            }
        }
        if(source == view.getSignUpButton())
        {
            System.out.println("Sign Up button clicked");
            view.getSuFrame().setLocation(view.getLiFrame().getX(), view.getLiFrame().getY());
            view.getLiFrame().setVisible(false);
            view.getSuFrame().setVisible(true);
        }
    }
}
