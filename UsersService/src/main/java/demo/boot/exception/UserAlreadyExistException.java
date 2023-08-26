package demo.boot.exception;

public class UserAlreadyExistException extends RuntimeException {

	private static final long serialVersionUID = 7922163548574772602L;

	public UserAlreadyExistException() {
		super();
	}

	public UserAlreadyExistException(String message) {
		super(message);
	}

}
