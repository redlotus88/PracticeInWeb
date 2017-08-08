package cn.rdlts.git;

import java.io.File;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.eclipse.jgit.api.CloneCommand;
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.ResetCommand.ResetType;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.revwalk.RevCommit;
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
	
	public Iterable<RevCommit> getCommits() {
		// TODO: 
		try {
			Iterable<RevCommit> commits = git.log().call();
			for (RevCommit rev : commits) {
				System.out.println(rev.getAuthorIdent());
				System.out.println(rev.getFullMessage());
				System.out.println(rev.getShortMessage());
				System.out.println(rev.getCommitTime());
			}
			
			return null;
		} catch (GitAPIException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public List<GitBranch> getBranches() {
		//TODO 得到所有Branch信息。
//		try {
//			List<Ref> refs = git.branchList().call();
//		} catch (GitAPIException e) {
//			e.printStackTrace();
//		}
		return null;
	}
	
	/**
	 * 调用该方法可以刷新本地的git仓库地址. 并重新生成gitRepository和git对象。
	 * 
	 * @param forced true表示强制清空git目录，重新clone一个新的。
	 * @throws Exception
	 */
	public void initRepository(boolean forced) throws Exception {
		String repository = configuration.getRepository();
		
		File repositoryDir = new File(repository);
		if (repositoryDir.exists() && !repositoryDir.isDirectory()) {
			throw new PiWGitRuntimeException("git.repository must be a directory.");
		}
		
		// 如果不存在git目录，或者强制刷新git目录，重新clone repo.
		if (!repositoryDir.exists() || (repositoryDir.exists() && forced)) {
			FileUtils.deleteDirectory(repositoryDir);
			repositoryDir.mkdirs();
			cloneRepository(repositoryDir);
		}
		
		File gitDir = new File(StringUtils.join(repository, GitConstants.GIT_FOLDER));
		if (!gitDir.exists()) {
			throw new PiWGitRuntimeException("Can't find /.git directory!");
		}
		
		FileRepositoryBuilder builder = new FileRepositoryBuilder();
		gitRepository = builder.setGitDir(gitDir)
								.readEnvironment()
								.findGitDir()
								.build();
		git = new Git(gitRepository);
		
		// 如果是非强制模式
		if (repositoryDir.exists() && !forced) {
			git.log().call();
			resetRepository();
		}
	}
	
	/**
	 * Reset repository to reference 
	 * git reset --hard [reference]
	 * 
	 * @throws Exception
	 */
	private void resetRepository() throws Exception {
		logger.info("Reset repository with configuration: " + configuration);
		String reference = configuration.getReference();
				
		// git reset --hard reference
		// e.g. git reset --hard remote/master
		logger.info("调用命令 git reset --hard " +  reference);
		git.reset().setMode(ResetType.HARD).setRef(reference).call();
		logger.info("End reset...");
	}
	
	/**
	 * Clone repository to repository
	 * 
	 * Bare: false 
	 * 
	 * @param gitDir
	 * @throws Exception
	 */
	private void cloneRepository(File gitDir) throws Exception {
		logger.info("Clone repository with configuration : " + configuration);
		
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

	protected Repository getGitRepository() {
		return gitRepository;
	}

	protected void setGitRepository(Repository gitRepository) {
		this.gitRepository = gitRepository;
	}
	
	public Git getGit() {
		return git;
	}

	public void setGit(Git git) {
		this.git = git;
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		initRepository(false);
	}
}
