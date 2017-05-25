package cn.rdlts.usermgr.service;

import java.util.List;

import cn.rdlts.usermgr.model.Account;

public interface AccountService {
	
	Account getById(Integer id);
	
	List<Account> findAll();
	
	Integer save(Account userInfo);
	
	
}
