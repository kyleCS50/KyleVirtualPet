/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package kylevirtualpet;

import java.awt.Color;
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

/**
 *
 * @author kylefrancis
 */
public class GameView extends JFrame{
    
    private Color fontColour = new Color(220, 219, 217);
    private Color backgroundColour = new Color(35, 36, 38);
    private Font font = new Font("Display", Font.BOLD, 30);
    
    private JPanel gamePanel;
    private BufferedImage myPetBuff;
    private Image myPetImg;
    private ImageIcon myPetIcon;
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
    private JLabel endLabel;
    private JButton quitButton;
    
    public GameView(String title, File file) {
        super(title);
        
        this.gamePanel = new JPanel();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1250, 700);
        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension screenDimension = tk.getScreenSize();
        Dimension frameDimension = this.getSize();
        this.setLocation((screenDimension.width-frameDimension.width)/2,
                (screenDimension.height-frameDimension.height)/2);
        this.add(gamePanel);
        this.setResizable(false);
        
        gamePanel.setLayout(null);
        gamePanel.setBackground(backgroundColour);
        
        try {
            this.myPetBuff = ImageIO.read(file);
            this.myPetImg = myPetBuff.getScaledInstance(myPetBuff.getWidth()/3, myPetBuff.getHeight()/3, Image.SCALE_DEFAULT);
            this.myPetIcon = new ImageIcon(myPetImg);
            this.myPetLabel = new JLabel();
            myPetLabel.setIcon(myPetIcon);
            myPetLabel.setBounds(10, 10, 320, 320);
            gamePanel.add(myPetLabel);
        } catch (IOException ex) {
            Logger.getLogger(GameView.class.getName()).log(Level.SEVERE, null, ex);
        }
        
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
        petIsLabel.setBounds(10, 10, 850, 210);
        petIsPanel.add(petIsLabel);
        
        this.happyLabel = new JLabel("Happiness");
        happyLabel.setFont(font);
        happyLabel.setForeground(fontColour);
        happyLabel.setBounds(30, 10, 170, 30);
        petStatsPanel.add(happyLabel);
        
        this.foodLabel = new JLabel("Food");
        foodLabel.setFont(font);
        foodLabel.setForeground(fontColour);
        foodLabel.setBounds(390, 10, 100, 30);
        petStatsPanel.add(foodLabel);
        
        this.cleanLabel = new JLabel("Cleanliness");
        cleanLabel.setFont(font);
        cleanLabel.setForeground(fontColour);
        cleanLabel.setBounds(690, 10, 180, 30);
        petStatsPanel.add(cleanLabel);
        
        this.happyStatLabel = new JLabel();
        happyStatLabel.setFont(new Font("Display", Font.BOLD, 120));
        happyStatLabel.setForeground(fontColour);
        happyStatLabel.setBounds(30, 70, 160, 100);
        petStatsPanel.add(happyStatLabel);
        
        this.foodStatLabel = new JLabel();
        foodStatLabel.setFont(new Font("Display", Font.BOLD, 120));
        foodStatLabel.setForeground(fontColour);
        foodStatLabel.setBounds(390, 70, 160, 100);
        petStatsPanel.add(foodStatLabel);
        
        this.cleanStatLabel = new JLabel();
        cleanStatLabel.setFont(new Font("Display", Font.BOLD, 120));
        cleanStatLabel.setForeground(fontColour);
        cleanStatLabel.setBounds(690, 70, 160, 100);
        petStatsPanel.add(cleanStatLabel);
        
        this.playButton = new JButton("Play");
        playButton.setFont(font);
        playButton.setBounds(30, 10, 190, 190);
        petActionsPanel.add(playButton);
        
        this.feedButton = new JButton("Feed");
        feedButton.setFont(font);
        feedButton.setBounds(340, 10, 190, 190);
        petActionsPanel.add(feedButton);
        
        this.cleanButton = new JButton("Clean");
        cleanButton.setFont(font);
        cleanButton.setBounds(690, 10, 190, 190);
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
        
        this.endLabel = new JLabel("Game Over!");
        endLabel.setFont(font);
        endLabel.setForeground(fontColour);
        endLabel.setBounds(10, 10, 850, 210);
        
        this.quitButton = new JButton("Quit");
        quitButton.setFont(font);
        quitButton.setBounds(800, 5, 95, 95);
        petIsPanel.add(quitButton);
        
        this.setVisible(false);
    }
    
    JButton getPlayButton() {
        return playButton;
    }
    
    JButton getFeedButton() {
        return feedButton;
    }
    
    JButton getCleanButton() {
        return cleanButton;
    }
    
    JButton getQuitButton() {
        return quitButton;
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
    
    public JPanel getGamePanel() {
        return gamePanel;
    }
    
    public JPanel getPetIsPanel() {
        return petIsPanel;
    }
    
    public JLabel getEndLabel() {
        return endLabel;
    }
}
