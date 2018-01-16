import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main extends JFrame implements ActionListener{
    
    private Container pane;
    private JPanel numberBar, playerBar, topBar;
    private Board board;
    public static int barWidth = 32;
    public static int timerWidth = 256;
    public static Font fontStyle = new Font("Comic Sans Ms", Font.BOLD, barWidth);
    private JTextField fileSave, fileLoad;
    
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
        
        // Testing Bar
        JPanel testingBar = new JPanel(new GridLayout());
        testingBar.setPreferredSize(new Dimension(Board.width+barWidth+timerWidth,64));
        JButton button1 = new JButton("New Game");
        JButton button2 = new JButton("Save");
        fileSave = new JTextField(20);
        fileSave.setText("Test.txt");
        JButton button3 = new JButton("Load");
        fileLoad = new JTextField(20);
        fileLoad.setText("Test.txt");
        
        button1.addActionListener(this);
        button2.addActionListener(this);
        button3.addActionListener(this);
        
        testingBar.add(button1);
        testingBar.add(button2);
        testingBar.add(fileSave);
        testingBar.add(button3);
        testingBar.add(fileLoad);
        
        pane.add(testingBar, BorderLayout.PAGE_END);
        
        pack();
    }
    
    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton) e.getSource();
        if (button.getText().equals("New Game")) {
            newGame();
        }
        if (button.getText().equals("Save")) {
            SaveNLoad.save(fileSave.getText(), board.compressBoard());
        }
        if (button.getText().equals("Load")) {
            newGame(fileLoad.getText());
        }
    }
    
    public void newGame(String fileName) {
        pane.remove(board);
        board = new Board(fileName);
        pane.add(board, BorderLayout.CENTER);
        
        pane.remove(playerBar);
        playerBar = new PlayerBar();
        pane.add(playerBar, BorderLayout.LINE_END);
    }
    
    public void newGame() {
        newGame("Default.txt");
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
        if (args.length == 3) {
            Board.setDimensionForDemo(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
            PlayerBar.changeTimerForDemo(Integer.parseInt(args[2]));
        }
        if (args.length == 1) {
            PlayerBar.changeTimerForDemo(Integer.parseInt(args[0]));
        }        
        Main test = new Main();
        test.setVisible(true);

    }
}