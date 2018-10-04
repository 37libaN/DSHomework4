/**
 * COSC 2100 - Project 5
 * Explain briefly the functionality of the class.
 * @author [Vishnu Appalaraju, Nabil Hussaini]
 * Instructor [Dr. Brylow] 
 * TA-BOT:MAILTO [srivishnu.appalaraju@marquette.edu nabil.hussaini@marquette.edu] 
 */
package percolationProject;

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
		double starttime = System.currentTimeMillis(); // start time
		double p = 0; // percolation tipping point
		double percentPassed = 0;

		Percolate2[] runners = new Percolate2[granularity];
		Thread[] thread = new Thread[threads];
		Percolate2[] splitRunners = new Percolate2[(granularity / threads) + 1];
		double threshOG = 1.00 / (granularity - 1); // the first threshold value
													// used based on granularity
		double threshold = 0;

		for (int count = 0; count < runners.length; count++) {
			if (threshold > 1)
				threshold = 1;
			runners[count] = new Percolate2(fluidType, gridSize, threshold);
			System.out.println(threshold);
			threshold = threshold + threshOG; // setting p to its next value
		}

		int count = 0;
		for (int i = 0; i < thread.length; i++) {
			for (int j = 0; j < splitRunners.length; j++) {
				if (count >= runners.length)
					break;
				splitRunners[j] = runners[count];
				count++;
				if(j==0)
					System.out.println(splitRunners[j].getP());
				if(j==2)
					System.out.println("Hi");
			}
			thread[i] = new Thread(new PercolateThreads(splitRunners));
		}

		for (int count2 = 0; count2 < thread.length; count2++) {
			thread[count2].start();
		}

		for (int count2 = 0; count2 < thread.length; count2++) {
			thread[count2].join();
		}

		for (int count2 = runners.length - 1; count2 >= 0; count2--) {
			System.out.println(runners[count2].getP());
			System.out.println(runners[count2].getTotalPassed());
			percentPassed = ((double) (runners[count2].getTotalPassed())) / ((double) runs);
			if (percentPassed >= 0.5) {
				p = runners[count].getP();
				break;
			}
		}

		double endtime = System.currentTimeMillis(); // end time
		System.out.println("Percolation tipping point p = " + p);
		System.out.println("Elapsed Time = " + (endtime - starttime) / 1000);
	}

}