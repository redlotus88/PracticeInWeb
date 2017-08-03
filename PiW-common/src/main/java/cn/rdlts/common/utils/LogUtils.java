package cn.rdlts.common.utils;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

public final class LogUtils {
	
	private LogUtils() {
		
	}
	
	public static void info(Logger log, Object message) {
		log.info(message);
	}
	
	public static void info(Logger log, Object... messages) {
		log.info(StringUtils.join(messages));
	}
	
	public static void warn(Logger log, Object message) {
		log.warn(message);
	}
	
	public static void warn(Logger log, Object... messages) {
		log.warn(StringUtils.join(messages));
	}
	
	public static void error(Logger log, Object message) {
		log.error(message);
	}
	
	public static void error(Logger log, Object... messages) {
		log.error(StringUtils.join(messages));
	}
}
