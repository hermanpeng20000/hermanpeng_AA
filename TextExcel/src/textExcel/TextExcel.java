package textExcel;
import java.util.*;

import java.io.FileNotFoundException;
import java.util.Scanner;

// Update this file with your own code.

public class TextExcel
{

	public static void main(String[] args)
	{
	    Spreadsheet testSheet=new Spreadsheet();
	    Scanner input = new Scanner(System.in);
	    String command = input.nextLine();
	    while(!command.equals("quit")){
	    	testSheet.processCommand(command);
	    	command = input.nextLine();
	    }
	}
}