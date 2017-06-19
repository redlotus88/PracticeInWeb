package cn.rdlts.core.security.model;

public enum RoleEnum {
	
	ADMIN("admin"), USER("user"), GUEST("guest");
	
	private String code;
	
	private RoleEnum(String code) {
		this.code = code;
	}
	
	public String getCode() {
		return code;
	}
	
	@Override
	public String toString() {
		return code;
	}
}
