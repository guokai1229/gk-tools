package top.guokaicn.tools.utils;

import org.junit.Test;

import java.util.*;

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
    public void isBlank()
    {
        try
        {
            AssertUtils.isBlank(null, "字符串格式错误");
            AssertUtils.isBlank("123123","字符串格式错误");
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


    @Test
    public void notEmpty()
    {
        try
        {
            Map<String,String> test = new HashMap<>();

            test.put("11","22");
            test.put("22","22");

            AssertUtils.notEmpty(test,"数据为空");

            test = null;

            AssertUtils.notEmpty(test,"数据为空");
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void testNotEmpty()
    {
        try
        {
            List<String> test = new ArrayList<>();

            test.add("11");
            test.add("22");

            AssertUtils.notEmpty(test,"数据为空");

            test = null;

            AssertUtils.notEmpty(test,"数据为空");
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }


    @Test
    public void isPhone()
    {
        try
        {
            AssertUtils.isPhone("13444444444","非电话号码");

            AssertUtils.isPhone("233333","非电话号码");
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void isEmail()
    {
        try
        {
            AssertUtils.isEmail("gggg@13.com","非邮件");

            AssertUtils.isEmail("233333","非邮件");
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void isUrl()
    {
        try
        {
            AssertUtils.isUrl("http://www.baidu.com","非url");

            AssertUtils.isUrl("233333","非url");
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void testIsDate()
    {
        try
        {
            AssertUtils.isDate("34234234","非日期");

            AssertUtils.isDate("2012-01-22 00:00:00","非日期");
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void isIdentity()
    {
    }

    @Test
    public void isIdentityStrong()
    {
    }
}