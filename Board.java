import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.*;
import java.util.ArrayList;

public class Board extends JFrame implements MouseListener {
    
    /**
    
    */
    private Container pane;
    private Piece[][] tiles;
    private boolean selected;
    private Piece selectedPiece;
    private turn int;
    private ArrayList<Piece> whitePieces;
    private ArrayList<Piece> blackPieces;
    public static int height = 1024;
    public static int width = 1024;
    private static Border standard;
    private static Border current;
    private static Border available;
    
}