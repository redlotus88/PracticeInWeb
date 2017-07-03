package cn.rdlts.core.usermgr.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.rdlts.core.usermgr.dao.AccountMapper;
import cn.rdlts.core.usermgr.dao.AccountProfileMapper;
import cn.rdlts.core.usermgr.model.Account;
import cn.rdlts.core.usermgr.model.AccountProfile;
import cn.rdlts.core.usermgr.service.AccountProfileService;

@Service("accountProfileService")
public class AccountProfileServiceLocalImpl implements AccountProfileService {

	private static Logger logger = Logger.getLogger(AccountProfileServiceLocalImpl.class);
	
	@Autowired
	private AccountProfileMapper accountProfileMapper;
	
	@Autowired
	private AccountMapper accountMapper;
	
	@Override
	public AccountProfile getById(Integer id) {
		logger.info("获取id=[" + id + "]的AccountProfile。");
		return accountProfileMapper.getById(id);
	}

	@Override
	public List<AccountProfile> findAll() {
		logger.info("查找所有AccountProfile对象。");
		return accountProfileMapper.findAll();
	}

	@Override
	public Integer save(AccountProfile accountProfile) {
		logger.info("插入AccountProfile : " + accountProfile);
		int result = accountProfileMapper.save(accountProfile);
		int accountId = accountProfile.getId();
		updateAccount(accountId);
		return result;
	}

	@Override
	public boolean exist(AccountProfile accountProfile) {
		logger.info("查询对象" + accountProfile + "是否存在");
		return accountProfileMapper.exist(accountProfile);
	}

	@Override
	public int update(AccountProfile accountProfile) {
		logger.info("更新对象 : " + accountProfile);
		int result = accountProfileMapper.update(accountProfile);
		int accountId = accountProfile.getId();
		updateAccount(accountId);
		return result;
	}
	
	private void updateAccount(int accountId) {
		Account account = accountMapper.getById(accountId);
		if (account == null) {
			logger.warn("AccountProfile的id无效，未找到相关Account.");
		} else {
			logger.info("更新Account最后更改时间。");
			accountMapper.update(account);
		}
	}
}
