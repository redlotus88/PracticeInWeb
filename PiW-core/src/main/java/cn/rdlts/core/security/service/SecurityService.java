package cn.rdlts.core.security.service;

import java.util.List;
import java.util.Set;

import cn.rdlts.core.security.model.Role;

public interface SecurityService {
	
	Set<String> getRolesByAccountName(String accountName);
	
	List<Role> findAllRoles();
	
}
