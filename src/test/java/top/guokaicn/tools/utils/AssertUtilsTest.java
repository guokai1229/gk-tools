package top.guokaicn.tools.utils;

import org.junit.Test;

public class AssertUtilsTest
{

    @Test
    public void isTrue()
    {
        try
        {
            AssertUtils.isTrue(true, "true");

            AssertUtils.isTrue(false, "false");
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
            AssertUtils.isFalse(true, "true");

            AssertUtils.isFalse(false, "false");
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
}