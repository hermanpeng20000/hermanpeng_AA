package textExcel;

public class TextCell implements Cell {
	// Null String that will later be modified
	String text;
	
	// Essentially prepares contents to be later implemented in the cell
	public TextCell(String input) {
		input = input.substring(1, input.length() - 1);
		text = input;
	}
	
	// Abbreviates the cell text to fit
	public String abbreviatedCellText() {
		String string = text;
		// For scenario where text is shorter than appropriate length of 10
		if (text.length() < 10){
			// Adds spaces to the text until length is full
			while (string.length() < 10){
				string += " ";
			}
			return string;
		} 
		// For scenario where text is longer than appropriate length of 10
		else if (text.length() > 10){
			// Creates a substring of the text that is returned
			string = string.substring(0, 10);
			return string;
		}
		// For scenario where text is already the appropriate length of 10
		else{
			return text;
		}
	}
	
	// For getting all the text
	public String fullCellText() {
		return "\"" + text + "\"";
	}
}