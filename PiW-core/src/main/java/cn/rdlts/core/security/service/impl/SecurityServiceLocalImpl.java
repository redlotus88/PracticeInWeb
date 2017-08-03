package cn.rdlts.core.security.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.rdlts.common.utils.LogUtils;
import cn.rdlts.common.utils.ToStringHelper;
import cn.rdlts.core.security.dao.RoleMapper;
import cn.rdlts.core.security.model.AccountRole;
import cn.rdlts.core.security.model.Role;
import cn.rdlts.core.security.service.SecurityService;
import cn.rdlts.core.usermgr.model.Account;
import cn.rdlts.core.usermgr.model.AccountVoid;

@Service("securityService")
public class SecurityServiceLocalImpl implements SecurityService {

	protected static Logger logger = Logger.getLogger(SecurityServiceLocalImpl.class);
	
	@Autowired
	private RoleMapper roleMapper;
	
	@Override
	public Role findRole(String codeRole) {
		return roleMapper.getByCode(codeRole);
	}
	
	@Override
	public Set<String> findRolesCodeByAccountName(String accountName) {
		logger.info(StringUtils.join("获取Accountname=[", accountName, "]的角色"));
		List<Role> roles = roleMapper.getByAccountName(accountName);
		return roles.stream().map(Role::getCode).collect(Collectors.toSet());
	}
	
	@Override
	public Set<Role> findRolesByAccountName(String accountName) {
		logger.info(StringUtils.join("获取Accountname=[", accountName, "]的角色"));
		return roleMapper.getByAccountName(accountName).stream().collect(Collectors.toSet());
	}
	
	@Override
	public List<Role> findAllRoles() {
		logger.info("获取所有角色信息...");
		return roleMapper.findAll();
	}

	@Override
	public int addRolesToAccount(List<Role> roles, Account account) {
		logger.info(StringUtils.join("为账户名=[", 
				getAccountNameOrEmpty(account), "] 添加角色：", ToStringHelper.toString(roles, Role::getCode)));
		if (CollectionUtils.isEmpty(roles)) {
			return 0;
		}
		
		AccountRole ar = new AccountRole(account, roles);
		return roleMapper.addRolesToAccount(ar);
	}

	@Override
	public int saveRolesToAccount(List<Role> roles, Account account) {
		logger.info(StringUtils.join("保存账户名=[", 
				getAccountNameOrEmpty(account), "] 的角色：", ToStringHelper.toString(roles, Role::getCode)));
		deleteRoles(account);
		return addRolesToAccount(roles, account);
	}

	@Override
	public boolean exist(Role role) {
		return roleMapper.exist(role);
	}

	@Override
	public boolean existRole(String codeRole) {
		return roleMapper.exist(new Role(codeRole));
	}

	@Override
	public int deleteRoles(Account account) {
		logger.info(StringUtils.join("删除账号[", getAccountNameOrEmpty(account) , "]的角色。"));
		if (account != null && CollectionUtils.isNotEmpty(roleMapper.getByAccountName(account.getAccountName()))) {
			return roleMapper.deleteRoles(account);
		}
		return 0;
	}
	
	@Override
	public int saveRole(Role role) {
		LogUtils.info(logger, "增加角色", role);
		int result = 0;
		if (role == null) {
			return result;
		}
		
		if (roleMapper.exist(role)) {
			result = roleMapper.update(role);
		} else {
			result = roleMapper.save(role);
		}
		return result;
	}

	private String getAccountNameOrEmpty(Account account) {
		return Optional.ofNullable(account).orElse(AccountVoid.getInstance()).getAccountName();
	}

	@Override
	public int deleteRole(Role role) {
		if (role == null) {
			return 0;
		}
		
		return roleMapper.delete(role);
	}
}
