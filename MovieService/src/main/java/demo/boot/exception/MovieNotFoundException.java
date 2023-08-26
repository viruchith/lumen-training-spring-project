package demo.boot.exception;

public class MovieNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 4740060386179346028L;

	public MovieNotFoundException() {
		super();
	}

	public MovieNotFoundException(String message) {
		super(message);
	}
	
}
