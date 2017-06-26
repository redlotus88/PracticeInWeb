package cn.rdlts.webapp.vo;

public final class ProfileVO {
	
	private String profileName;
	private String publicEmail;
	private String company;
	
	public ProfileVO() {
		// Nothing to do.
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
}
