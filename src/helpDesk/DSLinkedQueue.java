/**
	 * COSC 2100 - Project 6
	 * A program simulating a helpdesk for students; this time it implements a waiting area as well.
	 * @author [Vishnu Appalaraju, Nabil Hussaini]
	 * Instructor [Dr. Brylow] 
	 * TA-BOT:MAILTO [srivishnu.appalaraju@marquette.edu nabil.hussaini@marquette.edu] 
	 */
public class DSLinkedQueue<T> implements DSQueueInterface<T> 
{
	  protected DSLLNode<T> front;
	  protected DSLLNode<T> rear;
	  protected int numElements = 0;
	  
	  public DSLinkedQueue()
	  {
	    front = null;
	    rear  = null;
	  }
	  
	  public void enqueue(T element)
	  {
	    DSLLNode<T> newNode = new DSLLNode<T>(element);
	    if (rear == null)
	      front = newNode;
	    else
	      rear.setNext(newNode);
	    rear = newNode;
	    numElements++;
	  }
	  
	  public T dequeue() throws DSQueueUnderflowException
	  {
	    if (isEmpty()) throw new DSQueueUnderflowException("Dequeue attemped on empty queue!");
	    else
	    {
	      T element;
	      element = front.getData();
	      front = front.getNext();
	      if (front == null)
	        rear = null;
	      numElements--;
	      return element;
	    }
	  }
	  
	  public boolean isEmpty()
	  {
	    if (front == null)
	      return true;
	    else
	      return false;
	  }
	  
	  public boolean isFull()
	  {
	    return false;
	  }
	  
	  public int size()
	  {
	    return numElements;
	  }
	}