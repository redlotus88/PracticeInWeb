package cn.rdlts.usermgr.exception;

import cn.rdlts.common.exception.AbstractPiWRuntimeException;

public class DuplicatedAccountNameException extends AbstractPiWRuntimeException {

	private static final long serialVersionUID = -4475100296656070154L;

	public DuplicatedAccountNameException(String message) {
		super(message);
	}
	
}
