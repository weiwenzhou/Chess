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
        
    }
    
    public ArrayList<Coords> getMoves(int x, int y, int xdirection, int ydirection){
        ArrayList<Coords> validDirection = new ArrayList<Coords>();
        x += xdirection;
        y += ydirection;
        while (inBetween(x, 0, 8) && inBetween(y,0,8)) {
            validDirection.add(new Coords(x,y));
            x += xdirection;
            y += ydirection;
        //WW add the portion where this can cut invalid moves from validDirection
        }
        return validDirection;
    }
    
    public boolean inBetween(int num, int lower, int higher) {
        return num >= lower && num < higher;
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
