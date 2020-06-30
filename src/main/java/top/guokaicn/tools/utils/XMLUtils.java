package top.guokaicn.tools.utils;

import org.apache.commons.lang.StringUtils;
import org.dom4j.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * xml操作的工具类，通过dom4j来进行操作的封装
 * @author GK
 */
public class XMLUtils
{
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
			Document doc = DocumentHelper.parseText(content);

			Element root = doc.getRootElement();

			instance = stringToMap((Element) root.selectSingleNode(xpath));
		}
		catch (DocumentException e)
		{
			e.printStackTrace();
		}

		return instance;
	}

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
			Document doc = DocumentHelper.parseText(content);

			instance = stringToMap(doc.getRootElement());
		}
		catch (DocumentException e)
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
	public static Map<String,Object> stringToMap(Element element)
	{
		Map<String,Object> instance = new HashMap<>();

		try
		{
			List<Attribute> attributes =  element.attributes();

			for(Attribute attr : attributes)
			{
				instance.put(attr.getName(),attr.getValue());
			}

			List<Element> elements = element.elements();

			for(Element ele : elements)
			{
				String value = ele.getText();

				if(StringUtils.isBlank(value) && !ele.elements().isEmpty())
				{
					value = ele.asXML();
				}

				instance.put(ele.getName(),value);
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
