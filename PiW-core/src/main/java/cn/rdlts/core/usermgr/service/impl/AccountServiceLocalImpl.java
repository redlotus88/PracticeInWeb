package cn.rdlts.core.usermgr.service.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.apache.shiro.util.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.rdlts.core.constant.ServiceConstants;
import cn.rdlts.core.security.dao.RoleMapper;
import cn.rdlts.core.security.model.AccountRole;
import cn.rdlts.core.security.model.Role;
import cn.rdlts.core.security.model.RoleEnum;
import cn.rdlts.core.usermgr.dao.AccountMapper;
import cn.rdlts.core.usermgr.model.Account;
import cn.rdlts.core.usermgr.service.AccountService;
import cn.rdlts.core.utils.ShiroPasswordHelper;

@Service("accountService")
public class AccountServiceLocalImpl implements AccountService {

	private static Logger logger = Logger.getLogger(AccountServiceLocalImpl.class);
	
	@Autowired
	private AccountMapper accountMapper;
	
	@Autowired
	private RoleMapper roleMapper;
	
	@Override
	public Account getById(Integer id) {
		return accountMapper.getById(id);
	}

	@Override
	public Account getByName(String name) {
		logger.info(StringUtils.join("根据name[", name, "]查找账号"));
		return accountMapper.getByName(name);
	}

	@Override
	public List<Account> findAll() {
		return accountMapper.findAll();
	}

	@Override
	public int save(final Account account) {
		logger.info(StringUtils.join("保存用户信息：", account));
		if (exist(account)) {
			logger.error(StringUtils.join("已存在用户[", account.getAccountName(), "], 无法创建"));
			return ServiceConstants.NO_AFFECTED_LINE;
		}
		
		Account toSave = ShiroPasswordHelper.encryptPassword(account);
		int affectedRow = accountMapper.save(toSave);
		logger.info(StringUtils.join("保存结束。影响", Integer.toString(affectedRow), "行"));
		return affectedRow;
	}
	
	@Override
	public int save(Account account, List<Role> roles) {
		int result = save(account);
		if (CollectionUtils.isEmpty(roles)) {
			Role guestRole = roleMapper.getByCode(RoleEnum.GUEST.getCode());
			roles.add(guestRole);
		}
		
		roleMapper.addRolesToAccount(new AccountRole(account, roles));
		return result;
	}

	@Override
	public boolean exist(final Account account) {
		return accountMapper.exist(account);
	}
	
	@Override
	public boolean exist(String accountName) {
		return accountMapper.exist(new Account(accountName));
	}

	@Override
	public int update(final Account account) {
		logger.info("更新用户信息：" + account);
		Account toUpdate = ShiroPasswordHelper.encryptPassword(account);
		int affectedRow = accountMapper.update(toUpdate);
		logger.info(StringUtils.join("更新完成，影响", Integer.toString(affectedRow), "行。"));
		return affectedRow;
	}
	
	@Override
	public int delete(final Account account) {
		logger.info(StringUtils.join("删除账号：", account.toString()));
		int affectedRow = accountMapper.delete(account);
		logger.info(StringUtils.join("删除成功，影响", Integer.toString(affectedRow), "行。"));
		return affectedRow;
	}

	@Override
	public List<Account> findAccountBy(Role role) {
		// TODO Auto-generated method stub
		return null;
	}

}
