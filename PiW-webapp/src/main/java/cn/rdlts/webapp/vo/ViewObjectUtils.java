package cn.rdlts.webapp.vo;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.apache.log4j.Logger;

import cn.rdlts.core.security.model.LoginInfo;
import cn.rdlts.core.security.model.Role;
import cn.rdlts.core.usermgr.model.Account;
import cn.rdlts.core.usermgr.model.AccountProfile;
import cn.rdlts.webapp.ToStringHelper;
import cn.rdlts.webapp.vo.datatable.AccountDataTableVO;
import cn.rdlts.webapp.vo.datatable.RoleDataTableVO;
import cn.rdlts.webapp.vo.datatable.view.AccountView;
import cn.rdlts.webapp.vo.datatable.view.RoleView;

public final class ViewObjectUtils {
	
	protected static Logger logger = Logger.getLogger(ViewObjectUtils.class);
	
	private static final String DATE_TIME_PATTERN = "yyyy-MM-dd HH:mm:ss";
	
	private ViewObjectUtils() {
	}
	
	public static void accept(AccountVO accountVO, List<Account> accounts, List<AccountProfile> profiles, List<LoginInfo> loginInfos, Map<Integer, List<Role>> accountRoles) {
		Map<Integer, AccountProfile> mapProfiles = profiles.stream().collect(Collectors.toMap(AccountProfile::getId, p -> p));
		Map<Integer, LoginInfo> mapLoginInfos = loginInfos.stream().collect(Collectors.toMap(LoginInfo::getAccountId, p -> p));
		List<AccountView> data = accounts.stream()
										.map(account -> ViewObjectUtils.decorate(new AccountView(), 
												account, mapProfiles.get(account.getId()), mapLoginInfos.get(account.getId()), accountRoles.get(account.getId())))
										.collect(Collectors.toList());
		accountVO.setData(new AccountDataTableVO(data));
	}
	
	public static void accept(RoleVO roleVO, List<Role> roles) {
		List<RoleView> data = roles.stream()
									.map(role -> ViewObjectUtils.decorate(new RoleView(), role))
									.collect(Collectors.toList());
		roleVO.setData(new RoleDataTableVO(data));
	}
	
	public static void accept(ProfileVO profileVO, AccountProfile accountProfile) {
		if (accountProfile != null) {
			profileVO.setProfileName(accountProfile.getProfileName());
			profileVO.setPublicEmail(accountProfile.getPublicEmail());
			profileVO.setCompany(accountProfile.getCompany());
		}
	}
	
	public static AccountView decorate(AccountView accountView, Account account, AccountProfile profile, LoginInfo lastLoginInfo, List<Role> roles) {
		if (account == null) {
			return accountView;
		}
		
		if (profile != null && account.getId() != profile.getId()) {
			logger.warn("Account与其Profile的ID不匹配");
		}
		
		accountView.setFormattedId(Integer.toString(Optional.ofNullable(account.getId()).orElse(Integer.valueOf(-1))), 8);
		accountView.setAccountName(account.getAccountName());
		if (lastLoginInfo != null && lastLoginInfo.getRecordTime() != null) {
			accountView.setLastLoginTime(DateTimeFormatter.ofPattern(DATE_TIME_PATTERN).format(lastLoginInfo.getRecordTime()));
		}
		if (account.getLastModifyTime() != null) {
			accountView.setLastModifyTime(DateTimeFormatter.ofPattern(DATE_TIME_PATTERN).format(account.getLastModifyTime()));
		}
		
		if (profile != null) {
			accountView.setProfileName(profile.getProfileName());
			accountView.setPublicEmail(profile.getPublicEmail());
			accountView.setCompany(profile.getCompany());
		}
		
		if (roles != null) {
			accountView.setRoles(ToStringHelper.toString(roles, Role::getCode, ","));
		}
		return accountView;
	}
	
	public static RoleView decorate(RoleView roleView, Role role) {
		if (role != null) {
			roleView.setId(Integer.toString(role.getId()));
			roleView.setCode(role.getCode());
			roleView.setDescription(role.getDescription());
		}
		return roleView;
	}

	public static void decorate(ProfileVO profileVO, AccountProfile accountProfile) {
		if (accountProfile != null) {
			accountProfile.setProfileName(profileVO.getProfileName());
			accountProfile.setPublicEmail(profileVO.getPublicEmail());
			accountProfile.setCompany(profileVO.getCompany());
		} 
	}
	
}
