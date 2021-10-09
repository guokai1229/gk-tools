package top.guokaicn.tools.common;

import org.junit.Test;
import top.guokaicn.tools.lang.rest.RestResult;
import top.guokaicn.tools.utils.JSONUtils;

public class ResultCodeTest
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

}