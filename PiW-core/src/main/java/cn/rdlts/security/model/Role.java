package cn.rdlts.security.model;

import java.io.Serializable;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class Role implements Serializable {
	
	private static final long serialVersionUID = -8514150123300546844L;
	
	private int id;
	private String code;
	private String description;
	
	public Role() {
	}
	
	public Role(String code, String description) {
		this.code = code;
		this.description = description;
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Role [id=" + id + ", code=" + code + ", description=" + description + "]";
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder()
				.append(code)
				.toHashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Role)) {
			return false;
		}
		
		Role objRole = (Role) obj;
		return new EqualsBuilder()
					.append(this.code, objRole.getCode()).isEquals();
	}
}
