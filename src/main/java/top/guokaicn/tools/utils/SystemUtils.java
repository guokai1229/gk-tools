package top.guokaicn.tools.utils;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.nio.charset.Charset;

/**
 * 系统信息工具，用于获取相关的系统信息
 * 
 * @author guokai
 *
 */
public class SystemUtils
{
	/**
	 * 获取当前工作目录
	 * @return 结果
	 */
	public static String getUserDir()
	{
		return System.getProperty("user.dir");
	}

	/**
	 * 获取当前用户名称
	 * @return 结果
	 */
	public static String getUserName()
	{
		return System.getProperty("user.name");
	}

	/**
	 * 获取用户的根目录
	 * @return 结果
	 */
	public static String getUserHome()
	{
		return System.getProperty("user.home");
	}

	/**
	 * 获取JRE目录
	 * @return 结果
	 */
	public static String getJavaJreHome()
	{
		return System.getProperty("java.home");
	}

	/**
	 * 获取操作系统的名称
	 * @return 结果
	 */
	public static String getOsName()
	{
		return System.getProperty("os.name");
	}

	/**
	 * 获取操作系统的版本
	 * @return 结果
	 */
	public static String getOsVersion()
	{
		return System.getProperty("os.version");
	}

	/**
	 * 获取java的版本
	 * @return 结果
	 */
	public static String getJavaVersion()
	{
		return System.getProperty("java.version");
	}

	/**
	 * 获取CLASS路径
	 * @return 结果
	 */
	public static String getClassPath()
	{
		return System.getProperty("java.class.path");
	}

	/**
	 * 获取目录分割符
	 * @return 结果
	 */
	public static String getPathSeparator()
	{
		return System.getProperty("path.separator");
	}

	/**
	 * 获取文件分隔符
	 * @return 结果
	 */
	public static String getFileSeparator()
	{
		return System.getProperty("file.separator");
	}

	/**
	 * 获取默认的文件编码
	 * @return 结果
	 */
	public static String getFileEncoding()
	{
		return System.getProperty("file.encoding");
	}

	/**
	 * 获取当前系统换行符
	 * @return 结果
	 */
	public static String getSystemLineSeparator()
	{
		return System.getProperty("line.separator");
	}

	/**
	 * @return 系统字符集编码
	 */
	public static String getSystemCharset()
	{
		return Charset.defaultCharset().name();
	}

	/**
	 * 获取机器HOST
	 * @return 结果
	 */
	public static String getHostName()
	{
		String result = "";

		try
		{
			InetAddress addr = InetAddress.getLocalHost();

			result = addr.getHostName();
		}
		catch (UnknownHostException e)
		{
			e.printStackTrace();
		}

		return result;
	}

	/**
	 * 获取机器IP地址
	 * @return 结果
	 */
	public static String getHostIP()
	{
		String result = "";

		try
		{
			InetAddress addr = InetAddress.getLocalHost();

			result = addr.getHostAddress();
		}
		catch (UnknownHostException e)
		{
			e.printStackTrace();
		}

		return result;
	}
}
