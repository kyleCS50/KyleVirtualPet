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
    private JLabel dogDiffLabel;
    private JLabel dogNameLabel;
    private BufferedImage dogBuff;
    private Image dogImg;
    private ImageIcon dogIcon;
    private JLabel dogLabel;
    //shorthair
    private JLabel catDiffLabel;
    private JLabel catNameLabel;
    private BufferedImage catBuff;
    private Image catImg;
    private ImageIcon catIcon;
    private JLabel catLabel;
    //canary
    private JLabel birdDiffLabel;
    private JLabel birdNameLabel;
    private BufferedImage birdBuff;
    private Image birdImg;
    private ImageIcon birdIcon;
    private JLabel birdLabel;
    
    private JButton backButton;
    
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
        
        this.backButton = new JButton("Back");
        backButton.setFont(new Font("Display", Font.PLAIN, 15));
        backButton.setBounds(10, 15, 150, 25);
        selectPanel.add(backButton);
        
        this.selectLabel = new JLabel("Select A Pet");
        selectLabel.setFont(font);
        selectLabel.setForeground(fontColour);
        selectLabel.setBounds(445, 20, 300, 50);
        selectPanel.add(selectLabel);
        
        this.birdDiffLabel = new JLabel("Easy");
        birdDiffLabel.setFont(font);
        birdDiffLabel.setForeground(Color.GREEN);
        birdDiffLabel.setBounds(85, 150, 350, 50);
        selectPanel.add(birdDiffLabel);
        
        this.catDiffLabel = new JLabel("Medium");
        catDiffLabel.setFont(font);
        catDiffLabel.setForeground(Color.ORANGE);
        catDiffLabel.setBounds(465, 150, 270, 50);
        selectPanel.add(catDiffLabel);
        
        this.dogDiffLabel = new JLabel("Hard");
        dogDiffLabel.setFont(font);
        dogDiffLabel.setForeground(Color.RED);
        dogDiffLabel.setBounds(845, 150, 350, 50);
        selectPanel.add(dogDiffLabel);
        
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
            this.birdBuff = ImageIO.read(new File("petAssets/bluejay.jpg"));
            this.birdImg = birdBuff.getScaledInstance(birdBuff.getWidth()/3, birdBuff.getHeight()/3, Image.SCALE_DEFAULT);
            this.birdIcon = new ImageIcon(birdImg);
            this.birdLabel = new JLabel();
            birdLabel.setIcon(birdIcon);
            birdLabel.setBounds(85, 254, birdIcon.getIconWidth(), birdIcon.getIconHeight());
            birdLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            selectPanel.add(birdLabel);
            
            //shorthair
            this.catBuff = ImageIO.read(new File("petAssets/shorthair.jpg"));
            this.catImg = catBuff.getScaledInstance(catBuff.getWidth()/3, catBuff.getHeight()/3, Image.SCALE_DEFAULT);
            this.catIcon = new ImageIcon(catImg);
            this.catLabel = new JLabel();
            catLabel.setIcon(catIcon);
            catLabel.setBounds(465, 254, catIcon.getIconWidth(), catIcon.getIconHeight());
            catLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            selectPanel.add(catLabel);
            
            //lab
            this.dogBuff = ImageIO.read(new File("petAssets/lab.jpg"));
            this.dogImg = dogBuff.getScaledInstance(dogBuff.getWidth()/3, dogBuff.getHeight()/3, Image.SCALE_DEFAULT);
            this.dogIcon = new ImageIcon(dogImg);
            this.dogLabel = new JLabel();
            dogLabel.setIcon(dogIcon);
            dogLabel.setBounds(845, 254, dogIcon.getIconWidth(), dogIcon.getIconHeight());
            dogLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            selectPanel.add(dogLabel);
            
        } catch (IOException ex) {
            Logger.getLogger(SelectView.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.setVisible(false);
        
    }
    
    JLabel getBirdLabel() {
        return birdLabel;
    }
    
    JLabel getCatLabel() {
        return catLabel;
    }
    
    JLabel getDogLabel() {
        return dogLabel;
    }
    
    public boolean isPetSelected() {
        return petSelected;
    }
    
    public void setPetSelected(boolean petSelected) {
        this.petSelected = petSelected;
    }

    public JButton getBackButton() {
        return backButton;
    }
    
    
}
