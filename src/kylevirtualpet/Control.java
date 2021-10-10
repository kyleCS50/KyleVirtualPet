/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package kylevirtualpet;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;


/**
 *
 * @author kylefrancis
 */
public class Control implements ActionListener, MouseListener
{
    private Model model;
    private LoginView loginView;
    private SignUpView signUpView;
    private MenuView menuView;
    private SelectView selectView;
    private GameView gameView;
    private Actions action;
    
    public Control(Model model, LoginView loginView, SignUpView signUpView, MenuView menuView, SelectView selectView) {
        this.model = model;
        this.loginView = loginView;
        this.signUpView = signUpView;
        this.menuView = menuView;
        this.selectView = selectView;
        
        loginView.getLoginButton().addActionListener(this);
        loginView.getSignUpButton().addActionListener(this);
        
        signUpView.getSuCreateButton().addActionListener(this);
        
        menuView.getPlayGameButton().addActionListener(this);
        menuView.getHowToButton().addActionListener(this);
        menuView.getDoneButton().addActionListener(this);
        
        selectView.getBirdLabel().addMouseListener(this);
        selectView.getCatLabel().addMouseListener(this);
        selectView.getDogLabel().addMouseListener(this);
    }
    
    
    
    @Override
    public void mouseClicked(MouseEvent me) {
        Object source = me.getSource();
        if(source == selectView.getBirdLabel())
        {
            model.setMyPet(new BlueJay("Mordecai"));
            gameView = new GameView("Virtual Pet Game - Mordecai", new File("petAssets/bluejay.jpg"));
        }
        if(source == selectView.getCatLabel())
        {
            model.setMyPet(new Shorthair("Eve"));
            gameView = new GameView("Virtual Pet Game - Eve", new File("petAssets/shorthair.jpg"));
        }
        if(source == selectView.getDogLabel())
        {
            model.setMyPet(new Labrador("Charlie"));
            gameView = new GameView("Virtual Pet Game - Charlie", new File("petAssets/lab.jpg"));
        }
        
        this.action = new Actions(model.getMyPet(), model.getOwner());
        
        gameView.getPlayButton().addActionListener(this);
        gameView.getFeedButton().addActionListener(this);
        gameView.getCleanButton().addActionListener(this);
        gameView.getEndButton().addActionListener(this);
        
        gameView.getHappyStatLabel().setText(model.getMyPet().getHappyMeter()+"");
        gameView.getFoodStatLabel().setText(model.getMyPet().getHungerMeter()+"");
        gameView.getCleanStatLabel().setText(model.getMyPet().getCleanMeter()+"");
        
        gameView.getPetName().setText("Name: " +model.getMyPet().getName());
        gameView.getPetBreed().setText("Breed: "+model.getMyPet().getBreed());
        gameView.getPetDiff().setText("Difficulty: "+model.getMyPet().getDiff());
        
        gameView.getPlayButton().setEnabled(true);
        gameView.getFeedButton().setEnabled(true);
        gameView.getCleanButton().setEnabled(true);
        
        selectView.setPetSelected(true);
        selectView.setVisible(false);
        gameView.setVisible(true);
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
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();
        
        if(source == loginView.getLoginButton())
        {
            System.out.println("Log In button pressed");
            String user = loginView.getLiUserField().getText();
            String password = loginView.getLiPassField().getText();
            
            if(user.equals(model.getUser()) && password.equals(model.getPass()))
            {
                loginView.getLiSuccessLabel().setForeground(new Color(6, 156, 24));
                loginView.getLiSuccessLabel().setText("Login Successful");
                System.out.println("Login Successful");
                loginView.setVisible(false);
                menuView.setVisible(true);
            }
            else
            {
                loginView.getLiSuccessLabel().setForeground(Color.RED);
                loginView.getLiSuccessLabel().setText("Wrong username or password");
                System.out.println("Login Unsuccessful");
            }
        }
        
        if(source == loginView.getSignUpButton())
        {
            System.out.println("Sign Up button clicked");
            loginView.setVisible(false);
            signUpView.setVisible(true);
        }
        
        if(source == signUpView.getSuCreateButton())
        {
            System.out.println("Create Account button clicked");
            String user = signUpView.getSuUserField().getText().trim();
            String pass1 = signUpView.getSuPassField().getText();
            String pass2 = signUpView.getSuConfirmField().getText();
            
            if(user.equals("") || pass1.equals("") || pass2.equals(""))
            {
                signUpView.getSuSuccessLabel().setForeground(Color.RED);
                signUpView.getSuSuccessLabel().setText("Fields can not remain empty.");
            }
            else
            {
                if(pass1.equals(pass2))
                {
                    signUpView.getSuSuccessLabel().setForeground(new Color(6, 156, 24));
                    signUpView.getSuSuccessLabel().setText("Account Created Successfully!");
                    signUpView.setVisible(false);
                    menuView.setVisible(true);
                    System.out.println("Create Account Successful");
                }
                else
                {
                    signUpView.getSuSuccessLabel().setForeground(Color.RED);
                    signUpView.getSuSuccessLabel().setText("Passwords must match to create new account.");
                    signUpView.getSuPassField().setText("");
                    signUpView.getSuConfirmField().setText("");
                    System.out.println("Create Account Unsuccessful");
                }
            }
        }
        
        if(source == menuView.getPlayGameButton())
        {
            menuView.setVisible(false);
            selectView.setVisible(true);
            System.out.println("Play button clicked");
        }
        
        if(source == menuView.getHowToButton())
        {
            menuView.getHowToFrame().setVisible(true);
            System.out.println("How To button clicked");
        }
        
        if(source == menuView.getDoneButton())
        {
            menuView.getHowToFrame().setVisible(false);
            System.out.println("How To Done button clicked");
        }
        
        if(selectView.isPetSelected())
        {
            if(source == gameView.getPlayButton())
            {
                System.out.println("play pressed");
                action.pickPlay();
                gameView.getPetIsLabel().setText("You just played with " +model.getMyPet().getName()+ ". Now they are " +action.nextRandEvent()+ "!");
            }
            if(source == gameView.getFeedButton())
            {
                System.out.println("feed pressed");
                action.pickFeed();
                gameView.getPetIsLabel().setText("You just fed " +model.getMyPet().getName()+ ". Now they are " +action.nextRandEvent()+ "!");
            }
            if(source == gameView.getCleanButton())
            {
                System.out.println("clean pressed");
                action.pickClean();
                gameView.getPetIsLabel().setText("You just cleaned " +model.getMyPet().getName()+ ". Now they are " +action.nextRandEvent()+ "!");
            }
            
            
            gameView.getHappyStatLabel().setText(model.getMyPet().getHappyMeter()+"");
            gameView.getFoodStatLabel().setText(model.getMyPet().getHungerMeter()+"");
            gameView.getCleanStatLabel().setText(model.getMyPet().getCleanMeter()+"");
            
            gameView.getNumRounds().setText("Rounds Played: "+model.getOwner().getRounds());
            
            if(model.getMyPet().getHappyMeter() <= 0 || model.getMyPet().getHungerMeter() <= 0 || model.getMyPet().getCleanMeter() <= 0)
            {
                gameView.getPlayButton().setEnabled(false);
                gameView.getFeedButton().setEnabled(false);
                gameView.getCleanButton().setEnabled(false);
                
                gameView.getPetIsLabel().setVisible(false);
                gameView.getPetIsPanel().add(gameView.getEndLabel());
                gameView.getPetIsPanel().add(gameView.getEndButton());
            }
            gameView.getGamePanel().repaint();
            
            if(source == gameView.getEndButton())
            {
                gameView.setVisible(false);
                menuView.setVisible(true);
            }
        }
    }
}
