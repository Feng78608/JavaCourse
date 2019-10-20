package new_api;

//数据转换需要导包进来，但我的总是出现问题，正在想办法解决。。。
import java.util.Scanner;

/*import org.json.XML;

import net.sf.json.JSONObject;

import net.sf.json.JSON;
import net.sf.json.JSONArray;
import net.sf.json.JSONSerializer;
import net.sf.json.xml.XMLSerializer;*/



import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.HashMap;
import java.util.Date;
import java.io.UnsupportedEncodingException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLEncoder;
import java.net.HttpURLConnection;
import java.text.SimpleDateFormat;

public class API {

	 public static void main(String[] args) {

		System.out.println("请输入想要查询天气的城市，如:jingzhou");	
	    Scanner input=new Scanner(System.in);	
	    String name=input.next();
	    String requestUrlXml = "http://flash.weather.com.cn/wmaps/xml/"+name+".xml";//接口地址
	    System.out.println(result("9787208061644",requestUrlXml));//测试数据
	   // Change change=new Change();
	   // change.getXmlToJson(result("9787208061644",requestUrlXml));
	    
	    System.out.println("请输入想要查询天气的城市，如:湖北荆州");
	    Scanner inputJson=new Scanner(System.in);
	    String nameJson=inputJson.next();
	    try {
	            initCityMap("cities.txt");
	    } catch (IOException e) {
	         System.out.println("读文件错误");
	         return;
	    }
	    
	    String code=cityToCode(nameJson);
	    String requestUrlJson = "http://www.weather.com.cn/data/cityinfo/"+code+".html";//接口地址
	    System.out.println(result("9787208061644",requestUrlJson));//测试数据
	    
	    
	    
	   
	    }
	 
	
	 
	    public static String get_time() {//设置时间
	        Date d = new Date();//创建日期对象
	        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");//创建格式化日期
	        String s = sdf.format(d);//创建成字符串
//	        System.out.println(s);
	        return s;
	    }
//	    "http://route.showapi.com/1626-1?"
//	    + "showapi_appid%3Dmyappid%26"
//	    + "isbn%3D9787208061644%26"
//	    + "showapi_sign%3Dmysecret"
	    public static String result(String ISBN,String requestUrl) {
	    	
	       // String requestUrl = "http://www.weather.com.cn/data/cityinfo/101010100.html";//接口地址
	        Map params = new HashMap();//params用于存储请求数据的参数
	        
	        params.put("isbn", ISBN);//请求数据
	        
	        params.put("showapi_appid", "94112");//showapi_appid的值
	      
	        params.put("showapi_timestamp", get_time());  //添加时间
	       
	        params.put("showapi_sign", "9a147a4260a34c9c8c4b304decf73744"); //数字签名，###填你的数字签名，可以在你的个人中心看到
	        
	        
	        String s = httpRequest(requestUrl, params);//调用httpRequest方法，这个方法主要用于请求地址，并加上请求参数
	       // System.out.println(s);
	       // String json=xmlToJson(s);
	        
	       // JSONObject jsonObject = XML.toJSONObject(read.asXML());
	        //设置缩进转为字符串
	        //System.out.println(jsonObject.toString(3));
	        return s;
	    }

	    private static String httpRequest(String requestUrl, Map params) {
	    	//buffer用于接受返回的数据
	        StringBuffer buffer = new StringBuffer();
	        try {
	        	//建立URL，把请求地址给补全，其中urlencode（）方法用于把params里的参数给取出来
	            URL url = new URL(requestUrl+"?"+urlencode(params)); 
	            //打开http连接
	            HttpURLConnection httpUrlConnection = (HttpURLConnection) url.openConnection();//连接
	            httpUrlConnection.setDoInput(true);//与输入对应
	            httpUrlConnection.setRequestMethod("GET");
	            httpUrlConnection.connect();

	            //获得输入
	            InputStream inputStream = httpUrlConnection.getInputStream();
	            InputStreamReader inputStreamReader = new InputStreamReader(inputStream,"utf-8");//编码
	            BufferedReader bufferedReader =  new BufferedReader(inputStreamReader);


	            //将bufferReader的值给放到str里->buffer
	            String str = null;
	            while((str = bufferedReader.readLine()) != null) {
	                buffer.append(str);
	            }


	            //关闭bufferReader和输入流
	            bufferedReader.close();
	            inputStreamReader.close();
	            inputStream.close();
	           // inputStream = null;

	            //断开连接
	            httpUrlConnection.disconnect();

	        } catch(Exception ex) {
	            ex.printStackTrace();
	        }
	        //返回字符串
	        return buffer.toString();
	    }

	    public static String urlencode(Map<String, Object> data) {//Map-一个集合包含一个字符串和一个对象

	    	//将map里的参数变成像 showapi_appid=xxx&showapi_sign=xxx&的样子，这是api请求的格式
	        StringBuilder sb = new StringBuilder();//将data的内容放在sb中
	        for(Map.Entry i : data.entrySet()) {
	            try {
	                sb.append(i.getKey()).append("=").append(URLEncoder.encode(i.getValue() + "", "UTF-8")).append("&");
	            } catch (UnsupportedEncodingException ex) {
	                ex.printStackTrace();
	            }
	        }
	        return sb.toString();
	    }
	/*
	 * public static String xmlToJson(String s) {
	 * 
	 * }
	 */    
	    
	    
	    private static HashMap<String, String> cityMap = new HashMap<String, String>();

	    // 初始化cityMap
	    public static void initCityMap(String fileName) throws IOException {
	        File file = new File(fileName);
	        BufferedReader reader = null;
	        try {
	            reader = new BufferedReader(new FileReader(file));
	            String tempString = null;
	            while ((tempString = reader.readLine()) != null) {
	                String[] strs = tempString.split("\t");
	                if (cityMap.get(strs[0]) == null) {
	                    cityMap.put(strs[0], strs[1]);
	                } else {
	                    System.out.println("城市键重复  " + strs[1]);
	                }
	            }
	            reader.close();
	        } catch (IOException e) {
	            e.printStackTrace();
	            throw e;
	        } finally {
	            if (reader != null) {
	                try {
	                    reader.close();
	                } catch (IOException e1) {
	                    throw e1;
	                }
	            }
	        }
	    }

	    // 输入城市名，返回城市代码
	    public static String cityToCode(String cityName) {
	        String code = cityMap.get(cityName);//匹配
	        if (code == null) {
	            return null;
	        }
	        return code;
	    }
	    
	    
	    
	}
	




