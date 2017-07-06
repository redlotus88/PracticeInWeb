package cn.rdlts.webapp.controller;

import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.rdlts.core.security.model.RoleEnum;
import cn.rdlts.core.usermgr.model.AccountProfile;
import cn.rdlts.core.usermgr.service.AccountProfileService;
import cn.rdlts.shiro.ShiroUser;
import cn.rdlts.shiro.ShiroUtils;
import cn.rdlts.webapp.constant.PathConst;
import cn.rdlts.webapp.constant.tiles.ViewTilesConst;
import cn.rdlts.webapp.exception.PiWUnknownViewException;
import cn.rdlts.webapp.vo.ProfileVO;
import cn.rdlts.webapp.vo.ViewObjectUtils;

@Controller
@RequestMapping("/settings")
public class SettingsController {
	
	protected static Logger logger = Logger.getLogger(SettingsController.class);
	
	@Autowired
	private AccountProfileService accountProfileService;

	@RequestMapping("/profile")
	public String profile(ProfileVO profileVO) {
		logger.info("访问个人档案页面");
		ShiroUser currentUser = ShiroUtils.getCurrentUser();
		if (currentUser == null) {
			return PathConst.REDIRECT_LOGOUT;
		}
		
		Integer accountId = currentUser.getId();
		AccountProfile accountProfile = accountProfileService.getById(accountId);
		profileVO.setAccountId(Integer.toString(accountId));
		ViewObjectUtils.accept(profileVO, accountProfile);
		
		if (SecurityUtils.getSubject().hasRole(RoleEnum.ADMIN.getCode())) {
			logger.info("用户是管理员，跳转到管理员个人档案设置界面。");
			return ViewTilesConst.VIEW_TILES_ADMIN_SETTINGS_PROFILE;
		}
		
		throw new PiWUnknownViewException("未知角色信息，无法访问档案页面");
	}
	
	@RequestMapping("/account")
	public String account() {
		logger.info("访问个人账户页面");
		ShiroUser currentUser = ShiroUtils.getCurrentUser();
		if (currentUser == null) {
			return PathConst.REDIRECT_LOGOUT;
		}
		
		if (SecurityUtils.getSubject().hasRole(RoleEnum.ADMIN.getCode())) {
			logger.info("用户是管理员，跳转到管理员账号设置界面。");
			return ViewTilesConst.VIEW_TILES_ADMIN_SETTINGS_ACCOUNT;
		}
		
		throw new PiWUnknownViewException("未知角色信息，无法访问账号管理页面");
	}
}
