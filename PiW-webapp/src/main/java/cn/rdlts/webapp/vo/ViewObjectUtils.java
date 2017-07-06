package cn.rdlts.webapp.vo;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.apache.log4j.Logger;

import cn.rdlts.core.usermgr.model.Account;
import cn.rdlts.core.usermgr.model.AccountProfile;
import cn.rdlts.webapp.vo.datatable.AccountDataTableVO;
import cn.rdlts.webapp.vo.datatable.AccountView;

public final class ViewObjectUtils {
	
	protected static Logger logger = Logger.getLogger(ViewObjectUtils.class);
	
	private static final String DATE_TIME_PATTERN = "yyyy-MM-dd HH:mm:ss";
	
	private ViewObjectUtils() {
	}
	
	public static void accept(AccountVO accountVO, List<Account> accounts, List<AccountProfile> profiles) {
		Map<Integer, AccountProfile> mapProfiles = profiles.stream().collect(Collectors.toMap(AccountProfile::getId, p -> p));
		List<AccountView> data = accounts.stream().map(account -> ViewObjectUtils.createViewWith(account, mapProfiles.get(account.getId())))
										.collect(Collectors.toList());
		accountVO.setData(new AccountDataTableVO(data));
	}
	
	public static void accept(ProfileVO profileVO, AccountProfile accountProfile) {
		if (accountProfile != null) {
			profileVO.setProfileName(accountProfile.getProfileName());
			profileVO.setPublicEmail(accountProfile.getPublicEmail());
			profileVO.setCompany(accountProfile.getCompany());
		}
	}
	
	public static AccountView createViewWith(Account account, AccountProfile profile) {
		AccountView view = new AccountView();
		if (account == null) {
			return view;
		}
		
		if (profile != null && account.getId() != profile.getId()) {
			logger.warn("Account与其Profile的ID不匹配");
		}
		
		view.setFormattedId(Integer.toString(Optional.ofNullable(account.getId()).orElse(Integer.valueOf(-1))), 8);
		view.setAccountName(account.getAccountName());
		//TODO: create login time record
		view.setLastLoginTime("2017-07-06 14:00:00");
		if (account.getLastModifyTime() != null) {
			view.setLastModifyTime(DateTimeFormatter.ofPattern(DATE_TIME_PATTERN).format(account.getLastModifyTime()));
		}
		
		if (profile != null) {
			view.setProfileName(profile.getProfileName());
			view.setPublicEmail(profile.getProfileName());
			view.setCompany(profile.getCompany());
		}
		return view;
	}

	public static void decorate(ProfileVO profileVO, AccountProfile accountProfile) {
		if (accountProfile != null) {
			accountProfile.setProfileName(profileVO.getProfileName());
			accountProfile.setPublicEmail(profileVO.getPublicEmail());
			accountProfile.setCompany(profileVO.getCompany());
		} 
	}
}
