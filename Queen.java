import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Queen extends Piece{
    
    public Queen(int x, int y, int c) {
        Queen(new Coords(x, y), c);
    }
    
    public Queen(Coords coor, int c) {
        super(coor, c);
        firstMove = true;
        if (c == 0) {
            this.setIcon(new ImageIcon("/Icons/blackQueen.png").getScaledInstance(Board.width/8,Board.height/8, Image.SCALE_SMOOTH));   
        } else {
            this.setIcon(new ImageIcon("/Icons/whiteQueen.png").getScaledInstance(Board.width/8,Board.height/8, Image.SCALE_SMOOTH));
        }
    }
    
    public ArrayList<ArrayList<Coords>> getValidMoves() {
        
    }
    
    public String toString() {
        return "";
    }
    
    private void setIcon() {
        
    }

}