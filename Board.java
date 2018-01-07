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
        
        // Piece Layout.
        /*
            true = white
            false = black
        */
        boolean backgroundColor = false; 
        tiles = new Piece[8][8];
        for (int r = 0; r < tiles.length; r++) {
            for (int c = 0; c < tiles[r].length; c++) {
                Piece token;
                
                // Black Pieces (Top Side) 
                
                if (r == 0) {
                    if (c == 0 || c == 7) {
                        token = new Rook(r, c, 0);
                    }
                    if (c == 1 || c == 6) {
                        token = new Knight(r, c, 0);
                    }
                    if (c == 2 || c == 5) {
                        token = new Bishop(r, c, 0);
                    }
                    if (c == 3) {
                        token = new Queen(r, c, 0);
                    } 
                    if (c == 4) {
                        token = new King(r, c, 0);
                    }
                } else if (r == 1) {
                    token = new Pawn(r, c, 0);
                } else if (r == 6) {
                    token = new Pawn(r, c, 1);
                } else if (r == 7) {
                    if (c == 0 || c == 7) {
                        token = new Rook(r, c, 1);
                    }
                    if (c == 1 || c == 6) {
                        token = new Knight(r, c, 1);
                    }
                    if (c == 2 || c == 5) {
                        token = new Bishop(r, c, 1);
                    }
                    if (c == 3) {
                        token = new Queen(r, c, 1);
                    } 
                    if (c == 4) {
                        token = new King(r, c, 1);
                    }
                } else {
                    token = new Piece(r, c, 2)
                }
                
                tiles[r][c] = token;
                
                // Piece defaults
                token.addMouseListener(this);
                token.setBorder(standard);
                token.setOpaque(true);
                
                // Background color 
                // Alternate the colors in every row.
                // Upper left corner is white
                if (y == 0) { 
                    color = !color;
                }
                if (color) {
                    l.setBackground(Color.white);
                    color = false;
                } else {
                    l.setBackground(Color.green);
                    color = true;
                }
                
                // Adds the token to the Container
                pane.add(token);
            }
        }
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