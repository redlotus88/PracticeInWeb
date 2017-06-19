package cn.rdlts.webapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.rdlts.shiro.ShiroUser;
import cn.rdlts.shiro.ShiroUtils;
import cn.rdlts.webapp.constant.ViewConst;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@RequestMapping(value = "/home")
	public String home(Model model) {
		ShiroUser shiroUser = ShiroUtils.getCurrentUser();
		model.addAttribute("accountName", shiroUser.getName());
		
		return ViewConst.VIEW_ADMIN;
	}
	
	
}
