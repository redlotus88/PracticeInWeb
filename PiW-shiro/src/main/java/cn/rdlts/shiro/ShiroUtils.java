package cn.rdlts.shiro;

import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.InvalidSessionException;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.util.WebUtils;

public final class ShiroUtils {
	
	private static Logger logger = Logger.getLogger(ShiroUtils.class);
	
	private ShiroUtils() {
	}
	
	public static ShiroUser getCurrentUser() {
		return (ShiroUser) SecurityUtils.getSubject().getPrincipal();
	}
	
	/**
     * Clear url.
     *
     * @param subject the subject
     */
    public static void clearURL(Subject subject) {
        Session session = subject.getSession(false);
        if (session != null) {
            session.removeAttribute(WebUtils.SAVED_REQUEST_KEY);
        }
    }
    
    public static Session getSession() {
    	try {
    		Subject subject = SecurityUtils.getSubject();
    		Session session = subject.getSession(false);
    		if (session == null) {
    			session = subject.getSession();
    		}
    		
    		if (session != null) {
    			return session;
    		}
    	} catch (InvalidSessionException e) {
    		logger.error("获取Shiro session失败。", e);
    	}
    	return null;
    }
}
