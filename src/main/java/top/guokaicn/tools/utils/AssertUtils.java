package top.guokaicn.tools.utils;

import org.apache.commons.lang.StringUtils;

import java.net.InetAddress;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 简单的断言判定
 */
public class AssertUtils
{
    /**
     * 判定是否为True
     *
     * @param expression 判定值
     * @param message    错误提示
     */
    public static void isTrue(boolean expression, String message)
    {
        if (!expression)
        {
            throw new IllegalArgumentException(message);
        }
    }

    /**
     * 判定是否为True
     *
     * @param expression 判定值
     * @param message    错误提示
     */
    public static void isTrue(Object expression, String message)
    {
        isInstanceOf(Boolean.class, expression, message);

        if (!(Boolean) expression)
        {
            throw new IllegalArgumentException(message);
        }
    }

    /**
     * 判定是否为Flase
     *
     * @param expression 判定值
     * @param message    错误提示
     */
    public static void isFalse(boolean expression, String message)
    {
        if (expression)
        {
            throw new IllegalArgumentException(message);
        }
    }

    /**
     * 判定是否为Flase
     *
     * @param expression 判定值
     * @param message    错误提示
     */
    public static void isFalse(Object expression, String message)
    {
        isInstanceOf(Boolean.class, expression, message);

        if ((Boolean) expression)
        {
            throw new IllegalArgumentException(message);
        }
    }

    /**
     * 判定是否为Null
     *
     * @param expression 判定值
     * @param message    错误提示
     */
    public static void isNull(Object expression, String message)
    {
        if (expression != null)
        {
            throw new IllegalArgumentException(message);
        }
    }

    /**
     * 判定是否非Null
     *
     * @param expression 判定值
     * @param message    错误提示
     */
    public static void notNull(Object expression, String message)
    {
        if (expression == null)
        {
            throw new IllegalArgumentException(message);
        }
    }

    /**
     * 判定是否为地址
     *
     * @param expression 判定值
     * @param message    错误提示
     */
    public static void isIpAddress(Object expression, String message)
    {
        isString(expression, message);

        try
        {
            InetAddress ip = InetAddress.getByName(String.valueOf(expression));

            if (ip == null)
            {
                throw new IllegalArgumentException(message);
            }
        }
        catch (Exception e)
        {
            throw new IllegalArgumentException(message);
        }
    }

    /**
     * 判定是否时间
     *
     * @param expression 判定值
     * @param message    错误提示
     */
    public static void isDate(Object expression, String message)
    {
        isInstanceOf(Date.class, expression, message);
    }

    /**
     * 判定是否字符串
     *
     * @param expression 判定值
     * @param message    错误提示
     */
    public static void isString(Object expression, String message)
    {
        isInstanceOf(String.class, expression, message);
    }

    /**
     * 判定是否对应对象
     *
     * @param type       类型
     * @param expression 判定值
     * @param message    错误提示
     */
    public static void isInstanceOf(Class<?> type, Object expression, String message)
    {
        notNull(type, "Type to check against must not be null");

        if (!type.isInstance(expression))
        {
            throw new IllegalArgumentException(message);
        }
    }

    /**
     * 断言字符串不为空
     *
     * @param str     字符串
     * @param message 错误信息
     */
    public static void notBlank(String str, String message)
    {
        if (StringUtils.isBlank(str))
        {
            throw new IllegalArgumentException(message);
        }
    }

    /**
     * 断言字符串为空
     * @param str 字符串
     * @param message 错误信息
     */
    public static void isBlank(String str,String message)
    {
        if (StringUtils.isNotBlank(str))
        {
            throw new IllegalArgumentException(message);
        }
    }

    /**
     * 断言字符串不相等
     *
     * @param a       a
     * @param b       b
     * @param message 错误信息
     */
    public static void notEquals(String a, String b, String message)
    {
        if (a != null && b != null)
        {
            if (a.equals(b))
            {
                throw new IllegalArgumentException(message);
            }
        }
        else
        {
            throw new IllegalArgumentException(message);
        }
    }

    /**
     * 断言字符串相等
     *
     * @param a       a
     * @param b       b
     * @param message 错误信息
     */
    public static void equals(String a, String b, String message)
    {
        if (a != null && b != null)
        {
            if (!a.equals(b))
            {
                throw new IllegalArgumentException(message);
            }
        }
        else if (a == null && b == null)
        {

        }
        else
        {
            throw new IllegalArgumentException(message);
        }
    }

    /**
     * 断言map不为空
     * @param map map
     * @param message 错误信息
     */
    public static void notEmpty(Map<?, ?> map, String message)
    {
        if((map == null || map.isEmpty()))
        {
            throw new IllegalArgumentException(message);
        }
    }

    /**
     * 断言collection不为空
     * @param collection collection
     * @param message 错误信息
     */
    public static void notEmpty(Collection<?> collection, String message)
    {
        if(collection == null || collection.isEmpty())
        {
            throw new IllegalArgumentException(message);
        }
    }

    /**
     * 是否电话号码
     * @param phone 电话
     * @param message 错误信息
     */
    public static void isPhone(String phone,String message)
    {
        if(testMatches(phone, "^1\\d{10}$"))
        {
            throw new IllegalArgumentException(message);
        }
    }

    /**
     * 是否邮件
     * @param email 邮件
     * @param message 错误信息
     */
    public static void isEmail(String email,String message)
    {
        if(testMatches(email, "^([a-zA-Z0-9_\\.\\-])+\\@(([a-zA-Z0-9\\-])+\\.)+([a-zA-Z0-9]{2,4})+$"))
        {
            throw new IllegalArgumentException(message);
        }
    }

    /**
     * 是否是网址
     * @param url 网址
     * @param message 错误信息
     */
    public static void isUrl(String url,String message)
    {
        if(testMatches(url, "(^#)|(^http(s*):\\/\\/[^\\s]+\\.[^\\s]+)"))
        {
            throw new IllegalArgumentException(message);
        }
    }

    /**
     * 是否日期格式的数据
     * @param date 日期
     * @param message 错误信息
     */
    public static void isDate(String date,String message)
    {
        if(!testMatches(date, "^(\\d{4})[-\\/](\\d{1}|0\\d{1}|1[0-2])([-\\/](\\d{1}|0\\d{1}|[1-2][0-9]|3[0-1]))*$"))
        {
            throw new IllegalArgumentException(message);
        }
    }

    /**
     * 是否身份证
     * @param identity 身份证
     * @param message 错误信息
     */
    public static void isIdentity(String identity,String message)
    {
        if(!testMatches(identity, "(^\\d{15}$)|(^\\d{17}(x|X|\\d)$)"))
        {
            throw new IllegalArgumentException(message);
        }
    }

    /**
     * 是否是身份证(强校验)
     */
    public static void isIdentityStrong(String identity,String message)
    {
        isIdentity(identity,message);

        String ai;
        if (identity.length() == 18)
        {
            ai = identity.substring(0, 17);
        }
        else
        {
            ai = identity.substring(0, 6) + "19" + identity.substring(6, 15);
        }
        // 验证出生年月
        String year = ai.substring(6, 10);  // 年
        String birthday = year + "-" + ai.substring(10, 12) + "-" + ai.substring(12, 14);

        isDate(birthday,message);

        try
        {
            long time = new SimpleDateFormat("yyyy-MM-dd").parse(birthday).getTime();

            GregorianCalendar gc = new GregorianCalendar();

            if ((gc.get(Calendar.YEAR) - Integer.parseInt(year)) > 150 || (gc.getTime().getTime() - time) < 0)
            {
                throw new IllegalArgumentException(message);
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
            throw new IllegalArgumentException(message);
        }
        // 验证地区码
        String[] areaCodes = new String[]{"11", "12", "13", "14", "15", "21", "22", "23",
                "31", "32", "33", "34", "35", "36", "37", "41", "42", "43", "44", "45", "46",
                "50", "51", "52", "53", "54", "61", "62", "63", "64", "65", "71", "81", "82", "91"};
        if (!Arrays.asList(areaCodes).contains(ai.substring(0, 2)))
        {
            throw new IllegalArgumentException(message);
        }
        // 验证最后一位
        if (identity.length() == 18)
        {
            String[] valCode = {"1", "0", "X", "9", "8", "7", "6", "5", "4", "3", "2"};
            String[] wi = {"7", "9", "10", "5", "8", "4", "2", "1", "6", "3", "7", "9", "10", "5", "8", "4", "2"};
            int totalMulAiWi = 0;
            for (int i = 0; i < 17; i++)
            {
                totalMulAiWi += Integer.parseInt(String.valueOf(ai.charAt(i))) * Integer.parseInt(wi[i]);
            }
            ai += valCode[totalMulAiWi % 11];
            if (!ai.equals(identity))
            {
                throw new IllegalArgumentException(message);
            }
        }
    }

    /**
     * 字符串是否匹配正则表达式
     */
    private static boolean testMatches(String str, String reg)
    {
        return !StringUtils.isNotBlank(str) || !str.matches(reg);
    }
}
