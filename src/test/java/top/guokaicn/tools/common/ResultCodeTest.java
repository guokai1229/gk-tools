package top.guokaicn.tools.common;

import org.junit.Test;
import top.guokaicn.tools.utils.JSONUtils;

public class ResultCodeTest
{

	@Test
	public void ok()
	{
		ResultCode result = ResultCode.ok();

		System.out.println(JSONUtils.objectToString(result));
	}

	@Test
	public void testOk()
	{
		ResultCode result = ResultCode.ok("测试成功");

		System.out.println(JSONUtils.objectToString(result));
	}

	@Test
	public void testOk1()
	{
		ResultCode result = ResultCode.ok(200,"测试成功");

		System.out.println(JSONUtils.objectToString(result));
	}

	@Test
	public void error()
	{
		ResultCode result = ResultCode.error();

		System.out.println(JSONUtils.objectToString(result));
	}

	@Test
	public void testError()
	{
		ResultCode result = ResultCode.error("测试错误");

		System.out.println(JSONUtils.objectToString(result));
	}

	@Test
	public void testError1()
	{
		ResultCode result = ResultCode.error(500,"测试错误");

		System.out.println(JSONUtils.objectToString(result));
	}

	@Test
	public void addData()
	{
		ResultCode result = ResultCode.ok("测试成功");

		result.addData("test","测试1").addData("test2","测试2");

		System.out.println(JSONUtils.objectToString(result));
	}

	@Test
	public void removeData()
	{
		ResultCode result = ResultCode.ok("测试成功");

		result.addData("test","测试1").addData("test2","测试2");

		result.removeData("test");

		System.out.println(JSONUtils.objectToString(result));
	}

	@Test
	public void cleanData()
	{
		ResultCode result = ResultCode.ok("测试成功");

		result.addData("test","测试1").addData("test2","测试2");

		result.cleanData();

		System.out.println(JSONUtils.objectToString(result));
	}
}