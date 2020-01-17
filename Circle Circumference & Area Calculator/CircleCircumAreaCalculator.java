
/*
 * Course:  	CMIS 242
 * File: 		CircleCircumAreaCalculator.java
 * Author: 		Andrew H. Rohn
 * Date: 		13 September 2018
 * Purpose: 	Finds the circumference and area of a circle
 */

public class CircleCircumAreaCalculator extends CircleCircumAreaFrame {
    
	public static void main (String[] args) {
		CircleCircumAreaCalculator calculator = new CircleCircumAreaCalculator();
		calculator.display();
	}
	
	// Main Constructor That Calls Subclasses
	public CircleCircumAreaCalculator() {
		super();  // calls frame subclass
		CircleCircumAreaPanel panel = new CircleCircumAreaPanel(); // calls object from panel subclass
		add(panel);
	}
}