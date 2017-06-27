package cn.rdlts.core.usermgr.service;

import java.util.List;

import cn.rdlts.core.usermgr.model.AccountProfile;

public interface AccountProfileService {
	
	AccountProfile getById(Integer id);
	
	List<AccountProfile> findAll();
	
	Integer save(final AccountProfile account);
	
	boolean exist(final AccountProfile account);
	
	int update(final AccountProfile account);
}
