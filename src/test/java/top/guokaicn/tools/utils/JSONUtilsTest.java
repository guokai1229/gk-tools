package top.guokaicn.tools.utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

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
		List list = JSONUtils.stringToObject("[\"123\",\"sdf\"]",List.class);

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
}
