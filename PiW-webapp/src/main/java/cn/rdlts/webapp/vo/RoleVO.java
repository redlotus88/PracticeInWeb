package cn.rdlts.webapp.vo;

import cn.rdlts.webapp.vo.datatable.RoleDataTableVO;

public class RoleVO {
	
	private RoleDataTableVO dataTable;
	
	public RoleVO() {
		// public constructor.
	}

	public RoleDataTableVO getData() {
		return dataTable;
	}

	public void setData(RoleDataTableVO dataTable) {
		this.dataTable = dataTable;
	}
}
