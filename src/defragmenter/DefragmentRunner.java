/**
	 * COSC 2100 - Project 7
	 * This program simulates the fragmentation of packets of information sent over the internet.
	 * @author [Vishnu Appalaraju, Nabil Hussaini]
	 * Instructor [Dr. Brylow] 
	 * TA-BOT:MAILTO [srivishnu.appalaraju@marquette.edu nabil.hussaini@marquette.edu] 
	 */

package defragmenter;
import java.util.Scanner;

public class DefragmentRunner
{
	public static void main(String[] args)
	{
		Scanner tokenizer = new Scanner(System.in);
		String throwout = tokenizer.nextLine();
		int id, froff, length, mf;
		boolean morefrag;

		Defragment defrag = new Defragment();

		while (tokenizer.hasNext())
		{
			id      = tokenizer.nextInt();
			froff   = tokenizer.nextInt();
			length  = tokenizer.nextInt();
			mf      = tokenizer.nextInt();
			if (mf == 1)
				morefrag = true;
			else
				morefrag = false;

			defrag.addFrag(id, froff, length, morefrag);
		}
		System.out.println("hi");
		System.out.println(defrag);
	}
}