package cn.rdlts.webapp.vo;

public final class ProfileVO {
	
	private String nickName;
	private String email;
	private String biography;
	private String company;
	
	public ProfileVO() {
		// Nothing to do.
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getBiography() {
		return biography;
	}

	public void setBiography(String biography) {
		this.biography = biography;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}
}
