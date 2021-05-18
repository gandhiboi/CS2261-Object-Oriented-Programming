package project1;
import java.util.*;	

public class HunterBearNinja {
	public static void main(String[] args ) {
		
		/* Defines variables for the statistics, the 
		 * random number generator for the computer, 
		 * and intelligence strategy for computer */
		int humanScore = 0;
		int computerScore = 0;
		int computerRandom;
		char computerChoice;
		char computerPrev = 'a';
		
		
		Scanner input = new Scanner(System.in);
		
		/* Displays the rules and options for the game */
		System.out.printf("%35s", "Welcome to Hunter-Bear-Ninja!!\n");
		System.out.println("--------------------------------------");
		System.out.println("The rules are as follows:");
		System.out.printf("%25s", "1) Hunter shoots bear\n");
		System.out.printf("%22s", "2) Bear eats ninja\n");
		System.out.printf("%26s", "3) Ninja kills hunter\n\n");
		
		System.out.println("Choose an option below:");
		System.out.printf("%13s", "A) Hunter\n");
		System.out.printf("%11s", "B) Bear\n");
		System.out.printf("%13s", "C) Ninja\n\n");
		
		
		/* Asks the user whether or not they would like to play */
		System.out.println("Would you like to play? (Enter Y/y or N/n)");
		String answer = input.next().toLowerCase();
		char ch = answer.charAt(0);
		
		/* Validates the user's entry */
		while(ch != 'y' && ch != 'n') {
			System.out.println("ERROR: Input invalid, enter Y/y or N/n");
			answer = input.next().toLowerCase();
			ch = answer.charAt(0);
			System.out.println(ch);
		};	
	
		
		/* Loop to execute the game multiple times until user says 'n' */
		while (ch == 'y') {
			
			while(ch != 'y' && ch != 'n') {
				System.out.println("ERROR: Input invalid, enter Y/y or N/n");
				answer = input.next().toLowerCase();
				ch = answer.charAt(0);
				System.out.println(ch);
			};
			
			/* Generates random number for the computer every iteration */
		    Random generator = new Random();
		    computerRandom = generator.nextInt(3) + 1; 
		    
		    /* Initializes the computer's random number
		     * for comparison to user input */
			if (computerRandom == 1) {
				computerChoice = 'a';
			}
			else if (computerRandom == 2) {
				computerChoice = 'b';
			}
			else
				computerChoice = 'c';
			
			/* Intelligence strategy to out play user */
			if (computerScore < humanScore) {
				computerChoice = computerPrev;
			}
			
			/* Retrieves user input and converts to lowercase for comparison*/
			System.out.println("Choose your option (A, B, C): ");
			String userChoice = input.next().toLowerCase();
			char choice = userChoice.charAt(0);
			
			/* Compares user input to computer input and displays winner/loser */
			if (choice == computerChoice) {
				System.out.println("It's a tie");
			}
			if (choice == 'b') {
				if (computerChoice == 'a') {
					System.out.println("You lose, hunter shoots bear!");
					computerScore++;
				}
			}
			if (choice == 'a') {
				if (computerChoice == 'b') {
					System.out.println("You win, hunter shoots bear!");
					humanScore++;
				}
			}
			if (choice == 'a') {
				if (computerChoice == 'c') {
					System.out.println("You lose, ninja kiils hunter!");
					computerScore++;
				}
			}
			if (choice == 'c') {
				if (computerChoice == 'a') {
					System.out.println("You win, ninja kills hunter!");
					humanScore++;
				}
			}
			if (choice == 'c') {
				if (computerChoice == 'b') {
					System.out.println("You lose, bear eats ninja!");
					computerScore++;
				}
			}
			if (choice == 'b') {
				if (computerChoice == 'c') {
					System.out.println("You win, bear eats ninja!");
					humanScore++;
				}
			}
			
			/* Checks if user enters an invalid input and prompts user to play again */ 
			if (choice != 'a' && choice != 'b' && choice != 'c')
				System.out.println("ERROR: Invalid user input.");
			
			/* Displays game statistics */
			System.out.println("Human: " + humanScore + " Computer: " + computerScore);
			
			/* Intelligence strategy */
			computerPrev = computerChoice;
			
			/* If user wants to stop playing, exit the game */
			if (ch == 'n') {
				System.out.println("Exiting the game!");
				System.exit(0);
			}
			
			/* Asks the user if they would like to play again */
			System.out.println("Would you like to play again?");
			answer = input.next().toLowerCase();
			ch = answer.charAt(0);
			
			/* Validates user input */
			if (ch != 'y' && ch != 'n') {
				System.out.println("ERROR: Invalid input, enter Y/y or N/n");
				answer = input.next().toLowerCase();
				ch = answer.charAt(0);
			}
			
			/* If user does not want to play again, exit and display stats */
			if (ch == 'n') {
				System.out.println("Thanks for playing!");
				System.out.println("The final score was Human: " + humanScore + " Computer: " + computerScore);
				System.exit(0);
			}
		}
		
		/* If user doesn't want to play off the start, display message */
		System.out.print("Maybe next time, see you later!");
	}
}