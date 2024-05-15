package etf.ip.exceptions;

import org.springframework.http.HttpStatus;

import java.io.Serializable;


public class ErrorMessage implements Serializable {
	private static final long serialVersionUID = 1L;

	private final HttpStatus httpStatus;
    private final String message;
    
    
	public ErrorMessage(HttpStatus httpStatus, String message) {
		super();
		this.httpStatus = httpStatus;
		this.message = message;
	}


	public HttpStatus getHttpStatus() {
		return httpStatus;
	}


	public String getMessage() {
		return message;
	}
	
}
