package top.guokaicn.tools.utils;

import org.junit.Test;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class AssertUtilsTest
{

    @Test
    public void isTrue()
    {
        try
        {
            AssertUtils.isTrue(true, "true");

//            AssertUtils.isTrue(false, "false");

            Map<String,Object> test = new HashMap<>();

            test.put("1",true);
            test.put("2",false);

            AssertUtils.isTrue(test.get("1"),"true");

            AssertUtils.isTrue(test.get("2"),"false");
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void isFalse()
    {
        try
        {
//            AssertUtils.isFalse(true, "true");

            AssertUtils.isFalse(false, "false");

            Map<String,Object> test = new HashMap<>();

            test.put("1",true);
            test.put("2",false);

            AssertUtils.isFalse(test.get("2"),"false");

            AssertUtils.isFalse(test.get("1"),"true");
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void isNull()
    {
        try
        {
            AssertUtils.isNull(new Object(), "notNull");

            AssertUtils.isNull(null, "null");
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void notNull()
    {
        try
        {
            AssertUtils.notNull(new Object(), "notNull");

            AssertUtils.notNull(null, "null");
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void isInstanceOf()
    {
        try
        {
            AssertUtils ass = new AssertUtils();

            AssertUtils.isInstanceOf(AssertUtils.class, ass, "is");

            AssertUtils.isInstanceOf(AssertUtils.class, new Object(), "not");
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void isIpAddress()
    {
        try
        {
            AssertUtils.isIpAddress("10.10.10.33","ip地址格式错误");
//            AssertUtils.isIpAddress("10.10.10.334");
//            AssertUtils.isIpAddress("test");
            AssertUtils.isIpAddress(1233,"ip地址格式错误");
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void isDate()
    {
        try
        {
            AssertUtils.isDate(new Date(), "时间格式错误");
            AssertUtils.isDate(1233,"时间格式错误");
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void isString()
    {
        try
        {
            AssertUtils.isString("123123", "字符串格式错误");
            AssertUtils.isString(1233,"字符串格式错误");
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void notBlank()
    {
        try
        {
            AssertUtils.notBlank("123123","字符串格式错误");
            AssertUtils.notBlank(null, "字符串格式错误");
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void notEquals()
    {
        try
        {
            AssertUtils.notEquals("123123","33333","字符串格式错误");
            AssertUtils.notEquals("123123","123123", "字符串格式错误");
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void testEquals()
    {
        try
        {
            AssertUtils.equals("123123","123123", "字符串格式错误");
            AssertUtils.equals("123123","33333","字符串格式错误");
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
}