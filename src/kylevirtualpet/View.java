/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package kylevirtualpet;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


/**
 *
 * @author kylefrancis
 */
public class View{
    private Color fontColour = new Color(220, 219, 217);
    private Color backgroundColour = new Color(35, 36, 38);
    private Font font = new Font("Display", Font.BOLD, 30);
    //login
    private JFrame liFrame;
    private JLabel liUserLabel;
    private JLabel liPassLabel;
    private JTextField liUserField;
    private JPasswordField liPassField;
    private JButton loginButton;
    private JLabel liSuccessLabel;
    private JPanel loginPanel;
    private JButton signUpButton;
    
    //signup
    private JFrame suFrame;
    private JLabel suUserLabel;
    private JLabel suPassLabel;
    private JLabel suConfirmLabel;
    private JTextField suUserField;
    private JPasswordField suPassField;
    private JPasswordField suConfirmField;
    private JButton suCreateButton;
    private JLabel suSuccessLabel;
    private JPanel signUpPanel;
    
    //menu screen
    private JFrame menuFrame;
    private JLabel menuLabel;
    private JButton playGameButton;
    private JButton statsButton;
    private JButton howToButton;
    private JFrame howToFrame;
    private JPanel howToPanel;
    private JLabel howToText;
    private JButton doneButton;
    private JPanel menuPanel;
    
    //select pet
    private JFrame selectFrame;
    private JPanel selectPanel;
    private JLabel selectLabel;
    //labrador
    private JLabel dogNameLabel;
    private BufferedImage labBuff;
    private Image labImg;
    private ImageIcon labIcon;
    private JLabel labLabel;
    //shorthair
    private JLabel catNameLabel;
    private BufferedImage shortBuff;
    private Image shortImg;
    private ImageIcon shortIcon;
    private JLabel shortLabel;
    //canary
    private JLabel birdNameLabel;
    private BufferedImage canBuff;
    private Image canImg;
    private ImageIcon canIcon;
    private JLabel canLabel;
    
    //game
    private JFrame gameFrame;
    private JPanel gamePanel;
    private JLabel myPetLabel;
    private JPanel petIsPanel;
    private JPanel petStatsPanel;
    private JPanel petActionsPanel;
    private JPanel infoPanel;
    private JLabel petIsLabel;
    private JLabel happyLabel;
    private JLabel foodLabel;
    private JLabel cleanLabel;
    private JLabel happyStatLabel;
    private JLabel foodStatLabel;
    private JLabel cleanStatLabel;
    private JButton playButton;
    private JButton feedButton;
    private JButton cleanButton;
    private JLabel petName;
    private JLabel petBreed;
    private JLabel petDiff;
    private JLabel numRounds;
    private JFrame endFrame;
    private JPanel endPanel;
    private JLabel endLabel;
    private JButton endButton;
    
    
    public View(String title)
    {
        this.constructLogIn(title+ " - Login");
        this.constructSignUp(title+ " - Sign Up");
        this.constructMenu(title+ " - Menu");
        this.constructSelect(title+ " - Select Pet");
        this.constructGame(title);
    }
    //----------------------------------GETTERS---------------------------------
    public JFrame getLiFrame() {
        return liFrame;
    }
    
    public JTextField getLiUserField() {
        return liUserField;
    }
    
    public JTextField getLiPassField() {
        return liPassField;
    }
    
    public JButton getLoginButton() {
        return loginButton;
    }
    
    public JLabel getLiSuccessLabel() {
        return liSuccessLabel;
    }
    
    public JButton getSignUpButton() {
        return signUpButton;
    }
    
    public JFrame getSuFrame() {
        return suFrame;
    }
    
    public JTextField getSuUserField() {
        return suUserField;
    }
    
    public JTextField getSuPassField() {
        return suPassField;
    }
    
    public JTextField getSuConfirmField() {
        return suConfirmField;
    }
    
    public JButton getSuCreateButton() {
        return suCreateButton;
    }
    
    public JLabel getSuSuccessLabel() {
        return suSuccessLabel;
    }
    
    public JFrame getSelectFrame() {
        return selectFrame;
    }
    
    public JLabel getLabLabel() {
        return labLabel;
    }
    
    public JLabel getShortLabel() {
        return shortLabel;
    }
    
    public JLabel getCanLabel() {
        return canLabel;
    }
    
    public JFrame getMenuFrame() {
        return menuFrame;
    }
    
    public JButton getPlayGameButton() {
        return playGameButton;
    }
    
    public JButton getStatsButton() {
        return statsButton;
    }
    
    public JButton getHowToButton() {
        return howToButton;
    }
    
    public JFrame getHowToFrame() {
        return howToFrame;
    }
    
    public JButton getDoneButton() {
        return doneButton;
    }
    
    public JFrame getGameFrame() {
        return gameFrame;
    }
    
    public JPanel getGamePanel() {
        return gamePanel;
    }
    
    public JLabel getMyPetLabel() {
        return myPetLabel;
    }
    
    public void setMyPetLabel(JLabel myPetLabel) {
        this.myPetLabel = myPetLabel;
    }
    
    public JLabel getPetIsLabel() {
        return petIsLabel;
    }
    
    public JLabel getHappyStatLabel() {
        return happyStatLabel;
    }
    
    public JLabel getFoodStatLabel() {
        return foodStatLabel;
    }
    
    public JLabel getCleanStatLabel() {
        return cleanStatLabel;
    }
    
    public JButton getPlayButton() {
        return playButton;
    }
    
    public JButton getFeedButton() {
        return feedButton;
    }
    
    public JButton getCleanButton() {
        return cleanButton;
    }
    
    public JLabel getPetName() {
        return petName;
    }
    
    public JLabel getPetBreed() {
        return petBreed;
    }
    
    public JLabel getPetDiff() {
        return petDiff;
    }
    
    public JLabel getNumRounds() {
        return numRounds;
    }
    
    public JFrame getEndFrame() {
        return endFrame;
    }
    
    public JLabel getEndLabel()
    {
        return endLabel;
    }
    
    public JButton getEndButton() {
        return endButton;
    }
    //----------------------------------LOG IN FRAME----------------------------
    private void constructLogIn(String title)
    {
        //login frame setup
        this.liFrame = new JFrame(title);
        this.loginPanel = new JPanel();
        liFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        liFrame.setSize(350, 200);
        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension screenDimension = tk.getScreenSize();
        Dimension frameDimension = liFrame.getSize();
        liFrame.setLocation((screenDimension.width-frameDimension.width)/2,
                (screenDimension.height-frameDimension.height)/2);
        liFrame.add(loginPanel);
        liFrame.setResizable(false);
        
        loginPanel.setLayout(null);
        loginPanel.setBackground(backgroundColour);
        
        //create elements
        this.liUserLabel = new JLabel("Username: ");
        this.liUserLabel.setForeground(fontColour);
        this.liUserLabel.setBounds(40, 40, 80, 25);
        loginPanel.add(liUserLabel);
        
        this.liUserField = new JTextField(10);
        this.liUserField.setBounds(130, 40, 150, 25);
        loginPanel.add(liUserField);
        
        this.liPassLabel = new JLabel("Password: ");
        this.liPassLabel.setForeground(fontColour);
        this.liPassLabel.setBounds(40, 70, 80, 25);
        loginPanel.add(liPassLabel);
        
        this.liPassField = new JPasswordField(10);
        this.liPassField.setBounds(130, 70, 150, 25);
        loginPanel.add(liPassField);
        
        this.loginButton = new JButton("Log In");
        this.loginButton.setBounds(205, 100, 80, 25);
        loginPanel.add(loginButton);
        
        this.signUpButton = new JButton("Sign Up");
        this.signUpButton.setBounds(135, 100, 80, 25);
        this.signUpButton.setToolTipText("Don't have an account? Sign Up!");
        loginPanel.add(signUpButton);
        
        this.liSuccessLabel = new JLabel("");
        this.liSuccessLabel.setBounds(40, 125, 300, 25);
        loginPanel.add(liSuccessLabel);
        
        this.liFrame.setVisible(true);
    }
    
    //----------------------------------SIGN UP FRAME---------------------------
    private void constructSignUp(String title)
    {
        this.suFrame = new JFrame(title);
        this.signUpPanel = new JPanel();
        suFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        suFrame.setSize(350, 200);
        suFrame.add(signUpPanel);
        suFrame.setResizable(false);
        
        signUpPanel.setLayout(null);
        signUpPanel.setBackground(backgroundColour);
        
        //create elements
        this.suUserLabel = new JLabel("Username: ");
        this.suUserLabel.setForeground(fontColour);
        this.suUserLabel.setBounds(40, 20, 80, 25);
        signUpPanel.add(suUserLabel);
        
        this.suUserField = new JTextField(10);
        this.suUserField.setBounds(160, 20, 150, 25);
        signUpPanel.add(suUserField);
        
        this.suPassLabel = new JLabel("Password: ");
        this.suPassLabel.setForeground(fontColour);
        this.suPassLabel.setBounds(40, 50, 80, 25);
        signUpPanel.add(suPassLabel);
        
        this.suPassField = new JPasswordField(10);
        this.suPassField.setBounds(160, 50, 150, 25);
        signUpPanel.add(suPassField);
        
        this.suConfirmLabel = new JLabel("Confirm Password: ");
        this.suConfirmLabel.setForeground(fontColour);
        this.suConfirmLabel.setBounds(40, 80, 130, 25);
        signUpPanel.add(suConfirmLabel);
        
        this.suConfirmField = new JPasswordField(10);
        this.suConfirmField.setBounds(160, 80, 150, 25);
        signUpPanel.add(suConfirmField);
        
        this.suCreateButton = new JButton("Create Account");
        this.suCreateButton.setBounds(30, 115, 120, 25);
        signUpPanel.add(suCreateButton);
        
        this.suSuccessLabel = new JLabel("");
        this.suSuccessLabel.setBounds(40, 140, 300, 25);
        signUpPanel.add(suSuccessLabel);
        
        suFrame.setVisible(false);
    }
    
    //----------------------------------MENU FRAME------------------------------
    private void constructMenu(String title)
    {
        this.menuFrame = new JFrame(title);
        this.menuPanel = new JPanel();
        
        menuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        menuFrame.setSize(1250, 700);
        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension screenDimension = tk.getScreenSize();
        Dimension frameDimension = menuFrame.getSize();
        menuFrame.setLocation((screenDimension.width-frameDimension.width)/2,
                (screenDimension.height-frameDimension.height)/2);
        menuFrame.add(menuPanel);
        menuFrame.setResizable(false);
        
        menuPanel.setLayout(null);
        menuPanel.setBackground(backgroundColour);
        
        this.menuLabel = new JLabel("Kyle's Virtual Pet Game");
        menuLabel.setFont(font);
        menuLabel.setForeground(fontColour);
        menuLabel.setBounds(445, 20, 360, 50);
        menuPanel.add(menuLabel);
        
        this.playGameButton = new JButton("Play Game");
        playGameButton.setFont(font);
        playGameButton.setBounds(85, 190, 320, 320);
        menuPanel.add(playGameButton);
        
        this.statsButton = new JButton("Game Stats");
        statsButton.setFont(font);
        statsButton.setBounds(465, 190, 320, 320);
        menuPanel.add(statsButton);
        
        this.howToButton = new JButton("How To Play");
        howToButton.setFont(font);
        howToButton.setBounds(845, 190, 320, 320);
        menuPanel.add(howToButton);
        
        this.howToFrame = new JFrame("How To Play");
        this.howToPanel = new JPanel();
        howToFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        howToFrame.setSize(450, 220);
        howToFrame.setLocation((screenDimension.width-frameDimension.width)/2,
                (screenDimension.height-frameDimension.height)/2);
        howToFrame.add(howToPanel);
        howToFrame.setResizable(false);
        
        howToPanel.setLayout(null);
        howToPanel.setBackground(backgroundColour);
        
        String text = "To play my virtual pet game first you must choose a pet. "
                + "Each pet has a happiness, food and cleanliness meter. "
                + "To increase the stats you a meter you can do an activity with your pet. "
                + "To increase happiness you can play with your pet, to increase food you feed your pet and to increase cleanliness you clean your pet. "
                + "Each pet has a different difficulty level which determines their starting stats and how much you can increase them for each activity.";
        this.howToText = new JLabel("<html>"+text+"</html>");
        howToText.setForeground(fontColour);
        howToText.setBounds(25, 10, 400, 150);
        howToPanel.add(howToText);
        
        this.doneButton = new JButton("Done");
        this.doneButton.setBounds(345, 160, 80, 25);
        howToPanel.add(doneButton);
        
        menuFrame.setVisible(false);
        howToFrame.setVisible(false);
    }
    
    //----------------------------------SELECT FRAME----------------------------
    private void constructSelect(String title)
    {
        this.selectFrame = new JFrame(title);
        this.selectPanel = new JPanel();
        selectFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        selectFrame.setSize(1250, 700);
        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension screenDimension = tk.getScreenSize();
        Dimension frameDimension = selectFrame.getSize();
        selectFrame.setLocation((screenDimension.width-frameDimension.width)/2,
                (screenDimension.height-frameDimension.height)/2);
        selectFrame.add(selectPanel);
        selectFrame.setResizable(false);
        
        selectPanel.setLayout(null);
        selectPanel.setBackground(backgroundColour);
        
        this.selectLabel = new JLabel("Select A Pet");
        selectLabel.setFont(font);
        selectLabel.setForeground(fontColour);
        selectLabel.setBounds(445, 20, 300, 50);
        selectPanel.add(selectLabel);
        
        this.birdNameLabel = new JLabel("Mordecai the Blue Jay");
        birdNameLabel.setFont(font);
        birdNameLabel.setForeground(fontColour);
        birdNameLabel.setBounds(85, 200, 350, 50);
        selectPanel.add(birdNameLabel);
        
        this.catNameLabel = new JLabel("Eve the Shorthair");
        catNameLabel.setFont(font);
        catNameLabel.setForeground(fontColour);
        catNameLabel.setBounds(465, 200, 270, 50);
        selectPanel.add(catNameLabel);
        
        this.dogNameLabel = new JLabel("Charlie the Labrador");
        dogNameLabel.setFont(font);
        dogNameLabel.setForeground(fontColour);
        dogNameLabel.setBounds(845, 200, 350, 50);
        selectPanel.add(dogNameLabel);
        try {
            //canary
            this.canBuff = ImageIO.read(new File("petAssets/bluejay.jpg"));
            this.canImg = canBuff.getScaledInstance(canBuff.getWidth()/3, canBuff.getHeight()/3, Image.SCALE_DEFAULT);
            this.canIcon = new ImageIcon(canImg);
            this.canLabel = new JLabel();
            canLabel.setIcon(canIcon);
            canLabel.setBounds(85, 254, canIcon.getIconWidth(), canIcon.getIconHeight());
            canLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            selectPanel.add(canLabel);
            
            //shorthair
            this.shortBuff = ImageIO.read(new File("petAssets/shorthair.jpg"));
            this.shortImg = shortBuff.getScaledInstance(shortBuff.getWidth()/3, shortBuff.getHeight()/3, Image.SCALE_DEFAULT);
            this.shortIcon = new ImageIcon(shortImg);
            this.shortLabel = new JLabel();
            shortLabel.setIcon(shortIcon);
            shortLabel.setBounds(465, 254, shortIcon.getIconWidth(), shortIcon.getIconHeight());
            shortLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            selectPanel.add(shortLabel);
            
            //lab
            this.labBuff = ImageIO.read(new File("petAssets/lab.jpg"));
            this.labImg = labBuff.getScaledInstance(labBuff.getWidth()/3, labBuff.getHeight()/3, Image.SCALE_DEFAULT);
            this.labIcon = new ImageIcon(labImg);
            this.labLabel = new JLabel();
            labLabel.setIcon(labIcon);
            labLabel.setBounds(845, 254, labIcon.getIconWidth(), labIcon.getIconHeight());
            labLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            selectPanel.add(labLabel);
            
        } catch (IOException ex) {
            Logger.getLogger(View.class.getName()).log(Level.SEVERE, null, ex);
        }
        selectFrame.setVisible(false);
    }
    
    //----------------------------------GAME FRAME------------------------------
    private void constructGame(String title)
    {
        this.gameFrame = new JFrame(title);
        this.gamePanel = new JPanel();
        gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameFrame.setSize(1250, 700);
        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension screenDimension = tk.getScreenSize();
        Dimension frameDimension = gameFrame.getSize();
        gameFrame.setLocation((screenDimension.width-frameDimension.width)/2,
                (screenDimension.height-frameDimension.height)/2);
        gameFrame.add(gamePanel);
        gameFrame.setResizable(false);
        
        gamePanel.setLayout(null);
        gamePanel.setBackground(backgroundColour);
        
        this.petIsPanel = new JPanel();
        petIsPanel.setBackground(new Color(62, 62, 64));
        petIsPanel.setBounds(340, 10, 900, 210);
        petIsPanel.setLayout(null);
        
        this.petStatsPanel = new JPanel();
        petStatsPanel.setBackground(new Color(62, 62, 64));
        petStatsPanel.setBounds(340, 230, 900, 210);
        petStatsPanel.setLayout(null);
        
        this.petActionsPanel = new JPanel();
        petActionsPanel.setBackground(new Color(62, 62, 64));
        petActionsPanel.setBounds(340, 450, 900, 210);
        petActionsPanel.setLayout(null);
        
        this.infoPanel = new JPanel();
        infoPanel.setBackground(new Color(62, 62, 64));
        infoPanel.setBounds(10, 340, 320, 320);
        infoPanel.setLayout(null);
        
        this.petIsLabel = new JLabel();
        petIsLabel.setFont(font);
        petIsLabel.setForeground(fontColour);
        petIsLabel.setBounds(10, petIsPanel.getHeight()/2, 850, 35);
        petIsPanel.add(petIsLabel);
        
        this.happyLabel = new JLabel("Happiness");
        happyLabel.setFont(font);
        happyLabel.setForeground(fontColour);
        happyLabel.setBounds(10, 10, 250, 30);
        petStatsPanel.add(happyLabel);
        
        this.foodLabel = new JLabel("Food");
        foodLabel.setFont(font);
        foodLabel.setForeground(fontColour);
        foodLabel.setBounds(300, 10, 250, 30);
        petStatsPanel.add(foodLabel);
        
        this.cleanLabel = new JLabel("Cleanliness");
        cleanLabel.setFont(font);
        cleanLabel.setForeground(fontColour);
        cleanLabel.setBounds(600, 10, 250, 30);
        petStatsPanel.add(cleanLabel);
        
        this.happyStatLabel = new JLabel();
        happyStatLabel.setFont(font);
        happyStatLabel.setForeground(fontColour);
        happyStatLabel.setBounds(10, 50, 250, 30);
        petStatsPanel.add(happyStatLabel);
        
        this.foodStatLabel = new JLabel();
        foodStatLabel.setFont(font);
        foodStatLabel.setForeground(fontColour);
        foodStatLabel.setBounds(300, 50, 250, 30);
        petStatsPanel.add(foodStatLabel);
        
        this.cleanStatLabel = new JLabel();
        cleanStatLabel.setFont(font);
        cleanStatLabel.setForeground(fontColour);
        cleanStatLabel.setBounds(600, 50, 250, 30);
        petStatsPanel.add(cleanStatLabel);
        
        this.playButton = new JButton("Play");
        playButton.setFont(font);
        playButton.setBounds(10, 10, 190, 190);
        petActionsPanel.add(playButton);
        
        this.feedButton = new JButton("Feed");
        feedButton.setFont(font);
        feedButton.setBounds(300, 10, 190, 190);
        petActionsPanel.add(feedButton);
        
        this.cleanButton = new JButton("Clean");
        cleanButton.setFont(font);
        cleanButton.setBounds(600, 10, 190, 190);
        petActionsPanel.add(cleanButton);
        
        this.petName = new JLabel();
        petName.setFont(font);
        petName.setForeground(fontColour);
        petName.setBounds(10, 0, 320, 50);
        infoPanel.add(petName);
        
        this.petBreed = new JLabel();
        petBreed.setFont(font);
        petBreed.setForeground(fontColour);
        petBreed.setBounds(10, 80, 320, 50);
        infoPanel.add(petBreed);
        
        this.petDiff = new JLabel();
        petDiff.setFont(font);
        petDiff.setForeground(fontColour);
        petDiff.setBounds(10, 160, 320, 50);
        infoPanel.add(petDiff);
        
        this.numRounds = new JLabel("Rounds Played: 0");
        numRounds.setFont(font);
        numRounds.setForeground(fontColour);
        numRounds.setBounds(10, 240, 320, 50);
        infoPanel.add(numRounds);
        
        gamePanel.add(petIsPanel);
        gamePanel.add(petStatsPanel);
        gamePanel.add(petActionsPanel);
        gamePanel.add(infoPanel);
        
        this.endFrame = new JFrame("Game Over");
        this.endPanel = new JPanel();
        endFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        endFrame.setSize(450, 220);
        Toolkit tk2 = Toolkit.getDefaultToolkit();
        Dimension screenDimension2 = tk2.getScreenSize();
        Dimension frameDimension2 = endFrame.getSize();
        endFrame.setLocation((screenDimension2.width-frameDimension2.width)/2,
                (screenDimension2.height-frameDimension2.height)/2);
        endFrame.add(endPanel);
        endFrame.setResizable(false);
        
        endPanel.setLayout(null);
        endPanel.setBackground(backgroundColour);
        
        this.endLabel = new JLabel("Game Over!");
        endLabel.setForeground(fontColour);
        endLabel.setBounds(25, 10, 400, 150);
        endPanel.add(endLabel);
        
        this.endButton = new JButton("End Game");
        this.endButton.setBounds(345, 160, 80, 25);
        endPanel.add(endButton);
        
        endFrame.setVisible(false);
        gameFrame.setVisible(false);
    }
}
