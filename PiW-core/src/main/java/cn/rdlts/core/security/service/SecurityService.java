package cn.rdlts.core.security.service;

import java.util.Set;

import cn.rdlts.core.security.model.LoginInfo;

public interface SecurityService {
	
	Set<String> getRolesByAccountName(String accountName);
	
}
