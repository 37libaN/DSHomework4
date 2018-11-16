package finalProject.homepage;

public class BinSearchTreeLogin<T> {
	private BSTNode root;
	boolean found;
	public boolean isEmpty() {
		if(root == null)
			return true;
		return false;
	}
	public boolean contains(T element) {
		recContains(element, root);
		return found;
	}
	private void recContains(T element, BSTNode root2) {
		if(root2 == null)
			found = false;
		else if(((Comparable) element).compareTo(root2.getInfo()) < 0)
			recContains(element, root2);
		else if(((Comparable) element).compareTo(root2.getInfo()) > 0)
			recContains(element, root2);
		else {
			found = true;
		}
	}
	public boolean remove(T element) {
		root = recRemove(element, root);
		return found;
	}
	private BSTNode recRemove(T element, BSTNode root2) {
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
	private BSTNode removeNode(BSTNode root2) {
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
	private T getPredecessor(BSTNode root2) {
		while(root2.getRight() != null)
			root2 = root2.getRight();
		return (T) root2.getInfo();
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
	
}
