package cn.rdlts.service;

import java.util.List;

import cn.rdlts.model.UserInfo;

public interface UserInfoService {
	
	UserInfo getById(Integer id);
	
	List<UserInfo> findAll();
	
	Integer save(UserInfo userInfo);
}
