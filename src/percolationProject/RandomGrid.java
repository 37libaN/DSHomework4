package percolationProject;
import java.util.*;
public class RandomGrid {
	private int[][] randomgrid;
	private int rannum;
	public RandomGrid(int n, double p) {
		Random random = new Random();
		randomgrid = new int[n][n];
		for(int r = 0; r < randomgrid.length; r++) {
			for(int c = 0; c < randomgrid[n].length; c++) {
				rannum = random.nextInt();
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
		randomgrid[row][col] = value;
	}

	public int getSize() {
		return randomgrid.length;
	}

	public String toString() {
		
	}

	public static void main(String[] args) {
		
	}

}
