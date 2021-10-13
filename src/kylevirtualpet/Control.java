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
    
    public Control(Model model)
    {
        this.model = model;
        
        this.menuView = new MenuView("Menu");
        this.loginView = new LoginView("LogIn");
        this.signUpView = new SignUpView("Sign Up");
        this.selectView = new SelectView("Select Pet");
        
        menuView.getPlayGameButton().addActionListener(this);
        menuView.getHowToButton().addActionListener(this);
        menuView.getDoneButton().addActionListener(this);
        
        loginView.getLoginButton().addActionListener(this);
        loginView.getSignUpButton().addActionListener(this);
        
        signUpView.getCreateButton().addActionListener(this);
        
        selectView.getBirdLabel().addMouseListener(this);
        selectView.getCatLabel().addMouseListener(this);
        selectView.getDogLabel().addMouseListener(this);
        selectView.getBackButton().addActionListener(this);
    }
    
    
    
    @Override
    public void mouseClicked(MouseEvent me) {
        Object source = me.getSource();
        if(source == selectView.getBirdLabel())
        {
            model.setMyPet(new BlueJay("Mordecai"));
            gameView = new GameView("Mordecai", new File("petAssets/bluejay.jpg"));
        }
        if(source == selectView.getCatLabel())
        {
            model.setMyPet(new Shorthair("Eve"));
            gameView = new GameView("Eve", new File("petAssets/shorthair.jpg"));
        }
        if(source == selectView.getDogLabel())
        {
            model.setMyPet(new Labrador("Charlie"));
            gameView = new GameView("Charlie", new File("petAssets/lab.jpg"));
        }
        
        this.action = new Actions(model.getMyPet(), model.getOwner());
        
        gameView.getPlayButton().addActionListener(this);
        gameView.getFeedButton().addActionListener(this);
        gameView.getCleanButton().addActionListener(this);
        gameView.getQuitButton().addActionListener(this);
        
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
        
        if(source == loginView.getLoginButton())
        {
            System.out.println("Log In button pressed");
            String user = loginView.getUserField().getText();
            String password = loginView.getPassField().getText();
            
            if(user.equals(model.getUser()) && password.equals(model.getPass()))
            {
                loginView.getSuccessLabel().setForeground(new Color(6, 156, 24));
                loginView.getSuccessLabel().setText("Login Successful");
                System.out.println("Login Successful");
                loginView.setVisible(false);
                menuView.setVisible(true);
            }
            else
            {
                loginView.getSuccessLabel().setForeground(Color.RED);
                loginView.getSuccessLabel().setText("Wrong username or password");
                System.out.println("Login Unsuccessful");
            }
        }
        
        if(source == loginView.getSignUpButton())
        {
            System.out.println("Sign Up button clicked");
            signUpView.getUserField().setText("");
            signUpView.getPassField().setText("");
            signUpView.getConfirmPassField().setText("");
            signUpView.getSuccessLabel().setText("");
            loginView.setVisible(false);
            signUpView.setVisible(true);
        }
        
        if(source == signUpView.getCreateButton())
        {
            System.out.println("Create Account button clicked");
            String user = signUpView.getUserField().getText().trim();
            String pass1 = signUpView.getPassField().getText();
            String pass2 = signUpView.getConfirmPassField().getText();
            
            if(user.equals("") || pass1.equals("") || pass2.equals(""))
            {
                signUpView.getSuccessLabel().setForeground(Color.RED);
                signUpView.getSuccessLabel().setText("Fields can not remain empty.");
            }
            else
            {
                if(pass1.equals(pass2))
                {
                    signUpView.getSuccessLabel().setForeground(new Color(6, 156, 24));
                    signUpView.getSuccessLabel().setText("Account Created Successfully!");
                    model.setUser(user);
                    model.setPass(pass2);
                    signUpView.setVisible(false);
                    menuView.setVisible(true);
                    System.out.println("Create Account Successful");
                }
                else
                {
                    signUpView.getSuccessLabel().setForeground(Color.RED);
                    signUpView.getSuccessLabel().setText("Passwords must match to create new account.");
                    signUpView.getPassField().setText("");
                    signUpView.getConfirmPassField().setText("");
                    System.out.println("Create Account Unsuccessful");
                }
            }
        }
        
        if(source == selectView.getBackButton())
        {
            selectView.setVisible(false);
            menuView.setVisible(true);
        }
        
        if(selectView.isPetSelected())
        {
            if(source == gameView.getPlayButton())
            {
                action.pickPlay();
                String nextEvent = action.nextRandEvent();
                while(nextEvent.equals("sad"))
                {
                    model.getMyPet().setHappyMeter(model.getMyPet().getHappyMeter() + 3);
                    nextEvent = action.nextRandEvent();
                }
                gameView.getPetIsLabel().setText("You just played with " +model.getMyPet().getName()+ ". Now they are " +nextEvent+ "!");            }
            if(source == gameView.getFeedButton())
            {
                action.pickFeed();
                String nextEvent = action.nextRandEvent();
                while(nextEvent.equals("hungry"))
                {
                    model.getMyPet().setHungerMeter(model.getMyPet().getHungerMeter() + 3);
                    nextEvent = action.nextRandEvent();
                }
                gameView.getPetIsLabel().setText("You just fed " +model.getMyPet().getName()+ ". Now they are " +nextEvent+ "!");            }
            if(source == gameView.getCleanButton())
            {
                action.pickClean();
                String nextEvent = action.nextRandEvent();
                while(nextEvent.equals("dirty"))
                {
                    model.getMyPet().setCleanMeter(model.getMyPet().getCleanMeter() + 3);
                    nextEvent = action.nextRandEvent();
                }
                gameView.getPetIsLabel().setText("You just cleaned " +model.getMyPet().getName()+ ". Now they are " +nextEvent+ "!");
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
                
                if(model.getMyPet().getHappyMeter() <= 0)
                    gameView.getEndLabel().setText(model.getMyPet().happyAtZero()+ " " +gameView.getEndLabel().getText());
                else if(model.getMyPet().getHungerMeter() <= 0)
                    gameView.getEndLabel().setText(model.getMyPet().foodAtZero()+ " " +gameView.getEndLabel().getText());
                else if(model.getMyPet().getCleanMeter() <= 0)
                    gameView.getEndLabel().setText(model.getMyPet().cleanAtZero()+ " " +gameView.getEndLabel().getText());
                
                gameView.getPetIsPanel().add(gameView.getEndLabel());
            }
            gameView.getGamePanel().repaint();
            
            if(source == gameView.getQuitButton())
            {
                gameView.setVisible(false);
                menuView.setVisible(true);
            }
        }
    }
}
