package cn.rdlts.webapp.shiro;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
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

import cn.rdlts.core.security.model.LoginInfo;
import cn.rdlts.core.security.model.LoginInfo.Type;
import cn.rdlts.core.security.service.LoginService;
import cn.rdlts.core.security.service.SecurityService;
import cn.rdlts.core.usermgr.model.Account;
import cn.rdlts.core.usermgr.model.AccountProfile;
import cn.rdlts.core.usermgr.model.EmptyAccountProfile;
import cn.rdlts.core.usermgr.service.AccountProfileService;
import cn.rdlts.core.usermgr.service.AccountService;
import cn.rdlts.shiro.ShiroUser;

public class PiWShiroAuthorizingRealm extends AuthorizingRealm {

	private static Logger logger = Logger.getLogger(PiWShiroAuthorizingRealm.class);
	
	@Autowired
	private AccountService accountService;
	
	@Autowired
	private AccountProfileService accountProfileService;
	
	@Autowired
	private SecurityService securityService;
	
	@Autowired
	private LoginService loginService;
	
	/**
	 * 授权查询回调函数, 进行鉴权但缓存中无用户的授权信息时调用
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		logger.info("执行权限认证");
		ShiroUser shiroUser = (ShiroUser) super.getAvailablePrincipal(principals);
		Account account = accountService.getByName(shiroUser.getAccountName());
		
		if (account == null) {
			throw new AuthenticationException("用户不存在：" + account);
		}
		
		SimpleAuthorizationInfo simpleAuthorInfo = new SimpleAuthorizationInfo();
		String accountName = account.getAccountName();
		// 角色赋予
		Set<String> roles = securityService.findRolesCodeByAccountName(accountName);
		logger.info(StringUtils.join("用户[", accountName, "]角色：", roles));
		simpleAuthorInfo.setRoles(roles);
		// 权限赋予
		logger.info(StringUtils.join("用户[", accountName, "]权限: "));
//		authorizationInfo.setStringPermissions(userService.findPermissions(username));
		
		logger.info("记录登录信息：");
		loginService.save(new LoginInfo(account.getId(), shiroUser.getHost(), LocalDateTime.now(), Type.LOGIN));
		
		logger.info("权限认证结束");
		return simpleAuthorInfo;
	}

	/** 
     * 认证回调函数, 登录时调用 
     */  
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken) {
		logger.info("认证用户token");
		UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
		String username = token.getUsername();
		Account account = accountService.getByName(username);
		if (account == null) {
			throw new UnknownAccountException("未查找到账号：" + username);
		}
		
		AccountProfile accountProfile = Optional.ofNullable(accountProfileService.getById(account.getId()))
												.orElse(new EmptyAccountProfile(username));
		
		return new SimpleAuthenticationInfo(new ShiroUser(account.getId(), account.getAccountName(), accountProfile.getProfileName(), token.getHost()), account.getPassword(), 
				ByteSource.Util.bytes(account.getCredentialsSalt()), getName());
	}

}
