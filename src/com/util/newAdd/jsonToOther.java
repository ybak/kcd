package com.util.newAdd;
import java.util.List;
import java.util.Map;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class jsonToOther {
	public static List<Map<String, Object>> stringToListMap(String str){
		Gson gson = new Gson();
		List<Map<String,Object>> list = gson.fromJson(str, new TypeToken<List<Map<String,Object>>>() {}.getType());
		return list;
	}
}
