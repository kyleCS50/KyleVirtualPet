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
import javax.swing.JList;
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
    private JButton newGameButton;
    private JButton loadGameButton;
    private JButton statsButton;
    private JButton howToButton;
    private JPanel menuPanel;
    private JButton logOutButton;
    
    private JFrame howToFrame;
    private JPanel howToPanel;
    private JLabel howToLabel;
    private JButton doneButton;
    
    private JFrame loadFrame;
    private JPanel loadPanel;
    private JList petList;
    private JButton loadButton;
    private JButton backButton;
    
    private boolean petSelected;
    
    public MenuView(String title)
    {
        super(title);
        this.menuPanel = new JPanel();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1250, 700);
        Toolkit tk1 = Toolkit.getDefaultToolkit();
        Dimension screenDimension1 = tk1.getScreenSize();
        Dimension frameDimension1 = this.getSize();
        this.setLocation((screenDimension1.width-frameDimension1.width)/2,
                (screenDimension1.height-frameDimension1.height)/2);
        this.add(menuPanel);
        this.setResizable(false);
        
        menuPanel.setLayout(null);
        menuPanel.setBackground(backgroundColour);
        
        this.menuLabel = new JLabel("Kyle's Virtual Pet Game");
        menuLabel.setFont(font);
        menuLabel.setForeground(fontColour);
        menuLabel.setBounds(445, 20, 360, 50);
        menuPanel.add(menuLabel);
        
        this.logOutButton = new JButton("Log Out");
        logOutButton.setBounds(10, 10, 80, 25);
        menuPanel.add(logOutButton);
        
        this.newGameButton = new JButton("New Game");
        newGameButton.setFont(font);
        newGameButton.setBounds(370, 150, 240, 240);
        menuPanel.add(newGameButton);
        
        this.loadGameButton = new JButton("Load Game");
        loadGameButton.setFont(font);
        loadGameButton.setBounds(620, 150, 240, 240);
        menuPanel.add(loadGameButton);
        
        this.statsButton = new JButton("Game Stats");
        statsButton.setFont(font);
        statsButton.setBounds(370, 400, 240, 240);
        menuPanel.add(statsButton);
        
        this.howToButton = new JButton("How To Play");
        howToButton.setFont(font);
        howToButton.setBounds(620, 400, 240, 240);
        menuPanel.add(howToButton);
        
        this.howToFrame = new JFrame("How To Play");
        this.howToPanel = new JPanel();
        howToFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        howToFrame.setSize(450, 220);
        Toolkit tk2 = Toolkit.getDefaultToolkit();
        Dimension screenDimension2 = tk2.getScreenSize();
        Dimension frameDimension2 = howToFrame.getSize();
        howToFrame.setLocation((screenDimension2.width-frameDimension2.width)/2,
                (screenDimension2.height-frameDimension2.height)/2);
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
        
        this.loadFrame = new JFrame("Load Game");
        this.loadPanel = new JPanel();
        loadFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        loadFrame.setSize(500, 220);
        Toolkit tk3 = Toolkit.getDefaultToolkit();
        Dimension screenDimension3 = tk3.getScreenSize();
        Dimension frameDimension3 = loadFrame.getSize();
        loadFrame.setLocation((screenDimension3.width-frameDimension3.width)/2,
                (screenDimension3.height-frameDimension3.height)/2);
        loadFrame.add(loadPanel);
        loadFrame.setResizable(false);
        
        loadPanel.setLayout(null);
        loadPanel.setBackground(backgroundColour);
        
        this.petList = new JList();
        petList.setBackground(new Color(62, 62, 64));
        petList.setForeground(fontColour);
        petList.setBounds(10, 10, 480, 140);
        loadPanel.add(petList);
        
        this.backButton = new JButton("Back");
        backButton.setBounds(10, 160, 80, 25);
        loadPanel.add(backButton);
        
        this.loadButton = new JButton("Load Pet");
        loadButton.setBounds(410, 160, 80, 25);
        loadPanel.add(loadButton);
        
        this.petSelected = false;
        
        this.setVisible(false);
        howToFrame.setVisible(false);
        loadFrame.setVisible(false);
    }
    
    public JButton getLoadButton() {
        return loadButton;
    }
    
    JButton getNewGameButton() {
        return newGameButton;
    }
    
    JButton getLoadGameButton()
    {
        return loadGameButton;
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
    
    public JButton getStatsButton() {
        return statsButton;
    }
    
    public JButton getLogOutButton() {
        return logOutButton;
    }
    
    public JFrame getLoadFrame()
    {
        return loadFrame;
    }
    
    public JButton getBackButton()
    {
        return backButton;
    }
    
    public JList getPetList()
    {
        return petList;
    }
    
    public boolean isPetSelected() {
        return petSelected;
    }
    
    public void setPetSelected(boolean petSelected) {
        this.petSelected = petSelected;
    }
    
}
