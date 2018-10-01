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
		double starttime = System.currentTimeMillis(); //start time
		double p = 0; //percolation tipping point
		double percentPassed = 0;
		//Time timer = new Time((long) 0.0);
		
		Percolate2[] runners = new Percolate2[granularity];
		Thread[] thread = new Thread[threads];
		double threshOG = 1.00/(granularity-1); //the first threshold value used based on granularity
		double threshold = 0;
		
		for(int count = 0; count<runners.length; count++){
			runners[count] = new Percolate2(fluidType, gridSize, threshold);
			if(threshold>1)
				threshold=1;
			else 
				threshold = threshold + threshOG; //setting p to its next value
		}
		System.out.println(threshold);
 
		/*
		for(int count = 0; count < runs; count++){
			thread[count].start();
		}
		
		for(Thread tr : thread){
				tr.join();
		}*/
		
		for(int count = runners.length-1; count>=0; count--){
			runners[count].run();
			percentPassed = (runners[count].getTotalPassed())/runs;
			if(percentPassed>=0.5){
				p = runners[count].getP();
				break;
			}
		}
		System.out.println(percentPassed);
		double endtime = System.currentTimeMillis(); //end time
		System.out.println("Percolation tipping point p = " + p);
		System.out.println("Elapsed Time = " + (endtime - starttime) / 1000);
	}

}