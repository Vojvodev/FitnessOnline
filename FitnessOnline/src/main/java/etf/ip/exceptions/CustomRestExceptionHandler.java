package etf.ip.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class CustomRestExceptionHandler {
	
	@ExceptionHandler(EmailTakenException.class)
	public ResponseEntity<ErrorMessage> handleEmailTakenException(EmailTakenException e) {
		 ErrorMessage error = new ErrorMessage(HttpStatus.NOT_FOUND, e.getLocalizedMessage());
		 return new ResponseEntity<>(error, error.getHttpStatus());
	}
}
