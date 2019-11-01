package top.guokaicn.tools.utils;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class FormatUtilsTest
{

	@Test
	public void toBoolean()
	{
		boolean result = FormatUtils.toBoolean("true");

		result = FormatUtils.toBoolean("false");

		result = FormatUtils.toBoolean("null");
	}

	@Test
	public void toInt()
	{
		int result = FormatUtils.toInt("true");

		result = FormatUtils.toInt("321.32");

		result = FormatUtils.toInt("444");

		result = FormatUtils.toInt(null);
	}

	@Test
	public void testToInt()
	{
		int result = FormatUtils.toInt("true",1);

		result = FormatUtils.toInt("321.32",1);

		result = FormatUtils.toInt("444",1);

		result = FormatUtils.toInt(null,1);
	}

	@Test
	public void isInt()
	{
		boolean result = FormatUtils.isInt(null);

		System.out.println(result);

		result = FormatUtils.isInt("33");

		System.out.println(result);

		result = FormatUtils.isInt("3asdf");

		System.out.println(result);
	}

	@Test
	public void toLong()
	{
		long result = FormatUtils.toLong(null);

		System.out.println(result);

		result = FormatUtils.toLong("33");

		System.out.println(result);

		result = FormatUtils.toLong("3asdf");

		System.out.println(result);

		result = FormatUtils.toLong("33.44");

		System.out.println(result);
	}

	@Test
	public void testToLong()
	{
		long result = FormatUtils.toLong(null,5L);

		System.out.println(result);

		result = FormatUtils.toLong("33",5L);

		System.out.println(result);

		result = FormatUtils.toLong("3asdf",5L);

		System.out.println(result);

		result = FormatUtils.toLong("33.44",5L);

		System.out.println(result);
	}

	@Test
	public void isLong()
	{
		boolean result = FormatUtils.isLong(null);

		System.out.println(result);

		result = FormatUtils.isLong("33");

		System.out.println(result);

		result = FormatUtils.isLong("3asdf");

		System.out.println(result);
	}

	@Test
	public void toDouble()
	{
		double result = FormatUtils.toDouble(null);

		System.out.println(result);

		result = FormatUtils.toDouble("33");

		System.out.println(result);

		result = FormatUtils.toDouble("3asdf");

		System.out.println(result);

		result = FormatUtils.toDouble("33.44");

		System.out.println(result);
	}

	@Test
	public void testToDouble()
	{
		double result = FormatUtils.toDouble(null,0.5);

		System.out.println(result);

		result = FormatUtils.toDouble("33",0.5);

		System.out.println(result);

		result = FormatUtils.toDouble("3asdf",0.5);

		System.out.println(result);

		result = FormatUtils.toDouble("33.44",0.5);

		System.out.println(result);
	}

	@Test
	public void isDouble()
	{
		boolean result = FormatUtils.isDouble(null);

		System.out.println(result);

		result = FormatUtils.isDouble("33");

		System.out.println(result);

		result = FormatUtils.isDouble("3asdf");

		System.out.println(result);

		result = FormatUtils.isDouble("33.232");

		System.out.println(result);
	}

	@Test
	public void toFloat()
	{
		float result = FormatUtils.toFloat(null);

		System.out.println(result);

		result = FormatUtils.toFloat("33");

		System.out.println(result);

		result = FormatUtils.toFloat("3asdf");

		System.out.println(result);

		result = FormatUtils.toFloat("33.44");

		System.out.println(result);
	}

	@Test
	public void testToFloat()
	{
		float result = FormatUtils.toFloat(null,0.5f);

		System.out.println(result);

		result = FormatUtils.toFloat("33",0.5f);

		System.out.println(result);

		result = FormatUtils.toFloat("3asdf",0.5f);

		System.out.println(result);

		result = FormatUtils.toFloat("33.44",0.5f);

		System.out.println(result);
	}

	@Test
	public void isFloat()
	{
		boolean result = FormatUtils.isFloat(null);

		System.out.println(result);

		result = FormatUtils.isFloat("33");

		System.out.println(result);

		result = FormatUtils.isFloat("3asdf");

		System.out.println(result);

		result = FormatUtils.isFloat("33.232");

		System.out.println(result);
	}

	@Test
	public void getFormatNumber()
	{
		String result = FormatUtils.getFormatNumber(44,"0.0000");

		System.out.println(result);
	}

	@Test
	public void testGetFormatNumber()
	{
		String result = FormatUtils.getFormatNumber(44.44,"0.0");

		System.out.println(result);
	}

	@Test
	public void listToString()
	{
		List<String> list = new ArrayList<>();

		list.add("3");

		list.add("4");

		String result = FormatUtils.listToString(list,';');

		System.out.println(result);
	}

	@Test
	public void testListToString()
	{
		List<String> list = new ArrayList<>();

		list.add("3");

		list.add("4");

		String result = FormatUtils.listToString(list);

		System.out.println(result);
	}

	@Test
	public void stringToList()
	{
		List<String> result = FormatUtils.stringToList("3123,4124,5123");

		System.out.println(result);
	}

	@Test
	public void testStringToList()
	{
		List<String> result = FormatUtils.stringToList("3123;4124;5123",';');

		System.out.println(result);
	}

	@Test
	public void formatString()
	{
		Map valuesMap = new HashMap();
		valuesMap.put("animal", "quick brown fox");
		valuesMap.put("target", "lazy dog");
		String templateString = "The ${animal} jumped over the ${target}.";

		System.out.println(FormatUtils.formatString(templateString,valuesMap));
	}

	@Test
	public void testFormatString()
	{
		Map valuesMap = new HashMap();
		valuesMap.put("animal", "quick brown fox");
		valuesMap.put("target", "lazy dog");
		String templateString = "The #{animal} jumped over the #{target}.";

		System.out.println(FormatUtils.formatString(templateString,valuesMap,"#{","}",'#'));
	}

	@Test
	public void mapToBean()
	{
		Map<String,Object> data = new HashMap<>();

		data.put("test0","123123123");

		data.put("test1","2222222222");

		data.put("test2","3333333333");

		data.put("test3","4444444444");

		data.put("ctest0","4444444444");

		data.put("ctest1","4444444444");

		data.put("ctest2","4444444444");

		data.put("ctest3","4444444444");

		TestRecord alarmRecord= FormatUtils.mapToBean(data, TestRecord.class);

		System.out.println(alarmRecord);
	}

	@Test
	public void beanToMap()
	{
		Map<String,Object> data = new HashMap<>();

		data.put("test0","123123123");

		data.put("test1","2222222222");

		data.put("test2","3333333333");

		data.put("test3","4444444444");

		data.put("ctest0","4444444444");

		data.put("ctest1","4444444444");

		data.put("ctest2","4444444444");

		data.put("ctest3","4444444444");

		TestRecord alarmRecord= FormatUtils.mapToBean(data, TestRecord.class);

		Map<String,Object> result = FormatUtils.beanToMap(alarmRecord);

		System.out.println(result);
	}
}