package cn.rdlts.webapp.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.rdlts.core.usermgr.model.Account;
import cn.rdlts.core.usermgr.service.AccountService;
import cn.rdlts.shiro.ShiroUser;
import cn.rdlts.shiro.ShiroUtils;
import cn.rdlts.webapp.constant.PathConst;
import cn.rdlts.webapp.constant.tiles.ViewTilesConst;
import cn.rdlts.webapp.vo.ProfileVO;

@Controller
@RequestMapping("/settings")
public class SettingsController {
	
	protected static Log logger = LogFactory.getLog(SettingsController.class);
	
	@Autowired
	private AccountService accountService;

	@RequestMapping("/profile")
	public String profile(HttpServletRequest request, ProfileVO profileVO, Model model) {
		logger.info("访问个人档案页面");
		ShiroUser currentUser = ShiroUtils.getCurrentUser();
		if (currentUser == null) {
			return PathConst.REDIRECT_LOGOUT;
		}
		
		Integer accountId = currentUser.getId();
		Account currentAccount = accountService.getById(accountId);
		
		String selectedLink = request.getRequestURI();
		model.addAttribute("selected-link", selectedLink);
		return ViewTilesConst.VIEW_TILES_ADMIN_SETTINGS_PROFILE;
	}
	
	@RequestMapping("/account")
	public String account(HttpServletRequest request) {
		return ViewTilesConst.VIEW_TILES_ADMIN_SETTINGS_ACCOUNT;
	}
}
