package cn.rdlts.core.usermgr.dao;

import org.springframework.stereotype.Repository;

import cn.rdlts.common.dao.BaseMapper;
import cn.rdlts.core.usermgr.model.AccountProfile;

@Repository
public interface AccountProfileMapper extends BaseMapper<AccountProfile, Integer> {
	
	boolean exist(AccountProfile entity); 
}
