import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main extends JFrame {
    
    private Container pane;
    private JPanel letterBar, numberBar, playerBar, topBar, board;
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
        
        // Adding sections
        pane.add(board, BorderLayout.CENTER);
        
        pack();
    }
    
    
    public static void main(String[] args) {
        Main test = new Main();
        test.setVisible(true);
    }
}