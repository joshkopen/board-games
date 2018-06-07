package boardbasics;

public class InvalidEntryException extends Exception {
	public InvalidEntryException() { super();}
	public InvalidEntryException(String message) { super(message); }
	public InvalidEntryException(String message, Throwable cause) { super(message, cause); }
	public InvalidEntryException(Throwable cause) { super(cause); }
}
