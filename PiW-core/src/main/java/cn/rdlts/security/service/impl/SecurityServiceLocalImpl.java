package cn.rdlts.security.service.impl;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.rdlts.security.dao.RoleMapper;
import cn.rdlts.security.model.Role;
import cn.rdlts.security.service.SecurityService;

@Service("securityService")
public class SecurityServiceLocalImpl implements SecurityService {

	@Autowired
	private RoleMapper roleMapper;

	@Override
	public Set<String> getRolesByAccountName(String accountName) {
		List<Role> roles = roleMapper.getByAccountName(accountName);
		Set<String> results = roles.stream().map(Role::getCode).collect(Collectors.toSet());
		return results;
	}
	

}
