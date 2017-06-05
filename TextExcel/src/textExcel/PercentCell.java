package textExcel;

public class PercentCell extends RealCell {
	
	@Override
	public String abbreviatedCellText() {
		// Base string with percent value
		String finalString = ((int)(getDoubleValue())) + "%";
		//String returnStr = value;
		if (fullCellText().length() > 10){
			return fullCellText().substring(0,10);
		// For situation where cell text is smaller than alloted space, returns the text with additional spaces to fill up space
		}else {
			while (finalString.length() < 10){
				finalString += " ";
			}
			return finalString;
		}
	}

	// Converts double value into decimal percent form
	public String fullCellText() {
		return (getDoubleValue()/100.0) + "";					
	}
	
	// Sets the input value through use of super class
	public PercentCell(String value){
		setValue(value);									
	}
	
	// Breaks down into parsed double 
	public double getDoubleValue(){
		String cutValue = getValue().substring(0, getValue().length() - 1);
		return(Double.parseDouble(cutValue)/100.0); 
	}

	// Returns cell type
	public String getType(){
		return "PercentCell";								
	}
}