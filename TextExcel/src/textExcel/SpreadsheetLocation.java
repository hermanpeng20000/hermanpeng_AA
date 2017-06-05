package textExcel;

// Class SpreadsheetLocation implements Location
public class SpreadsheetLocation implements Location
{
	// Initializes the column and row ints necessary to gauge spreadsheet
	private int column;
	private int row;
	
	// Method to reorganize the spreadsheet
    public SpreadsheetLocation(String cellInput)
    {
    	// Calls upon split method written under this method
        String [] array = split(cellInput);
        char temporary = array[0].charAt(0);
        // Readjustments of column and row
        column = (int)temporary - (int)'A';
        row = Integer.parseInt(array[1])-1;
    }
    
    // Method to split cell into separate parts into an array
    public String[] split(String cellInput){
    	return cellInput.split("(?<=\\D)(?=\\d)|(?<=\\d)(?=\\D)");
    }
    
    @Override
    // Getter to return row
    public int getRow()
    {
        return row;
    }

    @Override
    // Getter to return column
    public int getCol()
    {
        return column;
    }
    

}