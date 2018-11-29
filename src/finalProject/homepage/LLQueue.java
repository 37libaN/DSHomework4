package finalProject.homepage;

public class LLQueue<T> {
	private Node<T> back; //node at end of list 
	private Node<T> front; //node at front of list 
	private int numElements; //number of elements in queue 
	public LLQueue() { 
		back = null;  
		front = null; 
		numElements = 0; 
	} 
	public boolean isEmpty(){ //returns true if empty, false if not  
		if (numElements == 0) 
			return true; 
		return false; 
	}  
	public void enqueue(T element){ //adds an element to back of list 
		if(isEmpty()) { 
			front = new Node<T>(element); 
			back = front; 
			numElements++; 
			return; 
		}	 
		back.setLink(new Node<T>(element)); 
		back = back.getLink(); 
		numElements++; 
	} 
	public T dequeue() {//returns the element at the front of list 
		if(!isEmpty()) { 
			T element = front.getInfo(); 
			front = front.getLink(); 
			if(front == null) 
				back = null; 
			numElements--; 
			return element; 
		} 
		return null; 
	} 
	public int size() { 
		return numElements; 
	}

}
