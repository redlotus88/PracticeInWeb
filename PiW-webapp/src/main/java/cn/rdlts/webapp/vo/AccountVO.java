package cn.rdlts.webapp.vo;

import cn.rdlts.webapp.vo.datatable.AccountDataTableVO;

public final class AccountVO {
	
	private AccountDataTableVO dataTable;
	
	private String accountName;
	
	private String password;
	
	private String[] roles;
	
	public AccountVO() {
		// public constructor.
	}

	public AccountDataTableVO getData() {
		return dataTable;
	}

	public void setData(AccountDataTableVO dataTable) {
		this.dataTable = dataTable;
	}

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

	public String[] getRoles() {
		return roles;
	}

	public void setRoles(String[] roles) {
		this.roles = roles;
	}
}
