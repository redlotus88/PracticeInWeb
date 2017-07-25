package cn.rdlts.core.security.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import cn.rdlts.common.dao.BaseMapper;
import cn.rdlts.core.security.model.AccountRole;
import cn.rdlts.core.security.model.Role;

@Repository
public interface RoleMapper extends BaseMapper<Role, Integer> {
	
	Role getByCode(String code);
	
	List<Role> getByAccountName(String accountName);
	
	/**
	 * 为账号添加相关角色, id关联。
	 * account的id和role的id不能为空
	 * 
	 * @param accountRole 
	 * @return
	 */
	int addRolesToAccount(AccountRole accountRole);
	
	boolean exist(Role role);
}
