package cn.rdlts.webapp.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.rdlts.webapp.constant.tiles.ViewTilesConst;

@Controller
@RequestMapping("/settings")
public class SettingsController {
	
	protected static Log log = LogFactory.getLog(SettingsController.class);
	
	@RequestMapping("/profile")
	public String profile(HttpServletRequest request, Model model) {
		log.info("访问个人档案页面");
		String selectedLink = request.getRequestURI();
		model.addAttribute("selected-link", selectedLink);
		return ViewTilesConst.VIEW_TILES_ADMIN_SETTINGS_PROFILE;
	}
	
	@RequestMapping("/account")
	public String account(HttpServletRequest request) {
		return ViewTilesConst.VIEW_TILES_ADMIN_SETTINGS_ACCOUNT;
	}
}
