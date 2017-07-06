package cn.rdlts.webapp.vo.datatable;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import cn.rdlts.webapp.vo.admin.mgr.AccountView;

/**
 * 基础DataTable VO对象
 * 
 * @author dragon
 *
 */
public abstract class BaseDataTableVO<T extends Serializable> implements Serializable {
	
	private static final long serialVersionUID = -7026785621007562381L;
	
	private String[] columns;
	
	private List<T> data = new ArrayList<>();

	public String[] getColumns() {
		return columns;
	}

	public void setColumns(String[] columns) {
		this.columns = columns;
	}

	public List<T> getData() {
		return data;
	}

	public void setData(List<T> data) {
		this.data = data;
	}
}
