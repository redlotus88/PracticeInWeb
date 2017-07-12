package cn.rdlts.webapp.vo;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
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
	
	public static void accept(AccountVO accountVO, List<Account> accounts, List<AccountProfile> profiles, List<LoginInfo> loginInfos) {
		Map<Integer, AccountProfile> mapProfiles = profiles.stream().collect(Collectors.toMap(AccountProfile::getId, p -> p));
		Map<Integer, LoginInfo> mapLoginInfos = loginInfos.stream().collect(Collectors.toMap(LoginInfo::getAccountId, p -> p));
		List<AccountView> data = accounts.stream()
										.map(account -> ViewObjectUtils.decorate(new AccountView(), account, mapProfiles.get(account.getId()), mapLoginInfos.get(account.getId())))
										.collect(Collectors.toList());
		accountVO.setData(new AccountDataTableVO(data));
	}
	
	public static void accept(RoleVO roleVO, List<Account> accounts, List<AccountProfile> profiles, List<Role> roles) {
		Map<Integer, AccountProfile> mapProfiles = profiles.stream().collect(Collectors.toMap(AccountProfile::getId, p -> p));
		
		Map<Integer, List<Role>> mapRoles = new HashMap<>();
//		Map<Integer, CopyOnWriteArrayList<Role>> mapRolesAfterCollection = 
//				roles.stream().collect(Collectors.toMap(Role::getId, 
//					role -> {	
//						CopyOnWriteArrayList<Role> lst = mapRoles.getOrDefault(role.getId(), new CopyOnWriteArrayList<>());
//						lst.add(role);
//						return mapRoles.put(role.getId(), lst);
//						}));
		for (Role role : roles) {
			List<Role> col = mapRoles.getOrDefault(role.getId(), new ArrayList<>());
			col.add(role);
			mapRoles.put(role.getId(), col);
		}
		
		List<RoleView> data = accounts.stream()
									.map(account -> ViewObjectUtils.decorate(new RoleView(), account, mapProfiles.get(account.getId()), mapRoles.get(account.getId())))
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
	
	public static AccountView decorate(AccountView accountView, Account account, AccountProfile profile, LoginInfo lastLoginInfo) {
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
		return accountView;
	}
	
	public static RoleView decorate(RoleView roleView, Account account, AccountProfile profile, List<Role> roles) {
		if (account == null) {
			return roleView;
		}
		
		if (profile != null && account.getId() != profile.getId()) {
			logger.warn("Account与其Profile的ID不匹配");
		}
		
		roleView.setFormattedId(Integer.toString(Optional.ofNullable(account.getId()).orElse(Integer.valueOf(-1))), 8);
		roleView.setAccountName(account.getAccountName());
		if (profile != null) {
			roleView.setProfileName(profile.getProfileName());
		}
		
		if (roles != null) {
			roleView.setRole(ToStringHelper.toString(roles, Role::getCode));
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
