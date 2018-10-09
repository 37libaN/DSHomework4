package helpDesk;

public interface DSQueueInterface<T>
{
	  void enqueue(T element) throws DSQueueOverflowException;
	  // Adds an element to the end of the queue.
	  
	  T dequeue() throws DSQueueUnderflowException;
	  // Remove an element from the front of the queue.
	  
	  boolean isFull();
	  
	  boolean isEmpty();
	  
	  int size();
	  // Returns number of elements currently stored in the queue.

	}	