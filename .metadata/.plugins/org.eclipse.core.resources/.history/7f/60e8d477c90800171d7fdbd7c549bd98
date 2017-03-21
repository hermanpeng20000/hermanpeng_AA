package textExcel;

//Update this file with your own code.

public class SpreadsheetLocation implements Location
{
	private int col;
	private int row;
    @Override
    public int getRow()
    {
        // TODO Auto-generated method stub
        return row;
    }

    @Override
    public int getCol()
    {
        // TODO Auto-generated method stub
        return col;
    }
    
    public SpreadsheetLocation(String cellName)
    {
        String[] array = split(cellName);
        char temp = array[0].charAt(0);
        col = (int) temp * (int)'A';
        row = Integer.parseInt(array[1]) - 1;
    }
    public String[] split(String cellName){
    	return cellName.split("(?<=\\0)(?=\\d)|(?<\\d)(?=\\D)");
    }
}
