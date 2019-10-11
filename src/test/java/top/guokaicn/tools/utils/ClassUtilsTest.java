package top.guokaicn.tools.utils;

import org.junit.Test;
import top.guokaicn.tools.handler.ConfigHandler;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class ClassUtilsTest
{
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

		TestRecord alarmRecord= ClassUtils.mapToBean(data, TestRecord.class);

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

		TestRecord alarmRecord= ClassUtils.mapToBean(data, TestRecord.class);

		Map<String,Object> result = ClassUtils.beanToMap(alarmRecord);

		System.out.println(result);
	}

	@Test
	public void newInstance()
	{
		ClassUtils classa = ClassUtils.newInstance("top.guokaicn.tools.utils.ClassUtils");

		System.out.println(classa);
	}

	@Test
	public void testNewInstance()
	{
		ClassUtils classa = ClassUtils.newInstance(ClassUtils.class);

		System.out.println(classa);
	}

	@Test
	public void testNewInstance1()
	{
		String path = this.getClass().getResource("/").getFile();

		ConfigHandler config = ClassUtils.newInstance(ConfigHandler.class,path+"\\config.properties");

		System.out.println(config);
	}

	@Test
	public void findMethod()
	{
		Method me = ClassUtils.findMethod(ConfigHandler.class,"getString",String.class);

		System.out.println(me);
	}


	@Test
	public void loadClass()
	{
		Class classa = ClassUtils.loadClass("top.guokaicn.tools.utils.ClassUtils");

		System.out.println(classa);
	}

	@Test
	public void testLoadClass()
	{
		Class classa = ClassUtils.loadClass("top.guokaicn.tools.utils.ClassUtils",false);

		System.out.println(classa);
	}

	@Test
	public void getClasses()
	{
		ClassUtils a1 = new ClassUtils();

		FileUtils a2 = new FileUtils();

		Class[] result = ClassUtils.getClasses(a1,a2);

		System.out.println(result);
	}

}