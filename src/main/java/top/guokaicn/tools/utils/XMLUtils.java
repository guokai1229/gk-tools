package top.guokaicn.tools.utils;

import org.apache.commons.lang.StringUtils;
import org.dom4j.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class XMLUtils
{
	public static Map<String,Object> stringToMap(String content)
	{
		Map<String,Object> instance = new HashMap<>();

		try
		{
			Document doc = DocumentHelper.parseText(content);

			Element root = doc.getRootElement();

			List<Attribute> attributes =  root.attributes();

			for(Attribute attr : attributes)
			{
				instance.put(attr.getName(),attr.getValue());
			}

			List<Element> elements = root.elements();

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

	public static <T> T stringToBean(String content,Class<T> tClass)
	{
		T t = null;

		Map<String, Object> instance = stringToMap(content);

		if(!instance.isEmpty())
		{
			t = ClassUtils.mapToBean(instance,tClass);
		}

		return t;
	}
}
