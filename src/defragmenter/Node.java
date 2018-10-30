/**
	 * COSC 2100 - Project 7
	 * 
	 * @author [Vishnu Appalaraju, Nabil Hussaini]
	 * Instructor [Dr. Brylow] 
	 * TA-BOT:MAILTO [srivishnu.appalaraju@marquette.edu nabil.hussaini@marquette.edu] 
	 */
package defragmenter;

public class Node<T> {
	private T info;
	private Node<T> link;
	public Node(){
		info = null;
		link = null;
	}
	public Node(T element){
		info = element;
		link = null;
	}
	public void setLink(Node<T> node){
		link = node;
	}
	public Node<T> getLink(){
		return link;
	}
	public void setInfo(T element){
		info = element;
	}
	public T getInfo(){
		return info;
	}
}
