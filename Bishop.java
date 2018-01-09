import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Bishop extends Piece{
    
    public Bishop(int, int, int) {
        
    }
    
    public Bishop(Coords, int) {
        
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
        return validSet;
    }
    
    public String toString() {
        
    }
    
    private void setIcon() {
        
    }

}