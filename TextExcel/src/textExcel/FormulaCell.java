package textExcel;

public class FormulaCell extends RealCell {
	
	private Spreadsheet sheet;

	// Makes cell that takes in a mathematical formula, takes in text and sheet
	public FormulaCell(String text, Spreadsheet sheet) {
		// Sets the sheet equal to the one we want
		this.sheet = sheet;
		// Sets value to what we want - the text entered
		setValue(text);
	}
	
	// Makes cell where all text in cell fits in allotted space
	public String abbreviatedCellText() {	
		// Takes length of text
		String textValue = getDoubleValue() + "";
		// Checks if text is too long
		if (textValue.length() > 10) {
			// If text is too long, returns a substring with appropriate length
			return textValue.substring(0, 10);
		} 
		// In event of different scenario
		else {
			// Adds spaces until appropriate length
			for (int i = textValue.length(); i < 10; i++) {
				textValue += " ";
			}
		// Returns the modified value with appropriate length
		return textValue;
		}
	}

	// Makes cell where all text is displayed, whether or not it fits in space
	public String fullCellText() {	
		// Simply returns the value
		return getValue();
	}
	
	// Returns the double version, including if it is a percentage
	public double getDoubleValue() {
		// Gets the part of the value we want to observe and modify
		String value = this.getValue().substring(2, getValue().length() - 2);
			// Takes away the spaces form the value
			String[] formula = value.trim().split(" ");
			// For situation where command is to find sum
			if (formula[0].toUpperCase().equals("SUM")) {
				String[] series = formula[1].toUpperCase().split("-");
				return sum(series[0], series[0], series[1]);
			// For situation where command is to find average
			} 
			else if (formula[0].toUpperCase().equals("AVG")) {
				String[] series = formula[1].toUpperCase().split("-");
				return sum(series[0], series[0], series[1]) / countRange(series[0], series[0], series[1]);
			// For other situation where input is different
			} 
			else {
				for (int i = 0; i < formula.length; i++) {
					if (formula[i].toUpperCase().charAt(0) >= 'A' && formula[i].toUpperCase().charAt(0) <= 'L') {
						SpreadsheetLocation location = sheet.getLoc(formula[i].toUpperCase());
						Cell cell = sheet.getSheet()[location.getRow()][location.getCol()];
						if (cell instanceof RealCell) {
							formula[i] = ((RealCell) cell).getDoubleValue() + "";
						} 
						else {
							formula[i] = "";
						}
					}
				}
				// To process the arithmetic commands
				double useVariable = Double.parseDouble(formula[0]);
				for (int i = 1; i < formula.length; i++) {
					// For addition
					if (formula[i].equals("+")){
						useVariable += Double.parseDouble(formula[i + 1]);
					}
					// For subtraction
					else if (formula[i].equals("-")){
						useVariable -= Double.parseDouble(formula[i + 1]);
					}
					// For multiplication
					else if (formula[i].equals("*")){
						useVariable *= Double.parseDouble(formula[i + 1]);
					}
					// For division
					else if (formula[i].equals("/")){
						useVariable /= Double.parseDouble(formula[i + 1]);
					}
				}
				return useVariable;
			}
	}

	// Method for the "sum" command
	public double sum(String start, String firstLocation, String secondLocation) {
		// For scenario where both locations are equal to one another
		if (firstLocation.equals(secondLocation)) {
			SpreadsheetLocation location = sheet.getLoc(secondLocation);
			// Creates cell with locations taken from location variable
			Cell cell = sheet.getSheet()[location.getRow()][location.getCol()];
			// Checks to see if cell is an instance of Real Cell
			if (cell instanceof RealCell) {
				// If so, returns double version of Real Cell
				return ((RealCell) cell).getDoubleValue();
			// Otherwise, return the null for doubles: 0.0
			} 
			else {
				return 0.0;
			}
		// For scenario where the first parts of both locations are equal
		} 
		else if (firstLocation.substring(1).equals(secondLocation.substring(1))) {
			SpreadsheetLocation loc = sheet.getLoc(firstLocation);
			firstLocation = ((char) (firstLocation.charAt(0) + 1)) + start.substring(1);
			Cell cell = sheet.getSheet()[loc.getRow()][loc.getCol()];
			// Checks to see if cell is an instance of Real Cell
			if (cell instanceof RealCell) {
				// Use of recursion
				return ((RealCell) cell).getDoubleValue() + sum(start, firstLocation, secondLocation);
			} 
			else {
				// Use of recursion
				return sum(start, firstLocation, secondLocation);
			}
		// The else
		} else {
			SpreadsheetLocation location = sheet.getLoc(firstLocation);
			firstLocation = firstLocation.substring(0, 1) + (Integer.parseInt(firstLocation.substring(1)) + 1);
			Cell cell = sheet.getSheet()[location.getRow()][location.getCol()];
			if (cell instanceof RealCell) {
				return ((RealCell) cell).getDoubleValue() + sum(start, firstLocation, secondLocation);
			} 
			else {
				// Use of recursion
				return sum(start, firstLocation, secondLocation);
			}
		}

	}

	// Method to find range
	public double countRange(String start, String firstLocation, String secondLocation) {
		SpreadsheetLocation loc = sheet.getLoc(firstLocation);
		if (firstLocation.equals(secondLocation)) {
			return 1;
		} 
		else if (firstLocation.substring(1).equals(secondLocation.substring(1))) {
			firstLocation = (char) (firstLocation.charAt(0) + 1) + start.substring(1);
			if (sheet.getSheet()[loc.getRow()][loc.getCol()] instanceof RealCell) {
				// Use of recursion
				return 1 + countRange(start, firstLocation, secondLocation);
			} 
			else {
				// Use of recursion
				return countRange(start,firstLocation, secondLocation);
			}
		} else {
			firstLocation = firstLocation.substring(0, 1) + (Integer.parseInt(firstLocation.substring(1)) + 1);
			if (sheet.getSheet()[loc.getRow()][loc.getCol()] instanceof RealCell) {
				// Use of recursion
				return 1 + countRange(start, firstLocation, secondLocation);
			} 
			else {
				return countRange(start, firstLocation, secondLocation);
			}

		}
	}

}