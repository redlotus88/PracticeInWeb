package cn.rdlts.shiro;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import cn.rdlts.security.service.SecurityService;
import cn.rdlts.usermgr.model.Account;
import cn.rdlts.usermgr.service.AccountService;

public class SystemAuthorizingRealm extends AuthorizingRealm {

	private static final Log LOGGER = LogFactory.getLog(SystemAuthorizingRealm.class);
	
	@Autowired
	private AccountService accountServiceImpl;
	
	@Autowired
	private SecurityService securityServiceImpl;
	
	/**
	 * 授权查询回调函数, 进行鉴权但缓存中无用户的授权信息时调用
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		LOGGER.info("执行权限认证");
		String accountName = (String)super.getAvailablePrincipal(principals);
		Account account = accountServiceImpl.getByName(accountName);
		
		if (account == null) {
			throw new AuthenticationException("用户不存在：" + account);
		}
		
		SimpleAuthorizationInfo simpleAuthorInfo = new SimpleAuthorizationInfo();
		simpleAuthorInfo.setRoles(securityServiceImpl.findCodeOfRoles(accountName));
		LOGGER.info("权限认证结束");
		return simpleAuthorInfo;
	}

	/** 
     * 认证回调函数, 登录时调用 
     */  
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken) throws AuthenticationException {
		LOGGER.info("认证用户token");
		UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
		String username = token.getUsername();
		Account account = accountServiceImpl.getByName(username);
		if (account == null) {
			throw new UnknownAccountException();
		}
		SimpleAuthenticationInfo autheInfo = new SimpleAuthenticationInfo(account.getAccountName(), account.getPassword(), 
				ByteSource.Util.bytes(account.getSalt()), getName());
		return autheInfo;
	}

}
