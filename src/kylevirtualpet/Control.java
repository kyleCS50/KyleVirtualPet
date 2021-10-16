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
        
        menuView.getNewGameButton().addActionListener(this);
        menuView.getLoadGameButton().addActionListener(this);
        menuView.getStatsButton().addActionListener(this);
        menuView.getHowToButton().addActionListener(this);
        menuView.getDoneButton().addActionListener(this);
        menuView.getLogOutButton().addActionListener(this);
        menuView.getLoadButton().addActionListener(this);
        menuView.getBackButton().addActionListener(this);
        
        loginView.getLoginButton().addActionListener(this);
        loginView.getSignUpButton().addActionListener(this);
        
        signUpView.getCreateButton().addActionListener(this);
        
        statsView.getBackButton().addActionListener(this);
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
            model.setMyPet(new BlueJay());
            gameView = new GameView("Mordecai", new File("petAssets/bluejay.jpg"));
            id = 1;
        }
        if(source == selectView.getCatLabel())
        {
            model.setMyPet(new Shorthair());
            gameView = new GameView("Eve", new File("petAssets/shorthair.jpg"));
            id = 2;
        }
        if(source == selectView.getDogLabel())
        {
            model.setMyPet(new Labrador());
            gameView = new GameView("Charlie", new File("petAssets/lab.jpg"));
            id = 3;
        }
        selectView.setPetSelected(true);
        selectView.setVisible(false);
        
        this.petSelected(gameView, id);
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
    
    private void petSelected(GameView gameView, int id)
    {
        VirtualPetsDB.insertOwner(model.getUsername(),model.getPassword(), id);
        this.action = new Actions(model.getMyPet(), model.getOwner());
        
        gameView.getPlayButton().addActionListener(this);
        gameView.getFeedButton().addActionListener(this);
        gameView.getCleanButton().addActionListener(this);
        gameView.getQuitButton().addActionListener(this);
        
        gameView.getHappyStatLabel().setText(model.getMyPet().getHappyMeter()+"");
        gameView.getFoodStatLabel().setText(model.getMyPet().getFoodMeter()+"");
        gameView.getCleanStatLabel().setText(model.getMyPet().getCleanMeter()+"");
        
        gameView.getPetName().setText("Name: " +model.getMyPet().getName());
        gameView.getPetBreed().setText("Breed: "+model.getMyPet().getBreed());
        gameView.getPetDiff().setText("Difficulty: "+model.getMyPet().getDiff());
        
        gameView.getPlayButton().setEnabled(true);
        gameView.getFeedButton().setEnabled(true);
        gameView.getCleanButton().setEnabled(true);
        
        gameView.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();
        
        if(source == menuView.getNewGameButton())
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
            
            if(model.getUsername().equals(user) && model.getPassword().equals(password))
            {
                loginView.setVisible(false);
                menuView.setVisible(true);
                System.out.println("Login Successful");
            }
            else
            {
                if(VirtualPetsDB.getOwnersMap().containsKey(user))
                {
                    if(VirtualPetsDB.getOwnersMap().get(user).equals(password))
                    {
                        loginView.getSuccessLabel().setForeground(new Color(6, 156, 24));
                        loginView.getSuccessLabel().setText("Login Successful");
                        System.out.println("Login Successful");
                        model.setUsername(user);
                        model.setPassword(password);
                        loginView.setVisible(false);
                        menuView.setVisible(true);
                    }
                    else
                    {
                        loginView.getSuccessLabel().setForeground(Color.RED);
                        loginView.getSuccessLabel().setText("Incorrect password. Please try again");
                        System.out.println("Login Unsuccessful");
                    }
                }
                else
                {
                    loginView.getSuccessLabel().setForeground(Color.RED);
                    loginView.getSuccessLabel().setText("Owner not found, try Signing Up!");
                    System.out.println("Login Unsuccessful");
                }
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
                if(VirtualPetsDB.getOwnersMap().containsKey(user))
                {
                    signUpView.getSuccessLabel().setForeground(Color.RED);
                    signUpView.getSuccessLabel().setText("Please enter a different username.");
                    signUpView.getUserField().setText("");
                    signUpView.getPassField().setText("");
                    signUpView.getConfirmPassField().setText("");
                    System.out.println("Create Owner Unsuccessful");
                }
                else
                {
                    if(pass1.equals(pass2))
                    {
                        signUpView.getSuccessLabel().setForeground(new Color(6, 156, 24));
                        signUpView.getSuccessLabel().setText("Owner Created Successfully!");
                        model.setUsername(user);
                        model.setPassword(pass2);
                        signUpView.setVisible(false);
                        menuView.setVisible(true);
                        System.out.println("Create Owner Successful");
                    }
                    else
                    {
                        signUpView.getSuccessLabel().setForeground(Color.RED);
                        signUpView.getSuccessLabel().setText("Passwords must match to create new owner.");
                        signUpView.getPassField().setText("");
                        signUpView.getConfirmPassField().setText("");
                        System.out.println("Create Owner Unsuccessful");
                    }
                }
            }
        }
        
        if(!VirtualPetsDB.getOwnersMap().containsKey(model.getUsername()))
            menuView.getLoadGameButton().setEnabled(false);
        else
            menuView.getLoadGameButton().setEnabled(true);
        
        if(source == menuView.getNewGameButton())
        {
            menuView.setVisible(false);
            selectView.setVisible(true);
            System.out.println("New Game button clicked");
        }
        
        if(source == menuView.getLoadGameButton())
        {
            menuView.getLoadFrame().setVisible(true);
            menuView.getPetList().setListData(VirtualPetsDB.getSavedPets(model.getUsername()).toArray());
            System.out.println("Load Game button clicked");
        }
        
        if(source == menuView.getStatsButton())
        {
            menuView.setVisible(false);
            statsView.setVisible(true);
            statsView.getTopThreeLabel().setText("<html>"+VirtualPetsDB.getTopRounds()+"</html>");
        }
        
        if(source == menuView.getHowToButton())
        {
            menuView.getHowToFrame().setVisible(true);
            System.out.println("How To button clicked");
        }
        
        if(source == menuView.getLogOutButton())
        {
            loginView.getUserField().setText("");
            loginView.getPassField().setText("");
            loginView.getSuccessLabel().setText("");
            menuView.setVisible(false);
            loginView.setVisible(true);
        }
        
        if(source == statsView.getBackButton())
        {
            statsView.setVisible(false);
            menuView.setVisible(true);
        }
        
        if(source == statsView.getDiffButton())
        {
            statsView.getDiffOwnersLabel().setText("<html>"+VirtualPetsDB.getDiff(statsView.getDiffBox().getSelectedItem().toString())+"</html>");
        }
        
        if(source == selectView.getBackButton())
        {
            selectView.setVisible(false);
            menuView.setVisible(true);
        }
        
        if(source == menuView.getBackButton())
        {
            menuView.getLoadFrame().setVisible(false);
        }
        
        if(source == menuView.getLoadButton())
        {
            if(!menuView.getPetList().isSelectionEmpty())
            {
                String selectedPet = menuView.getPetList().getSelectedValue().toString();
                //int index = menuView.getPetList().getSelectedIndex();
                int id = 0;
                String[] pet = selectedPet.split(" \\| ", 5);
                int rounds = Integer.parseInt(pet[1].split(": ")[1]);
                int happy = Integer.parseInt(pet[2].split(": ")[1]);
                int food = Integer.parseInt(pet[3].split(": ")[1]);
                int clean = Integer.parseInt(pet[4].split(": ")[1]);
                
                if(pet[0].equals("Mordecai the Blue Jay"))
                {
                    model.setMyPet(new BlueJay(happy, food, clean));
                    model.getOwner().setRounds(rounds);
                    gameView = new GameView("Mordecai", new File("petAssets/bluejay.jpg"));
                    id = 1;
                }
                else if(pet[0].equals("Eve the Shorthair"))
                {
                    model.setMyPet(new Shorthair(happy, food, clean));
                    model.getOwner().setRounds(rounds);
                    gameView = new GameView("Eve", new File("petAssets/shorthair.jpg"));
                    id = 1;
                }
                else if(pet[0].equals("Charlie the Labarador"))
                {
                    model.setMyPet(new Labrador(happy, food, clean));
                    model.getOwner().setRounds(rounds);
                    gameView = new GameView("Charlie", new File("petAssets/lab.jpg"));
                    id = 1;
                }
                this.petSelected(gameView, id);
                menuView.setPetSelected(true);
            }
        }
        
        if(selectView.isPetSelected() || menuView.isPetSelected())
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
                    model.getMyPet().setFoodMeter(model.getMyPet().getFoodMeter() + 3);
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
            gameView.getFoodStatLabel().setText(model.getMyPet().getFoodMeter()+"");
            gameView.getCleanStatLabel().setText(model.getMyPet().getCleanMeter()+"");
            
            gameView.getNumRounds().setText("Rounds Played: "+model.getOwner().getRounds());
            
            if(model.getMyPet().getHappyMeter() <= 0 || model.getMyPet().getFoodMeter() <= 0 || model.getMyPet().getCleanMeter() <= 0)
            {
                gameView.getPlayButton().setEnabled(false);
                gameView.getFeedButton().setEnabled(false);
                gameView.getCleanButton().setEnabled(false);
                
                gameView.getPetIsLabel().setVisible(false);
                
                if(model.getMyPet().getHappyMeter() <= 0)
                    gameView.getEndLabel().setText(model.getMyPet().happyAtZero()+ " " +gameView.getEndLabel().getText());
                else if(model.getMyPet().getFoodMeter() <= 0)
                    gameView.getEndLabel().setText(model.getMyPet().foodAtZero()+ " " +gameView.getEndLabel().getText());
                else if(model.getMyPet().getCleanMeter() <= 0)
                    gameView.getEndLabel().setText(model.getMyPet().cleanAtZero()+ " " +gameView.getEndLabel().getText());
                
                gameView.getPetIsPanel().add(gameView.getEndLabel());
            }
            gameView.getGamePanel().repaint();
            
            if(source == gameView.getQuitButton())
            {
                VirtualPetsDB.insertSavedPets(model.getUsername(), model.getOwner().getRounds(), model.getMyPet().getHappyMeter(), model.getMyPet().getFoodMeter(),  model.getMyPet().getCleanMeter());
                gameView.setVisible(false);
                menuView.setVisible(true);
            }
        }
    }
}
