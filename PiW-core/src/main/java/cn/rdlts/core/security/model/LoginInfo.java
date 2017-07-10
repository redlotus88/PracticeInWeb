package cn.rdlts.core.security.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class LoginInfo implements Serializable {

	private static final long serialVersionUID = 6614505515447330928L;

	private Long serial;
	
	private int accountId;

	private String loginIp;

	private LocalDateTime datetime;

	private Type type;

	public LoginInfo() {
		// public constructor
	}

	public Long getSerial() {
		return serial;
	}

	public void setSerial(Long serial) {
		this.serial = serial;
	}
	
	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public LocalDateTime getDatetime() {
		return datetime;
	}

	public void setDatetime(LocalDateTime datetime) {
		this.datetime = datetime;
	}

	public String getLoginIp() {
		return loginIp;
	}

	public void setLoginIp(String loginIp) {
		this.loginIp = loginIp;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	enum Type {
		LOGIN("login"), LOGOUT("logout");
		
		private String code;
		
		Type(String code) {
			this.code = code;
		}
		
		@Override
		public String toString() {
			return code;
		}
	}
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
