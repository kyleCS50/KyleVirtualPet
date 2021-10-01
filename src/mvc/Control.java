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
public class Control implements ActionListener
{
    private Model model;
    private View view;
    
    public Control(Model model, View view) {
        this.model = model;
        this.view = view;
        
        view.getLoginButton().addActionListener(this);
        view.getSignUpButton().addActionListener(this);
        view.getSuCreateButton().addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();
        
        if(source == view.getLoginButton())
        {
            System.out.println("Log In button pressed");
            String user = view.getLiUserField().getText();
            String password = view.getLiPassField().getText();
            
            if(user.equals(model.getUser()) && password.equals(model.getPass()))
            {
                view.getLiSuccessLabel().setForeground(new Color(6, 156, 24));
                view.getLiSuccessLabel().setText("Login Successful");
                view.getLiFrame().setVisible(false);
                view.getSelectFrame().setVisible(true);
            }
            else
            {
                view.getLiSuccessLabel().setForeground(Color.RED);
                view.getLiSuccessLabel().setText("Wrong username or password");
            }
        }
        
        if(source == view.getSignUpButton())
        {
            System.out.println("Sign Up button clicked");
            view.getSuFrame().setLocation(view.getLiFrame().getX(), view.getLiFrame().getY());
            view.getLiFrame().setVisible(false);
            view.getSuFrame().setVisible(true);
        }
        
        if(source == view.getSuCreateButton())
        {
            System.out.println("Create Account button clicked");
            String user = view.getSuUserField().getText().trim();
            String pass1 = view.getSuPassField().getText();
            String pass2 = view.getSuConfirmField().getText();
            
            if(user.equals("") || pass1.equals("") || pass2.equals(""))
            {
                view.getSuSuccessLabel().setForeground(Color.RED);
                view.getSuSuccessLabel().setText("Fields can not remain empty.");
            }
            else
            {
                if(pass1.equals(pass2))
                {
                    view.getSuSuccessLabel().setForeground(new Color(6, 156, 24));
                    view.getSuSuccessLabel().setText("Account Created Successfully!");
                    view.getSuFrame().setVisible(false);
                    view.getSelectFrame().setVisible(true);
                }
                else
                {
                    view.getSuSuccessLabel().setForeground(Color.RED);
                    view.getSuSuccessLabel().setText("Passwords must match to create new account.");
                    view.getSuPassField().setText("");
                    view.getSuConfirmField().setText("");
                }
            }
        }
    }
}
