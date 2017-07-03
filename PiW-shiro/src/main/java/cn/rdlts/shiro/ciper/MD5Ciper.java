package cn.rdlts.shiro.ciper;

import org.apache.log4j.Logger;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

import cn.rdlts.shiro.constant.PiWShiroConst;

/**
 * MD5Ciper.
 * 
 * @author Dragon.Wang
 *
 */
public final class MD5Ciper {
	
	private static Logger log = Logger.getLogger(MD5Ciper.class);
	
	private static int shiroHashIterations = PiWShiroConst.DEFAULT_HASH_ITERATIONS;
	
	private MD5Ciper() {
	}
	
	public static String encrypt(String password, String salt) {
		log.info("加密字符串[" + password + "] with salt[" + salt + "].");
		SimpleHash sh = new SimpleHash(PiWShiroConst.ALGORITHM_MD5, password, ByteSource.Util.bytes(salt), shiroHashIterations);
		return sh.toHex();
	}
	
	public static void setShiroHashIterations(int hashIterations) {
		log.info("设置shiro hashIterations的值：" + hashIterations);
		MD5Ciper.shiroHashIterations = hashIterations;
	}
}
