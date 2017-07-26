package cn.rdlts.core.security.service;

import java.util.List;
import java.util.Set;

import cn.rdlts.core.security.model.Role;
import cn.rdlts.core.usermgr.model.Account;

public interface SecurityService {
	
	Role findRole(String codeRole);
	
	Set<String> findRolesCodeByAccountName(String accountName);
	
	Set<Role> findRolesByAccountName(String accountName);
	
	List<Role> findAllRoles();
	
	int addRolesToAccount(List<Role> roles, Account account);
	
	boolean exist(Role role);
	
	boolean existRole(String codeRole);
}
