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
	protected DSLinkedQueue<Student> students;//students being helped and are not in waiting room
	protected DSLinkedQueue<Student> waiting1000s;
	protected DSLinkedQueue<Student> waiting2000s;
	protected DSLinkedQueue<Student> waiting3000s;
	protected DSLinkedQueue<Student> waiting4000s;
	protected final int MAXWAITING = 3;//maximum number in a waiting list

	public HelpDesk() {
		log = new DSLinkedQueue(); // queues and simulation time are initialized
		students = new DSLinkedQueue();
		waiting1000s = new DSLinkedQueue();
		waiting2000s = new DSLinkedQueue();
		waiting3000s = new DSLinkedQueue();
		waiting4000s = new DSLinkedQueue();
		simtime = 0;
	}

	public void step() { // students in the queues are marked as finished
		if (students.isEmpty() == false && students.front.getData().w > 0) {//if a student is still being helped
			Student stud2 = new Student(students.front.getData().n, students.front.getData().c,
					students.front.getData().w - 1);
			students.dequeue();
			students.enqueue(stud2);
		}
		if (students.isEmpty() == false && students.front.getData().w == 0) {//if a student is finished being helped
			log.enqueue("Time " + (simtime + 1) + "," + " Finished helping " + students.front.getData().n + " from COSC"
					+ students.front.getData().c);
			students.dequeue();
		}
		if (students.isEmpty()) {//if no students are left to be helped the waiting queues are checked
			Student stud3 = null;
			if (!waiting1000s.isEmpty()) {
				stud3 = waiting1000s.dequeue();
			} else if (!waiting2000s.isEmpty()) {
				stud3 = waiting2000s.dequeue();
			} else if (!waiting3000s.isEmpty()) {
				stud3 = waiting3000s.dequeue();
			} else if (!waiting4000s.isEmpty()) {
				stud3 = waiting4000s.dequeue();
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
		} else if (!students.isEmpty()) {//if empty the student is added to one of the waiting queues
			boolean enqueued = false;//variable to check if student is enqueued
			if (stud.c < 2000 && waiting1000s.size() < MAXWAITING) {
				waiting1000s.enqueue(stud);
				enqueued = true;
			} else if (stud.c < 3000 && waiting2000s.size() < MAXWAITING) {
				waiting2000s.enqueue(stud);
				enqueued = true;
			} else if (stud.c < 4000 && waiting3000s.size() < MAXWAITING) {
				waiting3000s.enqueue(stud);
				enqueued = true;
			} else if (stud.c < 5000 && waiting4000s.size() < MAXWAITING) {
				waiting4000s.enqueue(stud);
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
