package cn.rdlts.usermgr.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.time.LocalDateTime;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import cn.rdlts.usermgr.JUnit4SpringContextTests;
import cn.rdlts.usermgr.model.Account;

@RunWith(JUnit4SpringContextTests.class)
@ContextConfiguration(value = "classpath:config/applicationContext.xml")
public class AccountDaoTest {
	
	private static Log LOGGER = LogFactory.getLog(AccountDaoTest.class);
	
	private final String ACCOUNT_TEST = "test";
	private final String PASSWORD_12345678 = "12345678";
	private final String SALT_1 = "salt1";
	
	@Autowired
	private AccountMapper accountMapper;
	
	private Account initAcc;

	@Before
	public void before() {
		initAcc = deleteAndInsertNewAccount(ACCOUNT_TEST, PASSWORD_12345678, SALT_1);
	}
	
	@After
	public void after() {
		accountMapper.delete(initAcc);
	}
	
	@Test
	public void getByIdTest() {
		LOGGER.info("开始测试方法：getByIdTest");
		Account account = accountMapper.getById(initAcc.getId());
		assertNotNull(account);
		assertAccount(account, ACCOUNT_TEST, PASSWORD_12345678, SALT_1);
		
		account = accountMapper.getById(-1);
		assertNull(account);
		LOGGER.info("测试结束");
	}
	
	@Test
	public void getByNameTest() {
		LOGGER.info("开始测试方法：getByNameTest");
		Account accDb = accountMapper.getByName(ACCOUNT_TEST);
		assertNotNull(accDb);
		assertAccount(accDb, ACCOUNT_TEST, PASSWORD_12345678, SALT_1);
		LOGGER.info("测试结束");
	}
	
	@Test
	public void findAllTest() {
		List<Account> accounts = accountMapper.findAll();
		assertNotNull(accounts);
	}
	
	@Test
	public void saveAndDeleteTest() {
		Account accToDel = accountMapper.getById(initAcc.getId());
		assertTrue("要删除的元素与插入的元素不符合。", accToDel.getAccountName().equals(initAcc.getAccountName()));
		assertEquals(ACCOUNT_TEST, accToDel.getAccountName());
		assertEquals(PASSWORD_12345678, accToDel.getPassword());
		assertEquals(SALT_1, accToDel.getSalt());
		assertNotNull(accToDel.getId());
		assertNotNull(accToDel.getCreateTime());
		
		/** ID删除 */
		accountMapper.delete(accToDel);
		
		accToDel = accountMapper.getById(accToDel.getId());
		assertNull(accToDel);
		
		/** username 删除 */
		Account account = deleteAndInsertNewAccount(ACCOUNT_TEST, PASSWORD_12345678, SALT_1);
		Account accWithoutId = new Account(ACCOUNT_TEST);
		accountMapper.delete(accWithoutId);
		
		accToDel = accountMapper.getById(account.getId());
		assertNull(accToDel);
	}
	
	@Test
	public void existTest() {
		Account account = deleteAndInsertNewAccount(ACCOUNT_TEST, PASSWORD_12345678, SALT_1);
		boolean result = accountMapper.exist(account);
		assertTrue(result);
		
		Account nonExist = new Account("j3r;23iur9x8");
		result = accountMapper.exist(nonExist);
		assertFalse(result);
	}
	
	@Test
	public void updateTest() {
		Account account = accountMapper.getById(initAcc.getId());
		assertNotNull(account.getCreateTime());
		assertNull(account.getLastModifyTime());
		account.setPassword("87654321");
		account.setLastModifyTime(LocalDateTime.now());
		accountMapper.update(account);
		
		account = accountMapper.getById(initAcc.getId());
		assertNotNull(account.getCreateTime());
		assertNotNull(account.getLastModifyTime());
		assertEquals("87654321", account.getPassword());
	}
	
	private Account deleteAndInsertNewAccount(String accName, String password, String salt) {
		Account account = new Account(accName, password, salt);
		account.setCreateTime(LocalDateTime.now());
		accountMapper.delete(account);
		Integer id = accountMapper.save(account);
		assertNotNull(id);
		assertTrue(id > 0);
		return account;
	}
	
	private void assertAccount(Account account, String expectedName, 
			String expectedPassword, String expectedSalt) {
		assertNotNull(account);
		assertEquals(account.getAccountName(), expectedName);
		assertEquals(account.getPassword(), expectedPassword);
		assertEquals(account.getSalt(), expectedSalt);
	}
}
