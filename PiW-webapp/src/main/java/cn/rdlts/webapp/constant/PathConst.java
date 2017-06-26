package cn.rdlts.webapp.constant;

import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * PiW 项目 SpringMVC path 常量
 * 
 * @author dragon
 *
 */
public final class PathConst {
	
	public static final String REDIRECT_LOGOUT = InternalResourceViewResolver.REDIRECT_URL_PREFIX + "/login/logout";
	
	private PathConst() {
	}
}
