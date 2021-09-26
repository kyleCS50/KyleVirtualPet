/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package mvc;

import java.awt.BorderLayout;
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
    private JFrame frame;
    private JLabel usernameLabel;
    private JLabel passwordLabel;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private JLabel success;
    private JPanel loginPanel;
    
    
    public View(String title)
    {
        //frame setup
        this.frame = new JFrame(title);
        this.loginPanel = new JPanel();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(350, 200);
        frame.add(loginPanel);
        
        loginPanel.setLayout(null);
        
        //create elements
        this.usernameLabel = new JLabel("Username: ");
        this.usernameLabel.setBounds(10, 20, 80, 25);
        loginPanel.add(usernameLabel);
        
        this.usernameField = new JTextField(10);
        this.usernameField.setBounds(100, 20, 150, 25);
        loginPanel.add(usernameField);
        
        this.passwordLabel = new JLabel("Password: ");
        this.passwordLabel.setBounds(10, 50, 80, 25);
        loginPanel.add(passwordLabel);
        
        this.passwordField = new JPasswordField(10);
        this.passwordField.setBounds(100, 50, 150, 25);
        loginPanel.add(passwordField);
        
        this.loginButton = new JButton("Log In");
        this.loginButton.setBounds(10, 80, 80, 25);
        loginPanel.add(loginButton);
        
        this.success = new JLabel("");
        this.success.setBounds(10, 110, 300, 25);
        loginPanel.add(success);
        
        frame.setVisible(true);
    }
    
    public JFrame getFrame() {
        return frame;
    }
    
    public void setFrame(JFrame frame) {
        this.frame = frame;
    }
    
    public JLabel getUsernameLabel() {
        return usernameLabel;
    }
    
    public void setUsernameLabel(JLabel usernameLabel) {
        this.usernameLabel = usernameLabel;
    }
    
    public JLabel getPasswordLabel() {
        return passwordLabel;
    }
    
    public void setPasswordLabel(JLabel passwordLabel) {
        this.passwordLabel = passwordLabel;
    }
    
    public JTextField getUsernameField() {
        return usernameField;
    }
    
    public void setUsernameField(JTextField usernameField) {
        this.usernameField = usernameField;
    }
    
    public JTextField getPasswordField() {
        return passwordField;
    }
    
    public void setPasswordField(JPasswordField passwordField) {
        this.passwordField = passwordField;
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

    public JLabel getSuccess() {
        return success;
    }

    public void setSuccess(JLabel success) {
        this.success = success;
    }
}
