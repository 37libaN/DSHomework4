/**
	 * COSC 2100 - Project 6
	 * A program simulating a helpdesk for students; this time it implements a waiting area as well.
	 * @author [Vishnu Appalaraju, Nabil Hussaini]
	 * Instructor [Dr. Brylow] 
	 * TA-BOT:MAILTO [srivishnu.appalaraju@marquette.edu nabil.hussaini@marquette.edu] 
	 */
package helpDesk;
public class DSArrayQueue<T> implements DSQueueInterface<T>
{
	  protected final int DEFCAP = 100;
	  protected T[] elements;
	  protected int numElements = 0;
	  protected int front = 0;
	  protected int rear;
	  
	  public DSArrayQueue()
	  {
	    elements = (T[]) new Object[DEFCAP];
	    rear = DEFCAP - 1;
	  }
	  
	  public DSArrayQueue(int size)
	  {
	    elements = (T[]) new Object[size];
	    rear = size - 1;
	  }
	  
	  private void grow()
	  {
	     T[] larger = (T[]) new Object[elements.length * 2];
	     
	     // Copy over contents of old array to new array.
	     int currSmaller = front;
	     for (int currLarger = 0; currLarger <  numElements; currLarger++)
	     {
	       larger[currLarger] = elements[currSmaller];
	       currSmaller = (currSmaller + 1) % elements.length;
	     }
	     elements = larger;
	     // fix front and rear pointer
	     front = 0;
	     rear = numElements - 1;
	  }
	  
	  public void enqueue(T element)
	  {
	    if (numElements == elements.length)
	    {
	      // Makes array 'elements' bigger.
	      grow();
	    }
	      
	    rear = (rear + 1) % elements.length;
	    elements[rear] = element;
	    numElements++;
	  }
	  
	  public T dequeue()
	  {
	    if (isEmpty())
	      throw new DSQueueUnderflowException("Dequeue attempted on empty space!");
	    else
	    {
	      T toReturn = elements[front];
	      elements[front] = null;
	      front = (front + 1) % elements.length;
	      numElements--;
	      return toReturn;
	    }
	  }
	  
	  public boolean isFull()
	  {
	    return false;
	  }
	  
	  public boolean isEmpty()
	  {
	    return (numElements == 0);
	  }
	  
	  public int size()
	  {
	    return numElements;
	  }
} 
