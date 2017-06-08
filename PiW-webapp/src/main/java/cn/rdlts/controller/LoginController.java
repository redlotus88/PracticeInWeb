package cn.rdlts.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import cn.rdlts.configurer.PiWCorePropertyConfigurer;
import cn.rdlts.exception.PiWLoginException;
import cn.rdlts.security.model.RoleEnum;
import cn.rdlts.shiro.ShiroUser;
import cn.rdlts.shiro.ShiroUtils;
import cn.rdlts.usermgr.service.AccountService;
import cn.rdlts.vo.LoginVO;

@Controller
@RequestMapping("/login")
public class LoginController {

	 /** logger. */
    private static final Log LOGGER = LogFactory.getLog(LoginController.class);
    
    @Autowired
    private AccountService accountService;

    @Autowired
    private PiWCorePropertyConfigurer configurer;
    
    /**
     * 系统入口
     * @return 返回login页面
     */
	@RequestMapping(method = RequestMethod.GET)
	public String login() {
		// 打开登录页面
		Subject currentUser = SecurityUtils.getSubject();
        ShiroUtils.clearURL(currentUser);
        
        LOGGER.info("验证当前用户是否登录：" + currentUser.getPrincipal());
        if (currentUser.isAuthenticated()) {
        	LOGGER.info("用户已登录成功，直接跳转。");
            return "redirect:/login/success.do";
        }
        LOGGER.info("用户未登陆，跳转到登录页");
		return "login";
	}
	
	/**
	 * 用户鉴权。
     * 
     * @param loginVO login视图
     * @param model 
     * @return
     */
    @RequestMapping(method = RequestMethod.POST)
    public String tryLogin(HttpServletRequest request, LoginVO loginVO, Model model) {
    	String accountName = loginVO.getAccountName();
    	String password = loginVO.getPassword();
    	boolean rememberMe = loginVO.isRememberMe();
    	
    	//TODO : 
    	//verifyAuthCode();
    	UsernamePasswordToken token = new UsernamePasswordToken(accountName, password, rememberMe);
    	LOGGER.info("验证登陆用户：" + ReflectionToStringBuilder.toString(token, ToStringStyle.MULTI_LINE_STYLE));
    	
    	Subject currentUser = SecurityUtils.getSubject();
    	
    	try {
    		verifyUser(currentUser, token);
    	} catch (PiWLoginException ex) {
    		LOGGER.error(ex.getMessage(), ex);
    		model.addAttribute("message_error",  ex.getMessage());
    	}
    	
    	if (currentUser.isAuthenticated()) {
    		LOGGER.info("用户[" + token.getUsername() + "]登录认证通过");
    	} else {
    		token.clear();
    	}
        return login();
    }
	
	private boolean verifyUser(Subject currentUser, UsernamePasswordToken token) throws PiWLoginException {
		boolean success = false;
		String username = token.getUsername();
		String errorMessage = null;
		Throwable exceptionLogin = null;
		try {  
            //在调用了login方法后,SecurityManager会收到AuthenticationToken,并将其发送给已配置的Realm执行必须的认证检查  
            //每个Realm都能在必要时对提交的AuthenticationTokens作出反应  
            //所以这一步在调用login(token)方法时,它会走到MyRealm.doGetAuthenticationInfo()方法中,具体验证方式详见此方法  
            LOGGER.info("对用户[" + username + "]进行登录验证..验证开始");  
            currentUser.login(token);  
            success = true;
            LOGGER.info("对用户[" + username + "]进行登录验证..验证通过");  
        } catch(UnknownAccountException uae){  
            LOGGER.error("对用户[" + username + "]进行登录验证..验证未通过,未知账户");  
            errorMessage = "未知账户";
            exceptionLogin = uae;
        } catch(IncorrectCredentialsException ice){  
            LOGGER.error("对用户[" + username + "]进行登录验证..验证未通过,错误的凭证");  
            errorMessage = "密码不正确";  
            exceptionLogin = ice;
        } catch(LockedAccountException lae){  
            LOGGER.error("对用户[" + username + "]进行登录验证..验证未通过,账户已锁定");  
            errorMessage = "账户已锁定";  
            exceptionLogin = lae;
        } catch(ExcessiveAttemptsException eae){  
        	LOGGER.error("对用户[" + username + "]进行登录验证..验证未通过,错误次数过多");  
        	errorMessage = "用户名或密码错误次数过多";  
        	exceptionLogin = eae;
        } catch(AuthenticationException ae){  
            //通过处理Shiro的运行时AuthenticationException就可以控制用户登录失败或密码错误时的情景  
        	LOGGER.error("对用户[" + username + "]进行登录验证..验证未通过,堆栈轨迹如下");  
            LOGGER.error(ae);  
            errorMessage = "用户名或密码不正确"; 
            exceptionLogin = ae;
        }
		
		if (!success) {
			throw new PiWLoginException(errorMessage, exceptionLogin);
		}
		return success;
	}

	/**
	 * 登录成功
	 * @return
	 */
	@RequestMapping(value="/success")
	public String success() {
		// 需要Token验证
		Subject currentUser = SecurityUtils.getSubject();
		ShiroUser shiroUser = ShiroUtils.getCurrentUser();
		LOGGER.info("用户 [" + shiroUser.getName() + "]  登陆系统...");
		
		if (currentUser.hasRole(RoleEnum.ADMIN.getCode())) {
			return "admin/admin";
		} else {
			return "client/client";
		}
	}
	
	@RequestMapping(value="/logout")
	public String logout() {
		SecurityUtils.getSubject().logout();
		return InternalResourceViewResolver.REDIRECT_URL_PREFIX + "/";
	}
}
