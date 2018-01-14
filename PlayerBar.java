import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PlayerBar extends JPanel {
    private JLabel[] timerLabels;
    
    
    public PlayerBar() {
        this.setLayout(new GridLayout(8,1));
        this.setPreferredSize(new Dimension(Main.timerWidth, Board.height));
        
        // Black: top 2 boxes
        JLabel blackName = new JLabel("Black", JLabel.CENTER);
        blackName.setBorder(Board.standard);
        blackName.setFont(Main.fontStyle);
        
        JLabel blackTimer = new JLabel();
        blackTimer.setBorder(Board.standard);
        blackTimer.setFont(Main.fontStyle);
        
        this.add(blackName);
        this.add(blackTimer);
        
        // Filler Labels
        for (int x = 0; x < 4; x++) {
            this.add(new JLabel());
        }
        
        // White: bottom 2 boxes
        JLabel whiteName = new JLabel("White", JLabel.CENTER);
        whiteName.setBorder(Board.standard);
        whiteName.setFont(Main.fontStyle);
        
        JLabel whiteTimer = new JLabel();
        whiteTimer.setBorder(Board.standard);
        whiteTimer.setFont(Main.fontStyle);
        
        this.add(whiteName);
        this.add(whiteTimer);
    }
    
}