package cn.rdlts.webapp.exception;

import cn.rdlts.common.exception.AbstractPiWRuntimeException;

/**
 * 测试用的异常
 * 
 * @author dragon
 *
 */
public class PiWTestException extends AbstractPiWRuntimeException {

	private static final long serialVersionUID = -6708268152124608195L;
	
	public PiWTestException(String message) {
		super(message);
	}

}
