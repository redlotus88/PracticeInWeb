package cn.rdlts.vo;

import cn.rdlts.constant.VOConstants;

public class LoginVO {
	
	private String accountName;
	
	private String password;
	
	private String rememberMe;

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRememberMe() {
		return rememberMe;
	}

	public void setRememberMe(String rememberMe) {
		this.rememberMe = rememberMe;
	}
	
	public boolean isRememberMe() {
		return rememberMe == null ? false : rememberMe.equals(VOConstants.CHECKBOX_ON);
	}
}
