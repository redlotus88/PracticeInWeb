package cn.rdlts.utils;

import org.apache.shiro.crypto.RandomNumberGenerator;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

import cn.rdlts.usermgr.model.Account;

public final class PasswordHelper {
	
	private static RandomNumberGenerator randomNumberGenerator = new SecureRandomNumberGenerator();
	
	private static final String ALGORITHM_MD5 = "md5";
	
	private static final int HASH_ITERATIONS = 2;
	
	/**
	 * 生成随机salt，返回生成的新密码。
	 * @param Account 未加密的用户信息
	 * @return Account 加密过密码的用户信息
	 */
	public static Account encryptPassword(Account account) {
		account.setSalt(randomNumberGenerator.nextBytes().toHex());
		String newPassword = new SimpleHash(
				ALGORITHM_MD5,
				account.getPassword(),
				ByteSource.Util.bytes(account.getSalt()),
				HASH_ITERATIONS).toHex();
		account.setPassword(newPassword);
		return account;
	}
}
