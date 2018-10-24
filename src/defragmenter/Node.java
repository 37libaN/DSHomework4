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
