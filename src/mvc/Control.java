/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author kylefrancis
 */
public class Control implements ActionListener{
    private Model model;
    private View view;

    public Control(Model model, View view) {
        this.model = model;
        this.view = view;
        
        view.getSaveButton().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
        view.getNameLabel().setText(view.getNameField().getText());
        System.out.println("saved");
        view.updateUI();
    }
    
    
    
}
