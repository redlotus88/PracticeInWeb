package cn.rdlts.core.usermgr.service;

import java.util.List;

import cn.rdlts.core.security.model.Role;
import cn.rdlts.core.usermgr.model.Account;

public interface AccountService {
	
	Account getById(Integer id);
	
	Account getByName(String name);
	
	List<Account> findAll();
	
	int save(final Account account);
	
	int save(final Account account, final List<Role> roles);
	
	boolean exist(final Account account);
	
	boolean exist(String accountName);
	
	int update(final Account account);
	
	List<Account> findAccountBy(Role role);
}
