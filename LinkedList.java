
// eig Schnittstellen-implementierung jedoch müssen dafür alle methoden definiert werden deswegen so..

public class LinkedList<T> {// implements List 

	//Datenelement
	private T item;
	//Zeiger auf nächstes Datenelement:
	private LinkedList<T> next;
	
	//Konstruktor, erzeugt leere Liste
	public LinkedList() {
		item = null;
		next = null;
	}
	
	public T getItem() {
		return ((T) this.item);
	}
	
	public LinkedList<T> getNext() {
		return next;	
	}
	
	public boolean isEmpty() {
		return (next == null);	// wenn Pointer null ist, ist die Liste leer oder das ende der List ist erreicht!
	}
	
	public T firstElement() {
		if (isEmpty()) {	// wenn sie leer ist gibt es kein erstes Element! (Strukturinvariante!)
			return null;	
		}
		else {
			return ((T) next.item); 	// wenn liste nicht leer, gib das erste Elemente (zweite Position immer!)
		}
	}
	
	public int length() {
		if (isEmpty())
			return 0;	// wenn sie leer ist(true) return 0
		else
			return 1 + next.length(); 	//Länge wird rekursiv ausgehend vom 1 element der liste gestartet
	}
	
	public LinkedList<T> insert(T xy) {	// insert fügt am Head neues Datenelement ein
		LinkedList<T> l = new LinkedList<T>();
		l.item = xy;
		l.next = next;	// neues LinkedList obj übernimmt den Zeiger
		next = l;		// Obj von davor zeigt nun auf das neue LinkedList obj, da dieses den Pionter übernommen hat
		return this;
	}
	
	public LinkedList<T> append(T xy) {
		if(isEmpty()) {	// wenn du am Ende bist füge ein:
			return insert(xy);
		}
		else {	// ansonste wander in der Datenstruktur weiter:
			return next.append(xy);
		}
	}
	
	private LinkedList<T> find(T xy) {
		if(isEmpty()) {
			return null;
		}
		else {
			if(firstElement().equals(xy)) {
				return this;	//returne dieses LinkedList objekt wenn es dieses Objekt ist!
			}
			else {	// ansonsten wander weiter:
				return next.find(xy);	
			}	
		}
	}
	
/*	public boolean equals(T obj) {
		
		return (this.item == obj.item);
	}*/
	
	public LinkedList<T> delete(T xy) {
		LinkedList<T> l = find(xy);
		if(l != null) {
			l.next = l.next.next;/* dadurch,dass das Element das nächste Element überspringt(nicht mehr 
	auf dieses Pointet => Speicherbereich verloren!) wird dieses vom garbage collector aufgesammelt und zerstört */
		}
		return this;
	}
	
	public LinkedList<T> delete() {
		if (!isEmpty()) {
			next = next.next;
		}
		return this;
	}
	
	public LinkedList<T> subList(int fromIndex, int toIndex) {
		return null;
	}
	
	public String toString() {
		return isEmpty() ? " |--" : " --> " + next.item + next;
	}
}