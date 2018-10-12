/**
	 * COSC 2100 - Project 6
	 * A program simulating a helpdesk for students; this time it implements a waiting area as well.
	 * @author [Vishnu Appalaraju, Nabil Hussaini]
	 * Instructor [Dr. Brylow] 
	 * TA-BOT:MAILTO [srivishnu.appalaraju@marquette.edu nabil.hussaini@marquette.edu] 
	 */
package helpDesk;
public class DSLLNode<T> 
{
	private T data;
	private DSLLNode<T> next;
	

	public DSLLNode(T data)
	{
		this(data, null);
	}
	public DSLLNode(T data, DSLLNode<T> next)
	{
		this.data = data;
		this.next = next;
	}
	
	public void setData(T data)
	{
		this.data = data;
	}
	
	public void setNext(DSLLNode<T> next)
	{
		this.next = next;
	}
	
	public T getData()
	{
		return this.data;
	}
	
	public DSLLNode<T> getNext()
	{
		return this.next;
	}
}