package percolationProject;

import java.sql.Time;
import java.util.Scanner;

public class PercRunner {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int gridSize = input.nextInt();
		int runs = input.nextInt();
		int granularity = input.nextInt();
		int threads = input.nextInt();
		int fluidType = input.nextInt();
		double p = 0; //percolation tipping point
		//Time timer = new Time((long) 0.0);
		double t = 0; //time
		Percolate2[] runners = new Percolate2[granularity];
		Thread[] thread = new Thread[granularity];
		double threshOG = 1.00/granularity; //the first threshold value used based on granularity
		double threshold = threshOG;
		for(int count = 0; count<runners.length; count++){
			runners[count] = new Percolate2(fluidType, gridSize, threshold);
			thread[count] = new Thread(runners[count]);
			threshold = threshold + threshOG; //setting p to its next value
		}
		for(Thread tr : thread){
			tr.start();
		}
		for(Thread tr : thread){
			tr.join();
		}
	}

}
