import javax.swing.*;
import java.util.ArrayList;

public class Piece extends JLabel{
    private ImageIcon[] icons;
    private Coords position;
    private int color;
    
    public Piece(int x, int y, int col){
        position = new Coords(x,y);
        color = col;      
    }
    
    public Piece(Coords coor, int col){
        position = coor;
        color = col;
    }
    
    public ArrayList<ArrayList<Coords>> getValidMoves(){
        ArrayList<ArrayList<Coords>> validSet = new ArrayList<ArrayList<Coords>>();
        return validSet;
    }
    
    public ArrayList<Coords> getMoves(int x, int y, int xdirection, int ydirection){
        ArrayList<Coords> validDirection = new ArrayList<Coords>();
        x += xdirection;
        y += ydirection;
        boolean notBlocked = true;
        while (inBetween(x) && inBetween(y) && notBlocked) {
            Coords position = new Coords(x,y);
            int positionColor = Board.getPiece(position).getColor();
            if (positionColor != 2) {
                notBlocked = false;
                // in here  0 or 1 if opposite number add otherwise don't.
                if (positionColor != getColor()) {
                    validDirection.add(position);
                }
            } else {
                // if 2 continue
                validDirection.add(position);
            }
            x += xdirection;
            y += ydirection;
            
        }
        return validDirection;
    }
    
    public boolean inBetween(Coords pos) {
        return inBetween(pos.getX()) && inBetween(pos.getY());
    }
    
    public boolean inBetween(int num) {
        return num >= 0 && num < 8;
    }
    
    public Coords getPosition(){
        return position;
    }
    
    public void setPosition(Coords coor){
        position = coor;
    }
    
    public int getColor(){
        return color;
    }
    
    public String toString(){
        return "";
    }
}
