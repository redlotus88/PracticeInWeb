package cn.rdlts.core.usermgr.service;

import java.util.List;

import cn.rdlts.core.usermgr.model.Account;

public interface AccountService {
	
	Account getById(Integer id);
	
	Account getByName(String name);
	
	List<Account> findAll();
	
	Integer save(final Account account);
	
	boolean exist(final Account account);
	
	int update(final Account account);
}
