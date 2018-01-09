import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Pawn {
    private boolean firstMove;
    private ImageIcon[] icons;
    
    Pawn(int x, int y, int c) {
        super(x, y, c);
        firstMove = true;
    }
    
    Pawn (Coords coor, int c) {
        super(coor, c);
        firstMove = true;
    }
    
    public ArrayList<ArrayList<Coords>> getValidMoves() {
        
    }
    
    public void notFirst() {
        firstMove = false;
    }
    
    private int getDirection() {
        if (getColor() == 0) {
            return 1;
        } else {
            return -1;
        }
    }
    
    public ArrayList<Coords> getKillMoves() {
        
    }
    
    public String toString() {
        return "";
    }
    
    private void setIcon() {
        
    }

}