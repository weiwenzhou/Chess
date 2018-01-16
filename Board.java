import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.*;
import java.util.ArrayList;

public class Board extends JPanel implements MouseListener {
    
    /**
    
    */
    private static Container pane;
    private Piece[] tiles;
    private boolean selected = false;
    private Piece selectedPiece;
    private static int turn;
    private static ArrayList<Piece> whitePieces;
    private static ArrayList<Piece> blackPieces;
    private static King[] kings;
    public static int height = 1024;
    public static int width = 1024;
    public static Border standard = new LineBorder(Color.black);
    public static Border current = new LineBorder(Color.red, 5);
    public static Border available = new LineBorder(Color.blue, 5);
    

    Board(String file) {
        // width = w;
        // height = h;
        
        pane = this;
        pane.setLayout(new GridLayout(8,8));
        
        // Piece Layout.
        /*
            true = white
            false = black
        */
        // initialize collection of pieces by color
        blackPieces = new ArrayList<Piece>();
        whitePieces = new ArrayList<Piece>();
        
        // initialize the array of kings
        kings = new King[2];
        
        // initialize turn
        turn = 1;
        
        boolean backgroundColor = false; 
        tiles = SaveNLoad.load(file);
        for (int index = 0; index < tiles.length; index++) {
            Piece token = tiles[index];
            // Adding token to piece
            if (token.getColor() == 0) {
                blackPieces.add(token);
            }
            if (token.getColor() == 1) {
                whitePieces.add(token);
            }
            
            // Adding kings
            if (token instanceof King) {
                kings[token.getColor()] = (King) token;
            }
            
            // Piece defaults
            token.addMouseListener(this);
            token.setBorder(standard);
            token.setOpaque(true);
            
            // Background color 
            // Alternate the colors in every row.
            // Upper left corner is white
            if (index % 8 == 0) { 
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
    
    Board() {
        this("Default.txt");
    }
    
    public static Piece getPiece(Coords cor) {
        return (Piece) pane.getComponent(cor.toID());
    }
    
    public static ArrayList<Coords> getColorMoves(int color) {
        ArrayList<Piece> viewingCollection;
        ArrayList<Coords> oppononentMoves = new ArrayList<Coords>();
        if (color == 0) {
            viewingCollection = whitePieces;
        } else {
            viewingCollection = blackPieces;
        }
        for (int x = 0; x < viewingCollection.size(); x++) {
            Piece viewingPiece = (Piece) viewingCollection.get(x);
            oppononentMoves.addAll(viewingPiece.getValidMoves());
        }
        return oppononentMoves;
    }
    
    public void mouseClicked(MouseEvent e) {
        Piece l = (Piece) e.getSource();
        
        // Testing Code
        System.out.println(l.getPosition());
        System.out.println(l.getClass());
        System.out.println(l.getColor());
        System.out.println(l);
        
        // if not selected and is a piece --> run
        // 2 equals not a tile. 0 = black, 1 = white
        // if opposite color king .getStatus = true --> then l must be the King.
        boolean isKing = true;
        if (kings[turn].getStatus()) {
            isKing = l instanceof King;
        }
        if (!selected && l.getColor() == turn && isKing) {
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
        ArrayList<Coords> locations = piece.getValidMoves();
        System.out.println(locations);
        while (locations.size() != 0) {
            Coords current = locations.get(0);
            System.out.println(current);
            locations.remove(0);
            Piece l = (Piece) pane.getComponent(current.toID());
            l.setBorder(available);
        }
    }
    
    private void movePiece(Piece currentPiece, Piece newSpot) {
        // King is taken
        if (newSpot instanceof King) {
            gameFinished((King) newSpot);
        }
        
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
        
        // king leaves check if he moves
        if (currentPiece instanceof King) {
            King currentPieceTempKing = (King) currentPiece;
            currentPieceTempKing.setStatus(false);
        }
        
        // turn base mechanic  
        // can be swap to a boolean
        if (turn == 1) {
            turn = 0;
        } else {
            turn = 1;
        }
        
        //checking for Check
        if (check(currentPiece)){
            // check in King has validMoves -> if not checkmate
            ArrayList<Coords> locations;
            King viewingKing;
            if (currentPiece.getColor() == 0) {
                viewingKing = kings[1];
            } else {
                viewingKing = kings[0];
            }
            locations = viewingKing.getValidMoves();
            // checkmate
            if (locations.size() == 0) {
                gameFinished(viewingKing);
            } else {
                System.out.println("Check!");
            }
        }
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
    
    private Boolean check(Piece currentPiece){
        ArrayList<Coords> locations = currentPiece.getValidMoves();
        System.out.println(locations);
        while (locations.size() != 0) {
            Coords current = locations.get(0);
            System.out.println(current);
            locations.remove(0);
            Piece l = (Piece) pane.getComponent(current.toID());
            if (l instanceof King && l.getColor() != currentPiece.getColor()) {
                    King tempKing = (King) l;
                    tempKing.setStatus(true);
                    return true;
            }
        }
        return false;
    }
    
    public static int getTurn() {
        return turn;
    }
    
    public static void gameFinished(King viewingKing) {
        String message;
        if (viewingKing.getColor() == 0) {
            message = "White Wins!";
        } else {
            message = "Black Wins!";
        }
        JOptionPane.showMessageDialog(null, message, "Game is finished!",JOptionPane.INFORMATION_MESSAGE);
    }
    
    public static King getCurrentKing() {
        King currentKing;
        if (turn == 0) {
            currentKing = kings[0];
        } else {
            currentKing = kings[1];
        }
        return currentKing;
    }
    
    private void clearColor() {
        for (int x = 0; x < 64; x++) {
            Piece p = (Piece) pane.getComponent(x);
            p.setBorder(standard);
        }
    }
    
    public String[] compressBoard() {
        String[] packBoard = new String[64];
        for (int x = 0; x < 64; x++) {
            Piece currentPiece = (Piece) pane.getComponent(x);
            packBoard[x] = currentPiece.toString();
        }
        return packBoard;
    } 
    
    public static void setDimensionForDemo(int w, int h) {
        width = w;
        height = h;
    }
    
    public static void main(String[] args) {
	// Board test;
	// if (args.length == 2){
	    // test = new Board(Integer.parseInt(args[0]), Integer.parseInt(args[1])); }
	// else {
	     // test = new Board();
	// }
	// test.setVisible(true);
    }
}
