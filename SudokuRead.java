/**
 * @author Jacob Smith A program for class SudokuRead that reads partially filled
 * sudoku text files
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class SudokuRead {
/**
 * The constructor includes new throws for
 * @param filename
 * @return
 * @throws IllegalArgumentException
 * @throws IOException
 */
	public static Sudoku readSudoku (String filename) throws IllegalArgumentException, IOException {

	int[][] array = new int[9][9]; // Array of 9x9 size

	try{ // With this try we want to read in a file of String filename
		BufferedReader in = new BufferedReader(new FileReader(filename));

		for(int i=0;i<array.length;i++){ // For loop for only row length of array
			String line = in.readLine(); // Reads in a line of text
			for(int j=0; j<array.length;j++){ // For loop for the column length
				char chr = line.charAt(j); // Returns specific character in the column
				if(chr==' '){ // If there is a space then put a 0
					array[i][j]=0; // Ideally I'd like to have put in a space
								   // but due to time constraints I couldn't figure out how
				}
				else
				{
					int value = Character.getNumericValue(chr); // Gives value the number value of char chr
					if(value>=1&&value<=9){ // if value is or between 1 and 9
						array[i][j]=value; // array gets that value
					}
					else
					{
						throw new IllegalArgumentException(); // Otherwise throws an illegal argument exception
					}
				}
			}
		}
		in.close(); // Closes the buffered reader
		}
		catch(IOException e){ // IOException being caught with a message
			System.out.println("file cannot be accessed");
		}
		Sudoku s = new Sudoku(array);
		return s;
	}
/**
 * Main method to try reading and printing to the screen the text files
 * and catches any IOExceptions or illegal arguments that might go in
 * @param args
 */
	public static void main(String[] args) {
		try {
		System.out.println(readSudoku("sudoku-ex1.txt"));
		}
		catch (IOException | IllegalArgumentException e) {

		}
	}

}
