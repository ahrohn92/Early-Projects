import java.util.Scanner;

class JavaMathMethods {
	
	public static void main (String[] args) {

		int contSelect = 1;
		 
		while (contSelect == 1) {
			 
			// User Prompt
			Scanner input = new Scanner(System.in);
			System.out.println("\nThis program demonstrates math methods in Java.\n");
			System.out.println("-----USER MENU-----\n");
			System.out.println("To find the absolute power of a number, press 1");
			System.out.println("To round a number up, press 2");
			System.out.println("To round a number down, press 3");
			System.out.println("To find the greater of two numbers, press 4");
			System.out.println("To find the lesser of two numbers, press 5");
			System.out.println("To find the square root of a number, press 6\n");
			int select = input.nextInt();
			 
			// Math Methods
			switch (select) {
			 	
			case 1:
				System.out.println("\nPlease enter a number that you want to find the absolute power of: \n");
				double num0 = input.nextDouble();
				System.out.println("\nThe absolute power of  "+num0+" is "+Math.abs(num0)+".");
				break;
			case 2:
				System.out.println("\nPlease enter a number that you want to round up: \n");
				double num1 = input.nextDouble();
				System.out.println("\nThe number "+num1+" has been rounded up to "+Math.ceil(num1)+".");
				break;
			case 3:
				System.out.println("\nPlease enter a number that you want to round down: \n");
				double num2 = input.nextDouble();
				System.out.println("\nThe number "+num2+" has been rounded down to "+Math.floor(num2)+".");
				break;
			case 4:
				System.out.println("\nEnter the first number: \n");
				double num3 = input.nextDouble();
				System.out.println("\nEnter the second number: \n");
				double num4 = input.nextDouble();
				System.out.println("\nThe greater of "+num3+" and "+num4+" is: "+Math.max(num3, num4)+".");
				break;
			case 5:
				System.out.println("\nEnter the first number: \n");
				double num5 = input.nextDouble();
				System.out.println("\nEnter the second number: \n");
				double num6 = input.nextDouble();
				System.out.println("\nThe lesser of "+num5+" and "+num6+" is: "+Math.max(num5, num6)+".");
				break;
			case 6:
				System.out.println("\nPlease enter a number that you want to find the square root of: \n");
				double num7 = input.nextDouble();
				System.out.println("\nThe square root of "+num7+" is "+Math.sqrt(num7)+".");
				break;
			}
			 
			contPrompt();
			contSelect = input.nextInt();
		}
	}
	public static void contPrompt() {
		System.out.println("\nWould you like to return to the user menu?");
		System.out.println("Yes = 1");
		System.out.println("No = 2\n");
	}
}