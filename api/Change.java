package api;

import net.sf.json.JSON;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.xml.XMLSerializer;

public class Change {
	public static void Xml2Json(String xmlString) {
		XMLSerializer xml = new XMLSerializer();
		JSON json = xml.read(xmlString);
		System.out.println(json.toString(1));
	}

	public static void json2xml(String jsonString) {
		XMLSerializer xmlSerializer = new XMLSerializer();
		JSONObject json = JSONObject.fromObject(jsonString);
		System.out.println(xmlSerializer.write(JSONArray.fromObject(json)));//这种方式只支持JSON数组
	}
}
