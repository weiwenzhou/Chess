import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Pawn {
    private boolean firstMove;
    
    public Pawn(int x, int y, int c) {
        Pawn(new Coords(x, y), c);
    }
    
    public Pawn (Coords coor, int c) {
        super(coor, c);
        firstMove = true;
        if (c == 0) {
            this.setIcon(new ImageIcon("/Icons/blackPawn.png").getScaledInstance(Test.width/8,Test.height/8, Image.SCALE_SMOOTH));   
        } else {
            this.setIcon(new ImageIcon("/Icons/whitePawn.png").getScaledInstance(Test.width/8,Test.height/8, Image.SCALE_SMOOTH));
        }
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
    

}