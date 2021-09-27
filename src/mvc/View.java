/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package mvc;

import java.awt.Color;
import java.awt.Dimension;
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
    private JButton selectButton;
    private JLabel selectLabel;
    private BufferedImage bi;
    private Image img;
    private ImageIcon icon;
    private JLabel imgLabel;
    
    public View(String title)
    {
        this.constructLogIn(title+ " - Login");
        this.constructSignUp(title+ " - Sign Up");
        this.constructSelect(title+ " - Select Pet");
    }
    //----------------------------------GETTERS AND SETTERS---------------------
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
    
    public JButton getSelectButton() {
        return selectButton;
    }
    
    public JLabel getSelectLabel() {
        return selectLabel;
    }
    
    public BufferedImage getBi() {
        return bi;
    }
    
    public Image getImg() {
        return img;
    }
    
    public ImageIcon getIcon() {
        return icon;
    }
    
    public JLabel getImgLabel() {
        return imgLabel;
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
        this.loginButton.setBounds(30, 100, 80, 25);
        loginPanel.add(loginButton);
        
        this.signUpButton = new JButton("Sign Up");
        this.signUpButton.setBounds(120, 100, 80, 25);
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
        
        this.selectButton = new JButton("Click Me!");
        this.selectButton.setBounds(300, 300, 120, 25);
        selectPanel.add(selectButton);
        
        this.selectLabel = new JLabel("Clicks: 0");
        this.selectLabel.setForeground(new Color(220, 219, 217));
        this.selectLabel.setBounds(250, 250, 120, 25);
        selectPanel.add(selectLabel);
        
        try {
            this.bi = ImageIO.read(new File("./meme.jpg"));
            this.img = bi.getScaledInstance(selectFrame.getWidth(), selectFrame.getHeight(), Image.SCALE_DEFAULT);
            this.icon = new ImageIcon(img);
            this.imgLabel = new JLabel();
            imgLabel.setIcon(icon);
            imgLabel.setBounds(0, 0, icon.getIconWidth(), icon.getIconHeight());            
        } catch (IOException ex) {
            Logger.getLogger(View.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        selectFrame.setVisible(false);
    }
}
