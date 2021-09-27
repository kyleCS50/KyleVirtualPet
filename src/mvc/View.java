/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package mvc;

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
    
    
    public View(String title)
    {
        this.constructLogIn(title+ " - Login");
        this.constructSignUp(title+ " - Sign Up");
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
    
    //----------------------------------LOG IN FRAME----------------------------
    private void constructLogIn(String title)
    {
        //login frame setup
        this.liFrame = new JFrame(title);
        this.loginPanel = new JPanel();
        getLiFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getLiFrame().setSize(350, 200);
        getLiFrame().add(loginPanel);
        getLiFrame().setResizable(false);
        loginPanel.setLayout(null);
        
        //create elements
        this.liUserLabel = new JLabel("Username: ");
        this.liUserLabel.setBounds(40, 40, 80, 25);
        loginPanel.add(liUserLabel);
        
        this.liUserField = new JTextField(10);
        this.liUserField.setBounds(130, 40, 150, 25);
        loginPanel.add(liUserField);
        
        this.liPassLabel = new JLabel("Password: ");
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
        
        getLiFrame().setVisible(true);
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
        
        //create elements
        this.suUserLabel = new JLabel("Username: ");
        this.suUserLabel.setBounds(40, 20, 80, 25);
        signUpPanel.add(suUserLabel);
        
        this.suUserField = new JTextField(10);
        this.suUserField.setBounds(160, 20, 150, 25);
        signUpPanel.add(suUserField);
        
        this.suPassLabel = new JLabel("Password: ");
        this.suPassLabel.setBounds(40, 50, 80, 25);
        signUpPanel.add(suPassLabel);
        
        this.suPassField = new JPasswordField(10);
        this.suPassField.setBounds(160, 50, 150, 25);
        signUpPanel.add(suPassField);
        
        this.suConfirmLabel = new JLabel("Confirm Password: ");
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
}
