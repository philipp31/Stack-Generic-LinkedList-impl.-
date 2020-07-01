
public class EmptyStackException extends Exception {
	
	EmptyStackException(String s){
		super("*** Stack ist leer bei Operation:  " + s);
	}

}