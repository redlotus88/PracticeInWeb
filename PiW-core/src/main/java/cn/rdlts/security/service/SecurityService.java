package cn.rdlts.security.service;

import java.util.Set;

import org.springframework.stereotype.Service;

public interface SecurityService {
	
	Set<String> findCodeOfRoles(String accountName);
}
