package cn.rdlts.core.utils;

import org.apache.shiro.crypto.RandomNumberGenerator;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;

import cn.rdlts.core.usermgr.model.Account;
import cn.rdlts.shiro.ciper.MD5Ciper;

public final class ShiroPasswordHelper {
	
	private static RandomNumberGenerator randomNumberGenerator = new SecureRandomNumberGenerator();
	
	/**
	 * 生成随机salt，返回生成的新密码。
	 * @param Account 未加密的用户信息
	 * @return Account 加密过密码的用户信息
	 */
	public static Account encryptPassword(Account account) {
		account.setSalt(randomNumberGenerator.nextBytes().toHex());
		String newPassword = MD5Ciper.encrypt(account.getPassword(), account.getCredentialsSalt()); 
		account.setPassword(newPassword);
		return account;
	}
	
	public static void main(String[] args) {
		String algorithmName = "md5";  
	    String username = "wang";  
	    String password = "111111";  
	    String salt1 = username;  
	    String salt2 = new SecureRandomNumberGenerator().nextBytes().toHex();  
	    int hashIterations = 3;  
	    SimpleHash hash = new SimpleHash(algorithmName, password, salt1 + salt2, hashIterations);  
	    String encodedPassword = hash.toHex();  
	    System.out.println(encodedPassword);  
	    System.out.println(salt2); 
	}
}
