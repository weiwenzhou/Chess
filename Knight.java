import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Knight extends Piece{
    
    public Knight(int x, int y, int c) {
        this(new Coords(x, y), c);
    }
    
    public Knight(Coords coor, int c) {
        super(coor, c);
        if (c == 0) {
            this.setIcon(new ImageIcon(new ImageIcon("./Icons/blackKnight.png").getImage().getScaledInstance(Board.width/8,Board.height/8, Image.SCALE_SMOOTH)));
        } else {
            this.setIcon(new ImageIcon(new ImageIcon("./Icons/whiteKnight.png").getImage().getScaledInstance(Board.width/8,Board.height/8, Image.SCALE_SMOOTH)));
        }
    }
    
    public ArrayList<Coords> getValidMoves() {
        ArrayList<Coords> validSet = new ArrayList<Coords>();
        ArrayList<Coords> validSetMoves = new ArrayList<Coords>();
        int xcor = getPosition().getX();
        int ycor = getPosition().getY();
        
         if (inBetween(xcor-2) && inBetween(ycor-1)) {
                validSetMoves.add(new Coords(xcor - 2,ycor - 1));
        }
        if (inBetween(xcor-2) && inBetween(ycor+1)) {
                validSetMoves.add(new Coords(xcor - 2,ycor + 1));
        }
        if (inBetween(xcor-1) && inBetween(ycor-2)) {
                validSetMoves.add(new Coords(xcor - 1,ycor - 2));
        }
        if (inBetween(xcor-1) && inBetween(ycor+2)) {
                validSetMoves.add(new Coords(xcor - 1,ycor + 2));
        }
        if (inBetween(xcor+1) && inBetween(ycor-2)) {
                validSetMoves.add(new Coords(xcor + 1,ycor - 2));
        }
        if (inBetween(xcor+1) && inBetween(ycor+2)) {
                validSetMoves.add(new Coords(xcor + 1,ycor + 2));
        }
        if (inBetween(xcor+2) && inBetween(ycor-1)) {
                validSetMoves.add(new Coords(xcor + 2,ycor - 1));
        }
        if (inBetween(xcor+2) && inBetween(ycor+1)) {
                validSetMoves.add(new Coords(xcor + 2,ycor + 1));
        }
        
        // verification of positions
        for (int x = 0; x < 8; x++) {
            Coords currentPosition = validSetMoves.get(0);
            validSetMoves.remove(0);
            if (Board.getPiece(currentPosition).getColor() != getColor()) {
                validSetMoves.add(currentPosition);
            }
        }
        validSet.addAll(validSetMoves);
        return validSet;
    }
    
    public String toString() {
        return "";
    }

}