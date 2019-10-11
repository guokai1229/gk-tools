package top.guokaicn.tools.utils;

import org.junit.Test;

import java.util.Map;

public class XMLUtilsTest
{

	@Test
	public void stringToMap()
	{
		String test = "<?xml version='1.0' encoding='iso-8859-1'?>";
		test += "<OneRecord ";
		test += "test0='2066648074' ";
		test += "test1='1420895508' ";
		test += "test2='4150201310' ";
		test += "test3='549553939' ";
		test += "ctest0='587339464' ";
		test += "ctest1='281252274' ";
		test += "ctest2='896203839' ";
		test += "ctest3='3515490974' ";
		test += "status='0'  ";
		test += "time='2019-06-12 14:19:52' ";
		test += "region_name='afff' ";
		test += "msg='33' ";
		test += "city_name='' ";
		test += "/>";

		Map<String,Object> data =  XMLUtils.stringToMap(test);

		System.out.println(data);
	}

	@Test
	public void stringToBean()
	{
		String test = "<?xml version='1.0' encoding='iso-8859-1'?>";
		test += "<OneRecord ";
		test += "test0='2066648074' ";
		test += "test1='1420895508' ";
		test += "test2='4150201310' ";
		test += "test3='549553939' ";
		test += "ctest0='587339464' ";
		test += "ctest1='281252274' ";
		test += "ctest2='896203839' ";
		test += "ctest3='3515490974' ";
		test += "status='0'  ";
		test += "time='2019-06-12 14:19:52' ";
		test += "region_name='afff' ";
		test += "city_name='' ";
		test += ">";
		test += "<msg><test>33123</test></msg>";
		test += "</OneRecord>";

		TestRecord data =  XMLUtils.stringToBean(test, TestRecord.class);

		System.out.println(data);
	}
}