

import java.text.DecimalFormat;
import java.util.Scanner;

public class FinalGradeCalculator {
	

	public static void FinalGradeCalculator() {
		
		// Initialization of Class Object
		GradeCalculator gc = new GradeCalculator();
		
		// Variable Definition
		double[][] gradedItemScores = new double[10][20];
		double gradedItemScoreAvg[] = new double[10];
		
		// Initialization of Scanner
		Scanner input = new Scanner(System.in);
		
		// Enters individual scores for graded items into a 2-dimensional array
		System.out.println("\nNow we will starting entering the scores for items that were already graded.");
			for (int i = 0; i < GradeCalculator.numCats; i++) { // Alternative method of passing variable
				double gradedItemScoreSum = 0.0;
				System.out.println("Fill in the scores for graded items under '"+gc.getCatName(i)+"'. (ex: 75.0)\n");
				for (int j = 0, num = 1; j < gc.getNumGradedItems(i); j++, num++) {
					System.out.println("Enter the score for graded item #"+num+": ");
					gradedItemScores[i][j] = input.nextDouble();
					gradedItemScoreSum += gradedItemScores[i][j];
				}
				gradedItemScoreAvg[i] = gradedItemScoreSum/gc.getNumGradedItems(i);
			}
							
			// Prints grade data
			DecimalFormat numFormat = new DecimalFormat("#.##");
				for (int i = 0; i < gc.getNumCats(); i++) {
					System.out.println("\n\nThe scores under '"+gc.getCatName(i)+"' are:\n");
					for (int j = 0, num = 1; j < gc.getNumGradedItems(i); j++, num++) {
						System.out.println("The score for graded item #"+num+" is: "+numFormat.format(gradedItemScores[i][j]));
					}
					System.out.println("---------------------------------------");
					System.out.println("The average of your scores is: "+numFormat.format(gradedItemScoreAvg[i]));
				}
							
			// Mathematical Equation to calculate final grade
			double finalGrade = 0.0;
			for (int i = 0; i < gc.getNumCats(); i++) {
				finalGrade += (gradedItemScoreAvg[i]/100)*gc.getCatPercentGrade(i);
			}
			
			// Determining Letter Grade
			char finalLetterGrade;
			if (finalGrade >= 90.0) {
				finalLetterGrade = 'A';
			} else if (90.0 > finalGrade && finalGrade >= 80.0) {
				finalLetterGrade = 'B';
			} else if (80.0 > finalGrade && finalGrade >= 70.0) {
				finalLetterGrade = 'C';
			} else if (70.0 > finalGrade && finalGrade >= 60.0) {
				finalLetterGrade = 'D';
			} else {
				finalLetterGrade = 'F';
			}
							
			// Final Output
			if (finalLetterGrade == 'A') {
				System.out.println("\n\nYour final grade is an "+finalLetterGrade+" ("+numFormat.format(finalGrade)+"%).");
			} else {
				System.out.println("\n\nYour final grade is a "+finalLetterGrade+" ("+numFormat.format(finalGrade)+"%).");
			}
	}

}
