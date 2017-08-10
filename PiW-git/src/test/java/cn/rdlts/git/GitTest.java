package cn.rdlts.git;

import org.apache.commons.lang3.StringUtils;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;

@RunWith(PiWJunit4GitTestRunner.class)
@ContextConfiguration(value = "classpath:config/applicationContext.xml")
public class GitTest {

	@Autowired
	@Qualifier("gitRepo")
	private PiWGit piWGit;
	
//	@Test
	public void gitTest() {
		Assert.assertNull(piWGit.getConfiguration().getUsername());
		Assert.assertNull(piWGit.getConfiguration().getPassword());
		Assert.assertEquals(piWGit.getConfiguration().getRepository(), "./target/git");
		Assert.assertEquals(piWGit.getConfiguration().getBranch(), "*");
		Assert.assertTrue(StringUtils.isNotEmpty(piWGit.getConfiguration().getCloneUrl()));
		Assert.assertNotNull(piWGit.getGitRepository());
	}
	
	@Test
	public void getBranchesTest() {
		Assert.assertTrue(piWGit.getBranches().size() > 0);
	}
}
