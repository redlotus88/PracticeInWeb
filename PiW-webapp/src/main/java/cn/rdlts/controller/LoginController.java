package cn.rdlts.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.rdlts.security.model.RoleEnum;
import cn.rdlts.shiro.ShiroUser;
import cn.rdlts.shiro.ShiroUtils;
import cn.rdlts.vo.LoginVO;

@Controller
@RequestMapping("/login")
public class LoginController {

	 /** logger. */
    private static final Log LOGGER = LogFactory.getLog(LoginController.class);

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
		return "login";
	}
	
	/**
	 * 用户鉴权成功会执行配置文件的成功路径。
     * 用户鉴权失败后，调用该方法。
     * 
     * @param accountName
     * @param model
     * @return
     */
    @RequestMapping(method = RequestMethod.POST)
    public String fail(@RequestParam("accountName") String accountName, Model model) {
        model.addAttribute("accountName", accountName);
        LOGGER.info("用户[" + accountName + "] 尝试登陆系统失败!");
        return login();
    }
	
	/**
	 * 登录成功
	 * @return
	 */
	@RequestMapping(value="/success", method = RequestMethod.POST)
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
}
