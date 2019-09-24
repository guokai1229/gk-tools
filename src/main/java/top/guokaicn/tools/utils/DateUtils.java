package top.guokaicn.tools.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * DateKit.日期的工具类，关于日期的一些工具处理方法(建议使用DateTime来处理，更加全面)
 * 在一些特殊的场景中，无法使用jota-time,则使用本工具类进行一些简单的日期处理
 *
 * @author gk
 */
public class DateUtils
{
	/**
	 * 默认的日期格式
	 */
	public static String dateFormat = "yyyy-MM-dd";
	/**
	 * 默认的时间格式
	 */
	public static String timeFormat = "yyyy-MM-dd HH:mm:ss";
	/**
	 * 每天小时数
	 */
	public static final long HOURS_PER_DAY = 24;
	/**
	 * 每小时分钟数
	 */
	public static final long MINUTES_PER_HOUR = 60;
	/**
	 * 每分钟秒数
	 */
	public static final long SECONDS_PER_MINUTE = 60;
	/**
	 * 每秒的毫秒数
	 */
	public static final long MILLIONSECONDS_PER_SECOND = 1000;
	/**
	 * 每分钟毫秒数
	 */
	public static final long MILLIONSECONDS_PER_MINUTE = MILLIONSECONDS_PER_SECOND * SECONDS_PER_MINUTE;
	/**
	 * 每天毫秒数
	 */
	public static final long MILLIONSECONDS_SECOND_PER_DAY = HOURS_PER_DAY * MINUTES_PER_HOUR * SECONDS_PER_MINUTE * MILLIONSECONDS_PER_SECOND;

	/**
	 * 把字符串通过提供的日期格式转换为date对象
	 *
	 * @param dateStr
	 * @param format
	 * @return
	 */
	public static Date toDate(String dateStr, String format)
	{
		SimpleDateFormat d1 = new SimpleDateFormat(format);
		try
		{
			return d1.parse(dateStr);
		}
		catch (ParseException e)
		{
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 把date对象通过提供的日期格式转换为字符串
	 *
	 * @param date
	 * @param format
	 * @return
	 */
	public static String toStr(Date date, String format)
	{
		SimpleDateFormat d1 = new SimpleDateFormat(format);
		return d1.format(date);
	}

	/**
	 * 把字符串从一种日期格式，解析为另一种日期格式的字符串
	 *
	 * @param dateStr
	 * @param format
	 * @param showFormat
	 * @return
	 */
	public static String parseDate(String dateStr, String format, String showFormat)
	{
		Date date = toDate(dateStr, format);

		return toStr(date, showFormat);
	}
	
	/**
	 * 获得当前的年份
	 *
	 * @return
	 */
	public static int getYear(Date date)
	{
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		int year = calendar.get(Calendar.YEAR);
		return year;
	}
	
	/**
	 * 获得提供的时间的月份
	 *
	 * @param date
	 * @return
	 */
	public static int getMonth(Date date)
	{
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		int month = calendar.get(Calendar.MONTH) + 1;
		return month;
	}
	
	/**
	 * 获得提供的时间的星期
	 *
	 * @param date
	 * @return
	 */
	public static int getWeekOfMonth(Date date)
	{
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		int week = calendar.get(Calendar.WEEK_OF_MONTH);
		return week;
	}
	
	/**
	 * 获得提供的时间的天数
	 *
	 * @param date
	 * @return
	 */
	public static int getDayOfMonth(Date date)
	{
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		int day = calendar.get(Calendar.DAY_OF_MONTH);
		return day;
	}
	
	/**
	 * 获得当前的小时
	 *
	 * @param date
	 * @return
	 */
	public static int getHour(Date date)
	{
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		int hour = calendar.get(Calendar.HOUR_OF_DAY);
		return hour;
	}

	/**
	 * 获得当前的分钟数
	 *
	 * @return
	 */
	public static int getMinute(Date date)
	{
		Calendar calendar = Calendar.getInstance();
		int minute = calendar.get(Calendar.MINUTE);
		return minute;
	}

	/**
	 * 年的计算
	 * 
	 * @param date
	 * @param amount
	 * @return
	 */
	public static Date addYears(final Date date, final int amount)
	{
		return add(date, Calendar.YEAR, amount);
	}

	/**
	 * 月的计算
	 * @param date
	 * @param amount
	 * @return
	 */
	public static Date addMonths(final Date date, final int amount)
	{
		return add(date, Calendar.MONTH, amount);
	}
	
	/**
	 * 星期的计算
	 * @param date
	 * @param amount
	 * @return
	 */
	public static Date addWeeks(final Date date, final int amount) 
	{
        return add(date, Calendar.WEEK_OF_YEAR, amount);
    }

	/**
	 * 天的计算
	 * @param date
	 * @param amount
	 * @return
	 */
	public static Date addDays(final Date date, final int amount) 
	{
        return add(date, Calendar.DAY_OF_MONTH, amount);
    }
	
	/**
	 * 小时的计算
	 * @param date
	 * @param amount
	 * @return
	 */
	public static Date addHours(final Date date, final int amount) 
	{
        return add(date, Calendar.HOUR_OF_DAY, amount);
    }

	/**
	 * 分钟的计算
	 * @param date
	 * @param amount
	 * @return
	 */
	public static Date addMinutes(final Date date, final int amount) 
	{
        return add(date, Calendar.MINUTE, amount);
    }
	
	/**
	 * 秒的计算
	 * @param date
	 * @param amount
	 * @return
	 */
	public static Date addSeconds(final Date date, final int amount) 
	{
        return add(date, Calendar.SECOND, amount);
    }
	
	/**
	 * 毫秒的计算
	 * @param date
	 * @param amount
	 * @return
	 */
	public static Date addMilliseconds(final Date date, final int amount) 
	{
        return add(date, Calendar.MILLISECOND, amount);
    }

	/**
	 * 计算日期
	 * 
	 * @param date
	 * @param calendarField
	 * @param amount
	 * @return
	 */
	private static Date add(final Date date, final int calendarField, final int amount)
	{
		if (date == null)
		{
			throw new IllegalArgumentException("The date must not be null");
		}
		final Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(calendarField, amount);
		return c.getTime();
	}

	/**
	 * 获得两个日期之间相差的分钟数。（date1 - date2）
	 *
	 * @param date1
	 * @param date2
	 * @return 返回两个日期之间相差的分钟数值
	 */
	public static int intervalMinutes(Date date1, Date date2)
	{
		long intervalMillSecond = date1.getTime() - date2.getTime();
		// 相差的分钟数 = 相差的毫秒数 / 每分钟的毫秒数 (小数位采用进位制处理，即大于0则加1)
		return (int) (intervalMillSecond / MILLIONSECONDS_PER_MINUTE + (intervalMillSecond % MILLIONSECONDS_PER_MINUTE > 0 ? 1 : 0));
	}

	/**
	 * 获得两个日期之间相差的秒数差（date1 - date2）
	 *
	 * @param date1
	 * @param date2
	 * @return
	 */
	public static int intervalSeconds(Date date1, Date date2)
	{
		long intervalMillSecond = date1.getTime() - date2.getTime();
		return (int) (intervalMillSecond / MILLIONSECONDS_PER_SECOND + (intervalMillSecond % MILLIONSECONDS_PER_SECOND > 0 ? 1 : 0));
	}

	/**
	 * 判断两个日期是否同一天
	 * 
	 * @param date1
	 * @param date2
	 * @return
	 */
	public static boolean isSameDay(final Date date1, final Date date2)
	{
		if (date1 == null || date2 == null)
		{
			throw new IllegalArgumentException("The date must not be null");
		}
		final Calendar cal1 = Calendar.getInstance();
		cal1.setTime(date1);
		final Calendar cal2 = Calendar.getInstance();
		cal2.setTime(date2);
		return isSameDay(cal1, cal2);
	}

	/**
	 * 判断两个日期是否同一天
	 * 
	 * @param cal1
	 * @param cal2
	 * @return
	 */
	public static boolean isSameDay(final Calendar cal1, final Calendar cal2)
	{
		if (cal1 == null || cal2 == null)
		{
			throw new IllegalArgumentException("The date must not be null");
		}
		return (cal1.get(Calendar.ERA) == cal2.get(Calendar.ERA) && cal1.get(Calendar.YEAR) == cal2.get(Calendar.YEAR) && cal1.get(Calendar.DAY_OF_YEAR) == cal2.get(Calendar.DAY_OF_YEAR));
	}

	/**
	 * 判断是否同一时刻
	 * 
	 * @param date1
	 * @param date2
	 * @return
	 */
	public static boolean isSameInstant(final Date date1, final Date date2)
	{
		if (date1 == null || date2 == null)
		{
			throw new IllegalArgumentException("The date must not be null");
		}
		return date1.getTime() == date2.getTime();
	}

	/**
	 * 判断是否同一时刻
	 * 
	 * @param cal1
	 * @param cal2
	 * @return
	 */
	public static boolean isSameInstant(final Calendar cal1, final Calendar cal2)
	{
		if (cal1 == null || cal2 == null)
		{
			throw new IllegalArgumentException("The date must not be null");
		}
		return cal1.getTime().getTime() == cal2.getTime().getTime();
	}
}
