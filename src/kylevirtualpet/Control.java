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
    //instansiate model and views
    private OwnerModel owner;
    private LoginView loginView;
    private SignUpView signUpView;
    private MenuView menuView;
    private StatsView statsView;
    private SelectView selectView;
    private GameView gameView;
    
    //control constructor
    public Control(OwnerModel owner) {
        
        this.owner = owner;
        this.loginView = new LoginView("Login");
        this.signUpView = new SignUpView("Sign Up");
        this.menuView = new MenuView("Menu");
        this.statsView = new StatsView("Game Stats");
        this.selectView = new SelectView("Select a Pet");
        
        //add action listeners
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
        
        //add mouse listeners
        selectView.getBirdLabel().addMouseListener(this);
        selectView.getCatLabel().addMouseListener(this);
        selectView.getDogLabel().addMouseListener(this);
        selectView.getBackButton().addActionListener(this);
    }
    
    //mouse listener for select frame
    @Override
    public void mouseClicked(MouseEvent me) {
        Object source = me.getSource();
        int id = 0;
        if(source == selectView.getBirdLabel()) //if bird is clicked make a new bird game frame
        {
            owner.setMyPet(new BlueJay());
            gameView = new GameView("Mordecai", new File("petAssets/bluejay.jpg"));
            id = 1;
        }
        if(source == selectView.getCatLabel()) //if cat is clicked make a new cat game frame
        {
            owner.setMyPet(new Shorthair());
            gameView = new GameView("Eve", new File("petAssets/shorthair.jpg"));
            id = 2;
        }
        if(source == selectView.getDogLabel()) //if dog is clicked make a new dog game frame
        {
            owner.setMyPet(new Labrador());
            gameView = new GameView("Charlie", new File("petAssets/lab.jpg"));
            id = 3;
        }
        selectView.setPetSelected(true); //set pet selected to true
        selectView.setVisible(false); //make select view not visible
        this.petSelected(gameView, id); //run pet selected method
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
    
    //method if pet is selected
    private void petSelected(GameView gameView, int id)
    {
        VirtualPetDB.insertOwner(owner.getUsername(), owner.getPassword(), id); //insert owner into db
        
        //add action listeners for game view
        gameView.getPlayButton().addActionListener(this);
        gameView.getFeedButton().addActionListener(this);
        gameView.getCleanButton().addActionListener(this);
        gameView.getQuitButton().addActionListener(this);
        
        //set stats labels
        gameView.getHappyStatLabel().setText(owner.getMyPet().getHappyMeter()+"");
        gameView.getFoodStatLabel().setText(owner.getMyPet().getFoodMeter()+"");
        gameView.getCleanStatLabel().setText(owner.getMyPet().getCleanMeter()+"");
        
        //set pet info label
        gameView.getPetName().setText("Name: " +owner.getMyPet().getName());
        gameView.getPetBreed().setText("Breed: "+owner.getMyPet().getBreed());
        gameView.getPetDiff().setText("Difficulty: "+owner.getMyPet().getDiff());
        
        //enable buttons
        gameView.getPlayButton().setEnabled(true);
        gameView.getFeedButton().setEnabled(true);
        gameView.getCleanButton().setEnabled(true);
        
        //make frame visible
        gameView.setVisible(true);
    }
    
    //action listener methods
    @Override
    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();
        
        //if login button is clicked
        if(source == loginView.getLoginButton())
        {
            String user = loginView.getUserField().getText();
            String password = loginView.getPassField().getText();
            
            //check if entered name and password match admin name and password
            if(owner.getUsername().equals(user) && owner.getPassword().equals(password))
            {
                loginView.setVisible(false);
                menuView.setVisible(true);
            }
            else
            {
                //check if name is in current owner database
                if(VirtualPetDB.getOwnersMap().containsKey(user))
                {
                    //check if password is correct
                    if(VirtualPetDB.getOwnersMap().get(user).equals(password))
                    {
                        loginView.getSuccessLabel().setForeground(new Color(6, 156, 24));
                        loginView.getSuccessLabel().setText("Login Successful");
                        owner.setUsername(user);
                        owner.setPassword(password);
                        loginView.setVisible(false);
                        menuView.setVisible(true);
                    }
                    else
                    {
                        loginView.getSuccessLabel().setForeground(Color.RED);
                        loginView.getSuccessLabel().setText("Incorrect password. Please try again");
                    }
                }
                else
                {
                    loginView.getSuccessLabel().setForeground(Color.RED);
                    loginView.getSuccessLabel().setText("Owner not found, try Signing Up!");
                }
            }
        }
        
        //if sign up button is clicked on log in frame
        if(source == loginView.getSignUpButton())
        {
            signUpView.getUserField().setText("");
            signUpView.getPassField().setText("");
            signUpView.getConfirmPassField().setText("");
            signUpView.getSuccessLabel().setText("");
            loginView.setVisible(false);
            signUpView.setVisible(true);
        }
        
        //if create account button is clicked
        if(source == signUpView.getCreateButton())
        {
            String user = signUpView.getUserField().getText().trim();
            String pass1 = signUpView.getPassField().getText();
            String pass2 = signUpView.getConfirmPassField().getText();
            
            //check if fields are empty
            if(user.equals("") || pass1.equals("") || pass2.equals(""))
            {
                signUpView.getSuccessLabel().setForeground(Color.RED);
                signUpView.getSuccessLabel().setText("Fields can not remain empty.");
            }
            else
            {
                //if owner is already created
                if(VirtualPetDB.getOwnersMap().containsKey(user))
                {
                    signUpView.getSuccessLabel().setForeground(Color.RED);
                    signUpView.getSuccessLabel().setText("Please enter a different username.");
                    signUpView.getUserField().setText("");
                    signUpView.getPassField().setText("");
                    signUpView.getConfirmPassField().setText("");
                }
                else
                {
                    //if passwords match
                    if(pass1.equals(pass2))
                    {
                        signUpView.getSuccessLabel().setForeground(new Color(6, 156, 24));
                        signUpView.getSuccessLabel().setText("Owner Created Successfully!");
                        owner.setUsername(user);
                        owner.setPassword(pass2);
                        signUpView.setVisible(false);
                        menuView.setVisible(true);
                    }
                    else
                    {
                        signUpView.getSuccessLabel().setForeground(Color.RED);
                        signUpView.getSuccessLabel().setText("Passwords must match to create new owner.");
                        signUpView.getPassField().setText("");
                        signUpView.getConfirmPassField().setText("");
                    }
                }
            }
        }
        
        //if back button is clikced
        if(source == signUpView.getBackButton())
        {
            signUpView.setVisible(false);
            loginView.getUserField().setText("");
            loginView.getPassField().setText("");
            loginView.getSuccessLabel().setText("");
            loginView.setVisible(true);
        }
        
        //if owner is in map enable load game button
        if(!VirtualPetDB.getOwnersMap().containsKey(owner.getUsername()))
            menuView.getLoadGameButton().setEnabled(false);
        else
            menuView.getLoadGameButton().setEnabled(true);
        
        //if owner clicks new game button open select screen
        if(source == menuView.getNewGameButton())
        {
            menuView.setVisible(false);
            selectView.setVisible(true);
        }
        
        //if owner clicks load button open load screen
        if(source == menuView.getLoadGameButton())
        {
            menuView.getLoadFrame().setVisible(true);
            menuView.getPetList().setListData(VirtualPetDB.getSavedPets(owner.getUsername()).toArray());
        }
        
        //if owner clicks stats button open stats screen
        if(source == menuView.getStatsButton())
        {
            menuView.setVisible(false);
            statsView.setVisible(true);
            statsView.getTopFiveLabel().setText("<html>"+VirtualPetDB.getTopRounds()+"</html>");
        }
        
        //if how to button is clicked on menu
        if(source == menuView.getHowToButton())
        {
            menuView.getHowToFrame().setVisible(true);
        }
        
        //if done button is clicked on how to
        if(source == menuView.getDoneButton())
        {
            menuView.getHowToFrame().setVisible(false);
        }
        
        //if owner logs out enable login frame set fields to empty
        if(source == menuView.getLogOutButton())
        {
            loginView.getUserField().setText("");
            loginView.getPassField().setText("");
            loginView.getSuccessLabel().setText("");
            menuView.setVisible(false);
            loginView.setVisible(true);
        }
        
        //if owner clicks back button on stats page
        if(source == statsView.getBackButton())
        {
            statsView.setVisible(false);
            menuView.setVisible(true);
        }
        
        //if owner clicks diff button show owners who picked selected difficulty
        if(source == statsView.getDiffButton())
        {
            statsView.getDiffOwnersLabel().setText("<html>"+VirtualPetDB.getDiff(statsView.getDiffBox().getSelectedItem().toString())+"</html>");
        }
        
        //if owner clicks back button on select page go back to menu
        if(source == selectView.getBackButton())
        {
            selectView.setVisible(false);
            menuView.setVisible(true);
        }
        
        //if owner clicks back button on load page go back to menu
        if(source == menuView.getBackButton())
        {
            menuView.getLoadFrame().setVisible(false);
        }
        
        //if owner clicks load button
        if(source == menuView.getLoadButton())
        {
            //if user has selected a pet
            if(!menuView.getPetList().isSelectionEmpty())
            {
                String selectedPet = menuView.getPetList().getSelectedValue().toString();
                int id = 0;
                String[] pet = selectedPet.split(" \\| ", 5);
                //split string into stats
                int rounds = Integer.parseInt(pet[1].split(": ")[1]);
                int happy = Integer.parseInt(pet[2].split(": ")[1]);
                int food = Integer.parseInt(pet[3].split(": ")[1]);
                int clean = Integer.parseInt(pet[4].split(": ")[1]);
                
                //if name equals different pet names
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
                
                //call petSelected method
                this.petSelected(gameView, id);
                menuView.getLoadFrame().setVisible(false);
                menuView.setPetSelected(true);
                //removed selected pet
                VirtualPetDB.removeSavedPet(owner.getUsername(), id, rounds, happy, food, clean);
            }
        }
        
        //if a pet is selected 
        if(selectView.isPetSelected() || menuView.isPetSelected())
        {
            //if user clicks play button
            if(source == gameView.getPlayButton())
            {
                owner.play(); //call owner's play method
                String nextEvent = owner.getMyPet().nextRandEvent();
                //if next event is same as last event get a new event
                while(nextEvent.equals("sad"))
                {
                    owner.getMyPet().setHappyMeter(owner.getMyPet().getHappyMeter() + 3);
                    nextEvent = owner.getMyPet().nextRandEvent();
                }
                gameView.getPetIsLabel().setText("You just played with " +owner.getMyPet().getName()+ ". Now they are " +nextEvent+ "!");            }
            //if user clicks feed button
            if(source == gameView.getFeedButton())
            {
                owner.feed(); //call owner feed method
                String nextEvent = owner.getMyPet().nextRandEvent();
                //if event is same as last event
                while(nextEvent.equals("hungry"))
                {
                    owner.getMyPet().setFoodMeter(owner.getMyPet().getFoodMeter() + 3);
                    nextEvent = owner.getMyPet().nextRandEvent();
                }
                gameView.getPetIsLabel().setText("You just fed " +owner.getMyPet().getName()+ ". Now they are " +nextEvent+ "!");            }
            //if user clicks clean button
            if(source == gameView.getCleanButton())
            {
                owner.clean(); //call owner clean method
                String nextEvent = owner.getMyPet().nextRandEvent();
                //if next event is same as last event return new event
                while(nextEvent.equals("dirty"))
                {
                    owner.getMyPet().setCleanMeter(owner.getMyPet().getCleanMeter() + 3);
                    nextEvent = owner.getMyPet().nextRandEvent();
                }
                gameView.getPetIsLabel().setText("<html>You just cleaned " +owner.getMyPet().getName()+ ". Now they are " +nextEvent+ "!</html>");
            }
            
            //update stats for pet after each button click
            gameView.getHappyStatLabel().setText(owner.getMyPet().getHappyMeter()+"");
            gameView.getFoodStatLabel().setText(owner.getMyPet().getFoodMeter()+"");
            gameView.getCleanStatLabel().setText(owner.getMyPet().getCleanMeter()+"");
            
            gameView.getNumRounds().setText("Rounds Played: "+owner.getRounds());
            
            //if any stats go to or below 0
            if(owner.getMyPet().getHappyMeter() <= 0 || owner.getMyPet().getFoodMeter() <= 0 || owner.getMyPet().getCleanMeter() <= 0)
            {
                //disable buttons
                gameView.getPlayButton().setEnabled(false);
                gameView.getFeedButton().setEnabled(false);
                gameView.getCleanButton().setEnabled(false);
                
                gameView.getPetIsLabel().setVisible(false);
                
                //display end message 
                if(owner.getMyPet().getHappyMeter() <= 0)
                    gameView.getEndLabel().setText("<html>"+owner.getMyPet().happyAtZero()+ " " +gameView.getEndLabel().getText()+"</html>");
                else if(owner.getMyPet().getFoodMeter() <= 0)
                    gameView.getEndLabel().setText("<html>"+owner.getMyPet().foodAtZero()+ " " +gameView.getEndLabel().getText()+"</html>");
                else if(owner.getMyPet().getCleanMeter() <= 0)
                    gameView.getEndLabel().setText("<html>"+owner.getMyPet().cleanAtZero()+ " " +gameView.getEndLabel().getText()+"</html>");
                
                gameView.getPetIsPanel().add(gameView.getEndLabel());
            }
            //repaint game panel
            gameView.getGamePanel().repaint();
            
            //if quit button is clicks
            if(source == gameView.getQuitButton())
            {
                //save owner and pet to savedPets table in database
                VirtualPetDB.insertSavedPets(owner.getUsername(), owner.getRounds(), owner.getMyPet().getHappyMeter(), owner.getMyPet().getFoodMeter(),  owner.getMyPet().getCleanMeter());
                gameView.setVisible(false);
                menuView.setVisible(true);
            }
        }
    }
}
