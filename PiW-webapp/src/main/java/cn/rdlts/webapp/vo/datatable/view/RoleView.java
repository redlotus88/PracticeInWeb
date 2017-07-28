package cn.rdlts.webapp.vo.datatable.view;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;

public final class RoleView implements Serializable {
	
	private static final long serialVersionUID = 1233591146295413808L;
	
	private String id;
	private String code;
	private String description;
	
	public RoleView() {
		// public constructor
	}
	
	public RoleView(String id, String code, String description) {
		this.id = id;
		this.code = code;
		this.description = description;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
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
