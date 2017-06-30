package cn.rdlts.webapp.exception;

import cn.rdlts.common.exception.AbstractPiWRuntimeException;

public class PiWUnknownViewException extends AbstractPiWRuntimeException {

	private static final long serialVersionUID = -4405373841694014054L;
	
	public PiWUnknownViewException(String message) {
		super(message);
	}
	
	public PiWUnknownViewException(Throwable cause) {
		super(cause);
	}
}
