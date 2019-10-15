package top.guokaicn.tools.utils;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.io.File;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * class工具类 ,用来处理java的反射的一般方法
 * 
 * @author gk
 *
 */
public class ClassUtils
{

	/**
	 * map转换为bean对象
	 * @param map 数据
	 * @param clazz class名称
	 * @param <T> 对象
	 * @return 数据
	 */
	public static <T> T mapToBean(Map<String,Object> map,Class clazz)
	{
		T bean = null;

		try
		{
			bean = (T) clazz.newInstance();

			PropertyDescriptor[] propertyDescriptors = Introspector.getBeanInfo(clazz).getPropertyDescriptors();

			for (PropertyDescriptor property : propertyDescriptors)
			{
				String propertyName = property.getName();

				Object value = map.get(propertyName);

				if(value != null)
				{
					Method setter = property.getWriteMethod();

					Class paramtypes = setter.getParameterTypes()[0];

					if(value.getClass().equals(paramtypes))
					{
						setter.invoke(bean, value);
					}
				}
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

		return bean;
	}

	/**
	 * bean转换为map对象
	 * @param obj 对象
	 * @param <T> 对象
	 * @return map对象
	 */
	public static <T> Map<String,Object> beanToMap(T obj)
	{
		Map<String,Object> result = new HashMap<>();

		try
		{
			if(obj != null)
			{
				BeanInfo beanInfo = Introspector.getBeanInfo(obj.getClass());

				PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();

				for (PropertyDescriptor property : propertyDescriptors)
				{
					String propertyName = property.getName();

					if (!propertyName.equals("class"))
					{
						Method getter = property.getReadMethod();

						Object value = getter.invoke(obj);

						result.put(propertyName,value);
					}
				}
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

		return result;
	}

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
			t = (T) Class.forName(clazz).newInstance();
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
	 * @param <T> 实例
	 * @return 实例
	 */
	public static <T> Class<T> loadClass(String className)
	{
		return loadClass(className, true);
	}

	/**
	 * 加载类
	 * @param className 类名
	 * @param isInitialized 是否初始化
	 * @param <T> 实例
	 * @return 实例
	 */
	public static <T> Class<T> loadClass(String className, boolean isInitialized)
	{
		Class<T> clazz = null;
		try
		{
			clazz = (Class<T>) Class.forName(className, isInitialized, getClassLoader());
		}
		catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		return clazz;
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

	/**
	 * 判断文件是否为class文件
	 * @param file 文件
	 * @return 结果
	 */
	public static boolean isClassFile(File file)
	{
		return isClass(file.getName());
	}

	/**
	 * 判断文件是否为jar文件
	 * @param file 文件
	 * @return 结果
	 */
	public static boolean isJarFile(File file)
	{
		return file.getName().endsWith(".jar");
	}

	/**
	 * 判断是否为class
	 * @param fileName 名称
	 * @return 结果
	 */
	private static boolean isClass(String fileName)
	{
		return fileName.endsWith(".class");
	}

}
