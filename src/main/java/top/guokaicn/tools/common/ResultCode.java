package top.guokaicn.tools.common;

import java.util.HashMap;
import java.util.Map;

/**
 * 通用的返回结果对象
 */
public class ResultCode
{
	/**
	 * 编码枚举对象
	 */
	private enum CODE
	{
		SUCCESS_CODE(200, "成功"),
		ERROR_CODE(500, "错误"),
		BAD_REQUEST_CODE(200, "错误请求"),
		UNAUTHORIZED_CODE(401, "需要认证错误"),
		FORBIDDEN_CODE(401, "拒绝错误"),
		NOT_FOUND_CODE(404, "未找到错误");

		private final int code;
		private final String description;

		CODE(int code, String message)
		{
			this.code = code;
			this.description = message;
		}

		public int getCode()
		{
			return code;
		}

		public String getDescription()
		{
			return description;
		}
	}

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
		return ok(CODE.SUCCESS_CODE.getCode(),CODE.SUCCESS_CODE.getDescription());
	}

	/**
	 * 自定义返回结果文本描述
	 * @param message 文本描述
	 * @return 对象
	 */
	public static ResultCode ok(String message)
	{
		return ok(CODE.SUCCESS_CODE.getCode(),message);
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
		return error(CODE.ERROR_CODE.getCode(),CODE.ERROR_CODE.getDescription());
	}

	/**
	 * 自定义返回结果文本描述
	 * @param message 文本描述
	 * @return 对象
	 */
	public static ResultCode error(String message)
	{
		return error(CODE.ERROR_CODE.getCode(),message);
	}

	/**
	 * 根据Exception来返回结果对象
	 * @param e 错误对象
	 * @return 对象
	 */
	public static ResultCode error(Exception e)
	{
		return error(CODE.ERROR_CODE.getCode(),e.getMessage());
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
		return error(CODE.BAD_REQUEST_CODE.getCode(),CODE.BAD_REQUEST_CODE.getDescription());
	}

	/**
	 * 自定义返回结果文本描述
	 * @param message 文本描述
	 * @return 对象
	 */
	public static ResultCode badRequestError(String message)
	{
		return error(CODE.BAD_REQUEST_CODE.getCode(),message);
	}

	/**
	 * 获取错误的结果对象
	 * @return 对象
	 */
	public static ResultCode unauthorizedError()
	{
		return error(CODE.UNAUTHORIZED_CODE.getCode(),CODE.UNAUTHORIZED_CODE.getDescription());
	}

	/**
	 * 自定义返回结果文本描述
	 * @param message 文本描述
	 * @return 对象
	 */
	public static ResultCode unauthorizedError(String message)
	{
		return error(CODE.UNAUTHORIZED_CODE.getCode(),message);
	}

	/**
	 * 获取错误的结果对象
	 * @return 对象
	 */
	public static ResultCode forbiddenError()
	{
		return error(CODE.FORBIDDEN_CODE.getCode(),CODE.FORBIDDEN_CODE.getDescription());
	}

	/**
	 * 自定义返回结果文本描述
	 * @param message 文本描述
	 * @return 对象
	 */
	public static ResultCode forbiddenError(String message)
	{
		return error(CODE.FORBIDDEN_CODE.getCode(),message);
	}

	/**
	 * 获取错误的结果对象
	 * @return 对象
	 */
	public static ResultCode notFoundError()
	{
		return error(CODE.NOT_FOUND_CODE.getCode(),CODE.NOT_FOUND_CODE.getDescription());
	}

	/**
	 * 自定义返回结果文本描述
	 * @param message 文本描述
	 * @return 对象
	 */
	public static ResultCode notFoundError(String message)
	{
		return error(CODE.NOT_FOUND_CODE.getCode(),message);
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
