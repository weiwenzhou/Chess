import java.util.*; //random, scanner, arraylist
import java.io.*; //file, filenotfoundexception

public class Load{
    //private String[] fileContents;
    
    public ArrayList<String> read (String fileName){
        ArrayList<String> fileContents = new ArrayList<String>();
        try{
            File f = new File (fileName);
            Scanner in = new Scanner (f);
            while(in.hasNext()){
                String line = in.nextLine();
                fileContents.add(line);
                System.out.println(line);
            }
        }catch(FileNotFoundException e){
            System.out.println("File not found: " + fileName);
            e.printStackTrace();
            System.exit(1);
        }
        return fileContents;
    }
}