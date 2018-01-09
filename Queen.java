import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Queen extends Piece{
    
    public Queen(int x, int y, int col) {
        super (x, y, col);
    }
    
    public Queen(Coords coor, int col) {
        super (coor, col);
    }
    
    public ArrayList<ArrayList<Coords>> getValidMoves() {
        ArrayList<ArrayList<Coords>> validSet = new ArrayList<ArrayList<Coords>>();
        int xcor = getPosition().getX();
        int ycor = getPosition().getY();
        //Diagonal
        validSet.add(getMoves(xcor,ycor, -1, -1));
        validSet.add(getMoves(xcor,ycor, -1, 1));
        validSet.add(getMoves(xcor,ycor, 1, -1));
        validSet.add(getMoves(xcor,ycor, 1, 1));
        //Linear
        validSet.add(getMoves(xcor,ycor, -1, 0));
        validSet.add(getMoves(xcor,ycor, 1, 0));
        validSet.add(getMoves(xcor,ycor, 0, -1));
        validSet.add(getMoves(xcor,ycor, 0, 1));
        return validSet;
    }
    
    public String toString() {
        return "";
    }
    
    private void setIcon() {
        
    }

}