package textExcel;

public class EmptyCell implements Cell {
	// Creation of cell with no entered content
	String contents = "";
	// nullStr is 10 blank spaces, as instructed
	private String blankString = "          ";
	
	// Sets the initial creation of EmptyCell to have no content
	public EmptyCell() {
		contents = "";
	}
	
	// When seeking the "shortened version", the 10 required spaces will be occupied by blank spaces
	public String abbreviatedCellText(){
		return blankString;
	}
	
	// When requesting to see the full string, a blank is shown, as contents are empty
	public String fullCellText(){
		return "";
	}
}