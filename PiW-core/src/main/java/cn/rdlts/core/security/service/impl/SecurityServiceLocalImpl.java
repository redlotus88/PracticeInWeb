package cn.rdlts.core.security.service.impl;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.rdlts.core.security.dao.RoleMapper;
import cn.rdlts.core.security.model.AccountRole;
import cn.rdlts.core.security.model.Role;
import cn.rdlts.core.security.service.SecurityService;
import cn.rdlts.core.usermgr.model.Account;

@Service("securityService")
public class SecurityServiceLocalImpl implements SecurityService {

	protected static Logger logger = Logger.getLogger(SecurityServiceLocalImpl.class);
	
	@Autowired
	private RoleMapper roleMapper;
	
	public Role getRole(String codeRole) {
		return roleMapper.getByCode(codeRole);
	}
	
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

	@Override
	public int addRolesToAccount(List<Role> roles, Account account) {
		AccountRole ar = new AccountRole(account, roles);
		return roleMapper.addRolesToAccount(ar);
	}

	@Override
	public boolean exist(Role role) {
		return roleMapper.exist(role);
	}

	@Override
	public boolean existRole(String codeRole) {
		return roleMapper.exist(new Role(codeRole));
	}
}
