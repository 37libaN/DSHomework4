package finalProject.homepage; 
 
public class SortedLinkedList<T> { 
	private Node<T> list; //1st node in list 
	private Node<T> loc; //where you are in list when going through it 
	private Node<T> prev; //one node before loc, null if loc is first element 
	private Node<T> foundNode; //node that is found by find 
	private int numElements; //number of elements in list 
	public SortedLinkedList(){  
		list = null;  
		loc = null;  
		prev = null;  
		numElements = 0; 
	}  
	public boolean isEmpty(){ //returns true if empty, false if not  
		if (numElements == 0) 
			return true;
		return false;
	} 
	public void add(T element){ //adds an element into its sorted position in list, sorted by ascending 
		reset(); 
		T currElement; //current element used for comparisons 
		if(loc == null) 
			return; 
		while(loc!=null){ 
			currElement = loc.getInfo(); 
			if(!(((Comparable) element).compareTo(currElement)<0)){  
				step(); //keep going through list until element to add is less than currElement 
			}	 
			else 
				break;		 
		} 
		Node<T> toAdd = new Node<T>(element); 
		if(prev == null){//if new node should be first Node 
			toAdd.setLink(list); 
			list = toAdd; 
		} 
		else{//inserts new node somewhere else in list 
			toAdd.setLink(loc); 
			prev.setLink(toAdd); 
		} 
		numElements++; 
	} 
	public Node<T> getNode(){ //returns loc 
		return loc; 
	} 
	public void step(){ //advances loc by one element 
		prev = loc; 
		loc = loc.getLink(); 
	} 
	public void reset(){ //resets loc to first element 
		loc = list; 
		prev = null; 
	} 
	public Node<T> getFoundNode(){ 
		return foundNode; 
	} 
	public boolean find(Object toFind){ 
		reset(); 
		while(loc!=null){ 
			/*if(((Fragment)((Node<T>)((SortedLinkedList<T>) this.list.getInfo()).list).getInfo()).getID()==toFind.getID()){ 
				foundNode = loc; 
				return true; 
			} 
			*/
			step();
		} 
		return false; 
	} 
	public int size() { 
		return numElements; 
	}  
} 
