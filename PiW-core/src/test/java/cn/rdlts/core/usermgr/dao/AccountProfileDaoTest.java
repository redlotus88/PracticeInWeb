package cn.rdlts.core.usermgr.dao;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import cn.rdlts.core.JUnit4SpringContextTests;
import cn.rdlts.core.usermgr.model.AccountProfile;

@RunWith(JUnit4SpringContextTests.class)
@ContextConfiguration(value = "classpath:config/applicationContext.xml")
public class AccountProfileDaoTest {
	
	private static Log log = LogFactory.getLog(AccountProfileDaoTest.class);
	
	private final int ACCOUNT_ID = 1;
	private final String PROFILE_NAME_PTEST = "ptest";
	private final String PUBLIC_EMAIL_TEST = "test@test.com";
	private final String COMPANY_TEST = "testComp";
	
	@Autowired
	private AccountProfileMapper accountProfileMapper;
	
	private AccountProfile initAccProfile;
	
	@Before
	public void before() {
		initAccProfile = deleteAndInsertNewAccountProfile(ACCOUNT_ID, PROFILE_NAME_PTEST, PUBLIC_EMAIL_TEST, COMPANY_TEST);
	}
	
	@After
	public void after() {
		log.info("删除AccountProfile:" + initAccProfile);
		accountProfileMapper.delete(initAccProfile);
	}
	
	@Test
	public void findAllTest() {
		List<AccountProfile> list = accountProfileMapper.findAll();
		Assert.assertNotNull(list);
		Assert.assertTrue(list.size() != 0);
	}
	
	@Test
	public void updateTest() {
		AccountProfile toUpdate = accountProfileMapper.getById(ACCOUNT_ID);
		toUpdate.setPublicEmail("updated@test.com");
		toUpdate.setProfileName("newTest");
		toUpdate.setCompany("newComp");
		
		int result = accountProfileMapper.update(toUpdate);
		Assert.assertEquals(result, 1);
	}
	
	private AccountProfile deleteAndInsertNewAccountProfile(int id, String profileName, String publicEmail, String company) {
		AccountProfile ap = new AccountProfile(id, profileName, publicEmail, company);
		log.info("创建AccountProfile : " + ap);
		accountProfileMapper.delete(ap);
		int result = accountProfileMapper.save(ap);
		Assert.assertEquals(result, 1);
		AccountProfile apResult = accountProfileMapper.getById(id);
		Assert.assertNotNull(apResult);
		return apResult;
	}
	
}
