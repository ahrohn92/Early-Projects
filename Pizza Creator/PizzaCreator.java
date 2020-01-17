/*
 * File: 		PizzaCreator.java
 * Author: 		Andrew H. Rohn
 * Date: 		17 September 2018
 * Purpose:		Implements different elements of Java Swing to simulate a pizza order.
 */

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.text.DecimalFormat;
import javax.swing.*;

public class PizzaCreator extends JFrame {
	
	// RadioButtons for Pizza Size
	private JRadioButton small = new JRadioButton("Small");
	private JRadioButton medium = new JRadioButton("Medium");
	private JRadioButton large = new JRadioButton("Large");
	private JRadioButton xlarge = new JRadioButton("X-Large");
	
	// RadioButtons for Crust Type
	private JRadioButton thin = new JRadioButton("Thin Crust");
	private JRadioButton regular = new JRadioButton("Regular Crust");
	private JRadioButton thick = new JRadioButton("Thick Crust");
	
	// RadioButtons for Sauce Type
	private JRadioButton red = new JRadioButton("Red Sauce");
	private JRadioButton white = new JRadioButton("White Sauce");
	
	// CheckBoxes for Toppings
	private JCheckBox pepperoni = new JCheckBox("Pepperoni");
	private JCheckBox sausage = new JCheckBox("Sausage");
	private JCheckBox bellpeppers = new JCheckBox("Bell Peppers");
	private JCheckBox tomatoes = new JCheckBox("Tomatoes");
	private JCheckBox anchovies = new JCheckBox("Anchovies");
	private JCheckBox olives = new JCheckBox("Olives");
	private JCheckBox roastedchicken = new JCheckBox("Roasted Chicken");
	private JCheckBox garlic = new JCheckBox("Garlic");
	private JCheckBox mushrooms = new JCheckBox("Mushrooms");
	private JCheckBox basil = new JCheckBox("Basil");
	private JCheckBox jalapenopeppers = new JCheckBox("Jalapeno Peppers");
	private JCheckBox bacon = new JCheckBox("Bacon");
	private JCheckBox ham = new JCheckBox("Ham");
	private JCheckBox pineapple = new JCheckBox("Pineapple");
	private JCheckBox extracheese = new JCheckBox("Extra Cheese");
	
	// TextFields for Customer Information
	private JTextField name = new JTextField("");
	private JTextField address1 = new JTextField("");
	private JTextField address2 = new JTextField("");
	private JTextField phonenumber = new JTextField("");
	
	// Button That Completes Order
	private JButton order = new JButton("Complete Order");
	
	// Constant Variable for Delivery Fee
	private static double DELIVERY_FEE = 2.50;
	
	// Default Constructor
	public PizzaCreator() {
		
		// Frame Dimensions
		setTitle("Andrew's Amazing Pizza Inc.  PIZZA CREATOR");
		setSize(900, 600);
		setBackground(Color.blue);
		setLayout(new BorderLayout());
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Pizza Size RadioButtonGroup
		ButtonGroup pizzaSize = new ButtonGroup();
		pizzaSize.add(small);
		pizzaSize.add(medium);
		pizzaSize.add(large);
		pizzaSize.add(xlarge);
		large.setSelected(true);
		
		// Pizza Size RadioButton Panel
		JPanel pizzaSizePanel = new JPanel();
		pizzaSizePanel.setLayout(new FlowLayout());
		pizzaSizePanel.add(small);
		pizzaSizePanel.add(medium);
		pizzaSizePanel.add(large);
		pizzaSizePanel.add(xlarge);
		
		// Pizza Crust RadioButtonGroup
		ButtonGroup crustType = new ButtonGroup();
		crustType.add(thin);
		crustType.add(regular);
		crustType.add(thick);
		regular.setSelected(true);
				
		// Pizza Crust RadioButton Panel
		JPanel crustTypePanel = new JPanel();
		crustTypePanel.setLayout(new FlowLayout());
		crustTypePanel.add(thin);
		crustTypePanel.add(regular);
		crustTypePanel.add(thick);
		
		// Sauce Type RadioButtonGroup
		ButtonGroup sauceType = new ButtonGroup();
		sauceType.add(red);
		sauceType.add(white);
		red.setSelected(true);
		
		// Sauce Type RadioButton Panel
		JPanel sauceTypePanel = new JPanel();
		sauceTypePanel.setLayout(new FlowLayout());
		sauceTypePanel.add(red);
		sauceTypePanel.add(white);
		
		// RadioButton Panel (Pizza Size + Crust Type + Sauce Type Panels)
		JPanel radioButtonPanel = new JPanel();
		radioButtonPanel.setLayout(new GridLayout(3,3,0,0));
		radioButtonPanel.add(new JLabel("SELECT THE SIZE OF THE PIZZA:", JLabel.RIGHT));
		radioButtonPanel.add(pizzaSizePanel);
		radioButtonPanel.add(new JLabel(""));
		radioButtonPanel.add(new JLabel("SELECT THE TYPE OF CRUST:", JLabel.RIGHT));
		radioButtonPanel.add(crustTypePanel);
		radioButtonPanel.add(new JLabel(""));
		radioButtonPanel.add(new JLabel("SELECT THE TYPE OF SAUCE:", JLabel.RIGHT));
		radioButtonPanel.add(sauceTypePanel);
		radioButtonPanel.add(new JLabel(""));
		
		// Toppings CheckBox Panel
		JPanel toppingsPanel = new JPanel();
		toppingsPanel.setLayout(new GridLayout(6,5,5,0));
		toppingsPanel.add(new JLabel(""));
		toppingsPanel.add(new JLabel(""));
		toppingsPanel.add(new JLabel("SELECT YOUR TOPPINGS:", JLabel.LEFT));
		toppingsPanel.add(new JLabel(""));
		toppingsPanel.add(new JLabel(""));
		toppingsPanel.add(new JLabel(""));
		toppingsPanel.add(pepperoni);
		toppingsPanel.add(sausage);
		toppingsPanel.add(bellpeppers);
		toppingsPanel.add(new JLabel(""));
		toppingsPanel.add(new JLabel(""));
		toppingsPanel.add(tomatoes);
		toppingsPanel.add(anchovies);
		toppingsPanel.add(olives);
		toppingsPanel.add(new JLabel(""));
		toppingsPanel.add(new JLabel(""));
		toppingsPanel.add(roastedchicken);
		toppingsPanel.add(garlic);
		toppingsPanel.add(mushrooms);
		toppingsPanel.add(new JLabel(""));
		toppingsPanel.add(new JLabel(""));
		toppingsPanel.add(basil);
		toppingsPanel.add(jalapenopeppers);
		toppingsPanel.add(bacon);
		toppingsPanel.add(new JLabel(""));
		toppingsPanel.add(new JLabel(""));
		toppingsPanel.add(ham);
		toppingsPanel.add(pineapple);
		toppingsPanel.add(extracheese);
		toppingsPanel.add(new JLabel(""));
		
		// Customer Information Panel
		JPanel customerInfoPanel = new JPanel();
		customerInfoPanel.setLayout(new GridLayout(5,2,5,0));
		customerInfoPanel.add(new JLabel(""));
		customerInfoPanel.add(new JLabel("PLEASE ENTER YOUR INFORMATION BELOW:", JLabel.CENTER));
		customerInfoPanel.add(new JLabel("NAME:", JLabel.RIGHT));
		customerInfoPanel.add(name);
		customerInfoPanel.add(new JLabel("DELIVERY ADDRESS:", JLabel.RIGHT));
		customerInfoPanel.add(address1);
		customerInfoPanel.add(new JLabel(""));
		customerInfoPanel.add(address2);
		customerInfoPanel.add(new JLabel("TELEPHONE NUMBER:", JLabel.RIGHT));
		customerInfoPanel.add(phonenumber);
		
		// Order Information Panel (Customer Information Panel + Order Button)
		JPanel orderInfoPanel = new JPanel();
		orderInfoPanel.setLayout(new GridLayout(2,1,0,5));
		orderInfoPanel.add(customerInfoPanel);
		orderInfoPanel.add(order);
			
		// Adding Panels to Frame
		add(radioButtonPanel, BorderLayout.NORTH);
		add(toppingsPanel, BorderLayout.CENTER);
		add(orderInfoPanel, BorderLayout.SOUTH);
		
		
		// Clicking "Order" Button Initiates ActionListener
		order.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double price = 0.0;
				// Pizza Size RadioButton Selection
				String size = null;
				if (small.isSelected()) {
					size = "small";
					price += 4.00;
				} else if (medium.isSelected()) {
					size = "medium";
					price += 5.50;
				} else if (large.isSelected()) {
					size = "large";
					price += 7.00;
				} else if (xlarge.isSelected()) {
					size = "extra large";
					price += 8.00;
				}
				// Crust Type RadioButton Selection
				String crust = null;
				if (thin.isSelected()) {
					crust = "thin";
				} else if (regular.isSelected()) {
					crust = "regular";
				} else if (thick.isSelected()) {
					crust = "thick";
				}
				// Sauce Type RadioButton Selection
				String sauce = null;
				if (red.isSelected()) {
					sauce = "red";
				} else if (white.isSelected()) {
					sauce = "white";
				}
				// Toppings CheckBox Selections
				ArrayList<String> toppings = new ArrayList<String>();
				if (pepperoni.isSelected()) {
					toppings.add("Pepperoni");
					price += 1.85;
				}
				if (sausage.isSelected()) {
					toppings.add("Sausage");
					price += 1.85;
				}
				if (bellpeppers.isSelected()) {
					toppings.add("Bell Peppers");
					price += 1.85;
				}
				if (tomatoes.isSelected()) {
					toppings.add("Tomatoes");
					price += 1.85;
				}
				if (anchovies.isSelected()) {
					toppings.add("Anchovies");
					price += 1.85;
				}
				if (olives.isSelected()) {
					toppings.add("Olives");
					price += 1.85;
				}
				if (roastedchicken.isSelected()) {
					toppings.add("Roasted Chicken");
					price += 1.85;
				}
				if (garlic.isSelected()) {
					toppings.add("Garlic");
					price += 1.85;
				}
				if (mushrooms.isSelected()) {
					toppings.add("Mushrooms");
					price += 1.85;
				}
				if (basil.isSelected()) {
					toppings.add("Basil");
					price += 1.85;
				}
				if (jalapenopeppers.isSelected()) {
					toppings.add("Jalapeno Peppers");
					price += 1.85;
				}
				if (bacon.isSelected()) {
					toppings.add("Bacon");
					price += 1.85;
				}
				if (ham.isSelected()) {
					toppings.add("Ham");
					price += 1.85;
				}
				if (pineapple.isSelected()) {
					toppings.add("Pineapple");
					price += 1.85;
				}
				if (extracheese.isSelected()) {
					toppings.add("Extra Cheese");
					price += 1.85;
				}
				
				// Final Price Including Delivery Fee
				price += DELIVERY_FEE;
				
				// Storing Customer Information from TextFields into Strings
				String nameEntry = name.getText(); 
				String address1Entry = address1.getText();
				String address2Entry = address2.getText();
				String phoneNumberEntry = phonenumber.getText();
				
				
				// Message Window is Created After Order Has Been Placed
				DecimalFormat decimalFormat = new DecimalFormat("0.00");
				JOptionPane.showMessageDialog(null, "Your order has been sent.\nYou ordered a "+size+" pizza "
						+ "with "+crust+" crust and "+sauce+" sauce. You have chosen the following toppings:"
								+ "\n\n"+toppings.toString()+"\n\nYour total is:  $"+decimalFormat.format(price)+""
										+ "\n\nThe pizza will be delivered within 30 minutes to "+nameEntry+" at the "
												+ "following address:\n\n"+address1Entry+"\n"+address2Entry);
			}
		});	
	}
	
	// Method That Displays Frame
	public void display() {
		setVisible(true);
	}

	// Main Method
	public static void main(String args[]) {
		PizzaCreator frame = new PizzaCreator();
		frame.display();
		}
}
