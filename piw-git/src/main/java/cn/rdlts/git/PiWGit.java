package cn.rdlts.git;

import java.io.File;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.eclipse.jgit.api.CloneCommand;
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.lib.Ref;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.storage.file.FileRepositoryBuilder;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cn.rdlts.git.core.GitBranch;
import cn.rdlts.git.exception.PiWGitRuntimeException;

@Component(value="piWGit")
public class PiWGit implements InitializingBean {
	
	private static Log logger = LogFactory.getLog(PiWGit.class);
	
	@Autowired
	private GitConfiguration configuration;
	
	private Repository gitRepository;
	
	private Git git;
	
	public PiWGit() {
		// nothing to do.
	}
	
	public List<GitBranch> getBranches() {
		try {
			List<Ref> refs = git.branchList().call();
		} catch (GitAPIException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void initRepository() throws Exception {
		String repository = configuration.getRepository();
		boolean alreadyClone = true;
		
		File gitDir = new File(repository);
		if (!gitDir.isDirectory()) {
			throw new PiWGitRuntimeException("git.repository must be a directory.");
		}
		
		File gitFile = new File(repository + File.separator + GitConstants.GIT_SUFFIX);
		alreadyClone = gitDir.exists() && gitFile.exists();
		
		if (!alreadyClone) {
			// 如果.git文件不存在，则删除目录，重新创建.
			FileUtils.deleteDirectory( gitDir);
			gitDir.mkdirs();
			cloneRepository(gitDir);
		} else {
			// TODO 如果存在git文件 则当branch不是*的时候，checkout branch
		}
		
		FileRepositoryBuilder builder = new FileRepositoryBuilder();
		gitRepository = builder.setGitDir(gitDir)
								.readEnvironment()
								.findGitDir()
								.build();
		git = new Git(gitRepository);
	}
	
	private void cloneRepository(File gitDir) throws Exception {
		logger.info("Clone repository from url : " + configuration.getCloneUrl());
		
		String branch = configuration.getBranch();
		// 初始化git repository
		CloneCommand cloneCmd = Git.cloneRepository()
										.setBare(false)
										.setDirectory(gitDir)
										.setURI(configuration.getCloneUrl());
		
		// 解析 branch.
		if (GitConstants.JOKE.equals(branch)) {
			cloneCmd.setCloneAllBranches(true);
		} else {
			cloneCmd.setBranch(branch);
		}
		
		cloneCmd.call();
		logger.info("Clone end...");
	}
	
	public GitConfiguration getConfiguration() {
		return configuration;
	}

	public void setConfiguration(GitConfiguration configuration) {
		this.configuration = configuration;
	}

	public Repository getGitRepository() {
		return gitRepository;
	}

	public void setGitRepository(Repository gitRepository) {
		this.gitRepository = gitRepository;
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		initRepository();
	}
}
