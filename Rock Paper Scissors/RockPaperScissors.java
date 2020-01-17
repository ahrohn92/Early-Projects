import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {

	public static void main(String[] args) throws InterruptedException {
		
		int userScore = 0;
		int compScore = 0;
		Scanner input = new Scanner(System.in);
		boolean runGame = true;
		while (runGame) {
			
			// Initial User Prompt
			System.out.println("\nChoose action:\n");
			System.out.println("Rock");
			System.out.println("Paper");
			System.out.println("Scissors\n");
			
			int numUserSelect = 0;
			boolean userSelectError = true;
			
			while (userSelectError) {
				
				String userSelect = input.nextLine();
				if (userSelect.equalsIgnoreCase("Rock")) {
					numUserSelect = 0;
					userSelectError = false;
				} else if (userSelect.equalsIgnoreCase("Paper")) {
					numUserSelect = 1;
					userSelectError = false;
				} else if (userSelect.equalsIgnoreCase("Scissors")) {
					numUserSelect = 2;
					userSelectError = false;
				} else {
					System.out.println("\nPlease enter either 'Rock', 'Paper', or 'Scissors'.\n");
				}
			}
			
			// Initialization of Randomizer
			Random RPS = new Random();
			
			// Computer Select
			int compSelect = RPS.nextInt(3);
			
			// Rock, Paper, Scissors
			System.out.println("\nRock...");
			Thread.sleep(1000);
			System.out.println("Paper...");
			Thread.sleep(1000);
			System.out.println("Scissors...\n");
			Thread.sleep(1000);
			
			// Determines Who Wins
			if (numUserSelect == 0) {
				System.out.println("Your choice: Rock");
				switch (compSelect) {
				case 0: 
						System.out.println("Comp choice: Rock");
						System.out.println("Result: Tie!");
						break;
				case 1: 
						System.out.println("Comp choice: Paper");
						System.out.println("Result: You Lose!");
						compScore++;
						break;
				case 2 :
						System.out.println("Comp choice: Scissors");
						System.out.println("Result: You Win!");
						userScore++;
						break;
				}
			}
			if (numUserSelect == 1) {
				System.out.println("Your choice: Paper");
				switch (compSelect) {
				case 0: 
						System.out.println("Comp choice: Rock");
						System.out.println("Result: You Win!");
						userScore++;
						break;
				case 1: 
						System.out.println("Comp choice: Paper");
						System.out.println("Result: Tie!");
						break;
				case 2 :
						System.out.println("Comp choice: Scissors");
						System.out.println("Result: You Lose!");
						compScore++;
						break;
				}
			}
			if (numUserSelect == 2) {
				System.out.println("Your choice: Scissors");
				switch (compSelect) {
				case 0: 
						System.out.println("Comp choice: Rock");
						System.out.println("Result: You Lose!");
						compScore++;
						break;
				case 1: 
						System.out.println("Comp choice: Paper");
						System.out.println("Result: You Win!");
						userScore++;
						break;
				case 2 :
						System.out.println("Comp choice: Scissors");
						System.out.println("Result: Tie!");
						break;
				}
			}
			
			// Score Tally
			System.out.println("\nYour Score: "+userScore);
			System.out.println("Comp Score: "+compScore);
			System.out.println("\nWould you like to play again? ('Yes' or 'No')\n");
			boolean replySelectError = true;
			while (replySelectError) {
				String runGameSelect = input.nextLine();
				if (runGameSelect.equalsIgnoreCase("YES")) {
					runGame = true;
					replySelectError = false;
				} else if (runGameSelect.equalsIgnoreCase("NO")) {
					runGame = false;
					replySelectError = false;
				} else {
					System.out.println("\nPlease enter either 'Yes' or 'No'.\n");
				}
			}
		}	
	}
}
