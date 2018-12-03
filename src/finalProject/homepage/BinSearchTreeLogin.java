package finalProject.homepage;

public class BinSearchTreeLogin<T> {
	private BSTNode<T> root;
	boolean found;
	private LLQueue<T> inOrderQueue;
	public boolean isEmpty() {
		if(root == null)
			return true;
		return false;
	}
	public void reset() {
		inOrderQueue = new LLQueue<T>();
		inOrder(root);
	}
	private void inOrder(BSTNode<T> root2) {
		if(root2!= null) {
			inOrder(root2.getLeft());
			inOrderQueue.enqueue(root2.getInfo());
			inOrder(root2.getRight());
		}
	}
	public LLQueue<T> getInOrderQueue() {
		return inOrderQueue;
	}
	public boolean contains(T element) {
		recContains(element, root);
		return found;
	}
	private void recContains(T element, BSTNode<T> root2) {
		if(root2 == null) {
			found = false;
			return;
		}
		else if(((Comparable) element).compareTo(root2.getInfo()) < 0)
			recContains(element, root2.getLeft());
		else if(((Comparable) element).compareTo(root2.getInfo()) > 0)
			recContains(element, root2.getRight());
		else {
			found = true;
			return;
		}
	}
	public boolean remove(T element) {
		root = recRemove(element, root);
		return found;
	}
	private BSTNode recRemove(T element, BSTNode<T> root2) {
		if(root2 == null)
			found = false;
		else if(((Comparable) element).compareTo(root2.getInfo()) < 0)
			root2.setLeft(recRemove(element, root2.getLeft()));
		else if(((Comparable) element).compareTo(root2.getInfo()) > 0)
			root2.setRight(recRemove(element, root2.getRight()));
		else {
			root2 = removeNode(root2);
			found = true;
		}
		return root2;
	}
	private BSTNode removeNode(BSTNode<T> root2) {
		T data = null;
		if(root2.getLeft() == null)
			return root2.getRight();
		else if(root2.getLeft() == null)
		return root2.getRight();
		else {
			data = getPredecessor(root2.getLeft());
			root2.setInfo(data);
			root2.setLeft(recRemove(data, root2.getLeft()));
			return root2;
		}
	}
	private T getPredecessor(BSTNode<T> root2) {
		while(root2.getRight() != null)
			root2 = root2.getRight();
		return root2.getInfo();
	}
	/*public T get(T element) {
		
	}*/
	public void add(T element) {
		root = recAdd(element, root);
	}
	private BSTNode recAdd(T element, BSTNode root2) {
		if(root2 == null) 
			root2 = new BSTNode<T>(element);
		else if(((Comparable) element).compareTo(root2.getInfo()) <= 0)
			root2.setLeft(recAdd(element, root2.getLeft()));
		else 
			root2.setRight(recAdd(element, root2.getRight()));
		return root2;	
	}
	public static void main(String args[]) {
		BinSearchTreeLogin<LoginInfo> l = new BinSearchTreeLogin<LoginInfo>();
		LoginInfo test = new LoginInfo("hi", "you");
		l.add(test);
		System.out.println(l.contains(new LoginInfo("hi", "you")));
	}
}
