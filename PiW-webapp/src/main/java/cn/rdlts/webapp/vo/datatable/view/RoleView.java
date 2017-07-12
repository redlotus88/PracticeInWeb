package cn.rdlts.webapp.vo.datatable.view;

import java.io.Serializable;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.ToStringBuilder;

public final class RoleView implements Serializable {
	
	private static final long serialVersionUID = 1233591146295413808L;
	
	private String id;
	private String accountName;
	private String profileName;
	private String role;
	private String description;
	
	public RoleView() {
		// public constructor
	}
	
	public RoleView(String id, String accountName, String profileName, String role, String description) {
		this.id = id;
		this.accountName = accountName;
		this.profileName = profileName;
		this.role = role;
		this.description = description;
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

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
