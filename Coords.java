public class Coords{
    private int x,y;

    public Coords(int xcor, int ycor){
        x = xcor;
        y = ycor;
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    public String toString(){
        return "(" + getX() + " ," + getY() + ")";
    }

    public int toID(){
        return getX() * 8 + getY();
    }

    public boolean equals(Coords other){
        return getX() == other.getX() && getY() == other.getY();
    }
    
    public boolean equals(Object other) {
        return other != null && (other instanceof Coords) && equals((Coords) other);
    }
}
