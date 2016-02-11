package FileInteraction;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Reader {

	private String file;
	
	public Reader(String src){
		this.file = src;
	}

	public void readFile(){

        // This will reference one line at a time
        String line = null;

        try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader = 
                new FileReader(file);

            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader = 
                new BufferedReader(fileReader);

            while((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }   

            // Always close files.
            bufferedReader.close();         
        }
        catch(IOException ex) {
            System.out.println(
                "Unable to open file '" + 
                file + "'"); 
        }
	}
	
	public static void main(String[] args){
		Reader r = new Reader("/home/planaspa/Downloads/busy_day.in");
		r.readFile();
	}
	
}
