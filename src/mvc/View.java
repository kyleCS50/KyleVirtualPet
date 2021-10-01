/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package mvc;

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
    
    //select pet
    private JFrame selectFrame;
    private JPanel selectPanel;
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
    
    public View(String title)
    {
        this.constructLogIn(title+ " - Login");
        this.constructSignUp(title+ " - Sign Up");
        this.constructSelect(title+ " - Select Pet");
    }
    //----------------------------------GETTERS---------------------------------
    public JFrame getLiFrame() {
        return liFrame;
    }
    
    public JLabel getLiUserLabel() {
        return liUserLabel;
    }
    
    public JLabel getLiPassLabel() {
        return liPassLabel;
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
    
    public JPanel getLoginPanel() {
        return loginPanel;
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
    
    public JLabel getSuUserLabel() {
        return suUserLabel;
    }
    
    public JLabel getSuPassLabel() {
        return suPassLabel;
    }
    
    public JLabel getSuConfirmLabel() {
        return suConfirmLabel;
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
    
    public JPanel getSignUpPanel() {
        return signUpPanel;
    }
    
    public JFrame getSelectFrame() {
        return selectFrame;
    }
    
    public JPanel getSelectPanel() {
        return selectPanel;
    }
    
    public JLabel getDogNameLabel() {
        return dogNameLabel;
    }
    
    public JLabel getCatNameLabel() {
        return catNameLabel;
    }
    
    public JLabel getBirdNameLabel() {
        return birdNameLabel;
    }
    
    public BufferedImage getLabBuff() {
        return labBuff;
    }
    
    public Image getLabImg() {
        return labImg;
    }
    
    public ImageIcon getLabIcon() {
        return labIcon;
    }
    
    public JLabel getLabLabel() {
        return labLabel;
    }
    
    public BufferedImage getShortBuff() {
        return shortBuff;
    }
    
    public Image getShortImg() {
        return shortImg;
    }
    
    public ImageIcon getShortIcon() {
        return shortIcon;
    }
    
    public JLabel getShortLabel() {
        return shortLabel;
    }
    
    public BufferedImage getCanBuff() {
        return canBuff;
    }
    
    public Image getCanImg() {
        return canImg;
    }
    
    public ImageIcon getCanIcon() {
        return canIcon;
    }
    
    public JLabel getCanLabel() {
        return canLabel;
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
        
        this.liFrame.setVisible(false);
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
        
        this.dogNameLabel = new JLabel("Charlie the Labrador");
        dogNameLabel.setFont(font);
        dogNameLabel.setForeground(fontColour);
        dogNameLabel.setBounds(845, 200, 350, 50);
        selectPanel.add(dogNameLabel);
        
        this.catNameLabel = new JLabel("Eve the Shorthair");
        catNameLabel.setFont(font);
        catNameLabel.setForeground(fontColour);
        catNameLabel.setBounds(465, 200, 270, 50);
        selectPanel.add(catNameLabel);
        
        this.birdNameLabel = new JLabel("Gandalf the Canary");
        birdNameLabel.setFont(font);
        birdNameLabel.setForeground(fontColour);
        birdNameLabel.setBounds(85, 200, 300, 50);
        selectPanel.add(birdNameLabel);
        
        try {
            //lab
            this.labBuff = ImageIO.read(new File("petAssets/lab.jpg"));
            this.labImg = labBuff.getScaledInstance(labBuff.getWidth()/3, labBuff.getHeight()/3, Image.SCALE_DEFAULT);
            this.labIcon = new ImageIcon(labImg);
            this.labLabel = new JLabel();
            labLabel.setIcon(labIcon);
            labLabel.setBounds(845, 254, labIcon.getIconWidth(), labIcon.getIconHeight());
            selectPanel.add(labLabel);
            
            //shorthair
            this.shortBuff = ImageIO.read(new File("petAssets/shorthair.jpg"));
            this.shortImg = shortBuff.getScaledInstance(shortBuff.getWidth()/3, shortBuff.getHeight()/3, Image.SCALE_DEFAULT);
            this.shortIcon = new ImageIcon(shortImg);
            this.shortLabel = new JLabel();
            shortLabel.setIcon(shortIcon);
            shortLabel.setBounds(465, 254, shortIcon.getIconWidth(), shortIcon.getIconHeight());
            selectPanel.add(shortLabel);
            
            //canary
            this.canBuff = ImageIO.read(new File("petAssets/canary.jpg"));
            this.canImg = canBuff.getScaledInstance(canBuff.getWidth()/3, canBuff.getHeight()/3, Image.SCALE_DEFAULT);
            this.canIcon = new ImageIcon(canImg);
            this.canLabel = new JLabel();
            canLabel.setIcon(canIcon);
            canLabel.setBounds(85, 254, canIcon.getIconWidth(), canIcon.getIconHeight());
            selectPanel.add(canLabel);
            
        } catch (IOException ex) {
            Logger.getLogger(View.class.getName()).log(Level.SEVERE, null, ex);
        }
        selectFrame.setVisible(true);
    }
}
