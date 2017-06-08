package cn.rdlts.security.service.impl;

import java.util.Set;

import org.springframework.stereotype.Service;

import cn.rdlts.security.service.SecurityService;

@Service("securityService")
public class SecurityServiceLocalImpl implements SecurityService {

	@Override
	public Set<String> findCodeOfRoles(String accountName) {
		return null;
	}

}
