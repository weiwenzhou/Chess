import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Pawn extends Piece{
    private boolean firstMove;
    
    public Pawn(int x, int y, int c) {
        this(new Coords(x, y), c);
    }
    
    public Pawn (Coords coor, int c) {
        super(coor, c);
        firstMove = true;
        if (c == 0) {
            this.setIcon(new ImageIcon(new ImageIcon("./Icons/blackPawn.png").getImage().getScaledInstance(Board.width/8,Board.height/8, Image.SCALE_SMOOTH)));
        } else {
            this.setIcon(new ImageIcon(new ImageIcon("./Icons/whitePawn.png").getImage().getScaledInstance(Board.width/8,Board.height/8, Image.SCALE_SMOOTH)));
        }
    }
    
    public ArrayList<Coords> getValidMoves() {
        ArrayList<Coords> validSet = new ArrayList<Coords>();
        ArrayList<Coords> forward = new ArrayList<Coords>();
        int xcor = getPosition().getX();
        int ycor = getPosition().getY();
        if (firstMove) {
            boolean notBlocked = true;
            for (int x = 1; x <= 2 && notBlocked; x++) {
                Coords position = new Coords(xcor + x * getDirection(), ycor);
                Piece viewingPiece = Board.getPiece(position);
                // if the tile in front is empty move otherwise don't 
                if (viewingPiece.getColor() == 2 && inBetween(position)) {
                    forward.add(position);
                } else {
                    notBlocked = false;
                }
            }
        }
        else {
            Coords position = new Coords(xcor + getDirection(), ycor);
            Piece viewingPiece = Board.getPiece(position);
            // if the tile in front is empty move otherwise don't 
            if (viewingPiece.getColor() == 2 && inBetween(position)) {
                forward.add(position);
            }
        }
        validSet.addAll(forward);
        validSet.addAll(getKillMoves());
        return validSet;
    }
    
    public void notFirst() {
        firstMove = false;
    }
    
    public boolean getFirst() {
        return firstMove;
    }
    
    private int getDirection() {
        if (getColor() == 0) {
            return 1;
        } else {
            return -1;
        }
    }
    
    public ArrayList<Coords> getKillMoves(boolean colorMatters) {
        ArrayList<Coords> validSet = new ArrayList<Coords>();
        int xcor = getPosition().getX() + getDirection();
        int ycor = getPosition().getY();
        // if piece color is equal to opposite color --> add
        Coords tileLeft = new Coords(xcor, ycor-1);
        //Piece tileLeftPiece = Board.getPiece(tileLeft);
        if (inBetween(tileLeft) && ( colorMatters || Board.getPiece(tileLeft).getColor() != getColor() ) && Board.getPiece(tileLeft).getColor() != 2) {
            validSet.add(tileLeft);
        }
        
        Coords tileRight = new Coords(xcor, ycor+1);
        //Piece tileRightPiece = Board.getPiece(tileRight);
        if (inBetween(tileRight) && ( colorMatters || Board.getPiece(tileRight).getColor() != getColor() ) && Board.getPiece(tileRight).getColor() != 2) {
            validSet.add(tileRight);
        }
        return validSet;
    }
    
    public ArrayList<Coords> getKillMoves() {
        return getKillMoves(false);
    }
    
    public String toString() {
        String returnString = super.toString();
        return "Pawn" + returnString.substring(returnString.indexOf(";")) + ";" + getFirst();
    }
    

}