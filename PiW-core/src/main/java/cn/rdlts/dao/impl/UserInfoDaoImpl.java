package cn.rdlts.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import cn.rdlts.dao.UserInfoDao;
import cn.rdlts.model.UserInfo;

@Repository("userInfoDao")
public class UserInfoDaoImpl implements UserInfoDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	@Override
	public UserInfo getById(Integer id) {
		String sql = "SELECT * FROM test WHERE id = ?";
		UserInfo userInfo = jdbcTemplate.queryForObject(sql, new UserInfo(), new Object[] { id });
		return userInfo;
	}

	@Override
	public List<UserInfo> findAll() {
		String sql = "SELECT * FROM test";
		List<UserInfo> userInfos = jdbcTemplate.query(sql, new UserInfo());
		return userInfos;
	}

	@Override
	public Integer save(UserInfo entity) {
		String sql = "INSERT INTO test(username) VALUES(:username)";  
        MapSqlParameterSource paramSource = new MapSqlParameterSource();  
        paramSource.addValue("username", entity.getUsername());  
        int result = namedParameterJdbcTemplate.update(sql, paramSource);  
          
        return result;  
	}
	
}
