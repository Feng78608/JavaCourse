package new_api;

import net.sf.json.JSON;
import net.sf.json.xml.XMLSerializer;

public class Change {
	 public static void getXmlToJson(String xmlString){
	        XMLSerializer xml = new XMLSerializer();
	        JSON json = xml.read(xmlString);
//	        System.out.println(json);
	        System.out.println(json.toString(1));
	    }

}
