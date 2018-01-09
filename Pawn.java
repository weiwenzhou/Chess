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
            this.setIcon(new ImageIcon(new ImageIcon("/Icons/blackPawn.png").getImage().getScaledInstance(Board.width/8,Board.height/8, Image.SCALE_SMOOTH)));
        } else {
            this.setIcon(new ImageIcon(new ImageIcon("/Icons/whitePawn.png").getImage().getScaledInstance(Board.width/8,Board.height/8, Image.SCALE_SMOOTH)));
        }
    }
    
    public ArrayList<ArrayList<Coords>> getValidMoves() {
        ArrayList<ArrayList<Coords>> validSet = new ArrayList<ArrayList<Coords>>();
        return validSet;
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
        ArrayList<Coords> validSet = new ArrayList<Coords>();
        return validSet;
    }
    
    public String toString() {
        return "";
    }
    

}