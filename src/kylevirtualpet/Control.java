/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package kylevirtualpet;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JLabel;

/**
 *
 * @author kylefrancis
 */
public class Control implements ActionListener, MouseListener
{
    private Model model;
    private View view;
    private Actions action;
    
    public Control(Model model, View view) {
        this.model = model;
        this.view = view;
        this.action = new Actions(model.getMyPet(), model.getOwner());
        
        view.getLoginButton().addActionListener(this);
        view.getSignUpButton().addActionListener(this);
        view.getSuCreateButton().addActionListener(this);
        view.getPlayGameButton().addActionListener(this);
        view.getHowToButton().addActionListener(this);
        view.getDoneButton().addActionListener(this);
        view.getPlayButton().addActionListener(this);
        view.getFeedButton().addActionListener(this);
        view.getCleanButton().addActionListener(this);
        
        view.getCanLabel().addMouseListener(this);
        view.getShortLabel().addMouseListener(this);
        view.getLabLabel().addMouseListener(this);
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
                System.out.println("Login Successful");
                view.getLiFrame().setVisible(false);
                view.getMenuFrame().setVisible(true);
            }
            else
            {
                view.getLiSuccessLabel().setForeground(Color.RED);
                view.getLiSuccessLabel().setText("Wrong username or password");
                System.out.println("Login Unsuccessful");
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
                    view.getMenuFrame().setVisible(true);
                    System.out.println("Create Account Successful");
                }
                else
                {
                    view.getSuSuccessLabel().setForeground(Color.RED);
                    view.getSuSuccessLabel().setText("Passwords must match to create new account.");
                    view.getSuPassField().setText("");
                    view.getSuConfirmField().setText("");
                    System.out.println("Create Account Unsuccessful");
                }
            }
        }
        
        if(source == view.getPlayGameButton())
        {
            view.getMenuFrame().setVisible(false);
            view.getSelectFrame().setVisible(true);
            System.out.println("Play button clicked");
        }
        
        if(source == view.getHowToButton())
        {
            view.getHowToFrame().setVisible(true);
            System.out.println("How To button clicked");
        }
        
        if(source == view.getDoneButton())
        {
            view.getHowToFrame().setVisible(false);
            System.out.println("How To Done button clicked");
        }
        
        if(source == view.getPlayButton())
        {
            action.pickPlay();
        }
        if(source == view.getFeedButton())
        {
            action.pickFeed();
        }
        if(source == view.getCleanButton())
        {
            action.pickClean();
        }
    }
    
    @Override
    public void mouseClicked(MouseEvent me) {
        Object source = me.getSource();
        
        if(source == view.getCanLabel())
        {
            model.setMyPet(new Canary("Icarus"));
        }
        
        if(source == view.getShortLabel())
        {
            model.setMyPet(new Shorthair("Eve"));
        }
        
        if(source == view.getLabLabel())
        {
            model.setMyPet(new Labrador("Charlie"));
        }
        view.setMyPetLabel((JLabel) source);
        view.getMyPetLabel().setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
        view.getMyPetLabel().setBounds(10, 10, 320, 320);
        view.getGamePanel().add(view.getMyPetLabel());
        
        view.getHappyStatLabel().setText(model.getMyPet().getHappyMeter()+"");
        view.getFoodStatLabel().setText(model.getMyPet().getHungerMeter()+"");
        view.getCleanStatLabel().setText(model.getMyPet().getCleanMeter()+"");
        
        view.getSelectFrame().setVisible(false);
        view.getGameFrame().setVisible(true);
    }
    
    @Override
    public void mousePressed(MouseEvent arg0) {
        
    }
    
    @Override
    public void mouseReleased(MouseEvent arg0) {
        
    }
    
    @Override
    public void mouseEntered(MouseEvent arg0) {
        
    }
    
    @Override
    public void mouseExited(MouseEvent arg0) {
        
    }
}
