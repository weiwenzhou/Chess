import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Rook extends Piece{
    private boolean firstMove;
    
    public Rook(int x, int y, int col) {
        super (x, y, col);
        firstMove = true;
    }
    
    public Rook(Coords coor, int col) {
        super (coor, col);
        firstMove = true;
    }
    
    public ArrayList<ArrayList<Coords>> getValidMoves() {
        ArrayList<ArrayList<Coords>> validSet = new ArrayList<ArrayList<Coords>>();
        int xcor = getPosition().getX();
        int ycor = getPosition().getY();
        //Linear
        validSet.add(getMoves(xcor,ycor, -1, 0));
        validSet.add(getMoves(xcor,ycor, 1, 0));
        validSet.add(getMoves(xcor,ycor, 0, -1));
        validSet.add(getMoves(xcor,ycor, 0, 1));
        return validSet;
    }
    
    public void notFirst() {
        firstMove = false;
    }
    
    public String toString() {
        return ""
    }

}