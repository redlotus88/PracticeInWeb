package cn.rdlts.webapp.controller;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.rdlts.core.usermgr.model.Account;
import cn.rdlts.core.usermgr.model.AccountProfile;
import cn.rdlts.core.usermgr.service.AccountProfileService;
import cn.rdlts.core.usermgr.service.AccountService;
import cn.rdlts.webapp.constant.tiles.ViewTilesConst;
import cn.rdlts.webapp.vo.AccountVO;
import cn.rdlts.webapp.vo.ViewObjectUtils;
import cn.rdlts.webapp.vo.datatable.AccountDataTableVO;
import net.sf.json.JSONObject;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	protected static Logger logger = Logger.getLogger(AdminController.class);
	
	@Autowired
	private AccountService accountService;
	
	@Autowired
	private AccountProfileService accountProfileService;
	
	@RequestMapping(value = "/dashboard")
	public String home() {
		return ViewTilesConst.VIEW_TILES_ADMIN_HOME;
	}
	
	@RequestMapping(value = "/mgr/account", method = RequestMethod.GET)
	public String manageAccount() {
		return ViewTilesConst.VIEW_TILES_ADMIN_MGR_ACCOUNT;
	}
	
	/**
	 * 获取账号信息。
	 * @return
	 */
	@RequestMapping(value= "/mgr/account", method = RequestMethod.POST)
	@ResponseBody
	public String getAccounts(AccountVO accountVO) {
		logger.info("开始获取账号列表信息：");
		List<Account> accounts = accountService.findAll();
		List<AccountProfile> accountProfiles = accountProfileService.findAll();
		
		ViewObjectUtils.accept(accountVO, accounts, accountProfiles);
		JSONObject object = JSONObject.fromObject(accountVO.getData());
		
		if (!object.isNullObject()) {
			logger.info(StringUtils.join("获取到列表：", object.toString()));
		} else {
			object = JSONObject.fromObject(AccountDataTableVO.getEmtpyObject());
			logger.warn("获取账号信息列表失败");
		}
		return object.toString();
	}
}
