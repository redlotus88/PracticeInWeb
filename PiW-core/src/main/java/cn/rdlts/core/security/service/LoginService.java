package cn.rdlts.core.security.service;

import java.util.List;

import cn.rdlts.core.security.model.LoginInfo;

public interface LoginService {
	
	/**
	 * 保存登录信息。
	 * @param loginInfo 
	 * @return 
	 */
	int save(LoginInfo loginInfo);
	
	/**
	 * 获取每日登录人数。
	 * @return
	 */
	int getDailyVisits();
	
	List<LoginInfo> findAll();
	
	List<LoginInfo> findAllBy(int accountId);
	
	List<LoginInfo> findAllLastLoginTimeByAccount();
}
