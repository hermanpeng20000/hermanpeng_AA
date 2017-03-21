package textExcel;

public class EmptyCell implements Cell {
	//emptycell returns empty strings for the cells
	public String abbreviatedCellText() {
		return "          ";
	}

	public String fullCellText() {
		return "";
	}
	public EmptyCell(){
		
	}
}