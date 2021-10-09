package top.guokaicn.tools.lang.rest;


/**
 * 通用的返回结果对象
 */
public class RestResult<T>
{
	/**
	 * 编码枚举对象
	 */
	private enum CODE
	{
		SUCCESS_CODE(200, "成功"),
		ERROR_CODE(500, "错误");

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
	private T data;

	/**
	 * 构造器私有
	 */
	private RestResult()
	{

	}

	/**
	 * 获取正确的结果对象
	 * @return 对象
	 */
	public static <T> RestResult<T> ok()
	{
		return ok(CODE.SUCCESS_CODE.getCode(), CODE.SUCCESS_CODE.getDescription());
	}

	/**
	 * 获取正确的结果对象
	 * @param data 数据
	 * @param <T> 类型
	 * @return 结果
	 */
	public static <T> RestResult<T> ok(T data)
	{
		return ok(CODE.SUCCESS_CODE.getCode(), CODE.SUCCESS_CODE.getDescription(), data);
	}

	/**
	 * 自定义返回结果文本描述
	 * @param message 文本描述
	 * @return 对象
	 */
	public static <T> RestResult<T> ok(String message)
	{
		return ok(CODE.SUCCESS_CODE.getCode(), message);
	}

	/**
	 * 获取正确的结果对象
	 * @param message 文本
	 * @param data 数据
	 * @param <T> 类型
	 * @return 结果
	 */
	public static <T> RestResult<T> ok(String message,T data)
	{
		return ok(CODE.SUCCESS_CODE.getCode(), message, data);
	}

	/**
	 * 自定义返回结果文本描述
	 * @param code 编码
	 * @param message 文本描述
	 * @return 对象
	 */
	public static <T> RestResult<T> ok(int code,String message)
	{
		return ok(code, message,null);
	}

	/**
	 * 返回成功结果
	 * @param code 编码
	 * @param message 文本描述
	 * @param data 数据
	 * @return 对象
	 */
	public static <T> RestResult<T> ok(int code,String message,T data)
	{
		RestResult<T> RestResult = new RestResult<>();

		RestResult.success = true;

		RestResult.message = message;

		RestResult.code = code;

		RestResult.setData(data);

		return RestResult;
	}

	/**
	 * 获取错误的结果对象
	 * @return 对象
	 */
	public static <T> RestResult<T> error()
	{
		return error(CODE.ERROR_CODE.getCode(), CODE.ERROR_CODE.getDescription());
	}

	/**
	 * 获取错误的结果对象
	 * @param data 数据
	 * @param <T> 类型
	 * @return 结果
	 */
	public static <T> RestResult<T> error(T data)
	{
		return error(CODE.ERROR_CODE.getCode(), CODE.ERROR_CODE.getDescription(), data);
	}

	/**
	 * 自定义返回结果文本描述
	 * @param message 文本描述
	 * @return 对象
	 */
	public static <T> RestResult<T> error(String message)
	{
		return error(CODE.ERROR_CODE.getCode(), message);
	}

	/**
	 * 自定义返回结果文本描述
	 * @param message 文本描述
	 * @param data 数据
	 * @param <T> 类型
	 * @return 结果
	 */
	public static <T> RestResult<T> error(String message,T data)
	{
		return error(CODE.ERROR_CODE.getCode(), message, data);
	}

	/**
	 * 根据Exception来返回结果对象
	 * @param e 错误对象
	 * @return 对象
	 */
	public static <T> RestResult<T> error(Exception e)
	{
		return error(CODE.ERROR_CODE.getCode(), e.getMessage());
	}

	/**
	 * 自定义返回结果文本描述
	 * @param code 错误编码
	 * @param message 文本描述
	 * @return 对象
	 */
	public static <T> RestResult<T> error(int code,String message)
	{
		return error(code, message,null);
	}

	/**
	 * 自定义返回结果文本描述
	 * @param code 编码
	 * @param message 文本描述
	 * @param data 数据
	 * @param <T> 类型
	 * @return 结果
	 */
	public static <T> RestResult<T> error(int code,String message,T data)
	{
		RestResult<T> RestResult = new RestResult<>();

		RestResult.success = false;

		RestResult.message = message;

		RestResult.code = code;

		RestResult.setData(data);

		return RestResult;
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

	public long getTimestamp()
	{
		return timestamp;
	}

	public T getData()
	{
		return data;
	}

	public void setData(T data)
	{
		this.data = data;
	}
}
