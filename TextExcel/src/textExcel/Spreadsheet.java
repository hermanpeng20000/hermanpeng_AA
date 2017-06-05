package textExcel;

// The Spreadsheet implements the Grid class
public class Spreadsheet implements Grid
{
	// Initialization of the rows and columns ints that form the sheet
	private int rows = 20;
	private int columns = 12;
	// Creation of the multi-dimensional array of Cells that are the length and height of the rows and columns ints
	private Cell[][] sheet = new Cell[rows][columns];
	private String nullString = "          ";

	// Makes every cell in the sheet an Empty Cell
	public Spreadsheet() {
		// Use of two for-loops to make sure every cell is converted into Empty Cell
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				sheet[i][j] = new EmptyCell();
			}
		}
	}
	

	// Receives the commands and processes it
	public String processCommand(String command){
		// Receives the long phrase of commands, and splits it into individual orders by removing spaces
		String[] commandArray = command.split(" ");
		// For situation where the command is to clear the cell
		if (commandArray[0].equalsIgnoreCase("clear")){
			// For situation where command is to clear entire sheet
			if (commandArray.length == 1){
				clearEntireCell();
				return getGridText();
			} 
			// For situation where command is to clear an individual cell
			else{
				clearOneCell(commandArray[1].toUpperCase());
				return getGridText();
			}
		}
		// For other situations where there is only one command inputed
		if (commandArray.length == 1){
			// Reads current command
			String currentCommand = commandArray[0].toUpperCase();
			// Calls Split Command from within Spreadsheet class
			String[] array = splitCommand(currentCommand);
			char temporary = array[0].charAt(0);
			// Forms new inputs for column and rows
			columns = (int)temporary-(int)'A';
			rows = Integer.parseInt(array[1])-1;
			// Returns updated sheet
			return getSheet()[rows][columns].fullCellText();
		}
		else{
			// Makes sure command is in upper case, to make sure all code can read it
			commandArray[0] = commandArray[0].toUpperCase();
			// For scenario where nothing has been inputed
			if (command.length() == 0){
				return "";
			} 
			else if(commandArray.length >= 3){
				String cell = commandArray[0];
				String stringLong = commandArray[2];
				for (int i = 3; i < commandArray.length; i++) {
					stringLong += " " + commandArray[i];
				}
				cellAssignment(stringLong, cell);
				return getGridText();
			}
			else if(command.length() < 3){
				return cellInspection(commandArray[0]);
			}
		}
		return "";
	}

	public String[] splitCommand(String command){
    	
    	return command.split("(?<=\\D)(?=\\d)|(?<=\\d)(?=\\D)");
    }

	

	@Override
	// Getter to return rows
	public int getRows()
	{
		return rows;
	}

	@Override
	// Getter to return columns
	public int getCols()
	{
		return columns;
	}
	
	// Used to assign cell to appropriate type according to inputed command
	public void cellAssignment(String input, String cell){
		SpreadsheetLocation location = new SpreadsheetLocation(cell);
		// If input contains "\" we know that the cell should be a Text Cell
		if(input.contains("\"")){
			sheet[location.getRow()][location.getCol()] = new TextCell(input);
		}
		// If input contains "(" we know that the cell should be a Formula Cell
		else if(input.contains("(") && input.contains(")")){
			sheet[location.getRow()][location.getCol()] = new FormulaCell(input, this);
		}
		// If input contains "%" we know that the cell should be a Percent Cell
		else if(input.contains("%")){
			sheet[location.getRow()][location.getCol()] = new PercentCell(input);
		}
		// If input does not contain "\" or "%" or "(" then we can conclude it is a Value Cell
		else{
			sheet[location.getRow()][location.getCol()] = new ValueCell(input);
		}
	}
	

	@Override
	// Returns the individual cell from the full sheet
	public Cell getCell(Location loc){
		return sheet[loc.getRow()][loc.getCol()];
	}
	
	// Returns the location from a spreadsheet
	public SpreadsheetLocation getLoc(String command) {
		SpreadsheetLocation location = new SpreadsheetLocation(command);
		return location;
	}
	
	// Checks if the location of a cell is correct, thus inspecting it
	public String cellInspection(String cell){
		SpreadsheetLocation cellInspector = new SpreadsheetLocation(cell);
		String result = sheet[cellInspector.getRow()][cellInspector.getCol()].fullCellText();
		return result;
	}
	
	// Command to clear one individual cell, converts it into an Empty Cell
	public void clearOneCell(String cell){
		SpreadsheetLocation toBeCleared = new SpreadsheetLocation(cell);
		sheet[toBeCleared.getRow()][toBeCleared.getCol()] = new EmptyCell();
	}
	
	// Command to clear entire grid, utilizes two for loops to convert 
	public void clearEntireCell(){
		for(int i = 0; i < rows; i++){
			for(int j = 0; j < columns; j++){
				sheet[i][j] = new EmptyCell();
			}
		}
	}
	
	// Getter to return grid
	public Cell[][] getSheet(){
		return sheet;
	}

	@Override
	// Getter to return grid text
	public String getGridText()
	{
		String grid = "   |";
		String cellString = null;
		
		// Fills top row with appropriate letters
		for(int i = 0; i < columns; i++){
			// Casts letters as chars, and adds ten spaces following it 
			grid += (char) ('A' + i) + "         |";
		}
		
		// Fills the grid
		for(int i = 1; i <= rows; i++){
			//makes new line at end of row and adds the number
			grid += "\n" + i;
			// Adjusts spacing, accounting for double digit numbers
			if(i >= 10){
				grid += " |";
			}
			else{
				grid += "  |";
			}
			
			// Sets all the values
			for(int k = 0; k < columns; k++){
				if(sheet[i-1][k].abbreviatedCellText() == ""){
					cellString = nullString;
				}
				else{
					cellString = sheet[i-1][k].abbreviatedCellText();
				}
				grid += cellString + "|";
			}
		}
		// Adds new line for clarity, then returns it
		grid += "\n";
		return grid;

		
	}

}