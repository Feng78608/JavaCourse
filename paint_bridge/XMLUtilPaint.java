package paint_bridge;

import javax.xml.parsers.*;
import org.w3c.dom.*;
import org.xml.sax.SAXException;
import java.io.*;

public class XMLUtilPaint
{
//�÷������ڴ�XML�����ļ�����ȡ������������������һ��ʵ������
public static Object getBean(String key)
{
	try
	{
		//�����ĵ�����
		DocumentBuilderFactory dFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = dFactory.newDocumentBuilder();
		Document doc;
		doc = builder.parse(new File("config.xml"));
		//��ȡ�����������ı��ڵ�
		NodeList nl = doc.getElementsByTagName(key);
			/*
			 * Node temp=nl.item(0); System.out.println(temp);
			 */
		Node classNode=nl.item(0).getFirstChild();
		
		String cName=classNode.getNodeValue();
		//ͨ����������ʵ�����󲢽��䷵��
		Class c=Class.forName("paint_bridge."+cName);//��������������
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
