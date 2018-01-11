import javax.swing.*;
import java.awt.*;
import java.util.*; //random, scanner, arraylist
import java.io.*; //file, filenotfoundexception, FileWriter, PrintWriter, IOException


public class Save{
    private String file;
    private String wordsToAdd;
    

    public void createFile(String file){  //thanks http://www.baeldung.com/java-write-to-file
        try{
            String str = "";
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            writer.write(str);
            
            writer.close();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
    
    public void writeToFile(String file, String wordsToAdd){
        try{
            BufferedWriter writer = new BufferedWriter(new FileWriter(file, true));
            writer.append(wordsToAdd);
            writer.newLine();
            
            writer.close();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
    
    
}