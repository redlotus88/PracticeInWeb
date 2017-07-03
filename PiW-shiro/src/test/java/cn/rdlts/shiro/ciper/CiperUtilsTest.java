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
		String password = "test1234";
		String salt = randomNumberGenerator.nextBytes().toHex();
		String encodedPassword = CiperUtils.encrypt(password, salt);
		
		Assert.assertTrue(CiperUtils.verifyPassowrd(password, salt, encodedPassword));
	}
}
