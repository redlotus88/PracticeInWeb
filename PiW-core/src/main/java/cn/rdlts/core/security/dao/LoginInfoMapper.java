package cn.rdlts.core.security.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import cn.rdlts.common.dao.BaseMapper;
import cn.rdlts.core.security.model.LoginInfo;

@Repository
public interface LoginInfoMapper extends BaseMapper<LoginInfo, Long> {
	
	int getDailyVisits();
	
	List<LoginInfo> findAllBy(int accountId);
	
	List<LoginInfo> findAllLastLoginTimeByAccount();
}
