
public class MainStack {

	public static void main(String[] args) {
		
		Stack<String> stackObj = new Stack<>();
		Stack<Integer> stackObj2 = new Stack<>();
		
		stackObj.push("Hallo");
		stackObj.push("Zweite Einfuegung zu erst!");
		stackObj2.push(1);
		stackObj2.push(2);
		
		print(stackObj);	// Struktur checken
		
		try {
			System.out.println("Hier der String Stack: ");
			System.out.println("erster Pop liefert : " + stackObj.pop());
			System.out.println("zweites Pop liefert : " + stackObj.pop());
			
			System.out.println("");
			System.out.println("Hier der int Stack: ");
			System.out.println("erster Pop liefert : " + stackObj2.pop());
			System.out.println("zweites Pop liefert : " + stackObj2.pop());
			
		// Hier bewusst eine Exception provozieren um richtiges Verhalten zu evaluieren:
			System.out.println("drittes Pop liefert : " + stackObj.pop());
		}
		catch(EmptyStackException e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	public static void print(Object s) {
		System.out.println(s);
	}

}