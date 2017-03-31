package textExcel;
import java.util.*;

public class TextCell implements Cell {
	String contents;
	
	//sets original contents then the data to the cell
	public TextCell(String temp) {
		contents = temp;
		temp = temp.substring(1, temp.length() - 1);
		contents = temp;
	}
	public String abbreviatedCellText() {
		String str = contents;
		if (contents.length() < 10){
			while (str.length() < 10){
				str += " ";
			}
			return str;
		} else if (contents.length() > 10){
			str = str.substring(0, 10);
			return str;
		}else{
			return contents;
		}
	}
	public String fullCellText() {
		return "\"" + contents + "\"";
	}
}