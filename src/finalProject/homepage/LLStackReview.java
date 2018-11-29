package finalProject.homepage;

public class LLStackReview<T> {
	private Node<T> list; // 1st node in list

	public LLStackReview() {
		list = null;
	}

	public boolean isEmpty() { // returns true if empty, false if not
		if (list == null)
			return true;
		return false;
	}

	public void Push(T element) { // adds an element to front of list
		if (list == null) {
			list = new Node<T>(element);
			return;
		}
		list.setLink(list);
		list = new Node<T>(element);
	}

	public T Top() {// returns the element at the front of list
		return list.getInfo();
	}

	public void Pop() {// deletes the element at the front of list
		list = list.getLink();
	}
}
