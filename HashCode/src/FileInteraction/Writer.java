package FileInteraction;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

public class Writer {
	
	private ArrayList<String> commands;
	
	public Writer() {
		this.commands = new ArrayList<String>();
	}
	
	/**
	 * command: D/L (deliver/load...)
	 */
	public void addCommand(int idDrone, String command, int warehouseId, int idProd, int numItems) {
		String s = idDrone + " " + command + " " + warehouseId + " " + idProd + " " + numItems;
		commands.add(s);
	}
	
	
	public void generateOutpout() throws FileNotFoundException, UnsupportedEncodingException {
		PrintWriter writer = new PrintWriter("output.txt", "UTF-8");
		writer.print(commands.size());
		for (String s:commands) {
			writer.printf("\n" + s);
		}
		writer.close();
	}

}
