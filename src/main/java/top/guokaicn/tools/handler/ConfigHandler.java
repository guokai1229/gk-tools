package top.guokaicn.tools.handler;

import org.apache.commons.lang.StringUtils;
import top.guokaicn.tools.utils.FormatUtils;
import top.guokaicn.tools.utils.UUIDUtils;

import java.io.*;
import java.nio.charset.Charset;
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
	 * properties文件配置对象
	 */
	private Properties config;
	/**
	 * 默认key对象
	 */
	private static String default_key;
	/**
	 * properties对象集合
	 */
	private static final ConcurrentHashMap<String, ConfigHandler> config_map = new ConcurrentHashMap<String, ConfigHandler>();

	/**
	 * 创建CONFIG处理对象
	 * 
	 * @param param 参数
	 */
	public static void createConfig(Object param)
	{
		default_key = UUIDUtils.getUUID();
		createConfig(default_key,param);
	}


	/**
	 * 创建CONFIG处理对象
	 *
	 * @param key key值
	 * @param param 参数
	 */
	public static void createConfig(String key, Object param)
	{
		ConfigHandler config = null;

		if (param instanceof String)
		{
			File file = new File((String) param);

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
	 * @return 配置对象
	 */
	public static ConfigHandler getConfig()
	{
		return config_map.get(default_key);
	}
	
	/**
	 * 获得全局配置文件对象
	 *
	 * @param key key值
	 * @return 配置对象
	 */
	public static ConfigHandler getConfig(String key)
	{
		return config_map.get(key);
	}
	
	/**
	 * 构造函数,通过文件地址来创建对象
	 * 
	 * @param pathAndfile 文件路径
	 */
	public ConfigHandler(String pathAndfile)
	{
		try
		{
			config = new Properties();
			InputStream in = new BufferedInputStream(new FileInputStream(pathAndfile));
			config.load(in);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * 构造函数,通过文本内容来创建对象
	 * @param content 文本内容
	 * @param charset 编码格式
	 */
	public ConfigHandler(String content, Charset charset)
	{
		try
		{
			config = new Properties();
			InputStream in = new ByteArrayInputStream(content.getBytes(charset));
			config.load(in);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * 通过流对象来创建对象
	 * 
	 * @param inStream 输入流
	 */
	public ConfigHandler(InputStream inStream)
	{
		try
		{
			config = new Properties();
			config.load(inStream);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * 获得string值
	 * 
	 * @param key key值
	 * @return 值
	 */
	public String getString(String key)
	{
		return config.getProperty(key);
	}

	/**
	 * 获得string值
	 * 
	 * @param key key值
	 * @param defaultValue 默认值
	 * @return 值
	 */
	public String getString(String key, String defaultValue)
	{
		String value = config.getProperty(key);

		return StringUtils.defaultIfBlank(value, defaultValue);
	}

	/**
	 * 获得boolean值
	 * 
	 * @param key key值
	 * @return 值
	 */
	public boolean getBoolean(String key)
	{
		String value = config.getProperty(key);
		
		return FormatUtils.toBoolean(value);
	}

	/**
	 * 取出Boolean类型的Property，但以System的Property优先.如果都为Null则返回Default值,如果内容不为true/false则返回false.
	 * @param key key值
	 * @param defaultValue 默认值
	 * @return 值
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
	 * @param key key值
	 * @return 值
	 */
	public int getInt(String key)
	{
		String value = config.getProperty(key);

		return FormatUtils.toInt(value);
	}

	/**
	 * 获得int值
	 *
	 * @param key key值
	 * @param defaultValue 默认值
	 * @return 值
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
	 * @param key key值
	 * @return 值
	 */
	public List<String> getList(String key)
	{
		return getList(key, ",");
	}

	/**
	 * 获取list对象
	 * 
	 * @param key key值
	 * @param regex 切分字符串
	 * @return 值
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
