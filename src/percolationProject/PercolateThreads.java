package percolationProject;

public class PercolateThreads implements Runnable {

	private Percolate2[] percolateTests;
	private int runs;

	public PercolateThreads(Percolate2[] percolateTests, int runs) {
		this.percolateTests = percolateTests;
		this.runs = runs;
	}

	/*
	 * public Percolate2 getPercolate(int index) { return percolateTests[index];
	 * }
	 */

	@Override
	public synchronized void run() {
		// TODO Auto-generated method stub
		for (int countRuns = 0; countRuns < runs; countRuns++) {
			for (int count = 0; count < percolateTests.length; count++) {
				if (percolateTests[count] != null) {
					percolateTests[count].runPercolate();
					System.out.println(percolateTests[count].getP());
				}
			}
		}
	}
}
