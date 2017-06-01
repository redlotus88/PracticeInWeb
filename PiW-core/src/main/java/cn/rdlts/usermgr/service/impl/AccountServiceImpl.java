package cn.rdlts.usermgr.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.rdlts.usermgr.dao.AccountMapper;
import cn.rdlts.usermgr.model.Account;
import cn.rdlts.usermgr.service.AccountService;
import cn.rdlts.utils.DateUtils;
import cn.rdlts.utils.PasswordHelper;
import cn.rdlts.utils.ServiceConstants;

@Service
public class AccountServiceImpl implements AccountService {

	private static final Log LOGGER = LogFactory.getLog(AccountServiceImpl.class);
	
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
		LOGGER.info("保存用户信息：" + account);
		if (exist(account)) {
			LOGGER.error("已存在用户[" + account.getAccountName() + "], 无法创建");
			return ServiceConstants.NO_AFFECTED_LINE;
		}
		
		Account toSave = PasswordHelper.encryptPassword(account);
		toSave.setCreateTime(DateUtils.nowTime());
		int affectedRow = accountMapper.save(toSave);
		LOGGER.info("保存结束。影响" + affectedRow + "行");
		return affectedRow;
	}

	@Override
	public boolean exist(final Account account) {
		return accountMapper.exist(account);
	}

	@Override
	public int update(final Account account) {
		LOGGER.info("更新用户信息：" + account);
		Account toUpdate = PasswordHelper.encryptPassword(account);
		toUpdate.setLastModifyTime(LocalDateTime.now());
		int affectedRow = accountMapper.update(toUpdate);
		LOGGER.info("更新完成，影响" + affectedRow + "行");
		return affectedRow;
	}
}
