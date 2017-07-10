package cn.rdlts.core.security.service.impl;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.rdlts.core.security.dao.RoleMapper;
import cn.rdlts.core.security.model.Role;
import cn.rdlts.core.security.service.SecurityService;

@Service("securityService")
public class SecurityServiceLocalImpl implements SecurityService {

	protected static Logger logger = Logger.getLogger(SecurityServiceLocalImpl.class);
	
	@Autowired
	private RoleMapper roleMapper;
	
	@Override
	public Set<String> getRolesByAccountName(String accountName) {
		List<Role> roles = roleMapper.getByAccountName(accountName);
		return roles.stream().map(Role::getCode).collect(Collectors.toSet());
	}
}
