import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javafx.stage.*;

import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileSystemView;

public class Main extends JFrame implements ActionListener{
    
    private Container pane;
    private JPanel numberBar, playerBar, topBar;
    private JMenuBar menuBar;
    private JMenu Options, Help;
    private JMenuItem newGame, saver, loader, helper;
    private String file = "Default.txt";
    private Board board;
    public static int barWidth = 32;
    public static int timerWidth = 256;
    public static Font fontStyle = new Font("Comic Sans Ms", Font.BOLD, barWidth);
    private JTextField fileSave, fileLoad;
    
    public Main() {
        

        // Window Dimension
        this.setTitle("Chess");
        this.setSize(Board.width+barWidth+timerWidth,Board.height+barWidth);
        this.setLocation(0,0);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        
        pane = this.getContentPane();
        
        // JPanel initialize
        board = new Board();
        topBar = makeTopBar();
        numberBar = makeNumberBar();
        playerBar = new PlayerBar();
        menuBar = makeMenuBar();
        
        // Adding sections
        pane.add(board, BorderLayout.CENTER);
        pane.add(topBar, BorderLayout.PAGE_START);
        pane.add(numberBar, BorderLayout.LINE_START);
        pane.add(playerBar, BorderLayout.LINE_END);
        this.setJMenuBar(menuBar);
        
        pack(); 
    }
    
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("New Game")){
            newGame();
        }
        if (e.getActionCommand().equals("Save")){
            file = FileChooser.main();
            SaveNLoad.save(file, board.compressBoard());
        }
        if (e.getActionCommand().equals("Load")){
            file = FileChooser.main();
            newGame(file);
        }
        if (e.getActionCommand().equals("Help")){
            JOptionPane.showMessageDialog(null,
            "The basic goal of Chess is to capture the enemy's king. Each piece has a different set of possible \n moves that allow players to play strategically. It's no wonder Chess has become a popular worldwide \n strategy game. For a more in-depth guide, please visit www.chesscorner.com/tutorial/learn.htm .");
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
    
    private JMenuBar makeMenuBar(){
        JMenuBar menuBar = new JMenuBar();
        JMenu Options = new JMenu("Options");
        JMenu Help = new JMenu("Help");
    
        //Initializing Options JMenuItems
        newGame = new JMenuItem("New Game");
        saver = new JMenuItem("Save");
        loader = new JMenuItem("Load");
    
        Options.add(newGame);
        Options.add(saver);
        Options.add(loader);
    
    
        //Initializing Help JMenuItems
        helper = new JMenuItem("Help");
        Help.add(helper);
    
        //Adding MenuListeners
        newGame.addActionListener(this);
        saver.addActionListener(this);
        loader.addActionListener(this);
    
        helper.addActionListener(this);

        //Adding Menus to MenuBar
        menuBar.add(Options);
        menuBar.add(Help);
        
        return menuBar;
    }
    
    
    public static void main(String[] args) {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int screenHeight = screenSize.height;
        int screenWidth = screenSize.width;
        int screenValue = Math.min(screenHeight,screenWidth);
        Board.setDimension(screenValue-300, screenValue-300);
        Main test = new Main();
        test.setVisible(true);
    }
}