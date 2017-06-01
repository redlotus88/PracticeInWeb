package cn.rdlts.security.model;

public enum RoleEnum {
	
	ADMIN("admin"), USER("user");
	
	private String code;
	
	private RoleEnum(String code) {
		this.code = code;
	}
	
	public String getCode() {
		return code;
	}
	
	public String toString() {
		return code;
	}
}
