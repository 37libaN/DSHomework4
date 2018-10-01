/**
 * COSC 2100 - Project 5
 * Explain briefly the functionality of the class.
 * @author [Vishnu Appalaraju, Nabil Hussaini]
 * Instructor [Dr. Brylow] 
 * TA-BOT:MAILTO [srivishnu.appalaraju@marquette.edu nabil.hussaini@marquette.edu] 
 */
package percolationProject;
import java.util.*;
public class RandomGrid {
	private int[][] randomgrid;
	private double rannum;
	public RandomGrid(int n, double p) { //constructs randomgrid objects
		Random random = new Random();
		randomgrid = new int[n][n];		
		for(int r = 0; r < randomgrid.length; r++) {
			for(int c = 0; c < randomgrid[r].length; c++) {
				rannum = random.nextDouble();
				if(rannum <= p) {
					randomgrid[r][c] = 1;
				}
				else {
					randomgrid[r][c] = 0;
				}
			}
		}
	}
	
	public int getValue(int row, int col) { //gets value at a specific location
		return randomgrid[row][col];
	}
	
	public void setValue(int row, int col, int value) { //sets value at a specific location
		if(value>=0)
			randomgrid[row][col] = value;
	}

	public int getSize() { //gets size of array
		return randomgrid.length;
	}

	public String toString() { //outputs array
		String toString = "";
		for(int i = 0; i<randomgrid.length; i++){
			for(int j = 0; j<randomgrid[i].length; j++){
				if(randomgrid[i][j]==0)
					toString+= "  ";
				else if(randomgrid[i][j]==1)
					toString+= "X ";
				else
					toString+= "* ";
			}
			toString+="\n";
		}
		return toString;
	}

	public static void main(String[] args) { //main method to test RandomGrid
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		if(n < 0) {
			System.out.println("ERROR: n must be positive.");
			System.exit(0);
		}
		/*if(n == 0) {
			System.out.println();
			System.exit(0);
		}*/
		double p = input.nextDouble();
		if(p < 0 || p > 1) {
			System.out.println("ERROR: p must be between 0 and 1 inclusive.");
			System.exit(0);
		}
		RandomGrid grid = new RandomGrid(n, p);
		System.out.println(grid.toString());
	}

}
