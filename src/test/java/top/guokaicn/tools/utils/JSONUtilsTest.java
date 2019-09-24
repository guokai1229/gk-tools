package top.guokaicn.tools.utils;

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
	}

	@Test
	public void createObjectNode()
	{
	}

	@Test
	public void createArrayNode()
	{
	}
}
