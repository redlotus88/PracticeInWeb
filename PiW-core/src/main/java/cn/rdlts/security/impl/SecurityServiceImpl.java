package cn.rdlts.security.impl;

import java.util.Set;

import org.springframework.stereotype.Service;

import cn.rdlts.security.service.SecurityService;

@Service
public class SecurityServiceImpl implements SecurityService {

	@Override
	public Set<String> findCodeOfRoles(String accountName) {
		return null;
	}

}
