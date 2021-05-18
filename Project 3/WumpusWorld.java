package Project3;
import java.awt.Point;
import java.util.*;

public class WumpusWorld {
	public static final int boardSIZE = 4;
	public static final int NUM_WUMPUS = 1;
	public static final int NUM_GOLD = 1;
	public static final int NUM_PITS = 3;
	public static final int WEST = 1;
	public static final int EAST = 2;
	public static final int NORTH = 3;
	public static final int SOUTH = 4;
	
	private Square[][] gameBoard;
	private ArrayList<Point> emptyLocations;
	private int humanX, humanY;
	
	public WumpusWorld() {
		
		//Sets the x and y coordinates for Human
		setHumanX(0);
		setHumanY(boardSIZE - 1);
		
		//Creates a 2D array for the gameBoard and empty list for emptyLocations
		gameBoard = new Square[boardSIZE][boardSIZE];
		emptyLocations = new ArrayList<>();
		
		//Creates the 4x4 grid for the gameBoard and creates empty locations for each square
		for(int i=0;i<boardSIZE;i++) {
			for(int j=0;j<boardSIZE;j++) {
				gameBoard[i][j] = new Square(i, j);
				if(j != 0 && i != boardSIZE -1)
					emptyLocations.add(new Point(i, j));
			}
		}
		
		//Shuffles the empty locations in the ArrayList and initializes the user to (3,0) in the 2D array
		Collections.shuffle(emptyLocations);		
		gameBoard[boardSIZE-1][0].addEntity(Square.HUMAN);
		
		//Loops through the 2D array and adds Pit and propagates breezes around the pits,
		//while checking the gameBoard's boundaries
		for(int i=0;i<NUM_PITS;i++) {
			Point p = emptyLocations.get(0);
			emptyLocations.remove(0);
			gameBoard[p.x][p.y].addEntity(Square.PIT);
			if(p.x >= 1) {
				gameBoard[p.x -1][p.y].addEntity(Square.BREEZE);
			}
			if(p.y >= 1) {
				gameBoard[p.x][p.y-1].addEntity(Square.BREEZE);
			}
			if(p.x <= boardSIZE - 2) {
				gameBoard[p.x + 1][p.y].addEntity(Square.BREEZE);
			}
			if(p.y <= boardSIZE -2) {
				gameBoard[p.x][p.y + 1].addEntity(Square.BREEZE);
			}
		}
		
		//Loops through the 2D array and adds Wumpus and propagates stenches around the wumpus,
		//while checking the gameBoard's boundaries
		for(int i=0;i<NUM_WUMPUS;i++) {
			Point p = emptyLocations.get(0);
			emptyLocations.remove(0);
			gameBoard[p.x][p.y].addEntity(Square.WUMPUS);
			if(p.x >= 1) {
				gameBoard[p.x -1][p.y].addEntity(Square.STENCH);
			}
			if(p.y >= 1) {
				gameBoard[p.x][p.y-1].addEntity(Square.STENCH);
			}
			if(p.x <= boardSIZE - 2) {
				gameBoard[p.x + 1][p.y].addEntity(Square.STENCH);
			}
			if(p.y <= boardSIZE -2) {
				gameBoard[p.x][p.y + 1].addEntity(Square.STENCH);
			}
		}
		
		//Adds the gold to the 2D array
		for(int i=0;i<NUM_GOLD;i++) {
			Point p = emptyLocations.get(0);
			emptyLocations.remove(0);
			gameBoard[p.x][p.y].addEntity(Square.GOLD);
		}
		
	}
	
	//Getters and setters for human x and y coordinates
	public int getHumanY() {
		return humanY;
	}
	
	public int getHumanX() {
		return humanX;
	}
	
	public void setHumanY(int humanY) {
		this.humanY = humanY;
	}
	
	public void setHumanX(int humanX) {
		this.humanX = humanX;
	}
	
	//Displays the entire board and the locations of the components when user enters 'C'
	public void displayBoard() {
		for(int i=0;i<boardSIZE;i++) {
			System.out.print("\n");
			System.out.print("|");
			for(int j=0;j<boardSIZE;j++) {
				System.out.print(gameBoard[i][j]);
				System.out.print("|");

			}
			System.out.println("");
		}
		System.out.println();
	}
	
	//Is called whenever the user enters N,S,E,W and updates the gameBoard
	//Removes the humans previous location and checks the boundaries for the human
	public void move(int dir) {
		switch(dir) {
		case WEST:
			if(humanX >= 1) {
				gameBoard[humanY][humanX].removeHuman();
				humanX -= 1;
				gameBoard[humanY][humanX].addEntity(Square.HUMAN);
			}
			else {
				System.out.println("Invalid move: you cannot go off the map.");
			}
			break;
		case EAST:
			if(humanX <= boardSIZE - 2) {
				gameBoard[humanY][humanX].removeHuman();
				humanX += 1;
				gameBoard[humanY][humanX].addEntity(Square.HUMAN);
			}
			else {
				System.out.println("Invalid move: you cannot go off the map.");
			}
			break;
		case NORTH:
			if(humanY >= 1) {
				gameBoard[humanY][humanX].removeHuman();
				humanY -= 1;
				gameBoard[humanY][humanX].addEntity(Square.HUMAN);
			}
			else {
				System.out.println("Invalid move: you cannot go off the map.");
			}
			break;
		case SOUTH:
			if(humanY <= boardSIZE - 1) {
				gameBoard[humanY][humanX].removeHuman();
				humanY += 1;
				gameBoard[humanY][humanX].addEntity(Square.HUMAN);
			}
			else {
				System.out.println("Invalid move: you cannot go off the map.");
			}
			break;
		default:
			System.out.println("Invalid move: you cannot go off the map.");
		}
	}
	
	/* Prints the square that the user is in, and whether or not 
	 * there is a stench near the Wumpus or breeze near the pits
	 * Returns false if the square the user lands on is either gold,
	 * wumpus, or pit, and displays the appropriate message.
	 */
	public boolean printCurrentSquare() {
		if(gameBoard[humanY][humanX].getContent().contains(Square.GOLD)) {
			System.out.println("Hurray, you found the gold ^_^ \n");
			return false;
		}
		if(gameBoard[humanY][humanX].getContent().contains(Square.WUMPUS)) {
			System.out.println("The wumpus has eaten you D:\n");
			return false;
		}
		if(gameBoard[humanY][humanX].getContent().contains(Square.PIT)) {
			System.out.println("You fell in a pit x_x \n");
			return false;
		}
		if(gameBoard[humanY][humanX].getContent().contains(Square.BREEZE)) {
			System.out.println("There's a subtle breeze.\n");
		}
		if(gameBoard[humanY][humanX].getContent().contains(Square.STENCH)) {
			System.out.println("There's a gnarly stench here.\n");
		}
		if(gameBoard[humanY][humanX].isEmpty()) {
			System.out.println("All safe");
		}
		return true;
	}
}
