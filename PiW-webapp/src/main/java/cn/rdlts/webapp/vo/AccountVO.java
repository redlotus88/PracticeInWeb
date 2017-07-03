package cn.rdlts.webapp.vo;

public final class AccountVO {
	
	private String oldPassword;
	private String newPassword;
	
	public AccountVO() {
		// Nothing to do.
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
