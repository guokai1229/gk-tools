package top.guokaicn.tools.utils;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class JSONUtils
{
	private static volatile ObjectMapper mapper;

	//初始化ObjectMapper
	static
	{
		mapper = new ObjectMapper();
		//解析使用Java/C++ 样式的注释（包括'/'+'*' 和'//' 变量）
		mapper.configure(JsonParser.Feature.ALLOW_COMMENTS, true);
		//允许单引号来包住属性名称和字符串值
		mapper.configure(JsonParser.Feature.ALLOW_SINGLE_QUOTES, true);
	}

	/**
	 * 对象转换为json字符串
	 *
	 * @param obj 对象
	 * @return 字符串
	 */
	public static String objectToString(Object obj)
	{
		String result = null;

		try
		{
			result = mapper.writeValueAsString(obj);
		}
		catch (JsonProcessingException e)
		{
			e.printStackTrace();
		}

		return result;
	}

	/**
	 * json字符串转换为对象
	 *
	 * @param value 字符串
	 * @param clazz 类
	 * @param <T> 类型
	 * @return 对象
	 */
	public static <T> T stringToObject(String value, Class<T> clazz)
	{
		T obj = null;

		try
		{
			obj = mapper.readValue(value, clazz);
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}

		return obj;
	}

	/**
	 * 字符串转换为list
	 * @param value 字符串
	 * @param clazz 类
	 * @param <T> 类型
	 * @return list对象
	 */
	public static<T> List<T> stringToList(String value, Class<T> clazz)
	{
		List<T> list = null;

		try
		{
			JavaType collectionType  = mapper.getTypeFactory().constructParametricType(List.class,clazz);

			list =  mapper.readValue(value,collectionType);
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}

		return list;
	}

	/**
	 * 字符串转普通的map对象
	 * @param value 值
	 * @return 结果
	 */
	public static Map<String,Object> stringToMap(String value)
	{
		Map<String,Object> map = null;

		try
		{
			map = mapper.readValue(value, new TypeReference<Map<String,Object>>() { });
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}

		return map;
	}

	/**
	 * 字符串转为map
	 * @param value 字符串
	 * @param clazz 类
	 * @param <T> 类型
	 * @return 值
	 */
	public static<T> Map<String,T> stringToMap(String value, Class<T> clazz)
	{
		Map<String,T> map = null;

		try
		{
			Map<String,Object> data = mapper.readValue(value, new TypeReference<Map<String,Object>>() { });

			if(data != null)
			{
				map = new LinkedHashMap<>();

				for(Map.Entry<String,Object> entry : data.entrySet())
				{
					String key = entry.getKey();

					String val = objectToString(entry.getValue());

					map.put(key,stringToObject(val,clazz));
				}
			}
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}

		return map;
	}

	/**
	 * 字符串创建json对象
	 *
	 * @param data 数据
	 * @return 对象
	 */
	public static JsonNode stringToJsonObject(String data)
	{
		ObjectMapper mapper = new ObjectMapper();
		try
		{
			return mapper.readTree(data);
		}
		catch (IOException e)
		{
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * object创建json对象
	 * @param data 数据
	 * @return 对象
	 */
	public static JsonNode objectToJsonObject(Object data)
	{
		ObjectMapper mapper = new ObjectMapper();
		return mapper.valueToTree(data);
	}

	/**
	 * 创建一个对象节点
	 *
	 * @return 节点
	 */
	public static ObjectNode createObjectNode()
	{
		ObjectMapper mapper = new ObjectMapper();
		return mapper.createObjectNode();
	}

	/**
	 * 创建一个数组节点
	 *
	 * @return 数组节点
	 */
	public static ArrayNode createArrayNode()
	{
		ObjectMapper mapper = new ObjectMapper();
		return mapper.createArrayNode();
	}

}
