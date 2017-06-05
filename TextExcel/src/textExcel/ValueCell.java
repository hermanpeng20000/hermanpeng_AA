package textExcel;

// Class ValueCell extends RealCell
public class ValueCell extends RealCell {
	// Constructor for Value Cell
	public ValueCell(String input) {
		// Sets the input of ValueCell
		setValue(input);
	}
	
	// Method to return double value
	public double getDoubleValue() {
		return Double.parseDouble(this.getValue());
	}

}