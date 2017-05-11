package cn.rdlts.model;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class UserInfo implements RowMapper<UserInfo>, Serializable {

	private static final long serialVersionUID = 6135843630592962776L;
	
	private int id;
	private String username;

	public UserInfo() {
	}
	
	public UserInfo(int id, String username) {
		this.id = id;
		this.username = username;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public UserInfo mapRow(ResultSet rs, int rowNum) throws SQLException {
		UserInfo userInfo = new UserInfo();  
        userInfo.setId(rs.getInt("id"));  
        userInfo.setUsername(rs.getString("username"));  
		return userInfo;
	}
	
	
}
