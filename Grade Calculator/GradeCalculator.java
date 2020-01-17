
import java.util.Scanner;
import java.text.DecimalFormat;

public class GradeCalculator {
	
	static int numCats;
	static String[] catName = new String[10];
	static int[] numGradedItems = new int[20];
	static double[] catPercentGrade = new double[10];

	public static void main(String[] args) {
		
		// Variable Definition
		double[] itemPercentGrade = new double[20];
		String correctUserSelect = "YES";
		String incorrectUserSelect = "NO";
		
		// USER PROMPT
		Scanner input = new Scanner(System.in);
		System.out.println("\n\n-----------------------GRADE CALCULATOR-----------------------\n\n");
		System.out.println("\nThis program will:\n");
		System.out.println("1.\tCalculate your final grade after all asignments have been scored.\n");
		System.out.println("2.\tCalculate what score you need on a final assignment to get a desired grade.\n");
		System.out.println("Please select either option '1' or '2'\n");
		int programSelect = input.nextInt();
		
		if (programSelect == 1) {
			System.out.println("\n\n--------------------FINAL GRADE CALCULATOR--------------------\n\n");
		} else {
			System.out.println("\n\n-------------------DESIRED GRADE CALCULATOR-------------------\n\n");
		}
		
		System.out.println("First, how many different grading categories comprise your final grade?\n");
		numCats = input.nextInt();  // Make Method to check for valid int
		
		// Finding values for variables and filling appropriate arrays
		boolean correctInfoCheckError = true;
		while (correctInfoCheckError) {
			boolean sumPercentCheckError = true;
			while (sumPercentCheckError) {
				double sumPercent = 0.0;
				for (int i = 0, num = 1; i < numCats; i++, num++) {
					System.out.println("\nWhat is the name of category #"+num+"?\n");
					Scanner textscan1 = new Scanner(System.in);
					catName[i] = textscan1.nextLine();
					System.out.println("\nWhat percentage of the total grade is this category worth? (ex: 50)\n");
					catPercentGrade[i] = input.nextDouble();
					sumPercent = sumPercent + catPercentGrade[i];
					System.out.println("\nHow many graded items are in this category?\n");
					numGradedItems[i] = input.nextInt();
					itemPercentGrade[i] = catPercentGrade[i]/numGradedItems[i];
				}
				
				// Checks to see if category percentages add up to 100%
				if (sumPercent == 100.0) {
					sumPercentCheckError = false;
				} else {
					System.out.println("\nSorry, but the sum of your category percentages adds up to "+sumPercent+"%");
					System.out.println("The sum must add up to exactly 100.0%.");
					sumPercentCheckError = true;
				}
			}
			
			// Prints overview of grade composition
			System.out.println("\n\n--------------------OVERVIEW OF GRADE COMPOSITION--------------------\n\n");
			DecimalFormat numFormat = new DecimalFormat("#.##"); // Limits decimal length
			for (int i = 0, num = 1; i < numCats; i++, num++) {
				System.out.println("Category number "+num+" is named: "+catName[i]);
				System.out.println(catName[i]+" make up "+numFormat.format(catPercentGrade[i])+"% of your overall grade.");
				System.out.print("There are "+numGradedItems[i]+" graded items in this category,");
				System.out.println(" comprimising "+numFormat.format(itemPercentGrade[i])+"% of your overall grade each.\n");
			}
			
			// Asks the user to confirm information inputed is correct
			Scanner textscan2 = new Scanner(System.in);
			System.out.println("Please check to see if this information is correct.");
			System.out.println("If so, please type 'YES' or 'NO'.\n");
			String userSelect = textscan2.nextLine();
			boolean inputCheckError = true;
			while (inputCheckError) {
				if (correctUserSelect.equalsIgnoreCase(userSelect)) {
					correctInfoCheckError = false;
					inputCheckError = false;
				} else if (incorrectUserSelect.equalsIgnoreCase(userSelect)) {	
					System.out.println("\nPlease re-input the correct information.");
					sumPercentCheckError = true;
					break;
				} else {
					System.out.println("\nPlease enter either 'YES' or 'NO'\n");
					userSelect = textscan2.nextLine();
				}
			}
		}
		
		// WHERE THE TWO PROGRAMS DIVERGE
		if (programSelect == 1) {
			FinalGradeCalculator.FinalGradeCalculator();
		} else {
			DesiredGradeCalculator.DesiredGradeCalculator();
		}
		
	}
	
	// Access Methods for Subclasses
	public int getNumCats() {
		return numCats;
	}
	public String getCatName(int i) {
		return catName[i];
	}
	public int getNumGradedItems(int i) {
		return numGradedItems[i];
	}
	public double getCatPercentGrade(int i) {
		return catPercentGrade[i];
	}
}