package cn.rdlts.core.usermgr.service;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import cn.rdlts.core.JUnit4SpringContextTests;
import cn.rdlts.core.usermgr.model.Account;

@RunWith(JUnit4SpringContextTests.class)
@ContextConfiguration(value = "classpath:config/applicationContext.xml")
public class AccountServiceTest {
	
	private static Logger logger = Logger.getLogger(AccountServiceTest.class);
	
	@Autowired
	private AccountService accountService;
	
	@Before
	public void before() {
		
	}
	
	@After
	public void after() {
		
	}
	
	@Test
	public void saveTest() {
		Account account = new Account("Rean_Wang", "123456");
		accountService.save(account);
	}
}
