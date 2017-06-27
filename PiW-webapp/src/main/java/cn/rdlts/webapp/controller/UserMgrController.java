package cn.rdlts.webapp.controller;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.rdlts.core.usermgr.model.AccountProfile;
import cn.rdlts.core.usermgr.service.AccountProfileService;
import cn.rdlts.shiro.ShiroUser;
import cn.rdlts.shiro.ShiroUtils;
import cn.rdlts.webapp.constant.PathConst;
import cn.rdlts.webapp.constant.ViewConst;
import cn.rdlts.webapp.vo.ProfileVO;

@Controller
@RequestMapping("/usermgr")
public class UserMgrController {
	
	protected static Log logger = LogFactory.getLog(UserMgrController.class);
	
	@Autowired
	private AccountProfileService accountProfileService;
	
	@RequestMapping(value="/${id}", method=RequestMethod.GET)
	public String getAccountProfile(@PathVariable String id) {
		String invalidPath = checkAccountConsistency(id);
		if (StringUtils.isNotEmpty(invalidPath)) {
			return invalidPath;
		}
		logger.info("跳转到个人档案页面。");
		return ViewConst.VIEW_SETTINGS_PROFILE;
	}
	
	@RequestMapping(value="/${id}", method=RequestMethod.POST)
	public String update(@PathVariable String id, ProfileVO profileVO) {
		logger.info("更新["+ id + "]的个人文档。");
		String invalidPath = checkAccountConsistency(id);
		if (StringUtils.isNotEmpty(invalidPath)) {
			return invalidPath;
		}
		
		AccountProfile ap = new AccountProfile();
		ap.setId(Integer.parseInt(id));
		profileVO.decorate(ap);
		int result = accountProfileService.update(ap);
		logger.info("更新完毕。影响数据库行数：" + result);
		return ViewConst.VIEW_SETTINGS_PROFILE;
	}
	
	/**
	 * Return a invalid path if not validated.
	 * @param id
	 * @return
	 */
	private String checkAccountConsistency(String id) {
		Integer currentId = null;
		ShiroUser currentUser = ShiroUtils.getCurrentUser();
		if (currentUser != null) {
			currentId = currentUser.getId();
		}
		logger.info("用户[" + currentId + "]尝试访问[" + id + "]的个人档案页面。");
		// 当前只能访问自己的网页
		if (StringUtils.isEmpty(id) || !StringUtils.isNumeric(id) || currentId == null) {
			logger.info("无用户信息，登出。");
			return PathConst.REDIRECT_LOGOUT;
		} else if (Integer.parseInt(id) != currentId.intValue()) {
			logger.info("不能访问其他用户页面，重定向为当前用户页面。");
			return "redirect:/usermgr/" + Integer.toString(currentId);
		}
		return null;
	}
}
