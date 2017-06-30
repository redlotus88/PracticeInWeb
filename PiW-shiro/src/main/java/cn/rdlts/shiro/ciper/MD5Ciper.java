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
public class MD5Ciper {
	
	private static Logger log = Logger.getLogger(MD5Ciper.class);
	
	private static int shiroHashIterations = PiWShiroConst.DEFAULT_HASH_ITERATIONS;
	
	public static String encrypt(String str, String salt) {
		SimpleHash sh = new SimpleHash(PiWShiroConst.ALGORITHM_MD5, str, ByteSource.Util.bytes(salt), shiroHashIterations);
		return sh.toString();
	}
	
	public static void setShiroHashIterations(int hashIterations) {
		MD5Ciper.shiroHashIterations = hashIterations;
	}
}
