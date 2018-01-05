public class Coords{//
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
	return "";
    }

    public int toID(){
	return 0;
    }

    public boolean equals(Coords other){
	return true;
    }
}
