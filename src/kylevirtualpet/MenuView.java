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

/**
 *
 * @author kylefrancis
 */
public class MenuView extends JFrame{
    
    private Color fontColour = new Color(220, 219, 217);
    private Color backgroundColour = new Color(35, 36, 38);
    private Font font = new Font("Display", Font.BOLD, 30);
    
    //menu screen
    private JLabel menuLabel;
    private JButton playGameButton;
    private JButton statsButton;
    private JButton howToButton;
    private JFrame howToFrame;
    private JPanel howToPanel;
    private JLabel howToLabel;
    private JButton doneButton;
    private JPanel menuPanel;
    
    public MenuView(String title)
    {
        super(title);
        this.menuPanel = new JPanel();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1250, 700);
        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension screenDimension = tk.getScreenSize();
        Dimension frameDimension = this.getSize();
        this.setLocation((screenDimension.width-frameDimension.width)/2,
                (screenDimension.height-frameDimension.height)/2);
        this.add(menuPanel);
        this.setResizable(false);
        
        menuPanel.setLayout(null);
        menuPanel.setBackground(backgroundColour);
        
        this.menuLabel = new JLabel("Kyle's Virtual Pet Game");
        menuLabel.setFont(font);
        menuLabel.setForeground(fontColour);
        menuLabel.setBounds(445, 20, 360, 50);
        menuPanel.add(menuLabel);
        
        this.playGameButton = new JButton("Select and Play");
        playGameButton.setFont(font);
        playGameButton.setBounds(85, 190, 320, 320);
        menuPanel.add(playGameButton);
        
        this.statsButton = new JButton("Game Stats");
        statsButton.setFont(font);
        statsButton.setBounds(465, 190, 320, 320);
        menuPanel.add(statsButton);
        
        this.howToButton = new JButton("How To Play");
        howToButton.setFont(font);
        howToButton.setBounds(845, 190, 320, 320);
        menuPanel.add(howToButton);
        
        this.howToFrame = new JFrame("How To Play");
        this.howToPanel = new JPanel();
        howToFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        howToFrame.setSize(450, 220);
        howToFrame.setLocation((screenDimension.width-frameDimension.width)/2,
                (screenDimension.height-frameDimension.height)/2);
        howToFrame.add(howToPanel);
        howToFrame.setResizable(false);
        
        howToPanel.setLayout(null);
        howToPanel.setBackground(backgroundColour);
        
        String howToText = "To play first pick a pet. Each pet has a different difficulty level. "
                + "Once you've picked your pet you can play, feed and clean them. "
                + "A harder difficulty means lower starting stats and a smaller increase to these stats when playing, feeding or cleaning. "
                + "By playing with your pet you increase their hapiness meter. "
                + "By feeding them you increase their food meter. "
                + "And by cleaning them you increase their cleanliness meter. "
                + "The aim of this game to get the highest number of rounds. "
                + "Your game will end if any of the meters go to or below 0.";
        this.howToLabel = new JLabel("<html>"+howToText+"</html>");
        howToLabel.setFont(new Font("Display", Font.PLAIN, 12));
        howToLabel.setForeground(fontColour);
        howToLabel.setBounds(25, 10, 400, 150);
        howToPanel.add(howToLabel);
        
        this.doneButton = new JButton("Done");
        this.doneButton.setBounds(345, 160, 80, 25);
        howToPanel.add(doneButton);
        
        this.setVisible(false);
        howToFrame.setVisible(false);
    }
    
    JButton getPlayGameButton() {
        return playGameButton;
    }
    
    JButton getStatsButton()
    {
        return statsButton;
    }
    
    JButton getHowToButton() {
        return howToButton;
    }
    
    JButton getDoneButton() {
        return doneButton;
    }
    
    public JFrame getHowToFrame() {
        return howToFrame;
    }
    
}
