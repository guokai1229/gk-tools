package top.guokaicn.tools.utils;

import org.w3c.dom.*;
import org.xml.sax.InputSource;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;
import java.io.StringReader;
import java.util.HashMap;
import java.util.Map;

/**
 * xml操作的工具类，通过dom4j来进行操作的封装
 * @author GK
 */
public class XMLUtils
{

	/**
	 * xml的字符串转换为map对象,子标签和属性都会被放入key
	 * @param content 字符串内容
	 * @return 数据
	 */
	public static Map<String,Object> stringToMap(String content)
	{
		Map<String,Object> instance = null;

		try
		{
			StringReader sr = new StringReader(content);
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder=factory.newDocumentBuilder();
			Document doc = builder.parse(new InputSource(sr));
			instance = stringToMap(doc.getDocumentElement());
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

		return instance;
	}

	/**
	 * xml的字符串转换为map对象，会通过转换完成以后的xml，查找对应的xpath，子标签和属性都会被放入key
	 * @param content 字符串内容
	 * @param xpath xpath
	 * @return 数据
	 */
	public static Map<String,Object> stringToMap(String content,String xpath)
	{
		Map<String,Object> instance = null;

		try
		{
			StringReader sr = new StringReader(content);
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder=factory.newDocumentBuilder();
			Document doc = builder.parse(new InputSource(sr));
			final XPath xPath = XPathFactory.newInstance().newXPath();
			XPathExpression expr = xPath.compile(xpath);
			Node node = (Node) expr.evaluate(doc, XPathConstants.NODE);
			instance = stringToMap(node);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

		return instance;
	}

	/**
	 * xml的字符串转换为map对象,子标签和属性都会被放入key
	 * @param element Element元素
	 * @return 数据
	 */
	public static Map<String,Object> stringToMap(Node element)
	{
		Map<String,Object> instance = new HashMap<>();

		try
		{
			NamedNodeMap attributes =  element.getAttributes();

			for(int i=0;i<attributes.getLength();i++)
			{
				instance.put(attributes.item(i).getNodeName(),attributes.item(i).getNodeValue());
			}

			NodeList elements = element.getChildNodes();

			for(int i=0;i<elements.getLength();i++)
			{
				String name = elements.item(i).getNodeName();

				String value = elements.item(i).getTextContent();

				instance.put(name,value);
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

		return instance;
	}

	/**
	 * xml的字符串转换为bean对象
	 * @param content xml字符串
	 * @param tClass 需要转换的class类型
	 * @param <T> 需要转换的类型
	 * @return 数据
	 */
	public static <T> T stringToBean(String content,Class<T> tClass)
	{
		T t = null;

		Map<String, Object> instance = stringToMap(content);

		if(!instance.isEmpty())
		{
			t = BeanUtils.mapToBean(instance,tClass);
		}

		return t;
	}

	/**
	 * xml的字符串转换为bean对象
	 * @param content xml字符串
	 * @param xpath xpath路径
	 * @param tClass 需要转换的class类型
	 * @param <T> 需要转换的类型
	 * @return 数据
	 */
	public static <T> T stringToBean(String content,String xpath,Class<T> tClass)
	{
		T t = null;

		Map<String, Object> instance = stringToMap(content,xpath);

		if(!instance.isEmpty())
		{
			t = BeanUtils.mapToBean(instance,tClass);
		}

		return t;
	}
}
