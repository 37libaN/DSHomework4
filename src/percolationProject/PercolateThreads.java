package percolationProject;

public class PercolateThreads implements Runnable {

	private Percolate2[] percolateTests;
	//private int[] p;
	//private int runs;
	//double firstVal, lastVal, gran;
	//static double p = 0;
	
	public PercolateThreads(Percolate2[] percolateTests){
		this.percolateTests = percolateTests;
		//this.firstVal = firstVal;
		//this.lastVal = lastVal;
	}
	
	public Percolate2 getPercolate(int index){
		return percolateTests[index];
	}
	
	@Override
	public synchronized void run() {
		// TODO Auto-generated method stub
		for(int count = 0; count < percolateTests.length; count++){
			if(percolateTests[count] == null){
				break;
			}
			percolateTests[count].runPercolate();
			System.out.println(percolateTests[count].getP());
		}
	}

}
