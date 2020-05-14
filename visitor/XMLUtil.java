package visitor;

import javax.xml.parsers.*;
import org.w3c.dom.*;
import org.xml.sax.SAXException;
import java.io.*;

public class XMLUtil
{
//该方法用于从XML配置文件中提取具体类类名，并返回一个实例对象
public static Object getBean()
{
	try
	{
		//创建文档对象
		DocumentBuilderFactory dFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = dFactory.newDocumentBuilder();
		Document doc;
		doc = builder.parse(new File("config.xml"));
		//获取包含类名的文本节点
		NodeList nl = doc.getElementsByTagName("visitor");
			/*
			 * Node temp=nl.item(0); System.out.println(temp);
			 */
		Node classNode=nl.item(0).getFirstChild();
		
		String cName=classNode.getNodeValue();
		//通过类名生成实例对象并将其返回
		Class c=Class.forName("visitor."+cName);//必须是完整类名
		Object obj=c.newInstance();
		return obj;
	}
	catch(Exception e)
	{
		e.printStackTrace();
		return null;
	}
}
}
