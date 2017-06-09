package cn.rdlts.security.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import cn.rdlts.common.dao.BaseMapper;
import cn.rdlts.security.model.Role;

@Repository
public interface RoleMapper extends BaseMapper<Role, Integer> {
	
	Role getByCode(String code);
	
	List<Role> getByAccountName(String accountName);
}
