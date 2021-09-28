/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package mvc;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.geom.Rectangle2D;
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
    private JLabel dogLabel;
    //bulldog
    private BufferedImage bulldogBuff;
    private Image bulldogImg;
    private ImageIcon bulldogIcon;
    private JLabel bulldogLabel;
    //beagle
    private BufferedImage beagleBuff;
    private Image beagleImg;
    private ImageIcon beagleIcon;
    private JLabel beagleLabel;
    //labrador
    private BufferedImage labBuff;
    private Image labImg;
    private ImageIcon labIcon;
    private JLabel labLabel;
    //persian
    private BufferedImage perBuff;
    private Image perImg;
    private ImageIcon perIcon;
    private JLabel perLabel;
    //shorthair
    private BufferedImage shortBuff;
    private Image shortImg;
    private ImageIcon shortIcon;
    private JLabel shortLabel;
    //siamese
    private BufferedImage siaBuff;
    private Image siaImg;
    private ImageIcon siaIcon;
    private JLabel siaLabel;
    //canary
    private BufferedImage canBuff;
    private Image canImg;
    private ImageIcon canIcon;
    private JLabel canLabel;
    //parakeet
    private BufferedImage parBuff;
    private Image parImg;
    private ImageIcon parIcon;
    private JLabel parLabel;
    //budgie
    private BufferedImage budBuff;
    private Image budImg;
    private ImageIcon budIcon;
    private JLabel budLabel;
    
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
    
    public JLabel getDogLabel() {
        return dogLabel;
    }
    
    public BufferedImage getBulldogBuff() {
        return bulldogBuff;
    }
    
    public Image getBulldogImg() {
        return bulldogImg;
    }
    
    public ImageIcon getBulldogIcon() {
        return bulldogIcon;
    }
    
    public JLabel getBulldogLabel() {
        return bulldogLabel;
    }
    
    public BufferedImage getBeagleBuff() {
        return beagleBuff;
    }
    
    public Image getBeagleImg() {
        return beagleImg;
    }
    
    public ImageIcon getBeagleIcon() {
        return beagleIcon;
    }
    
    public JLabel getBeagleLabel() {
        return beagleLabel;
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
    
    public BufferedImage getPerBuff() {
        return perBuff;
    }
    
    public Image getPerImg() {
        return perImg;
    }
    
    public ImageIcon getPerIcon() {
        return perIcon;
    }
    
    public JLabel getPerLabel() {
        return perLabel;
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
    
    public BufferedImage getSiaBuff() {
        return siaBuff;
    }
    
    public Image getSiaImg() {
        return siaImg;
    }
    
    public ImageIcon getSiaIcon() {
        return siaIcon;
    }
    
    public JLabel getSiaLabel() {
        return siaLabel;
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
    
    public BufferedImage getParBuff() {
        return parBuff;
    }
    
    public Image getParImg() {
        return parImg;
    }
    
    public ImageIcon getParIcon() {
        return parIcon;
    }
    
    public JLabel getParLabel() {
        return parLabel;
    }
    
    public BufferedImage getBudBuff() {
        return budBuff;
    }
    
    public Image getBudImg() {
        return budImg;
    }
    
    public ImageIcon getBudIcon() {
        return budIcon;
    }
    
    public JLabel getBudLabel() {
        return budLabel;
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
        loginPanel.setBackground(new Color(35, 36, 38));
        
        //create elements
        this.liUserLabel = new JLabel("Username: ");
        this.liUserLabel.setForeground(new Color(220, 219, 217));
        this.liUserLabel.setBounds(40, 40, 80, 25);
        loginPanel.add(liUserLabel);
        
        this.liUserField = new JTextField(10);
        this.liUserField.setBounds(130, 40, 150, 25);
        loginPanel.add(liUserField);
        
        this.liPassLabel = new JLabel("Password: ");
        this.liPassLabel.setForeground(new Color(220, 219, 217));
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
        signUpPanel.setBackground(new Color(35, 36, 38));
        
        //create elements
        this.suUserLabel = new JLabel("Username: ");
        this.suUserLabel.setForeground(new Color(220, 219, 217));
        this.suUserLabel.setBounds(40, 20, 80, 25);
        signUpPanel.add(suUserLabel);
        
        this.suUserField = new JTextField(10);
        this.suUserField.setBounds(160, 20, 150, 25);
        signUpPanel.add(suUserField);
        
        this.suPassLabel = new JLabel("Password: ");
        this.suPassLabel.setForeground(new Color(220, 219, 217));
        this.suPassLabel.setBounds(40, 50, 80, 25);
        signUpPanel.add(suPassLabel);
        
        this.suPassField = new JPasswordField(10);
        this.suPassField.setBounds(160, 50, 150, 25);
        signUpPanel.add(suPassField);
        
        this.suConfirmLabel = new JLabel("Confirm Password: ");
        this.suConfirmLabel.setForeground(new Color(220, 219, 217));
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
        selectFrame.setSize(1250, 750);
        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension screenDimension = tk.getScreenSize();
        Dimension frameDimension = selectFrame.getSize();
        selectFrame.setLocation((screenDimension.width-frameDimension.width)/2,
                (screenDimension.height-frameDimension.height)/2);
        selectFrame.add(selectPanel);
        selectFrame.setResizable(false);
        
        selectPanel.setLayout(null);
        selectPanel.setBackground(new Color(35, 36, 38));
        
        this.dogLabel = new RotateLabel("Dogs");
        this.dogLabel.setBounds(40, 140, 300, 25);
        selectPanel.add(dogLabel);
        
        try {
            //--------------------------DOGS------------------------------------
            //bulldog
            this.bulldogBuff = ImageIO.read(new File("petAssets/bulldog.jpg"));
            this.bulldogImg = bulldogBuff.getScaledInstance(bulldogBuff.getWidth()/5, bulldogBuff.getHeight()/5, Image.SCALE_DEFAULT);
            this.bulldogIcon = new ImageIcon(bulldogImg);
            this.bulldogLabel = new JLabel();
            bulldogLabel.setIcon(bulldogIcon);
            bulldogLabel.setBounds(230, 40, bulldogIcon.getIconWidth(), bulldogIcon.getIconHeight());
            selectPanel.add(bulldogLabel);
            
            //beagle
            this.beagleBuff = ImageIO.read(new File("petAssets/beagle.jpg"));
            this.beagleImg = beagleBuff.getScaledInstance(beagleBuff.getWidth()/5, beagleBuff.getHeight()/5, Image.SCALE_DEFAULT);
            this.beagleIcon = new ImageIcon(beagleImg);
            this.beagleLabel = new JLabel();
            beagleLabel.setIcon(beagleIcon);
            beagleLabel.setBounds(530, 40, beagleIcon.getIconWidth(), beagleIcon.getIconHeight());
            selectPanel.add(beagleLabel);
            
            //lab
            this.labBuff = ImageIO.read(new File("petAssets/lab.jpg"));
            this.labImg = labBuff.getScaledInstance(labBuff.getWidth()/5, labBuff.getHeight()/5, Image.SCALE_DEFAULT);
            this.labIcon = new ImageIcon(labImg);
            this.labLabel = new JLabel();
            labLabel.setIcon(labIcon);
            labLabel.setBounds(830, 40, labIcon.getIconWidth(), labIcon.getIconHeight());
            selectPanel.add(labLabel);
            
            //--------------------------CATS------------------------------------
            //persian
            this.perBuff = ImageIO.read(new File("petAssets/persian.jpg"));
            this.perImg = perBuff.getScaledInstance(perBuff.getWidth()/5, perBuff.getHeight()/5, Image.SCALE_DEFAULT);
            this.perIcon = new ImageIcon(perImg);
            this.perLabel = new JLabel();
            perLabel.setIcon(perIcon);
            perLabel.setBounds(230, 270, perIcon.getIconWidth(), perIcon.getIconHeight());
            selectPanel.add(perLabel);
            
            //shorthair
            this.shortBuff = ImageIO.read(new File("petAssets/shorthair.jpg"));
            this.shortImg = shortBuff.getScaledInstance(shortBuff.getWidth()/5, shortBuff.getHeight()/5, Image.SCALE_DEFAULT);
            this.shortIcon = new ImageIcon(shortImg);
            this.shortLabel = new JLabel();
            shortLabel.setIcon(shortIcon);
            shortLabel.setBounds(530, 270, shortIcon.getIconWidth(), shortIcon.getIconHeight());
            selectPanel.add(shortLabel);
            
            //siamese
            this.siaBuff = ImageIO.read(new File("petAssets/siamese.jpg"));
            this.siaImg = siaBuff.getScaledInstance(siaBuff.getWidth()/5, siaBuff.getHeight()/5, Image.SCALE_DEFAULT);
            this.siaIcon = new ImageIcon(siaImg);
            this.siaLabel = new JLabel();
            siaLabel.setIcon(siaIcon);
            siaLabel.setBounds(830, 270, siaIcon.getIconWidth(), siaIcon.getIconHeight());
            selectPanel.add(siaLabel);
            
            //--------------------------BIRDS------------------------------------
            //canary
            this.canBuff = ImageIO.read(new File("petAssets/canary.jpg"));
            this.canImg = canBuff.getScaledInstance(canBuff.getWidth()/5, canBuff.getHeight()/5, Image.SCALE_DEFAULT);
            this.canIcon = new ImageIcon(canImg);
            this.canLabel = new JLabel();
            canLabel.setIcon(canIcon);
            canLabel.setBounds(230, 500, canIcon.getIconWidth(), canIcon.getIconHeight());
            selectPanel.add(canLabel);
            
            //parakeet
            this.parBuff = ImageIO.read(new File("petAssets/parakeet.jpg"));
            this.parImg = parBuff.getScaledInstance(parBuff.getWidth()/5, parBuff.getHeight()/5, Image.SCALE_DEFAULT);
            this.parIcon = new ImageIcon(parImg);
            this.parLabel = new JLabel();
            parLabel.setIcon(parIcon);
            parLabel.setBounds(530, 500, parIcon.getIconWidth(), parIcon.getIconHeight());
            selectPanel.add(parLabel);
            
            //budgie
            this.budBuff = ImageIO.read(new File("petAssets/budgie.jpg"));
            this.budImg = budBuff.getScaledInstance(budBuff.getWidth()/5, budBuff.getHeight()/5, Image.SCALE_DEFAULT);
            this.budIcon = new ImageIcon(budImg);
            this.budLabel = new JLabel();
            budLabel.setIcon(budIcon);
            budLabel.setBounds(830, 500, budIcon.getIconWidth(), budIcon.getIconHeight());
            selectPanel.add(budLabel);
        } catch (IOException ex) {
            Logger.getLogger(View.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        selectFrame.setVisible(true);
    }
    
    private class RotateLabel extends JLabel
    {
        public RotateLabel(String s)
        {
            super(s);
        }
        
        @Override
        public void paintComponent(Graphics g) {
            Graphics2D g2 = (Graphics2D) g;
            g2.rotate(0, getX() + getWidth()/2, getY() + getHeight()/2);
            super.paintComponent(g);
        }
    }
}
