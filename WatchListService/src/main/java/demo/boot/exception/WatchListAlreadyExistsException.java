package demo.boot.exception;

public class WatchListAlreadyExistsException extends RuntimeException {


	private static final long serialVersionUID = -526714844997040929L;

	public WatchListAlreadyExistsException() {
		super();
	}

	public WatchListAlreadyExistsException(String message) {
		super(message);
	}

	
}
