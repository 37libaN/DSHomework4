/**
 * COSC 2100 - Project 4
 * Explain briefly the functionality of the class.
 * @author [Vishnu Appalaraju, Nabil Hussaini]
 * Instructor [Dr. Brylow] 
 * TA-BOT:MAILTO [srivishnu.appalaraju@marquette.edu nabil.hussaini@marquette.edu] 
 */
package percolationProject;

import java.util.*;

public class Percolate2 {

	public void percolateFluidType1(int r, int c, RandomGrid g) { // percolates vertically
																	
		if (g.getValue(r, c) == 0) {
			g.setValue(r, c, 2);
		}
		if (!(r + 1 > (g.getSize() - 1))) {
			if (g.getValue(r + 1, c) == 0)
				percolate(r + 1, c, g);
		}
		if (r - 1 >= 0) {
			if (g.getValue(r - 1, c) == 0)
				percolate(r - 1, c, g);
		}
		return;
	}

	public void percolateFluidType2(int r, int c, RandomGrid g) { // percolates horizontally and vertically																	
		
		if (g.getValue(r, c) == 0) {
			g.setValue(r, c, 2);
		}

		if (!(c + 1 > (g.getSize() - 1))) {
			if (g.getValue(r, c + 1) == 0)
				percolate(r, c + 1, g);
		}
		if (!(r + 1 > (g.getSize() - 1))) {
			if (g.getValue(r + 1, c) == 0)
				percolate(r + 1, c, g);
		}
		if (c - 1 >= 0) {
			if (g.getValue(r, c - 1) == 0)
				percolate(r, c - 1, g);
		}
		if (r - 1 >= 0) {
			if (g.getValue(r - 1, c) == 0)
				percolate(r - 1, c, g);
		}
		return;
	}

	public void percolateFluidType3(int r, int c, RandomGrid g) { //percolates vertically, horizontally, and diagonally																
		
		if (g.getValue(r, c) == 0) {
			g.setValue(r, c, 2);
		}
		
		if (!(c + 1 > (g.getSize() - 1))) {
			if (g.getValue(r, c + 1) == 0)
				percolate(r, c + 1, g);
		}
		if (!(r + 1 > (g.getSize() - 1))) {
			if (g.getValue(r + 1, c) == 0)
				percolate(r + 1, c, g);
		}
		if (c - 1 >= 0) {
			if (g.getValue(r, c - 1) == 0)
				percolate(r, c - 1, g);
		}
		if (r - 1 >= 0) {
			if (g.getValue(r - 1, c) == 0)
				percolate(r - 1, c, g);
		}	
		
		//diagonals
		if (!(c + 1 > (g.getSize() - 1)) && !(r + 1 > (g.getSize() - 1))) {
			if (g.getValue(r + 1, c + 1) == 0)
				percolate(r + 1, c + 1, g);
		}
		if (!(c + 1 > (g.getSize() - 1)) && (r - 1 >= 0)) {
			if (g.getValue(r - 1, c + 1) == 0)
				percolate(r + 1, c, g);
		}
		if ((c - 1 >= 0) && !(r + 1 > (g.getSize() - 1))) {
			if (g.getValue(r + 1, c - 1) == 0)
				percolate(r + 1, c - 1, g);
		}
		if ((c - 1 >= 0) && (r - 1 >= 0)) {
			if (g.getValue(r - 1, c - 1) == 0)
				percolate(r - 1, c - 1, g);
		}	
		return;
	}

	public static void percolate(int r, int c, RandomGrid g) { // percolates
																// through array
		if (g.getValue(r, c) == 0) {
			g.setValue(r, c, 2);
		}

		if (!(c + 1 > (g.getSize() - 1))) {
			if (g.getValue(r, c + 1) == 0)
				percolate(r, c + 1, g);
		}
		if (!(r + 1 > (g.getSize() - 1))) {
			if (g.getValue(r + 1, c) == 0)
				percolate(r + 1, c, g);
		}
		if (c - 1 >= 0) {
			if (g.getValue(r, c - 1) == 0)
				percolate(r, c - 1, g);
		}
		if (r - 1 >= 0) {
			if (g.getValue(r - 1, c) == 0)
				percolate(r - 1, c, g);
		}
		return;
	}
}
