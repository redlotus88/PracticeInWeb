package cn.rdlts.shiro.ciper;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.shiro.authc.credential.Md5CredentialsMatcher;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import cn.rdlts.shiro.configurer.PiWShiroPropertyConfigurer;
import cn.rdlts.shiro.constant.PiWShiroConst;

/**
 * MD5Ciper.
 * 
 * @author Dragon.Wang
 *
 */
public class MD5Ciper {
	
	private static Log log = LogFactory.getLog(MD5Ciper.class);
	
	private static int shiroHashIterations = PiWShiroConst.DEFAULT_HASH_ITERATIONS;
	
	public static String encrypt(String str, String salt) {
		SimpleHash sh = new SimpleHash(PiWShiroConst.ALGORITHM_MD5, str, ByteSource.Util.bytes(salt), shiroHashIterations);
		return sh.toString();
	}
	
	public static void setShiroHashIterations(int hashIterations) {
		MD5Ciper.shiroHashIterations = hashIterations;
	}
}
