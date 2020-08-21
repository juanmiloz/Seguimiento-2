package exceptions;

public class IdentifyCardException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public IdentifyCardException() {
		super("the customer cannot enter the premises if they have an identity card");
	}
}
