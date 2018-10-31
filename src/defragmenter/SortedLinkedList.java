/**
	 * COSC 2100 - Project 7
	 * This program simulates the fragmentation of packets of information sent over the internet.
	 * @author [Vishnu Appalaraju, Nabil Hussaini]
	 * Instructor [Dr. Brylow] 
	 * TA-BOT:MAILTO [srivishnu.appalaraju@marquette.edu nabil.hussaini@marquette.edu] 
	 */

package defragmenter;
public class SortedLinkedList<T> implements Comparable {
	private int numElements; // number of elements in list
	private Node<T> list; // 1st node in list
	private Node<T> loc; // where you are in list when going through it
	private Node<T> prev; // one node before loc, null if loc is first element
	private Node<T> foundNode; // node that is found by find

	public SortedLinkedList() {
		numElements = 0;
		list = null;
		loc = null;
		prev = null;
	}

	public boolean isEmpty() { // returns true if empty, false if not
		if (numElements == 0)
			return true;
		else
			return false;
	}

	public void add(T element) { // adds an element into its sorted position in
									// list, sorted by ascending
		//System.out.println("listAdd");
		reset();
		T currElement; // current element used for comparisons
		while (loc != null) {
			currElement = loc.getInfo();
			if (((Comparable) currElement).compareTo((Comparable) element) < 0) {
				step(); // keep going through list until element to add is less
						// than currElement
			} else
				break;
		}
		Node<T> toAdd = new Node<T>(element);
		if (prev == null) {// if new node should be first Node
			toAdd.setLink(list);
			list = toAdd;
		} else {// inserts new node somewhere else in list
			toAdd.setLink(loc);
			prev.setLink(toAdd);
		}
		numElements++;
	}

	public Node<T> getNode() { // returns loc
		return loc;
	}

	public void step() { // advances loc by one element
		prev = loc;
		loc = loc.getLink();
	}

	public void reset() { // resets loc to first element
		loc = list;
		prev = null;
	}

	public Node<T> getFoundNode() {
		return foundNode;
	}

	public boolean find(Fragment toFind) {
		foundNode = null;
		reset();
		//System.out.println("finding");
		while (loc != null) {
			if (((Fragment) ((Node<T>) ((SortedLinkedList<T>) loc.getInfo()).getList()).getInfo()).getID() == toFind.getID()) {
				foundNode = loc;
				return true;
			}
			step();
		}
		return false;
	}

	public Node<T> getList(){
		return list;
	}
	
	public Node<T> getPrev(){
		return prev;
	}
	
	@Override
	public int compareTo(Object listCompare) {
		if (((Fragment) getList().getInfo()).getID() < ((Fragment) ((SortedLinkedList<T>) listCompare).getList().getInfo()).getID())
			return -1;
		else if (((Fragment) getList().getInfo()).getID() == ((Fragment) ((SortedLinkedList<T>) listCompare).getList().getInfo()).getID())
			return 0;
		else
			return 1;
	}
}
