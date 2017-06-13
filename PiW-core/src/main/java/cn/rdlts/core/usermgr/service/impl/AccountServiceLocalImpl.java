package cn.rdlts.core.usermgr.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.rdlts.core.constant.ServiceConstants;
import cn.rdlts.core.usermgr.dao.AccountMapper;
import cn.rdlts.core.usermgr.model.Account;
import cn.rdlts.core.usermgr.service.AccountService;
import cn.rdlts.core.utils.DateUtils;
import cn.rdlts.core.utils.ShiroPasswordHelper;

@Service("accountService")
public class AccountServiceLocalImpl implements AccountService {

	private static Log logger = LogFactory.getLog(AccountServiceLocalImpl.class);
	
	@Autowired
	private AccountMapper accountMapper;
	
	@Override
	public Account getById(Integer id) {
		return accountMapper.getById(id);
	}

	@Override
	public Account getByName(String name) {
		return accountMapper.getByName(name);
	}

	@Override
	public List<Account> findAll() {
		return accountMapper.findAll();
	}

	@Override
	public Integer save(final Account account) {
		logger.info("保存用户信息：" + account);
		if (exist(account)) {
			logger.error("已存在用户[" + account.getAccountName() + "], 无法创建");
			return ServiceConstants.NO_AFFECTED_LINE;
		}
		
		Account toSave = ShiroPasswordHelper.encryptPassword(account);
		toSave.setCreateTime(DateUtils.nowTime());
		int affectedRow = accountMapper.save(toSave);
		logger.info("保存结束。影响" + affectedRow + "行");
		return affectedRow;
	}

	@Override
	public boolean exist(final Account account) {
		return accountMapper.exist(account);
	}

	@Override
	public int update(final Account account) {
		logger.info("更新用户信息：" + account);
		Account toUpdate = ShiroPasswordHelper.encryptPassword(account);
		toUpdate.setLastModifyTime(LocalDateTime.now());
		int affectedRow = accountMapper.update(toUpdate);
		logger.info("更新完成，影响" + affectedRow + "行");
		return affectedRow;
	}
}
