package top.guokaicn.tools.utils;

import java.net.InetAddress;
import java.util.Date;

/**
 * 简单的断言判定
 */
public class AssertUtils
{
    /**
     * 判定是否为True
     * @param expression 判定值
     * @param message 错误提示
     */
    public static void isTrue(boolean expression, String message)
    {
        if (!expression)
        {
            throw new IllegalArgumentException(message);
        }
    }
    /**
     * 判定是否为Flase
     * @param expression 判定值
     * @param message 错误提示
     */
    public static void isFalse(boolean expression, String message)
    {
        if (expression)
        {
            throw new IllegalArgumentException(message);
        }
    }

    /**
     * 判定是否为Null
     * @param expression 判定值
     * @param message 错误提示
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
     * @param expression 判定值
     * @param message 错误提示
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
     * @param expression 判定值
     * @param message 错误提示
     */
    public static void isIpAddress(Object expression,String message)
    {
        isString(expression,message);

        try
        {
            InetAddress ip = InetAddress.getByName(String.valueOf(expression));

            if(ip == null)
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
     * @param expression 判定值
     * @param message 错误提示
     */
    public static void isDate(Object expression, String message)
    {
        isInstanceOf(Date.class,expression,message);
    }

    /**
     * 判定是否字符串
     * @param expression 判定值
     * @param message 错误提示
     */
    public static void isString(Object expression,String message)
    {
        isInstanceOf(String.class,expression,message);
    }

    /**
     * 判定是否对应对象
     * @param type 类型
     * @param expression 判定值
     * @param message 错误提示
     */
    public static void isInstanceOf(Class<?> type, Object expression, String message)
    {
        notNull(type, "Type to check against must not be null");

        if (!type.isInstance(expression))
        {
            throw new IllegalArgumentException(message);
        }
    }
}
