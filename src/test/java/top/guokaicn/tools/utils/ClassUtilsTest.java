package top.guokaicn.tools.utils;

import org.junit.Test;
import top.guokaicn.tools.handler.ConfigHandler;

import java.lang.reflect.Method;

public class ClassUtilsTest
{

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
		ConfigHandler config = ClassUtils.newInstance(ConfigHandler.class,"D:\\test\\测试\\11\\xcf1.txt");

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