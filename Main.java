import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main extends JFrame {
    
    private Container pane;
    private JPanel numberBar, playerBar, topBar, board;
    public static int barWidth = 32;
    public static int timerWidth = 256;
    public static Font fontStyle = new Font("Comic Sans Ms", Font.BOLD, barWidth);
    
    public Main() {
        // Window Dimension
        this.setTitle("Chess");
        this.setSize(Board.width+barWidth+timerWidth,Board.height+barWidth);
        this.setLocation(100,100);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        
        pane = this.getContentPane();
        
        // JPanel initialize
        board = new Board();
        topBar = makeTopBar();
        numberBar = makeNumberBar();
        playerBar = new PlayerBar();
        
        // Adding sections
        pane.add(board, BorderLayout.CENTER);
        pane.add(topBar, BorderLayout.PAGE_START);
        pane.add(numberBar, BorderLayout.LINE_START);
        pane.add(playerBar, BorderLayout.LINE_END);
        
        pack();
    }
    
    private JPanel makeLetterBar() {
        JPanel letterBar = new JPanel(new GridLayout(1,8));
        for (int x = 0; x < 8; x++) {
            JLabel token;
            
            char letter = (char) (65+x);
            token = new JLabel(""+letter, JLabel.CENTER);
            token.setPreferredSize(new Dimension(Board.width/8,barWidth));
            token.setFont(fontStyle);
            
            token.setBorder(Board.standard);
            letterBar.add(token);
        }
        return letterBar;
    }

    private JPanel makeTopBar() {
        JPanel top = new JPanel(new BorderLayout());
        
        // letterBar
        JPanel letterBar = makeLetterBar();
        
        // Left Side Box
        JLabel leftBox = new JLabel();
        leftBox.setPreferredSize(new Dimension(barWidth,barWidth));
        
        // Right Side Box
        JLabel rightBox = new JLabel();
        rightBox.setPreferredSize(new Dimension(timerWidth,barWidth));
        
        
        top.add(leftBox, BorderLayout.LINE_START);
        top.add(rightBox, BorderLayout.LINE_END);
        top.add(letterBar, BorderLayout.CENTER);
        
        return top;
    }
    
    private JPanel makeNumberBar() {
        numberBar = new JPanel(new GridLayout(8,1));
        numberBar.setPreferredSize(new Dimension(barWidth,Board.width/8));
        
        for (int x = 8; x > 0; x--) {
            JLabel token;
            token = new JLabel(""+x, JLabel.CENTER);
            token.setPreferredSize(new Dimension(barWidth,Board.width/8));
            token.setFont(fontStyle);
            
            token.setBorder(Board.standard);
            numberBar.add(token);
        }
        
        return numberBar;
    }
    
    
    public static void main(String[] args) {
        Main test = new Main();
        test.setVisible(true);
    }
}