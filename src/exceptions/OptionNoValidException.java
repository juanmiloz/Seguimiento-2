package exceptions;

public class OptionNoValidException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public OptionNoValidException() {
		super("The option entered is not among the allowed options");
	}
}
