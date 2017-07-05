package cn.rdlts.webapp.controller;

import java.util.Optional;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import cn.rdlts.core.usermgr.model.Account;
import cn.rdlts.core.usermgr.model.AccountProfile;
import cn.rdlts.core.usermgr.service.AccountProfileService;
import cn.rdlts.core.usermgr.service.AccountService;
import cn.rdlts.shiro.ShiroUser;
import cn.rdlts.shiro.ShiroUtils;
import cn.rdlts.shiro.ciper.CiperUtils;
import cn.rdlts.webapp.bean.WebMessage;
import cn.rdlts.webapp.constant.PathConst;
import cn.rdlts.webapp.constant.ViewConst;
import cn.rdlts.webapp.enumeration.WebMessageTypeEnum;
import cn.rdlts.webapp.vo.AccountVO;
import cn.rdlts.webapp.vo.ProfileVO;

@Controller
@RequestMapping("/usermgr")
public class UserMgrController {
	
	protected static Logger logger = Logger.getLogger(UserMgrController.class);
	
	private static final String ATT_MESSAGE = "message";
	
	@Autowired
	private AccountService accountService;
	
	@Autowired
	private AccountProfileService accountProfileService;
	
	@RequestMapping(value="profile/{id}", method=RequestMethod.GET)
	public String toAccountProfile(@PathVariable String id) {
		logger.info("跳转到个人档案页面。");
		return ViewConst.REDIRECT_SETTINGS_PROFILE;
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
		profileVO.decorate(ap);
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
	
	@RequestMapping(value="account/{id}", method=RequestMethod.GET)
	public String toAccount() {
		logger.info("跳转到个人账号页面。");
		return ViewConst.REDIRECT_SETTINGS_ACCOUNT;
	}
	
	@RequestMapping(value="account/{id}", method=RequestMethod.POST)
	public String updateAccount(@PathVariable String id, AccountVO accountVO, RedirectAttributes model) {
		logger.info("更新id=["+ id + "]的个人账号。");
		String invalidPath = checkAccountConsistency(id, "/settings/account");
		if (StringUtils.isNotEmpty(invalidPath)) {
			return invalidPath;
		}
		
		Account account = accountService.getById(Integer.parseInt(id));
		Optional<WebMessage> message = verifyForm(account, accountVO);
		
		if (!message.isPresent()) {
			logger.info("旧密码验证, 二次输入密码验证成功。");
			account.setPassword(accountVO.getNewPassword());
			int affected = accountService.update(account);
			message = Optional.of(WebMessage.createMessage("更新密码成功", WebMessageTypeEnum.INFO));
			logger.info("更新用户[" + account.getAccountName() + "]的密码成功，影响数据库" + affected + "行。");
		}
		
		model.addFlashAttribute(ATT_MESSAGE, message.orElse(WebMessage.createMessage("更新密码失败", WebMessageTypeEnum.ERROR)));
		model.addFlashAttribute("accountVO", accountVO);
		return ViewConst.REDIRECT_SETTINGS_ACCOUNT;
	}
	
	/**
	 * 校验修改密码表单
	 * 
	 * @param id
	 * @param accountVO
	 * @return
	 */
	private Optional<WebMessage> verifyForm(Account account, AccountVO accountVO) {
		WebMessage result = null;
		String np = accountVO.getNewPassword();
		String confirm = accountVO.getConfirmPassword();
		
		if (StringUtils.isBlank(np)) {
			logger.error("新密码不能为空");
			result = WebMessage.createMessage("新密码不能为空", WebMessageTypeEnum.ERROR);
		} else if (!np.equals(confirm)) {
			logger.error("二次输入密码不正确");
			result = WebMessage.createMessage("二次输入密码不正确", WebMessageTypeEnum.ERROR);
		} else if (!CiperUtils.verifyPassowrd(accountVO.getOldPassword(), account.getCredentialsSalt(), account.getPassword())) {
			logger.error("更新密码失败：旧密码错误。");
			result = WebMessage.createMessage("旧密码错误", WebMessageTypeEnum.ERROR);
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
