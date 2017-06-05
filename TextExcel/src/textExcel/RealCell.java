package textExcel;

// RealCell implements Cell, sets a skeleton for other cell types
abstract class RealCell implements Cell {

	private String value;
	
	// Allows inputed value to be saved in the private String

	// For text to fit in the alloted space
	public String abbreviatedCellText() {	//basic method to take the string and turn it into the ten char String
		// Sets a string to be modified in comparison to value
		String temporary = value;
		if (value.contains("%") && value.contains(".")) {
			temporary =	value.replace(value.substring(value.indexOf(".")), "%");
		}
		else if (!value.contains("%")) { 
			temporary = Double.parseDouble(value) + "";
		}
		if (temporary.length() > 10) {
			return temporary.substring(0, 10);
		}
		else {
			
			for (int i = temporary.length(); i < 10; i++) {
				temporary += " ";
			}
			return temporary;
		}
	}
	
	// Returns the full, unabbreviated cell value
	public String fullCellText() {
		String value = getDoubleValue() + "";
		if (getValue().equals("0")) {
			return getValue();
		}
		else if (!value.contains("%") && value.contains(".0") 
				&& isDecimalEqualToZero(value)
				&& value.replace("-", "").length() > 3) {
			return value.substring(0, value.indexOf("."));
		}
		else if (!value.contains("%") && !value.contains(".")) {
			value += ".0";
		}
	return value;
	}
	
	// Getter that gets the value
	public String getValue() {
		return this.value;
	}
	
	// Setter that sets the value
	public void setValue(String text) {
		this.value = text;
	}
	
	// MEthod to find if a decimal, that is inputed as a parameter, is equal to zero
	private boolean isDecimalEqualToZero(String doubleValue) {
		// If value is a percent, it must be false
		if (doubleValue.contains("%")) {
			return false;
		}
		String[] number = doubleValue.split("\\.");
		if(number.length > 1) {
			// Gets the value to right of decimal point
			int d = Integer.parseInt(number[1]);
			return d == 0;
		}
		else {
			return true;
		}
		
	}
	
	// Returns the double value
	public double getDoubleValue(){
		return Double.parseDouble(value);
	}

}