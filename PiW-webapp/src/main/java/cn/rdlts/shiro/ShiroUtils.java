package cn.rdlts.shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.util.WebUtils;

public final class ShiroUtils {
	
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
}
