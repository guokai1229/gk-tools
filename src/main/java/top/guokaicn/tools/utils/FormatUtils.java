package top.guokaicn.tools.utils;

import org.apache.commons.lang.BooleanUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;
import org.apache.commons.lang.text.StrSubstitutor;

import java.text.DecimalFormat;
import java.util.*;

public class FormatUtils
{
	/**
	 * 把字符串转换为boolean，如果为空，则默认为false
	 * @param str 字符串
	 * @return 结果
	 */
	public static boolean toBoolean(String str)
	{
		return BooleanUtils.toBoolean(str);
	}

	/**
	 * 把字符串转换为int，如果为空，则默认为-1
	 *
	 * @param str 字符串
	 * @return 值
	 */
	public static int toInt(String str)
	{
		return toInt(str,-1);
	}

	/**
	 * 把字符串转换为int，如果为空，则使用默认值
	 * @param str 字符串
	 * @param defaultValue 默认值
	 * @return 值
	 */
	public static int toInt(String str,int defaultValue)
	{
		if(NumberUtils.isNumber(str))
		{
			Number num =  NumberUtils.createNumber(str);

			return num.intValue();
		}
		else
		{
			return NumberUtils.toInt(str,defaultValue);
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
	 * @param defaultValue 默认值
	 * @return 值
	 */
	public static long toLong(String str,long defaultValue)
	{
		if(NumberUtils.isNumber(str))
		{
			Number num =  NumberUtils.createNumber(str);

			return num.longValue();
		}
		else
		{
			return NumberUtils.toLong(str,defaultValue);
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
	 * @param defaultValue 默认值
	 * @return 值
	 */
	public static double toDouble(String str,double defaultValue)
	{
		return NumberUtils.toDouble(str, defaultValue);
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
	 * 把字符串转换为float，如果为空，则默认为-1
	 *
	 * @param str 字符串
	 * @return 值
	 */
	public static float toFloat(String str)
	{
		return toFloat(str,-1.0f);
	}

	/**
	 * 把字符串转换为float，如果为空，则使用默认值
	 * @param str 字符串
	 * @param defaultValue 默认值
	 * @return 值
	 */
	public static float toFloat(String str,float defaultValue)
	{
		return NumberUtils.toFloat(str, defaultValue);
	}

	/**
	 * 多个字符串参数，是否为float型的字符
	 *
	 * @param strings 参数
	 * @return 值
	 */
	public static boolean isFloat(String... strings)
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
					Float.parseFloat(str);
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
	 * @param format 格式
	 * @return 结果
	 */
	public static String getFormatNumber(double value, String format)
	{
		DecimalFormat df = new DecimalFormat("#"+format);

		return df.format(value);
	}

	/**
	 * 获取格式化数字，格式：#0.00
	 *
	 * @param value 需要格式化的数字
	 * @param format 格式
	 * @return 结果
	 */
	public static String getFormatNumber(long value, String format)
	{
		DecimalFormat df = new DecimalFormat("#"+format);

		return df.format(value);
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

	/**
	 * 通过键值对来格式化字符串，会替换原字符串中的${key}的值为value
	 * @param str 字符串
	 * @param valuesMap 键值对
	 * @return 替换后的字符串
	 */
	public static String formatString(String str, Map valuesMap)
	{
		return formatString(str, valuesMap,"${","}",StrSubstitutor.DEFAULT_ESCAPE);
	}

	/**
	 * 通过键值对来格式化字符串，会替换原字符串中的${key}的值为value
	 * @param str 字符串
	 * @param valuesMap 键值对
	 * @param prefix 自定义的前缀
	 * @param suffix 自定义的后缀
	 * @param escape 标识符
	 * @return 替换后的字符串
	 */
	public static String formatString(String str, Map valuesMap,String prefix, String suffix, char escape)
	{
		String result = str;

		if(valuesMap != null && !valuesMap.isEmpty())
		{
			if(StringUtils.isNotBlank(str))
			{
				StrSubstitutor sub = new StrSubstitutor(valuesMap,prefix,suffix,escape);

				result = sub.replace(str);
			}
		}

		return result;
	}
}
