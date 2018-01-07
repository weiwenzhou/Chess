import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.*;
import java.util.ArrayList;

public class Board extends JFrame implements MouseListener {
    
    /**
    
    */
    private Container pane;
    private Piece[][] tiles;
    private boolean selected;
    private Piece selectedPiece;
    private int turn;
    private ArrayList<Piece> whitePieces;
    private ArrayList<Piece> blackPieces;
    public static int height = 1024;
    public static int width = 1024;
    public static Border standard = new LineBorder(Color.black);
    public static Border current = new LineBorder(Color.red, 5);
    public static Border available = new LineBorder(Color.blue, 5);
    
    Board() {
        
        this.setTitle("Chess");
        this.setSize(width,height);
        this.setLocation(100,100);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        
        pane = this.getContentPane();
        
        pane.setLayout(new GridLayout(8,8));
    }
    
    Board(int h, int w) {
    
    }
    
    public static Piece[][] getContainer() {
        return new Piece[8][8];
    }
    
    public void mouseClicked(MouseEvent e) {
        
    }
    
    public void mouseEntered(MouseEvent e) {
        
    }
    
    public void mouseExited(MouseEvent e) {
        
    }
    
    public void mousePressed(MouseEvent e) {
        
    }
    
    public void mouseReleased(MouseEvent e) {
        
    }
    
    private void movePiece(Piece currentSpot, Piece newSpot) {
        
    }
    
    private Piece Promotion(int x, int y, int color) {
        return null;
    }
    
    public String toString() {
        return "";
    } 
    
    public void clearColor() {
        
    }

}