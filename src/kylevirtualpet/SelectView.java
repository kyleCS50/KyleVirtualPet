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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author kylefrancis
 */
public class SelectView extends JFrame{
    
    private Color fontColour = new Color(220, 219, 217);
    private Color backgroundColour = new Color(35, 36, 38);
    private Font font = new Font("Display", Font.BOLD, 30);
    
    //select pet
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
    
    private boolean petSelected;
    
    public SelectView(String title){
        super(title);
        
        this.selectPanel = new JPanel();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1250, 700);
        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension screenDimension = tk.getScreenSize();
        Dimension frameDimension = this.getSize();
        this.setLocation((screenDimension.width-frameDimension.width)/2,
                (screenDimension.height-frameDimension.height)/2);
        this.add(selectPanel);
        this.setResizable(false);
        
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
        
        this.petSelected = false;
        
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
            Logger.getLogger(SelectView.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.setVisible(false);
        
    }

    JLabel getCanLabel() {
        return canLabel;
    }

    JLabel getShortLabel() {
        return shortLabel;
    }

    JLabel getLabLabel() {
       return labLabel;
    }

    public boolean isPetSelected() {
        return petSelected;
    }

    public void setPetSelected(boolean petSelected) {
        this.petSelected = petSelected;
    }
    
    
}
