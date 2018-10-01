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
		double starttime = System.currentTimeMillis(); //start time
		double p = 0; //percolation tipping point
		//Time timer = new Time((long) 0.0);
		
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
		double endtime = System.currentTimeMillis(); //end time
		System.out.println("Percolation tipping point p = "+p);
		System.out.println("Elapsed Time = "+(endtime-starttime)/1000);
	}

}
