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
    private OwnerModel owner;
    private LoginView loginView;
    private SignUpView signUpView;
    private MenuView menuView;
    private StatsView statsView;
    private SelectView selectView;
    private GameView gameView;
    
    private Actions action;
    
    public Control(OwnerModel owner) {
        
        this.owner = owner;
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
        signUpView.getBackButton().addActionListener(this);
        
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
            owner.setMyPet(new BlueJay());
            gameView = new GameView("Mordecai", new File("petAssets/bluejay.jpg"));
            id = 1;
        }
        if(source == selectView.getCatLabel())
        {
            owner.setMyPet(new Shorthair());
            gameView = new GameView("Eve", new File("petAssets/shorthair.jpg"));
            id = 2;
        }
        if(source == selectView.getDogLabel())
        {
            owner.setMyPet(new Labrador());
            gameView = new GameView("Charlie", new File("petAssets/lab.jpg"));
            id = 3;
        }
        selectView.setPetSelected(true);
        selectView.setVisible(false);
        owner.setRounds(1);
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
        VirtualPetDB.insertOwner(owner.getUsername(), owner.getPassword(), id);
        this.action = new Actions(owner);
        
        gameView.getPlayButton().addActionListener(this);
        gameView.getFeedButton().addActionListener(this);
        gameView.getCleanButton().addActionListener(this);
        gameView.getQuitButton().addActionListener(this);
        
        gameView.getHappyStatLabel().setText(owner.getMyPet().getHappyMeter()+"");
        gameView.getFoodStatLabel().setText(owner.getMyPet().getFoodMeter()+"");
        gameView.getCleanStatLabel().setText(owner.getMyPet().getCleanMeter()+"");
        
        gameView.getPetName().setText("Name: " +owner.getMyPet().getName());
        gameView.getPetBreed().setText("Breed: "+owner.getMyPet().getBreed());
        gameView.getPetDiff().setText("Difficulty: "+owner.getMyPet().getDiff());
        
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
            
            if(owner.getUsername().equals(user) && owner.getPassword().equals(password))
            {
                loginView.setVisible(false);
                menuView.setVisible(true);
                System.out.println("Login Successful");
            }
            else
            {
                if(VirtualPetDB.getOwnersMap().containsKey(user))
                {
                    if(VirtualPetDB.getOwnersMap().get(user).equals(password))
                    {
                        loginView.getSuccessLabel().setForeground(new Color(6, 156, 24));
                        loginView.getSuccessLabel().setText("Login Successful");
                        System.out.println("Login Successful");
                        owner.setUsername(user);
                        owner.setPassword(password);
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
                if(VirtualPetDB.getOwnersMap().containsKey(user))
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
                        owner.setUsername(user);
                        owner.setPassword(pass2);
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
        
        if(source == signUpView.getBackButton())
        {
            signUpView.setVisible(false);
            loginView.getUserField().setText("");
            loginView.getPassField().setText("");
            loginView.getSuccessLabel().setText("");
            loginView.setVisible(true);
        }
        
        if(!VirtualPetDB.getOwnersMap().containsKey(owner.getUsername()))
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
            menuView.getPetList().setListData(VirtualPetDB.getSavedPets(owner.getUsername()).toArray());
            System.out.println("Load Game button clicked");
        }
        
        if(source == menuView.getStatsButton())
        {
            menuView.setVisible(false);
            statsView.setVisible(true);
            statsView.getTopFiveLabel().setText("<html>"+VirtualPetDB.getTopRounds()+"</html>");
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
            statsView.getDiffOwnersLabel().setText("<html>"+VirtualPetDB.getDiff(statsView.getDiffBox().getSelectedItem().toString())+"</html>");
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
                int id = 0;
                String[] pet = selectedPet.split(" \\| ", 5);
                int rounds = Integer.parseInt(pet[1].split(": ")[1]) + 1;
                int happy = Integer.parseInt(pet[2].split(": ")[1]);
                int food = Integer.parseInt(pet[3].split(": ")[1]);
                int clean = Integer.parseInt(pet[4].split(": ")[1]);
                
                if(pet[0].equals("Mordecai the Blue Jay"))
                {
                    owner.setMyPet(new BlueJay(happy, food, clean));
                    owner.setRounds(rounds);
                    gameView = new GameView("Mordecai", new File("petAssets/bluejay.jpg"));
                    id = 1;
                }
                else if(pet[0].equals("Eve the Shorthair"))
                {
                    owner.setMyPet(new Shorthair(happy, food, clean));
                    owner.setRounds(rounds);
                    gameView = new GameView("Eve", new File("petAssets/shorthair.jpg"));
                    id = 2;
                }
                else if(pet[0].equals("Charlie the Labrador"))
                {
                    owner.setMyPet(new Labrador(happy, food, clean));
                    owner.setRounds(rounds);
                    gameView = new GameView("Charlie", new File("petAssets/lab.jpg"));
                    id = 3;
                }
                this.petSelected(gameView, id);
                menuView.getLoadFrame().setVisible(false);
                menuView.setPetSelected(true);
                VirtualPetDB.removeSavedPet(owner.getUsername(), id, rounds - 1, happy, food, clean);
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
                    owner.getMyPet().setHappyMeter(owner.getMyPet().getHappyMeter() + 3);
                    nextEvent = action.nextRandEvent();
                }
                gameView.getPetIsLabel().setText("You just played with " +owner.getMyPet().getName()+ ". Now they are " +nextEvent+ "!");            }
            if(source == gameView.getFeedButton())
            {
                action.pickFeed();
                String nextEvent = action.nextRandEvent();
                while(nextEvent.equals("hungry"))
                {
                    owner.getMyPet().setFoodMeter(owner.getMyPet().getFoodMeter() + 3);
                    nextEvent = action.nextRandEvent();
                }
                gameView.getPetIsLabel().setText("You just fed " +owner.getMyPet().getName()+ ". Now they are " +nextEvent+ "!");            }
            if(source == gameView.getCleanButton())
            {
                action.pickClean();
                String nextEvent = action.nextRandEvent();
                while(nextEvent.equals("dirty"))
                {
                    owner.getMyPet().setCleanMeter(owner.getMyPet().getCleanMeter() + 3);
                    nextEvent = action.nextRandEvent();
                }
                gameView.getPetIsLabel().setText("<html>You just cleaned " +owner.getMyPet().getName()+ ". Now they are " +nextEvent+ "!</html>");
            }
            
            
            gameView.getHappyStatLabel().setText(owner.getMyPet().getHappyMeter()+"");
            gameView.getFoodStatLabel().setText(owner.getMyPet().getFoodMeter()+"");
            gameView.getCleanStatLabel().setText(owner.getMyPet().getCleanMeter()+"");
            
            gameView.getNumRounds().setText("Rounds Played: "+owner.getRounds());
            
            if(owner.getMyPet().getHappyMeter() <= 0 || owner.getMyPet().getFoodMeter() <= 0 || owner.getMyPet().getCleanMeter() <= 0)
            {
                gameView.getPlayButton().setEnabled(false);
                gameView.getFeedButton().setEnabled(false);
                gameView.getCleanButton().setEnabled(false);
                
                gameView.getPetIsLabel().setVisible(false);
                
                if(owner.getMyPet().getHappyMeter() <= 0)
                    gameView.getEndLabel().setText("<html>"+owner.getMyPet().happyAtZero()+ " " +gameView.getEndLabel().getText()+"</html>");
                else if(owner.getMyPet().getFoodMeter() <= 0)
                    gameView.getEndLabel().setText("<html>"+owner.getMyPet().foodAtZero()+ " " +gameView.getEndLabel().getText()+"</html>");
                else if(owner.getMyPet().getCleanMeter() <= 0)
                    gameView.getEndLabel().setText("<html>"+owner.getMyPet().cleanAtZero()+ " " +gameView.getEndLabel().getText()+"</html>");
                
                gameView.getPetIsPanel().add(gameView.getEndLabel());
            }
            gameView.getGamePanel().repaint();
            
            if(source == gameView.getQuitButton())
            {
                VirtualPetDB.insertSavedPets(owner.getUsername(), owner.getRounds(), owner.getMyPet().getHappyMeter(), owner.getMyPet().getFoodMeter(),  owner.getMyPet().getCleanMeter());
                gameView.setVisible(false);
                menuView.setVisible(true);
            }
        }
    }
}
