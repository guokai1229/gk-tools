package top.guokaicn.tools.utils;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class FormatUtils
{
	/**
	 * 把字符串转换为boolean，如果为空，则默认为false
	 * @param str 字符串
	 * @return 结果
	 */
	public static boolean toBoolean(String str)
	{
		if(str == null || str.trim().equals(""))
		{
			return false;
		}

		return str.equals("true");
	}

	/**
	 * 把字符串转换为int，如果为空，则默认为-1
	 *
	 * @param str 字符串
	 * @return 值
	 */
	public static int toInt(String str)
	{
		return  toInt(str,-1);
	}

	/**
	 * 把字符串转换为int，如果为空，则使用默认值
	 * @param str 字符串
	 * @param defaultvalue 默认值
	 * @return 值
	 */
	public static int toInt(String str,int defaultvalue)
	{
		if (!isInt(str))
		{
			return defaultvalue;
		}
		else
		{
			return Integer.parseInt(str);
		}
	}

	/**
	 * 多个字符串参数，是否为INT型的字符
	 *
	 * @param strings 参数
	 * @return 值
	 */
	public static boolean isInt(String... strings)
	{
		if(strings != null && strings.length>0)
		{
			for(String str : strings)
			{
				if(str == null || str.trim().equals(""))
				{
					return false;
				}
			}
			try
			{
				for (String str : strings)
				{
					Integer.parseInt(str);
				}
			}
			catch (NumberFormatException e)
			{
				return false;
			}

			return true;
		}
		else
		{
			return false;
		}
	}

	/**
	 * 把字符串转换为long，如果为空，则默认为-1
	 *
	 * @param str 字符串
	 * @return 值
	 */
	public static long toLong(String str)
	{
		return toLong(str,-1L);
	}

	/**
	 * 把字符串转换为long，如果为空，则使用默认值
	 * @param str 字符串
	 * @param defaultvalue 默认值
	 * @return 值
	 */
	public static long toLong(String str,long defaultvalue)
	{
		if (!isLong(str))
		{
			return defaultvalue;
		}
		else
		{
			return Long.parseLong(str);
		}
	}

	/**
	 * 多个字符串参数，是否为long型的字符
	 *
	 * @param strings 参数
	 * @return 值
	 */
	public static boolean isLong(String... strings)
	{
		if(strings != null && strings.length>0)
		{
			for(String str : strings)
			{
				if(str == null || str.trim().equals(""))
				{
					return false;
				}
			}
			try
			{
				for (String str : strings)
				{
					Long.parseLong(str);
				}
			}
			catch (NumberFormatException e)
			{
				return false;
			}

			return true;
		}
		else
		{
			return false;
		}
	}

	/**
	 * 把字符串转换为double，如果为空，则默认为-1
	 *
	 * @param str 字符串
	 * @return 值
	 */
	public static double toDouble(String str)
	{
		return toDouble(str,-1.0);
	}

	/**
	 * 把字符串转换为double，如果为空，则使用默认值
	 * @param str 字符串
	 * @param defaultvalue 默认值
	 * @return 值
	 */
	public static double toDouble(String str,double defaultvalue)
	{
		if (!isDouble(str))
		{
			return defaultvalue;
		}
		else
		{
			return Double.parseDouble(str);
		}
	}

	/**
	 * 多个字符串参数，是否为double型的字符
	 *
	 * @param strings 参数
	 * @return 值
	 */
	public static boolean isDouble(String... strings)
	{
		if(strings != null && strings.length>0)
		{
			for(String str : strings)
			{
				if(str == null || str.trim().equals(""))
				{
					return false;
				}
			}
			try
			{
				for (String str : strings)
				{
					Double.parseDouble(str);
				}
			}
			catch (NumberFormatException e)
			{
				return false;
			}

			return true;
		}
		else
		{
			return false;
		}
	}

	/**
	 * 获取格式化数字，格式：#0.00
	 *
	 * @param value 需要格式化的数字
	 * @return 结果
	 */
	public static String getFormatNumber(double value, String format)
	{
		DecimalFormat df = new DecimalFormat("#"+format);

		String result = format;

		result = df.format(value);

		return result;
	}

	/**
	 * 获取格式化数字，格式：#0.00
	 *
	 * @param value 需要格式化的数字
	 * @return 结果
	 */
	public static String getFormatNumber(long value, String format)
	{
		DecimalFormat df = new DecimalFormat("#"+format);

		String result = format;

		result = df.format(value);

		return result;
	}

	/**
	 * 将list集合里字符串用逗号连接，返回字符串
	 * @param list list对象
	 * @return 结果
	 */
	public static String listToString(Collection<String> list)
	{
		return listToString(list,',');
	}

	/**
	 * 将list集合里字符串用expr分隔符连接，返回字符串
	 * @param list list对象
	 * @param separator 分隔符
	 * @return 结果
	 */
	public static String listToString(Collection<String> list, Character separator)
	{
		StringBuilder sb = new StringBuilder();

		for (String s : list)
		{
			sb.append(s).append(separator);
		}
		return sb.toString().substring(0, sb.toString().length() - 1);
	}

	/**
	 * 将字符串转换为list对象
	 * @param str 字符串对象
	 * @return list对象
	 */
	public static List<String> stringToList(String str)
	{
		return stringToList(str,',');
	}

	/**
	 * 根据分隔符将字符串转换为list对象
	 * @param str 字符串对象
	 * @param separator 分隔符
	 * @return list对象
	 */
	public static List<String> stringToList(String str,Character separator)
	{
		String[] data = str.split(separator.toString());

		return Arrays.asList(data);
	}
}
