
/*
 * Course:  	CMIS 242
 * File: 		CircleCircumAreaFrame.java
 * Author: 		Andrew H. Rohn
 * Date: 		13 September 2018
 * Purpose: 	Constructs the frame of the program
 */

import javax.swing.JFrame;

public class CircleCircumAreaFrame extends JFrame {
        
	// Constructor for Frame
	CircleCircumAreaFrame() {
		super("Circumference & Area of a Circle");
		setSize(500, 400);
		setResizable(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}
    // Displays Contents of Frame
	public void display() {
		setVisible(true);
	}
}