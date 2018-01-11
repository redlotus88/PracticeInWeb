package cn.rdlts.webapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.rdlts.webapp.constant.tiles.ViewTilesConst;

/**
 * 天眼项目
 * 
 * @author dragon
 *
 */
@Controller
@RequestMapping("/skyeyes")
public class SkyeyesController {
	
	
	@RequestMapping("/dashboard")
	public String dashboard() {
		return ViewTilesConst.VIEW_TILES_ADMIN_SKYEYES_DASHBOARD;
	}
}	
