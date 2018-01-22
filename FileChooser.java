//Credit to Amit Narang's group for advice on this portion

import javax.swing.JFileChooser.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;
import java.awt.Component;
import javax.swing.*;
import java.io.*;

public class FileChooser {

    //Opens JFileChooser GUI element, 
    public static String FileReturn(){
        
        JFileChooser jfc = new JFileChooser(new File("./SaveGames"));
        
        //Filters inputs to only *.txt files
        jfc.setDialogTitle("Select a text file");
        jfc.setAcceptAllFileFilterUsed(false);
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Text Files", "txt");	
        jfc.setFileFilter(filter);
    
        int returnValue = jfc.showOpenDialog(null);
        
        return jfc.getSelectedFile().getName();
    }
    
   public static String main() {
        try{
            return FileReturn();
        }
        catch (NullPointerException e) {
            return main();
        }
    }
}