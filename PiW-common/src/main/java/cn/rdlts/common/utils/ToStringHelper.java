package cn.rdlts.common.utils;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.function.Function;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

public final class ToStringHelper {
	
	private ToStringHelper() {
	}
	
	/**
	 * @see cn.rdlts.common.utils.ToStringHelper#toString(List, Function, String, String, String)
	 * 
	 * @param list
	 * @param fn
	 * @return
	 */
	public static <T extends Object> String toString(T[] list, Function<T, String> fn) {
		return toString(Arrays.asList(list), fn);
	}
	
	/**
	 * @see cn.rdlts.common.utils.ToStringHelper#toString(List, Function, String, String, String)
	 * 
	 * @param list
	 * @param fn
	 * @param sep
	 * @return
	 */
	public static <T extends Object> String toString(T[] list, Function<T, String> fn, char sep) {
		return toString(Arrays.asList(list), fn, sep);
	}
	
	/**
	 * @see cn.rdlts.common.utils.ToStringHelper#toString(List, Function, String, String, String)
	 * 
	 * @param list
	 * @param fn
	 * @return
	 */
	public static <T extends Object> String toString(List<T> list, Function<T, String> fn) {
		return toString(list, fn, "[", "]", ",");
	}
	
	/**
	 * @see cn.rdlts.common.utils.ToStringHelper#toString(List, Function, String, String, String)
	 * 
	 * @param list
	 * @param fn
	 * @param sep
	 * @return
	 */
	public static <T extends Object> String toString(List<T> list, Function<T, String> fn, char sep) {
		return toString(list, fn, "[", "]", Character.toString(sep));
	}
	
	/**
	 * @see cn.rdlts.common.utils.ToStringHelper#toString(List, Function, String, String, String)
	 * 
	 * @param list
	 * @param fn
	 * @param sep
	 * @return
	 */
	public static <T extends Object> String toString(List<T> list, Function<T, String> fn, String sep) {
		return toString(list, fn, "[", "]", sep);
	}

	/**
	 * <pre>
	 * 将一个list {a, b, c} 打印成以下格式： prefix + (fn.apply(obj) + sep + fn.apply(obj))* + suffix
	 * 示例：toString({a,b,c}, String::toString, "[", "]", ";") 
	 * 结果: [a;b;c]
	 * </pre>
	 * 
	 * @param list
	 * @param fn
	 * @param prefix
	 * @param suffix
	 * @param sep
	 * @return
	 */
	public static <T extends Object> String toString(List<T> list, Function<T, String> fn, String prefix, String suffix, String sep) {
		StringBuilder sb = new StringBuilder();
		if (CollectionUtils.isEmpty(list)) {
			return StringUtils.EMPTY;
		}
		
		// 可以使用style来完成拼接字符串
		Iterator<T> it = list.iterator();
		T obj = null;
		while (it.hasNext()) {
			obj = it.next();
			sb.append(fn.apply(obj));
			sb.append(sep);
		}

		if (sb.length() > 0) {
			sb.deleteCharAt(sb.length() - 1);
		}
		return StringUtils.join(prefix, sb.toString(), suffix);
	}
}
