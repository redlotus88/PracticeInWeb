package cn.rdlts.usermgr.dao;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import cn.rdlts.security.dao.RoleMapper;
import cn.rdlts.security.model.Role;
import cn.rdlts.usermgr.JUnit4SpringContextTests;

@RunWith(JUnit4SpringContextTests.class)
@ContextConfiguration(value = "classpath:config/applicationContext.xml")
public class RoleDaoTest {
	
	private static Log LOGGER = LogFactory.getLog(AccountDaoTest.class);
	
	@Autowired
	private RoleMapper roleMapper;
	
	@Test
	public void getByCodeTest() {
		Role role = roleMapper.getByCode("admin");
		Assert.assertNotNull(role);
	}
	
	@Test
	public void getByAccountNameTest() {
		List<Role> roles = roleMapper.getByAccountName("Rean");
		Assert.assertNotNull(roles);
		Assert.assertTrue(roles.size() > 0);
	}
}
