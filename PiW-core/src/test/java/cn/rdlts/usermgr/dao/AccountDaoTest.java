package cn.rdlts.usermgr.dao;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.rdlts.usermgr.AbstractJUnit4SpringContextTests;
import cn.rdlts.usermgr.dao.mapper.AccountMapper;
import cn.rdlts.usermgr.model.Account;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = "classpath:config/applicationContext.xml")
public class AccountDaoTest extends AbstractJUnit4SpringContextTests {
	
	@Resource
	private AccountMapper accountMapper;
	
	@Test
	public void getByIdTest() {
		Account account = accountMapper.getById(1);
		assertNotNull(account);
		assertTrue("Rean".equals(account.getAccountName()));
		assertTrue("1qaz2wsx".equals(account.getPassword()));
	}
	
	@Test
	public void findAllTest() {
		List<Account> accounts = accountMapper.findAll();
		assertNotNull(accounts);
	}
	
	@Test
	public void saveAndDelete() {
		Account account = new Account("test", "12345678");
		accountMapper.delete(account);
		Integer id = accountMapper.save(account);
		assertNotNull(id);
		assertTrue(id > 0);
		
		Account accToDel = accountMapper.getById(account.getId());
		assertTrue("要删除的元素与插入的元素不符合。", accToDel.getAccountName().equals(account.getAccountName()));
		assertNotNull(accToDel.getId());
		accountMapper.delete(accToDel);
		
		accToDel = accountMapper.getById(accToDel.getId());
		assertNull(accToDel);
	}
	
}
