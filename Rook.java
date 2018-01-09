import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Rook extends Piece{
    private boolean firstMove;
    
    public Rook(int x, int y, int c) {
        Rook(new Coords(x, y), c);
    }
    
    public Rook(Coords coor, int c) {
        super(coor, c);
        firstMove = true;
        if (c == 0) {
            this.setIcon(new ImageIcon("/Icons/blackRook.png").getScaledInstance(Board.width/8,Board.height/8, Image.SCALE_SMOOTH));   
        } else {
            this.setIcon(new ImageIcon("/Icons/whiteRook.png").getScaledInstance(Board.width/8,Board.height/8, Image.SCALE_SMOOTH));
        }
    }
    
    public ArrayList<ArrayList<Coords>> getValidMoves() {
        
    }
    
    public void notFirst() {
        firstMove = false;
    }
    
    public String toString() {
        return "";
    }
    
}