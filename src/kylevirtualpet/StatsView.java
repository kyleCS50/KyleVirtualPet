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
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author kylefrancis
 */
public class StatsView extends JFrame{
    
    private Color fontColour = new Color(220, 219, 217);
    private Color backgroundColour = new Color(35, 36, 38);
    private Font font = new Font("Display", Font.BOLD, 30);
    
    //instansiate stats compnents
    private JLabel statsLabel;
    private JLabel scoresLabel;
    private JLabel topFiveLabel;
    private JLabel diffLabel;
    private JLabel diffOwnersLabel;
    private JButton backButton;
    private JButton diffButton;
    private JComboBox diffBox;
    private JPanel scoresPanel;
    private JPanel diffPanel;
    private JPanel statsPanel;
    
    //stats constructor
    public StatsView(String title)
    {
        //stats frame
        super(title);
        this.statsPanel = new JPanel();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1250, 700);
        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension screenDimension = tk.getScreenSize();
        Dimension frameDimension = this.getSize();
        this.setLocation((screenDimension.width-frameDimension.width)/2,
                (screenDimension.height-frameDimension.height)/2);
        this.add(statsPanel);
        this.setResizable(false);
        
        statsPanel.setLayout(null);
        statsPanel.setBackground(backgroundColour);
        
        this.statsLabel = new JLabel("Game Stats");
        statsLabel.setFont(font);
        statsLabel.setForeground(fontColour);
        statsLabel.setBounds(525, 20, 200, 50);
        statsPanel.add(statsLabel);
        
        this.scoresPanel = new JPanel();
        scoresPanel.setBackground(new Color(62, 62, 64));
        scoresPanel.setBounds(212, 200, 403, 460);
        scoresPanel.setLayout(null);
        
        this.diffPanel = new JPanel();
        diffPanel.setBackground(new Color(62, 62, 64));
        diffPanel.setBounds(635, 200, 403, 460);
        diffPanel.setLayout(null);
        
        this.backButton = new JButton("Back");
        backButton.setFont(new Font("Display", Font.PLAIN, 15));
        backButton.setBounds(10, 15, 150, 25);
        statsPanel.add(backButton);
        
        this.scoresLabel = new JLabel("High Scores");
        scoresLabel.setFont(font);
        scoresLabel.setForeground(fontColour);
        scoresLabel.setBounds(314, 150, 200, 35);
        statsPanel.add(scoresLabel);
        
        this.diffLabel = new JLabel("Difficulty");
        diffLabel.setFont(font);
        diffLabel.setForeground(fontColour);
        diffLabel.setBounds(747, 150, 200, 35);
        statsPanel.add(diffLabel);
        
        this.topFiveLabel = new JLabel();
        topFiveLabel.setFont(font);
        topFiveLabel.setForeground(fontColour);
        topFiveLabel.setBounds(80, 10, 400, 400);
        scoresPanel.add(topFiveLabel);
        
        String[] diff = new String[]{"Easy", "Medium", "Hard"};
        this.diffBox = new JComboBox(diff);
        diffBox.setBounds(80, 10, 100, 25);
        diffPanel.add(diffBox);
        
        this.diffButton = new JButton("See Owners");
        diffButton.setBounds(190, 10, 100, 25);
        diffPanel.add(diffButton);
        
        this.diffOwnersLabel = new JLabel();
        diffOwnersLabel.setForeground(fontColour);
        diffOwnersLabel.setFont(font);
        diffOwnersLabel.setBounds(10, 0, 383, 460);
        diffPanel.add(diffOwnersLabel);
        
        statsPanel.add(scoresPanel);
        statsPanel.add(diffPanel);
        
        this.setVisible(false);
    }
    
    //getter methods
    public JButton getDiffButton() {
        return diffButton;
    }
    
    public JComboBox getDiffBox() {
        return diffBox;
    }
    
    public JLabel getDiffOwnersLabel() {
        return diffOwnersLabel;
    }
    
    public JButton getBackButton() {
        return backButton;
    }
    
    public JPanel getStatsPanel() {
        return statsPanel;
    }
    
    public JLabel getTopFiveLabel()
    {
        return topFiveLabel;
    }
    
}
