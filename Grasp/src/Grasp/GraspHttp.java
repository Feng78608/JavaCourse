package Grasp;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.Writer;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;



public class GraspHttp {
	 public static void main(String[] args) throws Exception {
	    	
	        CloseableHttpClient closeableHttpClient=HttpClients.createDefault();//发送Get请求
	        //发送GET请求，创建HttpGet对象，并指定请求URL
	        HttpGet httpGet=new HttpGet("http://www.w3.org/Consortium/Member/List");
	             //.execute（HttpUriRequest request）该方法返回一个HttpResponse。 
	        CloseableHttpResponse closeableHttpResponse=closeableHttpClient.execute(httpGet);
	        //getEntity()方法可获取HttpEntity对象，该对象包装了服务器的响应内容
	        HttpEntity httpEntity=closeableHttpResponse.getEntity(); //获取实体、网页内容
	           //这个静态方法将HttpEntity转换成字符串,防止服务器返回的数据带有中文,所以在转换的时候将字符集指定成utf-8就可以了
	        String str=EntityUtils.toString(httpEntity, "utf-8");
	         //释放连接
	        closeableHttpResponse.close();
	        closeableHttpClient.close();
	         
	        Document document=Jsoup.parse(str); //解析网页
	         
	        //查找url主页下的class样式为member的所有<li>，可以查看源代码看样式
	        Elements elements=document.select(".member");
	        for(Element e:elements){
	            System.out.println(e.text());
	        }
	        
	        Writer write = null;
	        BufferedWriter bufferedWriter = null;

	        try {
	            write = new FileWriter("E:\\eclipse\\JavaTest\\src\\bits\\org\\find\\result.txt");
	            bufferedWriter = new BufferedWriter(write);

	            for(int i=0;i<elements.size();i++){
	                bufferedWriter.write(elements.get(i).text()+"\r\n");//写入换行
	            }
	            System.out.println("写入完成！");

	        } catch (Exception e) {
	            e.printStackTrace();
	        }finally {
	            try {
	                bufferedWriter.flush();
	                write.flush();
	                bufferedWriter.close();
	                write.close();

	            } catch (Exception e) {
	                e.printStackTrace();
	            }
	        }

	    }

}
