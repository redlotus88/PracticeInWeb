package cn.rdlts.core.security.service;

import java.util.List;

import cn.rdlts.core.security.model.LoginInfo;

public interface LoginService {
	
	void save(LoginInfo loginInfo);
	
	List<LoginInfo> findAll();
	
	List<LoginInfo> findAllBy(int accountId);
}
