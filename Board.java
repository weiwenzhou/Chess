import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.*;
import java.util.ArrayList;

public class Board extends JFrame implements MouseListener {
    
    /**
    
    */
    private static Container pane;
    private Piece[][] tiles;
    private boolean selected = false;
    private Piece selectedPiece;
    private int turn = 1;
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
                Piece token = new Piece(r, c, 2);
                
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
                    token = new Piece(r, c, 2);
                }
                
                tiles[r][c] = token;
                
                // Piece defaults
                token.addMouseListener(this);
                token.setBorder(standard);
                token.setOpaque(true);
                
                // Background color 
                // Alternate the colors in every row.
                // Upper left corner is white
                if (c == 0) { 
                    backgroundColor = !backgroundColor;
                }
                if (backgroundColor) {
                    token.setBackground(Color.white);
                    backgroundColor = false;
                } else {
                    token.setBackground(Color.green);
                    backgroundColor = true;
                }
                
                // Adds the token to the Container
                pane.add(token);
            }
        }
    }
    
    Board(int h, int w) {
    
    }
    
    public static Piece getPiece(Coords cor) {
        return (Piece) pane.getComponent(cor.toID());
    }
    
    public void mouseClicked(MouseEvent e) {
        Piece l = (Piece) e.getSource();
        
        // Testing Code
        System.out.println(l.getPosition());
        System.out.println(l.getClass());
        
        // if not selected and is a piece --> run
        // 2 equals not a tile. 0 = black, 1 = white
        if (!selected && l.getColor() == turn) {
            // changes the border of the piece pressed
            l.setBorder(current);
            // highlights the places where the piece can go to
            highlight(l);
            // is selected after
            selected = true;
            selectedPiece = l;
        } else {
            
            
            // not selected after and clears border colors
            clearColor();
            selected = false;
            selectedPiece = null;
        }
    }
    
    public void mouseEntered(MouseEvent e) {
        
    }
    
    public void mouseExited(MouseEvent e) {
        
    }
    
    public void mousePressed(MouseEvent e) {
        
    }
    
    public void mouseReleased(MouseEvent e) {
        
    }
    
    private void highlight (Piece piece) {
        Piece p = (Piece) piece;
        ArrayList<ArrayList<Coords>> locations = p.getValidMoves();
        System.out.println(locations);
        while (locations.size() != 0) {
            ArrayList<Coords> currentSet = locations.get(0);
            System.out.println(currentSet);
            locations.remove(0);
            while (currentSet.size() != 0) {
                Coords current = currentSet.get(0);
                currentSet.remove(0);
                Piece l = (Piece) pane.getComponent(current.toID());
                l.setBorder(available);
            }
        }
    }
    
    private void movePiece(Piece currentSpot, Piece newSpot) {
        
    }
    
    private Piece Promotion(int x, int y, int color) {
        return null;
    }
    
    public String toString() {
        return "";
    } 
    
    private void clearColor() {
        for (int x = 0; x < 64; x++) {
            Piece p = (Piece) pane.getComponent(x);
            p.setBorder(standard);
        }
    }
    
    public static void main(String[] args) {
        Board test = new Board();
        test.setVisible(true);
    }
}