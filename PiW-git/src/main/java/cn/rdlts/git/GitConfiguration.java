package cn.rdlts.git;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class GitConfiguration {
	
	@Value("${git.username}")
	private String username;
	
	@Value("${git.password}")
	private String password;
	
	@Value("${git.repository}")
	private String repository;
	
	@Value("${git.cloneUrl}")
	private String cloneUrl;
	
	/**
	 * 默认值为origin
	 */
	@Value("${git.reference:HEAD}")
	private String reference;
	
	/**
	 * 默认值为*
	 */
	@Value("${git.branch:*}")
	private String branch;
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRepository() {
		return repository;
	}

	public void setRepository(String repository) {
		this.repository = repository;
	}

	public String getCloneUrl() {
		return cloneUrl;
	}

	public void setCloneUrl(String cloneUrl) {
		this.cloneUrl = cloneUrl;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
