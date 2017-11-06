/**
 * @author Jacob Smith A program for class Sudoku that declares a 2 dimensional
 * array and toString of the board/layout for a completed sudoku
 */
public class Sudoku {

	public Sudoku(int array[][]) { // Constructor for the array
		this.array = array; // Refers to the array object
	}

	public int[][] getArray() { // Method for getting the array
		return array;
	}

	private int[][] array; // Initialising variable integer array

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
		for (int i = 0; i < array.length; i++) { 
			if (i == 0 || i == 3 || i == 6) { // When the loop is at row 0, 3, and 6
				board += border + "\n"; // Add the boundary row to the board at those locations
									 // and move to the next line with \n
			}
			board += single; // Adds the  single wall to the board
			for (int j = 0; j < array[i].length; j++) {
				if (j == 3 || j == 6) { // At column index 3 and 6
					board += "|| " + array[i][j] + " "; // The double border wall should be added
				} else {
					board += "| " + array[i][j] + " "; // otherwise add the single border wall
				}
				if (j == 8) {
					board += doubleb + "\n"; // if column is 8 add the double wall
				}
				if (j == 8 && (i == 0 || i == 1 || i == 3 || i == 4 || i == 6 || i == 7)) {
					board += rows + "\n"; // add the rows to the board
				}


			}

		}
		board += border; // adds the border wall to the bottom of the board
						 // because our for loop stops before that row
		return board;

	}

	public boolean isFilled() { // Method to check if all elements are filled in the sudoku
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				if (array[i][j] == 0) {
					return false; // returns when there's a 0 or blank
				}
			}
		}
		return true; // returns true when every space is filled
	}
/**
 * Main method that plugs values in for an array 'a', then prints to screen with the toString
 * Ideally I wanted to add an if () in order to create a space for any 0's but could
 * not figure out how
 */
	public static void main(String[] args) {
		int[][] a = { { 1, 2, 3, 4, 5, 6, 7, 8, 9 }, { 4, 5, 6, 7, 8, 9, 1, 2, 3 }, { 7, 8, 9, 1, 2, 3, 4, 5, 6 },
				{ 2, 3, 4, 5, 6, 7, 8, 9, 1 }, { 5, 6, 7, 8, 9, 1, 2, 3, 4 }, { 8, 9, 1, 2, 3, 4, 5, 6, 7 },
				{ 3, 4, 5, 6, 7, 8, 9, 1, 2 }, { 6, 7, 8, 9, 1, 2, 3, 4, 5 }, { 9, 1, 2, 3, 4, 5, 6, 7, 8 } };

		Sudoku sudokuObj = new Sudoku(a);
		System.out.println(sudokuObj.toString());
		System.out.println(sudokuObj.isFilled());

	}
}
