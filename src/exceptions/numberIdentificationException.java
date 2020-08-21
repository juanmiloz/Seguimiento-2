package exceptions;

public class numberIdentificationException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public numberIdentificationException() {
		super("Your number of identification card can't entry today");
	}
}
