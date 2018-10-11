/**
	 * COSC 2100 - Project 6
	 * A program simulating a helpdesk for students; this time it implements a waiting area as well.
	 * @author [Vishnu Appalaraju, Nabil Hussaini]
	 * Instructor [Dr. Brylow] 
	 * TA-BOT:MAILTO [srivishnu.appalaraju@marquette.edu nabil.hussaini@marquette.edu] 
	 */
import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
public class DSQueueTestRunner {

	  @Test(expected = DSQueueUnderflowException.class)
	  public void testDequeueException() 
	  {
	    DSArrayBoundedQueue<Integer> queue = new DSArrayBoundedQueue<Integer>();
	    queue.dequeue();
	  }
	  
	  @Test(expected = DSQueueOverflowException.class)
	  public void testEnqueueException() 
	  {
	    DSArrayBoundedQueue<Integer> queue = new DSArrayBoundedQueue<Integer>(1);
	    queue.enqueue(1);
	    queue.enqueue(2);
	  }
	  
	  @Test
	  public void testEnqueueDequeue0() {
	    DSArrayBoundedQueue<Integer> queue = new DSArrayBoundedQueue<Integer>();
	    try
	    {
	      queue.enqueue(5);
	      assertTrue(queue.dequeue() == 5);
	    }
	    catch (DSQueueOverflowException e)
	    {
	      fail(e.toString());
	    }
	    catch (DSQueueUnderflowException e)
	    {
	      fail(e.toString());
	    }
	  }
	  
	  @Test
	  public void testEnqueueDequeue1() {
	    DSArrayBoundedQueue<Integer> queue = new DSArrayBoundedQueue<Integer>();
	    try
	    {
	      queue.enqueue(5);
	      queue.enqueue(7);
	      queue.enqueue(6);
	      queue.enqueue(9);
	      
	      assertTrue(queue.dequeue() == 5);
	      assertTrue(queue.dequeue() == 7);
	      assertTrue(queue.dequeue() == 6);
	      assertTrue(queue.dequeue() == 9);
	    }
	    catch (DSQueueUnderflowException e)
	    {
	      fail(e.toString());
	    }
	    catch (DSQueueOverflowException e)
	    {
	      fail(e.toString());
	    }
	  }
	  
	  @Test
	  public void testEnqueueDequeue2() {
	    DSArrayBoundedQueue<Integer> queue = new DSArrayBoundedQueue<Integer>();
	    try
	    {
	      queue.enqueue(2);
	      queue.enqueue(3);
	      queue.enqueue(3);
	      queue.enqueue(4);
	      
	      assertTrue(queue.dequeue() == 2);
	      assertTrue(queue.dequeue() == 3);
	      assertTrue(queue.dequeue() == 3);
	      assertTrue(queue.dequeue() == 4);
	    }
	    catch (DSQueueUnderflowException e)
	    {
	      fail(e.toString());
	    }
	    catch (DSQueueOverflowException e)
	    {
	      fail(e.toString());
	    }
	  }
	  
	  @Test
	  public void testEnqueueDequeue3() {
	    DSArrayBoundedQueue<Integer> queue = new DSArrayBoundedQueue<Integer>();
	    try
	    {
	      queue.enqueue(5);
	      int x = queue.dequeue();
	      queue.enqueue(3);
	      queue.enqueue(7);
	      x = queue.dequeue();
	      assertTrue(queue.dequeue() == 7);
	    }
	    catch (DSQueueUnderflowException e)
	    {
	      fail(e.toString());
	    }
	    catch (DSQueueOverflowException e)
	    {
	      fail(e.toString());
	    }
	  }
	  
	  @Test
	  public void testIsEmpty() {
	    DSArrayBoundedQueue<Integer> queue = new DSArrayBoundedQueue<Integer>();
	    try
	    {
	      assertTrue(queue.isEmpty());
	      queue.enqueue(5);
	      assertFalse(queue.isEmpty());
	      int x = queue.dequeue();
	    }
	    catch (Exception e)
	    {
	      fail(e.toString());
	    }
	    assertTrue(queue.isEmpty());
	  }
	  
	  @Test
	  public void testIsFull() {
	    DSArrayBoundedQueue<Integer> queue = new DSArrayBoundedQueue<Integer>(5);
	    assertFalse(queue.isFull());
	    try
	    {
	      queue.enqueue(1);
	      queue.enqueue(2);
	      queue.enqueue(3);
	      queue.enqueue(4);
	      queue.enqueue(5);
	      assertTrue(queue.isFull());
	      int x = queue.dequeue();
	    }
	    catch (Exception e)
	    {
	      fail(e.toString());
	    }
	    assertFalse(queue.isFull());
	  }
	  
	  
	  @Test(expected = DSQueueUnderflowException.class)
	  public void testUnDequeueException() 
	  {
	    DSLinkedQueue<Integer> queue = new DSLinkedQueue<Integer>();
	    queue.dequeue();
	  }
	  
	  @Test
	  public void testUnEnqueueDequeue0() {
	    DSLinkedQueue<Integer> queue = new DSLinkedQueue<Integer>();
	    try
	    {
	      queue.enqueue(5);
	      assertTrue(queue.dequeue() == 5);
	    }
	    catch (DSQueueUnderflowException e)
	    {
	      fail(e.toString());
	    }
	  }
	  
	  @Test
	  public void testUnEnqueueDequeue1() {
	    DSLinkedQueue<Integer> queue = new DSLinkedQueue<Integer>();
	    try
	    {
	      queue.enqueue(5);
	      queue.enqueue(7);
	      queue.enqueue(6);
	      queue.enqueue(9);
	      
	      assertTrue(queue.dequeue() == 5);
	      assertTrue(queue.dequeue() == 7);
	      assertTrue(queue.dequeue() == 6);
	      assertTrue(queue.dequeue() == 9);
	    }
	    catch (DSQueueUnderflowException e)
	    {
	      fail(e.toString());
	    }
	  }
	  
	  @Test
	  public void testUnEnqueueDequeue2() {
	    DSLinkedQueue<Integer> queue = new DSLinkedQueue<Integer>();
	    try
	    {
	      queue.enqueue(2);
	      queue.enqueue(3);
	      queue.enqueue(3);
	      queue.enqueue(4);
	      
	      assertTrue(queue.dequeue() == 2);
	      assertTrue(queue.dequeue() == 3);
	      assertTrue(queue.dequeue() == 3);
	      assertTrue(queue.dequeue() == 4);
	    }
	    catch (DSQueueUnderflowException e)
	    {
	      fail(e.toString());
	    }
	  }
	  
	  @Test
	  public void testUnEnqueueDequeue3() {
	    DSLinkedQueue<Integer> queue = new DSLinkedQueue<Integer>();
	    try
	    {
	      queue.enqueue(5);
	      int x = queue.dequeue();
	      queue.enqueue(3);
	      queue.enqueue(7);
	      x = queue.dequeue();
	      assertTrue(queue.dequeue() == 7);
	    }
	    catch (DSQueueUnderflowException e)
	    {
	      fail(e.toString());
	    }
	  }
	  
	  @Test
	  public void testUnIsEmpty() {
	    DSLinkedQueue<Integer> queue = new DSLinkedQueue<Integer>();
	    try
	    {
	      assertTrue(queue.isEmpty());
	      queue.enqueue(5);
	      assertFalse(queue.isEmpty());
	      int x = queue.dequeue();
	    }
	    catch (Exception e)
	    {
	      fail(e.toString());
	    }
	    assertTrue(queue.isEmpty());
	  }
	  
	  public static void main(String[] args) 
	  {
	    Result result = JUnitCore.runClasses(DSQueueTestRunner.class);
	    for (Failure failure : result.getFailures()) 
	    {
	      System.out.println(failure.toString());
	    }
	    if (result.wasSuccessful())
	    {
	      long time = result.getRunTime();
	      System.out.println("All " +
	                         result.getRunCount() +
	                         " tests successful. " +
	                         "(" + time + "ms)");
	    }
	  }
	}