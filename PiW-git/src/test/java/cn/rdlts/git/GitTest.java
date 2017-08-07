package cn.rdlts.git;

import org.apache.commons.lang3.StringUtils;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

@RunWith(PiWJunit4GitTestRunner.class)
@ContextConfiguration(value = "classpath:config/applicationContext.xml")
public class GitTest {

	@Autowired
	private PiWGit piWGit;
	
	@Test
	public void gitTest() {
		Assert.assertEquals(piWGit.getConfiguration().getUsername(), StringUtils.EMPTY);
		Assert.assertEquals(piWGit.getConfiguration().getPassword(), StringUtils.EMPTY);
		Assert.assertEquals(piWGit.getConfiguration().getRepository(), "./target/git");
		Assert.assertEquals(piWGit.getConfiguration().getBranch(), "*");
		Assert.assertTrue(StringUtils.isNotEmpty(piWGit.getConfiguration().getCloneUrl()));
		Assert.assertNotNull(piWGit.getGitRepository());
	}
	
	
}
