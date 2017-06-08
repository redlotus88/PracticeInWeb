package cn.rdlts.exception;

public class PiWLoginException extends Exception {

	private static final long serialVersionUID = 2341985261620901663L;

	public PiWLoginException(String msg) {
		super(msg);
	}
	
	public PiWLoginException(Throwable cause) {
		super(cause);
	}
	
	public PiWLoginException(String msg, Throwable cause) {
		super(msg, cause);
	}
}
