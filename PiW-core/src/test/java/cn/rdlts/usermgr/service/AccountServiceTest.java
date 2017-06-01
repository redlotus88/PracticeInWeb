package cn.rdlts.usermgr.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import cn.rdlts.usermgr.JUnit4SpringContextTests;
import cn.rdlts.usermgr.model.Account;

@RunWith(JUnit4SpringContextTests.class)
@ContextConfiguration(value = "classpath:config/applicationContext.xml")
public class AccountServiceTest {
	
	private static Log LOGGER = LogFactory.getLog(AccountServiceTest.class);
	
	@Autowired
	private AccountService accountServiceImpl;
	
	@Test
	public void saveTest() {
		Account account = new Account("Rean_Wang", "123456");
		accountServiceImpl.save(account);
	}
}
