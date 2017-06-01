package cn.rdlts.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.rdlts.security.model.RoleEnum;
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
	public String get() {
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
	 * 登录成功
	 * @return
	 */
	@RequestMapping(value="/success", method = RequestMethod.POST)
	public String success() {
		// 需要Token验证
		Subject currentUser = SecurityUtils.getSubject();
		if (currentUser.hasRole(RoleEnum.ADMIN.getCode())) {
			return "admin/admin";
		} else {
			return "client/client";
		}
	}
}
