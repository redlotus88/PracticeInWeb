package cn.rdlts.core.usermgr.model;

import org.apache.commons.lang.StringUtils;

public class AccountVoid extends Account {
	
	private static final long serialVersionUID = -4821811340462868044L;
	
	private static volatile AccountVoid instance;

	private AccountVoid() {
		super(StringUtils.EMPTY, null);
		super.setId(-1);
	}
	
	public static AccountVoid getInstance() {
		if (instance == null) {
			synchronized (AccountVoid.class) {
				if (instance == null) {
					instance = new AccountVoid();
				}
			}
		}
		return instance;
	}
}
