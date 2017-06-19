package cn.rdlts.shiro;

import java.io.Serializable;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * 自定义Authentication对象，使得Subject除了携带用户的登录名外还可以携带更多信息.
 */
public class ShiroUser implements Serializable {
	
	private static final long serialVersionUID = -1373760761780840081L;
	
	private String accountName;

	public ShiroUser(String name) {
		this.accountName = name;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	@Override
	public String toString() {
		return "ShiroUser [accountName=" + accountName + "]";
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(accountName).toHashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof ShiroUser) {
			ShiroUser user = (ShiroUser) obj;
			return new EqualsBuilder()
					.append(accountName, user.getAccountName())
					.isEquals();
		}
		return false;
	}
}
