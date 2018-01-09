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
        return validSet;
    }
    
    public void notFirst() {
        firstMove = false;
    }
    
    public String toString() {
        return "";
    }
    
}