package cn.rdlts.core.security.service.impl;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
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
		logger.info(StringUtils.join("获取Accountname=[", accountName, "]的角色"));
		List<Role> roles = roleMapper.getByAccountName(accountName);
		return roles.stream().map(Role::getCode).collect(Collectors.toSet());
	}
	
	@Override
	public List<Role> findAllRoles() {
		logger.info("获取所有角色信息...");
		return roleMapper.findAll();
	}
}
