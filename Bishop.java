import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Bishop extends Piece{
    
    public Bishop(int x, int y, int c) {
        Bishop(new Coords(x, y), c);
    }
    
    public Bishop(Coords coor, int c) {
        super(coor, c);
        firstMove = true;
        if (c == 0) {
            this.setIcon(new ImageIcon("/Icons/blackBishop.png").getScaledInstance(Board.width/8,Board.height/8, Image.SCALE_SMOOTH));   
        } else {
            this.setIcon(new ImageIcon("/Icons/whiteBishop.png").getScaledInstance(Board.width/8,Board.height/8, Image.SCALE_SMOOTH));
        }
    }
    
    public ArrayList<ArrayList<Coords>> getValidMoves() {
        
    }
    
    public String toString() {
        return "";
    }
    
}