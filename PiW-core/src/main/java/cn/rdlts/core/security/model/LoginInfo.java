package cn.rdlts.core.security.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class LoginInfo implements Serializable {

	private static final long serialVersionUID = 6614505515447330928L;

	private Long serial;
	
	private int accountId;

	private String loginIp;

	private transient LocalDateTime recordTime;

	private Type type;

	public LoginInfo() {
		// public constructor
	}
	
	public LoginInfo(int accountId, String loginIp, LocalDateTime recordTime, Type type) {
		this.accountId = accountId;
		this.loginIp = loginIp;
		this.recordTime = recordTime;
		this.type = type;
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
	
	public LocalDateTime getRecordTime() {
		return recordTime;
	}

	public void setRecordTime(LocalDateTime recordTime) {
		this.recordTime = recordTime;
	}

	public enum Type {
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
