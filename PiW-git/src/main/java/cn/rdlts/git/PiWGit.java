package cn.rdlts.git;

import java.io.File;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.eclipse.jgit.api.CloneCommand;
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.ResetCommand.ResetType;
import org.eclipse.jgit.lib.Ref;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.storage.file.FileRepositoryBuilder;
import org.springframework.beans.factory.InitializingBean;

import cn.rdlts.git.core.Branch;
import cn.rdlts.git.exception.PiWGitRuntimeException;

public class PiWGit implements InitializingBean {
	
	private static Log logger = LogFactory.getLog(PiWGit.class);
	
	private GitConfiguration configuration;
	
	private Repository gitRepository;
	
	private Git git;
	
	private boolean lazyLoad = false;
	
	private boolean initialized = false;
	
	public PiWGit() {
		// nothing to do.
	}
	
	public String getUri() {
		return configuration.getCloneUrl();
	}
	
	public List<Branch> getBranches() {
		Map<String, Ref> refs = getGitRepository().getAllRefs();
		for (Ref ref : refs.values()) {
			System.out.println(ref.getName() + ref.getObjectId().getName());
		}
		return Collections.EMPTY_LIST;
	}
	
	/**
	 * 调用该方法可以刷新本地的git仓库地址. 并重新生成gitRepository和git对象。
	 * 
	 * @param forced true表示强制清空git目录，重新clone一个新的。
	 * @throws Exception
	 */
	public synchronized void initRepository(boolean forced) throws Exception {
		if (configuration == null) {
			logger.warn("No configuration found!");
			return;
		}
		
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
			throw new PiWGitRuntimeException("无法找到.git目录[" + gitDir.getAbsolutePath() + "]");
		}
		
		FileRepositoryBuilder builder = new FileRepositoryBuilder();
		gitRepository = builder.setGitDir(gitDir)
								.readEnvironment()
								.findGitDir()
								.build();
		git = new Git(gitRepository);
		// 如果是非强制模式
		if (repositoryDir.exists() && !forced) {
			resetRepository();
		}
		
		GitRegistration.register(this);
		initialized = true;
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
	
	public boolean isLazyLoad() {
		return lazyLoad;
	}

	public void setLazyLoad(boolean lazyLoad) {
		this.lazyLoad = lazyLoad;
	}

	protected Repository getGitRepository() {
		lazyLoad();
		return gitRepository;
	}
	
	protected Git getGit() {
		lazyLoad();
		return git;
	}

	private void lazyLoad() {
		if (!initialized && lazyLoad) {
			try {
				initRepository(false);
			} catch (Exception e) {
				throw new PiWGitRuntimeException("懒加载初始化git repository[" + configuration.getRepository() + "]失败", e);
			}
		}
	}
	
	@Override
	public void afterPropertiesSet() throws Exception {
		if (!lazyLoad) {
			initRepository(false);
		} else {
			GitRegistration.register(this);
		}
	}
}
