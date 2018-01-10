import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class King extends Piece{
    private boolean firstMove;
    
    public King(int x, int y, int c) {
        this(new Coords(x, y), c);
    }
    
    public King(Coords coor, int c) {
        super(coor, c);
        firstMove = true;
        if (c == 0) {
            this.setIcon(new ImageIcon(new ImageIcon("./Icons/blackKing.png").getImage().getScaledInstance(Board.width/8,Board.height/8, Image.SCALE_SMOOTH)));
        } else {
            this.setIcon(new ImageIcon(new ImageIcon("./Icons/whiteKing.png").getImage().getScaledInstance(Board.width/8,Board.height/8, Image.SCALE_SMOOTH)));
        }
    }
    
    public ArrayList<ArrayList<Coords>> getValidMoves() {
        ArrayList<ArrayList<Coords>> validSet = new ArrayList<ArrayList<Coords>>();
        ArrayList<Coords> validSetMoves = new ArrayList<Coords>();
        int xcor = getPosition().getX();
        int ycor = getPosition().getY();
        
        if (inBetween(xcor-1) && inBetween(ycor-1)) {
                validSetMoves.add(new Coords(xcor - 1,ycor - 1));
        }
        if (inBetween(xcor-1) && inBetween(ycor)) {
                validSetMoves.add(new Coords(xcor - 1,ycor));
        }
        if (inBetween(xcor-1) && inBetween(ycor+1)) {
                validSetMoves.add(new Coords(xcor - 1,ycor + 1));
        }
        if (inBetween(xcor) && inBetween(ycor-1)) {
                validSetMoves.add(new Coords(xcor,ycor - 1));
        }
        if (inBetween(xcor) && inBetween(ycor+1)) {
                validSetMoves.add(new Coords(xcor,ycor + 1));
        }
        if (inBetween(xcor+1) && inBetween(ycor-1)) {
                validSetMoves.add(new Coords(xcor + 1,ycor - 1));
        }
        if (inBetween(xcor+1) && inBetween(ycor)) {
                validSetMoves.add(new Coords(xcor + 1,ycor));
        }
        if (inBetween(xcor+1) && inBetween(ycor+1)) {
                validSetMoves.add(new Coords(xcor + 1,ycor + 1));
        }
        
        // verification of positions
        for (int x = 0; x < 8; x++) {
            Coords currentPosition = validSetMoves.get(0);
            validSetMoves.remove(0);
            if (Board.getPiece(currentPosition).getColor() != getColor()) {
                validSetMoves.add(currentPosition);
            }
        }
        validSet.add(validSetMoves);
        return validSet;
    }
    
    public void notFirst() {
        firstMove = false;
    }
    
    public String toString() {
        return "";
    }

}