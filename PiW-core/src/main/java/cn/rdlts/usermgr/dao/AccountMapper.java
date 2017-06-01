package cn.rdlts.usermgr.dao;

import org.springframework.stereotype.Repository;

import cn.rdlts.common.dao.BaseMapper;
import cn.rdlts.usermgr.model.Account;

@Repository
public interface AccountMapper extends BaseMapper<Account, Integer> {
	
	boolean exist(Account entity); 
	
	Account getByName(String name);
	
	int update(Account entity);
}
