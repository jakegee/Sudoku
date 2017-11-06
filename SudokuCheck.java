/**
 * @author Jacob Smith A program for class SudokuCheck that checks if a 9x9 Sudoku
 * satisfies the rules for a sudoku game. It will check to see if each number
 * played is a valid move with stating "true" or "false"
 */
import java.util.ArrayList;
import java.util.Collections;

public class SudokuCheck {
/**
 * Method for checking the values in each row to see if there are any duplicates
 * @param sudoku 
 * @param row
 * @return
 */
	public static boolean checkRow(Sudoku sudoku, int row) { 
		for (int col = 0; col < sudoku.getArray().length; col++) {
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					if ((sudoku.getArray()[row][i] == sudoku.getArray()[row][j]) && !(i == j)) { // This
						// if statement verifies that you cannot have the same value in i and j as well
						// as the value in the row index for i and j
						return false;
					}
				}
			}
		}
		return true;
	}
/**
 * Method for checking the values in each column to see if there are any duplicates
 * @param sudoku
 * @param col
 * @return
 */
	public static boolean checkCol(Sudoku sudoku, int col) {
		for (int row = 0; row < sudoku.getArray().length; row++) {
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					if ((sudoku.getArray()[i][col] == sudoku.getArray()[j][col]) && !(i == j)) { // This
						// if statement verifies that you cannot have the same value in i and j as well
						// as the value in the column index for i and j
						return false;
					}
				}
			}
		}
		return true;
	}
/**
 * This method is for checking the values of a sudoku in a 3x9 array
 * @param sudoku
 * @return
 */
	public static boolean[][] check(Sudoku sudoku) {
		boolean[][] result = new boolean[3][9];

		for (int r = 0; r < sudoku.getArray().length; r++) {
			result[0][r] = checkRow(sudoku, r); // for loop that checks rows
		}

		for (int c = 0; c < sudoku.getArray().length; c++) {
			result[1][c] = checkCol(sudoku, c); // for loops that checks columns
		}
/**
 * Each result has an array index and gets the checkSquare object sudoku at a row and column position
 */
		result[2][0] = checkSquare(sudoku, 0, 0);
		result[2][1] = checkSquare(sudoku, 0, 3);
		result[2][2] = checkSquare(sudoku, 0, 6);
		result[2][3] = checkSquare(sudoku, 3, 0);
		result[2][4] = checkSquare(sudoku, 3, 3);
		result[2][5] = checkSquare(sudoku, 3, 6);
		result[2][6] = checkSquare(sudoku, 6, 0);
		result[2][7] = checkSquare(sudoku, 6, 3);
		result[2][8] = checkSquare(sudoku, 6, 6);

		return result;
	}

	public static boolean checkSquare(Sudoku sudoku, int checkRow, int checkCol) {

		// List<Integer> list = new ArrayList<Integer>();
		// int [] smallArray = {1,2,3,4,5,6,7,8,9};
/**
 * We're creating new array lists here and adding them together in order to store the values
 * so that they can be checked
 */
		ArrayList<Integer> list = new ArrayList<Integer>();
		ArrayList<Integer> listB = new ArrayList<Integer>();
		listB.add(1);
		listB.add(2);
		listB.add(3);
		listB.add(4);
		listB.add(4);
		listB.add(5);
		listB.add(6);
		listB.add(7);
		listB.add(8);
		listB.add(9);

		int k = checkRow;
		int l = checkCol;

		for (k = checkRow; k < checkRow + 3; k++) { // For loop for checking the rows

			for (l = checkCol; l < checkCol + 3; l++) { // For loop for checking the columns

				// System.out.print(sudoku.getArray()[k][l]);
				list.add(sudoku.getArray()[k][l]); // Adds the arrays to the list
			}

		}

		Collections.sort(list); // Sorts the list

		return list.containsAll(listB); // returns the contents of the list
	}

	public static String BooTOString(boolean[][] b) {
		String a = ""; // Assigns a blank String a so that
		for (int i = 0; i < 3; i++) { // we go through the loops of i and j
			for (int j = 0; j < 9; j++) {
				a += " " + b[i][j]; // Adds the newly create array b with a
			}
			a += "\n"; // adds a new line for a
		}
		return a; // returns a
	}
/**
 * Main method that plugs in values of an array to check with our program that it does
 * return true or false for correct values
 * @param args
 */
	public static void main(String[] args) {
		int[][] array = new int[][] { { 1, 2, 3, 4, 5, 6, 7, 8, 9 }, { 4, 5, 6, 7, 8, 9, 1, 2, 3 },
				{ 7, 8, 9, 1, 2, 3, 4, 5, 6 }, { 2, 3, 4, 5, 6, 7, 8, 9, 1 }, { 5, 6, 7, 8, 9, 1, 2, 3, 4 },
				{ 8, 9, 1, 2, 3, 4, 5, 6, 7 }, { 3, 4, 5, 6, 7, 8, 9, 1, 2 }, { 6, 7, 8, 9, 1, 2, 3, 4, 5 },
				{ 9, 1, 2, 3, 4, 5, 6, 7, 8 } };
		Sudoku sudoku = new Sudoku(array);
		boolean[][] boo;

		boo = check(sudoku);

		System.out.println(BooTOString(boo));
	}

}