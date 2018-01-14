import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PlayerBar extends JPanel implements ActionListener{
    private JLabel[] timerLabels;
    private Timer playerCountdown;
    
    public PlayerBar() {
        this.setLayout(new GridLayout(8,1));
        this.setPreferredSize(new Dimension(Main.timerWidth, Board.height));
        
        // Initialize timerLabels
        timerLabels = new JLabel[2];
        
        // Timer for countdown
        playerCountdown = new Timer(1000, this);
        playerCountdown.start();
        
        // Inital Time
        int timeSet = 1;
        String initalTime = ":00";
        if (timeSet < 10) {
            initalTime = "0" + timeSet + initalTime;
        } else {
            initalTime = timeSet + initalTime;
        }
        
        // Black: top 2 boxes
        JLabel blackName = new JLabel("Black", JLabel.CENTER);
        blackName.setBorder(Board.standard);
        blackName.setFont(Main.fontStyle);
        
        JLabel blackTimer = new JLabel(initalTime, JLabel.CENTER);
        blackTimer.setBorder(Board.standard);
        blackTimer.setFont(Main.fontStyle);
        
        // Added timer to array
        timerLabels[0] = blackTimer;
        
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
        
        JLabel whiteTimer = new JLabel("00:05", JLabel.CENTER);
        whiteTimer.setBorder(Board.standard);
        whiteTimer.setFont(Main.fontStyle);
        
        // Added timer to array
        timerLabels[1] = whiteTimer;
        
        this.add(whiteName);
        this.add(whiteTimer);
    }
    
    public void actionPerformed(ActionEvent e){
        JLabel currentLabel = timerLabels[Board.getTurn()];
        String currentLabelText = currentLabel.getText();
        int index = currentLabelText.indexOf(":");
        int min = Integer.parseInt(currentLabelText.substring(index-2,index));
        int sec = Integer.parseInt(currentLabelText.substring(index+1,index+3));
        if (sec <= 1) {
            if (min == 0) {
                playerCountdown.stop();
                Board.gameFinished(Board.getCurrentKing());
                sec--;
            } else {
                min--;
                sec = 59;
            }
        } else {
            sec--;
        }
        String newText = ":";
        // Minutes configuration
        if (min < 10) {
            newText = "0" + min + newText;
        } else {
            newText = min + newText;
        }
        
        // Seconds configuration
        if (sec < 10) {
            newText = newText + "0" + sec;
        } else {
            newText = newText + sec;
        }
        currentLabel.setText(newText);
    }
    
}