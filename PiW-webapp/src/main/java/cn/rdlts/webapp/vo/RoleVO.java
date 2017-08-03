package cn.rdlts.webapp.vo;

import cn.rdlts.webapp.vo.datatable.RoleDataTableVO;

public class RoleVO {
	
	private RoleDataTableVO dataTable;
	private String code;
	private String description;
	
	public RoleVO() {
		// public constructor.
	}

	public RoleDataTableVO getData() {
		return dataTable;
	}

	public void setData(RoleDataTableVO dataTable) {
		this.dataTable = dataTable;
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
	
	
}
