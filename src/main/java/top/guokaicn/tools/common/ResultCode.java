package top.guokaicn.tools.common;

import java.util.HashMap;
import java.util.Map;

/**
 * 通用的返回结果对象
 */
public class ResultCode
{
	private static final int SUCCESS_CODE = 20001;

	private static final int ERROR_CODE = 50001;

	private Boolean success;

	private Integer code;

	private String message;

	private Map<String, Object> data = new HashMap<>();

	/**
	 * 构造器私有
	 */
	private ResultCode()
	{

	}

	/**
	 * 获取正确的结果对象
	 * @return 对象
	 */
	public static ResultCode ok()
	{
		ResultCode resultCode = new ResultCode();

		resultCode.success = true;

		resultCode.message = "成功";

		resultCode.code = SUCCESS_CODE;

		return resultCode;
	}

	/**
	 * 自定义返回结果文本描述
	 * @param message 文本描述
	 * @return 对象
	 */
	public static ResultCode ok(String message)
	{
		ResultCode resultCode = new ResultCode();

		resultCode.success = true;

		resultCode.message = message;

		resultCode.code = SUCCESS_CODE;

		return resultCode;
	}

	/**
	 * 获取错误的结果对象
	 * @return 对象
	 */
	public static ResultCode error()
	{
		ResultCode resultCode = new ResultCode();

		resultCode.success = true;

		resultCode.message = "错误";

		resultCode.code = ERROR_CODE;

		return resultCode;
	}

	/**
	 * 自定义返回结果文本描述
	 * @param message 文本描述
	 * @return 对象
	 */
	public static ResultCode error(String message)
	{
		ResultCode resultCode = new ResultCode();

		resultCode.success = true;

		resultCode.message = message;

		resultCode.code = ERROR_CODE;

		return resultCode;
	}

	/**
	 * 添加数据
	 * @param key key值
	 * @param value value值
	 * @return 使用链式编程，返回类本身
	 */
	public ResultCode addData(String key,Object value)
	{
		data.put(key,value);

		return this;
	}

	public void setSuccess(Boolean success)
	{
		this.success = success;
	}

	public void setCode(Integer code)
	{
		this.code = code;
	}

	public void setMessage(String message)
	{
		this.message = message;
	}

	public void setData(Map<String, Object> data)
	{
		this.data = data;
	}

	public Boolean getSuccess()
	{
		return success;
	}

	public Integer getCode()
	{
		return code;
	}

	public String getMessage()
	{
		return message;
	}

	public Map<String, Object> getData()
	{
		return data;
	}
}
