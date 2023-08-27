package demo.boot.exception;

public class WatchListNotFoundException extends RuntimeException {

	
	private static final long serialVersionUID = 9057465826363550908L;

	public WatchListNotFoundException() {
		super();
	}

	public WatchListNotFoundException(String message) {
		super(message);
	}
	
}
