package demo.boot.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class WatchListServiceExceptionHandler {

	@ExceptionHandler(WatchListNotFoundException.class)
	public ResponseEntity<?> handleWatchListnotFoundException(WatchListNotFoundException e){
		return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(WatchListAlreadyExistsException.class)
	public ResponseEntity<?> handleWatchListAlreadyExistsException(WatchListAlreadyExistsException e){
		return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
	}
	
	
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<?> handleValidationExceptions(MethodArgumentNotValidException  e){
		Map<String, String> errors = new HashMap<>();
		e.getBindingResult().getAllErrors().forEach(error->{
			FieldError fieldError = (FieldError) error;
			errors.put(fieldError.getField(), fieldError.getDefaultMessage());
		});
		return new ResponseEntity<>(errors,HttpStatus.BAD_REQUEST);
	}

	
}
