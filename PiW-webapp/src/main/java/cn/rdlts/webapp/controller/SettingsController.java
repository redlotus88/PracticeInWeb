package cn.rdlts.webapp.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.rdlts.core.usermgr.model.AccountProfile;
import cn.rdlts.core.usermgr.service.AccountProfileService;
import cn.rdlts.core.usermgr.service.AccountService;
import cn.rdlts.shiro.ShiroUser;
import cn.rdlts.shiro.ShiroUtils;
import cn.rdlts.webapp.constant.PathConst;
import cn.rdlts.webapp.constant.tiles.ViewTilesConst;
import cn.rdlts.webapp.vo.ProfileVO;

@Controller
@RequestMapping("/settings")
public class SettingsController {
	
	protected static Logger logger = Logger.getLogger(SettingsController.class);
	
	@Autowired
	private AccountService accountService;
	
	@Autowired
	private AccountProfileService accountProfileService;

	@RequestMapping("/profile")
	public String profile(HttpServletRequest request, ProfileVO profileVO, Model model) {
		logger.info("访问个人档案页面");
		ShiroUser currentUser = ShiroUtils.getCurrentUser();
		if (currentUser == null) {
			return PathConst.REDIRECT_LOGOUT;
		}
		
		Integer accountId = currentUser.getId();
		AccountProfile accountProfile = accountProfileService.getById(accountId);
		profileVO.setAccountId(Integer.toString(accountId));
		profileVO.accept(accountProfile);
		
		String selectedLink = request.getRequestURI();
		model.addAttribute("selected-link", selectedLink);
		return ViewTilesConst.VIEW_TILES_ADMIN_SETTINGS_PROFILE;
	}
	
	@RequestMapping("/account")
	public String account(HttpServletRequest request) {
		return ViewTilesConst.VIEW_TILES_ADMIN_SETTINGS_ACCOUNT;
	}
}
