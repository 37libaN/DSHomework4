/**
 * COSC 2100 - Project 5
 * Explain briefly the functionality of the class.
 * @author [Vishnu Appalaraju, Nabil Hussaini]
 * Instructor [Dr. Brylow] 
 * TA-BOT:MAILTO [srivishnu.appalaraju@marquette.edu nabil.hussaini@marquette.edu] 
 */
package percolationProject;

public class PercolateThreads implements Runnable {

	private Percolate2[] percolateTests;
	private int runs;

	public PercolateThreads(Percolate2[] percolateTests, int runs) { //constructor
		this.percolateTests = percolateTests;
		this.runs = runs;
	}

	@Override
	public synchronized void run() { // runs the percolate tests
		// TODO Auto-generated method stub
		for (int countRuns = 0; countRuns < runs; countRuns++) {
			for (int count = 0; count < percolateTests.length; count++) {
				if (percolateTests[count] != null) {
					percolateTests[count].runPercolate();
				}
			}
		}
	}
}
