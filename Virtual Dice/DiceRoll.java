import java.util.Scanner;
import java.util.Random;

class DiceRoll {
	
	public static void main(String[] args) {
		
		// User Prompt
		Scanner input = new Scanner(System.in);
		System.out.println("\nThis program rolls a virtual dice.");
		
		int select = 1;	
		while (select == 1) {	
			System.out.println("How many times do you want to roll the dice?\n");
			int numRoll = input.nextInt();
		
			// Random Number Generator
			Random dice = new Random();
			int num;
			System.out.println();

			for (int count = 1; count <= numRoll; count++) {
			num = 1 + dice.nextInt(6);
			System.out.println("Dice roll #"+count+" was "+num+".");
			}
			contPrompt();
			select = input.nextInt();
			System.out.println();
		}
	}
	static void contPrompt() {
		System.out.println("\nWould you like to roll the dice again?");
		System.out.println("\nPress 1 for Yes");
		System.out.println("Press 2 for No\n");
	}
}