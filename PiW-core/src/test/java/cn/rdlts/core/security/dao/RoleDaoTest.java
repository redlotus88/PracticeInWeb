package cn.rdlts.core.security.dao;

import java.util.Arrays;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import cn.rdlts.core.JUnit4SpringContextTests;
import cn.rdlts.core.TestUtils;
import cn.rdlts.core.security.model.AccountRole;
import cn.rdlts.core.security.model.Role;
import cn.rdlts.core.usermgr.model.Account;

@RunWith(JUnit4SpringContextTests.class)
@ContextConfiguration(value = "classpath:config/applicationContext.xml")
public class RoleDaoTest {
	
	private static Logger log = Logger.getLogger(RoleDaoTest.class);
	
	private static final String ROLE_TEST = "roleTest";
	
	private static final String DESCRIPTION_TEST = "test";
	
	@Autowired
	private RoleMapper roleMapper;
	
	private Role roleTest;
	
	@Before
	public void before() {
		deleteRole(ROLE_TEST);
		roleTest = saveRole(ROLE_TEST, DESCRIPTION_TEST);
	}
	
	@After
	public void after() {
		deleteRole(roleTest);
	}
	
	@Test
	public void getByCodeTest() {
		log.info("测试getByCode方法...");
		Role role = roleMapper.getByCode(ROLE_TEST);
		Assert.assertNotNull(role);
		log.info("测试结束");
	}
	
	@Test
	public void getByAccountNameTest() {
		log.info("测试getByAccountName方法...");
		List<Role> roles = roleMapper.getByAccountName("Rean");
		Assert.assertNotNull(roles);
		Assert.assertTrue(roles.size() > 0);
		log.info("测试结束");
	}
	
	@Test
	public void updateAndDeleteTest() {
		log.info("测试update和delete方法...");
		
		final String DESC_NEW = "Update test";
		Role roleToUpdate = roleMapper.getByCode(ROLE_TEST);
		Assert.assertNotNull(roleToUpdate);
		roleToUpdate.setCode("New code");
		roleToUpdate.setDescription(DESC_NEW);
		int result = roleMapper.update(roleToUpdate);
		Assert.assertEquals(result, 1);
		
		Role roleResult = roleMapper.getByCode(ROLE_TEST);
		Assert.assertNotNull(roleResult);
		Assert.assertEquals(DESC_NEW, roleResult.getDescription());
		// Code不变
		Assert.assertEquals(ROLE_TEST, roleResult.getCode());
		
		result = roleMapper.delete(roleResult);
		Assert.assertEquals(result, 1);
		roleResult = roleMapper.getByCode(ROLE_TEST);
		Assert.assertNull(roleResult);
		log.info("测试结束");
	}
	
	@Test
	public void addRolesToAccountTest() {
		log.info("测试为账号添加权限");
		deleteRole("roleAcc1");
		deleteRole("roleAcc2");
		Role role1 = saveRole("roleAcc1", "role1 desc");
		Role role2 = saveRole("roleAcc2", "role2 desc");
		Account account = TestUtils.deleteAndInsertNewAccount("Test", "123456", "salt1");
		
		AccountRole ar = new AccountRole(account, Arrays.asList(role1, role2));
		int result = roleMapper.addRolesToAccount(ar);
		Assert.assertEquals(2, result);
		List<Role> roles = roleMapper.getByAccountName("Test");
		Assert.assertTrue(CollectionUtils.isNotEmpty(roles));
		Assert.assertTrue(roles.contains(role1));
		Assert.assertTrue(roles.contains(role2));
		
		deleteRole(role1);
		deleteRole(role2);
		log.info("addRolesToAccountTest测试结束");
	}
	
	private Role saveRole(String code, String desc) {
		log.info("创建Role[code=" + code + ", description=" + desc + "]");
		int result = roleMapper.save(new Role(code, desc));
		Assert.assertEquals(result, 1);
		Role newRole = roleMapper.getByCode(code);
		Assert.assertNotNull(newRole);
		return newRole;
	}
	
	private int deleteRole(Role role) {
		return roleMapper.delete(role);
	}
	
	private int deleteRole(String code) {
		return deleteRole(new Role(code));
	}
}
