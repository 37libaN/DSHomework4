/**
 * COSC 2100 - Project 4
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
	public RandomGrid(int n, double p) {
		Random random = new Random();
		if(n<1){
			//default grid size
			n=1;
		}
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
	
	public int getValue(int row, int col) {
		return randomgrid[row][col];
	}
	
	public void setValue(int row, int col, int value) {
		if(value>=0)
			randomgrid[row][col] = value;
		//not changed if given bad data
	}

	public int getSize() {
		return randomgrid.length;
	}

	public String toString() {
		String toString = "";
		for(int i = 0; i<randomgrid.length; i++){
			for(int j = 0; j<randomgrid[i].length; j++){
				if(randomgrid[i][j]==0)
					toString+= "  ";
				else if(randomgrid[i][j]==1)
					toString+= "X ";
				else if(randomgrid[i][j] != 1 && randomgrid[i][j] != 0)
					toString+= "* ";
			}
			toString+="\n";
		}
		return toString;
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		if(n < 0) {
			System.out.println("ERROR: n must be positive.");
			System.exit(0);
		}
		if(n == 0) {
			System.out.println();
			System.exit(0);
		}
		double p = input.nextDouble();
		if(p < 0 || p > 1) {
			System.out.println("ERROR: p must be between 0 and 1 inclusive.");
			System.exit(0);
		}
		RandomGrid grid = new RandomGrid(n, p);
		System.out.println(grid.toString());
	}

}
