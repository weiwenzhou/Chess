import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Queen extends Piece{
    
    public Queen(int x, int y, int c) {
        this(new Coords(x, y), c);
    }
    
    public Queen(Coords coor, int c) {
        super(coor, c);
        if (c == 0) {
            this.setIcon(new ImageIcon(new ImageIcon("./Icons/blackQueen.png").getImage().getScaledInstance(Board.width/8,Board.height/8, Image.SCALE_SMOOTH)));
        } else {
            this.setIcon(new ImageIcon(new ImageIcon("./Icons/whiteQueen.png").getImage().getScaledInstance(Board.width/8,Board.height/8, Image.SCALE_SMOOTH)));
        }
    }
    
    public ArrayList<ArrayList<Coords>> getValidMoves() {
        ArrayList<ArrayList<Coords>> validSet = new ArrayList<ArrayList<Coords>>();
        int xcor = getPosition().getX();
        int ycor = getPosition().getY();
        //Diagonal
        validSet.add(getMoves(xcor,ycor, -1, -1));
        validSet.add(getMoves(xcor,ycor, -1, 1));
        validSet.add(getMoves(xcor,ycor, 1, -1));
        validSet.add(getMoves(xcor,ycor, 1, 1));
        //Linear
        validSet.add(getMoves(xcor,ycor, -1, 0));
        validSet.add(getMoves(xcor,ycor, 1, 0));
        validSet.add(getMoves(xcor,ycor, 0, -1));
        validSet.add(getMoves(xcor,ycor, 0, 1));
        return validSet;
    }
    
    public String toString() {
        return "";
    }

}