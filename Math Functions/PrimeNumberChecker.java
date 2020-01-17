import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

/*
 * Course:  	CMSC 335
 * File: 		PrimeNumberChecker.java
 * Author: 		Andrew H. Rohn
 * Date: 		7 Feb 2019
 * Purpose: 	Determines if a number is prime or not and displays its factors.
 */

public class PrimeNumberChecker extends JFrame {

	// Components for Panels
	private JLabel inputLabel = new JLabel("Enter a number:", SwingConstants.CENTER);
	private JTextField inputTextField = new JTextField("", 10);
	private JButton checkButton = new JButton("Check");
	private JLabel isItPrimeLabel = new JLabel("Is it prime?", SwingConstants.CENTER);
	private JTextField isItPrimeTextField = new JTextField("", 10);
	private JTextArea factorsTextArea = new JTextArea();
    private JScrollPane outputScrollPane = new JScrollPane(factorsTextArea);
	
	// Constructor for GUI
	public PrimeNumberChecker() {
		
		// Creation of inputPanel
		JPanel inputPanel = new JPanel();
		inputPanel.setLayout(new GridLayout(1, 2, 5, 0));
		inputPanel.add(inputLabel);
		inputPanel.add(inputTextField);
		
		// Creation of buttonPanel
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new FlowLayout());
		buttonPanel.add(checkButton);
		
		// Creation of isItPrimePanel
		JPanel isItPrimePanel = new JPanel();
		isItPrimePanel.setLayout(new GridLayout(1, 2, 5, 0));
		isItPrimePanel.add(isItPrimeLabel);
		isItPrimePanel.add(isItPrimeTextField);
		isItPrimeTextField.setEditable(false);
        
        // Creation of upperPanel (inputPanel + buttonPanel + isItPrimePanel)
        JPanel upperPanel = new JPanel(new GridLayout(3,1,5,5));
        upperPanel.add(inputPanel);
        upperPanel.add(buttonPanel);
        upperPanel.add(isItPrimePanel);
        
        // Creation of mainPanel (upperPanel + outputScrollPane)
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        outputScrollPane.setBorder(BorderFactory.createTitledBorder("Factors"));
        factorsTextArea.setEditable(false);
        factorsTextArea.setLineWrap(true);
        factorsTextArea.setFont(new Font("Monospaced", 0, 12));
        mainPanel.add(upperPanel, BorderLayout.NORTH);
        mainPanel.add(outputScrollPane, BorderLayout.CENTER);
        add(mainPanel);
        
        // ActionLister for Check Button
        checkButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        
        		// Checks for Valid Integer Input
                boolean validInt;
                try {
                	Integer.parseInt(inputTextField.getText().trim());
                	validInt = true;
                } catch (NumberFormatException nfe) {
                	isItPrimeTextField.setText("N / A");
                	factorsTextArea.setText("Please enter a valid integer.");
                	validInt = false;
                }

                if (validInt = true) {

            		// Local Variables
                	int number = Integer.parseInt(inputTextField.getText().trim());
            		boolean primeNum = true;
            		ArrayList<Integer> factors = new ArrayList<Integer>();
            		
            		// Checks to See if Number is Prime
            		for (int i = 1; i <= number; i++) {
            			if(number % i == 0) {
            				if ((i != 1) && (i != number)) {
            					primeNum = false;
            				}
            				factors.add(i);
            			}
            		}
            		
            		// Outputs Results
            		if (primeNum == true) {
            			isItPrimeTextField.setText("Yes");
            			factorsTextArea.setText(number+" is only divisible by:\n"+factors);
            		} else {
            			isItPrimeTextField.setText("No");
            			factorsTextArea.setText(number+" is divisible by:\n"+factors);
            		}
                }
        	}
        }); 
	}
	
	// Main Method
	public static void main(String args[]) {
		
		PrimeNumberChecker pnc = new PrimeNumberChecker();
		
        // Parameters for GUI Frame
        pnc.setTitle("Prime Number Checker");
        pnc.setSize(500,300);
        pnc.setLocationRelativeTo(null);
        pnc.setResizable(false);
        pnc.setVisible(true);
        pnc.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}
}