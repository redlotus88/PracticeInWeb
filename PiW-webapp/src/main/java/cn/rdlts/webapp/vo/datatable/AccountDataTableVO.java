package cn.rdlts.webapp.vo.datatable;

import java.util.ArrayList;
import java.util.List;

import cn.rdlts.webapp.vo.datatable.view.AccountView;

public class AccountDataTableVO extends BaseDataTableVO<AccountView> {

	private static final long serialVersionUID = 3955609939637312742L;

	private static volatile AccountDataTableVO emptyObject = null;
	
	public AccountDataTableVO() {
		// public constructor
	}
	
	public AccountDataTableVO(List<AccountView> data) {
		super.setData(data);
	}
	
	public static AccountDataTableVO getEmtpyObject() {
		if (emptyObject == null) {
			synchronized(AccountDataTableVO.class) { 
				if (emptyObject == null) {
					generateEmtpyObject();
				}
			}
		}
		return emptyObject;
	}
	
	private static AccountDataTableVO generateEmtpyObject() {
		emptyObject = new AccountDataTableVO();
		emptyObject.setData(new ArrayList<AccountView>());
		return emptyObject;
	}
	
}
