package cn.rdlts.webapp.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.rdlts.webapp.constant.ViewConst;

@Controller
@RequestMapping(value = "/git")
public class GitController {
	
	/** log */
	private static Logger log = Logger.getLogger(GitController.class);
	
}
