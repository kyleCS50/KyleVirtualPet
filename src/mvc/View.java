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
    private JLabel liSuccess;
    private JPanel loginPanel;
    private JButton signUpButton;
    
    //signup
    private JFrame suFrame;
    private JLabel suUserLabel;
    private JLabel suPassLabel;
    private JTextField suUserField;
    private JPasswordField suPassField;
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
    
    public void setLiFrame(JFrame liFrame) {
        this.liFrame = liFrame;
    }
    
    public JLabel getLiUserLabel() {
        return liUserLabel;
    }
    
    public void setLiUserLabel(JLabel liUserLabel) {
        this.liUserLabel = liUserLabel;
    }
    
    public JLabel getLiPassLabel() {
        return liPassLabel;
    }
    
    public void setLiPassLabel(JLabel liPassLabel) {
        this.liPassLabel = liPassLabel;
    }
    
    public JTextField getLiUserField() {
        return liUserField;
    }
    
    public void setLiUserField(JTextField liUserField) {
        this.liUserField = liUserField;
    }
    
    public JTextField getPasswordField() {
        return getLiPassField();
    }
    
    public void setLiPassField(JPasswordField liPassField) {
        this.liPassField = liPassField;
    }
    
    public JButton getLoginButton() {
        return loginButton;
    }
    
    public void setLoginButton(JButton loginButton) {
        this.loginButton = loginButton;
    }
    
    public JPanel getLoginPanel() {
        return loginPanel;
    }
    
    public void setLoginPanel(JPanel loginPanel) {
        this.loginPanel = loginPanel;
    }
    
    public JLabel getLiSuccess() {
        return liSuccess;
    }
    
    public void setLiSuccess(JLabel liSuccess) {
        this.liSuccess = liSuccess;
    }
    
    public JButton getSignUpButton() {
        return signUpButton;
    }
    
    public void setSignUpButton(JButton signUpButton) {
        this.signUpButton = signUpButton;
    }
    
    public JPasswordField getLiPassField() {
        return liPassField;
    }
    
    public JFrame getSuFrame() {
        return suFrame;
    }
    
    public void setSuFrame(JFrame suFrame) {
        this.suFrame = suFrame;
    }
    
    public JLabel getSuUserLabel() {
        return suUserLabel;
    }
    
    public void setSuUserLabel(JLabel suUserLabel) {
        this.suUserLabel = suUserLabel;
    }
    
    public JLabel getSuPassLabel() {
        return suPassLabel;
    }
    
    public void setSuPassLabel(JLabel suPassLabel) {
        this.suPassLabel = suPassLabel;
    }
    
    public JTextField getSuUserField() {
        return suUserField;
    }
    
    public void setSuUserField(JTextField suUserField) {
        this.suUserField = suUserField;
    }
    
    public JPasswordField getSuPassField() {
        return suPassField;
    }
    
    public void setSuPassField(JPasswordField suPassField) {
        this.suPassField = suPassField;
    }
    
    public JButton getSuCreateButton() {
        return suCreateButton;
    }
    
    public void setSuCreateButton(JButton suCreateButton) {
        this.suCreateButton = suCreateButton;
    }
    
    public JLabel getSuSuccessLabel() {
        return suSuccessLabel;
    }
    
    public void setSuSuccessLabel(JLabel suSuccessLabel) {
        this.suSuccessLabel = suSuccessLabel;
    }
    
    public JPanel getSignUpPanel() {
        return signUpPanel;
    }
    
    public void setSignUpPanel(JPanel signUpPanel) {
        this.signUpPanel = signUpPanel;
    }
    
    //----------------------------------LOG IN FRAME----------------------------
    private void constructLogIn(String title)
    {
        //login frame setup
        this.liFrame = new JFrame(title);
        this.loginPanel = new JPanel();
        liFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        liFrame.setSize(350, 200);
        liFrame.add(loginPanel);
        liFrame.setResizable(false);
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
        
        this.liSuccess = new JLabel("");
        this.liSuccess.setBounds(40, 125, 300, 25);
        loginPanel.add(liSuccess);
        
        liFrame.setVisible(true);
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
        this.suUserLabel.setBounds(40, 40, 80, 25);
        signUpPanel.add(suUserLabel);
        
        this.suUserField = new JTextField(10);
        this.suUserField.setBounds(130, 40, 150, 25);
        signUpPanel.add(suUserField);
        
        this.suPassLabel = new JLabel("Password: ");
        this.suPassLabel.setBounds(40, 70, 80, 25);
        signUpPanel.add(suPassLabel);
        
        this.suPassField = new JPasswordField(10);
        this.suPassField.setBounds(130, 70, 150, 25);
        signUpPanel.add(suPassField);
        
        this.suCreateButton = new JButton("Create Account");
        this.suCreateButton.setBounds(30, 100, 120, 25);
        signUpPanel.add(suCreateButton);
        
        suFrame.setVisible(false);
    }
}
