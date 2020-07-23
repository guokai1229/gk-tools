package top.guokaicn.tools.utils;

import java.util.Date;

/**
 * 简单的断言判定
 */
public class AssertUtils
{
    public static void isTrue(boolean expression, String message)
    {
        if (!expression)
        {
            throw new IllegalArgumentException(message);
        }
    }

    public static void isFalse(boolean expression, String message)
    {
        if (expression)
        {
            throw new IllegalArgumentException(message);
        }
    }

    public static void isNull(Object object, String message)
    {
        if (object != null)
        {
            throw new IllegalArgumentException(message);
        }
    }

    public static void notNull(Object object, String message)
    {
        if (object == null)
        {
            throw new IllegalArgumentException(message);
        }
    }

    public static void isDate(Object object, String message)
    {
        isInstanceOf(Date.class,object,message);
    }

    public static void isString(Object object,String message)
    {
        isInstanceOf(String.class,object,message);
    }

    public static void isInstanceOf(Class<?> type, Object obj, String message)
    {
        notNull(type, "Type to check against must not be null");

        if (!type.isInstance(obj))
        {
            throw new IllegalArgumentException(message);
        }
    }
}
