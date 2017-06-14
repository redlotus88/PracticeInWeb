package cn.rdlts.webapp.exception;

public class PiWShiroException extends Exception {

	private static final long serialVersionUID = 4210394323465486762L;
	
	public PiWShiroException(String msg) {
		super(msg);
	}
	
	public PiWShiroException(Throwable cause) {
		super(cause);
	}
}
