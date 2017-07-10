package cn.rdlts.core.security.dao;

import java.time.LocalDateTime;
import java.util.List;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.ibatis.binding.BindingException;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import cn.rdlts.core.JUnit4SpringContextTests;
import cn.rdlts.core.security.model.LoginInfo;
import cn.rdlts.core.security.model.LoginInfo.Type;

@RunWith(JUnit4SpringContextTests.class)
@ContextConfiguration(value = "classpath:config/applicationContext.xml")
public class LoginInfoDaoTest {
	
	private static Logger logger = Logger.getLogger(LoginInfoDaoTest.class);
	
	private static final int TEST_ACCOUNT_ID = 1;
	
	private static final String TEST_LOGIN_IP = "192.168.1.1";
	
	@Autowired
	private LoginInfoMapper loginInfoMapper;
	
	private LoginInfo loginInfoTest;
	
	@Before
	public void before() {
		loginInfoTest = createLoginInfo(TEST_ACCOUNT_ID, TEST_LOGIN_IP);
		Assert.assertNotNull(loginInfoTest);
	}
	
	@After
	public void after() {
	}

	@Test
	public void findAllByTest() {
		logger.info("测试findAllBy方法：");
		List<LoginInfo> results = loginInfoMapper.findAllBy(TEST_ACCOUNT_ID);
		Assert.assertTrue(results.size() > 0);
	}
	
	@Test
	public void findAllTest() {
		logger.info("测试findAll方法：");
		List<LoginInfo> results = loginInfoMapper.findAll();
		logger.info("结果：" + ToStringBuilder.reflectionToString(results));
		Assert.assertTrue(results.size() > 0);
	}
	
	@Test(expected = BindingException.class)
	public void deleteTest() {
		logger.info("测试delete方法：");
		loginInfoMapper.delete(new LoginInfo());
	}
	
	@Test(expected = BindingException.class)
	public void updateTest() {
		logger.info("测试update方法：");
		loginInfoMapper.update(new LoginInfo());
	}
	
	public LoginInfo createLoginInfo(int accountId, String loginIp) {
		LoginInfo loginInfo = new LoginInfo();
		loginInfo.setLoginIp(loginIp);
		loginInfo.setAccountId(accountId);
		loginInfo.setRecordTime(LocalDateTime.now());
		loginInfo.setType(Type.LOGIN);
		
		loginInfoMapper.save(loginInfo);
		return loginInfoMapper.getById(loginInfo.getSerial());
	}
	
}
