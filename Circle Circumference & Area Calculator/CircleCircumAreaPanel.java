
/*
 * Course:  	CMIS 242
 * File: 		CircleCircumAreaPanel.java
 * Author: 		Andrew H. Rohn
 * Date: 		13 September 2018
 * Purpose: 	Constructs the panel for the program & defines action listener function
 */

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

public class CircleCircumAreaPanel extends JPanel implements ActionListener {
    
	// Initialize Input / Output Text Fields
	private JTextField inputField = new JTextField("");
	private JTextField outputFieldOne = new JTextField("");
	private JTextField outputFieldTwo = new JTextField("");

	// Initialize Button
	private JButton button = new JButton("Calculate");

    // Constructor for Panel
	public CircleCircumAreaPanel() {
	                
		// Panel Creation
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(5,2,0,5));  // layout of components in panel
	    
		// Border Layout
		setLayout(new BorderLayout());
		setBackground(Color.lightGray);

	    // Components of Panel, including labels and text fields
		panel.add(new JLabel("", JLabel.CENTER));
		panel.add(new JLabel("Input / Output", JLabel.CENTER));
		panel.add(new JLabel("Enter the radius:", JLabel.CENTER));
		panel.add(inputField);
		panel.add(new JLabel("Circumference of the Circle:", JLabel.CENTER));
		panel.add(outputFieldOne);
		panel.add(new JLabel("Area of the Circle:", JLabel.CENTER));
		panel.add(outputFieldTwo);
		add(panel, BorderLayout.CENTER);
			
		// Making output text fields non-editable
		outputFieldOne.setBackground(Color.lightGray);
		outputFieldOne.setEditable(false);
		outputFieldTwo.setBackground(Color.lightGray);
		outputFieldTwo.setEditable(false);
	
		// Separate Panel for Button
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		buttonPanel.add(button);
		add(buttonPanel, BorderLayout.SOUTH);
	
		// Action Listener for Button
		button.addActionListener(this);
	}
	
	// Function of Action Listener
	public void actionPerformed(ActionEvent event) {
		
		DecimalFormat numFormat = new DecimalFormat("#.##");  // Limits decimal places in output
		
		// Variable Definitions for Mathematical Formulas
		final double PI = 3.14159265;
        double radius = (Double.parseDouble(inputField.getText()));
  
        // Mathematical Formulas   
        double circCircum = 2 * PI * radius;  // for circumference of circle
        double circArea = PI * radius * radius;  // for area of circle

        // Output
        outputFieldOne.setText(String.valueOf(numFormat.format(circCircum))+" units");
        outputFieldTwo.setText(String.valueOf(numFormat.format(circArea))+" units squared");
	}
}