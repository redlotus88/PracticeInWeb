package cn.rdlts.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.rdlts.dao.UserInfoDao;
import cn.rdlts.model.UserInfo;
import cn.rdlts.service.UserInfoService;

@Service("userInfoService")
public class UserInfoServiceImpl implements UserInfoService {

	@Autowired
	private UserInfoDao userInfoDao;
	
	@Override
	public UserInfo getById(Integer id) {
		return userInfoDao.getById(id);
	}

	@Override
	public List<UserInfo> findAll() {
		return userInfoDao.findAll();
	}

	@Override
	public Integer save(UserInfo userInfo) {
		return userInfoDao.save(userInfo);
	}

}
