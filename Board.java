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
        System.out.println(l.getColor());
        
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
            LineBorder bor = (LineBorder) l.getBorder();
            if (bor.getLineColor().equals(Color.blue)) {
                movePiece(selectedPiece, l);
            }
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
    
    private void movePiece(Piece currentPiece, Piece newSpot) {
        // fields for currentPiece
        Coords currentPiecePosition = currentPiece.getPosition();
        Color currentPieceBG = currentPiece.getBackground();
        int currentIndex = currentPiecePosition.toID();
        
        // fields for newSpot
        Coords newSpotPosition = newSpot.getPosition();
        Color newSpotBG = newSpot.getBackground();
        int newIndex = newSpotPosition.toID();
        
        // replacement piece for the currentPiece's spot
        Piece newPiece = new Piece(currentPiecePosition.getX(), currentPiecePosition.getY(), 2);
        newPiece.setBackground(currentPieceBG);
        // defaults
        newPiece.addMouseListener(this);
        newPiece.setBorder(standard);
        newPiece.setOpaque(true);
        
        // changing background color of currentPiece to match new spot
        currentPiece.setBackground(newSpotBG);
        currentPiece.setPosition(newSpotPosition);
        
        // swapping
        if (currentIndex < newIndex) {
            pane.add(newPiece, currentIndex);
            pane.add(currentPiece, newIndex);
            pane.remove(newSpot);
        } else {
            pane.add(currentPiece, newIndex);
            pane.remove(newSpot);
            pane.add(newPiece, currentIndex);
        }
        
        // for pawns to not allowed to take 2 spots forward
        // for pawns to be promoted
        if (currentPiece instanceof Pawn) {
            Pawn currentPieceTemp = (Pawn) currentPiece;
            currentPieceTemp.notFirst();
            // if in the final row. 0 = for top row, 7 for bottom row
            if (newSpotPosition.getX() == 0 || newSpotPosition.getX() == 7) {
                Piece promotePiece = promotion(newSpotPosition, currentPiece.getColor());
                
                // Match promotePiece to currentPiece
                promotePiece.setBackground(newSpotBG);
                promotePiece.addMouseListener(this);
                promotePiece.setBorder(standard);
                promotePiece.setOpaque(true);
                
                // Replacing currentPiece with promotePiece
                pane.remove(currentPiece);
                pane.add(promotePiece, newIndex);
            }
        }
        
        // turn base mechanic  
        // can be swap to a boolean
        if (turn == 1) {
            turn = 0;
        } else {
            turn = 1;
        }
        
        //checking for Check
//        if (check(currentPiece)){
//            System.out.println("Check!");
//        }
    }
    
    private Piece promotion(Coords cor, int color) {
        Piece promotePiece;
        String selection;
        int choice;
        String referenceString = "RBKQ";
        // JOptionPane
        String[] options = {"Rook","Bishop","Knight","Queen"};
        selection = (String) JOptionPane.showInputDialog(null, 
        "Choose", 
        "Promote",  
        JOptionPane.QUESTION_MESSAGE, 
        null, 
        options, 
        options[0]);
        
        try {
            choice = referenceString.indexOf(selection.substring(0,1));
        } catch (NullPointerException e) {
            return promotion(cor, color);
        }
        if (choice == 0) {
            return new Rook(cor, color);
        } else if (choice == 1) {
            return new Bishop(cor, color);
        } else if (choice == 2) {
            return new Knight(cor, color);
        } else if (choice == 3) {
            return new Queen(cor, color);
        } else {
           return promotion(cor, color);
        }
    }
    
    private Boolean check(Piece piece){
        Piece currentPiece = (Piece) piece;
        ArrayList<ArrayList<Coords>> currentMoves = currentPiece.getValidMoves();
        System.out.println(currentMoves);
        while (currentMoves.size() != 0) {
            ArrayList<Coords> currentSet = currentMoves.get(0);
            System.out.println(currentSet);
            currentSet.remove(0);
            while (currentSet.size() != 0) {
                Coords current = currentSet.get(0);
                currentSet.remove(0);
                Piece p = (Piece) pane.getComponent(current.toID());
                if (p instanceof King){
                    System.out.println("Check by" + p);
                    return true;
                }
            }
        }
        return false;
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