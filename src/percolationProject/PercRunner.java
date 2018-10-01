package percolationProject;

import java.util.Scanner;

public class PercRunner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int gridSize = input.nextInt();
		int runs = input.nextInt();
		int granularity = input.nextInt();
		int threads = input.nextInt();
		int fluidType = input.nextInt();
		Percolate2 perc = new Percolate2();
		perc.runPercolate(fluidType, gridSize, 0.5);
		perc.runPercolate(2, 5, 0.5);
		perc.runPercolate(3, 5, 0.5);
	}

}
