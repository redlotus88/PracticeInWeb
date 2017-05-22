package cn.rdlts.usermgr.model;

import java.io.Serializable;

public class Account implements Serializable {

	private static final long serialVersionUID = 6135843630592962776L;
	
	private int id;
	
	private String accountName;
	
	private String password;

	public Account() {
	}
	
	public Account(String username, String password) {
		this.accountName = username;
		this.password = password;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
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
	
}
