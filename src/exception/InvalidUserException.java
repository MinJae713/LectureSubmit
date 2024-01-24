package exception;

public class InvalidUserException extends Exception{
	private static final long serialVersionUID = 1L;

	public InvalidUserException() {
		super("유효한 사용자가 아닙니다.");
	}
}
