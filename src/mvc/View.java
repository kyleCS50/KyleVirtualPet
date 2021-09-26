/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package mvc;

import java.awt.BorderLayout;
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
    
    public View(String title)
    {
        //set up frame
        this.frame = new JFrame(title);
        frame.getContentPane().setLayout(new BorderLayout());
        frame.getContentPane().setLayout(new BorderLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 120);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        
        //create elements
        this.nameLabel = new JLabel("Name: ");
        this.ageLabel = new JLabel("Age: ");
        this.nameField = new JTextField();
        this.ageBox = new JComboBox();
        this.saveButton = new JButton("Save Info");
        
        this.add(nameLabel, BorderLayout.CENTER);
        this.add(ageLabel, BorderLayout.CENTER);
        this.add(nameField, BorderLayout.NORTH);
        this.add(ageBox, BorderLayout.NORTH);
        this.add(saveButton, BorderLayout.NORTH);
        
        frame.add(this);
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
