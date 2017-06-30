package cn.rdlts.webapp.enumeration;

import java.util.Optional;

import org.apache.commons.lang3.StringUtils;

public enum WebMessageTypeEnum {
	
	INFO("info"), SUCCESS("success"), WARNING("warning"), ERROR("error");
	
	private String code;
	
	private WebMessageTypeEnum(String code) {
		this.code = code;
	}
	
	public static Optional<WebMessageTypeEnum> resolve(String type) {
		Optional<WebMessageTypeEnum> result = Optional.empty();
		
		if (StringUtils.isNotBlank(type)) {
			try {
				result = Optional.ofNullable(valueOf(type));
			} catch (IllegalArgumentException e) {
				// Swallow the exception.
			}
		}
		return result;		
	}
	
	public String getCode() {
		return code;
	}
}
