package cn.rdlts.core.security.model;

import java.io.Serializable;
import java.util.List;

import cn.rdlts.core.usermgr.model.Account;

public class AccountRole implements Serializable {
	
	private static final long serialVersionUID = -2284168114932173950L;

	private Account account;
	
	private List<Role> roles;
	
	public AccountRole(Account account, List<Role> roles) {
		this.account = account;
		this.roles = roles;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
}
