/**
	 * COSC 2100 - Project 6
	 * Explain briefly the functionality of the class.
	 * @author [Vishnu Appalaraju, Nabil Hussaini]
	 * Instructor [Dr. Brylow] 
	 * TA-BOT:MAILTO [srivishnu.appalaraju@marquette.edu nabil.hussaini@marquette.edu] 
	 */
package helpDesk;
import java.util.*;
public class HelpDesk<T> {
	    protected int simtime; //simulation time is declared
	    protected DSLinkedQueue log; //the two queues are declared, one for the log and one for students
	    protected DSLinkedQueue<Student> students;

	    public HelpDesk() {
	        log = new DSLinkedQueue(); //queues and simulation time are initialized
	        students = new DSLinkedQueue();
	        simtime = 0;
	    }

	    public void step() { //students in the queues are marked as finished
	        if (students.isEmpty() == false && students.front.getData().w > 0) {
	            Student stud2 = new Student(students.front.getData().n, students.front.getData().c, students.front.getData().w - 1);
	            students.dequeue();
	            students.enqueue(stud2);
	        }
	        if (students.isEmpty() == false && students.front.getData().w == 0) {
	            log.enqueue("Time " + (simtime + 1) + "," + " Finished helping " + students.front.getData().n + " from COSC"+ students.front.getData().c);
	            students.dequeue();
	        }
	        simtime++;
	    }

	    public void addStudent(String name, int course, int workload) { //students are added to the queue based on course and are helped or sent to the waiting room
	        Student stud = new Student(name, course, workload);
	        if (students.isEmpty()) {
	            students.enqueue(stud);
	            log.enqueue("Time " + simtime + "," + " Started helping " + students.front.getData().n + " from COSC" + students.front.getData().c);
	        }
	        if (!students.isEmpty() && course < students.front.getData().c) {
	            students.enqueue(stud);
	            log.enqueue("Time " + simtime + "," + " Started helping " + students.front.getData().n + " from COSC" + students.front.getData().c);
	        } else if (stud.c > students.front.getData().c) {
	            log.enqueue("Time " + (simtime) + "," + " Turned away " + stud.n + " from COSC" + stud.c);
	        }
	    }

	    public int getTime() { //simulation time is returned
	        return simtime;
	    }

	    public String toString() { //the current state of the helpdesk is returned as a String
	        if (students.isEmpty()) {
	            return "Time " + simtime + ", IDLE";
	        } else {
	            return "Time " + simtime + ", Helping " + students.front.getData().n + " from COSC" + students.front.getData().c;
	        }
	    }

	    public String getLog() { //the log is returned as a String
	        String logOut = "";
	        while (!log.isEmpty()) {
	            logOut += log.front.getData() + "\n";
	            log.dequeue();
	        }
	        return logOut;
	    }
	}

	class Student { //the student class contains constructors to initialize student objects
	    public String n;
	    public int c;
	    public int w;

	    public Student() {
	    }

	    public Student(String name, int course, int workload) {
	        n = name;
	        c = course;
	        w = workload;
	    }
	}
