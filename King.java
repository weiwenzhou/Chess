import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class King {
    private boolean firstMove;
    
    public King(int x, int y, int c) {
        King(new Coords(x, y), c);
    }
    
    public King(Coords coor, int c) {
        super(coor, c);
        firstMove = true;
        if (c == 0) {
            this.setIcon(new ImageIcon("/Icons/blackKing.png").getScaledInstance(Board.width/8,Board.height/8, Image.SCALE_SMOOTH));   
        } else {
            this.setIcon(new ImageIcon("/Icons/whiteKing.png").getScaledInstance(Board.width/8,Board.height/8, Image.SCALE_SMOOTH));
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