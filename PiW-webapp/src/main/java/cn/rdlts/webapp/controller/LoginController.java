package cn.rdlts.webapp.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
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
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import cn.rdlts.core.security.model.RoleEnum;
import cn.rdlts.shiro.ShiroUser;
import cn.rdlts.shiro.ShiroUtils;
import cn.rdlts.webapp.constant.ViewConst;
import cn.rdlts.webapp.exception.PiWLoginException;
import cn.rdlts.webapp.vo.LoginVO;

@Controller
@RequestMapping("/login")
public class LoginController {

	 /** logger. */
    private static Log logger = LogFactory.getLog(LoginController.class);
    
    private static final String REDIRECT_SUCCESS = "redirect:/login/success.do";
    
    private static final String REDIRECT_ADMIN = "redirect:/admin/home.do";
    
    /**
     * 系统入口
     * @return 返回login页面
     */
	@RequestMapping(method = RequestMethod.GET)
	public String login() {
		Subject currentUser = SecurityUtils.getSubject();
        ShiroUtils.clearURL(currentUser);
        
        logger.info("验证当前用户是否登录：" + currentUser.getPrincipal());
        if (currentUser.isAuthenticated()) {
        	logger.info("用户已登录成功，直接跳转。");
            return REDIRECT_SUCCESS;
        }
        logger.info("用户未登陆，跳转到登录页");
		return ViewConst.VIEW_LOGIN;
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
    	
    	if (StringUtils.isNotEmpty(password) && StringUtils.isNotEmpty(accountName)) {
        	UsernamePasswordToken token = new UsernamePasswordToken(accountName, password, rememberMe);
        	logger.info("验证登陆用户：" + ReflectionToStringBuilder.toString(token, ToStringStyle.MULTI_LINE_STYLE));
        	
        	Subject currentUser = SecurityUtils.getSubject();
        	
        	try {
        		verifyUser(currentUser, token);
        	} catch (PiWLoginException ex) {
        		logger.error(ex.getMessage(), ex);
        		model.addAttribute("errorMessage",  ex.getMessage());
        	}
        	
        	if (currentUser.isAuthenticated()) {
        		logger.info("用户[" + token.getUsername() + "]登录认证通过");
        		return REDIRECT_SUCCESS;
        	} else {
        		logger.info("用户[" + token.getUsername() + "]登录认证失败，清除用户token");
        		token.clear();
        	}
    	} else {
    		model.addAttribute("errorMessage", "账号或密码不能为空");
    	}
        return ViewConst.VIEW_LOGIN;
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
            logger.info("对用户[" + username + "]进行Shiro权限验证..验证开始");  
            currentUser.login(token);  
            success = true;
            logger.info("对用户[" + username + "]进行Shiro权限验证..验证通过");  
        } catch(UnknownAccountException uae){  
            logger.error("对用户[" + username + "]进行Shiro权限验证..验证未通过,未知账户");  
            errorMessage = "未知账户";
            exceptionLogin = uae;
        } catch(IncorrectCredentialsException ice){  
            logger.error("对用户[" + username + "]进行Shiro权限验证..验证未通过,错误的凭证");  
            errorMessage = "密码不正确";  
            exceptionLogin = ice;
        } catch(LockedAccountException lae){  
            logger.error("对用户[" + username + "]进行Shiro权限验证..验证未通过,账户已锁定");  
            errorMessage = "账户已锁定";  
            exceptionLogin = lae;
        } catch(ExcessiveAttemptsException eae){  
        	logger.error("对用户[" + username + "]进行Shiro权限验证..验证未通过,错误次数过多");  
        	errorMessage = "用户名或密码错误次数过多";  
        	exceptionLogin = eae;
        } catch(AuthenticationException ae){  
            //通过处理Shiro的运行时AuthenticationException就可以控制用户登录失败或密码错误时的情景  
        	logger.error("对用户[" + username + "]进行Shiro权限验证..验证未通过,堆栈轨迹如下");  
            logger.error(ae);  
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
		logger.info("用户 [" + shiroUser.getAccountName() + "]  登陆系统...");
		
		if (currentUser.hasRole(RoleEnum.ADMIN.getCode())) {
			logger.info("跳转到管理员界面");
			return REDIRECT_ADMIN;
		} else {
			logger.info("跳转到客户端界面");
			return ViewConst.VIEW_CLIENT;
		}
	}
	
	@RequestMapping(value="/logout")
	public String logout() {
		SecurityUtils.getSubject().logout();
		return InternalResourceViewResolver.REDIRECT_URL_PREFIX + "/";
	}
}
