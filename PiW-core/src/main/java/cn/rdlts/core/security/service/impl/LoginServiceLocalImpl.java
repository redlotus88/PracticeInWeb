package cn.rdlts.core.security.service.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.rdlts.core.security.dao.LoginInfoMapper;
import cn.rdlts.core.security.model.LoginInfo;
import cn.rdlts.core.security.service.LoginService;

@Service("loginService")
public class LoginServiceLocalImpl implements LoginService {

	protected static Logger logger = Logger.getLogger(LoginServiceLocalImpl.class);
	
	@Autowired
	private LoginInfoMapper loginInfoMapper;
	
	@Override
	public int save(LoginInfo loginInfo) {
		logger.info(StringUtils.join("记录登入登出信息：", loginInfo));
		return loginInfoMapper.save(loginInfo);
	}
	
	@Override
	public List<LoginInfo> findAll() {
		logger.info("查找所有的登入登出记录...");
		return loginInfoMapper.findAll();
	}

	@Override
	public List<LoginInfo> findAllBy(int accountId) {
		logger.info(StringUtils.join("查找账号[", Integer.toString(accountId), "] 的所有登入登出记录..."));
		return loginInfoMapper.findAllBy(accountId);
	}

	@Override
	public int getDailyVisits() {
		int num = loginInfoMapper.getDailyVisits();
		logger.info(StringUtils.join("查询当天登录人次数：", Integer.toString(num)));
		return num;
	}

	@Override
	public List<LoginInfo> findAllLastLoginTimeByAccount() {
		logger.info("查找所有账号最后一次登录时间");
		return loginInfoMapper.findAllLastLoginTimeByAccount();
	}

}
