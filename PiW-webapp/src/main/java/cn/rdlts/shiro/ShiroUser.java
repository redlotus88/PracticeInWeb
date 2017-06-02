package cn.rdlts.shiro;

import java.io.Serializable;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * 自定义Authentication对象，使得Subject除了携带用户的登录名外还可以携带更多信息.
 */
public class ShiroUser implements Serializable {
	
	private static final long serialVersionUID = -1373760761780840081L;
	
	private String name;
	
	public ShiroUser(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "ShiroUser [name=" + name + "]";
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(name).toHashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof ShiroUser) {
			ShiroUser user = (ShiroUser) obj;
			return new EqualsBuilder()
					.append(this.name, user.getName())
					.isEquals();
		}
		return false;
	}
}
