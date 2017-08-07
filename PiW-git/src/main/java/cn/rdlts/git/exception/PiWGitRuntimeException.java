package cn.rdlts.git.exception;

public class PiWGitRuntimeException extends RuntimeException {

	private static final long serialVersionUID = 30413526708493180L;

	public PiWGitRuntimeException() {
		super();
	}
	
	public PiWGitRuntimeException(String message) {
		super(message);
	}
	
	public PiWGitRuntimeException(String message, Throwable cause) {
		super(message, cause);
	}
}
