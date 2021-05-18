package Project3;
import java.util.Scanner;

public class Project3 {

	public static void main(String[] args) {
		WumpusWorld wumpusWorld = new WumpusWorld();
		Scanner sc = new Scanner(System.in);
		
		System.out.println("\tWelcome to Wumpus World!");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("Objective: Find the gold treausure without being devoured \n"
				+ "by the evil Wumpus or falling into one of the 3 pits!\n");
		System.out.println("Hint: Press 'C' if you get stuck to show the map.\n" );
		
		System.out.println("I wish you the best of luck!  (^_^) \n");
		
		//Loops through the game until the user finds the gold, falls in the pit, or runs into the Wumpus
		while(wumpusWorld.printCurrentSquare()) {
			
			System.out.println("Where would you like to move:");
			System.out.println("N - North");
			System.out.println("S - South");
			System.out.println("E - East");
			System.out.println("W - West");
			
			int choice = sc.next().charAt(0);
			switch(choice) {
			case 'N':
				wumpusWorld.move(WumpusWorld.NORTH);
				break;
			case 'S':
				wumpusWorld.move(WumpusWorld.SOUTH);
				break;
			case 'E':
				wumpusWorld.move(WumpusWorld.EAST);
				break;
			case 'W':
				wumpusWorld.move(WumpusWorld.WEST);
				break;
			case 'C':
				wumpusWorld.displayBoard();
				break;
				}
			}
		sc.close();
		}
	}
