import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
/**
 * @author Jacob Smith A program for class SudokuInteractive that allows
 * the user to interact with the sudoku game
 */
public class SudokuInteractive extends Sudoku { // Extends Sudoku.java into this subclass

	public SudokuInteractive(int[][] array) {
		super(array);
	}

	public String toString() {
		/**
		 * The purpose of this toString is to print out the boundaries and
		 * design of the sudoku board
		 *
		 */
		String board = ""; // Board area to be completed
		String border = "++===+===+===++===+===+===++===+===+===++"; // 3x3 boundary row
		String rows = "++---+---+---++---+---+---++---+---+---++"; // Between rows
		String doubleb = "||"; // Border for 3x3 walls
		String single = "|"; // Wall between each number
/**
 * Following for loops and if statements are for setting up the entire playable game board
 */
		for (int i = 0; i < getArray().length; i++) {
			if (i == 0 || i == 3 || i == 6) { // When the loop is at row 0, 3, and 6
				board += border + "\n"; // Add the boundary row to the board at those locations
									 // and move to the next line with \n
			}
			board += single; // Adds the  single wall to the board
			for (int j = 0; j < getArray()[i].length; j++) {
				if (j == 3 || j == 6) { // At column index 3 and 6
					board += "||" +"*"+getArray()[i][j]+"*"; // The double border wall should be added
				} else {
					board += "|" +"*"+getArray()[i][j]+"*"; // otherwise add the single border wall
				}
				if (j == 8) {
					board += doubleb + "\n"; // if column is 8 add the double wall
				}

				if (j == 8 && (i == 0 || i == 1 || i == 3 || i == 4 || i == 6 || i == 7)) {
					board += rows + "\n"; // add the rows to the board
				}
				if (getArray()[i][j] == 0) {
					board += "";
				}

			}

		}
		board += border; // adds the border wall to the bottom of the board
						 // because our for loop stops before that row
		return board;
	}
/**
 * Main method in order to read in a file, allow a user to input,
 * and print values to the board
 * @param args
 */
	public static void main(String[] args) {

		String filename ="sudoku-ex1.txt"; // Reads in a file of a partial sudoku
		int row, column, value;

		Scanner input = new Scanner(System.in); // Provides the user to have input
		ArrayList<String> tempValue = new ArrayList<String>();

		try {	// Reads the file that's been input and places it into an array
		SudokuRead s = new SudokuRead();
		Sudoku newArray = s.readSudoku(filename);
		int[][]array=newArray.getArray();
		SudokuInteractive newBoard = new SudokuInteractive(array);

		for (int i = 0; i <array.length; i++) { // For loop for the rows and columns
			for (int j = 0; j <array.length; j++) { // Assigning values and storing them
			if (array[i][j] == 0);
				String iValue = String.valueOf(i);
				String jValue = String.valueOf(j);
				tempValue.add(iValue + jValue);
			}
		}

		while (newArray.isFilled()==false) {
/**
 * Allows for a user to have input for the row, column, and value entered at that section
 */
			System.out.println(newBoard);
			System.out.println("Please enter a row value between 1-9");
			row = input.nextInt()-1;
			System.out.println("Please enter a column value between 1-9");
			column = input.nextInt()-1;
			System.out.println("Please enter a value to be entered onto the board");
			value = input.nextInt();

			if (array[row][column] == 0) { // States if equal to 0
				String newiValue = String.valueOf(row);  // Assign these values to row/column
				String newjValue = String.valueOf(column);
			String position = newiValue + newjValue; // Give this position
				if (tempValue.contains(position)) { // If it's a blank space enter it
					array[row][column] = value; // array gets the value
				}
				else {
					System.out.println("The value can't be changed"); // Else displays this message
				}
			}
			else {
				array[row][column] = value; // else array gets the value
			}
			System.out.println(newArray);
			}
		input.close(); // Closes users input
		}
		catch(IOException e){ // Catch statements for file not existing or if an incorrect number is entered
			System.out.println("File does not exist");
		}
		catch(java.lang.ArrayIndexOutOfBoundsException e) {
			System.out.println("Please only enter a number 1-9");
		}

	}
}
