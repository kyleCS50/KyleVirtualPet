/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package mvc;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 *
 * @author kylefrancis
 */
public class Control implements ActionListener, MouseListener
{
    private Model model;
    private View view;
    private int clicks = 0;
    
    public Control(Model model, View view) {
        this.model = model;
        this.view = view;
        
        view.getLoginButton().addActionListener(this);
        view.getSignUpButton().addActionListener(this);
        view.getSuCreateButton().addActionListener(this);
        
        view.getBulldogLabel().addMouseListener(this);
        view.getBeagleLabel().addMouseListener(this);
        view.getLabLabel().addMouseListener(this);
        view.getPerLabel().addMouseListener(this);
        view.getShortLabel().addMouseListener(this);
        view.getSiaLabel().addMouseListener(this);
        view.getCanLabel().addMouseListener(this);
        view.getParLabel().addMouseListener(this);
        view.getBudLabel().addMouseListener(this);
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
    
    @Override
    public void mouseClicked(MouseEvent me) {
        Object source = me.getSource();
        
    }
    
    @Override
    public void mousePressed(MouseEvent me) {
    }
    
    @Override
    public void mouseReleased(MouseEvent me) {
    }
    
    @Override
    public void mouseEntered(MouseEvent me) {
        Object source = me.getSource();
        view.getNameLabel().setVisible(true);
        view.getDogLabel().setVisible(false);
        view.getCatLabel().setVisible(false);
        view.getBirdLabel().setVisible(false);
        
        //bulldog
        if(source == view.getBulldogLabel())
        {
            view.getNameLabel().setText("Angus the Bulldog");
            view.getNameLabel().setBounds(181, 242, 290, 50);
            view.getBeagleLabel().setVisible(false);
            view.getLabLabel().setVisible(false);
            view.getPerLabel().setVisible(false);
            view.getShortLabel().setVisible(false);
            view.getSiaLabel().setVisible(false);
            view.getCanLabel().setVisible(false);
            view.getParLabel().setVisible(false);
            view.getBudLabel().setVisible(false);
        }
        //beagle
        if(source == view.getBeagleLabel())
        {
            view.getNameLabel().setText("Brandy the Beagle");
            view.getNameLabel().setBounds(481, 242, 290, 50);
            view.getBulldogLabel().setVisible(false);
            view.getLabLabel().setVisible(false);
            view.getPerLabel().setVisible(false);
            view.getShortLabel().setVisible(false);
            view.getSiaLabel().setVisible(false);
            view.getCanLabel().setVisible(false);
            view.getParLabel().setVisible(false);
            view.getBudLabel().setVisible(false);
        }
        //lab
        if(source == view.getLabLabel())
        {
            view.getNameLabel().setText("Charlie the Labrador");
            view.getNameLabel().setBounds(757, 242, 350, 50);
            view.getBulldogLabel().setVisible(false);
            view.getBeagleLabel().setVisible(false);
            view.getPerLabel().setVisible(false);
            view.getShortLabel().setVisible(false);
            view.getSiaLabel().setVisible(false);
            view.getCanLabel().setVisible(false);
            view.getParLabel().setVisible(false);
            view.getBudLabel().setVisible(false);
        }
        //persian
        if(source == view.getPerLabel())
        {
            view.getNameLabel().setText("Diamond the Persian");
            view.getNameLabel().setBounds(157, 462, 350, 50);
            view.getBeagleLabel().setVisible(false);
            view.getLabLabel().setVisible(false);
            view.getBulldogLabel().setVisible(false);
            view.getShortLabel().setVisible(false);
            view.getSiaLabel().setVisible(false);
            view.getCanLabel().setVisible(false);
            view.getParLabel().setVisible(false);
            view.getBudLabel().setVisible(false);
        }
        //shorthair
        if(source == view.getShortLabel())
        {
            view.getNameLabel().setText("Eve the Shorthair");
            view.getNameLabel().setBounds(491, 462, 270, 50);
            view.getBulldogLabel().setVisible(false);
            view.getLabLabel().setVisible(false);
            view.getPerLabel().setVisible(false);
            view.getBeagleLabel().setVisible(false);
            view.getSiaLabel().setVisible(false);
            view.getCanLabel().setVisible(false);
            view.getParLabel().setVisible(false);
            view.getBudLabel().setVisible(false);
        }
        //siamese
        if(source == view.getSiaLabel())
        {
            view.getNameLabel().setText("Felix the Siamese");
            view.getNameLabel().setBounds(791, 462, 270, 50);
            view.getBulldogLabel().setVisible(false);
            view.getBeagleLabel().setVisible(false);
            view.getPerLabel().setVisible(false);
            view.getShortLabel().setVisible(false);
            view.getLabLabel().setVisible(false);
            view.getCanLabel().setVisible(false);
            view.getParLabel().setVisible(false);
            view.getBudLabel().setVisible(false);
        }
        //canary
        if(source == view.getCanLabel())
        {
            view.getNameLabel().setText("Gandalf the Canary");
            view.getNameLabel().setBounds(181, 450, 300, 50);
            view.getBeagleLabel().setVisible(false);
            view.getLabLabel().setVisible(false);
            view.getPerLabel().setVisible(false);
            view.getShortLabel().setVisible(false);
            view.getSiaLabel().setVisible(false);
            view.getBulldogLabel().setVisible(false);
            view.getParLabel().setVisible(false);
            view.getBudLabel().setVisible(false);
        }
        //parakeet
        if(source == view.getParLabel())
        {
            view.getNameLabel().setText("Harry the Parakeet");
            view.getNameLabel().setBounds(475, 450, 300, 50);
            view.getBulldogLabel().setVisible(false);
            view.getLabLabel().setVisible(false);
            view.getPerLabel().setVisible(false);
            view.getShortLabel().setVisible(false);
            view.getSiaLabel().setVisible(false);
            view.getCanLabel().setVisible(false);
            view.getBeagleLabel().setVisible(false);
            view.getBudLabel().setVisible(false);
        }
        //budgie
        if(source == view.getBudLabel())
        {
            view.getNameLabel().setText("Icarus the Budgie");
            view.getNameLabel().setBounds(786, 450, 280, 50);
            view.getBulldogLabel().setVisible(false);
            view.getBeagleLabel().setVisible(false);
            view.getPerLabel().setVisible(false);
            view.getShortLabel().setVisible(false);
            view.getSiaLabel().setVisible(false);
            view.getCanLabel().setVisible(false);
            view.getParLabel().setVisible(false);
            view.getLabLabel().setVisible(false);
        }
    }
    
    @Override
    public void mouseExited(MouseEvent me) {
        view.getNameLabel().setVisible(false);
        view.getDogLabel().setVisible(true);
        view.getCatLabel().setVisible(true);
        view.getBirdLabel().setVisible(true);
        view.getBulldogLabel().setVisible(true);
        view.getBeagleLabel().setVisible(true);
        view.getLabLabel().setVisible(true);
        view.getPerLabel().setVisible(true);
        view.getShortLabel().setVisible(true);
        view.getSiaLabel().setVisible(true);
        view.getCanLabel().setVisible(true);
        view.getParLabel().setVisible(true);
        view.getBudLabel().setVisible(true);
    }
}
