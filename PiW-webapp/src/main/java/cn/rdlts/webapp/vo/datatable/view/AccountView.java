package cn.rdlts.webapp.vo.datatable.view;

import java.io.Serializable;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class AccountView implements Serializable {
	
	private static final long serialVersionUID = 8285380880050328563L;
	
	private String id;
	private String accountName;
	private String profileName;
	private String roles;
	private String publicEmail;
	private String company;
	private String lastLoginTime;
	private String lastModifyTime;
	
	public AccountView() {
		// public constructor
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public void setFormattedId(String id, int size) {
		this.id = StringUtils.leftPad(id, size, '0');
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public String getProfileName() {
		return profileName;
	}

	public void setProfileName(String profileName) {
		this.profileName = profileName;
	}
	
	public String getRoles() {
		return roles;
	}

	public void setRoles(String roles) {
		this.roles = roles;
	}

	public String getPublicEmail() {
		return publicEmail;
	}

	public void setPublicEmail(String publicEmail) {
		this.publicEmail = publicEmail;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getLastLoginTime() {
		return lastLoginTime;
	}

	public void setLastLoginTime(String lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}

	public String getLastModifyTime() {
		return lastModifyTime;
	}

	public void setLastModifyTime(String lastModifyTime) {
		this.lastModifyTime = lastModifyTime;
	}
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
