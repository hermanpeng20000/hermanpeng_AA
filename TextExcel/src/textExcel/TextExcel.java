// Herman Peng
// APCS Period 1
// Project: Text Excel
// 2017 Fall Semester

package textExcel;

// Sets up the scanner that is used to read commands from user
import java.util.Scanner;

// The "brain" of the program, where a sheet is created and user input processed
public class TextExcel
{

	public static void main(String[] args)
	{
		// Create a new sheet that will be modified
	    Spreadsheet sheet = new Spreadsheet();
	    // Takes in input from user
	    Scanner console = new Scanner(System.in);
	    // Stores the user input as a command to be processed
	    String command = console.nextLine();
	    // This loop is where the action is performed, continuing to work until "quit" is entered
	    while(!command.equals("quit")){
	    	sheet.processCommand(command);
	    	command = console.nextLine();
	    }
	}
}