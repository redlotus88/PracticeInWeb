package cn.rdlts.core.security.service;

import java.util.List;
import java.util.Set;

import cn.rdlts.core.security.model.Role;
import cn.rdlts.core.usermgr.model.Account;

public interface SecurityService {
	
	/**
	 * 
	 * @param roles
	 * @param account
	 * @return int 数据库影响行数
	 */
	int addRolesToAccount(List<Role> roles, Account account);
	
	int deleteRole(Role role);
	
	/**
	 * 
	 * @param account
	 * @return int 数据库影响行数
	 */
	int deleteRoles(Account account);
	
	boolean exist(Role role);
	
	boolean existRole(String codeRole);
	
	Role findRole(String codeRole);
	
	Set<String> findRolesCodeByAccountName(String accountName);
	
	Set<Role> findRolesByAccountName(String accountName);
	
	List<Role> findAllRoles();
	
	/**
	 * 
	 * @param roles
	 * @param account
	 * @return int 数据库影响行数
	 */
	int saveRolesToAccount(List<Role> roles, Account account);
	
	int saveRole(Role role);
	
}
