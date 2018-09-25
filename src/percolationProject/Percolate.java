/**
 * COSC 2100 - Project 4
 * Explain briefly the functionality of the class.
 * @author [Vishnu Appalaraju, Nabil Hussaini]
 * Instructor [Dr. Brylow] 
 * TA-BOT:MAILTO [srivishnu.appalaraju@marquette.edu nabil.hussaini@marquette.edu] 
 */
package percolationProject;

import java.util.*;

public class Percolate {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String theinput = input.nextLine();
		String valueN = theinput.substring(0, theinput.indexOf(" "));
		int n = Integer.parseInt(valueN);
		String valueP = theinput.substring(theinput.indexOf(" ") + 1);
		double p = Double.parseDouble(valueP);
		RandomGrid rg = new RandomGrid(n, p);
		
		for(int j = 0; j < rg.getSize(); j++){ 
			if(rg.getValue(0, j)==0){
				

				percolate(0, j, rg); 
				
			}
			} 		
		int lastRow = rg.getSize() - 1;
		boolean percolated = false;
			for (int i = 0; i < rg.getSize(); i++) {
				if (rg.getValue(lastRow, i) > 1) {
					percolated = true;
				}
			}
		
		System.out.println(rg.toString());
		System.out.println("Percolated = " + percolated);
	}

	public static void percolate(int r, int c, RandomGrid g) {
		if (g.getValue(r, c) == 0) {
			g.setValue(r, c, 2);
		}
		
		if (c + 1 >= 0 && !(c + 1 > (g.getSize() - 1))) {
			if (g.getValue(r, c + 1) == 0)
				percolate(r, c + 1, g);
		}
		if (r + 1 >= 0 && !(r + 1 > (g.getSize() - 1))) {
			if (g.getValue(r + 1, c) == 0)
				percolate(r + 1, c, g);
		}
		if (c - 1 >= 0 && !(c - 1 > (g.getSize() - 1))) {
			if (g.getValue(r, c - 1) == 0)
				percolate(r, c - 1, g);
		}
		if (r - 1 >= 0 && !(r - 1 > (g.getSize() - 1))) {
			if (g.getValue(r - 1, c) == 0)
				percolate(r - 1, c, g);
		}	
		return;
	}
}
