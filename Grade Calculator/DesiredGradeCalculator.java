

import java.text.DecimalFormat;
import java.util.Scanner;

public class DesiredGradeCalculator {

	public static void DesiredGradeCalculator() {
		
		// Initialization of Class Object
		GradeCalculator gc = new GradeCalculator();
		
		// Variable Definition
		char desiredLetterGrade = 0;
		double minLetterGradeValue = 0.0;
		double unknownItemScoreSum = 0.0;
		double[][] gradedItemScores = new double[10][20];
		double gradedItemScoreAvg[] = new double[10];
		
		// Initialization of Scanner
		Scanner input = new Scanner(System.in);
		System.out.println("\nWhat is your desired letter grade?\n");
		
		boolean validCharError = true;
		while (validCharError) {
			desiredLetterGrade = Character.toUpperCase(input.next().charAt(0));
			switch (desiredLetterGrade) {
				case 'A' : minLetterGradeValue = 90.0;
					validCharError = false;
					break;
				case 'B' : minLetterGradeValue = 80.0;
					validCharError = false;
					break;
				case 'C' : minLetterGradeValue = 70.0;
					validCharError = false;
					break;
				case 'D' : minLetterGradeValue = 60.0;
					validCharError = false;
					break;
				case 'F' : minLetterGradeValue = 0.0;
					validCharError = false;
					break;
				default : System.out.println("Please input a valid character (e.g. 'A' or 'a')");
					break;
			}
		}
		System.out.println("\nIn order to get a(n) "+desiredLetterGrade+", your final grade will have to be equal to or greater"
				+ " than "+minLetterGradeValue+"%.\n");
		
		System.out.println("Which category has the unscored assignment?\n");
		for (int i = 0, select = 1; i < GradeCalculator.numCats; i++, select++) {
			System.out.println(select+".\t"+gc.getCatName(i)+"\n");
		}
		int catSelect = input.nextInt() - 1;
		
		// Enters individual scores for graded items into a 2-dimensional array
		System.out.println("\nNow we will starting entering the scores for items that were already graded.");
		for (int i = 0; i < gc.getNumCats(); i++) {
			double gradedItemScoreSum = 0.0;
			
			System.out.println("Fill in the scores for graded items under '"+gc.getCatName(i)+"'. (ex: 75.0)\n");
			if (i == catSelect) {
				for (int j = 0, num = 1; j < gc.getNumGradedItems(i)-1; j++, num++) { // Leaves element void of value
					System.out.println("Enter the score for graded item #"+num+": ");
					gradedItemScores[i][j] = input.nextDouble();
					unknownItemScoreSum += gradedItemScores[i][j];
				}
			} else {
				for (int j = 0, num = 1; j < gc.getNumGradedItems(i); j++, num++) {
					System.out.println("Enter the score for graded item #"+num+": ");
					gradedItemScores[i][j] = input.nextDouble();
					gradedItemScoreSum += gradedItemScores[i][j];
				}
			}
			gradedItemScoreAvg[i] = gradedItemScoreSum/gc.getNumGradedItems(i);
		}
						
		// Mathematical Equations that Calculates Unknown Score
		double unknownScore = 0.0;
		double tempNum = 0.0;
		DecimalFormat numFormat = new DecimalFormat("#.##");
		for (int i = 0; i < gc.getNumCats(); i++) {
			if (i != catSelect) {
				tempNum += gradedItemScoreAvg[i]*(gc.getCatPercentGrade(i)/100);
			}
		}
		unknownScore = gc.getNumGradedItems(catSelect)*((minLetterGradeValue - tempNum)/(gc.getCatPercentGrade(catSelect)/100)) - unknownItemScoreSum;
		
		// Calculates Max Possible Grade
		gradedItemScores[catSelect][gc.getNumGradedItems(catSelect)-1] = 100;
		double maxFinalGrade = 0.0;
		for (int i = 0; i < gc.getNumCats(); i++) {
			maxFinalGrade += (gradedItemScoreAvg[i]/100)*gc.getCatPercentGrade(i);
		}
		maxFinalGrade += ((100+unknownItemScoreSum)/gc.getNumGradedItems(catSelect)/100)*gc.getCatPercentGrade(catSelect);
		
		// Determining Letter Grade
		char maxFinalLetterGrade;
		if (maxFinalGrade >= 90.0) {
			maxFinalLetterGrade = 'A';
		} else if (90.0 > maxFinalGrade && maxFinalGrade >= 80.0) {
			maxFinalLetterGrade = 'B';
		} else if (80.0 > maxFinalGrade && maxFinalGrade >= 70.0) {
			maxFinalLetterGrade = 'C';
		} else if (70.0 > maxFinalGrade && maxFinalGrade >= 60.0) {
			maxFinalLetterGrade = 'D';
		} else {
			maxFinalLetterGrade = 'F';
		}

		// Output
		if (unknownScore > 100.0) {
			System.out.println("\nI'm sorry, but it is impossible for you to get a(n) "+desiredLetterGrade+".\n");
			System.out.println("The best grade you could possibly get is a(n) "+maxFinalLetterGrade+" ("+numFormat.format(maxFinalGrade)+"%).");
		} else {
			System.out.println("\n\nYou need to get a score of at least "+numFormat.format(unknownScore)+" on the last assignment under '"+gc.getCatName(catSelect)+"'"
					+ " to get a(n) "+desiredLetterGrade+".");
		}
	}
}
