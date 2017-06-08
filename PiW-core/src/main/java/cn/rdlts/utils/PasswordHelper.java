package cn.rdlts.utils;

import org.apache.shiro.crypto.RandomNumberGenerator;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

import cn.rdlts.usermgr.model.Account;

public final class PasswordHelper {
	
	private static RandomNumberGenerator randomNumberGenerator = new SecureRandomNumberGenerator();
	
	private static final String ALGORITHM_MD5 = "md5";
	
	private static final int HASH_ITERATIONS = 3;
	
	/**
	 * 生成随机salt，返回生成的新密码。
	 * @param Account 未加密的用户信息
	 * @return Account 加密过密码的用户信息
	 */
	public static Account encryptPassword(Account account) {
		account.setSalt(randomNumberGenerator.nextBytes().toHex());
		String newPassword = encryptMD5(account.getPassword(), account.getCredentialsSalt()); 
		account.setPassword(newPassword);
		return account;
	}
	
	public static String encryptMD5(String str, String salt) {
		SimpleHash sh = new SimpleHash(ALGORITHM_MD5, str, ByteSource.Util.bytes(salt), HASH_ITERATIONS);
		return sh.toString();
	}
	
	public static void main(String[] args) {
//		String username = "Rean";
//		String pass = "123456";
//		
//		Account acc = new Account(username, pass);
//		encryptPassword(acc);
//		System.out.println("加密后的密码：" + acc.getPassword());
//		System.out.println("Salt:" + acc.getCredentialsSalt());
		String algorithmName = "md5";  
	    String username = "wang";  
	    String password = "111111";  
	    String salt1 = username;  
	    String salt2 = new SecureRandomNumberGenerator().nextBytes().toHex();  
	    int hashIterations = 3;  
	    SimpleHash hash = new SimpleHash(algorithmName, password,  
	            salt1 + salt2, hashIterations);  
	    String encodedPassword = hash.toHex();  
	    System.out.println(encodedPassword);  
	    System.out.println(salt2); 
	}
}
