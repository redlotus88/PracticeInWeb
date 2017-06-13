package cn.rdlts.core.security.service;

import java.util.Set;

public interface SecurityService {
	
	Set<String> getRolesByAccountName(String accountName);
}
