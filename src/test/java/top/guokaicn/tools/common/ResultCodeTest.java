package top.guokaicn.tools.common;

import org.junit.Test;
import top.guokaicn.tools.utils.JSONUtils;

import static org.junit.Assert.*;

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
	public void addData()
	{
		ResultCode result = ResultCode.ok("测试成功");

		result.addData("test","测试1").addData("test2","测试2");

		System.out.println(JSONUtils.objectToString(result));
	}

}