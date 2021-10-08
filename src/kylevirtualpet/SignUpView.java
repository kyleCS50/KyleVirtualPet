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
    
    //signup
    private JLabel suUserLabel;
    private JLabel suPassLabel;
    private JLabel suConfirmLabel;
    private JTextField suUserField;
    private JPasswordField suPassField;
    private JPasswordField suConfirmField;
    private JButton suCreateButton;
    private JLabel suSuccessLabel;
    private JPanel signUpPanel;
    
    public SignUpView(String title) {
        super(title);
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
        
        this.setVisible(false);
    }
    
    JButton getSuCreateButton() {
        return suCreateButton;
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

    public JLabel getSuSuccessLabel() {
        return suSuccessLabel;
    }
    
    
}
