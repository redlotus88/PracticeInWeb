package cn.rdlts.webapp.vo.admin.mgr;

import java.util.List;

public final class AccountVO {
	
	private List<AccountDataTableVO> dataTable;
	
	public AccountVO() {
		// public constructor.
	}

	public List<AccountDataTableVO> getData() {
		return dataTable;
	}

	public void setData(List<AccountDataTableVO> dataTable) {
		this.dataTable = dataTable;
	}
}
