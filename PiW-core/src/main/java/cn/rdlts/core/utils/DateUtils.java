package cn.rdlts.core.utils;

import java.time.LocalDateTime;

public final class DateUtils {
	
	private DateUtils() {
	}
	
	public static LocalDateTime nowTime() {
		return LocalDateTime.now();
	}
}
