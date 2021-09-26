/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package mvc;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author kylefrancis
 */
public class View extends JPanel{
    private JFrame frame;
    private JLabel nameLabel;
    private JLabel ageLabel;
    private JTextField nameField;
    private JComboBox ageBox;
    private JButton saveButton;
    private JPanel inputPanel;
    private JPanel outputPanel;
    private Integer[] ageArray;
    
    public View(String title)
    {
        
        //create elements
        this.nameLabel = new JLabel("Name: ");
        this.ageLabel = new JLabel("Age: ");
        this.nameField = new JTextField(10);
        this.saveButton = new JButton("Save Info");
        this.inputPanel = new JPanel();
        this.outputPanel = new JPanel();
        this.ageArray = new Integer[50];
        for(int i = 0; i < ageArray.length; i++)
        {
            this.ageArray[i] = (i+1);
        }
        this.ageBox = new JComboBox(ageArray);
        
        outputPanel.add(nameLabel);
        outputPanel.add(ageLabel);
        outputPanel.setBackground(Color.RED);
        inputPanel.add(nameField);
        inputPanel.add(ageBox);
        inputPanel.add(saveButton);
        inputPanel.setBackground(Color.BLUE);
        this.add(outputPanel, BorderLayout.NORTH);
        this.add(inputPanel, BorderLayout.SOUTH);
        
        //frame setup
        this.frame = new JFrame(title);
        frame.getContentPane().add(this);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 120);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    
    public JFrame getFrame() {
        return frame;
    }
    
    public void setFrame(JFrame frame) {
        this.frame = frame;
    }
    
    public JLabel getNameLabel() {
        return nameLabel;
    }
    
    public void setNameLabel(JLabel nameLabel) {
        this.nameLabel = nameLabel;
    }
    
    public JLabel getAgeLabel() {
        return ageLabel;
    }
    
    public void setAgeLabel(JLabel ageLabel) {
        this.ageLabel = ageLabel;
    }
    
    public JTextField getNameField() {
        return nameField;
    }
    
    public void setNameField(JTextField nameField) {
        this.nameField = nameField;
    }
    
    public JComboBox getAgeBox() {
        return ageBox;
    }
    
    public void setAgeBox(JComboBox ageBox) {
        this.ageBox = ageBox;
    }
    
    public JButton getSaveButton() {
        return saveButton;
    }
    
    public void setSaveButton(JButton saveButton) {
        this.saveButton = saveButton;
    }
}
