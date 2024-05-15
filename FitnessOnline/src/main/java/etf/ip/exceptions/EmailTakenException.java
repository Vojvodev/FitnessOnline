package etf.ip.exceptions;

public class EmailTakenException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public EmailTakenException() {
		super();
	}

	public EmailTakenException(String message) {
		super(message);
	}
	
}
