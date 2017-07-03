package cn.rdlts.shiro.ciper;

import org.apache.commons.lang3.StringUtils;

/**
 * Ciper Utility.
 * @author dragon
 *
 */
public class CiperUtils {
	/**
	 * 根据当前的密码算法，加密密码。
	 * 
	 * @param password
	 * @param salt
	 * @return
	 */
	public static String encrypt(String password, String salt) {
		return MD5Ciper.encrypt(password, salt);
	}
	
	/**
	 * 如果encryptedPassword为空，则始终返回false.
	 * 
	 * @param toVerify
	 * @param salt
	 * @param encryptedPassword
	 * @return
	 */
	public static boolean verifyPassowrd(String toVerify, String salt, String encryptedPassword) {
		boolean result = false;
		if (StringUtils.isNotBlank(encryptedPassword)) {
			result = encryptedPassword.equals(encrypt(toVerify, salt));
		}
		return result;
	}
	
	private CiperUtils() {
	}
}
