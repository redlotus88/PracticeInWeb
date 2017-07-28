package cn.rdlts.webapp.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import cn.rdlts.common.json.JSONUtils;
import cn.rdlts.core.security.model.Role;
import cn.rdlts.core.security.service.SecurityService;
import cn.rdlts.core.usermgr.model.Account;
import cn.rdlts.core.usermgr.model.AccountProfile;
import cn.rdlts.core.usermgr.service.AccountProfileService;
import cn.rdlts.core.usermgr.service.AccountService;
import cn.rdlts.shiro.ShiroUser;
import cn.rdlts.shiro.ShiroUtils;
import cn.rdlts.shiro.ciper.CiperUtils;
import cn.rdlts.webapp.ToStringHelper;
import cn.rdlts.webapp.bean.WebMessage;
import cn.rdlts.webapp.constant.PathConst;
import cn.rdlts.webapp.constant.ViewConst;
import cn.rdlts.webapp.enumeration.WebMessageTypeEnum;
import cn.rdlts.webapp.vo.AccountVO;
import cn.rdlts.webapp.vo.ProfileVO;
import cn.rdlts.webapp.vo.SettingsAccountVO;
import cn.rdlts.webapp.vo.ViewObjectUtils;

@Controller
@RequestMapping("/usermgr")
public class UserMgrController {
	
	protected static Logger logger = Logger.getLogger(UserMgrController.class);
	
	private static final String ATT_MESSAGE = "message";
	
	@Autowired
	private AccountService accountService;
	
	@Autowired
	private AccountProfileService accountProfileService;
	
	@Autowired
	private SecurityService securitySerivce;
	
	@RequestMapping(value="account/{id}", method=RequestMethod.GET)
	public String toAccount() {
		logger.info("跳转到个人账号页面。");
		return ViewConst.REDIRECT_SETTINGS_ACCOUNT;
	}

	@RequestMapping(value="profile/{id}", method=RequestMethod.GET)
	public String toAccountProfile(@PathVariable String id) {
		logger.info("跳转到个人档案页面。");
		return ViewConst.REDIRECT_SETTINGS_PROFILE;
	}
	
	@RequestMapping(value="account/{id}", method=RequestMethod.POST)
	public String updateAccount(@PathVariable String id, SettingsAccountVO settingsAccountVO, RedirectAttributes model) {
		logger.info("更新id=["+ id + "]的个人账号。");
		String invalidPath = checkAccountConsistency(id, "/settings/account");
		if (StringUtils.isNotEmpty(invalidPath)) {
			return invalidPath;
		}
		
		Account account = accountService.getById(Integer.parseInt(id));
		Optional<WebMessage> message = verifyForm(account, settingsAccountVO);
		
		if (!message.isPresent()) {
			logger.info("旧密码验证, 二次输入密码验证成功。");
			account.setPassword(settingsAccountVO.getNewPassword());
			int affected = accountService.update(account);
			message = Optional.of(WebMessage.createMessage("更新密码成功", WebMessageTypeEnum.INFO));
			logger.info("更新用户[" + account.getAccountName() + "]的密码成功，影响数据库" + affected + "行。");
		}
		
		model.addFlashAttribute(ATT_MESSAGE, message.orElse(WebMessage.createMessage("更新密码失败", WebMessageTypeEnum.ERROR)));
		model.addFlashAttribute("accountVO", settingsAccountVO);
		return ViewConst.REDIRECT_SETTINGS_ACCOUNT;
	}

	@RequestMapping(value="profile/{id}", method=RequestMethod.POST)
	public String updateProfile(@PathVariable String id, ProfileVO profileVO, RedirectAttributes model) {
		logger.info("更新["+ id + "]的个人文档。");
		String invalidPath = checkAccountConsistency(id, "/settings/profile");
		if (StringUtils.isNotEmpty(invalidPath)) {
			return invalidPath;
		}
		
		AccountProfile ap = new AccountProfile();
		ap.setId(Integer.parseInt(id));
		ViewObjectUtils.decorate(profileVO, ap);
		int result;
		if (accountProfileService.exist(ap)) {
			result = accountProfileService.update(ap);
		} else {
			result = accountProfileService.save(ap);
		}
		
		model.addFlashAttribute(ATT_MESSAGE, WebMessage.createMessage("更新档案成功", WebMessageTypeEnum.SUCCESS));
		logger.info("更新完毕。影响数据库行数：" + result);
		return ViewConst.REDIRECT_SETTINGS_PROFILE;
	}
	
	@RequestMapping(value="globalAccount", method=RequestMethod.POST)
	public String addGlobalAccount(AccountVO accountVO, RedirectAttributes model) {
		logger.info("添加全局账号...");
		WebMessage message = null;
		String accountName = accountVO.getAccountName();
		
		if (!accountService.exist(accountName)) {
			Account account = new Account(accountName, accountVO.getPassword());
			String[] codeRoles = accountVO.getRoles();
			List<Role> roles = new ArrayList<>();
			
			if (ArrayUtils.isNotEmpty(codeRoles)) {
				roles = Arrays.stream(codeRoles).map(codeRole -> securitySerivce.findRole(codeRole)).collect(Collectors.toList());
				roles.removeIf(Objects::isNull);
			}
			
			try {
				accountService.save(account, roles);
				message =  WebMessage.createMessage("添加新账号成功", WebMessageTypeEnum.SUCCESS);
			} catch (Exception ex) {
				message =  WebMessage.createMessage("添加账号失败", WebMessageTypeEnum.ERROR);
			}
		} else {
			message = WebMessage.createMessage("创建失败，用户名重复", WebMessageTypeEnum.ERROR);
		}
		
		model.addFlashAttribute(ATT_MESSAGE, message);
		return ViewConst.REDIRECT_MGR_GLOBAL_ACCOUNT;
	}
	
	@RequestMapping(value="globalAccount/{id}", method=RequestMethod.POST)
	@ResponseBody
	public String updateGlobalAccount(@PathVariable String id, @RequestParam(value = "roles[]") String[] roles) {
		logger.info(StringUtils.join("更新账号角色信息[", id, "] -> " + ToStringHelper.toString(roles, String::toString, ',') ));
		String message;
		WebMessageTypeEnum type = WebMessageTypeEnum.ERROR;
		Account account;
		
		
		if (StringUtils.isBlank(id) || !StringUtils.isNumeric(id)) {
			message = "无法识别id..删除失败";
		} else {
			Integer idNum = Integer.parseInt(id);
			account = accountService.getById(idNum);
			
			ShiroUser curUser = ShiroUtils.getCurrentUser();
			
			if (account == null) {
				message = StringUtils.join("无法找到账号id=[" , id , "]");
			} else if (curUser.getAccountName().equals(account.getAccountName())) { //检验是否更新自身.
				message = "无法更新自身的权限!!!";
				type = WebMessageTypeEnum.WARNING;
			} else {
				List<Role> rolesObj = Arrays.stream(roles).map(code -> securitySerivce.findRole(code)).filter(Objects::nonNull).collect(Collectors.toList());
				int affectedRow = securitySerivce.saveRolesToAccount(rolesObj, account);
				message = StringUtils.join("更新账号角色信息成功. 影响行数：", Integer.toString(affectedRow), "行");
				type = WebMessageTypeEnum.SUCCESS;
			}
		}
		return JSONUtils.toJSON(WebMessage.createMessage(message, type));
	}
	
	@RequestMapping(value="globalAccount/{id}",
			produces="application/json; charset=utf-8", // 处理ajax返回json中文字符的时候乱码的问题。
			method=RequestMethod.DELETE)
	@ResponseBody
	public String deleteGlobalAccount(@PathVariable String id) {
		logger.info(StringUtils.join("删除账号[", id, "]"));
		String message;
		WebMessageTypeEnum type = WebMessageTypeEnum.ERROR;
		Account account;
		
		if (StringUtils.isBlank(id) || !StringUtils.isNumeric(id)) {
			message = "无法识别id..删除失败";
		} else {
			Integer idNum = Integer.parseInt(id);
			account = accountService.getById(idNum);
			ShiroUser curUser = ShiroUtils.getCurrentUser();
			
			if (account == null) {
				message = StringUtils.join("无法找到账号id=[" , id , "]");
			} else if (curUser.getAccountName().equals(account.getAccountName())) {
				message = "无法删除自己！！！";
				type = WebMessageTypeEnum.WARNING;
			} else {
				accountService.delete(account);
				message = "成功删除元素。";
				type = WebMessageTypeEnum.SUCCESS;
			}
		}
		return JSONUtils.toJSON(WebMessage.createMessage(message, type));
	}
	
	/**
	 * 校验修改密码表单
	 * 
	 * @param id
	 * @param settingsAccountVO
	 * @return
	 */
	private Optional<WebMessage> verifyForm(Account account, SettingsAccountVO settingsAccountVO) {
		WebMessage result = null;
		String errorMessage = null;
		String op = settingsAccountVO.getOldPassword();
		String np = settingsAccountVO.getNewPassword();
		String confirm = settingsAccountVO.getConfirmPassword();
		
		if (StringUtils.isBlank(np)) {
			errorMessage = "新密码不能为空";
		} else if (!StringUtils.equals(np, confirm)) {
			errorMessage = "二次输入密码不正确";
		} else if (!CiperUtils.verifyPassowrd(settingsAccountVO.getOldPassword(), account.getCredentialsSalt(), account.getPassword())) {
			errorMessage = "更新密码失败：旧密码错误。";
		} else if (StringUtils.equals(op, np)) {
			errorMessage = "新旧密码不能相同。";
		}
		
		if (StringUtils.isNotEmpty(errorMessage)) { 
			logger.error(errorMessage);
			result = WebMessage.createMessage(errorMessage, WebMessageTypeEnum.ERROR);
		}
		return Optional.ofNullable(result);
	}
	
	/**
	 * Return a invalid path if not validated.
	 * @param id
	 * @return
	 */
	private String checkAccountConsistency(String id, String errorPath) {
		Integer currentId = null;
		ShiroUser currentUser = ShiroUtils.getCurrentUser();
		if (currentUser != null) {
			currentId = currentUser.getId();
		}
		logger.info("用户id=[" + currentId + "]尝试访问id=[" + id + "]的个人档案页面。");
		// 当前只能访问自己的网页
		if (StringUtils.isEmpty(id) || !StringUtils.isNumeric(id) || currentId == null) {
			logger.info("无用户信息，登出。");
			return PathConst.REDIRECT_LOGOUT;
		} else if (Integer.parseInt(id) != currentId.intValue()) {
			logger.info("不能访问其他用户页面，重定向为当前用户页面。");
			return InternalResourceViewResolver.REDIRECT_URL_PREFIX + errorPath;
		}
		return null;
	}
	
}
