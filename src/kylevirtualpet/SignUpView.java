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
public class SignUpView extends JFrame{
    
    private Color fontColour = new Color(220, 219, 217);
    private Color backgroundColour = new Color(35, 36, 38);
    private Font font = new Font("Display", Font.BOLD, 30);
    
    //instansiate signup comopnents
    private JLabel userLabel;
    private JLabel passLabel;
    private JLabel confirmPassLabel;
    private JTextField userField;
    private JPasswordField passField;
    private JPasswordField confirmPassField;
    private JButton createButton;
    private JButton backButton;
    private JLabel successLabel;
    private JPanel signUpPanel;
    private JLabel createTipLabel;
    
    //sign up constructor
    public SignUpView(String title) {
        super(title);
        //sign up frame
        this.signUpPanel = new JPanel();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(350, 200);
        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension screenDimension = tk.getScreenSize();
        Dimension frameDimension = this.getSize();
        this.setLocation((screenDimension.width-frameDimension.width)/2,
                (screenDimension.height-frameDimension.height)/2);
        this.add(signUpPanel);
        this.setResizable(false);
        
        signUpPanel.setLayout(null);
        signUpPanel.setBackground(backgroundColour);
        
        //create elements
        this.userLabel = new JLabel("Username: ");
        this.userLabel.setForeground(fontColour);
        this.userLabel.setBounds(40, 30, 80, 25);
        signUpPanel.add(userLabel);
        
        this.userField = new JTextField(10);
        this.userField.setBounds(160, 30, 150, 25);
        signUpPanel.add(userField);
        
        this.passLabel = new JLabel("Password: ");
        this.passLabel.setForeground(fontColour);
        this.passLabel.setBounds(40, 60, 80, 25);
        signUpPanel.add(passLabel);
        
        this.passField = new JPasswordField(10);
        this.passField.setBounds(160, 60, 150, 25);
        signUpPanel.add(passField);
        
        this.confirmPassLabel = new JLabel("Confirm Password: ");
        this.confirmPassLabel.setForeground(fontColour);
        this.confirmPassLabel.setBounds(40, 90, 130, 25);
        signUpPanel.add(confirmPassLabel);
        
        this.confirmPassField = new JPasswordField(10);
        this.confirmPassField.setBounds(160, 90, 150, 25);
        signUpPanel.add(confirmPassField);
        
        this.backButton = new JButton("Back");
        backButton.setBounds(5, 5, 80, 25);
        signUpPanel.add(backButton);
        
        this.createButton = new JButton("Create Owner");
        this.createButton.setBounds(30, 115, 120, 25);
        signUpPanel.add(createButton);
        
        this.createTipLabel = new JLabel("<html>To save owner you must select a pet</html>");
        createTipLabel.setBounds(160, 115, 170, 30);
        createTipLabel.setForeground(fontColour);
        signUpPanel.add(createTipLabel);
        
        this.successLabel = new JLabel("");
        this.successLabel.setBounds(40, 140, 300, 25);
        signUpPanel.add(successLabel);
        
        this.setVisible(false);
    }
    
    //getters and setters
    JButton getCreateButton() {
        return createButton;
    }
    
    public JTextField getUserField() {
        return userField;
    }
    
    public JTextField getPassField() {
        return passField;
    }
    
    public JTextField getConfirmPassField() {
        return confirmPassField;
    }
    
    public JLabel getSuccessLabel() {
        return successLabel;
    }

    public JButton getBackButton() {
        return backButton;
    }
    
    
}
