package cn.rdlts.webapp.controller;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.rdlts.shiro.ShiroUser;
import cn.rdlts.shiro.ShiroUtils;
import cn.rdlts.webapp.constant.PathConst;
import cn.rdlts.webapp.constant.ViewConst;

@Controller
@RequestMapping("/usermgr")
public class UserMgrController {
	
	protected static Log logger = LogFactory.getLog(UserMgrController.class);
	
	@RequestMapping("/${accountName}")
	public String getUserInfo(@PathVariable String accountName) {
		ShiroUser currentUser = ShiroUtils.getCurrentUser();
		String currentAccountName = currentUser.getAccountName();
		
		// 当前只能访问自己的网页
		if (StringUtils.isEmpty(accountName)) {
			return PathConst.REDIRECT_LOGOUT;
		} else if (!accountName.equals(currentAccountName)) {
			return "redirect:/usermgr/" + currentAccountName;
		}
		
		return ViewConst.VIEW_PROFILE;
	}
}
