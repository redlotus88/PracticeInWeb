package cn.rdlts.webapp.vo;

import cn.rdlts.webapp.vo.datatable.AccountDataTableVO;

public final class AccountVO {
	
	private AccountDataTableVO dataTable;
	
	public AccountVO() {
		// public constructor.
	}

	public AccountDataTableVO getData() {
		return dataTable;
	}

	public void setData(AccountDataTableVO dataTable) {
		this.dataTable = dataTable;
	}
}
