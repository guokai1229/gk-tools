package top.guokaicn.tools.lang.rest;

import org.junit.Test;
import top.guokaicn.tools.utils.JSONUtils;

/**
 * @author guokai
 * @date 2021/11/6 9:35
 */
public class RestResultUtilsTest
{
    @Test
    public void ok()
    {
        RestResult<?> result = RestResult.ok();

        System.out.println(JSONUtils.objectToString(result));
    }

    @Test
    public void testOk()
    {
        RestResult<?> result = RestResult.ok("测试成功");

        System.out.println(JSONUtils.objectToString(result));
    }

    @Test
    public void testOk1()
    {
        RestResult<?> result = RestResult.ok(200, "测试成功");

        System.out.println(JSONUtils.objectToString(result));
    }

    @Test
    public void error()
    {
        RestResult<?> result = RestResult.error();

        System.out.println(JSONUtils.objectToString(result));
    }



    @Test
    public void testError()
    {
        RestResult<?> result = RestResult.error("测试错误");

        System.out.println(JSONUtils.objectToString(result));
    }

    @Test
    public void testError1()
    {
        RestResult<?> result = RestResult.error(500, "测试错误");

        System.out.println(JSONUtils.objectToString(result));
    }

    @Test
    public void testError2()
    {
        Exception e = new Exception("this is a ex");

        RestResult<?> result = RestResult.error(e);

        System.out.println(JSONUtils.objectToString(result));
    }

    @Test
    public void testGetData()
    {
        RestResult<String> result = RestResultUtils.ok("123123");

        String test = RestResultUtils.getData(result);

        System.out.println(test);
    }
}