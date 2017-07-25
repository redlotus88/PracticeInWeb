package cn.rdlts.core;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cn.rdlts.core.usermgr.dao.AccountMapper;
import cn.rdlts.core.usermgr.model.Account;

@Component
public final class TestUtils {
	
	@Autowired
	private AccountMapper accountMapper;
	
	private static TestUtils testUtils;
	
	private TestUtils() {
	}
	
	@PostConstruct
	public void init() {
		testUtils = this;
		testUtils.accountMapper = this.accountMapper;
	}
	
	public static Account deleteAndInsertNewAccount(String accName, String password, String salt) {
		Account account = new Account(accName, password, salt);
		
		testUtils.accountMapper.delete(account);
		Integer id = testUtils.accountMapper.save(account);
		assertNotNull(id);
		assertTrue(id > 0);
		return account;
	}
	
	
}
