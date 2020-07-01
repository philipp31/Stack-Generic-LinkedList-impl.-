
public class Stack<T> {
	
	private LinkedList<T> listObj;
	
	public Stack(){
		listObj = new LinkedList<T>();
	}
	
	public boolean isEmpty() {
		return listObj.isEmpty();
	}
	
	public void push(T content) {
		listObj.insert(content);	//füge am Anfang ein
	}
	
	public T pop() throws EmptyStackException {	// gib erstes Element und lösche es
		if(listObj.isEmpty()) {
			throw new EmptyStackException("pop() ***");
		}
		T cache = listObj.firstElement();
		listObj.delete();
		return cache;
	}
	
	public String toString() {
		return listObj.toString();
	}

}