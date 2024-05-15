package etf.ip.exceptions;

public class InvalidUsernameException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public InvalidUsernameException() {
		super();
	}

	public InvalidUsernameException(String message) {
		super(message);
	}
	
}
