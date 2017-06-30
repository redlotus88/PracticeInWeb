package cn.rdlts.webapp.exception;

/**
 * Login exception 捕捉登录异常，包括账号密码错误。
 * 无论处理结果是什么，都不需要返回404，或者其他错误http code。
 * 
 * @author dragon
 *
 */
public class PiWLoginException extends RuntimeException {

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
