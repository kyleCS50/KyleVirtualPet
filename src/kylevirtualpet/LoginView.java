/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package kylevirtualpet;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
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
public class LoginView extends JFrame{
    
    private Color fontColour = new Color(220, 219, 217);
    private Color backgroundColour = new Color(35, 36, 38);
    private Font font = new Font("Display", Font.BOLD, 30);
    
    //login
    private JLabel liUserLabel;
    private JLabel liPassLabel;
    private JTextField userField;
    private JPasswordField passField;
    private JButton loginButton;
    private JLabel successLabel;
    private JPanel loginPanel;
    private JButton signUpButton;
    
    public LoginView(String title){
        super(title);
        //login frame setup
        this.loginPanel = new JPanel();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(350, 200);
        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension screenDimension = tk.getScreenSize();
        Dimension frameDimension = this.getSize();
        this.setLocation((screenDimension.width-frameDimension.width)/2,
                (screenDimension.height-frameDimension.height)/2);
        this.add(loginPanel);
        this.setResizable(false);
        
        loginPanel.setLayout(null);
        loginPanel.setBackground(backgroundColour);
        
        //create elements
        this.liUserLabel = new JLabel("Username: ");
        this.liUserLabel.setForeground(fontColour);
        this.liUserLabel.setBounds(40, 40, 80, 25);
        loginPanel.add(liUserLabel);
        
        this.userField = new JTextField(10);
        this.userField.setBounds(130, 40, 150, 25);
        loginPanel.add(userField);
        
        this.liPassLabel = new JLabel("Password: ");
        this.liPassLabel.setForeground(fontColour);
        this.liPassLabel.setBounds(40, 70, 80, 25);
        loginPanel.add(liPassLabel);
        
        this.passField = new JPasswordField(10);
        this.passField.setBounds(130, 70, 150, 25);
        loginPanel.add(passField);
        
        this.loginButton = new JButton("Log In");
        this.loginButton.setBounds(205, 100, 80, 25);
        loginPanel.add(loginButton);
        
        this.signUpButton = new JButton("Sign Up");
        this.signUpButton.setBounds(135, 100, 80, 25);
        this.signUpButton.setToolTipText("Don't have an account? Sign Up!");
        loginPanel.add(signUpButton);
        
        this.successLabel = new JLabel("");
        this.successLabel.setBounds(40, 125, 300, 25);
        loginPanel.add(successLabel);
        
        this.setVisible(true);
    }
    
    JButton getLoginButton() {
        return loginButton;
    }
    
    JButton getSignUpButton() {
        return signUpButton;
    }
    
    public JTextField getUserField() {
        return userField;
    }
    
    public JTextField getPassField() {
        return passField;
    }
    
    public JLabel getSuccessLabel() {
        return successLabel;
    }
    
    
}
