package cn.rdlts.webapp.vo.datatable;

import java.io.Serializable;

public abstract class AbstractServerSideDTVO<T extends Serializable> extends BaseDataTableVO<T> {
	
	private static final long serialVersionUID = 3003382792055257550L;
	
	private int draw;
	private int recordsTotal;
	private int recordsFiltered;

	public int getDraw() {
		return draw;
	}

	public void setDraw(int draw) {
		this.draw = draw;
	}

	public int getRecordsTotal() {
		return recordsTotal;
	}

	public void setRecordsTotal(int recordsTotal) {
		this.recordsTotal = recordsTotal;
	}

	public int getRecordsFiltered() {
		return recordsFiltered;
	}

	public void setRecordsFiltered(int recordsFiltered) {
		this.recordsFiltered = recordsFiltered;
	}
	
	
}
