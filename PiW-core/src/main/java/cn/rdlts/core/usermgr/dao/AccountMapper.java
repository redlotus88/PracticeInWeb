package cn.rdlts.core.usermgr.dao;

import org.springframework.stereotype.Repository;

import cn.rdlts.common.dao.BaseMapper;
import cn.rdlts.core.usermgr.model.Account;

@Repository
public interface AccountMapper extends BaseMapper<Account, Integer> {
	
	boolean exist(Account entity); 
	
	Account getByName(String name);
	
	int update(Account entity);
}
