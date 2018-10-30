/**
	 * COSC 2100 - Project 6
	 * A program simulating a helpdesk for students; this time it implements a waiting area as well.
	 * @author [Vishnu Appalaraju, Nabil Hussaini]
	 * Instructor [Dr. Brylow] 
	 * TA-BOT:MAILTO [srivishnu.appalaraju@marquette.edu nabil.hussaini@marquette.edu] 
	 */
package helpDesk;
import java.util.Scanner;

public class HelpDeskRunner 
{
	  public static void main(String[] args)
	  {
	    Scanner tokenizer = new Scanner(System.in);
	    
	    int rounds  = tokenizer.nextInt();
	    int time    = -1;
	    String name = null;
	    int course  = 0;
	    int work    = 0;
	    
	    HelpDesk hd = new HelpDesk();
	    
	    if (tokenizer.hasNext())
	    {
	      time    = tokenizer.nextInt();
	      name    = tokenizer.next();
	      course  = tokenizer.nextInt();
	      work    = tokenizer.nextInt();
	    }
	    
	    do
	    {
	      while (time == hd.getTime())
	      {
	        //System.out.println("Time " + time + ",\t" + name + " from COSC" + course + " for " + work + " minutes.");
	        hd.addStudent(name, course, work);
	        if (tokenizer.hasNext())
	        {
	          time    = tokenizer.nextInt();
	          name    = tokenizer.next();
	          course  = tokenizer.nextInt();
	          work    = tokenizer.nextInt();
	        }
	        else
	        {
	          time = -1;
	        }
	      }
	      
	      System.out.println(hd);
	      hd.step();
	    }
	    while (hd.getTime() < rounds);
	    
	    
	//   System.out.println("Time " + time + ",\t" + name + " from COSC" + course + " for " + work + " minutes.");
	    
	//  System.out.println("Rounds = " + rounds);
	    System.out.println();
	    System.out.println("LOG:");
	    System.out.println(hd.getLog()); 
	  }
	}
