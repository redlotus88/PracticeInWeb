package cn.rdlts.webapp;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Function;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import cn.rdlts.core.security.model.Role;

public final class ToStringHelper {
	
	private ToStringHelper() {
	}
	
	public static <T extends Object> String toString(List<T> list, Function<T, String> fn) {
		return toString(list, fn, "[", "]", ';');
	}
	
	public static <T extends Object> String toString(List<T> list, Function<T, String> fn, String prefix, String suffix, char sep) {
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
	
	public static void main(String[] args) {
		Role role1 = new Role("code1", "desc1");
		Role role2 = new Role("code2", "desc2");
		Role role3 = new Role("code3", "desc3");
		Role role4 = new Role("code4", "desc4");
		List<Role> lst = new ArrayList<Role>();
		lst.add(role1);
		lst.add(role2);
		lst.add(role3);
		lst.add(role4);
		System.out.println(ToStringHelper.toString(lst, Role::getCode));
	}
}
