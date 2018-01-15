import java.util.*;
import java.io.*;
import java.nio.file.*;

public class SaveNLoad {
    
    public static void save(String file, String[] linesToAdd){
        Path filePath = FileSystems.getDefault().getPath(".", file);
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
    
}