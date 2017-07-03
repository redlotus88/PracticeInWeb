package cn.rdlts.webapp.vo;

public final class AccountVO {
	
	private Integer id;
	private String oldPassword;
	private String newPassword;
	
	public AccountVO() {
		// Nothing to do.
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getOldPassword() {
		return oldPassword;
	}

	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}
	
}
