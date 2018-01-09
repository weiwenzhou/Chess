import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Knight extends Piece{
    
    public Knight(int x, int y, int c) {
        Knight(new Coords(x, y), c);
    }
    
    public Knight(Coords coor, int c) {
        super(coor, c);
        firstMove = true;
        if (c == 0) {
            this.setIcon(new ImageIcon("/Icons/blackKnight.png").getScaledInstance(Board.width/8,Board.height/8, Image.SCALE_SMOOTH));   
        } else {
            this.setIcon(new ImageIcon("/Icons/whiteKnight.png").getScaledInstance(Board.width/8,Board.height/8, Image.SCALE_SMOOTH));
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