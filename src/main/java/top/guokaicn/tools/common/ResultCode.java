package top.guokaicn.tools.common;

import java.util.HashMap;
import java.util.Map;

/**
 * 通用的返回结果对象
 */
public class ResultCode
{
	/**
	 * 成功编码
	 */
	private static final int SUCCESS_CODE = 200;
	/**
	 * 错误编码
	 */
	private static final int ERROR_CODE = 500;
	/**
	 * 错误请求错误
	 */
	private static final int BAD_REQUEST_CODE = 400;
	/**
	 * 需要认证错误
	 */
	private static final int UNAUTHORIZED_CODE = 401;
	/**
	 * 拒绝错误
	 */
	private static final int FORBIDDEN_CODE = 401;
	/**
	 * 未找到错误
	 */
	private static final int NOT_FOUND_CODE = 404;

	/**
	 * 是否成功标识
	 */
	private Boolean success;

	/**
	 * 结果编码
	 */
	private Integer code;

	/**
	 * 信息文本
	 */
	private String message;

	/**
	 * 时间戳
	 */
	private final long timestamp = System.currentTimeMillis();

	/**
	 * 携带数据
	 */
	private Map<String, Object> data;

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
		return ok(SUCCESS_CODE,"成功");
	}

	/**
	 * 自定义返回结果文本描述
	 * @param message 文本描述
	 * @return 对象
	 */
	public static ResultCode ok(String message)
	{
		return ok(SUCCESS_CODE,message);
	}

	/**
	 * 自定义返回结果文本描述
	 * @param code 编码
	 * @param message 文本描述
	 * @return 对象
	 */
	public static ResultCode ok(int code,String message)
	{
		ResultCode resultCode = new ResultCode();

		resultCode.success = true;

		resultCode.message = message;

		resultCode.code = code;

		return resultCode;
	}

	/**
	 * 获取错误的结果对象
	 * @return 对象
	 */
	public static ResultCode error()
	{
		return error(ERROR_CODE,"错误");
	}

	/**
	 * 自定义返回结果文本描述
	 * @param message 文本描述
	 * @return 对象
	 */
	public static ResultCode error(String message)
	{
		return error(ERROR_CODE,message);
	}

	/**
	 * 自定义返回结果文本描述
	 * @param code 错误编码
	 * @param message 文本描述
	 * @return 对象
	 */
	public static ResultCode error(int code,String message)
	{
		ResultCode resultCode = new ResultCode();

		resultCode.success = false;

		resultCode.message = message;

		resultCode.code = code;

		return resultCode;
	}

	/**
	 * 获取错误的结果对象
	 * @return 对象
	 */
	public static ResultCode badRequestError()
	{
		return error(BAD_REQUEST_CODE,"错误请求");
	}

	/**
	 * 自定义返回结果文本描述
	 * @param message 文本描述
	 * @return 对象
	 */
	public static ResultCode badRequestError(String message)
	{
		return error(BAD_REQUEST_CODE,message);
	}

	/**
	 * 获取错误的结果对象
	 * @return 对象
	 */
	public static ResultCode unauthorizedError()
	{
		return error(UNAUTHORIZED_CODE,"错误请求");
	}

	/**
	 * 自定义返回结果文本描述
	 * @param message 文本描述
	 * @return 对象
	 */
	public static ResultCode unauthorizedError(String message)
	{
		return error(UNAUTHORIZED_CODE,message);
	}

	/**
	 * 获取错误的结果对象
	 * @return 对象
	 */
	public static ResultCode forbiddenError()
	{
		return error(FORBIDDEN_CODE,"错误请求");
	}

	/**
	 * 自定义返回结果文本描述
	 * @param message 文本描述
	 * @return 对象
	 */
	public static ResultCode forbiddenError(String message)
	{
		return error(FORBIDDEN_CODE,message);
	}

	/**
	 * 获取错误的结果对象
	 * @return 对象
	 */
	public static ResultCode notFoundError()
	{
		return error(NOT_FOUND_CODE,"错误请求");
	}

	/**
	 * 自定义返回结果文本描述
	 * @param message 文本描述
	 * @return 对象
	 */
	public static ResultCode notFoundError(String message)
	{
		return error(NOT_FOUND_CODE,message);
	}

	/**
	 * 添加数据
	 * @param key key值
	 * @param value value值
	 * @return 使用链式编程，返回类本身
	 */
	public ResultCode addData(String key,Object value)
	{
		if(data == null)
		{
			data = new HashMap<>();
		}

		data.put(key,value);

		return this;
	}

	/**
	 * 移除数据
	 * @param key key值
	 * @return 使用链式编程，返回类本身
	 */
	public ResultCode removeData(String key)
	{
		if(data != null)
		{
			data.remove(key);
		}

		return this;
	}

	/**
	 * 清除所有数据
	 * @return 使用链式编程，返回类本身
	 */
	public ResultCode cleanData()
	{
		if(data != null)
		{
			data.clear();
			data = null;
		}

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

	public long getTimestamp()
	{
		return timestamp;
	}
}
