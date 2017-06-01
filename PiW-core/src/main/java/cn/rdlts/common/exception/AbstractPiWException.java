package cn.rdlts.common.exception;

public abstract class AbstractPiWException extends Exception {

	private static final long serialVersionUID = 3332161896758707587L;
	
	public AbstractPiWException(String message) {
		super(message);
	}
	
	public AbstractPiWException(Throwable throwable) {
		super(throwable);
	}
}
