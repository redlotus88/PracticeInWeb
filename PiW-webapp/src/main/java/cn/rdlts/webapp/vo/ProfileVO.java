package cn.rdlts.webapp.vo;

import cn.rdlts.core.usermgr.model.AccountProfile;

public final class ProfileVO {
	
	private String accountName;
	private String profileName;
	private String publicEmail;
	private String company;
	
	public ProfileVO() {
		// Nothing to do.
	}
	
	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public String getProfileName() {
		return profileName;
	}

	public void setProfileName(String profileName) {
		this.profileName = profileName;
	}

	public String getPublicEmail() {
		return publicEmail;
	}

	public void setPublicEmail(String publicEmail) {
		this.publicEmail = publicEmail;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}
	
	public void accept(AccountProfile accountProfile) {
		if (accountProfile != null) {
			
		}
	}
	
	public void decorate(AccountProfile accountProfile) {
		if (accountProfile != null) {
			accountProfile.setProfileName(profileName);
			accountProfile.setPublicEmail(publicEmail);
			accountProfile.setCompany(company);
		} 
	}
}
