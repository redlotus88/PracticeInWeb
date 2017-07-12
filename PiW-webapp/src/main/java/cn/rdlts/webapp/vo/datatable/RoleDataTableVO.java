package cn.rdlts.webapp.vo.datatable;

import java.util.List;

import cn.rdlts.webapp.vo.datatable.view.RoleView;

public class RoleDataTableVO extends BaseDataTableVO<RoleView> {

	private static final long serialVersionUID = -6402196576318346673L;
		
	public RoleDataTableVO() {
		// public constructor
	}
	
	public RoleDataTableVO(List<RoleView> data) {
		super.setData(data);
	}
}
