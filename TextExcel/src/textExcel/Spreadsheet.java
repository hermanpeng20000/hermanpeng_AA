package textExcel;

// Update this file with your own code.

public class Spreadsheet implements Grid
{
	private int rows = 20;
	private int columns = 12;
	private char[] alphabet = new char[] { 'A', 'B', 'C', 'D', 'E', 'F', 'G' };
	private Cell[][] sheet = new Cell[rows][columns];
	private String name = "";
	private String nullStr="          ";

	public Spreadsheet() {
		for(int i=0;i<rows;i++){
			for(int j=0;j<columns;j++){
				sheet[i][j]=new EmptyCell();
			}
		}
	}
	

	@Override
	public String processCommand(String command)
	{
		String[] commandArray = command.split(" ");
		if (commandArray[0].equalsIgnoreCase("clear")){
			if(commandArray.length == 1){
				clearEntireCell();
				return getGridText();
			} else{
				clearOneCell(commandArray[1].toUpperCase());
				return getGridText();
			}
		}
		if(commandArray.length==1){
			String upCommand=commandArray[0].toUpperCase();
			String[] array=splitCommand(upCommand);
			char temp=array[0].charAt(0);
			columns=(int)temp-(int)'A';
			rows=Integer.parseInt(array[1])-1;
			return getSheet()[rows][columns].fullCellText();
			
		}else{
			commandArray[0] = commandArray[0].toUpperCase();
			if(command.length()==0){
				return "";
			} else if(commandArray.length >= 3){
				String userInput = commandArray[2];
				int counter = 3;
				while(counter < commandArray.length){
					userInput += " " + commandArray[counter];
					counter++;
				}
				String cell = commandArray[0];
				cellAssignment(userInput, cell);
				return getGridText();
			}else if(command.length() < 3){
				return cellInspection(commandArray[0]);
			}
		}
		return "";
	}

	public String[] splitCommand(String command){
    	
    	return command.split("(?<=\\D)(?=\\d)|(?<=\\d)(?=\\D)");
    }

	

	@Override
	public int getRows()
	{
		
		return rows;
	}

	@Override
	public int getCols()
	{
		// TODO Auto-generated method stub
		return columns;
	}
	
	public void cellAssignment(String input, String cell){
		SpreadsheetLocation b = new SpreadsheetLocation(cell);
		if(input.contains("\"")){
			sheet[b.getRow()][b.getCol()] = new TextCell(input);
		}else if(input.contains("%")){
			sheet[b.getRow()][b.getCol()] = new PercentCell(input);
		}else if(input.contains("(") && input.contains(")")){
			sheet[b.getRow()][b.getCol()] = new FormulaCell(input);
		}else{
			sheet[b.getRow()][b.getCol()] = new ValueCell(input);
		}
	}
	

	@Override
	public Cell getCell(Location loc){
		return sheet[loc.getRow()][loc.getCol()];
	}
	
	public String cellInspection(String cell){
		SpreadsheetLocation a = new SpreadsheetLocation(cell);
		String result = sheet[a.getRow()][a.getCol()].fullCellText();
		return result;
	}
	
	public void clearOneCell(String cell){
		SpreadsheetLocation userInput = new SpreadsheetLocation(cell);
		sheet[userInput.getRow()][userInput.getCol()] = new EmptyCell();
	}
	
	public void clearEntireCell(){
		for(int i = 0; i < rows; i++){
			for(int j = 0; j < columns; j++){
				sheet[i][j] = new EmptyCell();
			}
		}
	}
	
	public Cell[][] getSheet(){
		return sheet;
	}

	@Override
	public String getGridText()
	{
		String grid = "   |";
		String cellStr=null;
		
		//fills in the top row with the letters
		for(int i = 0; i < columns; i++){
			//cast to character type for letters, add the 10 spaces between this and the next one
			grid += (char) ('A' + i) + "         |";
		}
		
		//fills in the grid
		for(int i = 1; i <= rows; i++){
			//makes new line at end of row and adds the number
			grid += "\n" + i;
			//fixes the spacing when the numbers hit double digits
			if(i >= 10){
				grid += " |";
			}else{
				grid += "  |";
			}
			
			//sets all the values of each part of the array
			for(int k = 0; k < columns; k++){
				//includes the dashed lines at the end, only lets first 10 characters show
				//Puts the cell with its values in the grid
				//i-1 because i started at 1 for numbering but arrays are zero based
				if(sheet[i-1][k].abbreviatedCellText()==""){
					cellStr=nullStr;
				}else{
					cellStr=sheet[i-1][k].abbreviatedCellText();
				}
				grid += cellStr + "|";
			}
		}
		grid += "\n";// adds a new line after finishing creating the grid
		return grid;

		
	}

}