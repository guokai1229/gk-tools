package top.guokaicn.tools.utils;

import java.lang.reflect.Method;
/**
 * class工具类 ,用来处理java的反射的一般方法
 * 
 * @author gk
 *
 */
public class ClassUtils
{
	/**
	 * 获得class loader<br>
	 * 若当前线程class loader不存在，取当前类的class loader
	 * 
	 * @return 类加载器
	 */
	public static ClassLoader getClassLoader()
	{
		ClassLoader classLoader = getContextClassLoader();

		if (classLoader == null)
		{
			classLoader = ClassUtils.class.getClassLoader();
		}

		return classLoader;
	}

	/**
	 * 获取当前线程的class loader
	 * 
	 * @return 类加载器
	 */
	public static ClassLoader getContextClassLoader()
	{
		return Thread.currentThread().getContextClassLoader();
	}

	/**
	 * 通过类名实例化对象
	 * @param clazz 类名
	 * @param <T> 实例
	 * @return 实例
	 */
	public static <T> T newInstance(String clazz)
	{
		T t = null;

		try
		{
			Class cla = loadClass(clazz);

			if(cla != null)
			{
				t = (T) cla.newInstance();
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

		return t;
	}

	/**
	 * 通过class对象实例化对象
	 * @param clazz 类名
	 * @param <T> 实例
	 * @return 实例
	 */
	public static <T> T newInstance(Class<T> clazz)
	{
		T t = null;

		try
		{
			t = clazz.newInstance();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

		return t;
	}

	/**
	 * 通过class对象和构造函数参数实例化对象
	 * @param clazz 类名
	 * @param params 参数
	 * @param <T> 实例
	 * @return 实例
	 */
	public static <T> T newInstance(Class<T> clazz, Object... params)
	{
		T t = null;

		if (params == null || params.length ==0)
		{
			return newInstance(clazz);
		}

		try
		{
			t = clazz.getDeclaredConstructor(getClasses(params)).newInstance(params);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

		return t;
	}

	/**
	 * 查找方法
	 * @param clazz 类名
	 * @param methodName 方法名
	 * @param paramTypes 参数类型
	 * @return 方法
	 */
	public static Method findMethod(Class<?> clazz, String methodName, Class<?>... paramTypes)
	{
		try
		{
			return clazz.getMethod(methodName, paramTypes);
		}
		catch (NoSuchMethodException ex)
		{
			return findDeclaredMethod(clazz, methodName, paramTypes);
		}
	}

	/**
	 * 查找所有方法
	 * @param clazz 类名
	 * @param methodName 方法名
	 * @param paramTypes 参数类型
	 * @return 方法
	 */
	public static Method findDeclaredMethod(Class<?> clazz, String methodName, Class<?>... paramTypes)
	{
		try
		{
			return clazz.getDeclaredMethod(methodName, paramTypes);
		}
		catch (NoSuchMethodException ex)
		{
			if (clazz.getSuperclass() != null)
			{
				return findDeclaredMethod(clazz.getSuperclass(), methodName, paramTypes);
			}

			return null;
		}
	}

	/**
	 * 加载类并初始化
	 * @param className 类名
	 * @return 实例
	 */
	public static Class loadClass(String className)
	{
		try
		{
			return org.apache.commons.lang.ClassUtils.getClass(className);
		}
		catch (ClassNotFoundException e)
		{
			return null;
		}
	}

	/**
	 * 加载类
	 * @param className 类名
	 * @param isInitialized 是否初始化
	 * @return 实例
	 */
	public static Class loadClass(String className, boolean isInitialized)
	{
		try
		{
			return org.apache.commons.lang.ClassUtils.getClass(getClassLoader(),className,isInitialized);
		}
		catch (ClassNotFoundException e)
		{
			return null;
		}
	}

	/**
	 * 获得对象数组的类数组
	 * @param objects 对象数组
	 * @return 类数组
	 */
	public static Class<?>[] getClasses(Object... objects)
	{
		Class<?>[] classes = new Class<?>[objects.length];

		for (int i = 0; i < objects.length; i++)
		{
			classes[i] = objects[i].getClass();
		}
		return classes;
	}
}
