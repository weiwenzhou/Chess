import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Knight extends Piece{
    
    public Knight(int x, int y, int c) {
        this(new Coords(x, y), c);
    }
    
    public Knight(Coords coor, int c) {
        super(coor, c);
        if (c == 0) {
            this.setIcon(new ImageIcon(new ImageIcon("./Icons/blackKnight.png").getImage().getScaledInstance(Board.width/8,Board.height/8, Image.SCALE_SMOOTH)));
        } else {
            this.setIcon(new ImageIcon(new ImageIcon("./Icons/whiteKnight.png").getImage().getScaledInstance(Board.width/8,Board.height/8, Image.SCALE_SMOOTH)));
        }
    }
    
    public ArrayList<ArrayList<Coords>> getValidMoves() {
        ArrayList<ArrayList<Coords>> validSet = new ArrayList<ArrayList<Coords>>();
        return validSet;
    }
    
    public String toString() {
        return "";
    }

}