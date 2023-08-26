package demo.boot.exception;

public class MovieAlreadyExistsException extends RuntimeException {

	private static final long serialVersionUID = 4891016496309730805L;

	public MovieAlreadyExistsException() {
		super();
	}

	public MovieAlreadyExistsException(String message) {
		super(message);
	}
	
	
}
