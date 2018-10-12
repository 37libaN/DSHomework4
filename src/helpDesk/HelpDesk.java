/**
	 * COSC 2100 - Project 6
	 * A program simulating a helpdesk for students; this time it implements a waiting area as well.
	 * @author [Vishnu Appalaraju, Nabil Hussaini]
	 * Instructor [Dr. Brylow] 
	 * TA-BOT:MAILTO [srivishnu.appalaraju@marquette.edu nabil.hussaini@marquette.edu] 
	 */


import java.util.*;

public class HelpDesk<T> {
	protected int simtime; // simulation time is declared
	protected DSLinkedQueue log; // the two queues are declared, one for the log
									// and one for students
	protected DSLinkedQueue<Student> students;
	protected DSLinkedQueue<Student> waiting1020;
	protected DSLinkedQueue<Student> waiting2010;
	protected DSLinkedQueue<Student> waiting3100;
	protected DSLinkedQueue<Student> waiting4300;
	protected final int MAXWAITING = 3;

	public HelpDesk() {
		log = new DSLinkedQueue(); // queues and simulation time are initialized
		students = new DSLinkedQueue();
		waiting1020 = new DSLinkedQueue();
		waiting2010 = new DSLinkedQueue();
		waiting3100 = new DSLinkedQueue();
		waiting4300 = new DSLinkedQueue();
		simtime = 0;
	}

	public void step() { // students in the queues are marked as finished
		if (students.isEmpty() == false && students.front.getData().w > 0) {
			Student stud2 = new Student(students.front.getData().n, students.front.getData().c,
					students.front.getData().w - 1);
			students.dequeue();
			students.enqueue(stud2);
		}
		if (students.isEmpty() == false && students.front.getData().w == 0) {
			log.enqueue("Time " + (simtime + 1) + "," + " Finished helping " + students.front.getData().n + " from COSC"
					+ students.front.getData().c);
			students.dequeue();
		}
		if (students.isEmpty()) {
			Student stud3 = null;
			if (!waiting1020.isEmpty()) {
				stud3 = waiting1020.dequeue();
			} else if (!waiting2010.isEmpty()) {
				stud3 = waiting2010.dequeue();
			} else if (!waiting3100.isEmpty()) {
				stud3 = waiting3100.dequeue();
			} else if (!waiting4300.isEmpty()) {
				stud3 = waiting4300.dequeue();
			}
			if (stud3 != null) {
				students.enqueue(stud3);
				log.enqueue("Time " + (simtime + 1) + "," + " Started helping " + students.front.getData().n + " from COSC"
						+ students.front.getData().c);
			}
		}
		simtime++;
	}

	public void addStudent(String name, int course, int workload) { // students
																	// are added
																	// to the
																	// queue
																	// based on
																	// course
																	// and are
																	// helped or
																	// sent to
																	// the
																	// waiting
																	// room
		Student stud = new Student(name, course, workload);
		if (students.isEmpty()) {
			students.enqueue(stud);
			log.enqueue("Time " + simtime + "," + " Started helping " + students.front.getData().n + " from COSC"
					+ students.front.getData().c);
		} else if (!students.isEmpty()) {
			boolean enqueued = false;
			if (stud.c == 1020 && waiting1020.size() < MAXWAITING) {
				waiting1020.enqueue(stud);
				enqueued = true;
			} else if (stud.c <= 2010 && waiting2010.size() < MAXWAITING) {
				waiting2010.enqueue(stud);
				enqueued = true;
			} else if (stud.c <= 3100 && waiting3100.size() < MAXWAITING) {
				waiting3100.enqueue(stud);
				enqueued = true;
			} else if (stud.c <= 4300 && waiting4300.size() < MAXWAITING) {
				waiting4300.enqueue(stud);
				enqueued = true;
			}
			if (enqueued)
				log.enqueue("Time " + (simtime) + "," + " Queued " + stud.n + " from COSC" + stud.c);
			else
				log.enqueue("Time " + (simtime) + "," + " Turned away " + stud.n + " from COSC" + stud.c);
		}

	}

	public int getTime() { // simulation time is returned
		return simtime;
	}

	public String toString() { // the current state of the helpdesk is returned
								// as a String
		if (students.isEmpty()) {
			return "Time " + simtime + ", IDLE";
		} else {
			return "Time " + simtime + ", Helping " + students.front.getData().n + " from COSC"
					+ students.front.getData().c;
		}
	}

	public String getLog() { // the log is returned as a String
		String logOut = "";
		while (!log.isEmpty()) {
			logOut += log.front.getData() + "\n";
			log.dequeue();
		}
		return logOut;
	}
}

class Student { // the student class contains constructors to initialize student
				// objects
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
