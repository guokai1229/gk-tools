package top.guokaicn.tools.handler;

import org.apache.commons.lang.StringUtils;
import top.guokaicn.tools.utils.FormatUtils;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;

import java.util.Arrays;

/**
 * 配置文件处理器，用来管理配置文件信息,保存信息通过properties文件 封装关于配置文件的处理方法，可以在以后，进行替换和升级保存信息的具体方法
 * 
 * @author gk
 *
 */
public class ConfigHandler
{
	/**
	 * 默认名称
	 */
	private static String default_name = "C21F969B5F03D33D43E04F8F136E7682";
	/**
	 * properties文件配置对象
	 */
	private Properties config;
	/**
	 * properties对象集合
	 */
	private static final ConcurrentHashMap<String, ConfigHandler> config_map = new ConcurrentHashMap<String, ConfigHandler>();

	/**
	 * 创建CONFIG处理对象
	 * 
	 * @param param
	 */
	public static void createConfig(Object param)
	{
		createConfig(default_name,param);
	}
	

	/**
	 * 创建CONFIG处理对象
	 * 
	 * @param param
	 */
	public static void createConfig(String key, Object param)
	{
		ConfigHandler config = null;

		if (param instanceof String)
		{
			config = new ConfigHandler((String) param);
		}
		else if (param instanceof InputStream)
		{
			config = new ConfigHandler((InputStream) param);
		}

		if (config != null)
		{
			config_map.put(key, config);
		}
	}

	/**
	 * 获得全局配置文件对象
	 * 
	 * @return
	 */
	public static ConfigHandler getConfig()
	{
		return config_map.get(default_name);
	}
	
	/**
	 * 获得全局配置文件对象
	 * 
	 * @return
	 */
	public static ConfigHandler getConfig(String key)
	{
		return config_map.get(key);
	}
	
	/**
	 * 构造函数,通过文件地址来创建对象
	 * 
	 * @param pathAndfile
	 */
	public ConfigHandler(String pathAndfile)
	{
		try
		{
			config = new Properties();
			InputStream in = new BufferedInputStream(new FileInputStream(pathAndfile));
			config.load(in);
		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * 通过流对象来创建对象
	 * 
	 * @param inStream
	 */
	public ConfigHandler(InputStream inStream)
	{
		try
		{
			config = new Properties();
			config.load(inStream);
		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * 获得string值
	 * 
	 * @param key
	 * @return
	 */
	public String getString(String key)
	{
		return config.getProperty(key);
	}

	/**
	 * 获得string值
	 * 
	 * @param key
	 * @return
	 */
	public String getString(String key, String defaultValue)
	{
		String value = config.getProperty(key);

		return StringUtils.defaultIfBlank(value, defaultValue);
	}

	/**
	 * 获得boolean值
	 * 
	 * @param key
	 * @return
	 */
	public boolean getBoolean(String key)
	{
		String value = config.getProperty(key);
		
		return FormatUtils.toBoolean(value);
	}

	/**
	 * 取出Boolean类型的Property，但以System的Property优先.如果都为Null则返回Default值,如果内容不为true/false则返回false.
	 */
	public Boolean getBoolean(String key, boolean defaultValue)
	{
		String value = config.getProperty(key);
		
		value = StringUtils.defaultIfBlank(value, String.valueOf(defaultValue));

		return FormatUtils.toBoolean(value);
	}

	/**
	 * 获得int值
	 * 
	 * @param key
	 * @return
	 */
	public int getInt(String key)
	{
		String value = config.getProperty(key);

		return FormatUtils.toInt(value);
	}

	/**
	 * 获得int值
	 * 
	 * @param key
	 * @return
	 */
	public int getInt(String key, int defaultValue)
	{
		String value = config.getProperty(key);
		
		value = StringUtils.defaultIfBlank(value, String.valueOf(defaultValue));

		return FormatUtils.toInt(value);
	}

	/**
	 * 获取list对象
	 * 
	 * @param key
	 * @return
	 */
	public List<String> getList(String key)
	{
		return getList(key, ",");
	}

	/**
	 * 获取list对象
	 * 
	 * @param key
	 * @param regex
	 * @return
	 */
	public List<String> getList(String key, String regex)
	{
		if (StringUtils.isBlank(key))
		{
			return null;
		}

		ArrayList<String> list = new ArrayList<String>();

		String[] values = config.getProperty(key).split(regex);

		list.addAll(Arrays.asList(values));

		return list;
	}

}
