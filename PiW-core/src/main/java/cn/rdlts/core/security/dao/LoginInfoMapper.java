package cn.rdlts.core.security.dao;

import org.springframework.stereotype.Repository;

import cn.rdlts.common.dao.BaseMapper;
import cn.rdlts.core.security.model.LoginInfo;

@Repository
public interface LoginInfoMapper extends BaseMapper<LoginInfo, Integer> {
	
	@Override
	default int delete(LoginInfo entity) {
		throw new UnsupportedOperationException("不支持删除登录信息");
	}
	
	@Override
	default int update(LoginInfo entity) {
		throw new UnsupportedOperationException("不支持更新登录信息");
	}
}
