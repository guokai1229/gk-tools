package top.guokaicn.tools.utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class JSONUtilsTest
{

	@Test
	public void objectToString()
	{
		List<String> list = new ArrayList<String>();

		list.add("123");

		list.add("sdf");

		System.out.println(JSONUtils.objectToString(list));
	}

	@Test
	public void stringToObject()
	{
		List list = JSONUtils.stringToObject("['123',\"sdf\"]",List.class);

		System.out.println(list);
	}

	@Test
	public void stringToList()
	{
		List<String>  list = JSONUtils.stringToList("[\"123\",\"sdf\"]",String.class);

		System.out.println(list);
	}

	@Test
	public void stringToJsonObject()
	{
		JsonNode node = JSONUtils.stringToJsonObject("[\"123\",\"sdf\"]");

		System.out.println(node);
	}

	@Test
	public void createObjectNode()
	{
		JsonNode node =  JSONUtils.createObjectNode();

		System.out.println(node);
	}

	@Test
	public void createArrayNode()
	{
		ArrayNode array = JSONUtils.createArrayNode();

		System.out.println(array);
	}

	@Test
	public void objectToJsonObject()
	{
		List<String> list = new ArrayList<String>();

		list.add("123");

		list.add("sdf");

		JsonNode node = JSONUtils.objectToJsonObject(list);

		System.out.println(node);
	}

    @Test
    public void stringToMap()
    {
    	String testData = "{\"key\":\"123123\",\"value\":\"33333\"}";

		Map<String,Object> data = JSONUtils.stringToMap(testData);

		System.out.println(data);
    }

    @Test
    public void testStringToMap()
    {
		String testData = "{\"key1\":{\"name\":\"2222\",\"age\":17},\"key2\":{\"name\":\"3333\",\"age\":16}}";

		Map<String,TestData> data = JSONUtils.stringToMap(testData,TestData.class);

		System.out.println(data);
    }


    static class TestData{
		private String name;

		private String age;

		public String getName()
		{
			return name;
		}

		public void setName(String name)
		{
			this.name = name;
		}

		public String getAge()
		{
			return age;
		}

		public void setAge(String age)
		{
			this.age = age;
		}
	}
}
