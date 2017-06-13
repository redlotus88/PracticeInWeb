package cn.rdlts.common.exception;

public class AbstractPiWRuntimeException extends RuntimeException {

	private static final long serialVersionUID = -1077187789258611821L;

	public AbstractPiWRuntimeException(String message) {
		super(message);
	}
	
	public AbstractPiWRuntimeException(Throwable throwable) {
		super(throwable);
	}
}
