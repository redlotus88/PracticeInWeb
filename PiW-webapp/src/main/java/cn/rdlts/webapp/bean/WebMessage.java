package cn.rdlts.webapp.bean;

import cn.rdlts.webapp.enumeration.WebMessageTypeEnum;

public class WebMessage {
	
	private String message;
	
	private WebMessageTypeEnum type;
	
	public WebMessage(String message) {
		this(message, WebMessageTypeEnum.INFO);
	}
	
	/**
	 * 如果无法识别type, 则默认为info.
	 * 
	 * @param message
	 * @param type
	 */
	public WebMessage(String message, String type) {
		this(message, WebMessageTypeEnum.resolve(type).orElse(WebMessageTypeEnum.INFO));
	}
	
	public WebMessage(String message, WebMessageTypeEnum type) {
		this.message = message;
		this.type = type;
	}
	
	public static WebMessage createMessage(String msg, WebMessageTypeEnum type) {
		return new WebMessage(msg, type);
	}
	
	public String getMessage() {
		return message;
	}
	
	public String getContent() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getType() {
		return type.getCode();
	}

	public void setType(WebMessageTypeEnum type) {
		this.type = type;
	}
	
	public boolean isError() {
		return type == WebMessageTypeEnum.ERROR;
	}
}
