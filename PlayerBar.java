import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PlayerBar extends JPanel implements ActionListener{
    private static JLabel[][] playerLabels;
    private Timer playerCountdown;
    private static int timeSet = 10;
    private static String whitePlayerName = "White";
    private static String blackPlayerName = "Black";
    
    public PlayerBar() {
        this.setLayout(new GridLayout(8,1));
        this.setPreferredSize(new Dimension(Main.timerWidth, Board.height));
        
        // Initialize playerLabels
        playerLabels = new JLabel[2][3];
        
        // Timer for countdown
        playerCountdown = new Timer(1000, this);
        playerCountdown.start();
        
        // Inital Time
        String initalTime = ":00";
        if (timeSet < 10) {
            initalTime = "0" + timeSet + initalTime;
        } else {
            initalTime = timeSet + initalTime;
        }
        
        // Black: top 3 boxes
        JLabel blackName = new JLabel(blackPlayerName, JLabel.CENTER);
        blackName.setBorder(Board.standard);
        blackName.setFont(Main.fontStyle);
        
        JLabel blackTimer = new JLabel(initalTime, JLabel.CENTER);
        blackTimer.setBorder(Board.standard);
        blackTimer.setFont(Main.fontStyle);
        
        JLabel blackCheck = new JLabel("",JLabel.CENTER);
        blackCheck.setFont(Main.fontStyle);
        
        // Added JLabels to array
        playerLabels[0][0] = blackName;
        playerLabels[0][1] = blackTimer;
        playerLabels[0][2] = blackCheck;
        
        this.add(blackName);
        this.add(blackTimer);
        this.add(blackCheck);
        
        // Filler Labels
        for (int x = 0; x < 2; x++) {
            this.add(new JLabel());
        }
        
        // White: bottom 3 boxes
        JLabel whiteCheck = new JLabel("",JLabel.CENTER);
        whiteCheck.setFont(Main.fontStyle);
        
        JLabel whiteName = new JLabel(whitePlayerName, JLabel.CENTER);
        whiteName.setBorder(Board.standard);
        whiteName.setFont(Main.fontStyle);
        
        JLabel whiteTimer = new JLabel(initalTime, JLabel.CENTER);
        whiteTimer.setBorder(Board.standard);
        whiteTimer.setFont(Main.fontStyle);
        
        // Added timer to array
        playerLabels[1][0] = whiteName;
        playerLabels[1][1] = whiteTimer;
        playerLabels[1][2] = whiteCheck;
        
        this.add(whiteCheck);
        this.add(whiteName);
        this.add(whiteTimer);
    }
    
    public static void showCheck(String str) {
        if (Board.getTurn() == 1) {
            playerLabels[1][2].setText(str);
        } else {
            playerLabels[0][2].setText(str);
        }
    }
    
    public void actionPerformed(ActionEvent e){
        JLabel currentLabel = playerLabels[Board.getTurn()][1];
        String currentLabelText = currentLabel.getText();
        int index = currentLabelText.indexOf(":");
        int min = Integer.parseInt(currentLabelText.substring(index-2,index));
        int sec = Integer.parseInt(currentLabelText.substring(index+1,index+3));
        boolean timerEnd = false;
        if (sec <= 1) {
            if (min == 0) {
                playerCountdown.stop();
                timerEnd = true;
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
        
        // Trigger win screen 
        if (timerEnd) {
            Board.gameFinished(Board.getCurrentKing());
        }
    }
    
    public static void changeTimerStartTime(int x) {
        timeSet = x;
    }
    
    public static void setPlayerNames(String white, String black) {
        whitePlayerName = white;
        blackPlayerName = black;
    }
}