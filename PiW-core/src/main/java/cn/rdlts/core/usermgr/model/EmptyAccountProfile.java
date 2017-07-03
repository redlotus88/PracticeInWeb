package cn.rdlts.core.usermgr.model;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public final class EmptyAccountProfile extends AccountProfile {

	private static final long serialVersionUID = -7763124702545645591L;
	
	private static final int ILLEGAL_ID = -1;
		
	public EmptyAccountProfile() {
		super(ILLEGAL_ID, StringUtils.EMPTY, StringUtils.EMPTY, StringUtils.EMPTY);
	}
	
	public EmptyAccountProfile(String profileName) {
		super(ILLEGAL_ID, profileName, StringUtils.EMPTY, StringUtils.EMPTY);
	}
	
	@Override
	public boolean equals(Object obj) {
		return obj instanceof EmptyAccountProfile;
	}
	
	@Override
	public int hashCode() {
		return new HashCodeBuilder()
				.append(getId()).toHashCode();
	}
	
	@Override
	public String toString() {
		return "EmtpyAccountProfile[]";
	}
}
