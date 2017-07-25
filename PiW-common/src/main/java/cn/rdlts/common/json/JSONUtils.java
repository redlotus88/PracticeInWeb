package cn.rdlts.common.json;

import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public final class JSONUtils {
	
	private JSONUtils() {
	}
	
	public static String toJSON(List<String> lst) {
		JSONArray jsonArr = new JSONArray();
		jsonArr.addAll(lst);
		return jsonArr.toString();
	}
	
	/**
	 * List : ("a", "b", "c") => {"data":["a","b", "c"]}
	 * 
	 * @param a list collection.
	 * @return json string
	 */
	public static String toJSONData(List<String> lst) {
		JSONObject jsonObj = new JSONObject();
		jsonObj.put("data", lst);
		return jsonObj.toString();
	}
}
