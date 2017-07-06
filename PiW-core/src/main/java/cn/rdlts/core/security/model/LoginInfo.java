package cn.rdlts.core.security.model;

import java.io.Serializable;
import java.time.LocalDateTime;

public class LoginInfo implements Serializable {
	
	private static final long serialVersionUID = 6614505515447330928L;

	private int id;
	
	private String loginIp;
	
	private LocalDateTime datetime;
	
	
}
