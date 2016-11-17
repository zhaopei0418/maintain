package online.zhaopei.myproject.common.tool;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ArrayTool implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -2588460245770231756L;

	public static Map<String, String> mapFromListOfMap(List<Map<String, String>> listOfMap, String keyStr, String valueStr) {
		Map<String, String> map = new HashMap<String, String>();
		for (Map<String, String> m : listOfMap) {
			String key = m.get(keyStr.toUpperCase());
			String value = m.get(valueStr.toUpperCase());
			map.put(key, value);
		}
		return map;
	}
}
