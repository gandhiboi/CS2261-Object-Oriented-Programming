package Project3;
import java.util.*;

public class Square {
	public static final int PIT = 0;
	public static final int BREEZE = 1;
	public static final int STENCH = 2;
	public static final int WUMPUS = 3;
	public static final int GOLD = 4;
	public static final int HUMAN = 5;
	private int x;
	private int y;
	private ArrayList<Integer> content;
	
	//Constructor that creates an empty ArrayList and sets x and y coordinates
	public Square(int x,int y) {
		setContent(new ArrayList<>());
		setX(x);
		setY(y);
	}
	
	//Getters and setters for the x and y coordinates
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	//Getter and setter for the array list
	public ArrayList<Integer> getContent() {
		return content;
	}
	
	public void setX(int x) {
		this.x = x;
	}
	
	public void setY(int y) {
		this.y = y;
	}

	public void setContent(ArrayList<Integer> content) {
		this.content = content;
	}
	
	//Method that adds an entity to the 2d array location being called 
	//(entity being either gold, wumpus, breeze, pit, gold)
	public void addEntity(int entity) {
		content.add(entity);
	}
	
	public boolean isEmpty() {
		return content.isEmpty();
	}
	
	//Removes the symbol for the human after the user moves the humans location
	void removeHuman() {
		content.remove((Integer)HUMAN);
	}
	
	//Checks whether the contents of the array list 
	//contain one of the entities and adds the corresponding symbol
	public String toString() {
		String str = "";
		if(content.contains(PIT)) {
			str += "P";
		}
		if(content.contains(BREEZE)) {
			str += "B";
		}
		if(content.contains(STENCH)) {
			str += "S";
		}
		if(content.contains(WUMPUS)) {
			str += "W";
		}
		if(content.contains(GOLD)) {
			str += "G";
		}
		if(content.contains(HUMAN)) {
			str += "*";
		}
		return String.format("%-6s", str);
	}
}
