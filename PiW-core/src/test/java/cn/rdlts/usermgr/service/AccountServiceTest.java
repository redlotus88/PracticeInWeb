package cn.rdlts.usermgr.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import cn.rdlts.core.usermgr.model.Account;
import cn.rdlts.core.usermgr.service.AccountService;
import cn.rdlts.usermgr.JUnit4SpringContextTests;

@RunWith(JUnit4SpringContextTests.class)
@ContextConfiguration(value = "classpath:config/applicationContext.xml")
public class AccountServiceTest {
	
	private static Log LOGGER = LogFactory.getLog(AccountServiceTest.class);
	
	@Autowired
	private AccountService accountService;
	
	@Test
	public void saveTest() {
		Account account = new Account("Rean_Wang", "123456");
		accountService.save(account);
	}
}
