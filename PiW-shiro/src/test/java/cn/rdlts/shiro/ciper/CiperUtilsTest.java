package cn.rdlts.shiro.ciper;

import org.apache.shiro.crypto.RandomNumberGenerator;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.junit.Assert;
import org.junit.Test;

public class CiperUtilsTest {
	
	private static RandomNumberGenerator randomNumberGenerator = new SecureRandomNumberGenerator();
	
	/**
	 * 测试加密工具类是否正确。
	 */
	@Test
	public void verifyPassowrdTest() {
		String name = "Rean";
		String password = "kami4423";
		String salt = randomNumberGenerator.nextBytes().toHex();
		String encodedPassword = CiperUtils.encrypt(password, name + salt);
		Assert.assertTrue(CiperUtils.verifyPassowrd(password, name + salt, encodedPassword));
		
		name = "Rean";
		password = "123456";
		salt = "e7209f164d849b63b0837e4cf54c13ec";
		encodedPassword = "2a30c6eb6ad8800c355602f3ed09bb3f";
		Assert.assertTrue(CiperUtils.verifyPassowrd(password, name + salt, encodedPassword));
				
	}
}
