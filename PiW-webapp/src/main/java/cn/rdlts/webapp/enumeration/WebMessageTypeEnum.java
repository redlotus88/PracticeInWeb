package cn.rdlts.webapp.enumeration;

public enum WebMessageTypeEnum {
	
	INFO("info"), SUCCESS("success"), WARNING("warning"), ERROR("error");
	
	private String code;
	
	private WebMessageTypeEnum(String code) {
		this.code = code;
	}
	
	public String getCode() {
		return code;
	}
}
