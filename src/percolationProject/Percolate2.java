/**
 * COSC 2100 - Project 5
 * Explain briefly the functionality of the class.
 * @author [Vishnu Appalaraju, Nabil Hussaini]
 * Instructor [Dr. Brylow] 
 * TA-BOT:MAILTO [srivishnu.appalaraju@marquette.edu nabil.hussaini@marquette.edu] 
 */
package percolationProject;

import java.util.*;


public class Percolate2{

	private int fluidType, gridSize, totalPassed;
	private double p;
	
	public Percolate2(int fluidType, int gridSize, double p){
		this.fluidType = fluidType;
		this.gridSize = gridSize;
		this.p = p;
		totalPassed = 0;
	}
	
	public synchronized void percolateFluidType1(int r, int c, RandomGrid g) { // percolates vertically
																	
		if (g.getValue(r, c) == 0) {
			g.setValue(r, c, 2);
		}
		if (!(r + 1 > (g.getSize() - 1))) {
			if (g.getValue(r + 1, c) == 0)
				percolateFluidType1(r + 1, c, g);
		}
		if (r - 1 >= 0) {
			if (g.getValue(r - 1, c) == 0)
				percolateFluidType1(r - 1, c, g);
		}
		return;
	}

	public synchronized void percolateFluidType2(int r, int c, RandomGrid g) { // percolates horizontally and vertically																	
		
		if (g.getValue(r, c) == 0) {
			g.setValue(r, c, 2);
		}

		if (!(c + 1 > (g.getSize() - 1))) {
			if (g.getValue(r, c + 1) == 0)
				percolateFluidType2(r, c + 1, g);
		}
		if (!(r + 1 > (g.getSize() - 1))) {
			if (g.getValue(r + 1, c) == 0)
				percolateFluidType2(r + 1, c, g);
		}
		if (c - 1 >= 0) {
			if (g.getValue(r, c - 1) == 0)
				percolateFluidType2(r, c - 1, g);
		}
		if (r - 1 >= 0) {
			if (g.getValue(r - 1, c) == 0)
				percolateFluidType2(r - 1, c, g);
		}
		return;
	}

	public synchronized void percolateFluidType3(int r, int c, RandomGrid g) { //percolates vertically, horizontally, and diagonally																
		
		if (g.getValue(r, c) == 0) {
			g.setValue(r, c, 2);
		}
		
		if (!(c + 1 > (g.getSize() - 1))) {
			if (g.getValue(r, c + 1) == 0)
				percolateFluidType3(r, c + 1, g);
		}
		if (!(r + 1 > (g.getSize() - 1))) {
			if (g.getValue(r + 1, c) == 0)
				percolateFluidType3(r + 1, c, g);
		}
		if (c - 1 >= 0) {
			if (g.getValue(r, c - 1) == 0)
				percolateFluidType3(r, c - 1, g);
		}
		if (r - 1 >= 0) {
			if (g.getValue(r - 1, c) == 0)
				percolateFluidType3(r - 1, c, g);
		}	
		
		//diagonals
		if (!(c + 1 > (g.getSize() - 1)) && !(r + 1 > (g.getSize() - 1))) {
			if (g.getValue(r + 1, c + 1) == 0)
				percolateFluidType3(r + 1, c + 1, g);
		}
		if (!(c + 1 > (g.getSize() - 1)) && (r - 1 >= 0)) {
			if (g.getValue(r - 1, c + 1) == 0)
				percolateFluidType3(r - 1, c + 1, g);
		}
		if ((c - 1 >= 0) && !(r + 1 > (g.getSize() - 1))) {
			if (g.getValue(r + 1, c - 1) == 0)
				percolateFluidType3(r + 1, c - 1, g);
		}
		if ((c - 1 >= 0) && (r - 1 >= 0)) {
			if (g.getValue(r - 1, c - 1) == 0)
				percolateFluidType3(r - 1, c - 1, g);
		}	
		return;
	}
	public synchronized void runPercolate() {
		RandomGrid rg = new RandomGrid(gridSize, p);
		if(fluidType == 1){
			for(int j = 0; j < rg.getSize(); j++){ //begins to percolate through array if fluid type is 1
				if(rg.getValue(0, j)==0){
					percolateFluidType1(0, j, rg); 		
				}
			}
		}
		
		else if(fluidType == 2){
			for(int j = 0; j < rg.getSize(); j++){ //begins to percolate through array if fluid type is 2
				if(rg.getValue(0, j)==0){
					percolateFluidType2(0, j, rg); 		
				}
			}
		}
		else if(fluidType == 3){
			for(int j = 0; j < rg.getSize(); j++){ //begins to percolate through array if fluid type is 3
				if(rg.getValue(0, j)==0){
					percolateFluidType3(0, j, rg); 		
				}
			}
		}
		boolean percolated = false;
		for (int i = 0; i < rg.getSize(); i++) {
			if (rg.getValue(rg.getSize()-1, i) != 0 && rg.getValue(rg.getSize()-1, i) != 1) {
				percolated = true;
				break;
			}
		}
		if(percolated){
			totalPassed++;
		}
	}
	
	public synchronized int getTotalPassed(){ // returning total passed tests
		return totalPassed;
	}
	
	public synchronized double getP(){ //returning threshold
		return p;
	}
}
