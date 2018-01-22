import java.util.*;
import java.io.*;
import java.nio.file.*;

public class SaveNLoad {
    
    public static void save(String file, String[] linesToAdd){
        Path filePath = Paths.get(file);
        try {
            Files.deleteIfExists(filePath);
        } catch (IOException e) {
        
        }
        try{
            BufferedWriter writer = new BufferedWriter(new FileWriter(file, true));
            for (int x = 0; x < linesToAdd.length; x++) {
                writer.append(linesToAdd[x]);
                writer.newLine();
            }
            
            writer.close();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
    
    public static Piece[] load(String fileName){
        Piece[] pieceCollection = new Piece[64];
        int index = 0;
        try{
            File f = new File ("./SaveGames/"+fileName);
            Scanner in = new Scanner (f);
            while(in.hasNext()){
                String line = in.nextLine();
                pieceCollection[index] = convertToPiece(line);
                index++;
            }
        }catch(FileNotFoundException e){
            System.out.println("File not found: " + fileName);
        }
        
        return pieceCollection;
    }
    
    private static Piece convertToPiece(String line) {
        String[] pieceFields = line.split(";");
        String pieceType = pieceFields[0];
        int pieceX = Integer.parseInt(pieceFields[1]);
        int pieceY = Integer.parseInt(pieceFields[2]);
        int pieceColor = Integer.parseInt(pieceFields[3]);
        Piece piece;
        if (pieceType.equals("Rook")) {
            piece = new Rook(pieceX, pieceY, pieceColor);
            Rook tempPiece = (Rook) piece;
            if (pieceFields[4].equals("false")) {
                tempPiece.notFirst();
            }
        } else if (pieceType.equals("Knight")) {
            piece = new Knight(pieceX, pieceY, pieceColor);
        } else if (pieceType.equals("Bishop")) {
            piece = new Bishop(pieceX, pieceY, pieceColor);
        } else if (pieceType.equals("Queen")) {
            piece = new Queen(pieceX, pieceY, pieceColor);
        } else if (pieceType.equals("King")) {
            piece = new King(pieceX, pieceY, pieceColor);
            King tempPiece = (King) piece;
            if (pieceFields[4].equals("false")) {
                tempPiece.notFirst();
            }
            if (pieceFields[5].equals("true")) {
                tempPiece.setStatus(true);
            }
        } else if (pieceType.equals("Pawn")) {
            piece = new Pawn(pieceX, pieceY, pieceColor);
            Pawn tempPiece = (Pawn) piece;
            if (pieceFields[4].equals("false")) {
                tempPiece.notFirst();
            }
        } else {
            piece = new Piece(pieceX, pieceY, pieceColor);
        }
        
        
        return piece;
    }
    
}