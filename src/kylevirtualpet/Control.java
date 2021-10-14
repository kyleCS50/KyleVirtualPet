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
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


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
    private StatsView statsView;
    private SelectView selectView;
    private GameView gameView;
    
    private Actions action;
    
    public Control(Model model) {
        
        this.model = model;
        this.loginView = new LoginView("Login");
        this.signUpView = new SignUpView("Sign Up");
        this.menuView = new MenuView("Menu");
        this.statsView = new StatsView("Game Stats");
        this.selectView = new SelectView("Select a Pet");
        
        menuView.getPlayGameButton().addActionListener(this);
        menuView.getStatsButton().addActionListener(this);
        menuView.getHowToButton().addActionListener(this);
        menuView.getDoneButton().addActionListener(this);
        
        loginView.getLoginButton().addActionListener(this);
        loginView.getSignUpButton().addActionListener(this);
        
        signUpView.getCreateButton().addActionListener(this);

        statsView.getDiffButton().addActionListener(this);
                
        selectView.getBirdLabel().addMouseListener(this);
        selectView.getCatLabel().addMouseListener(this);
        selectView.getDogLabel().addMouseListener(this);
        selectView.getBackButton().addActionListener(this);
    }
    
    
    
    @Override
    public void mouseClicked(MouseEvent me) {
        Object source = me.getSource();
        int id = 0;
        if(source == selectView.getBirdLabel())
        {
            model.setMyPet(new BlueJay("Mordecai"));
            gameView = new GameView("Mordecai", new File("petAssets/bluejay.jpg"));
            id = 1;
        }

        if(source == selectView.getCatLabel())
        {
            model.setMyPet(new Shorthair("Eve"));
            gameView = new GameView("Eve", new File("petAssets/shorthair.jpg"));
   id = 2;
        }
        if(source == selectView.getDogLabel())
        {
            model.setMyPet(new Labrador("Charlie"));
            gameView = new GameView("Charlie", new File("petAssets/lab.jpg"));
            id = 3;
        }
        
        VirtualPetsDB.insertOwner(model.getUsername(),model.getPassword(), id);
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
            try {
                System.out.println("Log In button pressed");
                String user = loginView.getLiUserField().getText();
                String password = loginView.getLiPassField().getText();
                
                if(model.getUsername().equals(user) && model.getPassword().equals(password))
                {
                    loginView.setVisible(false);
                    menuView.setVisible(true);
                }
                
                if(VirtualPetsDB.getOwnersMap().containsKey(user))
                {
                    if(VirtualPetsDB.getOwnersMap().get(user).equals(password))
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
                        loginView.getLiSuccessLabel().setText("Incorrect password. Please try again");
                        System.out.println("Login Unsuccessful");
                    }
                }
                else
                {
                    loginView.getLiSuccessLabel().setForeground(Color.RED);
                    loginView.getLiSuccessLabel().setText("Owner not found, try Signing Up!");
                    System.out.println("Login Unsuccessful");
                }
            } catch (SQLException ex) {
                Logger.getLogger(Control.class.getName()).log(Level.SEVERE, null, ex);
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
            System.out.println("Create Owner button clicked");
            String user = signUpView.getSuUserField().getText().trim();
            String pass1 = signUpView.getSuPassField().getText();
            String pass2 = signUpView.getSuConfirmField().getText();
            
            if(user.equals("") || pass1.equals("") || pass2.equals(""))
            {
                signUpView.getSuccessLabel().setForeground(Color.RED);
                signUpView.getSuccessLabel().setText("Fields can not remain empty.");
            }
            else
            {
                try {
                    if(VirtualPetsDB.getOwnersMap().containsKey(user))
                    {
                        signUpView.getSuSuccessLabel().setForeground(Color.RED);
                        signUpView.getSuSuccessLabel().setText("Please enter a different username.");
                        signUpView.getSuUserField().setText("");
                        signUpView.getSuPassField().setText("");
                        signUpView.getSuConfirmField().setText("");
                        System.out.println("Create Owner Unsuccessful");
                    }
                    else
                    {
                        if(pass1.equals(pass2))
                        {
                            signUpView.getSuSuccessLabel().setForeground(new Color(6, 156, 24));
                            signUpView.getSuSuccessLabel().setText("Owner Created Successfully!");
                            model.setUsername(user);
                            model.setPassword(pass2);
                            signUpView.setVisible(false);
                            menuView.setVisible(true);
                            System.out.println("Create Owner Successful");
                        }
                        else
                        {
                            signUpView.getSuSuccessLabel().setForeground(Color.RED);
                            signUpView.getSuSuccessLabel().setText("Passwords must match to create new owner.");
                            signUpView.getSuPassField().setText("");
                            signUpView.getSuConfirmField().setText("");
                            System.out.println("Create Owner Unsuccessful");
                        }
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(Control.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        
        if(source == selectView.getBackButton())
    {
            selectView.setVisible(false);
            menuView.setVisible(true);
        }

        if(source == menuView.getPlayGameButton())
        {
            menuView.setVisible(false);
            selectView.setVisible(true);
            System.out.println("Play button clicked");
        }
        
        if(source == menuView.getStatsButton())
        {
            menuView.setVisible(false(;
statsView.setVisible(true);
        }
        
        if(source == menuView.getHowToButton())
        {
            menuView.getHowToFrame().setVisible(true);
            System.out.println("How To button clicked");
        }
       
    
        
        if(source == statsView.getDiffButton())
        {
            try {
                statsView.getDiffOwnersLabel().setText("<html>"+VirtualPetsDB.getDiff(statsView.getDiffBox().getSelectedItem().toString())+"</html>");
            } catch (SQLException ex) {
                Logger.getLogger(Control.class.getName()).log(Level.SEVERE, null, ex);
            }
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
                VirtualPetsDB.insertSavedPets(model.getOwner().getRounds(), model.getMyPet().getHappyMeter(), model.getMyPet().getHungerMeter(),  model.getMyPet().getCleanMeter());
                gameView.setVisible(false);
                menuView.setVisible(true);
            }
        }
    }
}
