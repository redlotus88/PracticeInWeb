package cn.rdlts.webapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.rdlts.webapp.constant.tiles.ViewTilesConst;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@RequestMapping(value = "/dashboard")
	public String home() {
		return ViewTilesConst.VIEW_TILES_ADMIN_HOME;
	}
	
	
}
