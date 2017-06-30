package cn.rdlts.core.security.service;

import java.util.Set;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import cn.rdlts.core.JUnit4SpringContextTests;
import cn.rdlts.core.security.service.SecurityService;

@RunWith(JUnit4SpringContextTests.class)
@ContextConfiguration(value = "classpath:config/applicationContext.xml")
public class SecurityServiceTest {
	
	@Autowired
	private SecurityService securityService;
	
	@Test
	public void getRolesByAccountNameTest() {
		Set<String> rolesRean = securityService.getRolesByAccountName("Rean");
		Set<String> rolesAlisa = securityService.getRolesByAccountName("Alisa");
		Set<String> nothing = securityService.getRolesByAccountName("adsfasj.x=1\"s");
		
		Assert.assertNotNull(rolesRean);
		Assert.assertNotNull(rolesAlisa);
		Assert.assertNotNull(nothing);
		
		Assert.assertTrue(rolesRean.size() > 0);
		Assert.assertTrue(rolesAlisa.size() > 0);
		Assert.assertEquals(nothing.size(), 0);
		
	}
}
