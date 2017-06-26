package cn.rdlts.core.usermgr.model;

import java.io.Serializable;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class AccountProfile implements Serializable {
	
	private static final long serialVersionUID = -4502663876885828362L;
	
	private int id;

	private String profileName;
	
	private String publicEmail;
	
	private String company;
	
	public AccountProfile() {
		// Public constructor
	}
	
	public AccountProfile(int id, String profileName, String publicEmail, String company) {
		super();
		this.id = id;
		this.profileName = profileName;
		this.publicEmail = publicEmail;
		this.company = company;
	}
	
	@Override
	public int hashCode() {
		return new HashCodeBuilder()
				.append(id)
				.append(profileName)
				.append(publicEmail)
				.append(company).toHashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof AccountProfile)) {
			return false;
		}
		
		AccountProfile apObj = (AccountProfile) obj;
		return new EqualsBuilder()
					.append(this.id, apObj.id)
					.append(this.profileName, apObj.getProfileName())
					.append(this.publicEmail, apObj.getPublicEmail())
					.append(this.company, apObj.getCompany()).isEquals();
	}
	
	@Override
	public String toString() {
		return "AccountProfile [id=" + id + ", profileName=" + profileName + ", publicEmail=" + publicEmail + ", company=" + company + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
