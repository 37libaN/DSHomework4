
public class DSArrayBoundedQueue<T> implements DSQueueInterface<T>
{
	  protected final int DEFCAP = 100;
	  protected T[] elements;
	  protected int numElements = 0;
	  protected int front = 0;
	  protected int rear;
	  
	  public DSArrayBoundedQueue()
	  {
	    elements = (T[]) new Object[DEFCAP];
	    rear = DEFCAP - 1;
	  }
	  
	  public DSArrayBoundedQueue(int size)
	  {
	    elements = (T[]) new Object[size];
	    rear = size - 1;
	  }
	  
	  public void enqueue(T element)
	  {
	    if (isFull())
	      throw new DSQueueOverflowException("Enqueue attempted on a full queue!");
	    else
	    {
	      rear = (rear + 1) % elements.length;
	      elements[rear] = element;
	      numElements++;
	    }
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
	    return (numElements == elements.length);
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
