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
	public void badRequestError()
	{
		ResultCode result = ResultCode.badRequestError();

		System.out.println(JSONUtils.objectToString(result));
	}

	@Test
	public void testBadRequestError()
	{
		ResultCode result = ResultCode.badRequestError("23232");

		System.out.println(JSONUtils.objectToString(result));
	}

	@Test
	public void unauthorizedError()
	{
		ResultCode result = ResultCode.unauthorizedError();

		System.out.println(JSONUtils.objectToString(result));
	}

	@Test
	public void testUnauthorizedError()
	{
		ResultCode result = ResultCode.unauthorizedError("23232");

		System.out.println(JSONUtils.objectToString(result));
	}

	@Test
	public void forbiddenError()
	{
		ResultCode result = ResultCode.forbiddenError();

		System.out.println(JSONUtils.objectToString(result));
	}

	@Test
	public void testForbiddenError()
	{
		ResultCode result = ResultCode.forbiddenError("23232");

		System.out.println(JSONUtils.objectToString(result));
	}

	@Test
	public void notFoundError()
	{
		ResultCode result = ResultCode.notFoundError();

		System.out.println(JSONUtils.objectToString(result));
	}

	@Test
	public void testNotFoundError()
	{
		ResultCode result = ResultCode.notFoundError("23232");

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

		result.removeData("test").removeData("test2");

		System.out.println(JSONUtils.objectToString(result));
	}

	@Test
	public void cleanData()
	{
		ResultCode result = ResultCode.ok("测试成功");

		result.addData("test","测试1").addData("test2","测试2");

		result = result.cleanData();

		System.out.println(JSONUtils.objectToString(result));
	}
}