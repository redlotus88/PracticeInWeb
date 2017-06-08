package cn.rdlts.usermgr.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class Account implements Serializable {

	private static final long serialVersionUID = 6135843630592962776L;
	
	private int id;
	
	private String accountName;
	
	private transient String password;
	
	private transient String salt;
	
	private transient LocalDateTime createTime;
	
	private transient LocalDateTime lastModifyTime;

	public Account() {
	}
	
	public Account(String accountName) {
		this(accountName, null);
	}
	
	public Account(String accountName, String password) {
		this(accountName, password, null);
	}
	
	public Account(String accountName, String password, String salt) {
		this.accountName = accountName;
		this.password = password;
		this.salt = salt;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}
	
	public String getCredentialsSalt() {
		return accountName + salt;
	}
	
	public LocalDateTime getCreateTime() {
		return createTime;
	}

	public void setCreateTime(LocalDateTime createTime) {
		this.createTime = createTime;
	}

	public LocalDateTime getLastModifyTime() {
		return lastModifyTime;
	}

	public void setLastModifyTime(LocalDateTime lastModifyTime) {
		this.lastModifyTime = lastModifyTime;
	}

	@Override
	public String toString() {
		return "Account [id=" + id + ", accountName=" + accountName + "]";
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder()
					.append(id)
					.append(accountName).toHashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Account)) {
			return false;
		}
		
		Account acc = (Account) obj;
		return new EqualsBuilder()
					.append(this.id, acc.id)
					.append(this.accountName, acc.getAccountName()).isEquals();
	}
	
	
}
